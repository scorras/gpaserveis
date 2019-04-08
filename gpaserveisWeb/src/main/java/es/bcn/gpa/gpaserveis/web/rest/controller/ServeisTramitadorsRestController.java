package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.ExpedientValidacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.RespostaValidarExpedientRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ServeisTramitadorsRestController.
 */
@RestController
@RequestMapping(value = "/serveis/tramitadors", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Tramitadors API", tags = "Serveis Tramitadors API")
@CommonsLog
public class ServeisTramitadorsRestController extends BaseRestController {

	@PostMapping("/expedients/{codiExpedient}/validacio")
	@ApiOperation(value = "Validar la sol·licitud de l'expedient", tags = { "Serveis Tramitadors API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaValidarExpedientRDTO validarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la validació de l'expedient") @RequestBody ExpedientValidacioRDTO expedientValidacio)
	        throws GPAServeisServiceException {

		return new RespostaValidarExpedientRDTO();
	}

}