package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.ServeisPortalService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaRegistrarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.ProcedimentsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs.DadesOperacioApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.documents.DocumentsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatCiutadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.VersioProcedimentApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.ActivableEnFormatElectronicApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.CompetenciaAssociadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.EstatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.ExclusivamentInternApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.FamiliaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitOvtApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitadorApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.DocumentAportatSubstituirRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.RespostaSubstituirDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar.ExpedientAbandonamentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar.RespostaAbandonarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.acces.RespostaAccesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.comunicacio.ExpedientComunicatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.comunicacio.RespostaRegistrarComunicacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.ExpedientEsmenaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.RespostaEsmenarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.RespostaActualitzarSolicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.SolicitudsActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.RespostaCercaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.RespostaCercaProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.DadesOperacioConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.RespostaConsultaDadesOperacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioAportadaConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentAportatConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.RespostaConsultaConfiguracioDocumentacioAportadaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.RespostaConsultaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.RespostaConsultaProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.RespostaCrearSolicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.SolicitudsCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud.RespostaRegistrarSolicitudsRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.rest.http.HttpHeaders;
import net.opentrends.openframe.services.rest.http.ResponseEntity;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/portal", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Portal API", tags = "Serveis Portal API")
@CommonsLog
public class ServeisPortalRestController extends BaseRestController {

	/** The resposta registrar solicitud mock service. */
	@Autowired
	private RespostaRegistrarSolicitudMockService respostaRegistrarSolicitudMockService;

