package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEstatDigitalitzacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatDigitalitzacioDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.handler.ServeisRestControllerExceptionHandler;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.EstatDigitalizaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.EstatDigitalizaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mds.notificacions.RespostaEvidenciaDigitalitzacioECompulsaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.estatDigitalitzacio.RespostaConsultaEstatDigitalitzacioRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.rest.http.ResponseEntity;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/mds", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis MDS API", tags = "Serveis MDS API")
@CommonsLog
public class ServeisModulDigitalitzacioRestController extends BaseRestController {

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/**
	 * Servei específic per rebre notificacions de les respostes del MDS a
	 * peticions d'escaneig. Aquestes respostes hauran de ser una petició POST
	 * enviada a la URL indicada a la petició d’escaneig original (camp
	 * notificationEndpoint). El document propiament dit no s'ha d’enviar però
	 * si l'identificador del document al gestor documental.
	 *
	 * @return void
	 */
	@PostMapping("/evidencia_digitalitzacio")
	@ApiOperation(value = "Notificacions de les respostes del MDS a peticions d'escaneig", tags = { "Serveis MDS API" })
	public ResponseEntity<Void> respostaNotificacioEscaneig(
	        @ApiParam(value = "Resposta del MDS a una peticion d'escaneig", required = true) @RequestBody RespostaEvidenciaDigitalitzacioECompulsaRDTO respostaEvidenciaDigitalitzacioECompulsaRDTO) {

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioECompulsaRDTO) - inici"); //$NON-NLS-1$
		}

		try {
			CallbackDigitalitzacio callbackDigitalitzacio = new CallbackDigitalitzacio();
			callbackDigitalitzacio.setIdDocScan(StringUtils.join(respostaEvidenciaDigitalitzacioECompulsaRDTO.getIdDocumentum(), ","));
			EstatDigitalizaApiParamValueTranslator estatDigitalizaApiParamValueTranslator = new EstatDigitalizaApiParamValueTranslator();
			callbackDigitalitzacio.setEstat(estatDigitalizaApiParamValueTranslator
			        .getInternalValueByApiParamValue(respostaEvidenciaDigitalitzacioECompulsaRDTO.getEstatECompulsa()));
			if (respostaEvidenciaDigitalitzacioECompulsaRDTO.getEstatECompulsa()
			        .equals(EstatDigitalizaApiParamValue.OK.getApiParamValue())) {
				callbackDigitalitzacio.setDataDigitalitzacio(DateTime.now());
			} else {
				callbackDigitalitzacio.setCodiError(null);
				callbackDigitalitzacio.setDescripcioError(null);
			}
			serveisService.callbackDigitalitzacio(callbackDigitalitzacio);
		} catch (Exception e) {
			log.error("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioECompulsaRDTO)", e);
		}

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioECompulsaRDTO) - fi"); //$NON-NLS-1$
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping(value = "/estat_digitalitzacio/{idPeticio}")
	@ApiOperation(value = "Consultar l'estat d'una petició de digitalització", tags = { "Serveis Tramitadors API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaEstatDigitalitzacioRDTO consultarEstatDigitalitzacio(
	        @ApiParam(value = "Identificador de la petició de digitalització", required = true) @PathVariable String idPeticio)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirEstatDigitalitzacio(String) - inici"); //$NON-NLS-1$
		}

		RespostaConsultaEstatDigitalitzacioRDTO respostaConsultaEstatDigitalitzacioRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		EstatDigitalitzacioDocumentRDTO estat = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ESTAT_DOCUMENT_DIGITALITZACIO_EXPEDIENT);

		try {
			// llamar a metodo de digitalitzacio status
			estat = serveisService.obtenirEstatDigitalitzacioDocument(idDocument);

		} catch (GPAApiParamValidationException e) {
			log.error("obtenirEstatDigitalitzacio(String)", e); // $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("obtenirEstatDigitalitzacio(String)", e); // $NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler
			        .handleException(Resultat.ERROR_ESTAT_DOCUMENT_DIGITALITZACIO_EXPEDIENT, e);
		}

		RespostaEstatDigitalitzacioBDTO respostaEstatDigitalitzacioBDTO = new RespostaEstatDigitalitzacioBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO,
		        estat != null ? estat.getMessage() : null, estat != null ? estat.getStatus() : null);
		respostaEstatDigitalitzacioRDTO = modelMapper.map(respostaEstatDigitalitzacioBDTO, RespostaEstatDigitalitzacioRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("obtenirEstatDigitalitzacio(String) - fi"); //$NON-NLS-1$
		}

		return respostaEstatDigitalitzacioRDTO;
	}

}