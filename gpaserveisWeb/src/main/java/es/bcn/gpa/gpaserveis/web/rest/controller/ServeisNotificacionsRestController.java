package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.apache.commons.lang.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ActualitzarNotificacio;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsNotificacionsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusEstatsNotificacionsApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.notificacions.estat.RetornNotificacioRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.rest.http.ResponseEntity;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/notificacions", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Notificacions API", tags = "Serveis Notificacions API")
@CommonsLog
public class ServeisNotificacionsRestController extends BaseRestController {

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/**
	 * Servei específic que invocarà Enotificació per informar de l'estat de les
	 * notificacions.
	 *
	 * @return void
	 * @throws GPAServeisServiceException
	 */
	@PostMapping("/retorn_notificacio")
	@ApiOperation(value = "Retorn de l'estat de les notificacions", tags = { "Serveis Notificacions API" })
	public ResponseEntity<Void> retornEstatNotificacio(
	        @ApiParam(value = "Resposta del servei de notificacions", required = true) @RequestBody RetornNotificacioRDTO retornNotificacioRDTO) {

		if (log.isDebugEnabled()) {
			log.debug("retornEstatNotificacio(RetornNotificacioRDTO) - inici"); //$NON-NLS-1$
		}

		ActualitzarNotificacio actualitzarNotificacio = new ActualitzarNotificacio();

		try {
			TipusEstatsNotificacionsApiParamValueTranslator tipusEstatsNotificacionsApiParamValueTranslator = new TipusEstatsNotificacionsApiParamValueTranslator();
			TipusEstatsNotificacionsApiParamValue tipusEstatsDocumentsApiParamValue = null;
			tipusEstatsDocumentsApiParamValue = tipusEstatsNotificacionsApiParamValueTranslator
			        .getEnumByApiParamValue(retornNotificacioRDTO.getEstat());

			DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			actualitzarNotificacio = modelMapper.map(retornNotificacioRDTO, ActualitzarNotificacio.class);

			switch (tipusEstatsDocumentsApiParamValue) {
			case REGISTRADA:
				actualitzarNotificacio.setDataHoraRegistre(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraRegistre()));
				break;
			case DIPOSITADA:
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraRegistre())) {
					actualitzarNotificacio
					        .setDataHoraRegistre(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraRegistre()));
				}
				actualitzarNotificacio.setDataHoraDiposit(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraDiposit()));
				break;
			case VISUALITZADA:
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraRegistre())) {
					actualitzarNotificacio
					        .setDataHoraRegistre(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraRegistre()));
				}
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraDiposit())) {
					actualitzarNotificacio.setDataHoraDiposit(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraDiposit()));
				}
				actualitzarNotificacio
				        .setDataHoraVisualitzacio(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraVisualitzacio()));
				break;
			case REBUTJADA_SENSE_ACCES:

			case REBUTJADA:

			case ACCEPTADA:

			case REBUTJADA_SENSE_ACCIO:
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraRegistre())) {
					actualitzarNotificacio
					        .setDataHoraRegistre(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraRegistre()));
				}
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraDiposit())) {
					actualitzarNotificacio.setDataHoraDiposit(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraDiposit()));
				}
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraVisualitzacio())) {
					actualitzarNotificacio
					        .setDataHoraVisualitzacio(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraVisualitzacio()));
				}
				actualitzarNotificacio
				        .setDataHoraAceptacioRebuig(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraAceptacioRebuig()));
				break;
			default:
				break;
			}

			serveisService.callbackNotificacio(actualitzarNotificacio);

		} catch (Exception e) {
			log.error("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioRDTO)", e);
		}

		if (log.isDebugEnabled()) {
			log.debug("retornEstatNotificacio(RetornNotificacioRDTO) - fi"); //$NON-NLS-1$
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}