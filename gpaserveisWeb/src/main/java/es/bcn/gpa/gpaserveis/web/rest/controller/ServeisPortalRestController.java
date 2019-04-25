package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.AportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaSubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaUploadDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.SubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.UploadDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAbandonarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsEsmenarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AportarDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaUploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SubstituirDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreCreacioSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.OrigenApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.ProcedimentsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs.DadesOperacioApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.documents.DocumentsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.AccioAbandonarApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatCiutadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.VersioProcedimentApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.ActivableEnFormatElectronicApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.CompetenciaAssociadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.EstatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.ExclusivamentInternApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.FamiliaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitOvtApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitadorApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.FitxerRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentacioAportarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.DocumentAportatSubstituirRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.RespostaSubstituirDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.upload.RespostaUploadDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar.ExpedientAbandonamentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar.RespostaAbandonarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.actualitzar.ExpedientActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.actualitzar.RespostaActualitzarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.crear.ExpedientCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.crear.RespostaCrearExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.DocumentRequeritCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.ExpedientEsmenaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.RespostaEsmenarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.registrar.RespostaRegistrarExpedientRDTO;
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

	/** The serveis service. */
	@Autowired
	private ServeisService serveisService;

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
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = serveisService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);

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

		RespostaProcedimentsCercaBDTO respostaProcedimentsCercaBDTO = serveisService.cercaProcediments(procedimentsCercaBDTO);

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

		DadesProcedimentBDTO dadesProcedimentBDTO = serveisService.consultarDadesProcediment(idProcediment);
		// El id del Procedimiento debe ser válido
		if (dadesProcedimentBDTO.getProcedimentsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_FOUND.getDescripcio());
		}
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

		// El id del Procedimiento debe ser válido
		DadesProcedimentBDTO dadesProcedimentBDTO = serveisService.consultarDadesProcediment(idProcediment);
		if (dadesProcedimentBDTO.getProcedimentsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_FOUND.getDescripcio());
		}

		// Información del Trámite
		TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
		        DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = serveisService
		        .consultarDadesTramitOvt(tramitsOvtCercaBDTO);
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper.map(internalTramitsOvtRDTO,
		        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
		respostaConsultaDadesOperacioRDTO.setTramit(tramitsOvtRDTO);

		// Dades Operacio que cumplen los criterios de búsqueda
		DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(idProcediment,
		        DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = serveisService.cercaDadesOperacio(dadesOperacioCercaBDTO);
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

		// El id del Procedimiento debe ser válido
		// Información del Procedimiento, para obtener el Id de Configuració
		// Documentació
		DadesProcedimentBDTO dadesProcedimentBDTO = serveisService.consultarDadesProcediment(idProcediment);
		if (dadesProcedimentBDTO.getProcedimentsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_FOUND.getDescripcio());
		}

		// Información del Trámite
		TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
		        DocumentsApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = serveisService
		        .consultarDadesTramitOvt(tramitsOvtCercaBDTO);
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper.map(internalTramitsOvtRDTO,
		        es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);
		respostaConsultaConfiguracioDocumentacioAportadaRDTO.setTramit(tramitsOvtRDTO);

		// Documents que cumplen los criterios de búsqueda
		DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
		        dadesProcedimentBDTO.getProcedimentsRDTO().getConfiguracioDocumentacio(),
		        DocumentsApiParamToInternalMapper.getTramitOvtInternalValue(codiTramit));
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
		        .cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO);
		// TODO Necesario pasar a la conversión el conjunto de
		// confdocsentEstatsExpList de la Configuración Documentación Entrada
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
	        @ApiParam(value = "Filtra expedients per conjunt d'estats", allowableValues = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @RequestParam(value = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_NAME, required = false) String[] estat,
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
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = serveisService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);

		// Expedients que cumplen los criterios de búsqueda
		ExpedientsCercaBDTO expedientsCercaBDTO = new ExpedientsCercaBDTO(
		        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient), nifSollicitant,
		        ExpedientsApiParamToInternalMapper.getDataPresentacioIniciInternalValue(dataPresentacioInici),
		        ExpedientsApiParamToInternalMapper.getDataPresentacioFiInternalValue(dataPresentacioFi),
		        ExpedientsApiParamToInternalMapper.getCodiProcedimentInternalValueList(codiProcediment),
		        ExpedientsApiParamToInternalMapper.getVersioProcedimentInternalValue(versioProcediment),
		        ExpedientsApiParamToInternalMapper.getEstatCiutadaInternalValueList(estat),
		        ExpedientsApiParamToInternalMapper.getIdUnitatGestoraInternalValueList(unitatsGestoresRDTOList),
		        ExpedientsApiParamToInternalMapper.getTramitadorInternalValue(tramitador), aplicacioNegoci, numeroPagina,
		        resultatsPerPagina, ExpedientsApiParamToInternalMapper.getOrdenarPerInternalValue(ordenarPer),
		        ExpedientsApiParamToInternalMapper.getSentitOrdenacioInternalValue(sentitOrdenacio));

		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = serveisService.cercaExpedients(expedientsCercaBDTO);

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
	@GetMapping("/expedients/{codiExpedient}")
	@ApiOperation(value = "Consultar les dades de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaExpedientsRDTO consultarDadesExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient)
	        throws GPAServeisServiceException {

		RespostaConsultaExpedientsRDTO respostaConsultaExpedientsRDTO = new RespostaConsultaExpedientsRDTO();

		// Datos principales del expedient
		DadesExpedientBDTO dadesExpedientBDTO = serveisService
		        .consultarDadesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
		// El código del expediente debe ser válido
		if (dadesExpedientBDTO.getExpedientsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_EXPEDIENTS_NOT_FOUND.getDescripcio());
		}
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
	 * Descarregar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @return the response entity
	 */
	@GetMapping(value = "/expedients/{codiExpedient}/documents/{idDocument}", produces = "*/*")
	@ApiOperation(value = "Descarregar document de l'expedient", tags = { "Serveis Portal API",
	        "Funcions de consulta al repositori de dades d'expedients" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public ResponseEntity<byte[]> descarregarDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {

		try {
			// El codi del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO,
			        Resultat.ERROR_DESCARREGAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			DocsEntradaRDTO docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisPortalRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_DESCARREGAR_DOCUMENT_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de
			// descarregar document
			DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO = new DescarregarDocumentExpedientBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), idDocument);
			byte[] result = serveisService.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");
			headers.add("Content-Length", String.valueOf(result.length));
			headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
			String filename = docsEntradaRDTO.getDocsFisics().getNom();
			headers.add("Content-Disposition", "attachment; filename=\"" + filename + "\"");

			return new ResponseEntity<byte[]>(result, headers, HttpStatus.OK);

		} catch (GPAApiParamValidationException e) {
			log.error("substituirDocumentExpedient(BigDecimal, BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$ type

			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("substituirDocumentExpedient(BigDecimal, BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$

			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Crear solicitud expedient.
	 *
	 * @param solicitudExpedient
	 *            the solicitud expedient
	 * @return the resposta crear expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("/expedients")
	@ApiOperation(value = "Crear una sol·licitud d'un expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCrearExpedientRDTO crearSolicitudExpedient(
	        @ApiParam(value = "Dades de la creació de l'expedient") @RequestBody ExpedientCrearRDTO solicitudExpedient)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearSolicitudExpedient(ExpedientCrearRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaCrearExpedientRDTO respostaCrearSolicitudsRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CREAR_EXPEDIENT);
		try {
			// El id del procedimiento debe existir y el procedimiento debe
			// encontrarse en estado Publicat
			DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			        .consultarDadesBasiquesProcediment(solicitudExpedient.getProcediment().getId());
			ServeisPortalRestControllerValidationHelper.validateProcedimentCrearSolicitudExpedient(dadesProcedimentBDTO);

			// El codi de la unitat gestora, opcional, debe existir y estar
			// vigente
			BigDecimal idUnitatGestora = null;
			if (solicitudExpedient.getUnitatGestora() != null) {
				UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO = new UnitatsGestoresCercaBDTO(
				        solicitudExpedient.getUnitatGestora().getCodi());
				UnitatsGestoresRDTO unitatsGestoresRDTO = serveisService.consultaDadesUnitatGestora(unitatsGestoresCercaBDTO);
				ServeisPortalRestControllerValidationHelper.validateUnitatGestora(unitatsGestoresRDTO, dadesProcedimentBDTO,
				        Resultat.ERROR_CREAR_EXPEDIENT);
				idUnitatGestora = unitatsGestoresRDTO.getId();
			} else {
				// Si no se indica, se establece la UGR del procedimiento
				idUnitatGestora = dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext();
			}

			ExpedientsRDTO expedientsRDTO = modelMapper.map(solicitudExpedient, ExpedientsRDTO.class);
			// Se debe indicar el id de la Unitat Gestora recuperada
			expedientsRDTO.setUnitatGestoraIdext(idUnitatGestora);
			ExpedientsCrearBDTO expedientsCrearBDTO = new ExpedientsCrearBDTO(expedientsRDTO);

			returnExpedientsRDTO = serveisService.crearSollicitudExpedient(expedientsCrearBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("crearSolicitudExpedient(ExpedientCrearRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("crearSolicitudExpedient(ExpedientCrearRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsCrearBDTO respostaExpedientsCrearBDTO = new RespostaExpedientsCrearBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaCrearSolicitudsRDTO = modelMapper.map(respostaExpedientsCrearBDTO, RespostaCrearExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("crearSolicitudExpedient(SolicitudsCrearRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaCrearSolicitudsRDTO;
	}

	/**
	 * Actualitzar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param solicitudExpedient
	 *            the solicitud expedient
	 * @return the resposta actualitzar expedient RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}")
	@ApiOperation(value = "Actualitzar dades de la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarExpedientRDTO actualitzarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la actualització de l'expedient") @RequestBody ExpedientActualitzarRDTO solicitudExpedient) {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaActualitzarExpedientRDTO respostaActualitzarSolicitudsRDTO = null;
		ExpedientsRDTO returnExpedientsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACTUALITZAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			// Si se indica alguna persona al menos debe indicarse el
			// Solicitante
			ServeisPortalRestControllerValidationHelper.validateSollicitantActualitzarSolicitudExpedient(
			        solicitudExpedient.getSollicitant(), solicitudExpedient.getRepresentant());

			// Actualizar Solicitante / Representante / Dades d'Operació si se
			// incluyen en los datos de la petición y si la acción es permitida
			if (solicitudExpedient.getSollicitant() != null || CollectionUtils.isNotEmpty(solicitudExpedient.getDadesOperacio())) {
				ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
				        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);
			}

			// Se obtienen los Dades d'Operació del procedimiento y se valida
			// que los códigos indicados existen. Se aprovecha para recuperar
			// los identificadores de los campos
			ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
			if (CollectionUtils.isNotEmpty(solicitudExpedient.getDadesOperacio())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = serveisService.cercaDadesOperacio(dadesOperacioCercaBDTO);
				dadesEspecifiquesRDTOList = ServeisPortalRestControllerValidationHelper.validateDadesOperacioActualitzarSolicitudExpedient(
				        solicitudExpedient.getDadesOperacio(), respostaDadesOperacioCercaBDTO.getDadesGrupsRDTOList(),
				        dadesExpedientBDTO.getExpedientsRDTO().getId());
			}

			// Se construye el modelo para la llamada a la operación de
			// actualización
			ExpedientsRDTO expedientsRDTO = modelMapper.map(solicitudExpedient, ExpedientsRDTO.class);
			// Se indica el id del Expediente recibido como path variable
			expedientsRDTO.setId(dadesExpedientBDTO.getExpedientsRDTO().getId());
			ActualitzarDadesSollicitud actualitzarDadesSollicitud = new ActualitzarDadesSollicitud();
			actualitzarDadesSollicitud.setExpedient(expedientsRDTO);
			actualitzarDadesSollicitud.setDadesEspecifiques(dadesEspecifiquesRDTOList);
			ExpedientsActualitzarBDTO expedientsActualitzarBDTO = new ExpedientsActualitzarBDTO(actualitzarDadesSollicitud);
			returnExpedientsRDTO = serveisService.actualitzarSolicitudExpedient(expedientsActualitzarBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsActualitzarBDTO respostaExpedientsActualitzarBDTO = new RespostaExpedientsActualitzarBDTO(returnExpedientsRDTO,
		        respostaResultatBDTO);
		respostaActualitzarSolicitudsRDTO = modelMapper.map(respostaExpedientsActualitzarBDTO, RespostaActualitzarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, SolicitudsActualitzarRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaActualitzarSolicitudsRDTO;
	}

	/**
	 * Registrar solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the resposta registrar expedient RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/registre")
	@ApiOperation(value = "Registrar la sol·licitud de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarExpedientRDTO registrarSolicitudExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient) {
		if (log.isDebugEnabled()) {
			log.debug("registrarSolicitudExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		RespostaRegistrarExpedientRDTO respostaRegistrarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaCrearRegistreSolicitudExpedient respostaCrearRegistreSolicitudExpedient = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REGISTRAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_REGISTRAR_EXPEDIENT);

			// Registrar expediente si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.REGISTRAR_SOLLICITUD, Resultat.ERROR_REGISTRAR_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de registro
			RegistreCreacioSolicitudExpedient registreCreacioSolicitudExpedient = new RegistreCreacioSolicitudExpedient();
			registreCreacioSolicitudExpedient.setExpedient(dadesExpedientBDTO.getExpedientsRDTO());
			ExpedientsRegistrarBDTO expedientsRegistrarBDTO = new ExpedientsRegistrarBDTO(registreCreacioSolicitudExpedient);
			respostaCrearRegistreSolicitudExpedient = serveisService.crearRegistreSolicitudExpedient(expedientsRegistrarBDTO);

			// Cambiar el estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
			        ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.REGISTRAR_SOLLICITUD.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("registrarSolicitudExpedient(BigDecimal)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("registrarSolicitudExpedient(BigDecimal)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_REGISTRAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsRegistrarBDTO respostaExpedientsRegistrarBDTO = new RespostaExpedientsRegistrarBDTO(
		        respostaCrearRegistreSolicitudExpedient, dadesExpedientBDTO.getExpedientsRDTO(), respostaResultatBDTO);
		respostaRegistrarExpedientRDTO = modelMapper.map(respostaExpedientsRegistrarBDTO, RespostaRegistrarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("registrarSolicitudExpedient(BigDecimal) - fi"); //$NON-NLS-1$
		}

		return respostaRegistrarExpedientRDTO;
	}

	/**
	 * Aportar documentacio expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param documentacioAportar
	 *            the documentacio aportar
	 * @return the resposta aportar document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio")
	@ApiOperation(value = "Aportar documentació a l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAportarDocumentRDTO aportarDocumentacioExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la creació del document") @RequestBody DocumentacioAportarRDTO documentacioAportar) {

		RespostaAportarDocumentRDTO respostaAportarDocumentRDTO = null;
		RespostaAportarDocumentacioExpedientRDTO respostaAportarDocumentacioExpedientRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_APORTAR_DOCUMENTACIO_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO,
			        Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT);

			// Las configuraciones de documentación indicadas deben estar
			// asociadas al procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> map = ServeisPortalRestControllerValidationHelper
			        .validateConfiguracioDocumentacioAportada(respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
			                documentacioAportar.getDocumentacio(), Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT);

			// Aportar documentación si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.APORTAR_DOCUMENTACIO, Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de aportar
			// documentació
			AportarDocumentExpedientBDTO aportarDocumentExpedientBDTO = new AportarDocumentExpedientBDTO();
			aportarDocumentExpedientBDTO.setIdExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
			if (CollectionUtils.isNotEmpty(documentacioAportar.getDocumentacio())) {
				ArrayList<DocsEntradaRDTO> docsEntradaRDTOList = new ArrayList<DocsEntradaRDTO>();
				for (DocumentAportatCrearRDTO documentAportatCrearRDTO : documentacioAportar.getDocumentacio()) {
					if (documentAportatCrearRDTO.getFitxer() == null) {
						// Inicialización para que no falle en el mapper el
						// fitxer opcional
						documentAportatCrearRDTO.setFitxer(new FitxerRDTO());
					}
					DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentAportatCrearRDTO, DocsEntradaRDTO.class);
					docsEntradaRDTO.setRevisio(RevisioApiParamValue.PENDENT.getInternalValue());
					docsEntradaRDTO.setOrigen(OrigenApiParamValue.EXTERN.getInternalValue());
					docsEntradaRDTO.setNou(NumberUtils.INTEGER_ONE);
					docsEntradaRDTO.setConfigDocEntrada(map.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
					docsEntradaRDTOList.add(docsEntradaRDTO);
				}
				AportarDocumentacioExpedient aportarDocumentacioExpedient = new AportarDocumentacioExpedient();
				aportarDocumentacioExpedient.setDocsEntrada(docsEntradaRDTOList);
				aportarDocumentExpedientBDTO.setAportarDocumentacioExpedient(aportarDocumentacioExpedient);
			}

			respostaAportarDocumentacioExpedientRDTO = serveisService.aportarDocumentacioExpedient(aportarDocumentExpedientBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("aportarDocumentacioExpedient(BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("aportarDocumentacioExpedient(BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaAportarDocumentExpedientBDTO respostaAportarDocumentExpedientBDTO = new RespostaAportarDocumentExpedientBDTO(
		        respostaAportarDocumentacioExpedientRDTO, respostaResultatBDTO);
		respostaAportarDocumentRDTO = modelMapper.map(respostaAportarDocumentExpedientBDTO, RespostaAportarDocumentRDTO.class);

		// TODO Pendiente integración con Registro
		if (!documentacioAportar.isRegistrar()) {
			respostaAportarDocumentRDTO.setRegistre(null);
		}

		return respostaAportarDocumentRDTO;
	}

	/**
	 * Substituir document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param documentSubstituir
	 *            the document substituir
	 * @return the resposta substituir document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/substituir")
	@ApiOperation(value = "Substituir les dades d'un document de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSubstituirDocumentRDTO substituirDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatSubstituirRDTO documentSubstituir) {

		RespostaSubstituirDocumentRDTO respostaSubstituirDocumentRDTO = null;
		RespostaSubstituirDocumentExpedientRDTO respostaSubstituirDocumentExpedientRDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SUBSTITUIR_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_SUBSTITUIR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisPortalRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_SUBSTITUIR_DOCUMENT_EXPEDIENT);

			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			ServeisPortalRestControllerValidationHelper.validateConfiguracioDocumentacioSubstituir(
			        respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(), documentSubstituir,
			        Resultat.ERROR_SUBSTITUIR_DOCUMENT_EXPEDIENT);

			// Substituir el document si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.SUBSTITUIR_DOCUMENT, Resultat.ERROR_SUBSTITUIR_DOCUMENT_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de aportar
			// documentació
			SubstituirDocumentExpedientBDTO substituirDocumentExpedientBDTO = new SubstituirDocumentExpedientBDTO();
			substituirDocumentExpedientBDTO.setIdExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
			SubstituirDocumentExpedient substituirDocumentExpedient = new SubstituirDocumentExpedient();
			DocsEntradaRDTO docsEntradaRDTOSubstituir = modelMapper.map(documentSubstituir, DocsEntradaRDTO.class);
			docsEntradaRDTOSubstituir.setId(idDocument);
			docsEntradaRDTOSubstituir.setRevisio(RevisioApiParamValue.PENDENT.getInternalValue());
			docsEntradaRDTOSubstituir.setConfigDocEntrada(docsEntradaRDTO.getConfigDocEntrada());
			substituirDocumentExpedient.setDocEntrada(docsEntradaRDTOSubstituir);

			substituirDocumentExpedientBDTO.setSubstituirDocumentExpedient(substituirDocumentExpedient);

			respostaSubstituirDocumentExpedientRDTO = serveisService.substituirDocumentExpedient(substituirDocumentExpedientBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("substituirDocumentExpedient(BigDecimal, BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("substituirDocumentExpedient(BigDecimal, BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_SUBSTITUIR_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaSubstituirDocumentExpedientBDTO respostaSubstituirDocumentExpedientBDTO = new RespostaSubstituirDocumentExpedientBDTO(
		        respostaSubstituirDocumentExpedientRDTO, respostaResultatBDTO);
		respostaSubstituirDocumentRDTO = modelMapper.map(respostaSubstituirDocumentExpedientBDTO, RespostaSubstituirDocumentRDTO.class);

		return respostaSubstituirDocumentRDTO;
	}

	/**
	 * Upload document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @param file
	 *            the file
	 * @return the resposta upload document RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/documentacio/{idDocument}/upload")
	@ApiOperation(value = "Pujar el contingut d'un document de l'expedient al gestor documental", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaUploadDocumentRDTO uploadDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Fitxer") @RequestPart("file") MultipartFile file) {

		RespostaUploadDocumentRDTO respostaUploadDocumentRDTO = null;
		RespostaUploadDocumentExpedient respostaUploadDocumentExpedient = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_UPLOAD_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			DadesExpedientBDTO dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_UPLOAD_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisPortalRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_UPLOAD_DOCUMENT_EXPEDIENT);

			// No hay una acción asociada al upload

			// Se construye el modelo para la llamada a la operación de upload
			// document
			UploadDocumentExpedient uploadDocumentExpedient = new UploadDocumentExpedient();
			// uploadDocumentExpedient.setDocEntrada(modelMapper.map(file,
			// DocsEntradaRDTO.class));
			docsEntradaRDTO.setFileToUploadContent(Base64.encodeBase64String(file.getBytes()));
			docsEntradaRDTO.setFileToUploadName(file.getOriginalFilename());
			docsEntradaRDTO.setFileToUploadType(file.getContentType());
			uploadDocumentExpedient.setDocEntrada(docsEntradaRDTO);
			UploadDocumentExpedientBDTO uploadDocumentExpedientBDTO = new UploadDocumentExpedientBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), uploadDocumentExpedient);

			respostaUploadDocumentExpedient = serveisService.uploadDocumentExpedient(uploadDocumentExpedientBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("uploadDocumentExpedient(BigDecimal, BigDecimal, MultipartFile)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("uploadDocumentExpedient(BigDecimal, BigDecimal, MultipartFile)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_UPLOAD_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaUploadDocumentExpedientBDTO respostaUploadDocumentExpedientBDTO = new RespostaUploadDocumentExpedientBDTO(
		        respostaUploadDocumentExpedient, respostaResultatBDTO);
		respostaUploadDocumentRDTO = modelMapper.map(respostaUploadDocumentExpedientBDTO, RespostaUploadDocumentRDTO.class);

		return respostaUploadDocumentRDTO;
	}

	/**
	 * Esborrar document expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param idDocument
	 *            the id document
	 * @return the resposta esborrar document RDTO
	 */
	@DeleteMapping("/expedients/{codiExpedient}/documentacio/{idDocument}")
	@ApiOperation(value = "Esborrar un document de l'expedient", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsborrarDocumentRDTO esborrarDocumentExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {

		RespostaEsborrarDocumentRDTO respostaEsborrarDocumentRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ESBORRAR_DOCUMENT_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ESBORRAR_DOCUMENT_EXPEDIENT);

			// El id del documento debe existir y pertenecer al expediente
			// indicado
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisPortalRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesExpedientBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_ESBORRAR_DOCUMENT_EXPEDIENT);

			// Esborrar document si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.ESBORRAR_DOCUMENT, Resultat.ERROR_ESBORRAR_DOCUMENT_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de esborrar
			// document
			EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO = new EsborrarDocumentExpedientBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), Arrays.asList(idDocument));
			serveisService.esborrarDocumentExpedient(esborrarDocumentExpedientBDTO);
		} catch (GPAApiParamValidationException e) {
			log.error("esborrarDocumentExpedient(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("esborrarDocumentExpedient(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ESBORRAR_DOCUMENT_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		ExpedientsRDTO expedientsRDTO = (dadesExpedientBDTO != null) ? dadesExpedientBDTO.getExpedientsRDTO() : null;
		RespostaEsborrarDocumentExpedientBDTO respostaEsborrarDocumentExpedientBDTO = new RespostaEsborrarDocumentExpedientBDTO(
		        expedientsRDTO, docsEntradaRDTO, respostaResultatBDTO);
		respostaEsborrarDocumentRDTO = modelMapper.map(respostaEsborrarDocumentExpedientBDTO, RespostaEsborrarDocumentRDTO.class);

		return respostaEsborrarDocumentRDTO;
	}

	/**
	 * Esmenar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param expedientEsmena
	 *            the expedient esmena
	 * @return the resposta esmenar expedient RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/esmena")
	@ApiOperation(value = "Respondre a requeriment o tràmit d'al·legacions o IP", tags = { "Serveis Portal API",
	        "Funcions d'execució d'accions" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsmenarExpedientRDTO esmenarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la esmena de l'expedient") @RequestBody ExpedientEsmenaRDTO expedientEsmena) {

		if (log.isDebugEnabled()) {
			log.debug("esmenarExpedient(BigDecimal, ExpedientEsmenaRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaEsmenarExpedientRDTO respostaEsmenarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ESMENAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_ESMENAR_EXPEDIENT);

			// Las configuraciones de documentación indicadas deben estar
			// asociadas al procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> map = ServeisPortalRestControllerValidationHelper
			        .validateConfiguracioDocumentacioEsmenar(respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
			                expedientEsmena.getDocumentacio(), Resultat.ERROR_ESMENAR_EXPEDIENT);

			// Esmenar expedient si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP, Resultat.ERROR_ESMENAR_EXPEDIENT);

			// Se construye el modelo para la llamada a la operación de esmenar
			// expedient document
			// Se aplica patrón saga con acciones compensatorias:
			// TODO Acciones compensatorias
			// 1. Registro
			// TODO pendiente de integración
			// 2. Aportar documentación
			AportarDocumentExpedientBDTO aportarDocumentExpedientBDTO = new AportarDocumentExpedientBDTO();
			aportarDocumentExpedientBDTO.setIdExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
			if (CollectionUtils.isNotEmpty(expedientEsmena.getDocumentacio())) {
				ArrayList<DocsEntradaRDTO> docsEntradaRDTOList = new ArrayList<DocsEntradaRDTO>();
				for (DocumentRequeritCrearRDTO documentRequeritCrearRDTO : expedientEsmena.getDocumentacio()) {
					DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentRequeritCrearRDTO, DocsEntradaRDTO.class);
					docsEntradaRDTO.setRevisio(RevisioApiParamValue.PENDENT.getInternalValue());
					docsEntradaRDTO.setOrigen(OrigenApiParamValue.EXTERN.getInternalValue());
					docsEntradaRDTO.setNou(NumberUtils.INTEGER_ONE);
					docsEntradaRDTO.setConfigDocEntrada(map.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
					docsEntradaRDTOList.add(docsEntradaRDTO);
				}
				AportarDocumentacioExpedient aportarDocumentacioExpedient = new AportarDocumentacioExpedient();
				aportarDocumentacioExpedient.setDocsEntrada(docsEntradaRDTOList);
				aportarDocumentacioExpedient.setEsmena(Boolean.TRUE);
				aportarDocumentExpedientBDTO.setAportarDocumentacioExpedient(aportarDocumentacioExpedient);
			}
			serveisService.aportarDocumentacioExpedient(aportarDocumentExpedientBDTO);

			// 3. Aportar valores de dades d'operació
			// Se obtienen los Dades d'Operació del procedimiento y se valida
			// que los códigos indicados existen. Se aprovecha para recuperar
			// los identificadores de los campos
			ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
			if (CollectionUtils.isNotEmpty(expedientEsmena.getDadesOperacio())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = serveisService.cercaDadesOperacio(dadesOperacioCercaBDTO);
				dadesEspecifiquesRDTOList = ServeisPortalRestControllerValidationHelper.validateDadesOperacioEsmenarExpedient(
				        expedientEsmena.getDadesOperacio(), respostaDadesOperacioCercaBDTO.getDadesGrupsRDTOList(),
				        dadesExpedientBDTO.getExpedientsRDTO().getId());
			}
			ActualitzarDadesSollicitud actualitzarDadesSollicitud = new ActualitzarDadesSollicitud();
			actualitzarDadesSollicitud.setExpedient(dadesExpedientBDTO.getExpedientsRDTO());
			actualitzarDadesSollicitud.setEsmena(Boolean.TRUE);
			actualitzarDadesSollicitud.setComentari(expedientEsmena.getComentari());
			actualitzarDadesSollicitud.setDadesEspecifiques(dadesEspecifiquesRDTOList);
			ExpedientsActualitzarBDTO expedientsActualitzarBDTO = new ExpedientsActualitzarBDTO(actualitzarDadesSollicitud);
			serveisService.actualitzarSolicitudExpedient(expedientsActualitzarBDTO);

			// 4. Insertar comentario de origen externo
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientEsmena.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(),
			        AccioTramitadorApiParamValue.RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

			// 5. Cambiar el estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
			        ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(),
			        AccioTramitadorApiParamValue.RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("esmenarExpedient(BigDecimal, ExpedientEsmenaRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("esmenarExpedient(BigDecimal, ExpedientEsmenaRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_ESMENAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsEsmenarBDTO respostaExpedientsEsmenarBDTO = new RespostaExpedientsEsmenarBDTO(
		        dadesExpedientBDTO != null ? dadesExpedientBDTO.getExpedientsRDTO() : null, respostaResultatBDTO);
		respostaEsmenarExpedientRDTO = modelMapper.map(respostaExpedientsEsmenarBDTO, RespostaEsmenarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("esmenarExpedient(BigDecimal, ExpedientEsmenaRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaEsmenarExpedientRDTO;
	}

	/**
	 * Abandonar expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param accio
	 *            the accio
	 * @param expedientAbandonament
	 *            the expedient abandonament
	 * @return the resposta abandonar expedient RDTO
	 */
	@PostMapping("/expedients/{codiExpedient}/{accio}")
	@ApiOperation(value = "Desistir/Renunciar l'expedient", tags = { "Serveis Portal API", "Funcions d'execució d'accions" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAbandonarExpedientRDTO abandonarExpedient(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Acció a realitzar amb l'expedient", required = true, allowableValues = AccioAbandonarApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES) @PathVariable String accio,
	        @ApiParam(value = "Dades del abandonament de l'expedient") @RequestBody ExpedientAbandonamentRDTO expedientAbandonament) {

		if (log.isDebugEnabled()) {
			log.debug("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaAbandonarExpedientRDTO respostaAbandonarExpedientRDTO = null;
		DadesExpedientBDTO dadesExpedientBDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_DESISTIR_RENUNCIAR_EXPEDIENT);
		try {
			// El codi del expediente debe existir
			dadesExpedientBDTO = serveisService
			        .consultarDadesBasiquesExpedient(ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient));
			ServeisPortalRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT);

			// Registrar expediente si la acción es permitida
			ServeisPortalRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
			        AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR, Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT);

			// Cambio de estado del expediente
			ExpedientCanviEstatAccio expedientCanviEstatAccio = modelMapper.map(dadesExpedientBDTO.getExpedientsRDTO(),
			        ExpedientCanviEstatAccio.class);
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO = new ExpedientsCanviarEstatAccioBDTO(expedientCanviEstatAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getInternalValue());
			serveisService.canviarEstatAccioExpedient(expedientsCanviarEstatAccioBDTO);

			// Crear comentario
			ComentariCreacioAccio comentariCreacioAccio = new ComentariCreacioAccio();
			comentariCreacioAccio.setComentari(expedientAbandonament.getComentari());
			ComentarisCrearAccioBDTO comentarisCrearAccioBDTO = new ComentarisCrearAccioBDTO(comentariCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getInternalValue());
			serveisService.crearComentariAccio(comentarisCrearAccioBDTO);

			// Crear aviso
			AvisCreacioAccio avisCreacioAccio = new AvisCreacioAccio();
			avisCreacioAccio.setOperacio(accio);
			AvisosCrearAccioBDTO avisosCrearAccioBDTO = new AvisosCrearAccioBDTO(avisCreacioAccio,
			        dadesExpedientBDTO.getExpedientsRDTO().getId(), AccioTramitadorApiParamValue.DESISTIR_RENUNCIAR.getInternalValue());
			serveisService.crearAvisAccio(avisosCrearAccioBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO)", e);
			// $NON-NLS-1$

			respostaResultatBDTO = new RespostaResultatBDTO(Resultat.ERROR_DESISTIR_RENUNCIAR_EXPEDIENT, ErrorPrincipal.ERROR_GENERIC);
		}

		RespostaExpedientsAbandonarBDTO respostaExpedientsAbandonarBDTO = new RespostaExpedientsAbandonarBDTO(
		        dadesExpedientBDTO.getExpedientsRDTO(), respostaResultatBDTO);
		respostaAbandonarExpedientRDTO = modelMapper.map(respostaExpedientsAbandonarBDTO, RespostaAbandonarExpedientRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("abandonarExpedient(BigDecimal, String, ExpedientAbandonamentRDTO) - fi"); //$NON-NLS-1$
		}

		return respostaAbandonarExpedientRDTO;
	}

}