package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.EstatDigitalizaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.IdiomaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.EstatDigitalizaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.IdiomaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mds.notificacions.RespostaEvidenciaDigitalitzacioRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
			@ApiParam(value = "Resposta del MDS a una peticion d'escaneig", required = true) @RequestBody RespostaEvidenciaDigitalitzacioRDTO respostaEvidenciaDigitalitzacioRDTO) {

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioRDTO) - inici"); //$NON-NLS-1$
		}

		try {

			IdiomaApiParamValueTranslator idiomaApiParamValueTranslator = new IdiomaApiParamValueTranslator();
			IdiomaApiParamValue idiomaApiParamValue = null;
			idiomaApiParamValue = idiomaApiParamValueTranslator.getEnumByApiParamValue(respostaEvidenciaDigitalitzacioRDTO.getIdioma());

			EstatDigitalizaApiParamValueTranslator estatDigitalizaApiParamValueTranslator = new EstatDigitalizaApiParamValueTranslator();
			EstatDigitalizaApiParamValue estatDigitalizaApiParamValue = null;
			estatDigitalizaApiParamValue = estatDigitalizaApiParamValueTranslator
					.getEnumByApiParamValue(respostaEvidenciaDigitalitzacioRDTO.getResultat());

			CallbackDigitalitzacio callbackDigitalitzacio = new CallbackDigitalitzacio();
			callbackDigitalitzacio.setIdDocScan(respostaEvidenciaDigitalitzacioRDTO.getIdDocScan());
			callbackDigitalitzacio.setEstat(estatDigitalizaApiParamValue.getInternalValue());
			if (respostaEvidenciaDigitalitzacioRDTO.getResultat().equals(EstatDigitalizaApiParamValue.OK.getApiParamValue())) {
				DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
				callbackDigitalitzacio.setDataDigitalitzacio(
						dataHoraFormatter.parseDateTime(respostaEvidenciaDigitalitzacioRDTO.getDataDigitalitzacio()));
				callbackDigitalitzacio.setIdioma(idiomaApiParamValue.getInternalValue());
			} else {
				callbackDigitalitzacio.setCodiError(respostaEvidenciaDigitalitzacioRDTO.getCodiError());
				callbackDigitalitzacio.setDescripcioError(respostaEvidenciaDigitalitzacioRDTO.getDescripcioError());
			}
			serveisService.callbackDigitalitzacio(callbackDigitalitzacio);
		} catch (Exception e) {
			log.error("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioRDTO)", e);
		}

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioRDTO) - fi"); //$NON-NLS-1$
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}