package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	/**
	 * Servei específic que invocarà Enotificació per informar de l'estat de les notificacions.
     *
	 * @return void
	 */
	@PostMapping("/retorn_notificacio")
	@ApiOperation(value = "Retorn de l'estat de les notificacions", tags = { "Serveis Notificacions API" })
	public ResponseEntity<Void> retornEstatNotificacio(
	        @ApiParam(value = "Resposta del MDS a una peticion d'escaneig", required = true) @RequestBody RetornNotificacioRDTO retornNotificacioRDTO) {

		if (log.isDebugEnabled()) {
			log.debug("retornEstatNotificacio(RetornNotificacioRDTO) - inici"); //$NON-NLS-1$
		}
		
		
		if (log.isDebugEnabled()) {
			log.debug("retornEstatNotificacio(RetornNotificacioRDTO) - fi"); //$NON-NLS-1$
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}