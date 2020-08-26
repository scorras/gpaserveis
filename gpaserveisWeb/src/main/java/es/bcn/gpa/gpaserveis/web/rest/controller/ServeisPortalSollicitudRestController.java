package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentEntradaSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaSubstituirDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaUploadDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaSollicitudsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocsTramPolitiquesSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusMime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitudSollicituds;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudActualitzarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.handler.ServeisRestControllerExceptionHandler;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerSagaHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerValidationHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerVisibilitatHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.common.BooleanApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.IdiomaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.OrigenApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusDocumentacioVinculadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusMimeApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusSignaturaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusIniciacioSollicitudApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.SuportConfeccioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs.DadesOperacioApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentacioAportarSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.DocumentAportatSubstituirRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.RespostaSubstituirDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.upload.RespostaUploadDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.actualitzar.RespostaActualitzarSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.actualitzar.SollicitudActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.RespostaCrearSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.SollicitudCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudActualitzarHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudCrearHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.registrar.RespostaRegistrarSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.registrar.SollicitudRegistrarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.RespostaConsultaSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.SollicitudConsultaRDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;
import net.opentrends.openframe.services.rest.http.HttpHeaders;
import net.opentrends.openframe.services.rest.http.ResponseEntity;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/portal", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Portal API", tags = "Serveis Portal API")

/** The Constant log. */
@CommonsLog
@EntornPropertySource(value = { "classpath:/app/config/gpaserveis.properties" })
public class ServeisPortalSollicitudRestController extends BaseRestController {

	/** The Constant BASE_MAPPING_SOLLICITUD. */
	private static final String BASE_MAPPING_SOLLICITUD = "/sollicituds/{idSollicitud}";

	/** The Constant BASE_MAPPING_SOLLICITUD_DOCUMENTACIO. */
	private static final String BASE_MAPPING_SOLLICITUD_DOCUMENTACIO = BASE_MAPPING_SOLLICITUD + "/documentacio";

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
	 * A aportar documentacio sollicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param documentacioAportar
	 *            the documentacio aportar
	 * @return the resposta sollicitud aportar document RDTO
	 */
	@PostMapping(BASE_MAPPING_SOLLICITUD_DOCUMENTACIO)
	@ApiOperation(value = "Aportar documentació a la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAportarDocumentSollicitudRDTO aportarDocumentacioSollicitud(
	        @ApiParam(value = "Codi de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Dades de la creació del document") @RequestBody DocumentacioAportarSollicitudRDTO documentacioAportarSollicitud) {

		RespostaAportarDocumentSollicitudRDTO respostaAportarDocumentSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_APORTAR_DOCUMENTACIO);
		List<DocsEntradaRDTO> docsEntradaRDTORespostaList = null;
		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		try {
			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			// Buscar la sol y a partir de la sol obtener el expedient
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_APORTAR_DOCUMENTACIO);
			// dadesExpedientBDTO =
			// serveisService.consultarDadesBasiquesExpedient(dadesSollicitudBDTO.getExpedientsRDTO().getId());

			// Las configuraciones de documentación indicadas deben estar
			// asociadas al procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesSollicitudBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> map = ServeisRestControllerValidationHelper
			        .validateConfiguracioDocumentacioAportada(respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
			                documentacioAportarSollicitud.getDocumentacio(), Resultat.ERROR_APORTAR_DOCUMENTACIO);

