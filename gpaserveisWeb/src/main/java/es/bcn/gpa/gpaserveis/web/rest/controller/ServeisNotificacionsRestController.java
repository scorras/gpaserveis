package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.Arrays;

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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentCanviEstat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsNotificacionsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusEstatsDocumentsApiParamValueTranslator;
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
	        @ApiParam(value = "Resposta del servei de notificacions", required = true) @RequestBody RetornNotificacioRDTO retornNotificacioRDTO)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("retornEstatNotificacio(RetornNotificacioRDTO) - inici"); //$NON-NLS-1$
		}

		TipusEstatsNotificacionsApiParamValueTranslator tipusEstatsNotificacionsApiParamValueTranslator = new TipusEstatsNotificacionsApiParamValueTranslator();
		TipusEstatsNotificacionsApiParamValue tipusEstatsDocumentsApiParamValue = null;
		tipusEstatsDocumentsApiParamValue = tipusEstatsNotificacionsApiParamValueTranslator
		        .getEnumByInternalValue(retornNotificacioRDTO.getEstat());

		TipusEstatsDocumentsApiParamValueTranslator tipusEstatsDocumentsApiParamValueTranslator = new TipusEstatsDocumentsApiParamValueTranslator();

		DocsTramitacioRDTO docsTramitacioRDTO = serveisService
		        .obtenirDocsTramitacioByNotificationId(retornNotificacioRDTO.getNotificacioId());
		BigDecimal expedientId = serveisService.getIdExpedientByDocumentacioIdExt(docsTramitacioRDTO.getDocumentacio());
		DocumentCanviEstat documentCanviEstat = new DocumentCanviEstat();
		documentCanviEstat.setDocsTramitacioIds(Arrays.asList(docsTramitacioRDTO.getId()));
		documentCanviEstat.setEstatActualId(docsTramitacioRDTO.getEstat());
		documentCanviEstat.setEstatFinalId(tipusEstatsDocumentsApiParamValue.getInternalValue());
		documentCanviEstat.setEstatActualDesc(
		        String.valueOf(tipusEstatsDocumentsApiParamValueTranslator.getEnumByInternalValue(docsTramitacioRDTO.getEstat())));
		documentCanviEstat.setEstatFinalDesc(String.valueOf(
		        tipusEstatsDocumentsApiParamValueTranslator.getEnumByInternalValue(tipusEstatsDocumentsApiParamValue.getInternalValue())));
		documentCanviEstat.setExpedientId(expedientId);

		switch (tipusEstatsDocumentsApiParamValue) {
		case PENDENT_NOTIFICACIO:
			break;
		case REGISTRAT:
			break;
		case DISPOSITAT:
			break;
		case NOTIFICACIO_VISUALITZADA:
			break;
		case NOTIFICACIO_REBUTJADA:
			break;
		case NOTIFICACIO_ACCEPTADA:
			break;
		default:
			break;
		}

		serveisService.actualitzarNotificacion();

		if (log.isDebugEnabled()) {
			log.debug("retornEstatNotificacio(RetornNotificacioRDTO) - fi"); //$NON-NLS-1$
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}