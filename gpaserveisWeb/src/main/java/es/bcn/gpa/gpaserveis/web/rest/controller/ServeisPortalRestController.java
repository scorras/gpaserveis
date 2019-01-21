package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaActualitzarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDadesOperacioMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDocumentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaExpedientsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaProcedimentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCrearSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaObrirSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaRegistrarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.ApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.SentitOrdenacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.ActivableEnFormatElectronicApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.CompetenciaAssociadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.EstatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.ExclusivamentInternApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.FamiliaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.OrdenarPerApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitadorApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.RespostaActualitzarSolicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds.SolicitudsActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.RespostaCercaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.RespostaCercaProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.RespostaConsultaDadesOperacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.RespostaConsultaDocumentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.RespostaConsultaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.RespostaConsultaProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.RespostaCrearSolicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.SolicitudsCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.obrir.expedients.RespostaObrirSolicitudsRDTO;
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

	/** The resposta consulta procediments mock service. */
	@Autowired
	private RespostaConsultaProcedimentsMockService respostaConsultaProcedimentsMockService;

	/** The resposta consulta dades operacio mock service. */
	@Autowired
	private RespostaConsultaDadesOperacioMockService respostaConsultaDadesOperacioMockService;

	/** The resposta consulta documents mock service. */
	@Autowired
	private RespostaConsultaDocumentsMockService respostaConsultaDocumentsMockService;

	// @Autowired
	// private RespostaCercaExpedientsMockService
	// respostaCercaExpedientsMockService;
	/** The resposta consulta expedients mock service. */
	//
	@Autowired
	private RespostaConsultaExpedientsMockService respostaConsultaExpedientsMockService;

	/** The resposta crear solicitud mock service. */
	@Autowired
	private RespostaCrearSolicitudMockService respostaCrearSolicitudMockService;

	/** The resposta actualitzar solicitud mock service. */
	@Autowired
	private RespostaActualitzarSolicitudMockService respostaActualitzarSolicitudMockService;

	/** The resposta registrar solicitud mock service. */
	@Autowired
	private RespostaRegistrarSolicitudMockService respostaRegistrarSolicitudMockService;

	/** The resposta obrir solicitud mock service. */
	@Autowired
	private RespostaObrirSolicitudMockService respostaObrirSolicitudMockService;

	/** The procediments service. */
	@Autowired
	private ProcedimentsService procedimentsService;

	/** The unitats gestores service. */
	@Autowired
	private UnitatsGestoresService unitatsGestoresService;

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
	 * @throws ApiException
	 *             the api exception
	 * @throws ApiException
	 *             the api exception
	 */
	@GetMapping("/procediments")
	@ApiOperation(value = "Cerca de procediments", tags = { "Serveis Portal API", "Funcions d'integració amb RPA" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCercaProcedimentsRDTO cercaProcediments(
	        @ApiParam(value = "Indicarà el número de resultats per pàgina") @RequestParam(value = "resultatsPerPagina", required = false, defaultValue = "20") int resultatsPerPagina,
	        @ApiParam(value = "Indicarà en quina pàgina hauria de començar els resultats demanats en una cerca") @RequestParam(value = "numeroPagina", required = false, defaultValue = "1") int numeroPagina,
	        @ApiParam(value = "Indicarà el camp mitjançant el qual s'ordenarà el resultat de la cerca", allowableValues = OrdenarPerApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = OrdenarPerApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = OrdenarPerApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String ordenarPer,
	        @ApiParam(value = "Indicarà el sentit d'ordenació per al resultat de la cerca", allowableValues = SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_NAME, required = false, defaultValue = SentitOrdenacioApiParamValueTranslator.REQUEST_PARAM_DEFAULT_VALUE) String sentitOrdenacio,
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
		PageDataOfUnitatsGestoresRDTO pageDataOfUnitatsGestoresRDTO = unitatsGestoresService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = pageDataOfUnitatsGestoresRDTO.getData();

		// Procediments que cumplen los criterios de búsqueda
		ProcedimentsCercaBDTO procedimentsCercaBDTO = new ProcedimentsCercaBDTO(codi, nom,
		        ApiParamToInternalMapper.getActivableFormatElectronicInternalValueList(activableFormatElectronic), actuacio,
		        ApiParamToInternalMapper.getTramitadorInternalValue(tramitador), aplicacioNegoci,
		        ApiParamToInternalMapper.getCompetenciaAssociadaInternalValueList(competenciaAssociada),
		        ApiParamToInternalMapper.getEstatInternalValueList(estat), ApiParamToInternalMapper.getFamiliaInternalValueList(familia),
		        ApiParamToInternalMapper.getExclusivamentInternInternalValue(exclusivamentIntern), organResolutori,
		        ApiParamToInternalMapper.getIdUnitatGestoraInternalValueList(unitatsGestoresRDTOList), numeroPagina, resultatsPerPagina,
		        ApiParamToInternalMapper.getOrdenarPerInternalValue(ordenarPer),
		        ApiParamToInternalMapper.getSentitOrdenacioInternalValue(sentitOrdenacio));
		PageDataOfProcedimentsRDTO pageDataOfProcedimentsRDTO = procedimentsService.cercaProcediments(procedimentsCercaBDTO);

		List<ProcedimentsRDTO> procedimentsRDTOList = pageDataOfProcedimentsRDTO.getData();
		for (ProcedimentsRDTO procedimentsRDTO : procedimentsRDTOList) {
			procedimentsCercaRDTOList.add(modelMapper.map(procedimentsRDTO, ProcedimentsCercaRDTO.class));
		}
		resposta.setData(procedimentsCercaRDTOList);

		// Paginació
		resposta.setPaginacio(modelMapper.map(pageDataOfProcedimentsRDTO.getPage(), PaginacioRDTO.class));

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
	 */
	@GetMapping("/procediments/{idProcediment}")
	@ApiOperation(value = "Consultar les dades del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaProcedimentsRDTO consultarDadesProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment) {

		return respostaConsultaProcedimentsMockService.getRespostaConsultaProcediments(idProcediment);
	}

	/**
	 * Consultar dades operacio procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @param idTramit
	 *            the id tramit
	 * @return the resposta consulta dades operacio RDTO
	 */
	@GetMapping("/procediments/{idProcediment}/tramits/{idTramit}/atributs")
	@ApiOperation(value = "Consultar les dades d'operació del tràmit", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaDadesOperacioRDTO consultarDadesOperacioProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Identificador del tràmit", required = true) @PathVariable BigDecimal idTramit) {

		return respostaConsultaDadesOperacioMockService.getRespostaConsultaDadesOperacio(idProcediment, idTramit);
	}

	/**
	 * Consultar documentacio procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @param idTramit
	 *            the id tramit
	 * @return the resposta consulta documents RDTO
	 */
	@GetMapping("/procediments/{idProcediment}/tramits/{idTramit}/documentacio")
	@ApiOperation(value = "Consultar les dades de documentació del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaDocumentsRDTO consultarDocumentacioProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Identificador del tràmit", required = true) @PathVariable BigDecimal idTramit) {

		return respostaConsultaDocumentsMockService.getRespostaConsultaDocuments(idProcediment, idTramit);
	}

	/**
	 * Cerca expedients.
	 *
	 * @param resultatsPerPagina
	 *            the resultats per pagina
	 * @param numeroPagina
	 *            the numero pagina
	 * @param codiExpedient
	 *            the codi expedient
	 * @param codiProcediment
	 *            the codi procediment
	 * @param unitatGestora
	 *            the unitat gestora
	 * @param estat
	 *            the estat
	 * @param nifSolicitant
	 *            the nif solicitant
	 * @param dataPresentacioInici
	 *            the data presentacio inici
	 * @param dataPresentacioFi
	 *            the data presentacio fi
	 * @return the resposta cerca expedients RDTO
	 */
	@GetMapping("/expedients")
	@ApiOperation(value = "Cerca d'expedients", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCercaExpedientsRDTO cercaExpedients(
	        // TODO Esta localización no es adecuada para esta anotación
	        // @ApiImplicitParams
	        @ApiParam(value = "Indicarà el número de resultats per pàgina") @RequestParam(value = "resultatsPerPagina", required = false, defaultValue = "20") int resultatsPerPagina,
	        @ApiParam(value = "Indicarà en quina pàgina hauria de començar els resultats demanats en una cerca") @RequestParam(value = "numeroPagina", required = false, defaultValue = "1") int numeroPagina,
	        @ApiParam(value = "Filtra expedients per codi") @RequestParam(value = "codiExpedient", required = false) String codiExpedient,
	        @ApiParam(value = "Filtra expedients per codi del procediment") @RequestParam(value = "codiProcediment", required = false) String codiProcediment,
	        @ApiParam(value = "Filtra expedients per Unitat Gestora") @RequestParam(value = "unitatGestora", required = false) String unitatGestora,
	        @ApiParam(value = "Filtra expedients per estat", allowableValues = "EN_PREPARACIO, EN_REVISIO, PENDENT_SUBSANACIO, EN_TRAMITACIO, PENDENT_ALEGACIONS, PENDENT_INFORMES, PROPOSAT_RESOLUCIO, RESOLT, TANCAT") @RequestParam(value = "estat", required = false) String estat,
	        @ApiParam(value = "Filtra expedients d'un sol·licitant") @RequestParam(value = "nifSolicitant", required = false) String nifSolicitant,
	        @ApiParam(value = "Filtra expedients per data de presentació") @RequestParam(value = "dataPresentacioInici", required = false) String dataPresentacioInici,
	        @ApiParam(value = "Filtra expedients per data de presentació") @RequestParam(value = "dataPresentacioFi", required = false) String dataPresentacioFi) {

		RespostaCercaExpedientsRDTO resposta = new RespostaCercaExpedientsRDTO();
		// try {

		List<ExpedientsCercaRDTO> data = new ArrayList<ExpedientsCercaRDTO>();
		PaginacioRDTO paginacio = new PaginacioRDTO();

		// PageDataOfExpedientsRDTO pageDataExpedients =
		// expedientsApi.getExpedientsUsingGET1(null, null, null, null, null,
		// null,
		// numeroPagina, null, null, resultatsPerPagina, null, null, null,
		// null);

		// List<ExpedientsRDTO> dades = pageDataExpedients.getData();
		// ExpedientsCercaRDTO resultatExp = null;
		// for (ExpedientsRDTO expedient : dades) {
		//
		// resultatExp = new ExpedientsCercaRDTO();
		//
		// resultatExp.setCodi(expedient.getCodi());
		// resultatExp.setDataModificacio(expedient.getDarreraModificacio().toString());
		// // TODO:: Resto de datos
		// data.add(resultatExp);
		//
		// }
		//
		// // Paginacio
		// paginacio.setNumeroPagina(pageDataExpedients.getPage().getCurrentPageNumber());
		// paginacio.setResultatsPerPagina(pageDataExpedients.getPage().getPageSize());
		// paginacio.setTotalPagines(pageDataExpedients.getPage().getTotalPages());
		// paginacio.setTotalResultats(pageDataExpedients.getPage().getTotalElements());
		//
		// resposta.setPaginacio(paginacio);
		// resposta.setData(data);

		// } catch (ApiException e) {
		// throw new GPAServeisRuntimeException(e);
		// }

		// Mock de datos
		// return
		// respostaCercaExpedientsMockService.getRespostaCercaExpedients();

		return resposta;
	}

	/**
	 * Consultar dades expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta consulta expedients RDTO
	 */
	@GetMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Consultar les dades de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaExpedientsRDTO consultarDadesExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		return respostaConsultaExpedientsMockService.getRespostaConsultaExpedients(idExpedient);
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

	/**
	 * Obrir solicitud expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta obrir solicituds RDTO
	 */
	@PostMapping("/expedients/{idExpedient}/obrir")
	@ApiOperation(value = "Obrir la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaObrirSolicitudsRDTO obrirSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		return respostaObrirSolicitudMockService.getRespostaObrirSolicituds(idExpedient);
	}

}