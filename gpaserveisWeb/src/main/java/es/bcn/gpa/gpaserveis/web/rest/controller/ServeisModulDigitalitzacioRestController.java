package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	/**
	 * Servei específic per rebre notificacions de les respostes del MDS a peticions d'escaneig. 
	 * Aquestes respostes hauran de ser una petició POST enviada a la URL indicada a la petició d’escaneig original (camp notificationEndpoint). 
	 * El document propiament dit no s'ha d’enviar però si l'identificador del document al gestor documental.
     *
	 * @return void
	 */
	@PostMapping("/evidencia_digitalitzacio")
	@ApiOperation(value = "Notificacions de les respostes del MDS a peticions d'escaneig", tags = { "Serveis MDS API" })
	public ResponseEntity<Void> respostaNotificacioEscaneig(
	        @ApiParam(value = "Resposta del MDS a una peticion d'escaneig", required = true) @RequestBody RespostaEvidenciaDigitalitzacioRDTO respostaEvidenciaDigitalitzacioRDTO) {

		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaNotificacioEscaneigRDTO) - inici"); //$NON-NLS-1$
		}
		
		
		if (log.isDebugEnabled()) {
			log.debug("respostaNotificacioEscaneig(RespostaNotificacioEscaneigRDTO) - fi"); //$NON-NLS-1$
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}