	/** The serveis portal service. */
	@Autowired
	private ServeisPortalService serveisPortalService;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Cerca procediments.
	 *
	 * @param resultatsPerPagina
	 *            the resultats per pagina
	 * @param numeroPagina
	 *            the numero pagina
	 * @param ordenarPer
	 *            the ordenar per
	 * @param sentitOrdenacio
	 *            the sentit ordenacio
	 * @param codi
	 *            the codi
	 * @param estat
	 *            the estat
	 * @param nom
	 *            the nom
	 * @param tramitador
	 *            the tramitador
	 * @param aplicacioNegoci
	 *            the aplicacio negoci
	 * @param ugr
	 *            the ugr
	 * @param exclusivamentIntern
	 *            the exclusivament intern
	 * @param activableFormatElectronic
	 *            the activable format electronic
	 * @param organResolutori
	 *            the organ resolutori
	 * @param competenciaAssociada
	 *            the competencia associada
	 * @param familia
	 *            the familia
	 * @param actuacio
	 *            the actuacio
	 * @return the resposta cerca procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/procediments")
	@ApiOperation(value = "Cerca de procediments", tags = { "Serveis Portal API", "Funcions d'integració amb RPA" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCercaProcedimentsRDTO cercaProcediments(
	        @ApiParam(value = "Indicarà el número de resultats per pàgina") @RequestParam(value = "resultatsPerPagina", required = false, defaultValue = "20") int resultatsPerPagina,
	        @ApiParam(value = "Indicarà en quina pàgina hauria de començar els resultats demanats en una cerca") @RequestParam(value = "numeroPagina", required = false, defaultValue = "1") int numeroPagina,
	        @ApiParam(value = "Indicarà el camp mitjançant el qual s'ordenarà el resultat de la cerca", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String ordenarPer,
	        @ApiParam(value = "Indicarà el sentit d'ordenació per al resultat de la cerca", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String sentitOrdenacio,
	        @ApiParam(value = "Filtra procediments per codi") @RequestParam(value = "codi", required = false) String codi,
	        @ApiParam(value = "Filtrar procediments per conjunt d'estats", allowableValues = EstatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = EstatApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] estat,
	        @ApiParam(value = "Filtra procediments per nom") @RequestParam(value = "nom", required = false) String nom,
	        @ApiParam(value = "Filtra procediments per aplicació de tramitació", allowableValues = TramitadorApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = TramitadorApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String tramitador,
	        @ApiParam(value = "En cas que el tramitador sigui una aplicació de negoci, filtra procediments pel nom de dita aplicació") @RequestParam(value = "aplicacioNegoci", required = false) String aplicacioNegoci,
	        @ApiParam(value = "Filtra procediments per conjunt d'Unitats Gestores Responsables") @RequestParam(value = "ugr", required = false) String ugr,
	        @ApiParam(value = "Filtra procediments per exclusivament intern", allowableValues = ExclusivamentInternApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = ExclusivamentInternApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String exclusivamentIntern,
	        @ApiParam(value = "Filtra procediments per canals d'activació en format electrònic", allowableValues = ActivableEnFormatElectronicApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = ActivableEnFormatElectronicApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] activableFormatElectronic,
	        @ApiParam(value = "Filtra procediments per òrgan resolutori") @RequestParam(value = "organResolutori", required = false) String organResolutori,
	        @ApiParam(value = "Filtrar procediments per conjunt de competències associades", allowableValues = CompetenciaAssociadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = CompetenciaAssociadaApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] competenciaAssociada,
	        @ApiParam(value = "Filtrar procediments per conjunt de famílies", allowableValues = FamiliaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = FamiliaApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] familia,
	        @ApiParam(value = "Filtra procediments per actuació") @RequestParam(value = "actuacio", required = false) String actuacio)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug(
			        "cercaProcediments(int, int, String, String, String, String[], String, String, String, String, String, String[], String, String[], String[], String) - inici"); //$NON-NLS-1$
		}

		RespostaCercaProcedimentsRDTO resposta = new RespostaCercaProcedimentsRDTO();
		List<ProcedimentsCercaRDTO> procedimentsCercaRDTOList = new ArrayList<ProcedimentsCercaRDTO>();

		// Data
		// Unitats Gestores que hacen match con el parámetro ugr
		UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(ugr);
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = serveisPortalService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);

		// Procediments que cumplen los criterios de búsqueda
		ProcedimentsCercaBDTO procedimentsCercaBDTO = new ProcedimentsCercaBDTO(codi, nom,
		        ProcedimentsApiParamToInternalMapper.getActivableFormatElectronicInternalValueList(activableFormatElectronic), actuacio,
		        ProcedimentsApiParamToInternalMapper.getTramitadorInternalValue(tramitador), aplicacioNegoci,
		        ProcedimentsApiParamToInternalMapper.getCompetenciaAssociadaInternalValueList(competenciaAssociada),
		        ProcedimentsApiParamToInternalMapper.getEstatInternalValueList(estat),
		        ProcedimentsApiParamToInternalMapper.getFamiliaInternalValueList(familia),
		        ProcedimentsApiParamToInternalMapper.getExclusivamentInternInternalValue(exclusivamentIntern), organResolutori,
		        ProcedimentsApiParamToInternalMapper.getIdUnitatGestoraInternalValueList(unitatsGestoresRDTOList), numeroPagina,
		        resultatsPerPagina, ProcedimentsApiParamToInternalMapper.getOrdenarPerInternalValue(ordenarPer),
		        ProcedimentsApiParamToInternalMapper.getSentitOrdenacioInternalValue(sentitOrdenacio));

		RespostaProcedimentsCercaBDTO respostaProcedimentsCercaBDTO = serveisPortalService.cercaProcediments(procedimentsCercaBDTO);

		for (DadesProcedimentBDTO dadesProcedimentBDTO : respostaProcedimentsCercaBDTO.getDadesProcedimentBDTOList()) {
			procedimentsCercaRDTOList.add(modelMapper.map(dadesProcedimentBDTO, ProcedimentsCercaRDTO.class));
		}
		resposta.setData(procedimentsCercaRDTOList);

		// Paginació
		resposta.setPaginacio(modelMapper.map(respostaProcedimentsCercaBDTO.getPaginationAttributes(), PaginacioRDTO.class));

		if (log.isDebugEnabled()) {
			log.debug(
			        "cercaProcediments(int, int, String, String, String, String[], String, String, String, String, String, String[], String, String[], String[], String) - fi"); //$NON-NLS-1$
		}
		return resposta;
	}

	/**
	 * Consultar dades procediment.
	 *
	 * @param codiProcediment
	 *            the codi procediment
	 * @return the resposta consulta procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/procediments/{codiProcediment}")
	@ApiOperation(value = "Consultar les dades del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaProcedimentsRDTO consultarDadesProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable String codiProcediment)
	        throws GPAServeisServiceException {

		RespostaConsultaProcedimentsRDTO respostaConsultaProcedimentsRDTO = new RespostaConsultaProcedimentsRDTO();

		DadesProcedimentBDTO dadesProcedimentBDTO = serveisPortalService.consultarDadesProcediment(codiProcediment);
		ProcedimentsConsultaRDTO procedimentsConsultaRDTO = modelMapper.map(dadesProcedimentBDTO, ProcedimentsConsultaRDTO.class);
		respostaConsultaProcedimentsRDTO.setProcediment(procedimentsConsultaRDTO);

		return respostaConsultaProcedimentsRDTO;
	}

	/**
	 * Consultar dades operacio procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @param codiTramit
	 *            the codi tramit
	 * @return the resposta consulta dades operacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/procediments/{idProcediment}/tramits/{codiTramit}/atributs")
	@ApiOperation(value = "Consultar les dades d'operació del tràmit", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaDadesOperacioRDTO consultarDadesOperacioTramit(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Codi del tràmit", allowableValues = TramitOvtApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true) @PathVariable String codiTramit)
	        throws GPAServeisServiceException {

		RespostaConsultaDadesOperacioRDTO respostaConsultaDadesOperacioRDTO = new RespostaConsultaDadesOperacioRDTO();
		DadesOperacioConsultaRDTO dadesOperacioConsultaRDTO = new DadesOperacioConsultaRDTO();

		// Información del Trámite
		TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
		        DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = serveisPortalService
		        .consultarDadesTramitOvt(tramitsOvtCercaBDTO);
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper.map(internalTramitsOvtRDTO,
		        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
		respostaConsultaDadesOperacioRDTO.setTramit(tramitsOvtRDTO);

		// Dades Operacio que cumplen los criterios de búsqueda
		DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(idProcediment,
		        DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = serveisPortalService.cercaDadesOperacio(dadesOperacioCercaBDTO);
		dadesOperacioConsultaRDTO = modelMapper.map(respostaDadesOperacioCercaBDTO, DadesOperacioConsultaRDTO.class);
		respostaConsultaDadesOperacioRDTO.setDadesOperacio(dadesOperacioConsultaRDTO);

		return respostaConsultaDadesOperacioRDTO;
	}

	/**
	 * Consultar documentacio entrada procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @param codiTramit
	 *            the codi tramit
	 * @return the resposta consulta configuracio documentacio aportada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/procediments/{idProcediment}/tramits/{codiTramit}/documentacio")
	@ApiOperation(value = "Consultar les dades de documentació d'entrada del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaConfiguracioDocumentacioAportadaRDTO consultarDocumentacioEntradaProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Codi del tràmit", allowableValues = TramitOvtApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true) @PathVariable String codiTramit)
	        throws GPAServeisServiceException {

		RespostaConsultaConfiguracioDocumentacioAportadaRDTO respostaConsultaConfiguracioDocumentacioAportadaRDTO = new RespostaConsultaConfiguracioDocumentacioAportadaRDTO();

		// Información del Trámite
		TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
		        DocumentsApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = serveisPortalService
		        .consultarDadesTramitOvt(tramitsOvtCercaBDTO);
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper.map(internalTramitsOvtRDTO,
		        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
		respostaConsultaConfiguracioDocumentacioAportadaRDTO.setTramit(tramitsOvtRDTO);

		// Información del Procedimiento, para obtener el Id de Configuració
		// Documentació
		DadesProcedimentBDTO dadesProcedimentBDTO = serveisPortalService.consultarDadesBasiquesProcediment(idProcediment);

		// Documents que cumplen los criterios de búsqueda
		DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
		        dadesProcedimentBDTO.getProcedimentsRDTO().getConfiguracioDocumentacio(),
		        DocumentsApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisPortalService
		        .cercaDocumentsEntrada(documentsEntradaCercaBDTO);
		ArrayList<ConfiguracioDocumentacioAportadaConsultaRDTO> configuracioDocumentacioAportadaConsultaRDTOList = new ArrayList<ConfiguracioDocumentacioAportadaConsultaRDTO>();
		for (ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO : respostaDocumentsEntradaCercaBDTO
		        .getConfiguracioDocsEntradaRDTOList()) {
			configuracioDocumentacioAportadaConsultaRDTOList
			        .add(modelMapper.map(configuracioDocsEntradaRDTO, ConfiguracioDocumentacioAportadaConsultaRDTO.class));
		}
		respostaConsultaConfiguracioDocumentacioAportadaRDTO
		        .setConfiguracioDocumentacioAportada(configuracioDocumentacioAportadaConsultaRDTOList);

		return respostaConsultaConfiguracioDocumentacioAportadaRDTO;
	}

	/**
	 * Cerca expedients.
	 *
	 * @param resultatsPerPagina
	 *            the resultats per pagina
	 * @param numeroPagina
	 *            the numero pagina
	 * @param ordenarPer
	 *            the ordenar per
	 * @param sentitOrdenacio
	 *            the sentit ordenacio
	 * @param codiExpedient
	 *            the codi expedient
	 * @param nifSollicitant
	 *            the nif sollicitant
	 * @param dataPresentacioInici
	 *            the data presentacio inici
	 * @param dataPresentacioFi
	 *            the data presentacio fi
	 * @param codiProcediment
	 *            the codi procediment
	 * @param versioProcediment
	 *            the versio procediment
	 * @param estat
	 *            the estat
	 * @param unitatGestora
	 *            the unitat gestora
	 * @param tramitador
	 *            the tramitador
	 * @param aplicacioNegoci
	 *            the aplicacio negoci
	 * @return the resposta cerca expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/expedients")
	@ApiOperation(value = "Cerca d'expedients", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCercaExpedientsRDTO cercaExpedients(
	        @ApiParam(value = "Indicarà el número de resultats per pàgina") @RequestParam(value = "resultatsPerPagina", required = false, defaultValue = "20") int resultatsPerPagina,
	        @ApiParam(value = "Indicarà en quina pàgina hauria de començar els resultats demanats en una cerca") @RequestParam(value = "numeroPagina", required = false, defaultValue = "1") int numeroPagina,
	        @ApiParam(value = "Indicarà el camp mitjançant el qual s'ordenarà el resultat de la cerca", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.OrdenarPerApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String ordenarPer,
	        @ApiParam(value = "Indicarà el sentit d'ordenació per al resultat de la cerca", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String sentitOrdenacio,
	        @ApiParam(value = "Filtra expedients per codi") @RequestParam(value = "codiExpedient", required = false) String codiExpedient,
	        @ApiParam(value = "Filtra expedients per sollicitant") @RequestParam(value = "nifSollicitant", required = false) String nifSollicitant,
	        @ApiParam(value = "Filtra expedients per data de presentació (format dd/MM/aaaa)") @RequestParam(value = "dataPresentacioInici", required = false) String dataPresentacioInici,
	        @ApiParam(value = "Filtra expedients per data de presentació (format dd/MM/aaaa)") @RequestParam(value = "dataPresentacioFi", required = false) String dataPresentacioFi,
	        @ApiParam(value = "Filtra expedients per un conjunt de codis de procediment") @RequestParam(value = "codiProcediment", required = false) String[] codiProcediment,
	        @ApiParam(value = "En cas que s'indiqui codi de procediment, filtra expedients per versió de procediment", allowableValues = VersioProcedimentApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = VersioProcedimentApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = VersioProcedimentApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String versioProcediment,
	        @ApiParam(value = "Filtrar procediments per conjunt d'estats", allowableValues = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] estat,
	        @ApiParam(value = "Filtra expedients per Unitat Gestora") @RequestParam(value = "unitatGestora", required = false) String unitatGestora,
	        @ApiParam(value = "Filtra procediments per aplicació de tramitació", allowableValues = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TramitadorApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TramitadorApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String tramitador,
	        @ApiParam(value = "En cas que el tramitador sigui una aplicació de negoci, filtra procediments pel nom de dita aplicació") @RequestParam(value = "aplicacioNegoci", required = false) String aplicacioNegoci)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug(
			        "cercaExpedients(int, int, String, String, String, String, String, String, String[], String, String[], String, String, String) - inici"); //$NON-NLS-1$
		}

		RespostaCercaExpedientsRDTO resposta = new RespostaCercaExpedientsRDTO();
		List<ExpedientsCercaRDTO> expedientsCercaRDTOList = new ArrayList<ExpedientsCercaRDTO>();

		// Data
		// Unitats Gestores que hacen match con el parámetro unitatGestora
		UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(unitatGestora);
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = serveisPortalService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);

		// Expedients que cumplen los criterios de búsqueda
		ExpedientsCercaBDTO expedientsCercaBDTO = new ExpedientsCercaBDTO(codiExpedient, nifSollicitant,
		        ExpedientsApiParamToInternalMapper.getDataPresentacioIniciInternalValue(dataPresentacioInici),
		        ExpedientsApiParamToInternalMapper.getDataPresentacioFiInternalValue(dataPresentacioFi),
		        ExpedientsApiParamToInternalMapper.getCodiProcedimentInternalValueList(codiProcediment),
		        ExpedientsApiParamToInternalMapper.getVersioProcedimentInternalValue(versioProcediment),
		        ExpedientsApiParamToInternalMapper.getEstatCiutadaInternalValueList(estat),
		        ExpedientsApiParamToInternalMapper.getIdUnitatGestoraInternalValueList(unitatsGestoresRDTOList),
		        ExpedientsApiParamToInternalMapper.getTramitadorInternalValue(tramitador), aplicacioNegoci, numeroPagina,
		        resultatsPerPagina, ExpedientsApiParamToInternalMapper.getOrdenarPerInternalValue(ordenarPer),
		        ExpedientsApiParamToInternalMapper.getSentitOrdenacioInternalValue(sentitOrdenacio));

		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = serveisPortalService.cercaExpedients(expedientsCercaBDTO);

		for (DadesExpedientBDTO dadesExpedientBDTO : respostaExpedientsCercaBDTO.getDadesExpedientBDTOList()) {
			expedientsCercaRDTOList.add(modelMapper.map(dadesExpedientBDTO, ExpedientsCercaRDTO.class));
		}
		resposta.setData(expedientsCercaRDTOList);

		// Paginació
		resposta.setPaginacio(modelMapper.map(respostaExpedientsCercaBDTO.getPaginationAttributes(), PaginacioRDTO.class));

		if (log.isDebugEnabled()) {
			log.debug(
			        "cercaExpedients(int, int, String, String, String, String, String, String, String[], String, String[], String, String, String) - fi"); //$NON-NLS-1$
		}
		return resposta;
	}

	/**
	 * Consultar dades expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the resposta consulta expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Consultar les dades de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaExpedientsRDTO consultarDadesExpedient(
	        @ApiParam(value = "Identificador del codi de l'expedient", required = true) @PathVariable String idExpedient)
	        throws GPAServeisServiceException {

		RespostaConsultaExpedientsRDTO respostaConsultaExpedientsRDTO = new RespostaConsultaExpedientsRDTO();

		// Decode codiExpedient. Puede contener espacios y barras
		String codiExpedientDecoded = null;
		try {
			codiExpedientDecoded = URLDecoder.decode(idExpedient, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			log.error("getExpedientByCodi(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e);
		}

		// Datos principales del expedient
		DadesExpedientBDTO dadesExpedientBDTO = serveisPortalService.consultarDadesExpedient(codiExpedientDecoded);
		ExpedientConsultaRDTO expedientConsultaRDTO = modelMapper.map(dadesExpedientBDTO, ExpedientConsultaRDTO.class);

		// Datos de cada tràmit OVT asociado a los documents aportats
		HashMap<String, es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO> tramitsOvtRDTOMap = null;
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = null;
		if (MapUtils.isNotEmpty(dadesExpedientBDTO.getTramitsOvtMap())) {
			tramitsOvtRDTOMap = new HashMap<String, es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO>();
			for (Entry<BigDecimal, TramitsOvtRDTO> tramitsOvtRDTOEntry : dadesExpedientBDTO.getTramitsOvtMap().entrySet()) {
				tramitsOvtRDTO = modelMapper.map(tramitsOvtRDTOEntry.getValue(),
				        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
				tramitsOvtRDTOMap.put(tramitsOvtRDTO.getCodi(), tramitsOvtRDTO);
			}
			if (CollectionUtils.isNotEmpty(expedientConsultaRDTO.getDocumentsAportats()) && MapUtils.isNotEmpty(tramitsOvtRDTOMap)) {
				for (DocumentAportatConsultaRDTO documentAportatConsultaRDTO : expedientConsultaRDTO.getDocumentsAportats()) {
					if (documentAportatConsultaRDTO.getTramit() != null) {
						documentAportatConsultaRDTO.setTramit(tramitsOvtRDTOMap.get(documentAportatConsultaRDTO.getTramit().getCodi()));
					}
				}
			}
		}

		respostaConsultaExpedientsRDTO.setExpedient(expedientConsultaRDTO);

		return respostaConsultaExpedientsRDTO;
	}
	
	
	
	/**
	 * Descarregar docuemnt expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta registrar solicituds RDTO
	 */
	@GetMapping("/expedients/{idExpedient}/documents/{idDocument}")
	@ApiOperation(value = "Descarregar document de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public ResponseEntity<byte[]> descarregarDocumentExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {

		byte[] result = "test".getBytes();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	    headers.add("Pragma", "no-cache");
	    headers.add("Expires", "0");
		headers.add("Content-Length", String.valueOf(result.length));
		headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
		headers.add("Content-Disposition", "attachment; filename=\"test.dat\"");
		
		return new ResponseEntity<byte[]>(result, headers, HttpStatus.OK);
			
	}
	

	/**
	 * Crear solicitud expedient.
	 *
	 * @param solicitudExpedient
	 *            the solicitud expedient
	 * @return the resposta crear solicituds RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients")
	@ApiOperation(value = "Crear una sol·licitud d'un expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCrearSolicitudsRDTO crearSolicitudExpedient(
	        @ApiParam(value = "Dades de la creació de l'expedient") @RequestBody SolicitudsCrearRDTO solicitudExpedient)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearSolicitudExpedient(SolicitudsCrearRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaCrearSolicitudsRDTO respostaCrearSolicitudsRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CREAR_EXPEDIENT);
		try {
			// El id del procedimiento debe existir y el procedimiento debe
			// encontrarse en estado Publicat
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisPortalService
			        .consultarDadesBasiquesProcediment(solicitudExpedient.getProcediment().getId());
			ServeisPortalRestControllerValidationHelper.validateProcedimentCrearSolicitudExpedient(dadesProcedimentBDTO);

			// El codi de la unitat gestora, opcional, debe existir y estar
			// vigente
			BigDecimal idUnitatGestora = null;
			if (solicitudExpedient.getUnitatGestora() != null) {
				UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
				        solicitudExpedient.getUnitatGestora().getCodi());
				UnitatsGestoresRDTO unitatsGestoresRDTO = serveisPortalService.consultaDadesUnitatGestora(unitatsGestoresCercaBDTO);
				ServeisPortalRestControllerValidationHelper.validateUnitatGestoraCrearSolicitudExpedient(unitatsGestoresRDTO,
				        dadesProcedimentBDTO);
				idUnitatGestora = unitatsGestoresRDTO.getId();
			} else {
				// Si no se indica, se establece la UGR del procedimiento
				idUnitatGestora = dadesProcedimentBDTO.getUgrRDTO().getId();
			}

			ExpedientsRDTO expedientsRDTO = modelMapper.map(solicitudExpedient, ExpedientsRDTO.class);
			// Se debe indicar el id de la Unitat Gestora recuperada
			expedientsRDTO.setUnitatGestoraIdext(idUnitatGestora);
			ExpedientsCrearBDTO expedientsCrearBDTO = new ExpedientsCrearBDTO(expedientsRDTO);

			returnExpedientsRDTO = serveisPortalService.crearSollicitudExpedient(expedientsCrearBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("crearSolicitudExpedient(SolicitudsCrearRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("crearSolicitudExpedient(SolicitudsCrearRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsCrearBDTO respostaExpedientsCrearBDTO = new RespostaExpedientsCrearBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaCrearSolicitudsRDTO = modelMapper.map(respostaExpedientsCrearBDTO, RespostaCrearSolicitudsRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("crearSolicitudExpedient(SolicitudsCrearRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaCrearSolicitudsRDTO;
	}

	/**
	 * Actualitzar solicitud expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @param solicitudExpedient
	 *            the solicitud expedient
	 * @return the resposta actualitzar solicituds RDTO
	 */
	@PostMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Actualitzar dades de la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarSolicitudsRDTO actualitzarSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Dades de la actualització de l'expedient") @RequestBody SolicitudsActualitzarRDTO solicitudExpedient) {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, SolicitudsActualitzarRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaActualitzarSolicitudsRDTO respostaActualitzarSolicitudsRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACTUALITZAR_EXPEDIENT);
		try {
			// El id del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisPortalService.consultarDadesBasiquesExpedient(idExpedient);
			ServeisPortalRestControllerValidationHelper.validateExpedientActualitzarSolicitudExpedient(dadesExpedientBDTO);


			// Si se indica alguna persona al menos debe indicarse el
			// Solicitante
			ServeisPortalRestControllerValidationHelper.validateSollicitantActualitzarSolicitudExpedient(
			        solicitudExpedient.getSollicitant(), solicitudExpedient.getRepresentant());

			// Actualizar Solicitante / Representante / Dades d'Operació si se
			// incluyen en los datos de la petición y si la acción es permitida
			if (solicitudExpedient.getSollicitant() != null || CollectionUtils.isNotEmpty(solicitudExpedient.getAtributs())) {
				ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
				        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT);
			}

			// Se obtienen los Dades d'Operació del procedimiento y se valida
			// que los códigos indicados existen. Se aprovecha para recuperar
			// los identificadores de los campos
			ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
			if (CollectionUtils.isNotEmpty(solicitudExpedient.getAtributs())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = serveisPortalService
				        .cercaDadesOperacio(dadesOperacioCercaBDTO);
				dadesEspecifiquesRDTOList = ServeisPortalRestControllerValidationHelper.validateDadesOperacioActualitzarSolicitudExpedient(
				        solicitudExpedient.getAtributs(), respostaDadesOperacioCercaBDTO.getDadesGrupsRDTOList(), idExpedient);
			}

			// Se construye el modelo para la llamada a la operación de
			// actualización
			ExpedientsRDTO expedientsRDTO = modelMapper.map(solicitudExpedient, ExpedientsRDTO.class);
			// Se indica el id del Expediente recibido como path variable
			expedientsRDTO.setId(idExpedient);
			ActualitzarDadesSollicitud actualitzarDadesSollicitud = new ActualitzarDadesSollicitud();
			actualitzarDadesSollicitud.setExpedient(expedientsRDTO);
			actualitzarDadesSollicitud.setDadesEspecifiques(dadesEspecifiquesRDTOList);
			ExpedientsActualitzarBDTO expedientsActualitzarBDTO = new ExpedientsActualitzarBDTO(actualitzarDadesSollicitud);

			returnExpedientsRDTO = serveisPortalService.actualitzarSolicitudExpedient(expedientsActualitzarBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, SolicitudsActualitzarRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, SolicitudsActualitzarRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsActualitzarBDTO respostaExpedientsActualitzarBDTO = new RespostaExpedientsActualitzarBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaActualitzarSolicitudsRDTO = modelMapper.map(respostaExpedientsActualitzarBDTO, RespostaActualitzarSolicitudsRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, SolicitudsActualitzarRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaActualitzarSolicitudsRDTO;
	}

	/**
	 * Registrar solicitud expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta registrar solicituds RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/registre")
	@ApiOperation(value = "Registrar la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarSolicitudsRDTO registrarSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		return respostaRegistrarSolicitudMockService.getRespostaRespostaRegistrarSolicituds(idExpedient);
	}
	
	
	
	/**
	 * 
	 *                              /!\ MOCKS /!\
	 *     
	 */
	
	/**
	 * Aportar documentacio.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta aportar documentacio RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/documentacio")
	@ApiOperation(value = "Aportar documentació a l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAportarDocumentacioRDTO aportarDocumentacioExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Dades de la creació del document") @RequestBody List<DocumentAportatCrearRDTO> documentacioAportada) {

		RespostaAportarDocumentacioRDTO resposta = new RespostaAportarDocumentacioRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}
	
	
	/**
	 * Substituir document.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta substituir document RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/documentacio/{idDocument}/versionar")
	@ApiOperation(value = "Substituir un document de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSubstituirDocumentRDTO substituirDocumentExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatSubstituirRDTO documentSubstituir) {
		
		RespostaSubstituirDocumentRDTO resposta = new RespostaSubstituirDocumentRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}
	
	
	
	/**
	 * Esborrar document.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta eliminar document RDTO
	 */
	@DeleteMapping("/expedients/{idExpedient}/documentacio/{idDocument}")
	@ApiOperation(value = "Esborrar un document de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsborrarDocumentRDTO esborrarDocumentExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {

		RespostaEsborrarDocumentRDTO resposta = new RespostaEsborrarDocumentRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}
	
	
	/**
	 * Esmenar expedient. (Respondre requeriment o al·legacio o IP)
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta esmenar expedient RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/esmena")
	@ApiOperation(value = "Respondre a requeriment o tràmit d'al·legacions o IP", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsmenarExpedientRDTO esmenarExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Dades de la esmena de l'expedient") @RequestBody ExpedientEsmenaRDTO expedientEsmena) {

		RespostaEsmenarExpedientRDTO resposta = new RespostaEsmenarExpedientRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}
	
	
	/**
	 * Desistir/Renunciar.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta abandonar expedient RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/{accio}")
	@ApiOperation(value = "Desistir/Renunciar l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAbandonarExpedientRDTO abandonarExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Acció a realitzar amb l'expedient", required = true, allowableValues="desistir, renunciar") @PathVariable String accio,
	        @ApiParam(value = "Dades del abandonament de l'expedient") @RequestBody ExpedientAbandonamentRDTO expedientAbandonament) {

		RespostaAbandonarExpedientRDTO resposta = new RespostaAbandonarExpedientRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}	
	
	
	/**
	 * Acces expedient
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta acces expedient RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/acces")
	@ApiOperation(value = "Accés a l'expedient (funcionari dona accés)", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAccesExpedientRDTO accesExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		RespostaAccesExpedientRDTO resposta = new RespostaAccesExpedientRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}	
	
	
	/**
	 * Registrar comunicacio
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta registrar comunicacio expedient RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/comunicat")
	@ApiOperation(value = "Registrar comunicació a l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarComunicacioExpedientRDTO registrarComunicacioExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Dades del comunicat de l'expedient") @RequestBody ExpedientComunicatRDTO expedientComunicat) {

		RespostaRegistrarComunicacioExpedientRDTO resposta = new RespostaRegistrarComunicacioExpedientRDTO();
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		resposta.setResultat(resultat);
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		resposta.setExpedient(expedient);
		return resposta;
	}	
	
}