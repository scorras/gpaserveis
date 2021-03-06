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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.AuditServeisService;
import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsNotificacionsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusEstatsNotificacionsApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.notificacions.estat.RetornNotificacioRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

	/** The audit serveis service. */
	@Autowired
	private AuditServeisService auditServeisService;

	/**
	 * Servei espec??fic que invocar?? Enotificaci?? per informar de l'estat de les
	 * notificacions.
	 *
	 * @return void
	 * @throws GPAServeisServiceException
	 */
	@PostMapping(value = "/retorn_notificacio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(nickname = "retornEstatNotificacio", value = "Retorn de l'estat de les notificacions", tags = {
			"Serveis Notificacions API" })
	@ApiImplicitParams(@ApiImplicitParam(name = "metadata", value = "Metadata", dataType = "__file", paramType = "form", required = true))
	public ResponseEntity<Void> retornEstatNotificacio(
			@ApiParam(value = "Document de la evid??ncia electr??nica de la notificaci??") @RequestParam(value = "evidencian", required = false) MultipartFile docEvidenciaElectronic,
			@ApiParam(value = "Document de la evid??ncia en paper de la notificaci??") @RequestParam(value = "evidenciap", required = false) MultipartFile docEvidenciaPaper,
			@RequestPart(value = "metadata", required = true) RetornNotificacioRDTO retornNotificacioRDTO)
			throws GPAServeisServiceException {
		if (log.isInfoEnabled()) {
			log.info("retornEstatNotificacio(RetornNotificacioRDTO) - inici"); //$NON-NLS-1$
			log.info(retornNotificacioRDTO); // $NON-NLS-1$
		}

		String resultatAudit = "OK";
		GPAServeisServiceException ex = null;

		ActualitzarNotificacioBDTO actualitzarNotificacio = new ActualitzarNotificacioBDTO();

		try {
			TipusEstatsNotificacionsApiParamValueTranslator tipusEstatsNotificacionsApiParamValueTranslator = new TipusEstatsNotificacionsApiParamValueTranslator();
			TipusEstatsNotificacionsApiParamValue tipusEstatsDocumentsApiParamValue = null;
			tipusEstatsDocumentsApiParamValue = tipusEstatsNotificacionsApiParamValueTranslator
					.getEnumByApiParamValue(retornNotificacioRDTO.getEstat());

			DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			actualitzarNotificacio = modelMapper.map(retornNotificacioRDTO, ActualitzarNotificacioBDTO.class);

			switch (tipusEstatsDocumentsApiParamValue) {
			case ENVIADA:
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraRegistre())) {
					actualitzarNotificacio
							.setDataHoraRegistre(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraRegistre()));
				}
				break;
			case DIPOSITADA:
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraRegistre())) {
					actualitzarNotificacio
							.setDataHoraRegistre(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraRegistre()));
				}
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraDiposit())) {
					actualitzarNotificacio.setDataHoraDiposit(dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraDiposit()));
				}
				break;
			case VISUALITZADA:
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
				if (StringUtils.isNotEmpty(retornNotificacioRDTO.getDataHoraAceptacioRebuig())) {
					actualitzarNotificacio.setDataHoraAceptacioRebuig(
							dataHoraFormatter.parseDateTime(retornNotificacioRDTO.getDataHoraAceptacioRebuig()));
				}
				break;
			default:
				break;
			}

			serveisService.callbackNotificacio(actualitzarNotificacio, docEvidenciaElectronic, docEvidenciaPaper);

		} catch (Exception e) {
			log.info("respostaNotificacioEscaneig(RespostaEvidenciaDigitalitzacioRDTO)", e);
			resultatAudit = "KO";
			ex = new GPAServeisServiceException(e);
		} finally {
			AuditServeisBDTO auditServeisBDTO = auditServeisService.rellenarAuditoria();

			auditServeisBDTO.setMappingAccio("/retorn_notificacio");
			auditServeisBDTO.setResultat(resultatAudit);
			auditServeisBDTO.setTipusPeticio("POST");
			auditServeisBDTO.setValueAccio("Retorn de l'estat de les notificacions");

			auditServeisService.registrarAuditServeisNotificacions(auditServeisBDTO, retornNotificacioRDTO, null, ex);
		}

		if (log.isInfoEnabled()) {
			log.info("retornEstatNotificacio(RetornNotificacioRDTO) - fi"); //$NON-NLS-1$
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}