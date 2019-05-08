package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.IncorporarNouDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.IncorporarNouDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaRebutjarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaValidarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsArxivarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsPausarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsProposarResolucioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsReactivarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRetornarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsTancarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaSignarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarLaTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerValidationHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.ConfiguracioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaSignarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.DocumentAportatRebutjarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.RespostaRebutjarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.DocumentAportatValidarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.RespostaValidarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.arxivar.ExpedientArxiuRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.arxivar.RespostaArxivarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.ExpedientPausaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.RespostaPausarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar.ExpedientReactivacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar.RespostaReactivarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar.ExpedientPropostaResolucioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar.RespostaProposarResolucioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tancar.ExpedientTancamentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tancar.RespostaTancarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tornar.ExpedientTornadaEnrereRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tornar.RespostaTornarEnrereExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.convidar.ExpedientConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.convidar.RespostaConvidarTramitarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.retornar.ExpedientRetornRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.retornar.RespostaRetornarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.unitatsgestores.canviar.ExpedientCanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.unitatsgestores.canviar.RespostaCanviarUnitatGestoraExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.ExpedientValidacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.RespostaValidarExpedientRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;

/**
 * The Class ServeisTramitadorsRestController.
 */
@RestController
@RequestMapping(value = "/serveis/tramitadors", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Tramitadors API", tags = "Serveis Tramitadors API")
@CommonsLog
@EntornPropertySource(value = { "classpath:/app/config/gpaserveis.properties" })
public class ServeisTramitadorsRestController extends BaseRestController {

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The expedients id organ. */
	@Value("${expedients.id.organ}")
	private String expedientsIdOrgan;

	/**
	 * Validar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientValidacio
	 *            the expedient validacio
	 * @return the resposta validar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/validar")
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
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_EXPEDIENT);

			// Validar solicitud de expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD, Resultat.ERROR_VALIDAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientValidacio.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.VALIDAR_SOLLICITUD.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("validarSolicitudExpedient(String, ExpedientValidacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("validarSolicitudExpedient(String, ExpedientValidacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_VALIDAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsValidarBDTO respostaExpedientsValidarBDTO = new RespostaExpedientsValidarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaValidarExpedientRDTO = modelMapper.map(respostaExpedientsValidarBDTO, RespostaValidarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("validarSolicitudExpedient(String, ExpedientValidacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaValidarExpedientRDTO;
	}

	/**
	 * Pausar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientPausa
	 *            the expedient pausa
	 * @return the resposta pausar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/pausar")
	@ApiOperation(value = "Pausar la tramitació de l'expedient", tags = { "Serveis Tramitadors API",
			"Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPausarExpedientRDTO pausarExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la pausa de l'expedient") @RequestBody ExpedientPausaRDTO expedientPausa)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("pausarExpedient(String, String, ExpedientPausaRDTO) - inici");
			// $NON-NLS-1$
		}

		RespostaPausarExpedientRDTO respostaPausarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PAUSAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Pausar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.PAUSAR_EXPEDIENT, Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			// Desde el estado 4 se puede transicionar al 5 o 6 en función del
			// motivo
			expedientCanviEstatAccio.setOperacio(expedientPausa.getMotiu());
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.PAUSAR_EXPEDIENT.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("pausarExpedient(String, String, ExpedientPausaRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("pausarExpedient(String, String, ExpedientPausaRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsPausarBDTO respostaExpedientsPausarBDTO = new RespostaExpedientsPausarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaPausarExpedientRDTO = modelMapper.map(respostaExpedientsPausarBDTO, RespostaPausarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("pausarExpedient(String, String, ExpedientPausaRDTO) - fi");
			// $NON-NLS-1$
		}

		return respostaPausarExpedientRDTO;
	}

	/**
	 * Reactivar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientReactivacio
	 *            the expedient reactivacio
	 * @return the resposta reactivar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/reactivar")
	@ApiOperation(value = "Força la recuperació de l'expedient inclús abans que hagi transcorregut el termini", tags = {
			"Serveis Tramitadors API", "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaReactivarExpedientRDTO reactivarExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la reactivació de l'expedient") @RequestBody ExpedientReactivacioRDTO expedientReactivacio)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("reactivarExpedient(String, ExpedientReactivacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaReactivarExpedientRDTO respostaReactivarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REACTIVAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REACTIVAR_EXPEDIENT);

			// Reactivar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.REACTIVAR_EXPEDIENT, Resultat.ERROR_REACTIVAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REACTIVAR_EXPEDIENT.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

			// TODO Fechas fin de plazo a null

		} catch (GPAApiParamValidationException e) {
			log.error("reactivarExpedient(String, ExpedientReactivacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("reactivarExpedient(String, ExpedientReactivacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_REACTIVAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsReactivarBDTO respostaExpedientsReactivarBDTO = new RespostaExpedientsReactivarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaReactivarExpedientRDTO = modelMapper.map(respostaExpedientsReactivarBDTO, RespostaReactivarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("reactivarExpedient(String, ExpedientReactivacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaReactivarExpedientRDTO;
	}

	/**
	 * Arxivar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientArxiu
	 *            the expedient arxiu
	 * @return the resposta arxivar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/arxivar")
	@ApiOperation(value = "Arxivar sol·licitud incompleta", tags = { "Serveis Tramitadors API",
			"Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaArxivarExpedientRDTO arxivarSolicitudExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de l'arxivat l'expedient") @RequestBody ExpedientArxiuRDTO expedientArxiu)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaArxivarExpedientRDTO respostaArxivarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ARXIVAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ARXIVAR_EXPEDIENT);

			// Archivar solicitud de expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.ARXIVAR_SOLLICITUD_INCOMPLETA, Resultat.ERROR_ARXIVAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(),
					AccioTramitadorApiParamValue.ARXIVAR_SOLLICITUD_INCOMPLETA.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ARXIVAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsArxivarBDTO respostaExpedientsArxivarBDTO = new RespostaExpedientsArxivarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaArxivarExpedientRDTO = modelMapper.map(respostaExpedientsArxivarBDTO, RespostaArxivarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("arxivarSolicitudExpedient(String, ExpedientArxiuRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaArxivarExpedientRDTO;
	}

	/**
	 * Retornar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientRetorn
	 *            the expedient retorn
	 * @return the resposta retornar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tramitar/retornar")
	@ApiOperation(value = "Donar resposta a l'acció Convidar a tramitar", tags = { "Serveis Tramitadors API",
			"Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRetornarExpedientRDTO retornarExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la tornada de l'expedient") @RequestBody ExpedientRetornRDTO expedientRetorn)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("retornarExpedient(String, ExpedientRetornRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaRetornarExpedientRDTO respostaRetornarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_RETORNAR_TRAMITACIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT);

			// Devolver la tramitación del expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.RETORNAR_TRAMITACIO, Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT);

			// Desasociar de la UG invitada a tramitar
			UnitatsGestoresRDTO unitatsGestoresRDTO = serveisService
			        .consultarDadesUnitatGestora(dadesExpedientBDTO.getExpedientsRDTO().getUgConvidadaIdext());
			RetornarLaTramitacioRDTO retornarLaTramitacioRDTO = new RetornarLaTramitacioRDTO();
			retornarLaTramitacioRDTO.setIdExpedientList(Arrays.asList(dadesExpedientBDTO.getExpedientsRDTO().getId()));
			DropdownItemBDTO dropdownItemBDTO = new DropdownItemBDTO();
			dropdownItemBDTO.setId(unitatsGestoresRDTO.getId());
			dropdownItemBDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());
			retornarLaTramitacioRDTO.setUnitatGestoraConvidada(dropdownItemBDTO);
			ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO = new ExpedientsRetornarTramitacioBDTO(
			        retornarLaTramitacioRDTO);
			serveisService.retornarTramitacioExpedient(expedientsRetornarTramitacioBDTO);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.RETORNAR_TRAMITACIO.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("retornarExpedient(String, ExpedientRetornRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("retornarExpedient(String, ExpedientRetornRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsRetornarBDTO respostaExpedientsRetornarBDTO = new RespostaExpedientsRetornarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaRetornarExpedientRDTO = modelMapper.map(respostaExpedientsRetornarBDTO, RespostaRetornarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("retornarExpedient(String, ExpedientRetornRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRetornarExpedientRDTO;
	}

	/**
	 * Proposar resolucio expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientPropostaResolucio
	 *            the expedient proposta resolucio
	 * @return the resposta proposar resolucio expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/resolucio/proposar")
	@ApiOperation(value = "Eleva una proposta de resolució per sotmetre-la al vist-i-plau i signatura dels òrgans competents", tags = {
			"Serveis Tramitadors API", "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaProposarResolucioExpedientRDTO proposarResolucioExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la proposta de resolució de l'expedient") @RequestBody ExpedientPropostaResolucioRDTO expedientPropostaResolucio)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaProposarResolucioExpedientRDTO respostaProposarResolucioExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PROPOSAR_RESOLUCIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PROPOSAR_RESOLUCIO_EXPEDIENT);

			// Proponer la resolución del expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO, Resultat.ERROR_PROPOSAR_RESOLUCIO_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.PROPOSAR_RESOLUCIO.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_RETORNAR_TRAMITACIO_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsProposarResolucioBDTO respostaExpedientsProposarResolucioBDTO = new RespostaExpedientsProposarResolucioBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaProposarResolucioExpedientRDTO = modelMapper.map(respostaExpedientsProposarResolucioBDTO,
				RespostaProposarResolucioExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("proposarResolucioExpedient(String, ExpedientPropostaResolucioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaProposarResolucioExpedientRDTO;
	}

	/**
	 * Tancar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientTancament
	 *            the expedient tancament
	 * @return the resposta tancar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tancar")
	@ApiOperation(value = "Tancar l'expedient", tags = { "Serveis Tramitadors API", "Funcions d'execució d'accions" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaTancarExpedientRDTO tancarExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades del tancament de l'expedient") @RequestBody ExpedientTancamentRDTO expedientTancament)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("tancarExpedient(String, ExpedientTancamentRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaTancarExpedientRDTO respostaTancarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_TANCAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_TANCAR_EXPEDIENT);

			// Cerrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.TANCAR_EXPEDIENT, Resultat.ERROR_TANCAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.TANCAR_EXPEDIENT.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

			// TODO Validar Contenido mínimo requerido (Documentos, Dades
			// d'Operació?)

		} catch (GPAApiParamValidationException e) {
			log.error("tancarExpedient(String, ExpedientTancamentRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("tancarExpedient(String, ExpedientTancamentRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_TANCAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsTancarBDTO respostaExpedientsTancarBDTO = new RespostaExpedientsTancarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaTancarExpedientRDTO = modelMapper.map(respostaExpedientsTancarBDTO, RespostaTancarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("tancarExpedient(String, ExpedientTancamentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaTancarExpedientRDTO;
	}

	/**
	 * Tornar enrere expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientTornadaEnrere
	 *            the expedient tornada enrere
	 * @return the resposta tornar enrere expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tornar")
	@ApiOperation(value = "Tornar enrere", tags = { "Serveis Tramitadors API", "Funcions d'execució d'accions" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaTornarEnrereExpedientRDTO tornarEnrereExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades del tancament de l'expedient") @RequestBody ExpedientTornadaEnrereRDTO expedientTornadaEnrere)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaTornarEnrereExpedientRDTO respostaTornarEnrereExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_TORNAR_ENRERE_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
					.consultarDadesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_TORNAR_ENRERE_EXPEDIENT);

			// Volver atrás si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.TORNAR_ENRERE, Resultat.ERROR_TORNAR_ENRERE_EXPEDIENT);

			// Cambio de estado del expediente
			// Es necesario consultar el histórico para determinar el cambio de
			// estado que debe hacerse
			if (CollectionUtils.isNotEmpty(dadesExpedientBDTO.getHistoricsEstats()) && dadesExpedientBDTO.getHistoricsEstats().size() > 1) {
				ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
						ExpedientCanviEstatAccio.class);
				String operacio = dadesExpedientBDTO.getHistoricsEstats().get(0).getIdEstatActual() + "_"
						+ dadesExpedientBDTO.getHistoricsEstats().get(1).getIdEstatActual();
				expedientCanviEstatAccio.setOperacio(operacio);
				ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(
						expedientCanviEstatAccio, dadesExpedientBDTO.getExpedientsRDTO().getId(),
						AccioTramitadorApiParamValue.TORNAR_ENRERE.getInternalValue());
				serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_TORNAR_ENRERE_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsTornarEnrereBDTO respostaExpedientsTornarEnrereBDTO = new RespostaExpedientsTornarEnrereBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaTornarEnrereExpedientRDTO = modelMapper.map(respostaExpedientsTornarEnrereBDTO, RespostaTornarEnrereExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("tornarEnrereExpedient(String, ExpedientTornadaEnrereRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaTornarEnrereExpedientRDTO;
	}

	/**
	 * Validar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentAportatValidar
	 *            the document aportat validar
	 * @return the resposta validar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/validar")
	@ApiOperation(value = "Validar document de l'expedient", tags = { "Serveis Tramitadors API",
			"Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaValidarDocumentRDTO validarDocumentExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
			@ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatValidarRDTO documentAportatValidar)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaValidarDocumentRDTO respostaValidarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO,
					Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT);

			// Validar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.VALIDAR_DOCUMENT, Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT);

			// Estado de revisión del documento a Correcte
			DocumentRevisio documentRevisio = new DocumentRevisio();
			documentRevisio.setDocsEntradaIds(Arrays.asList(idDocument));
			documentRevisio.setExpedientId(dadesExpedientBDTO.getExpedientsRDTO().getId());
			documentRevisio.setEstatRevisioId(RevisioApiParamValue.CORRECTE.getInternalValue());
			DocumentAportatValidarBDTO documentAportatValidarBDTO = new DocumentAportatValidarBDTO(documentRevisio);
			serveisService.revisarDocumentacioEntrada(documentAportatValidarBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(documentAportatValidar.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.VALIDAR_DOCUMENT.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_VALIDAR_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaValidarDocumentExpedientBDTO respostaValidarDocumentExpedientBDTO = new RespostaValidarDocumentExpedientBDTO(
				docsEntradaRDTO, respostaResultatBDTO);
		respostaValidarDocumentRDTO = modelMapper.map(respostaValidarDocumentExpedientBDTO, RespostaValidarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("validarDocumentExpedient(String, BigDecimal, DocumentAportatValidarRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaValidarDocumentRDTO;
	}

	/**
	 * Rebutjar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentAportatRebutjar
	 *            the document aportat rebutjar
	 * @return the resposta rebutjar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/rebutjar")
	@ApiOperation(value = "Rebutjar document de l'expedient", tags = { "Serveis Tramitadors API",
			"Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRebutjarDocumentRDTO rebutjarDocumentExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
			@ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatRebutjarRDTO documentAportatRebutjar)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaRebutjarDocumentRDTO respostaRebutjarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REBUTJAR_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO,
					Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT);

			// Validar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.REBUTJAR_DOCUMENT, Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT);

			// Estado de revisión del documento a Incorrecte
			DocumentRevisio documentRevisio = new DocumentRevisio();
			documentRevisio.setDocsEntradaIds(Arrays.asList(idDocument));
			documentRevisio.setExpedientId(dadesExpedientBDTO.getExpedientsRDTO().getId());
			documentRevisio.setEstatRevisioId(RevisioApiParamValue.INCORRECTE.getInternalValue());
			DocumentAportatValidarBDTO documentAportatValidarBDTO = new DocumentAportatValidarBDTO(documentRevisio);
			serveisService.revisarDocumentacioEntrada(documentAportatValidarBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(documentAportatRebutjar.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REBUTJAR_DOCUMENT.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_REBUTJAR_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaRebutjarDocumentExpedientBDTO respostaRebutjarDocumentExpedientBDTO = new RespostaRebutjarDocumentExpedientBDTO(
				docsEntradaRDTO, respostaResultatBDTO);
		respostaRebutjarDocumentRDTO = modelMapper.map(respostaRebutjarDocumentExpedientBDTO, RespostaRebutjarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("rebutjarDocumentExpedient(String, BigDecimal, DocumentAportatRebutjarRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRebutjarDocumentRDTO;
	}

	/**
	 * Convidar tramitar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientConvidarTramitar
	 *            the expedient convidar tramitar
	 * @return the resposta convidar tramitar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/tramitar/convidar")
	@ApiOperation(value = "Convidar a tramitar l'expedient", tags = { "Serveis Tramitadors API",
			"Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaConvidarTramitarExpedientRDTO convidarTramitarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la invitació a tramitar l'expedient") @RequestBody ExpedientConvidarTramitarRDTO expedientConvidarTramitar)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaConvidarTramitarExpedientRDTO respostaConvidarTramitarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CONVIDAR_TRAMITAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			// Se obtiene la información del procedimiento asociado al
			// expediente
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
					.consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

			// El codi de la unitat gestora debe existir y estar vigente
			UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
			        expedientConvidarTramitar.getCodiUnitatGestora());
			UnitatsGestoresRDTO unitatsGestoresRDTO = serveisService.consultarDadesUnitatGestora(unitatsGestoresCercaBDTO);
			ServeisRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
			        Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			// Invitar a tramitar el expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.CONVIDAR_TRAMITAR, Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT);

			// Asociación de la UG invitada a tramitar
			ConvidarTramitarRDTO convidarTramitarRDTO = new ConvidarTramitarRDTO();
			convidarTramitarRDTO.setIdExpedientList(Arrays.asList(dadesExpedientBDTO.getExpedientsRDTO().getId()));
			DropdownItemBDTO dropdownItemBDTO = new DropdownItemBDTO();
			dropdownItemBDTO.setId(unitatsGestoresRDTO.getId());
			dropdownItemBDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());
			convidarTramitarRDTO.setUnitatGestoraConvidada(dropdownItemBDTO);
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientConvidarTramitar.getComentari());
			convidarTramitarRDTO.setComentari(comentaris);
			ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO = new ExpedientsConvidarTramitarBDTO(convidarTramitarRDTO);
			serveisService.convidarTramitarExpedient(expedientsConvidarTramitarBDTO);

			// Crear comentario
			// TODO Ahora se crea el comentario dentro de la operación de
			// Convidar a Tramitar. Queda pendiente sacar esta operación fuera

		} catch (GPAApiParamValidationException e) {
			log.error("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_CONVIDAR_TRAMITAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsConvidarTramitarBDTO respostaExpedientsConvidarTramitarBDTO = new RespostaExpedientsConvidarTramitarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaConvidarTramitarExpedientRDTO = modelMapper.map(respostaExpedientsConvidarTramitarBDTO,
				RespostaConvidarTramitarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("convidarTramitarExpedient(String, ExpedientConvidarTramitarRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaConvidarTramitarExpedientRDTO;
	}

	/**
	 * Canviar unitat gestora expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientCanviUnitatGestora
	 *            the expedient canvi unitat gestora
	 * @return the resposta canviar unitat gestora expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/unitat")
	@ApiOperation(value = "Canviar la unitat gestora de l’expedient", tags = { "Serveis Tramitadors API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaCanviarUnitatGestoraExpedientRDTO canviarUnitatGestoraExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody ExpedientCanviUnitatGestoraRDTO expedientCanviUnitatGestora)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaCanviarUnitatGestoraExpedientRDTO respostaCanviarUnitatGestoraExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		UnitatsGestoresRDTO unitatsGestoresRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CANVIAR_UNITAT_GESTORA_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT);

			// Se obtiene la información del procedimiento asociado al
			// expediente
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			        .consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

			// El codi de la nueva unitat gestora debe existir, estar vigente y
			// asociada al Procedimiento del Expediente
			UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
			        expedientCanviUnitatGestora.getCodiUnitatGestora());
			unitatsGestoresRDTO = serveisService.consultarDadesUnitatGestora(unitatsGestoresCercaBDTO);
			ServeisRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
			        Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT);
			// Se setea la nueva unidad gestora en la información del expediente
			dadesExpedientBDTO.setUnitatsGestoresRDTO(unitatsGestoresRDTO);

			// Cambiar la Unidad Gestora del expediente si la acción es
			// permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.CANVIAR_UNITAT_GESTORA, Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT);

			// Asociación de la nueva UG
			CanviUnitatGestoraRDTO canviUnitatGestoraRDTO = new CanviUnitatGestoraRDTO();
			canviUnitatGestoraRDTO.setIdExpedientList(Arrays.asList(dadesExpedientBDTO.getExpedientsRDTO().getId()));
			DropdownItemBDTO unitatGestoraActual = new DropdownItemBDTO();
			unitatGestoraActual.setId(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
			unitatGestoraActual.setDescripcio(dadesExpedientBDTO.getExpedientsRDTO().getDescUnitatGestora());
			canviUnitatGestoraRDTO.setUnitatGestoraActual(unitatGestoraActual);
			DropdownItemBDTO unitatGestoraFutura = new DropdownItemBDTO();
			unitatGestoraFutura.setId(unitatsGestoresRDTO.getId());
			unitatGestoraFutura.setDescripcio(unitatsGestoresRDTO.getDescripcio());
			canviUnitatGestoraRDTO.setUnitatGestoraFutura(unitatGestoraFutura);
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientCanviUnitatGestora.getComentari());
			canviUnitatGestoraRDTO.setComentari(comentaris);
			ExpedientsCanviarUnitatGestoraBDTO expedientsCanviarUnitatGestoraBDTO = new ExpedientsCanviarUnitatGestoraBDTO(
			        canviUnitatGestoraRDTO);
			serveisService.canviarUnitatGestoraExpedient(expedientsCanviarUnitatGestoraBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsCanviarUnitatGestoraBDTO respostaExpedientsCanviarUnitatGestoraBDTO = new RespostaExpedientsCanviarUnitatGestoraBDTO(
		        dadesExpedientBDTO, respostaResultatBDTO);
		respostaCanviarUnitatGestoraExpedientRDTO = modelMapper.map(respostaExpedientsCanviarUnitatGestoraBDTO,
		        RespostaCanviarUnitatGestoraExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("canviarUnitatGestoraExpedient(String, ExpedientCanviUnitatGestoraRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaCanviarUnitatGestoraExpedientRDTO;
	}

	/**
	 * Incorporar nou document expedient expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param documentIncorporacioNou
	 *            the document incorporacio nou
	 * @return the resposta incorporar nou document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio")
	@ApiOperation(value = "Incorporar un nou document electrònic", tags = { "Serveis Tramitadors API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaIncorporarNouDocumentRDTO incorporarNouDocumentExpedientExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades del document a incorporar") @RequestBody DocumentIncorporacioNouRDTO documentIncorporacioNou)
	        throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaIncorporarNouDocumentRDTO respostaIncorporarNouDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		Boolean esAportada = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);
		try {
			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
			        .getEnumByApiParamValue(documentIncorporacioNou.getDocument().getConfiguracio());
			switch (configuracioApiParamValue) {
			case APORTADA:
				esAportada = Boolean.TRUE;

				break;
			case GENERADA:
				esAportada = Boolean.FALSE;

				break;
			default:
				break;
			}

			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			// El número de registro indicado debe existir
			registreAssentamentRDTO = serveisService
			        .consultarDadesRegistreAssentament(documentIncorporacioNou.getDocument().getNumeroRegistre());
			ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
			        Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			// Incorporar un nuevo documento electrónico al expediente si la
			// acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.INCORPORAR_NOU_DOCUMENT_ELECTRONIC, Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			// Incorporar un nuevo documento, pudiéndose tratar de entrada o
			// tramitación
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			// Hay que tener en cuenta que en este caso puede tratarse de
			// documento de entrada o de tramitación
			if (BooleanUtils.isTrue(esAportada)) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioEntradaIncorporatNou(
				                respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
				                documentIncorporacioNou.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				IncorporarNouDocumentEntradaExpedientBDTO incorporarNouDocumentEntradaExpedientBDTO = new IncorporarNouDocumentEntradaExpedientBDTO();
				DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentIncorporacioNou, DocsEntradaRDTO.class);
				docsEntradaRDTO
				        .setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
				incorporarNouDocumentEntradaExpedientBDTO.setDocsEntradaRDTO(docsEntradaRDTO);
				incorporarNouDocumentEntradaExpedientBDTO.setIdExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
				docsEntradaRDTOResult = serveisService.guardarDocumentEntrada(incorporarNouDocumentEntradaExpedientBDTO);
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
				        .cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
				        .validateConfiguracioDocumentacioTramitacioIncorporatNou(
				                respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
				                documentIncorporacioNou.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				IncorporarNouDocumentTramitacioExpedientBDTO incorporarNouDocumentTramitacioExpedientBDTO = new IncorporarNouDocumentTramitacioExpedientBDTO();
				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentIncorporacioNou, DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
				        configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());
				incorporarNouDocumentTramitacioExpedientBDTO.setDocsTramitacioRDTO(docsTramitacioRDTO);
				incorporarNouDocumentTramitacioExpedientBDTO.setIdExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
				docsTramitacioRDTOResult = serveisService.guardarDocumentTramitacio(incorporarNouDocumentTramitacioExpedientBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		if (BooleanUtils.isTrue(esAportada)) {
			RespostaIncorporarNouDocumentEntradaExpedientBDTO respostaIncorporarNouDocumentEntradaExpedientBDTO = new RespostaIncorporarNouDocumentEntradaExpedientBDTO(
			        docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        registreAssentamentRDTO, respostaResultatBDTO);
			respostaIncorporarNouDocumentRDTO = modelMapper.map(respostaIncorporarNouDocumentEntradaExpedientBDTO,
			        RespostaIncorporarNouDocumentRDTO.class);
		} else {
			RespostaIncorporarNouDocumentTramitacioExpedientBDTO respostaIncorporarNouDocumentTramitacioExpedientBDTO = new RespostaIncorporarNouDocumentTramitacioExpedientBDTO(
			        docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
			        registreAssentamentRDTO, respostaResultatBDTO);
			respostaIncorporarNouDocumentRDTO = modelMapper.map(respostaIncorporarNouDocumentTramitacioExpedientBDTO,
			        RespostaIncorporarNouDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaIncorporarNouDocumentRDTO;
	}

/**
	 * Signar document.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @return the resposta signar document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/signar")
	@ApiOperation(value = "Signar un document", tags = { "Serveis Portal API", "Funcions d'execució d'accions" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSignarDocumentRDTO signarDocument(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {

		if (log.isDebugEnabled()) {
			log.debug("signarDocument(String, BigDecimal) - inici"); //$NON-NLS-1$
		}

		RespostaSignarDocumentRDTO respostaSignarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SIGNAR_DOCUMENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_SIGNAR_DOCUMENT);

			// Registrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.SIGNAR_DOCUMENT, Resultat.ERROR_SIGNAR_DOCUMENT);

			// Firmar documento
			serveisService.signarDocument(idDocument);

		} catch (GPAApiParamValidationException e) {
			log.error("signarDocument(String, BigDecimal)", e); // $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("signarDocument(String, BigDecimal)", e); // $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_SIGNAR_DOCUMENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaSignarDocumentBDTO respostaSignarDocumentBDTO = new RespostaSignarDocumentBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaSignarDocumentRDTO = modelMapper.map(respostaSignarDocumentBDTO, RespostaSignarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("signarDocument(String, BigDecimal) - fi"); //$NON-NLS-1$
		}

		return respostaSignarDocumentRDTO;
	}
}