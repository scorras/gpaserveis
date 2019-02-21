package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaActualitzarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCrearSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaRegistrarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
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
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.RespostaActualitzarSolicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.SolicitudsActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.RespostaCercaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.RespostaCercaProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.DadesOperacioConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.RespostaConsultaDadesOperacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentsEntradaConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.RespostaConsultaDocumentsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientsConsultaRDTO;
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

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/portal", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Portal API", tags = "Serveis Portal API")
@CommonsLog
public class ServeisPortalRestController extends BaseRestController {

	/** The resposta crear solicitud mock service. */
	@Autowired
	private RespostaCrearSolicitudMockService respostaCrearSolicitudMockService;

	/** The resposta actualitzar solicitud mock service. */
	@Autowired
	private RespostaActualitzarSolicitudMockService respostaActualitzarSolicitudMockService;

	/** The resposta registrar solicitud mock service. */
	@Autowired
	private RespostaRegistrarSolicitudMockService respostaRegistrarSolicitudMockService;

	/** The procediments service. */
	@Autowired
	private ProcedimentsService procedimentsService;

	/** The unitats gestores service. */
	@Autowired
	private UnitatsGestoresService unitatsGestoresService;

	/** The tramits service. */
	@Autowired
	private TramitsService tramitsService;

	/** The expedients service. */
	@Autowired
	private ExpedientsService expedientsService;

	/** The dades operacio service. */
	@Autowired
	private DadesOperacioService dadesOperacioService;

	/** The documents service. */
	@Autowired
	private DocumentsService documentsService;

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
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = ServeisPortalRestControllerHelper
		        .loadUnitatsGestoresList(unitatsGestoresService, unitatsGestoresCercaBDTO);

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