			// Se construye el modelo para la llamada a la operación de aportar
			// documentació
			if (CollectionUtils.isNotEmpty(documentacioAportarSollicitud.getDocumentacio())) {
				docsEntradaRDTORespostaList = new ArrayList<DocsEntradaRDTO>();
				DocsEntradaRDTO docsEntradaRDTOResposta = null;
				for (DocumentAportatCrearRDTO documentAportatCrearRDTO : documentacioAportarSollicitud.getDocumentacio()) {
					DocsEntradaRDTO docsEntradaRDTO = modelMapper.map(documentAportatCrearRDTO, DocsEntradaRDTO.class);
					docsEntradaRDTO.setRevisio(RevisioApiParamValue.PENDENT.getInternalValue());
					docsEntradaRDTO.setOrigen(docsEntradaRDTO.getOrigen() == null ? OrigenApiParamValue.EXTERN.getInternalValue()
					        : docsEntradaRDTO.getOrigen());
					docsEntradaRDTO.setNou(NumberUtils.INTEGER_ONE);
					docsEntradaRDTO.setConfigDocEntrada(map.get(String.valueOf(docsEntradaRDTO.getConfigDocEntrada())).getId());
					docsEntradaRDTO.setDocsTercers(NumberUtils.INTEGER_ONE);
					docsEntradaRDTO.setSollicitudIdext(idSollicitud);
					docsEntradaRDTO.setEsborrany(1);

					if (BooleanUtils.isTrue(documentAportatCrearRDTO.getDeclaracioResponsable())) {
						CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO = new CrearDeclaracioResponsableBDTO(
						        dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
						docsEntradaRDTOResposta = serveisService.crearDeclaracioResponsable(crearDeclaracioResponsableBDTO);
					} else {
						CrearDocumentEntradaBDTO crearDocumentEntradaBDTO = new CrearDocumentEntradaBDTO(
						        dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
						docsEntradaRDTOResposta = serveisService.crearDocumentEntrada(crearDocumentEntradaBDTO);
					}
					docsEntradaRDTORespostaList.add(docsEntradaRDTOResposta);
				}
			}
		} catch (GPAApiParamValidationException e) {
			log.error("aportarDocumentacioExpedient(BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("aportarDocumentacioExpedient(BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_APORTAR_DOCUMENTACIO, e);
		}

		RespostaAportarDocumentSollicitudBDTO respostaAportarDocumentSollicitudBDTO = new RespostaAportarDocumentSollicitudBDTO(
		        docsEntradaRDTORespostaList, (dadesSollicitudBDTO != null && dadesSollicitudBDTO.getExpedientsRDTO() != null)
		                ? dadesSollicitudBDTO.getExpedientsRDTO() : null,
		        (dadesSollicitudBDTO != null ? dadesSollicitudBDTO.getSollicitudsRDTO() : null), respostaResultatBDTO);
		respostaAportarDocumentSollicitudRDTO = modelMapper.map(respostaAportarDocumentSollicitudBDTO,
		        RespostaAportarDocumentSollicitudRDTO.class);

		return respostaAportarDocumentSollicitudRDTO;
	}

	/**
	 * Esborrar document.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param idDocument
	 *            the id document
	 * @return the resposta esborrar document RDTO
	 */
	@DeleteMapping(BASE_MAPPING_SOLLICITUD_DOCUMENTACIO + "/{idDocument}")
	@ApiOperation(value = "Esborrar un document de la sollicitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaEsborrarDocumentSollicitudRDTO esborrarDocument(
	        @ApiParam(value = "Identificador de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {
		if (log.isDebugEnabled()) {
			log.debug("esborrarDocument(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		RespostaEsborrarDocumentSollicitudRDTO respostaEsborrarDocumentSollicitudRDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ESBORRAR_DOCUMENT);
		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		try {

			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_ESBORRAR_DOCUMENT);

			// El id del documento debe existir y pertenecer a la solicitud
			// indicada
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesSollicitudBDTO,
			        Resultat.ERROR_ESBORRAR_DOCUMENT);

			// Se construye el modelo para la llamada a la operación de esborrar
			// document
			EsborrarDocumentBDTO esborrarDocumentBDTO = new EsborrarDocumentBDTO(dadesSollicitudBDTO.getExpedientsRDTO().getId(),
			        idDocument);

			serveisService.esBorrarDocumentacioEntrada(esborrarDocumentBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("esborrarDocument(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("esborrarDocument(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ESBORRAR_DOCUMENT, e);
		}

		ExpedientsRDTO expedientsRDTO = (dadesSollicitudBDTO != null) ? dadesSollicitudBDTO.getExpedientsRDTO() : null;
		RespostaEsborrarDocumentEntradaSollicitudBDTO respostaEsborrarDocumentEntradaSollicitudBDTO = new RespostaEsborrarDocumentEntradaSollicitudBDTO(
		        expedientsRDTO, docsEntradaRDTO, respostaResultatBDTO,
		        (dadesSollicitudBDTO != null && dadesSollicitudBDTO.getSollicitudsRDTO() != null) ? dadesSollicitudBDTO.getSollicitudsRDTO()
		                : null);
		respostaEsborrarDocumentSollicitudRDTO = modelMapper.map(respostaEsborrarDocumentEntradaSollicitudBDTO,
		        RespostaEsborrarDocumentSollicitudRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("esborrarDocument(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
		}
		return respostaEsborrarDocumentSollicitudRDTO;
	}

	/**
	 * Upload document sol·licitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param idDocument
	 *            the id document
	 * @param file
	 *            the file
	 * @return the resposta upload document RDTO
	 */
	@PostMapping(value = BASE_MAPPING_SOLLICITUD_DOCUMENTACIO + "/{idDocument}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ApiOperation(value = "Pujar el contingut d'un document de la sol·licitud al gestor documental", tags = {
	        "Serveis Portal API" }, extensions = { @Extension(name = "x-imi-roles", properties = {
	                @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	@ApiImplicitParams(@ApiImplicitParam(name = "idGestorDocumental", value = "idGestorDocumental", dataType = "string", paramType = "form", required = false))
	public RespostaUploadDocumentSollicitudRDTO uploadDocumentSollicitud(
	        @ApiParam(value = "Id de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Fitxer") @RequestParam(name = "file", required = false) MultipartFile file,
	        @ApiParam(value = "Identificador Gestor Documental") @RequestParam(name = "idGestorDocumental", required = false) String idGestorDocumental) {

		RespostaUploadDocumentSollicitudRDTO respostaUploadDocumentSollicitudRDTO = null;
		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResposta = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_UPLOAD_DOCUMENT);
		try {

			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_UPLOAD_DOCUMENT);

			// El id del documento debe existir y pertenecer a la solicitud
			// indicada
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesSollicitudBDTO,
			        Resultat.ERROR_UPLOAD_DOCUMENT);

			// Se valida que venga file o idgestor documental para decidir que
			// operacion realizar
			ServeisRestControllerValidationHelper.validateEntradaUpload(file, idGestorDocumental, Resultat.ERROR_UPLOAD_DOCUMENT);

			// No hay una acción asociada al upload
			if (null != file) {
				// No se debe permitir subir un fichero a una Declaración
				// Responsable
				ServeisRestControllerValidationHelper.validateDocumentUpload(docsEntradaRDTO, Resultat.ERROR_UPLOAD_DOCUMENT);

				// Se construye el modelo para la llamada a la operación de
				// upload document
				GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(
				        dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO, file, null);
				docsEntradaRDTOResposta = serveisService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);

				// Preparar datos para registro
				if (docsEntradaRDTO.getConfiguracioDocsEntrada() != null && SuportConfeccioApiParamValue.PLANTILLA.getInternalValue()
				        .equals(docsEntradaRDTO.getConfiguracioDocsEntrada().getSuportConfeccio())) {
					String idDocumentum = docsEntradaRDTOResposta.getMigracioIdOrigen();
					// Guardamo solicitud en pos 1 del doc de entrada en
					// documentum y devuelve el xml de sol
					String xmlSolicitud = guardarXMLSollicitud(dadesSollicitudBDTO, idDocumentum);
					// calculamos el hash del XML y actualizamos la solicitud
					// con el hash
					String hash = DigestUtils.sha256Hex(xmlSolicitud);
					SollicitudsRDTO sollicitud = dadesSollicitudBDTO.getSollicitudsRDTO();
					sollicitud.setHash(hash);
					serveisService.updateSollicitud(sollicitud);

				}
			}
			if (StringUtils.isNotEmpty(idGestorDocumental)) {
				GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(
				        dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO, null, idGestorDocumental);
				docsEntradaRDTOResposta = serveisService.guardarDocumentEntradaGestorDocumental(guardarDocumentEntradaFitxerBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("uploadDocumentExpedient(BigDecimal, BigDecimal, MultipartFile)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("uploadDocumentExpedient(BigDecimal, BigDecimal, MultipartFile)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_UPLOAD_DOCUMENT, e);
		}

		RespostaUploadDocumentSollicitudBDTO respostaUploadDocumentSollicitudBDTO = new RespostaUploadDocumentSollicitudBDTO(
		        docsEntradaRDTOResposta, dadesSollicitudBDTO != null ? dadesSollicitudBDTO.getExpedientsRDTO() : null, respostaResultatBDTO,
		        dadesSollicitudBDTO != null ? dadesSollicitudBDTO.getSollicitudsRDTO() : null);
		respostaUploadDocumentSollicitudRDTO = modelMapper.map(respostaUploadDocumentSollicitudBDTO,
		        RespostaUploadDocumentSollicitudRDTO.class);

		return respostaUploadDocumentSollicitudRDTO;
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
	@GetMapping(value = BASE_MAPPING_SOLLICITUD_DOCUMENTACIO + "/{idDocument}", produces = "*/*")
	@ApiOperation(value = "Descarregar document de la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public ResponseEntity<byte[]> descarregarDocumentSollicitud(
	        @ApiParam(value = "Id de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument) {

		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		try {
			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			ServeisRestControllerValidationHelper.validateDescargaDocumentSollicitud(dadesSollicitudBDTO,
			        Resultat.ERROR_DESCARREGAR_DOCUMENT);

			// El id del documento debe existir y pertenecer al expediente de la
			// solicitud
			DocsRDTO docsRDTO = serveisService.consultarDadesDocument(idDocument);
			ServeisRestControllerValidationHelper.validateDocument(docsRDTO, dadesSollicitudBDTO.getExpedientsRDTO(),
			        Resultat.ERROR_DESCARREGAR_DOCUMENT);

			// Se construye el modelo para la llamada a la operación de
			// descarregar document
			DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO = new DescarregarDocumentExpedientBDTO(
			        dadesSollicitudBDTO.getExpedientsRDTO().getId(), idDocument);
			byte[] result = serveisService.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");
			headers.add("Content-Length", String.valueOf(result.length));
			headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
			String filename = docsRDTO.getDocsFisics().getNom();
			headers.add("Content-Disposition", "attachment; filename=\"" + filename + "\"");

			return new ResponseEntity<byte[]>(result, headers, HttpStatus.OK);

		} catch (GPAApiParamValidationException e) {
			log.error("descarregarDocumentSollicitud(BigDecimal, BigDecimal)", e); //$NON-NLS-1$ type
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("descarregarDocumentSollicitud(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Substituir document sollicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param idDocument
	 *            the id document
	 * @param documentSubstituir
	 *            the document substituir
	 * @return the resposta substituir document sollicitud RDTO
	 */
	@PostMapping(BASE_MAPPING_SOLLICITUD_DOCUMENTACIO + "/{idDocument}/substituir")
	@ApiOperation(value = "Substituir les dades d'un document de la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSubstituirDocumentSollicitudRDTO substituirDocumentSollicitud(
	        @ApiParam(value = "Id de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Identificador del document", required = true) @PathVariable BigDecimal idDocument,
	        @ApiParam(value = "Dades de la versió del document") @RequestBody DocumentAportatSubstituirRDTO documentSubstituir) {

		RespostaSubstituirDocumentSollicitudRDTO respostaSubstituirDocumentSollicitudRDTO = null;
		DocsEntradaRDTO docsEntradaRDTO = null;
		DocsEntradaRDTO docsEntradaRDTOResposta = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_SUBSTITUIR_DOCUMENT);
		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		try {
			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			// El id de sollicitud debe existir
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_SUBSTITUIR_DOCUMENT);

			// El id del documento debe existir y pertenecer a la solicitud
			// indicada
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesSollicitudBDTO,
			        Resultat.ERROR_SUBSTITUIR_DOCUMENT);

			// La configuración de documentación indicada debe estar asociada al
			// procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
			        dadesSollicitudBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> map = ServeisRestControllerValidationHelper
			        .validateConfiguracioDocumentacioSubstituir(respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
			                documentSubstituir, Resultat.ERROR_SUBSTITUIR_DOCUMENT);

			// Se construye el modelo para la llamada a la operación de aportar
			// documentació
			DocsEntradaRDTO docsEntradaRDTOSubstituir = modelMapper.map(documentSubstituir, DocsEntradaRDTO.class);
			docsEntradaRDTOSubstituir.setId(docsEntradaRDTO.getId());
			docsEntradaRDTOSubstituir.setDocumentacio(docsEntradaRDTO.getDocumentacio());
			docsEntradaRDTOSubstituir.setRevisio(docsEntradaRDTO.getRevisio());
			docsEntradaRDTOSubstituir.setConfigDocEntrada(map.get(String.valueOf(docsEntradaRDTOSubstituir.getConfigDocEntrada())).getId());
			docsEntradaRDTOSubstituir.setEsborrany(1);
			if (docsEntradaRDTO.getDocsFisics() != null && docsEntradaRDTOSubstituir.getDocsFisics() != null) {
				docsEntradaRDTOSubstituir.getDocsFisics().setId(docsEntradaRDTO.getDocsFisics().getId());
			}

			if (docsEntradaRDTO.getDeclaracioResponsable()
			        .compareTo(BooleanApiParamValue.TRUE.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
				ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsableBDTO = new ActualitzarDeclaracioResponsableBDTO(
				        dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTOSubstituir);
				docsEntradaRDTOResposta = serveisService.actualitzarDeclaracioResponsable(actualitzarDeclaracioResponsableBDTO);
			} else {
				ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO = new ActualitzarDocumentEntradaBDTO(
				        dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTOSubstituir);
				docsEntradaRDTOResposta = serveisService.actualitzarDocumentEntrada(actualitzarDocumentEntradaBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("substituirDocumentExpedient(BigDecimal, BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("substituirDocumentExpedient(BigDecimal, BigDecimal, List<DocumentAportatCrearRDTO>)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_SUBSTITUIR_DOCUMENT, e);
		}

		RespostaSubstituirDocumentSollicitudBDTO respostaSubstituirDocumentSollicitudBDTO = new RespostaSubstituirDocumentSollicitudBDTO(
		        docsEntradaRDTOResposta,
		        (dadesSollicitudBDTO != null && dadesSollicitudBDTO.getExpedientsRDTO() != null) ? dadesSollicitudBDTO.getExpedientsRDTO()
		                : null,
		        respostaResultatBDTO, (dadesSollicitudBDTO != null && dadesSollicitudBDTO.getSollicitudsRDTO() != null)
		                ? dadesSollicitudBDTO.getSollicitudsRDTO() : null);
		respostaSubstituirDocumentSollicitudRDTO = modelMapper.map(respostaSubstituirDocumentSollicitudBDTO,
		        RespostaSubstituirDocumentSollicitudRDTO.class);

		return respostaSubstituirDocumentSollicitudRDTO;
	}

	/**
	 * Crear solicitud expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param sollicitudCrearRDTO
	 *            the sollicitud crear RDTO
	 * @return the resposta crear expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@PostMapping("expedients/{codiExpedient}/sollicituds")
	@ApiOperation(value = "Crear una sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaCrearSollicitudRDTO crearSolicitud(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable String codiExpedient,
	        @ApiParam(value = "Dades de la creació de la sol·licitud") @RequestBody SollicitudCrearRDTO sollicitudCrearRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearSolicitud(SollicitudCrearRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaCrearSollicitudRDTO respostaCrearSollicitudRDTO = null;
		SollicitudsRDTO returnSollicitudsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_CREAR_SOLLICITUD);
		DadesExpedientBDTO dadesExpedientBDTO = null;
		try {

			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_CREAR_SOLLICITUD);

			// Si se indica alguna persona al menos debe indicarse el
			// Solicitante
			ServeisRestControllerValidationHelper.validateSollicitantCrearSolicitudExpedient(sollicitudCrearRDTO.getSollicitant(),
			        Resultat.ERROR_CREAR_SOLLICITUD);

			// Validaciones
			// 1- Validar que la solicitud que llega no sea SOL (Pedir a Longi)
			ServeisRestControllerValidationHelper.validateTipusSollicitud(sollicitudCrearRDTO.getCodiTramit(),
			        Resultat.ERROR_CREAR_SOLLICITUD);
			// 2- Validar que la acción es permitida en función del tipo de
			// solicitud:
			// APO
			// Aportar documentación si la acción es permitida
			if (StringUtils.equals(sollicitudCrearRDTO.getCodiTramit(), TramitOvtApiParamValue.APO.getApiParamValue())) {
				ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
				        AccioTramitadorApiParamValue.APORTAR_DOCUMENTACIO, Resultat.ERROR_CREAR_SOLLICITUD);
			}
			// REQ / ALE
			// Esmenar expedient si la acción es permitida
			else if (StringUtils.equals(sollicitudCrearRDTO.getCodiTramit(), TramitOvtApiParamValue.REQ.getApiParamValue())
			        || StringUtils.equals(sollicitudCrearRDTO.getCodiTramit(), TramitOvtApiParamValue.ALE.getApiParamValue())) {
				ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
				        AccioTramitadorApiParamValue.RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP, Resultat.ERROR_CREAR_SOLLICITUD);
			}

			// se valida que si la relacion es de persona interesada, solo
			// permita valores sollicitant y representant
			ServeisRestControllerValidationHelper.validatePersonesInteressadesExpedient(sollicitudCrearRDTO.getPersonesInteressades(),
			        Resultat.ERROR_CREAR_SOLLICITUD);
			// 1 - validar que la persona logueada esta dentro de los
			// interesados
			ServeisRestControllerValidationHelper.validateUsuariLogueadoInteressadesExpedient(sollicitudCrearRDTO.getPersonesInteressades(),
			        sollicitudCrearRDTO.getSollicitant(), sollicitudCrearRDTO.getRepresentant(), Resultat.ERROR_CREAR_SOLLICITUD);

			// Información del Trámite
			TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
			        DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(sollicitudCrearRDTO.getCodiTramit()));
			es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = serveisService
			        .consultarDadesTramitOvt(tramitsOvtCercaBDTO);

			// Aplicamos el campo de Relación correspondiente a las personas que
			// se relacionan
			sollicitudCrearRDTO.getSollicitant().setRelacio(RelacioPersonaApiParamValue.SOLLICITANT.getApiParamValue());
			if (sollicitudCrearRDTO.getRepresentant() != null) {
				sollicitudCrearRDTO.getRepresentant().setRelacio(RelacioPersonaApiParamValue.REPRESENTANT.getApiParamValue());
			}

			// 2 - validar que si hay lista de implicados, tengan
			// relacioTerceraPersona y coincida alguna definida en el
			// procedimiento
			if (sollicitudCrearRDTO.getPersonesImplicades() != null) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
				        .consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				ServeisRestControllerValidationHelper.validateTerceresPersonesProcediment(sollicitudCrearRDTO.getPersonesImplicades(),
				        dadesProcedimentBDTO, Resultat.ERROR_CREAR_SOLLICITUD);
			}

			if (sollicitudCrearRDTO.getPersonesInteressades() != null) {
				for (PersonesRDTO personaSollicitud : sollicitudCrearRDTO.getPersonesInteressades()) {
					if (personaSollicitud.getRelacio() == null)
						personaSollicitud.setRelacio(RelacioPersonaApiParamValue.REPRESENTANT.getApiParamValue());
				}
			}

			SollicitudCrearHelper sollicitudCrearHelper = new SollicitudCrearHelper(sollicitudCrearRDTO, internalTramitsOvtRDTO.getId(),
			        dadesExpedientBDTO.getExpedientsRDTO().getId());

			SollicitudsRDTO sollicitudsRDTO = modelMapper.map(sollicitudCrearHelper, SollicitudsRDTO.class);
			sollicitudsRDTO.setIniciacio(TipusIniciacioSollicitudApiParamValue.SOLLICITUD.getInternalValue());
			SollicitudsCrearBDTO sollicitudCrearBDTO = new SollicitudsCrearBDTO(sollicitudsRDTO);

			returnSollicitudsRDTO = serveisService.crearSollicitud(sollicitudCrearBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("crearSolicitud(SollicitudCrearRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("crearSolicitud(SollicitudCrearRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_CREAR_SOLLICITUD, e);
		}

		RespostaSollicitudCrearBDTO respostaSollicitudCrearBDTO = new RespostaSollicitudCrearBDTO(returnSollicitudsRDTO,
		        respostaResultatBDTO, (dadesExpedientBDTO != null && dadesExpedientBDTO.getExpedientsRDTO() != null)
		                ? dadesExpedientBDTO.getExpedientsRDTO() : null);
		respostaCrearSollicitudRDTO = modelMapper.map(respostaSollicitudCrearBDTO, RespostaCrearSollicitudRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("crearSolicitud(SolicitudsCrearRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaCrearSollicitudRDTO;
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
	@PostMapping("/sollicituds/{idSollicitud}")
	@ApiOperation(value = "Actualitzar dades de la sol·licitud de la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaActualitzarSollicitudRDTO actualitzarSollicitud(
	        @ApiParam(value = "Codi de l'expedient", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Dades de la actualització de l'expedient") @RequestBody SollicitudActualitzarRDTO sollicitudActualitzar) {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO) - inici"); //$NON-NLS-1$
		}

		RespostaActualitzarSollicitudRDTO respostaActualitzarSollicitudsRDTO = null;
		SollicitudsRDTO returnSollicitudsRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_ACTUALITZAR_SOLLICITUD);
		try {
			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			// El Id de sol·licitud debe existir
			DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			ServeisRestControllerValidationHelper.validateActualitzarSollicitud(dadesSollicitudBDTO, sollicitudActualitzar,
			        Resultat.ERROR_ACTUALITZAR_SOLLICITUD);

			// Recuperamos los dadesExpedientBDTO para la validación del estado
			DadesExpedientBDTO dadesExpedientBDTO = serveisService.consultarDadesExpedient(dadesSollicitudBDTO.getExpedientsRDTO().getId(),
			        visibilitat);

			// Si se indica alguna persona al menos debe indicarse el
			// Solicitante
			ServeisRestControllerValidationHelper.validateSollicitantActualitzarSolicitudExpedient(sollicitudActualitzar.getSollicitant(),
			        sollicitudActualitzar.getRepresentant());

			// se valida que si la relacion es de persona interesada, solo
			// permita valores sollicitant y representant
			ServeisRestControllerValidationHelper.validatePersonesInteressadesExpedient(sollicitudActualitzar.getPersonesInteressades(),
			        Resultat.ERROR_ACTUALITZAR_SOLLICITUD);

			// Actualizar Solicitante / Representante / Dades d'Operació si se
			// incluyen en los datos de la petición y si la acción es permitida
			if (sollicitudActualitzar.getSollicitant() != null || CollectionUtils.isNotEmpty(sollicitudActualitzar.getDadesOperacio())) {
				ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
				        AccioTramitadorApiParamValue.INFORMAR_DADES_EXPEDIENT, Resultat.ERROR_ACTUALITZAR_SOLLICITUD);
			}

			// Se obtienen los Dades d'Operació del procedimiento y se valida
			// que los códigos indicados existen. Se aprovecha para recuperar
			// los identificadores de los campos
			ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
			if (CollectionUtils.isNotEmpty(sollicitudActualitzar.getDadesOperacio())) {
				DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
				        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
				RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = serveisService.cercaDadesOperacio(dadesOperacioCercaBDTO);
				dadesEspecifiquesRDTOList = ServeisRestControllerValidationHelper.validateDadesOperacioActualitzarSolicitudExpedient(
				        sollicitudActualitzar.getDadesOperacio(), respostaDadesOperacioCercaBDTO.getDadesGrupsRDTOList(),
				        dadesExpedientBDTO.getExpedientsRDTO().getId(), dadesSollicitudBDTO.getSollicitudsRDTO().getId(), true);

			}

			// Aplicamos el campo de Relación correspondiente a las personas que
			// se relacionan
			if (sollicitudActualitzar.getSollicitant() != null) {
				sollicitudActualitzar.getSollicitant().setRelacio(RelacioPersonaApiParamValue.SOLLICITANT.getApiParamValue());
			}
			if (sollicitudActualitzar.getRepresentant() != null) {
				sollicitudActualitzar.getRepresentant().setRelacio(RelacioPersonaApiParamValue.REPRESENTANT.getApiParamValue());
			}

			// 2 - validar que si hay lista de implicados, tengan
			// relacioTerceraPersona y coincida alguna definida en el
			// procedimiento
			if (sollicitudActualitzar.getPersonesImplicades() != null) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
				        .consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				ServeisRestControllerValidationHelper.validateTerceresPersonesProcediment(sollicitudActualitzar.getPersonesImplicades(),
				        dadesProcedimentBDTO, Resultat.ERROR_CREAR_SOLLICITUD);
			}

			if (sollicitudActualitzar.getPersonesInteressades() != null) {
				for (PersonesRDTO personaSollicitud : sollicitudActualitzar.getPersonesInteressades()) {
					if (personaSollicitud.getRelacio() == null)
						personaSollicitud.setRelacio(RelacioPersonaApiParamValue.REPRESENTANT.getApiParamValue());
				}
			}

			SollicitudActualitzarHelper sollicitudActualitzarHelper = new SollicitudActualitzarHelper(sollicitudActualitzar);

			// Se construye el modelo para la llamada a la operación de
			// actualización
			SollicitudsRDTO sollicitudsRDTO = modelMapper.map(sollicitudActualitzarHelper, SollicitudsRDTO.class);
			// Se indica el id del Expediente recibido como path variable
			sollicitudsRDTO.setId(dadesSollicitudBDTO.getSollicitudsRDTO().getId());

			ActualitzarDadesSollicitudSollicituds actualitzarDadesSollicitudSollicituds = new ActualitzarDadesSollicitudSollicituds();
			actualitzarDadesSollicitudSollicituds.setSollicitud(sollicitudsRDTO);
			actualitzarDadesSollicitudSollicituds.setDadesEspecifiques(dadesEspecifiquesRDTOList);
			SollicitudsActualitzarBDTO sollicitudsActualitzarBDTO = new SollicitudsActualitzarBDTO(actualitzarDadesSollicitudSollicituds);
			returnSollicitudsRDTO = serveisService.actualitzarDadesSollicitudSollicituds(sollicitudsActualitzarBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("actualitzarSolicitudExpedient(BigDecimal, ExpedientActualitzarRDTO)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ACTUALITZAR_SOLLICITUD, e);
		}

		RespostaSollicitudsActualitzarBDTO respostaSollicitudsActualitzarBDTO = new RespostaSollicitudsActualitzarBDTO(
		        returnSollicitudsRDTO, respostaResultatBDTO);
		respostaActualitzarSollicitudsRDTO = modelMapper.map(respostaSollicitudsActualitzarBDTO, RespostaActualitzarSollicitudRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitud(BigDecimal, SolicitudsActualitzarRDTO) - fi"); //$NON-NLS-1$
		}
		return respostaActualitzarSollicitudsRDTO;
	}

	/**
	 * Consultar dades sollicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @return the resposta consulta sollicituds RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping("/sollicituds/{idSollicitud}")
	@ApiOperation(value = "Consultar les dades de la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public RespostaConsultaSollicitudsRDTO consultarDadesSollicitud(
	        @ApiParam(value = "Identificador de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud)
	        throws GPAServeisServiceException {

		RespostaConsultaSollicitudsRDTO respostaConsultaSollicitudsRDTO = new RespostaConsultaSollicitudsRDTO();

		BigDecimal visibilitat = BigDecimal.ONE;

		try {
			// TODO GPA-2923
			visibilitat = ServeisRestControllerVisibilitatHelper.obtenirVisibilitatSollicitud(serveisService, idSollicitud,
			        expedientsIdOrgan);
		} catch (GPAApiParamValidationException e) {
			log.error("consultarDadesExpedient(String)", e); //$NON-NLS-1$
			throw new GPAServeisServiceException(e.getResultat().getDescripcio());
		} catch (Exception e) {
			log.error("consultarDadesExpedient(String)", e); //$NON-NLS-1$
			throw new GPAServeisServiceException(e.getMessage());
		}

		// Datos principales de la solicitud
		DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);

		// El identificador de la solicitud debe ser válido
		if (dadesSollicitudBDTO.getSollicitudsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_SOLLICITUDS_NOT_FOUND.getDescripcio());
		}
		SollicitudConsultaRDTO sollicitudConsultaRDTO = modelMapper.map(dadesSollicitudBDTO, SollicitudConsultaRDTO.class);

		respostaConsultaSollicitudsRDTO.setSollicitud(sollicitudConsultaRDTO);

		return respostaConsultaSollicitudsRDTO;
	}

	/**
	 * Exportar dades sollicitud xml.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @return the response entity
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@GetMapping(value = "/sollicituds/{idSollicitud}/report/exportacio-xml", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Exporta les dades de la sol·licitud en format XML", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public ResponseEntity<String> exportarDadesSollicitudXml(
	        @ApiParam(value = "Identificador de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @RequestParam(name = "codiCSV", required = false) String codiCSV) throws GPAServeisServiceException {

		BigDecimal visibilitat = BigDecimal.ONE;

		try {
			// TODO GPA-2923
			visibilitat = ServeisRestControllerVisibilitatHelper.obtenirVisibilitatSollicitud(serveisService, idSollicitud,
			        expedientsIdOrgan);
		} catch (GPAApiParamValidationException e) {
			log.error("consultarDadesExpedient(String)", e); //$NON-NLS-1$
			throw new GPAServeisServiceException(e.getResultat().getDescripcio());
		} catch (Exception e) {
			log.error("consultarDadesExpedient(String)", e); //$NON-NLS-1$
			throw new GPAServeisServiceException(e.getMessage());
		}

		// Datos principales de la solicitud
		DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);

		// El identificador de la solicitud debe ser válido
		if (dadesSollicitudBDTO.getSollicitudsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_SOLLICITUDS_NOT_FOUND.getDescripcio());
		}

		// TODO Validación de que la solicitud se encuentre registrada (El XML
		// se recupera de Documentum)

		SollicitudConsultaRDTO sollicitudConsultaRDTO = modelMapper.map(dadesSollicitudBDTO, SollicitudConsultaRDTO.class);
		sollicitudConsultaRDTO.setCodiCSV(codiCSV);

		// TODO Recuperar el XML de Documentum
		String dadesXmlBase64 = serveisService.crearXmlDadesSollicitud(sollicitudConsultaRDTO);

		return new ResponseEntity<String>(dadesXmlBase64, HttpStatus.OK);
	}

	/**
	 * Registrar solicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @return the resposta registrar sollicitud RDTO
	 */
	@PostMapping("/sollicituds/{idSollicitud}/registre")
	@ApiOperation(value = "Registrar la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaRegistrarSollicitudRDTO registrarSolicitud(
	        @ApiParam(value = "Id de sollicitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Dades de l'registre de la sol·licitud", required = false) @RequestBody(required = false) SollicitudRegistrarRDTO sollicitudRegistrarRDTO) {
		if (log.isDebugEnabled()) {
			log.debug("registrarSolicitud(BigDecimal) - inici"); //$NON-NLS-1$
		}

		RespostaRegistrarSollicitudRDTO respostaRegistrarSollicitudRDTO = null;
		DadesSollicitudBDTO dadesSollicitudBDTO = null;
		RespostaCrearRegistreExpedient respostaCrearRegistreExpedient = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_REGISTRAR_SOLLICITUD);
		DocsTramitacioRDTO respostaCrearJustificant = null;
		ExpedientsRegistrarSollicitudBDTO expedientsRegistrarSollicitudBDTO = null;
		DocsEntActualizarRegistre docsEntActualizarRegistre = null;
		boolean registreDocumentacioAssociat = false;
		boolean registreSollicitudAssociat = false;
		ArrayList<BigDecimal> idDocsEntradaList = new ArrayList<BigDecimal>();
		try {

			// TODO GPA-2923
			BigDecimal visibilitat = BigDecimal.ONE;

			// Datos principales de la solicitud
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);

			// El identificador de la solicitud debe ser válido, no debe ser de
			// tipo SOL y no debe estar ya registrada
			ServeisRestControllerValidationHelper.validateRegistreSollicitud(dadesSollicitudBDTO, Resultat.ERROR_REGISTRAR_SOLLICITUD);

			// Se construye el modelo para la llamada a la operación de registro
			// TODO ¿Cómo procedemos para registrar el XML de la solicitud?
			if (CollectionUtils.isNotEmpty(dadesSollicitudBDTO.getDocumentsAportats())) {
				for (DocsEntradaRDTO docsEntradaRDTO : dadesSollicitudBDTO.getDocumentsAportats()) {
					idDocsEntradaList.add(docsEntradaRDTO.getId());
				}
			}
			CrearSollicitud registreCreacioSolicitud = new CrearSollicitud();
			registreCreacioSolicitud.setSollicitud(dadesSollicitudBDTO.getSollicitudsRDTO());
			registreCreacioSolicitud.setDocuments(idDocsEntradaList);
			expedientsRegistrarSollicitudBDTO = new ExpedientsRegistrarSollicitudBDTO(registreCreacioSolicitud);
			// La documentación vinculada a generar se determina por el tipo de
			// solicitud
			BigDecimal tipusDocumentacioVinculadaInternalValue = (dadesSollicitudBDTO.getSollicitudsRDTO().getTramitOvtIdext()
			        .compareTo(TramitOvtApiParamValue.APO.getInternalValue()) == NumberUtils.INTEGER_ZERO)
			                ? TipusDocumentacioVinculadaApiParamValue.JUSTIFICANT_APORTACIO.getInternalValue()
			                : ((dadesSollicitudBDTO.getSollicitudsRDTO().getTramitOvtIdext()
			                        .compareTo(TramitOvtApiParamValue.REQ.getInternalValue()) == NumberUtils.INTEGER_ZERO)
			                                ? TipusDocumentacioVinculadaApiParamValue.JUSTIFICANT_ESMENA.getInternalValue()
			                                : (TipusDocumentacioVinculadaApiParamValue.JUSTIFICANT_ALLEGACIO.getInternalValue()));
			respostaCrearRegistreExpedient = serveisService.crearRegistreSollicitud(expedientsRegistrarSollicitudBDTO,
			        tipusDocumentacioVinculadaInternalValue);
			registreSollicitudAssociat = true;

			// Asociar registre de la solicitud a la propia solicitud
			// TODO se puede incluir aquí el duplicado de los dades especifiques
			// valors para hacerlos efectivos en el expediente
			SollicitudActualitzarRegistre sollicitudActualitzarRegistre = new SollicitudActualitzarRegistre();
			sollicitudActualitzarRegistre.setIdRegistre(respostaCrearRegistreExpedient.getRegistreAssentament().getId());
			sollicitudActualitzarRegistre.setIdSollicitud(dadesSollicitudBDTO.getSollicitudsRDTO().getId());
			sollicitudActualitzarRegistre.setDataPresentacio(respostaCrearRegistreExpedient.getRegistreAssentament().getDataRegistre());
			if (sollicitudRegistrarRDTO != null) {
				sollicitudActualitzarRegistre.setSignaturaSollicitud(sollicitudRegistrarRDTO.getSignaturaSolicitud());
			}
			serveisService.associarRegistreSollicitud(sollicitudActualitzarRegistre);

			// Asociar registre de la solicitud a los posibles documentos
			// vinculados a la solicitud
			if (CollectionUtils.isNotEmpty(idDocsEntradaList)) {
				docsEntActualizarRegistre = new DocsEntActualizarRegistre();
				docsEntActualizarRegistre.setIdRegistre(respostaCrearRegistreExpedient.getRegistreAssentament().getId());
				docsEntActualizarRegistre.setListIdsDocsEnt(idDocsEntradaList);
				serveisService.associarRegistreDocsEnt(docsEntActualizarRegistre);
				registreDocumentacioAssociat = true;
			}

			// Duplicar los Valores de Datos Específicos para que quede por un
			// lado la foto inmutable en la solicitud y los datos actualizados
			// en el expediente
			// A tener en cuenta:
			// 1- Asociado a cada Dato Específico puede haber 1 o N Valores
			// asociados
			// 2- Si el expediente no tiene valores para el dato específico, se
			// insertan con SOLLICITUD = null
			// 3- Si el expediente ya tiene valores para el dato específico, se
			// eliminan todos y se insertan los nuevos con SOLLICITUD = null
			// 4- Si el expediente tiene valores para datos específicos que no
			// se informan en la solicitud, ¿se deben mantener o eliminar? De
			// momento no eliminamos (lo que viene es lo que hay sólo a nivel de
			// solicitud)
			serveisService.guardarDadesEspecifiquesSollicitud(dadesSollicitudBDTO.getSollicitudsRDTO().getId());

			// Recoger plantilla del Justificante a generar
			// TODO Comprobar que getConfiguracioDocumentacioProc() no es nulo y
			// se está recuperando dentro de la consulta de dades sollicitud
			RespostaPlantillaDocVinculada respostaPlantillaDocVinculada = serveisService.getPlantillaDocVinculada(
			        dadesSollicitudBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), tipusDocumentacioVinculadaInternalValue);

			// Generar Justificant
			DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
			ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
			configuracioDocsTramitacio.setSuportEnllac(respostaPlantillaDocVinculada.getPlantilla());
			configuracioDocsTramitacio.setId(respostaPlantillaDocVinculada.getId());
			// setear la politica que nos devuelve el registro de ariadna
			ConfDocsTramPolitiquesSig confDocsTramPolitiquesSig = new ConfDocsTramPolitiquesSig();
			confDocsTramPolitiquesSig.setConfiguracioDocsTramitacio(configuracioDocsTramitacio.getId());
			confDocsTramPolitiquesSig.setOrdre(new BigDecimal(NumberUtils.INTEGER_ONE));
			confDocsTramPolitiquesSig.setPoliticaSignatura(respostaCrearRegistreExpedient.getPolitic());
			confDocsTramPolitiquesSig.setModalitatIdext(TipusSignaturaApiParamValue.SEGELL.getInternalValue());
			configuracioDocsTramitacio.addConfDocsTramPolitiquesSigListItem(confDocsTramPolitiquesSig);

			docsTramitacioRDTO.setIdioma(IdiomaApiParamValue.CATALA.getInternalValue());
			docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
			docsTramitacioRDTO.setConfigDocTramitacio(respostaPlantillaDocVinculada.getId());
			docsTramitacioRDTO.setOrigen(2);
			docsTramitacioRDTO.setDocsTercers(1);
			docsTramitacioRDTO.setSollicitudIdext(dadesSollicitudBDTO.getSollicitudsRDTO().getId());
			TipusMime tipusMime = new TipusMime();
			tipusMime.setId(TipusMimeApiParamValue.PDF.getInternalValue());
			DocsFisics docsFisics = new DocsFisics();
			docsFisics.setTipusMime(tipusMime);
			docsFisics.setTipus(TipusMimeApiParamValue.PDF.getInternalValue());
			docsTramitacioRDTO.setDocsFisics(docsFisics);
			CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO = new CrearDocumentTramitacioBDTO(
			        dadesSollicitudBDTO.getExpedientsRDTO().getId(), dadesSollicitudBDTO.getSollicitudsRDTO().getId(), docsTramitacioRDTO);
			respostaCrearJustificant = serveisService.guardarDocumentTramitacioJustificantPlantilla(crearDocumentTramitacioBDTO);

			// Obtener el XML y almacenarlo en el Gestor Documental .
			// Asociar el código generado a nivel de Sollicitud, puesto que será
			// el Objeto Documental a utilizar
			String idDocumentum = respostaCrearJustificant.getMigracioIdOrigen();
			// Buscamos de nuevo la solicitud para que incluya los datos de
			// registro
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud, visibilitat);
			guardarXMLSollicitud(dadesSollicitudBDTO, idDocumentum);

			// se llama a segell para firmar el justificante de registro del
			// expediente
			SignarSegellDocument signarSegellDocumentRDTO = new SignarSegellDocument();
			signarSegellDocumentRDTO.setIdDocument(respostaCrearJustificant.getId());
			SignarSegellDocument signarSegellDocumentResponse = serveisService.signarSegellDocument(signarSegellDocumentRDTO);

			// si la firma no es valida se lanza el error
			if (signarSegellDocumentResponse != null && StringUtils.isNotEmpty(signarSegellDocumentResponse.getDescError())) {

				StringBuilder strMessageError = new StringBuilder(Constants.MISSATGE_ERROR_SIGNATURES);
				throw new GPAServeisServiceException(strMessageError.append(": ").append(signarSegellDocumentResponse.getCodiError())
				        .append(": ").append(signarSegellDocumentResponse.getDescError()).toString());
			}

			// TODO Calcular Hash de documento firmado, regenerar el PDF con el
			// hash incrustado y guardarlo bajo el mismo objeto documental
			// serveisService.guardarDocumentTramitacioJustificantPlantillaSignat

			// Vincular Justificante en Ariadna
			RegistreDocumentacioExpedient registreDocumentacioExpedient = new RegistreDocumentacioExpedient();
			try {

				registreDocumentacioExpedient.setIdJustificant(respostaCrearJustificant.getCodi());
				registreDocumentacioExpedient.setNumAss(respostaCrearRegistreExpedient.getRegistreAssentament().getCodi());

				serveisService.registreDocumentacioAriadna(registreDocumentacioExpedient);
			} catch (Exception e) {
				log.error("registrarSolicitudExpedient(BigDecimal): Error retornAssentament", e);// $NON-NLS-1$

				// almacenamos el indicador de que esta pendiente el retorno en
				// el
				// expediente para que continue el registro o la accion
				// correctamente

				dadesSollicitudBDTO.getExpedientsRDTO().setPendentRetorn(NumberUtils.INTEGER_ONE);
				serveisService.actualitzarExpedient(dadesSollicitudBDTO.getExpedientsRDTO());
			}

			// Cambio de estado del expediente:
			// - APO: No hay transición
			// - REQ: Se pasa del 3 al 2
			// - ALE: Se pasa del 5 al 4
			if ((dadesSollicitudBDTO.getSollicitudsRDTO().getTramitOvtIdext()
			        .compareTo(TramitOvtApiParamValue.REQ.getInternalValue()) == NumberUtils.INTEGER_ZERO)
			        || (dadesSollicitudBDTO.getSollicitudsRDTO().getTramitOvtIdext()
			                .compareTo(TramitOvtApiParamValue.ALE.getInternalValue()) == NumberUtils.INTEGER_ZERO)) {
				ExpedientCanviEstat expedientCanviEstat = modelMapper.map(dadesSollicitudBDTO.getExpedientsRDTO(),
				        ExpedientCanviEstat.class);

				// obtenemos el idAccioEstat futuro
				List<AccionsEstatsRDTO> accionsEstatsRDTOList = serveisService.cercaTransicioCanviEstat(
				        AccioTramitadorApiParamValue.RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP.getInternalValue(),
				        dadesSollicitudBDTO.getExpedientsRDTO().getIdEstat());

				// debe existir una transicion posible para el estado actual
				ServeisRestControllerValidationHelper.validateTransicioAccioDisponibleExpedient(accionsEstatsRDTOList,
				        AccioTramitadorApiParamValue.RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP, Resultat.ERROR_REGISTRAR_EXPEDIENT);

				expedientCanviEstat.setIdAccioEstat(accionsEstatsRDTOList.get(0).getId());

				ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO = new ExpedientsCanviarEstatBDTO(expedientCanviEstat,
				        dadesSollicitudBDTO.getExpedientsRDTO().getId());
				serveisService.canviarEstatExpedient(expedientsCanviarEstatBDTO);
			}

		} catch (GPAApiParamValidationException e) {
			log.error("registrarSolicitud(BigDecimal)", e);// $NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("registrarSolicitud(BigDecimal)", e);

			ServeisRestControllerSagaHelper.sagaRegistrarSolicitud(serveisService, dadesSollicitudBDTO, respostaCrearRegistreExpedient,
			        registreSollicitudAssociat, respostaCrearJustificant, docsEntActualizarRegistre, registreDocumentacioAssociat,
			        idDocsEntradaList);

			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_REGISTRAR_SOLLICITUD, e);
		}

		RespostaSollicitudsRegistrarBDTO respostaSollicitudsRegistrarBDTO = new RespostaSollicitudsRegistrarBDTO(
		        respostaCrearRegistreExpedient, respostaCrearJustificant,
		        dadesSollicitudBDTO != null ? dadesSollicitudBDTO.getExpedientsRDTO() : null,
		        dadesSollicitudBDTO != null ? dadesSollicitudBDTO.getSollicitudsRDTO() : null, respostaResultatBDTO);
		respostaRegistrarSollicitudRDTO = modelMapper.map(respostaSollicitudsRegistrarBDTO, RespostaRegistrarSollicitudRDTO.class);

		if (log.isDebugEnabled()) {
			log.debug("registrarSolicitud(BigDecimal) - fi"); //$NON-NLS-1$
		}

		return respostaRegistrarSollicitudRDTO;
	}

	/**
	 * Guardar XML sollicitud.
	 *
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idDocumentum
	 *            the id documentum
	 * @return the string
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private String guardarXMLSollicitud(DadesSollicitudBDTO dadesSollicitudBDTO, String idDocumentum) throws GPAServeisServiceException {
		SollicitudConsultaRDTO sollicitudConsultaRDTO = modelMapper.map(dadesSollicitudBDTO, SollicitudConsultaRDTO.class);
		String xmlDadesSollicitudBase64 = serveisService.crearXmlDadesSollicitud(sollicitudConsultaRDTO);
		String xmlSolicitud = new String(Base64Utils.decodeFromString(xmlDadesSollicitudBase64), StandardCharsets.UTF_8);
		// Guardamos XML en pos 1 de documentum asociado al pdf (pdf: pos 0,
		// xml: pos 1)
		serveisService.guardarXmlSollicitud(idDocumentum, xmlSolicitud);
		return xmlSolicitud;
	}

}