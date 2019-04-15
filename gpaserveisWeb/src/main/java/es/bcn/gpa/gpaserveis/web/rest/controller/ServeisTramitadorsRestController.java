package es.bcn.gpa.gpaserveis.web.rest.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaValidarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ValidarExpedient;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
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

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/expedients/{codiExpedient}/validacio")
	@ApiOperation(value = "Validar la sol·licitud de l'expedient", tags = { "Serveis Tramitadors API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaValidarExpedientRDTO validarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la validació de l'expedient") @RequestBody ExpedientValidacioRDTO expedientValidacio)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("validarSolicitudExpedient(String, ExpedientValidacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaValidarExpedientRDTO respostaValidarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaValidarExpedient respostaValidarExpedient = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_EXPEDIENT);

			// Validar solicitud de expediente si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD, Resultat.ERROR_VALIDAR_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de validar
			ValidarExpedient validarExpedient = new ValidarExpedient();
			validarExpedient.setExpedient(dadesExpedientBDTO.getExpedientsRDTO());
			validarExpedient.setComentari(expedientValidacio.getComentari());

			ExpedientsValidarBDTO expedientsValidarBDTO = new ExpedientsValidarBDTO(validarExpedient);
			respostaValidarExpedient = serveisService.validarSolicitudExpedient(expedientsValidarBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("validarSolicitudExpedient(String, ExpedientValidacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("validarSolicitudExpedient(String, ExpedientValidacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsValidarBDTO respostaExpedientsValidarBDTO = new RespostaExpedientsValidarBDTO(respostaValidarExpedient,
		        respostaResultatBDTO);
		respostaValidarExpedientRDTO = modelMapper.map(respostaExpedientsValidarBDTO, RespostaValidarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("validarSolicitudExpedient(String, ExpedientValidacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaValidarExpedientRDTO;
	}

}