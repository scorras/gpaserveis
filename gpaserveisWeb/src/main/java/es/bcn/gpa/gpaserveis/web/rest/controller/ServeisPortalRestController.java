package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaActualitzarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCercaProcedimentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDadesOperacioMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaDocumentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaExpedientsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaConsultaProcedimentsMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaCrearSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaObrirSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.mock.RespostaRegistrarSolicitudMockService;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.BaseApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.SentitOrdenacioApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.ActivableEnFormatElectronicApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.CompetenciaAssociadaApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.EstatApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.ExclusivamentInternApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.FamiliaApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.OrdenarPerApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment.TramitadorApiParamValueConverter;
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
import es.bcn.gpa.gpaserveis.web.rest.exception.GPAServeisServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import net.opentrends.openframe.services.rest.controller.AbstractRestController;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/portal", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Portal API", tags = "Serveis Portal API")
public class ServeisPortalRestController extends AbstractRestController {

	@Autowired
	private RespostaCercaProcedimentsMockService respostaCercaProcedimentsMockService;

	@Autowired
	private RespostaConsultaProcedimentsMockService respostaConsultaProcedimentsMockService;

	@Autowired
	private RespostaConsultaDadesOperacioMockService respostaConsultaDadesOperacioMockService;

	@Autowired
	private RespostaConsultaDocumentsMockService respostaConsultaDocumentsMockService;

	// @Autowired
	// private RespostaCercaExpedientsMockService
	// respostaCercaExpedientsMockService;
	//
	@Autowired
	private RespostaConsultaExpedientsMockService respostaConsultaExpedientsMockService;

	@Autowired
	private RespostaCrearSolicitudMockService respostaCrearSolicitudMockService;

	@Autowired
	private RespostaActualitzarSolicitudMockService respostaActualitzarSolicitudMockService;

	@Autowired
	private RespostaRegistrarSolicitudMockService respostaRegistrarSolicitudMockService;

	@Autowired
	private RespostaObrirSolicitudMockService respostaObrirSolicitudMockService;

	@Autowired
	private ProcedimentsApi procedimentsApi;

	@Autowired
	private UnitatsGestoresApi unitatsGestoresApi;

	@Autowired
	private Expedients_Api expedientsApi;

	@Autowired
	@Qualifier("ordenarPerApiParamValueConverter")
	private BaseApiParamValueConverter ordenarPerApiParamValueConverter;

	@Autowired
	@Qualifier("sentitOrdenacioApiParamValueConverter")
	private BaseApiParamValueConverter sentitOrdenacioApiParamValueConverter;

	@Autowired
	@Qualifier("estatApiParamValueConverter")
	private BaseApiParamValueConverter estatApiParamValueConverter;

	@Autowired
	@Qualifier("tramitadorApiParamValueConverter")
	private BaseApiParamValueConverter tramitadorApiParamValueConverter;

	@Autowired
	@Qualifier("exclusivamentInternApiParamValueConverter")
	private BaseApiParamValueConverter exclusivamentInternApiParamValueConverter;

	@Autowired
	@Qualifier("activableEnFormatElectronicApiParamValueConverter")
	private BaseApiParamValueConverter activableEnFormatElectronicApiParamValueConverter;

	@Autowired
	@Qualifier("competenciaAssociadaApiParamValueConverter")
	private BaseApiParamValueConverter competenciaAssociadaApiParamValueConverter;

	@Autowired
	@Qualifier("familiaApiParamValueConverter")
	private BaseApiParamValueConverter familiaApiParamValueConverter;

	@Autowired
	private ModelMapper procedimentsModelMapper;