		RespostaProcedimentsCercaBDTO respostaProcedimentsCercaBDTO = ServeisPortalRestControllerHelper
		        .loadCercaProcediments(procedimentsService, unitatsGestoresService, procedimentsCercaBDTO);

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
	 * @param idProcediment
	 *            the id procediment
	 * @return the resposta consulta procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/procediments/{idProcediment}")
	@ApiOperation(value = "Consultar les dades del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaProcedimentsRDTO consultarDadesProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment)
	        throws GPAServeisServiceException {

		RespostaConsultaProcedimentsRDTO respostaConsultaProcedimentsRDTO = new RespostaConsultaProcedimentsRDTO();

		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisPortalRestControllerHelper.loadDadesProcediment(procedimentsService,
		        unitatsGestoresService, idProcediment);
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
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = ServeisPortalRestControllerHelper
		        .loadTramitsOvtRDTO(tramitsService, tramitsOvtCercaBDTO);
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper.map(internalTramitsOvtRDTO,
		        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
		respostaConsultaDadesOperacioRDTO.setTramit(tramitsOvtRDTO);

		// Dades Operacio que cumplen los criterios de búsqueda
		DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(idProcediment,
		        DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = ServeisPortalRestControllerHelper
		        .loadCercaDadesOperacio(dadesOperacioService, dadesOperacioCercaBDTO);
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
	 * @return the resposta consulta documents RDTO
	 * @throws GPAServeisServiceException
	 */
	@GetMapping("/procediments/{idProcediment}/tramits/{codiTramit}/documents")
	@ApiOperation(value = "Consultar les dades de documentació d'entrada del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaDocumentsEntradaRDTO consultarDocumentacioEntradaProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Codi del tràmit", required = true) @PathVariable String codiTramit) throws GPAServeisServiceException {

		RespostaConsultaDocumentsEntradaRDTO respostaConsultaDocumentsEntradaRDTO = new RespostaConsultaDocumentsEntradaRDTO();
		DocumentsEntradaConsultaRDTO documentsEntradaConsultaRDTO = new DocumentsEntradaConsultaRDTO();

		// Información del Trámite
		TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
		        DocumentsApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = ServeisPortalRestControllerHelper
		        .loadTramitsOvtRDTO(tramitsService, tramitsOvtCercaBDTO);
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper.map(internalTramitsOvtRDTO,
		        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
		respostaConsultaDocumentsEntradaRDTO.setTramit(tramitsOvtRDTO);

		// Información del Procedimiento, para obtener el Id de Configuració
		// Documentació
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisPortalRestControllerHelper.loadDadesBasiquesProcediment(procedimentsService,
		        idProcediment);

		// Documents que cumplen los criterios de búsqueda
		DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
		        dadesProcedimentBDTO.getProcedimentsRDTO().getConfiguracioDocumentacio(),
		        DocumentsApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = ServeisPortalRestControllerHelper
		        .loadCercaDocumentsEntrada(documentsService, documentsEntradaCercaBDTO);
		documentsEntradaConsultaRDTO = modelMapper.map(respostaDocumentsEntradaCercaBDTO, DocumentsEntradaConsultaRDTO.class);
		respostaConsultaDocumentsEntradaRDTO.setDocumentacioEntrada(documentsEntradaConsultaRDTO);

		return respostaConsultaDocumentsEntradaRDTO;
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
	 * @param sollicitant
	 *            the sollicitant
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
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = ServeisPortalRestControllerHelper
		        .loadUnitatsGestoresList(unitatsGestoresService, unitatsGestoresCercaBDTO);

		// Expedients que cumplen los criterios de búsqueda
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		DateTime dataPresentacioIniciDateTime = null;
		if (StringUtils.isNotEmpty(dataPresentacioInici)) {
			dataPresentacioIniciDateTime = DateTime.parse(dataPresentacioInici, dateTimeFormatter);
		}
		DateTime dataPresentacioFiDateTime = null;
		if (StringUtils.isNotEmpty(dataPresentacioFi)) {
			dataPresentacioFiDateTime = DateTime.parse(dataPresentacioFi, dateTimeFormatter);
		}
		ExpedientsCercaBDTO expedientsCercaBDTO = new ExpedientsCercaBDTO(codiExpedient, nifSollicitant, dataPresentacioIniciDateTime,
		        dataPresentacioFiDateTime, ExpedientsApiParamToInternalMapper.getCodiProcedimentInternalValueList(codiProcediment),
		        ExpedientsApiParamToInternalMapper.getVersioProcedimentInternalValue(versioProcediment),
		        ExpedientsApiParamToInternalMapper.getEstatCiutadaInternalValueList(estat),
		        ExpedientsApiParamToInternalMapper.getIdUnitatGestoraInternalValueList(unitatsGestoresRDTOList),
		        ExpedientsApiParamToInternalMapper.getTramitadorInternalValue(tramitador), aplicacioNegoci, numeroPagina,
		        resultatsPerPagina, ExpedientsApiParamToInternalMapper.getOrdenarPerInternalValue(ordenarPer),
		        ExpedientsApiParamToInternalMapper.getSentitOrdenacioInternalValue(sentitOrdenacio));

		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = ServeisPortalRestControllerHelper.loadCercaExpedients(expedientsService,
		        unitatsGestoresService, expedientsCercaBDTO);

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
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta consulta expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Consultar les dades de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaExpedientsRDTO consultarDadesExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient)
	        throws GPAServeisServiceException {

		RespostaConsultaExpedientsRDTO respostaConsultaExpedientsRDTO = new RespostaConsultaExpedientsRDTO();

		DadesExpedientBDTO dadesExpedientBDTO = ServeisPortalRestControllerHelper.loadDadesExpedient(expedientsService,
		        unitatsGestoresService, tramitsService, documentsService, idExpedient);
		ExpedientsConsultaRDTO expedientsConsultaRDTO = modelMapper.map(dadesExpedientBDTO, ExpedientsConsultaRDTO.class);
		respostaConsultaExpedientsRDTO.setExpedient(expedientsConsultaRDTO);

		return respostaConsultaExpedientsRDTO;
	}

	/**
	 * Crear solicitud expedient.
	 *
	 * @param solicitudExpedient
	 *            the solicitud expedient
	 * @return the resposta crear solicituds RDTO
	 */
	@PostMapping("/expedients")
	@ApiOperation(value = "Crear una sol·licitud d'un expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCrearSolicitudsRDTO crearSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient") @RequestBody SolicitudsCrearRDTO solicitudExpedient) {

		return respostaCrearSolicitudMockService.getRespostaRespostaCrearSolicituds();
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
	@PutMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Actualitzar dades de la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarSolicitudsRDTO actualitzarSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Identificador de l'expedient") @RequestBody SolicitudsActualitzarRDTO solicitudExpedient) {

		return respostaActualitzarSolicitudMockService.getRespostaRespostaActualitzarSolicituds(idExpedient);
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

}