package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentTramitacioFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaCompletarDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaCompletarDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaPrepararRequerimentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaPresentarDeclaracioResponsableExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaRebutjarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaValidarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAccesBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsArxivarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsDocumentSignatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsNotificarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsPausarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsProposarResolucioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsReactivarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRegistrarComunicacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRetornarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsTancarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaResolucioValidarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaSignarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioRequeritsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UsuariPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AcumularExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarLaTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerValidationHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.common.BooleanApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.ConfiguracioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusAccionsPortaSigApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.MotiuPausaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.ConfiguracioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.MotiuPausaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.resolucio.validar.PersonaValidarResolucioDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.resolucio.validar.RespostaResolucioValidarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.PersonaSignarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaSignarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar.DocumentComplecioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar.RespostaCompletarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.DocumentDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.RespostaDigitalitzarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.DocumentIncorporacioNouRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.RespostaIncorporarNouDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.RequerimentPreparacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.RespostaPrepararRequerimentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.presentar.declaracio.responsable.DeclaracioResponsablePresentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.presentar.declaracio.responsable.RespostaPresentarDeclaracioResponsableRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.DocumentAportatRebutjarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.RespostaRebutjarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.DocumentAportatValidarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.RespostaValidarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acces.ExpedientAccesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acces.RespostaAccesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular.ExpedientAcumulacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular.RespostaAcumularExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.arxivar.ExpedientArxiuRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.arxivar.RespostaArxivarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.comunicar.ExpedientComunicatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.comunicar.RespostaRegistrarComunicacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.ExpedientNotificacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.RespostaNotificarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.ExpedientPausaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.RespostaPausarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar.ExpedientReactivacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar.RespostaReactivarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar.ExpedientPropostaResolucioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar.RespostaProposarResolucioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.signat.ExpedientDocumentSignatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.signat.RespostaDocumentSignatExpedientRDTO;
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
	@ApiOperation(value = "Validar la sol·licitud de l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
	@ApiOperation(value = "Pausar la tramitació de l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPausarExpedientRDTO pausarExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la pausa de l'expedient", required = true) @RequestBody ExpedientPausaRDTO expedientPausa)
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

			// Si se indica una fecha límite, debe ser posterior a la fecha
			// actual
			ServeisRestControllerValidationHelper.validateDataLimit(expedientPausa.getDataLimit(), Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Pausar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.PAUSAR_EXPEDIENT, Resultat.ERROR_PAUSAR_EXPEDIENT);

			// Cambio de estado del expediente y actualización de fechas de
			// límite de plazo
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			// Desde el estado 4 se puede transicionar al 5 o 6 en función del
			// motivo
			expedientCanviEstatAccio.setOperacio(expedientPausa.getMotiu());
			if (StringUtils.isNotEmpty(expedientPausa.getDataLimit())) {
				DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
				DateTime valorDataHora = DateTime.parse(expedientPausa.getDataLimit(), dataHoraFormatter);
				MotiuPausaApiParamValueTranslator motiuPausaApiParamValueTranslator = new MotiuPausaApiParamValueTranslator();
				MotiuPausaApiParamValue motiuPausaApiParamValue = motiuPausaApiParamValueTranslator
						.getEnumByApiParamValue(expedientPausa.getMotiu());
				switch (motiuPausaApiParamValue) {
				case TRAMIT_ALLEGACIONS:
					expedientCanviEstatAccio.setDataLimitAllegacio(valorDataHora);

					break;
				case REQUERIMENT_SUBSANACIO:
					expedientCanviEstatAccio.setDataLimitRequeriment(valorDataHora);

					break;
				default:
					break;
				}
			}
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.PAUSAR_EXPEDIENT.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

			// Se vuelve a consultar el expediente actualizado
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));

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
			"Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
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

			// Cambio de estado del expediente y actualización de fechas de
			// límite de plazo a null
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REACTIVAR_EXPEDIENT.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

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
	@ApiOperation(value = "Arxivar sol·licitud incompleta", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
	@ApiOperation(value = "Donar resposta a l'acció Convidar a tramitar", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
			"Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
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
	@ApiOperation(value = "Tancar l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
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
	@ApiOperation(value = "Tornar enrere", tags = { "Serveis Tramitadors API" }, extensions = {
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
	@ApiOperation(value = "Validar document de l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
	@ApiOperation(value = "Rebutjar document de l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
	@ApiOperation(value = "Convidar a tramitar l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
	@ApiOperation(value = "Canviar la unitat gestora de l’expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
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
	 * Incorporar nou document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param file
	 *            the file
	 * @param documentIncorporacioNou
	 *            the document incorporacio nou
	 * @return the resposta incorporar nou document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio")
	@ApiOperation(value = "Incorporar un nou document electrònic", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaIncorporarNouDocumentRDTO incorporarNouDocumentExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Fitxer") @RequestPart("file") MultipartFile file,
			@ApiParam(value = "Dades del document a incorporar") @RequestParam("document") DocumentIncorporacioNouRDTO documentIncorporacioNou)
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
			if (BooleanUtils.isTrue(esAportada)) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioEntradaIncorporatNou(
								respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
								documentIncorporacioNou.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentIncorporacioNou.getDocument(), DocsEntradaRDTO.class);
				docsEntradaRDTO
						.setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
				GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO, file);
				docsEntradaRDTOResult = serveisService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioTramitacioIncorporatNou(
								respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
								documentIncorporacioNou.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentIncorporacioNou.getDocument(), DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
						configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());
				GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO = new GuardarDocumentTramitacioFitxerBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO, file);
				docsTramitacioRDTOResult = serveisService.guardarDocumentTramitacioFitxer(guardarDocumentTramitacioFitxerBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO)", e);
			// $NON-NLS-1$
			if (e.getMessage() != null && e.getMessage().contains("Error OpenText:")) {
				respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT,
						ErrorPrincipal.ERROR_EXPEDIENTS_OPENTEXT, e.getMessage());
			} else {
				respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT,
						ErrorPrincipal.ERROR_GENERIC);
			}
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
					respostaResultatBDTO);
			respostaIncorporarNouDocumentRDTO = modelMapper.map(respostaIncorporarNouDocumentTramitacioExpedientBDTO,
					RespostaIncorporarNouDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("incorporarNouDocumentExpedientExpedient(String, DocumentIncorporacioNouRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaIncorporarNouDocumentRDTO;
	}

	/**
	 * Validar resolucio document.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocResolucio
	 *            the id doc resolucio
	 * @param persona
	 *            the persona
	 * @return the resposta resolucio validar document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/resolucio/{idDocResolucio}/validar")
	@ApiOperation(value = "Validar un document", tags = { "Serveis Portal API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaResolucioValidarDocumentRDTO validarResolucioDocument(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocResolucio,
			@ApiParam(value = "Persona que valida el document", required = true) @RequestBody PersonaValidarResolucioDocumentRDTO persona) {

		if (log.isDebugEnabled()) {
			log.debug("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaResolucioValidarDocumentRDTO respostaResolucioValidarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_VALIDAR_DOCUMENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_VALIDAR_DOCUMENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocResolucio);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
					Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			// Registrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.VALIDAR_DOCUMENT, Resultat.ERROR_VALIDAR_DOCUMENT);

			// Validar documento
			SignarDocument signarDocument = new SignarDocument();
			signarDocument.setIdDocument(idDocResolucio);
			signarDocument.setAccio(TipusAccionsPortaSigApiParamValue.VALIDAR_DOCUMENT.getInternalValue());
			// TODO Descomentar cuando se genere el cliente de documentación
			signarDocument.setUnitatGestoraIdext(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
			UsuariPortaSig usuariPortaSig = new UsuariPortaSig();
			usuariPortaSig.setMatricula(persona.getMatricula());
			usuariPortaSig.setNif(persona.getDocumentIdentitat());
			signarDocument.setUsuariPortaSig(usuariPortaSig);
			PeticionsPortasig peticionsPortasig = serveisService.signarValidarDocument(signarDocument);
			serveisService.signarValidarDocument(signarDocument);

		} catch (GPAApiParamValidationException e) {
			log.error("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO)", e); // $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO)", e); // $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_VALIDAR_DOCUMENT, ErrorPrincipal.ERROR_GENERIC);
		}

		// TODO: Modificar respuesta cuando PortSig devuelve descError y
		// codiError
		RespostaResolucioValidarDocumentBDTO respostaResolucioValidarDocumentBDTO = new RespostaResolucioValidarDocumentBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaResolucioValidarDocumentRDTO = modelMapper.map(respostaResolucioValidarDocumentBDTO,
				RespostaResolucioValidarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("validarResolucioDocument(String, BigDecimal, PersonaValidarResolucioDocumentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaResolucioValidarDocumentRDTO;
	}

	/**
	 * Signar document.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param persona
	 *            the persona
	 * @return the resposta signar document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/signar")
	@ApiOperation(value = "Signar un document", tags = { "Serveis Portal API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSignarDocumentRDTO signarDocument(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
			@ApiParam(value = "Persona que signa el document", required = true) @RequestBody PersonaSignarDocumentRDTO persona) {

		if (log.isDebugEnabled()) {
			log.debug("signarDocument(String, BigDecimal, PersonaSignarDocumentRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaSignarDocumentRDTO respostaSignarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SIGNAR_DOCUMENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_SIGNAR_DOCUMENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
					Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			// Registrar expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.SIGNAR_DOCUMENT, Resultat.ERROR_SIGNAR_DOCUMENT);

			// Firmar documento
			SignarDocument signarDocument = new SignarDocument();
			signarDocument.setIdDocument(idDocument);
			signarDocument.setAccio(TipusAccionsPortaSigApiParamValue.SIGNAR_DOCUMENT.getInternalValue());
			// TODO Descomentar cuando se genere el cliente de documentación
			signarDocument.setUnitatGestoraIdext(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
			UsuariPortaSig usuariPortaSig = new UsuariPortaSig();
			usuariPortaSig.setMatricula(persona.getMatricula());
			usuariPortaSig.setNif(persona.getDocumentIdentitat());
			signarDocument.setUsuariPortaSig(usuariPortaSig);
			PeticionsPortasig peticionsPortasig = serveisService.signarValidarDocument(signarDocument);
			serveisService.signarValidarDocument(signarDocument);

		} catch (GPAApiParamValidationException e) {
			log.error("signarDocument(String, BigDecimal, PersonaSignarDocumentRDTO)", e); // $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("signarDocument(String, BigDecimal, PersonaSignarDocumentRDTO)", e); // $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_SIGNAR_DOCUMENT, ErrorPrincipal.ERROR_GENERIC);
		}

		// TODO: Modificar respuesta cuando PortSig devuelve descError y
		// codiError
		RespostaSignarDocumentBDTO respostaSignarDocumentBDTO = new RespostaSignarDocumentBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaSignarDocumentRDTO = modelMapper.map(respostaSignarDocumentBDTO, RespostaSignarDocumentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("signarDocument(String, BigDecimal, PersonaSignarDocumentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaSignarDocumentRDTO;
	}

	/**
	 * Completar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentComplecio
	 *            the document complecio
	 * @return the resposta completar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/completar")
	@ApiOperation(value = "Completar un document", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaCompletarDocumentRDTO completarDocumentExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
			@ApiParam(value = "Dades del document a completar") @RequestBody DocumentComplecioRDTO documentComplecio)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaCompletarDocumentRDTO respostaCompletarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		Boolean esAportada = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_COMPLETAR_DOCUMENT_EXPEDIENT);
		try {
			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
					.getEnumByApiParamValue(documentComplecio.getDocument().getConfiguracio());
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
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			if (BooleanUtils.isTrue(esAportada)) {
				DocsEntradaRDTO docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
				ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO,
						Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);
			} else {
				DocsTramitacioRDTO docsTramitacioRDTO = serveisService.consultarDadesDocumentGenerat(idDocument);
				ServeisRestControllerValidationHelper.validateDocumentGenerat(docsTramitacioRDTO, dadesExpedientBDTO,
						Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);
			}

			// Completar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.COMPLETAR_DOCUMENT, Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

			// Completar documento, pudiéndose tratar de entrada o tramitación
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			if (BooleanUtils.isTrue(esAportada)) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioEntradaCompletat(
								respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(), documentComplecio.getDocument(),
								Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

				DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentComplecio.getDocument(), DocsEntradaRDTO.class);
				docsEntradaRDTO
						.setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
				ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO = new ActualitzarDocumentEntradaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
				docsEntradaRDTOResult = serveisService.actualitzarDocumentEntrada(actualitzarDocumentEntradaBDTO);
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioTramitacioCompletat(
								respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
								documentComplecio.getDocument(), Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT);

				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentComplecio.getDocument(), DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
						configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());
				ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO = new ActualitzarDocumentTramitacioBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO);
				docsTramitacioRDTOResult = serveisService.actualitzarDocumentTramitacio(actualitzarDocumentTramitacioBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_COMPLETAR_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		if (BooleanUtils.isTrue(esAportada)) {
			RespostaCompletarDocumentEntradaExpedientBDTO respostaCompletarDocumentEntradaExpedientBDTO = new RespostaCompletarDocumentEntradaExpedientBDTO(
					docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
					respostaResultatBDTO);
			respostaCompletarDocumentRDTO = modelMapper.map(respostaCompletarDocumentEntradaExpedientBDTO,
					RespostaCompletarDocumentRDTO.class);
		} else {
			RespostaCompletarDocumentTramitacioExpedientBDTO respostaCompletarDocumentTramitacioExpedientBDTO = new RespostaCompletarDocumentTramitacioExpedientBDTO(
					docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
					respostaResultatBDTO);
			respostaCompletarDocumentRDTO = modelMapper.map(respostaCompletarDocumentTramitacioExpedientBDTO,
					RespostaCompletarDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("completarDocumentExpedient(String, BigDecimal, DocumentComplecioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaCompletarDocumentRDTO;
	}

	/**
	 * Presentar declaracio responsable expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param declaracioResponsablePresentacio
	 *            the declaracio responsable presentacio
	 * @return the resposta presentar declaracio responsable RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/declaracio/responsable")
	@ApiOperation(value = "Presentar declaració responsable", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPresentarDeclaracioResponsableRDTO presentarDeclaracioResponsableExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades del document a incorporar") @RequestBody DeclaracioResponsablePresentacioRDTO declaracioResponsablePresentacio)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaPresentarDeclaracioResponsableRDTO respostaPresentarDeclaracioResponsableRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO,
					Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);

			// Incorporar un nuevo documento electrónico al expediente si la
			// acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.PRESENTAR_DECLARACIO_RESPONSABLE,
					Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);

			// Presentar Declaración Responsable
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
					dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
					.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
					.validateConfiguracioDocumentacioEntradaDeclaracioResponsablePresentada(
							respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
							declaracioResponsablePresentacio.getDocument(), Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT);

			DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(declaracioResponsablePresentacio.getDocument(), DocsEntradaRDTO.class);
			docsEntradaRDTO
					.setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
			docsEntradaRDTO.setDeclaracioResponsable(BooleanApiParamValue.TRUE.getInternalValue());
			CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO = new CrearDeclaracioResponsableBDTO(
					dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
			docsEntradaRDTOResult = serveisService.crearDeclaracioResponsable(crearDeclaracioResponsableBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT,
					ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaPresentarDeclaracioResponsableExpedientBDTO respostaPresentarDeclaracioResponsableExpedientBDTO = new RespostaPresentarDeclaracioResponsableExpedientBDTO(
				docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaPresentarDeclaracioResponsableRDTO = modelMapper.map(respostaPresentarDeclaracioResponsableExpedientBDTO,
				RespostaPresentarDeclaracioResponsableRDTO.class);
		if (log.isDebugEnabled()) {
			log.debug("presentarDeclaracioResponsableExpedient(String, DeclaracioResponsablePresentacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaPresentarDeclaracioResponsableRDTO;
	}

	/**
	 * Preparar requeriment expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param requerimentPreparacio
	 *            the requeriment preparacio
	 * @return the resposta preparar requeriment RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/requeriment")
	@ApiOperation(value = "Preparar un requeriment a l’interessat", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaPrepararRequerimentRDTO prepararRequerimentExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Fitxer") @RequestPart("file") MultipartFile file,
			@ApiParam(value = "Dades del requeriment a preparar") @RequestParam("requeriment") RequerimentPreparacioRDTO requerimentPreparacio)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaPrepararRequerimentRDTO respostaPrepararRequerimentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_PREPARAR_REQUERIMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT);

			// Preparar un requerimiento para el expediente si la acción es
			// permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.PREPARAR_REQUERIMENT_INTERESSAT, Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT);

			// Los Datos de Operación deben existir, estar asociados al
			// procedimiento y tener asociado el trámite OVT de Esmena. Se
			// aprovecha para recuperar los identificadores de los campos
			ArrayList<BigDecimal> idDadesOperacionsList = null;
			if (CollectionUtils.isNotEmpty(requerimentPreparacio.getDadesOperacioRequerits())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				RespostaDadesOperacioRequeritsCercaBDTO respostaDadesOperacioRequeritsCercaBDTO = serveisService
						.cercaDadesOperacioRequerits(dadesOperacioCercaBDTO);
				idDadesOperacionsList = ServeisRestControllerValidationHelper.validateDadesOperacioPrepararRequerimentExpedient(
						requerimentPreparacio.getDadesOperacioRequerits(),
						respostaDadesOperacioRequeritsCercaBDTO.getDadesOperacionsRDTOList());
			}

			// Las Configuraciones de Documentación deben existir, estar
			// asociados al procedimiento y tener asociado el trámite OVT de
			// Esmena
			ArrayList<BigDecimal> idConfiguracioDocsEntradaList = null;
			if (CollectionUtils.isNotEmpty(requerimentPreparacio.getDocumentacioRequerida())) {
				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(),
						TramitOvtApiParamValue.REQ.getInternalValue());
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO);
				idConfiguracioDocsEntradaList = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioPrepararRequerimentExpedient(requerimentPreparacio.getDocumentacioRequerida(),
								respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList());
			}

			// Preparar el requerimiento
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
					dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
			RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
					.cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
			HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
					.validateConfiguracioDocumentacioTramitacioRequerimentPreparat(
							respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
							requerimentPreparacio.getDocument(), Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT);

			DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(requerimentPreparacio.getDocument(), DocsTramitacioRDTO.class);
			docsTramitacioRDTO.setConfigDocTramitacio(
					configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());
			GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
			guardarRequerimentExpedient.setDocsTramitacio(docsTramitacioRDTO);
			guardarRequerimentExpedient.setIdsDadesOperList(idDadesOperacionsList);
			guardarRequerimentExpedient.setIdsConfDocEntradaList(idConfiguracioDocsEntradaList);
			GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO = new GuardarRequerimentFitxerBDTO(
					dadesExpedientBDTO.getExpedientsRDTO().getId(), guardarRequerimentExpedient, file);
			docsTramitacioRDTOResult = serveisService.guardarRequerimentFitxer(guardarRequerimentFitxerBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO)", e);
			// $NON-NLS-1$
			if (e.getMessage() != null && e.getMessage().contains("Error OpenText:")) {
				respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT,
						ErrorPrincipal.ERROR_EXPEDIENTS_OPENTEXT, e.getMessage());
			} else {
				respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT,
						ErrorPrincipal.ERROR_GENERIC);
			}
		}

		RespostaPrepararRequerimentExpedientBDTO respostaPrepararRequerimentExpedientBDTO = new RespostaPrepararRequerimentExpedientBDTO(
				docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaPrepararRequerimentRDTO = modelMapper.map(respostaPrepararRequerimentExpedientBDTO, RespostaPrepararRequerimentRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("prepararRequerimentExpedient(String, RequerimentPreparacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaPrepararRequerimentRDTO;
	}

	/**
	 * Acumular expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientAcumulacio
	 *            the expedient acumulacio
	 * @return the resposta acumular expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/acumular")
	@ApiOperation(value = "Acumular expedients", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAcumularExpedientRDTO acumularExpedient(
			@ApiParam(value = "Codi de l'expedient acumulador", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de l'acumulació d'expedient") @RequestBody ExpedientAcumulacioRDTO expedientAcumulacio)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("acumularExpedient(String, ExpedientAcumulacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaAcumularExpedientRDTO respostaAcumularExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientAcumulador = null;
		DadesExpedientBDTO dadesExpedientAcumular = null;
		List<DadesExpedientBDTO> dadesExpedientBDTOAcumulatsList = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACUMULAR_EXPEDIENT);
		try {
			// El codi del expediente acumulador debe existir y no debe estar ya
			// acumulado
			dadesExpedientAcumulador = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedientAcumulador(dadesExpedientAcumulador, Resultat.ERROR_ACUMULAR_EXPEDIENT);

			// El codi del expediente a acumular debe existir, ser diferente al
			// acumulador indicado, pertenecer al mismo procedimiento y no estar
			// ya acumulado a otro expediente
			dadesExpedientAcumular = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(expedientAcumulacio.getCodiExpedient(), expedientsIdOrgan));
			ExpedientsCercaAcumularBDTO expedientsCercaAcumularBDTO = new ExpedientsCercaAcumularBDTO(
					dadesExpedientAcumulador.getExpedientsRDTO().getProcedimentIdext());
			RespostaExpedientsCercaBDTO respostaExpedientsAcumularCercaBDTO = serveisService
					.cercaExpedientsAcumular(expedientsCercaAcumularBDTO);
			ServeisRestControllerValidationHelper.validateExpedientAcumular(dadesExpedientAcumulador, dadesExpedientAcumular,
					respostaExpedientsAcumularCercaBDTO.getDadesExpedientBDTOList(), Resultat.ERROR_ACUMULAR_EXPEDIENT);

			// Acumular expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientAcumulador,
					AccioTramitadorApiParamValue.ACUMULAR_EXPEDIENTS, Resultat.ERROR_ACUMULAR_EXPEDIENT);

			// Acumular expediente
			AcumularExpedientRDTO acumularExpedientRDTO = new AcumularExpedientRDTO();
			acumularExpedientRDTO.setIdExpedientAcumulador(dadesExpedientAcumulador.getExpedientsRDTO().getId());
			acumularExpedientRDTO.setCodiExpedientAcumulador(dadesExpedientAcumulador.getExpedientsRDTO().getCodi());
			HashMap<String, String> expedientsAcumulatsMap = new HashMap<String, String>();
			expedientsAcumulatsMap.put(dadesExpedientAcumular.getExpedientsRDTO().getId().toString(),
					dadesExpedientAcumular.getExpedientsRDTO().getCodi());
			acumularExpedientRDTO.setExpedientsAcumulats(expedientsAcumulatsMap);
			Comentaris comentaris = new Comentaris();
			comentaris.setDescripcio(expedientAcumulacio.getComentari());
			acumularExpedientRDTO.setComentari(comentaris);
			ExpedientsAcumularBDTO expedientsAcumularBDTO = new ExpedientsAcumularBDTO(acumularExpedientRDTO);
			serveisService.acumularExpedient(expedientsAcumularBDTO);

			// Se obtiene la lista actualizada de expedientes acumulados
			RespostaExpedientsCercaBDTO respostaExpedientsAcumulatsCercaBDTO = serveisService
					.cercaExpedientsAcumulats(dadesExpedientAcumulador.getExpedientsRDTO().getId());
			dadesExpedientBDTOAcumulatsList = respostaExpedientsAcumulatsCercaBDTO.getDadesExpedientBDTOList();

		} catch (GPAApiParamValidationException e) {
			log.error("acumularExpedient(String, ExpedientAcumulacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("acumularExpedient(String, ExpedientAcumulacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ACUMULAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsAcumularBDTO respostaExpedientsAcumularBDTO = new RespostaExpedientsAcumularBDTO(
				dadesExpedientAcumulador != null ? dadesExpedientAcumulador.getExpedientsRDTO() : null, dadesExpedientBDTOAcumulatsList,
				respostaResultatBDTO);
		respostaAcumularExpedientRDTO = modelMapper.map(respostaExpedientsAcumularBDTO, RespostaAcumularExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("acumularExpedient(String, ExpedientAcumulacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaAcumularExpedientRDTO;
	}

	/**
	 * Acces expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientAcces
	 *            the expedient acces
	 * @return the resposta acces expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/acces")
	@ApiOperation(value = "Accés a l'expedient (funcionari dona accés)", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAccesExpedientRDTO accesExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de l'accés a l'expedient") @RequestBody ExpedientAccesRDTO expedientAcces)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("accesExpedient(String, ExpedientAccesRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaAccesExpedientRDTO respostaAccesExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		PersonesSollicitudRDTO personesSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACCES_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
					.consultarDadesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ACCES_EXPEDIENT);

			// El documento de identidad debe corresponderse con el de una
			// persona implicada en el expediente
			personesSollicitudRDTO = ServeisRestControllerValidationHelper.validatePersonaImplicadaExpedient(dadesExpedientBDTO,
					expedientAcces.getDocumentIdentitat(), Resultat.ERROR_ACCES_EXPEDIENT);

			// Dar acceso al expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.ACCES_EXPEDIENT, Resultat.ERROR_ACCES_EXPEDIENT);

			// Se actualiza la persona indicada estableciendo el flag
			// VISIBILITAT_OVT a true
			personesSollicitudRDTO.setVisibilitatOvt(BooleanApiParamValue.TRUE.getInternalValue());
			serveisService.actualitzarDadesAltraPersonaImplicada(personesSollicitudRDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("accesExpedient(String, ExpedientAccesRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("accesExpedient(String, ExpedientAccesRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ACCES_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsAccesBDTO respostaExpedientsAccesBDTO = new RespostaExpedientsAccesBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaAccesExpedientRDTO = modelMapper.map(respostaExpedientsAccesBDTO, RespostaAccesExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("accesExpedient(String, ExpedientAccesRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaAccesExpedientRDTO;
	}

	/**
	 * Registrar comunicacio expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientComunicat
	 *            the expedient comunicat
	 * @return the resposta registrar comunicacio expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/comunicat")
	@ApiOperation(value = "Registrar comunicació de l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarComunicacioExpedientRDTO registrarComunicacioExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la comunicació de l'expedient") @RequestBody ExpedientComunicatRDTO expedientComunicat)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("registrarComunicacioExpedient(String, ExpedientComunicatRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaRegistrarComunicacioExpedientRDTO respostaRegistrarComunicacioExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REGISTRAR_COMUNICACIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT);

			// Registrar comunicación del expediente si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.REGISTRAR_COMUNICACIO, Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT);

			// TODO Negocio de la acción

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientComunicat.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REGISTRAR_COMUNICACIO.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("registrarComunicacioExpedient(String, ExpedientComunicatRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("registrarComunicacioExpedient(String, ExpedientComunicatRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsRegistrarComunicacioBDTO respostaExpedientsRegistrarComunicacioBDTO = new RespostaExpedientsRegistrarComunicacioBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaRegistrarComunicacioExpedientRDTO = modelMapper.map(respostaExpedientsRegistrarComunicacioBDTO,
				RespostaRegistrarComunicacioExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("registrarComunicacioExpedient(String, ExpedientComunicatRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaRegistrarComunicacioExpedientRDTO;
	}

	/**
	 * Notificar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientNotificacio
	 *            the expedient notificacio
	 * @return the resposta notificar expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/notificar")
	@ApiOperation(value = "Enviar notificació de l'expedient", tags = { "Serveis Tramitadors API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaNotificarExpedientRDTO notificarExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la notificació de l'expedient") @RequestBody ExpedientNotificacioRDTO expedientNotificacio)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("notificarExpedient(String, ExpedientNotificacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaNotificarExpedientRDTO respostaNotificarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		String idNotificacio = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_NOTIFICAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_NOTIFICAR_EXPEDIENT);

			// Notificar si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.NOTIFICAR, Resultat.ERROR_NOTIFICAR_EXPEDIENT);

			// TODO Negocio de la acción
			idNotificacio = null;

		} catch (GPAApiParamValidationException e) {
			log.error("notificarExpedient(String, ExpedientNotificacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("notificarExpedient(String, ExpedientNotificacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_NOTIFICAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsNotificarBDTO respostaExpedientsNotificarBDTO = new RespostaExpedientsNotificarBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO, idNotificacio);
		respostaNotificarExpedientRDTO = modelMapper.map(respostaExpedientsNotificarBDTO, RespostaNotificarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("notificarExpedient(String, ExpedientNotificacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaNotificarExpedientRDTO;
	}

	/**
	 * Document signat expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientDocumentSignat
	 *            the expedient document signat
	 * @return the resposta document signat expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/signat")
	@ApiOperation(value = "Força el canvi d'estat de l'expedient a Finzalizado i Comunicat després de la signatura dels documents", tags = {
			"Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaDocumentSignatExpedientRDTO documentSignatExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de l'expedient amb document signat") @RequestBody ExpedientDocumentSignatRDTO expedientDocumentSignat)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("documentSignatExpedient(String, ExpedientDocumentSignatRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaDocumentSignatExpedientRDTO respostaDocumentSignatExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_DOCUMENT_SIGNAT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT);

			// Documento firmado si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.DOCUMENT_SIGNAT, Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
					ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
					dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.DOCUMENT_SIGNAT.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

			// TODO Fechas fin de plazo a null

		} catch (GPAApiParamValidationException e) {
			log.error("documentSignatExpedient(String, ExpedientDocumentSignatRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("documentSignatExpedient(String, ExpedientDocumentSignatRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsDocumentSignatBDTO respostaExpedientsDocumentSignatBDTO = new RespostaExpedientsDocumentSignatBDTO(
				dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaDocumentSignatExpedientRDTO = modelMapper.map(respostaExpedientsDocumentSignatBDTO,
				RespostaDocumentSignatExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("documentSignatExpedient(String, ExpedientDocumentSignatRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaDocumentSignatExpedientRDTO;
	}

	/**
	 * Digitalitzar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param documentDigitalitzacio
	 *            the document digitalitzacio
	 * @return the resposta digitalitzar document RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/digitalitzar")
	@ApiOperation(value = "Força el canvi d'estat de l'expedient a Finzalizado i Comunicat després de la signatura dels documents", tags = {
			"Serveis Tramitadors API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
					@ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaDigitalitzarDocumentRDTO digitalitzarDocumentExpedient(
			@ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
			@ApiParam(value = "Dades de la digitalització del document de l'expedient") @RequestBody DocumentDigitalitzacioRDTO documentDigitalitzacio)
			throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaDigitalitzarDocumentRDTO respostaDigitalitzarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RegistreAssentamentRDTO registreAssentamentRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResult = null;
		DocsTramitacioRDTO docsTramitacioRDTOResult = null;
		Boolean esAportada = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_DOCUMENT_DIGITALITZAT_EXPEDIENT);
		try {
			ConfiguracioApiParamValueTranslator configuracioApiParamValueTranslator = new ConfiguracioApiParamValueTranslator();
			ConfiguracioApiParamValue configuracioApiParamValue = configuracioApiParamValueTranslator
					.getEnumByApiParamValue(documentDigitalitzacio.getDocument().getConfiguracio());
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
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);

			// El número de registro indicado debe existir
			registreAssentamentRDTO = serveisService
					.consultarDadesRegistreAssentament(documentDigitalitzacio.getDocument().getNumeroRegistre());
			ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
					Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

			// Digitalizar documento si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.DIGITALITZAR_DOCUMENT, Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT);

			// Digitalizar un documento, pudiéndose tratar de entrada o
			// tramitación
			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			if (BooleanUtils.isTrue(esAportada)) {
				// El número de registro indicado debe existir
				registreAssentamentRDTO = serveisService
						.consultarDadesRegistreAssentament(documentDigitalitzacio.getDocument().getNumeroRegistre());
				ServeisRestControllerValidationHelper.validateRegistreAssentament(registreAssentamentRDTO,
						Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
				RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
				HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaMap = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioEntradaDigitalitzar(
								respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
								documentDigitalitzacio.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentDigitalitzacio.getDocument(), DocsEntradaRDTO.class);
				docsEntradaRDTO
						.setConfigDocEntrada(configuracioDocsEntradaMap.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
				docsEntradaRDTO.setRegistreIdext(registreAssentamentRDTO.getId());

				CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO = new CrearDocumentEntradaDigitalitzarBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
				docsEntradaRDTOResult = serveisService.crearDocumentEntradaDigitalitzat(crearDocumentEntradaDigitalitzarBDTO);
			} else {
				DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO = new DocumentsTramitacioCercaBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc());
				RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = serveisService
						.cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
				HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioMap = ServeisRestControllerValidationHelper
						.validateConfiguracioDocumentacioTramitacioDigitalitzar(
								respostaDocumentsTramitacioCercaBDTO.getConfiguracioDocsTramitacioRDTOList(),
								documentDigitalitzacio.getDocument(), Resultat.ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT);

				DocsTramitacioRDTO docsTramitacioRDTO = modelMapper.map(documentDigitalitzacio.getDocument(), DocsTramitacioRDTO.class);
				docsTramitacioRDTO.setConfigDocTramitacio(
						configuracioDocsTramitacioMap.get(String.valueOf(docsTramitacioRDTO.getConfigDocTramitacio())).getId());
				CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO = new CrearDocumentTramitacioDigitalitzarBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), docsTramitacioRDTO);
				docsTramitacioRDTOResult = serveisService.crearDocumentTramitacioDigitalitzat(crearDocumentTramitacioDigitalitzarBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		if (BooleanUtils.isTrue(esAportada)) {
			RespostaDigitalitzarDocumentEntradaBDTO respostaDigitalitzarDocumentExpedientBDTO = new RespostaDigitalitzarDocumentEntradaBDTO(
					docsEntradaRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
					registreAssentamentRDTO, respostaResultatBDTO);
			respostaDigitalitzarDocumentRDTO = modelMapper.map(respostaDigitalitzarDocumentExpedientBDTO,
					RespostaDigitalitzarDocumentRDTO.class);
		} else {
			RespostaDigitalitzarDocumentTramitacioBDTO respostaDigitalitzarDocumentTramitacioBDTO = new RespostaDigitalitzarDocumentTramitacioBDTO(
					docsTramitacioRDTOResult, dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null,
					registreAssentamentRDTO, respostaResultatBDTO);
			respostaDigitalitzarDocumentRDTO = modelMapper.map(respostaDigitalitzarDocumentTramitacioBDTO,
					RespostaDigitalitzarDocumentRDTO.class);
		}

		if (log.isDebugEnabled()) {
			log.debug("digitalitzarDocumentExpedient(String, DocumentDigitalitzacioRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaDigitalitzarDocumentRDTO;
	}

}