package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
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

import es.bcn.gpa.gpaserveis.business.AuditServeisService;
import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.EstatDigitalitzacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.EstatDigitalitzacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mds.notificacions.RespostaEvidenciaDigitalitzacioECompulsaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.estatDigitalitzacio.RespostaConsultaEstatDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.BaseRestController;
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

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The audit serveis service. */
	@Autowired
	private AuditServeisService auditServeisService;

	/**
	 * Servei específic per rebre notificacions de les respostes del MDS a
	 * peticions d'escaneig. Aquestes respostes hauran de ser una petició POST
	 * enviada a la URL indicada a la petició d’escaneig original (camp
	 * notificationEndpoint). El document propiament dit no s'ha d’enviar però
	 * si l'identificador del document al gestor documental.
	 *
	 * @return void
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/evidencia_digitalitzacio")
	@ApiOperation(value = "Notificacions de les respostes del MDS a peticions d'escaneig", tags = { "Serveis MDS API" })
	public ResponseEntity<Void> respostaNotificacioEscaneig(
			@ApiParam(value = "Resposta del MDS a una peticion d'escaneig", required = true) @RequestBody RespostaEvidenciaDigitalitzacioECompulsaRDTO respostaEvidenciaDigitalitzacioECompulsaRDTO)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioECompulsaRDTO) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		try {
			CallbackDigitalitzacio callbackDigitalitzacio = new CallbackDigitalitzacio();
			callbackDigitalitzacio.setIdPeticio(respostaEvidenciaDigitalitzacioECompulsaRDTO.getIdPeticio());
			callbackDigitalitzacio.setIdDocScan(StringUtils.join(respostaEvidenciaDigitalitzacioECompulsaRDTO.getIdDocumentum(), ","));
			EstatDigitalitzacioApiParamValueTranslator estatDigitalizaApiParamValueTranslator = new EstatDigitalitzacioApiParamValueTranslator();
			callbackDigitalitzacio.setEstat(estatDigitalizaApiParamValueTranslator
					.getInternalValueByApiParamValue(respostaEvidenciaDigitalitzacioECompulsaRDTO.getEstatECompulsa()));
			if (respostaEvidenciaDigitalitzacioECompulsaRDTO.getEstatECompulsa()
					.equals(EstatDigitalitzacioApiParamValue.OK.getApiParamValue())) {
				callbackDigitalitzacio.setDataDigitalitzacio(DateTime.now());
			} else {
				callbackDigitalitzacio.setCodiError(null);
				callbackDigitalitzacio.setDescripcioError(null);
			}
			serveisService.callbackDigitalitzacio(callbackDigitalitzacio);
		} catch (Exception e) {
			log.error("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioECompulsaRDTO)", e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/evidencia_digitalitzacio");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Notificacions de les respostes del MDS a peticions d'escaneig");

			auditServeisService.registrarAuditServeisMds(auditServeisBDTO, respostaEvidenciaDigitalitzacioECompulsaRDTO, null, ex);
		}

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioECompulsaRDTO) - fi"); //$NON-NLS-1$
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * Consultar estat digitalitzacio.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @return the resposta consulta estat digitalitzacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping(value = "/estat_digitalitzacio/{idPeticio}")
	@ApiOperation(value = "Consultar l'estat d'una petició de digitalització", tags = { "Serveis MDS API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaEstatDigitalitzacioRDTO consultarEstatDigitalitzacio(
			@ApiParam(value = "Identificador de la petició de digitalització", required = true) @PathVariable String idPeticio)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirEstatDigitalitzacio(String) - inici"); //$NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		RespostaConsultaEstatDigitalitzacioRDTO respostaConsultaEstatDigitalitzacioRDTO = null;
		PeticionsDigitalitzacioRDTO peticionsDigitalitzacioRDTO = null;

		try {
			peticionsDigitalitzacioRDTO = serveisService.consultarEstatDigitalitzacio(idPeticio);
		} catch (GPAServeisServiceException e) {
			log.error(e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/estat_digitalitzacio/" + idPeticio);
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Consultar l'estat d'una petició de digitalització");

			auditServeisService.registrarAuditServeisMds(auditServeisBDTO, null, peticionsDigitalitzacioRDTO, ex);
		}

		if (peticionsDigitalitzacioRDTO != null) {
			respostaConsultaEstatDigitalitzacioRDTO = modelMapper.map(peticionsDigitalitzacioRDTO,
					RespostaConsultaEstatDigitalitzacioRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("obtenirEstatDigitalitzacio(String) - fi"); //$NON-NLS-1$
		}

		return respostaConsultaEstatDigitalitzacioRDTO;
	}

}