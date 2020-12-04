package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn0.EsBcnMciSignaturaWebServiceSchemasDetallErrorsType;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn0.EsBcnMciSignaturaWebServiceSchemasTicketType;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn0.ListenerMciSignaturaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9.DetallErrorsDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9.ResultatPeticioDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;
import net.opentrends.openframe.services.rest.http.ResponseEntity;

/**
 * The Class ServeisSignaturesRestController.
 */
@RestController
@RequestMapping(value = "/serveis/signatures", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Signatures API", tags = "Serveis Signatures API")
@CommonsLog
@EntornPropertySource(value = { "classpath:/app/config/gpaserveis.properties" })
public class ServeisSignaturesRestController extends BaseRestController {

	@Value("${cerca.signatures.oge.url}")
	private String cercaSignaturesOgeUrl;

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/**
	 * Listener mci signatura.
	 *
	 * @param listenerMciSignaturaDTO
	 *            the listener mci signatura DTO
	 * @param response
	 *            the response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@PostMapping(path = "/listenerMciSignatura", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	@ApiOperation(value = "Resultat de la signatura criptogràfica", tags = { "Serveis Signatures API" })
	public void listenerMciSignatura(
	        @ApiParam(value = "Resultat de la signatura criptogràfica a una petició de vist-i-plau/signatura", required = true) ListenerMciSignaturaDTO listenerMciSignaturaDTO,
	        HttpServletResponse response) throws GPAServeisServiceException, IOException {

		if (log.isInfoEnabled()) {
			log.info("listenerMciSignatura(ListenerMciSignaturaDTO,HttpServletResponse) - inici"); //$NON-NLS-1$
			log.info(listenerMciSignaturaDTO); // $NON-NLS-1$
		}

		EsBcnMciSignaturaWebServiceSchemasTicketType esBcnMciSignaturaWebServiceSchemasTicketType = serveisService
		        .parseMciSignaturesTicket(listenerMciSignaturaDTO.getTicket());

		// Sólo habrá que hacer efectiva la firma para aquellos documentos que
		// no devuelvan error
		SignarCriptograficaDocument signarCriptograficaDocument = new SignarCriptograficaDocument();
		ArrayList<BigDecimal> idDocumentsSignatsList = new ArrayList<BigDecimal>();
		DocsTramitacioRDTO docsTramitacioRDTO = null;
		EsBcnMciSignaturaWebServiceSchemasDetallErrorsType esBcnMciSignaturaWebServiceSchemasDetallErrorsType = null;
		StringBuffer queryParams = new StringBuffer();

		signarCriptograficaDocument.setIdPeticio(esBcnMciSignaturaWebServiceSchemasTicketType.getIdPeticio());
		queryParams.append("?idPeticio=");
		queryParams.append(esBcnMciSignaturaWebServiceSchemasTicketType.getIdPeticio());

		for (int i = 0; i < esBcnMciSignaturaWebServiceSchemasTicketType.getErrors().getEsBcnMciSignaturaWebServiceSchemasDetallErrors()
		        .size(); i++) {
			esBcnMciSignaturaWebServiceSchemasDetallErrorsType = esBcnMciSignaturaWebServiceSchemasTicketType.getErrors()
			        .getEsBcnMciSignaturaWebServiceSchemasDetallErrors().get(i);
			docsTramitacioRDTO = serveisService
			        .consultarDadesDocumentGeneratPerIdGestorDocumental(esBcnMciSignaturaWebServiceSchemasDetallErrorsType.getIdDocument());
			if (esBcnMciSignaturaWebServiceSchemasDetallErrorsType.getSignaturaResultat() != null) {
				// Si contiene el elemento <signaturaResultat> la firma se
				// realizó correctamente
				idDocumentsSignatsList.add(docsTramitacioRDTO.getId());
				queryParams.append("&result[");
				queryParams.append(i);
				queryParams.append("].idDocument=");
				queryParams.append(docsTramitacioRDTO.getId());
				queryParams.append("&result[");
				queryParams.append(i);
				queryParams.append("].codiError=0");
			} else if (esBcnMciSignaturaWebServiceSchemasDetallErrorsType.getDetallError() != null) {
				// Si contiene el elemento <detallError> se produjo algún tipo
				// de error
				queryParams.append("&result[");
				queryParams.append(i);
				queryParams.append("].idDocument=");
				queryParams.append(docsTramitacioRDTO.getId());
				queryParams.append("&result[");
				queryParams.append(i);
				queryParams.append("].codiError=");
				queryParams.append(esBcnMciSignaturaWebServiceSchemasDetallErrorsType.getDetallError().getCodiError());
			} else {
				// En cualquier otro caso se devuelve un error genérico
				queryParams.append("&result[");
				queryParams.append(i);
				queryParams.append("].idDocument=");
				queryParams.append(docsTramitacioRDTO.getId());
				queryParams.append("&result[");
				queryParams.append(i);
				queryParams.append("].codiError=-1");
			}
		}
		signarCriptograficaDocument.setIdDocuments(idDocumentsSignatsList);
		SignarCriptograficaDocumentResponse signarCriptograficaDocumentResponse = serveisService
		        .signarCriptograficaDocument(signarCriptograficaDocument);

		if (log.isInfoEnabled()) {
			log.info("listenerMciSignatura(ListenerMciSignaturaDTO,HttpServletResponse) - fi");
			// $NON-NLS-1$
		}

		response.sendRedirect(cercaSignaturesOgeUrl + queryParams.toString());
	}

	/**
	 * Resultat peticio.
	 *
	 * @param resultatPeticioDTO
	 *            the resultat peticio DTO
	 * @param response
	 *            the response
	 * @return the response entity
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping(path = "/resultatPeticio", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Resultat de la signatura criptogràfica", tags = { "Serveis Signatures API" })
	public ResponseEntity<Void> resultatPeticio(
	        @ApiParam(value = "Resultat de la signatura criptogràfica a una petició de vist-i-plau/signatura", required = true) @RequestBody ResultatPeticioDTO resultatPeticioDTO,
	        HttpServletResponse response) throws GPAServeisServiceException {

		if (log.isInfoEnabled()) {
			log.info("resultatPeticio(ResultatPeticioDTO) - inici"); //$NON-NLS-1$
			log.info(resultatPeticioDTO); // $NON-NLS-1$
		}

		// Sólo habrá que hacer efectiva la firma para aquellos documentos que
		// no devuelvan error
		SignarCriptograficaDocument signarCriptograficaDocument = new SignarCriptograficaDocument();
		ArrayList<BigDecimal> idDocumentsSignatsList = new ArrayList<BigDecimal>();
		DocsTramitacioRDTO docsTramitacioRDTO = null;
		DetallErrorsDTO detallErrorsDTO = null;

		String idPeticio = resultatPeticioDTO.getIdPeticio().toString();
		signarCriptograficaDocument.setIdPeticio(idPeticio);

		for (int i = 0; i < resultatPeticioDTO.getErrors().size(); i++) {
			detallErrorsDTO = resultatPeticioDTO.getErrors().get(i);
			if (detallErrorsDTO.getDetallError() == null && detallErrorsDTO.getIdDocument() != null) {
				// Si no contiene el elemento detallError y viene el id del
				// documento, la firma se realizó correctamente
				if (log.isInfoEnabled()) {
					log.info("resultatPeticio(ResultatPeticioDTO) - Document signat correctament: " + detallErrorsDTO.getIdDocument()); // $NON-NLS-1$
				}
				docsTramitacioRDTO = serveisService.consultarDadesDocumentGeneratPerIdGestorDocumental(detallErrorsDTO.getIdDocument());
				idDocumentsSignatsList.add(docsTramitacioRDTO.getId());
			}
		}
		signarCriptograficaDocument.setIdDocuments(idDocumentsSignatsList);
		SignarCriptograficaDocumentResponse signarCriptograficaDocumentResponse = serveisService
		        .signarCriptograficaDocument(signarCriptograficaDocument);

		if (log.isInfoEnabled()) {
			log.info("resultatPeticio(ResultatPeticioDTO) - fi"); // $NON-NLS-1$
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Resultat peticio error general.
	 *
	 * @param errorCodi
	 *            the error codi
	 * @param idPeticio
	 *            the id peticio
	 * @param response
	 *            the response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@GetMapping("/resultatPeticio")
	@ApiOperation(value = "Resultat d'error general de la signatura criptogràfica", tags = { "Serveis Signatures API" })
	public void resultatPeticioErrorGeneral(
	        @ApiParam(value = "Codi de l'error") @RequestParam(value = "ERROR_CODI", required = false) String errorCodi,
	        @ApiParam(value = "Identificador de la petició de signatura") @RequestParam(value = "ID", required = false) String idPeticio,
	        HttpServletResponse response) throws GPAServeisServiceException, IOException {

		if (log.isDebugEnabled()) {
			log.info("resultatPeticioErrorGeneral(String, String) - inici"); //$NON-NLS-1$
		}

		StringBuffer queryParams = new StringBuffer();
		queryParams.append("?ERROR_CODI=");
		queryParams.append(errorCodi);
		queryParams.append("&ID=");
		queryParams.append(idPeticio);

		if (log.isDebugEnabled()) {
			log.info("resultatPeticioErrorGeneral(String, String) - fi"); // $NON-NLS-1$
		}

		response.sendRedirect(cercaSignaturesOgeUrl + queryParams.toString());
	}

}