	@GetMapping("/procediments")
	@ApiOperation(value = "Cerca de procediments", tags = { "Serveis Portal API", "Funcions d'integració amb RPA" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCercaProcedimentsRDTO cercaProcediments(
	        @ApiParam(value = "Indicarà el número de resultats per pàgina") @RequestParam(value = "resultatsPerPagina", required = false, defaultValue = "20") int resultatsPerPagina,
	        @ApiParam(value = "Indicarà en quina pàgina hauria de començar els resultats demanats en una cerca") @RequestParam(value = "numeroPagina", required = false, defaultValue = "1") int numeroPagina,
	        @ApiParam(value = "Indicarà el camp mitjançant el qual s'ordenarà el resultat de la cerca", allowableValues = OrdenarPerApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = OrdenarPerApiParamValueConverter.REQUEST_PARAM_NAME, required = false, defaultValue = OrdenarPerApiParamValueConverter.REQUEST_PARAM_DEFAULT_VALUE) String ordenarPer,
	        @ApiParam(value = "Indicarà el sentit d'ordenació per al resultat de la cerca", allowableValues = SentitOrdenacioApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = SentitOrdenacioApiParamValueConverter.REQUEST_PARAM_NAME, required = false, defaultValue = SentitOrdenacioApiParamValueConverter.REQUEST_PARAM_DEFAULT_VALUE) String sentitOrdenacio,
	        @ApiParam(value = "Filtra procediments per codi") @RequestParam(value = "codi", required = false) String codi,
	        @ApiParam(value = "Filtrar procediments per conjunt d'estats", allowableValues = EstatApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = EstatApiParamValueConverter.REQUEST_PARAM_NAME, required = false) String[] estat,
	        @ApiParam(value = "Filtra procediments per nom") @RequestParam(value = "nom", required = false) String nom,
	        @ApiParam(value = "Filtra procediments per aplicació de tramitació", allowableValues = TramitadorApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = TramitadorApiParamValueConverter.REQUEST_PARAM_NAME, required = false) String tramitador,
	        @ApiParam(value = "En cas que el tramitador sigui una aplicació de negoci, filtra procediments pel nom de dita aplicació") @RequestParam(value = "aplicacioNegoci", required = false) String aplicacioNegoci,
	        @ApiParam(value = "Filtra procediments per conjunt d'Unitats Gestores Responsables") @RequestParam(value = "ugr", required = false) String ugr,
	        @ApiParam(value = "Filtra procediments per exclusivament intern", allowableValues = ExclusivamentInternApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = ExclusivamentInternApiParamValueConverter.REQUEST_PARAM_NAME, required = false) String exclusivamentIntern,
	        @ApiParam(value = "Filtra procediments per canals d'activació en format electrònic", allowableValues = ActivableEnFormatElectronicApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = ActivableEnFormatElectronicApiParamValueConverter.REQUEST_PARAM_NAME, required = false) String[] activableFormatElectronic,
	        @ApiParam(value = "Filtra procediments per òrgan resolutori") @RequestParam(value = "organResolutori", required = false) String organResolutori,
	        @ApiParam(value = "Filtrar procediments per conjunt de competències associades", allowableValues = CompetenciaAssociadaApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = CompetenciaAssociadaApiParamValueConverter.REQUEST_PARAM_NAME, required = false) String[] competenciaAssociada,
	        @ApiParam(value = "Filtrar procediments per conjunt de famílies", allowableValues = FamiliaApiParamValueConverter.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = FamiliaApiParamValueConverter.REQUEST_PARAM_NAME, required = false) String[] familia,
	        @ApiParam(value = "Filtra procediments per actuació") @RequestParam(value = "actuacio", required = false) String actuacio)
	        throws GPAServeisServiceException, es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException,
	        es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException {

		RespostaCercaProcedimentsRDTO resposta = new RespostaCercaProcedimentsRDTO();
		List<ProcedimentsCercaRDTO> procedimentsCercaRDTOList = new ArrayList<ProcedimentsCercaRDTO>();

		// Data
		PageDataOfProcedimentsRDTO pageDataOfProcedimentsRDTO = procedimentsApi.cercaProcediments(null, null,
		        getActivableFormatElectronicInternalValueList(activableFormatElectronic), actuacio, aplicacioNegoci, codi,
		        getCompetenciaAssociadaInternalValueList(competenciaAssociada), null, null, null, null, numeroPagina,
		        getSentitOrdenacioInternalValue(sentitOrdenacio), getEstatInternalValueList(estat), getFamiliaInternalValueList(familia),
		        null, null, getExclusivamentInternInternalValue(exclusivamentIntern), null, nom, getTramitadorInternalValue(tramitador),
		        organResolutori, resultatsPerPagina, null, getOrdenarPerInternalValue(ordenarPer), null, null,
		        getIdUnitatGestoraInternalValueList(ugr));

		List<ProcedimentsRDTO> procedimentsRDTOList = pageDataOfProcedimentsRDTO.getData();

		for (ProcedimentsRDTO procedimentsRDTO : procedimentsRDTOList) {
			procedimentsCercaRDTOList.add(procedimentsModelMapper.map(procedimentsRDTO, ProcedimentsCercaRDTO.class));
		}
		resposta.setData(procedimentsCercaRDTOList);

		// Paginació
		resposta.setPaginacio(procedimentsModelMapper.map(pageDataOfProcedimentsRDTO.getPage(), PaginacioRDTO.class));

		return resposta;

		// Mock de datos
		// return
		// respostaCercaProcedimentsMockService.getRespostaCercaProcediments();
	}

	private String getOrdenarPerInternalValue(String ordenarPer) {
		return ordenarPerApiParamValueConverter.getInternalValueByApiParamValue(ordenarPer);
	}

	private String getSentitOrdenacioInternalValue(String sentitOrdenacio) {
		return sentitOrdenacioApiParamValueConverter.getInternalValueByApiParamValue(sentitOrdenacio);
	}

	private List<BigDecimal> getEstatInternalValueList(String[] estat) {
		return estatApiParamValueConverter.getInternalValueListByApiParamValueList(estat);
	}

	private Integer getTramitadorInternalValue(String tramitador) {
		return tramitadorApiParamValueConverter.getInternalValueByApiParamValue(tramitador);
	}

	private List<BigDecimal> getIdUnitatGestoraInternalValueList(String ugr) throws ApiException {
		ArrayList<BigDecimal> idUnitatGestoraInternalValueList = null;
		if (StringUtils.isNotEmpty(ugr)) {
			PageDataOfUnitatsGestoresRDTO pageDataOfUnitatsGestoresRDTO = unitatsGestoresApi.cercaUnitatsGestores(null, null, null, null,
			        null, null, null, null, null, null, null, null, null, ugr, null, null, null, null, null, null);
			idUnitatGestoraInternalValueList = new ArrayList<BigDecimal>();
			for (UnitatsGestoresRDTO unitatsGestoresRDTO : pageDataOfUnitatsGestoresRDTO.getData()) {
				idUnitatGestoraInternalValueList.add(unitatsGestoresRDTO.getId());
			}
		}
		return idUnitatGestoraInternalValueList;
	}

	private Integer getExclusivamentInternInternalValue(String exclusivamentIntern) {
		return exclusivamentInternApiParamValueConverter.getInternalValueByApiParamValue(exclusivamentIntern);
	}

	private List<String> getActivableFormatElectronicInternalValueList(String[] activableFormatElectronic) {
		return activableEnFormatElectronicApiParamValueConverter.getInternalValueListByApiParamValueList(activableFormatElectronic);
	}

	private List<BigDecimal> getCompetenciaAssociadaInternalValueList(String[] competenciaAssociada) {
		return competenciaAssociadaApiParamValueConverter.getInternalValueListByApiParamValueList(competenciaAssociada);
	}

	private List<BigDecimal> getFamiliaInternalValueList(String[] familia) {
		return familiaApiParamValueConverter.getInternalValueListByApiParamValueList(familia);
	}

	@GetMapping("/procediments/{idProcediment}")
	@ApiOperation(value = "Consultar les dades del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaProcedimentsRDTO consultarDadesProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment) {

		return respostaConsultaProcedimentsMockService.getRespostaConsultaProcediments(idProcediment);
	}

	@GetMapping("/procediments/{idProcediment}/tramits/{idTramit}/atributs")
	@ApiOperation(value = "Consultar les dades d'operació del tràmit", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaDadesOperacioRDTO consultarDadesOperacioProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Identificador del tràmit", required = true) @PathVariable BigDecimal idTramit) {

		return respostaConsultaDadesOperacioMockService.getRespostaConsultaDadesOperacio(idProcediment, idTramit);
	}

	@GetMapping("/procediments/{idProcediment}/tramits/{idTramit}/documentacio")
	@ApiOperation(value = "Consultar les dades de documentació del procediment", tags = { "Serveis Portal API",
	        "Funcions d'integració amb RPA" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaDocumentsRDTO consultarDocumentacioProcediment(
	        @ApiParam(value = "Identificador del procediment", required = true) @PathVariable BigDecimal idProcediment,
	        @ApiParam(value = "Identificador del tràmit", required = true) @PathVariable BigDecimal idTramit) {

		return respostaConsultaDocumentsMockService.getRespostaConsultaDocuments(idProcediment, idTramit);
	}

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

	@GetMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Consultar les dades de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaExpedientsRDTO consultarDadesExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		return respostaConsultaExpedientsMockService.getRespostaConsultaExpedients(idExpedient);
	}

	@PostMapping("/expedients")
	@ApiOperation(value = "Crear una sol·licitud d'un expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCrearSolicitudsRDTO crearSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient") @RequestBody SolicitudsCrearRDTO solicitudExpedient) {

		return respostaCrearSolicitudMockService.getRespostaRespostaCrearSolicituds();
	}

	@PutMapping("/expedients/{idExpedient}")
	@ApiOperation(value = "Actualitzar dades de la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarSolicitudsRDTO actualitzarSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient,
	        @ApiParam(value = "Identificador de l'expedient") @RequestBody SolicitudsActualitzarRDTO solicitudExpedient) {

		return respostaActualitzarSolicitudMockService.getRespostaRespostaActualitzarSolicituds(idExpedient);
	}

	@PostMapping("/expedients/{idExpedient}/registre")
	@ApiOperation(value = "Registrar la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarSolicitudsRDTO registrarSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		return respostaRegistrarSolicitudMockService.getRespostaRespostaRegistrarSolicituds(idExpedient);
	}

	@PostMapping("/expedients/{idExpedient}/obrir")
	@ApiOperation(value = "Obrir la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaObrirSolicitudsRDTO obrirSolicitudExpedient(
	        @ApiParam(value = "Identificador de l'expedient", required = true) @PathVariable BigDecimal idExpedient) {

		return respostaObrirSolicitudMockService.getRespostaObrirSolicituds(idExpedient);
	}

}