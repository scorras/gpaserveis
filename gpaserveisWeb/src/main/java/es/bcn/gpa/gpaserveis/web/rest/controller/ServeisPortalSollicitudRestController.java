package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentEntradaSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaUploadDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.handler.ServeisRestControllerExceptionHandler;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerValidationHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.OrigenApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs.DadesOperacioApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentacioAportarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.upload.RespostaUploadDocumentSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.RespostaCrearSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.SollicitudCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudCrearHelper;
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
	 * @param idSollicitud the id sollicitud
	 * @param documentacioAportar the documentacio aportar
	 * @return the resposta sollicitud aportar document RDTO
	 */
	@PostMapping(BASE_MAPPING_SOLLICITUD_DOCUMENTACIO)
	@ApiOperation(value = "Aportar documentació a la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaAportarDocumentSollicitudRDTO aportarDocumentacioSollicitud(
	        @ApiParam(value = "Codi de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
	        @ApiParam(value = "Dades de la creació del document") @RequestBody DocumentacioAportarRDTO documentacioAportar) {

		RespostaAportarDocumentSollicitudRDTO respostaAportarDocumentSollicitudRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_APORTAR_DOCUMENTACIO);
		DadesExpedientBDTO dadesExpedientBDTO = null;
		List<DocsEntradaRDTO> docsEntradaRDTORespostaList = null;
		DadesSollicitudBDTO dadesSollicitudBDTO = null; 
		try {
			// Buscar la sol y a partir de la sol obtener el expedient
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_APORTAR_DOCUMENTACIO);
			//dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(dadesSollicitudBDTO.getExpedientsRDTO().getId());
			
			// Las configuraciones de documentación indicadas deben estar
			// asociadas al procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
					dadesSollicitudBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
			        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> map = ServeisRestControllerValidationHelper
			        .validateConfiguracioDocumentacioAportada(respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
			                documentacioAportar.getDocumentacio(), Resultat.ERROR_APORTAR_DOCUMENTACIO);

			
			// Se construye el modelo para la llamada a la operación de aportar
			// documentació
			if (CollectionUtils.isNotEmpty(documentacioAportar.getDocumentacio())) {
				docsEntradaRDTORespostaList = new ArrayList<DocsEntradaRDTO>();
				DocsEntradaRDTO docsEntradaRDTOResposta = null;
				for (DocumentAportatCrearRDTO documentAportatCrearRDTO : documentacioAportar.getDocumentacio()) {
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
		        docsEntradaRDTORespostaList,
		        (dadesExpedientBDTO != null && dadesExpedientBDTO.getExpedientsRDTO() != null) ? dadesExpedientBDTO.getExpedientsRDTO()
		                : null,(dadesSollicitudBDTO != null? dadesSollicitudBDTO.getSollicitudsRDTO() : null),respostaResultatBDTO);
		respostaAportarDocumentSollicitudRDTO = modelMapper.map(respostaAportarDocumentSollicitudBDTO, RespostaAportarDocumentSollicitudRDTO.class);
		
		return respostaAportarDocumentSollicitudRDTO;
	}
	
	/**
	 * Esborrar document.
	 *
	 * @param idSollicitud the id sollicitud
	 * @param idDocument the id document
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
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_APORTAR_DOCUMENTACIO);

			// El id del documento debe existir y pertenecer a la solicitud indicada
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesSollicitudBDTO,
			        Resultat.ERROR_ESBORRAR_DOCUMENT);

			// Se construye el modelo para la llamada a la operación de esborrar document
			EsborrarDocumentBDTO esborrarDocumentBDTO = new EsborrarDocumentBDTO(dadesSollicitudBDTO.getExpedientsRDTO().getId(), idDocument);

			serveisService.esBorrarDocumentacioEntrada(esborrarDocumentBDTO);

		} catch (GPAApiParamValidationException e) {
			log.error("esborrarDocument(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = new RespostaResultatBDTO(e);
		} catch (Exception e) {
			log.error("esborrarDocument(BigDecimal, BigDecimal)", e); //$NON-NLS-1$
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_ESBORRAR_DOCUMENT, e);
		}

		ExpedientsRDTO expedientsRDTO = (dadesSollicitudBDTO != null) ? dadesSollicitudBDTO.getExpedientsRDTO() : null;
		RespostaEsborrarDocumentEntradaSollicitudBDTO respostaEsborrarDocumentEntradaSollicitudBDTO = new RespostaEsborrarDocumentEntradaSollicitudBDTO(expedientsRDTO,
		        docsEntradaRDTO, respostaResultatBDTO, dadesSollicitudBDTO.getSollicitudsRDTO());
		respostaEsborrarDocumentSollicitudRDTO = modelMapper.map(respostaEsborrarDocumentEntradaSollicitudBDTO, RespostaEsborrarDocumentSollicitudRDTO.class);
		

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
			
			dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud);
			ServeisRestControllerValidationHelper.validateSollicitud(dadesSollicitudBDTO, Resultat.ERROR_APORTAR_DOCUMENTACIO);

			// El id del documento debe existir y pertenecer a la solicitud indicada
			docsEntradaRDTO = serveisService.consultarDadesDocumentAportat(idDocument);
			ServeisRestControllerValidationHelper.validateDocumentAportat(docsEntradaRDTO, dadesSollicitudBDTO,
			        Resultat.ERROR_UPLOAD_DOCUMENT);

			// Se valida que venga file o idgestor documental para decidir que operacion realizar
			ServeisRestControllerValidationHelper.validateEntradaUpload(file, idGestorDocumental, Resultat.ERROR_UPLOAD_DOCUMENT);

			// No hay una acción asociada al upload
			if (null != file) {
				// No se debe permitir subir un fichero a una Declaración Responsable
				ServeisRestControllerValidationHelper.validateDocumentUpload(docsEntradaRDTO, Resultat.ERROR_UPLOAD_DOCUMENT);

				// Se construye el modelo para la llamada a la operación de upload document
				GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO = new GuardarDocumentEntradaFitxerBDTO(
						dadesSollicitudBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO, file, null);
				docsEntradaRDTOResposta = serveisService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);
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
		        docsEntradaRDTOResposta, dadesSollicitudBDTO != null? dadesSollicitudBDTO.getExpedientsRDTO() : null, respostaResultatBDTO, dadesSollicitudBDTO != null? dadesSollicitudBDTO.getSollicitudsRDTO() : null);
		respostaUploadDocumentSollicitudRDTO = modelMapper.map(respostaUploadDocumentSollicitudBDTO, RespostaUploadDocumentSollicitudRDTO.class);

		return respostaUploadDocumentSollicitudRDTO;
	}

	/**
	 * Crear solicitud expedient.
	 *
	 * @param codiExpedient the codi expedient
	 * @param sollicitudCrearRDTO the sollicitud crear RDTO
	 * @return the resposta crear expedient RDTO
	 * @throws GPAServeisServiceException             the GPA serveis service exception
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

			// Información del Trámite
			TramitsOvtCercaBDTO tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(
					DadesOperacioApiParamToInternalMapper.getTramitOvtInternalValue(sollicitudCrearRDTO.getCodiTramit()));
			es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = serveisService
					.consultarDadesTramitOvt(tramitsOvtCercaBDTO);

			// Aplicamos el campo de Relación correspondiente a las personas que
			// se relacionan
			sollicitudCrearRDTO.getSollicitant().setRelacio(RelacioPersonaApiParamValue.SOLLICITANT.getApiParamValue());
			sollicitudCrearRDTO.getRepresentant().setRelacio(RelacioPersonaApiParamValue.REPRESENTANT.getApiParamValue());

			// TODO: descomentar lo siguiente cuando se añadan las listas de
			// implicades e interessades a las sol·licituds
			// for (PersonesRDTO personaSollicitud :
			// sollicitudCrearRDTO.getPersonesImplicades()) {
			// if (personaSollicitud.getRelacio() == null)
			// personaSollicitud.setRelacio(RelacioPersonaApiParamValue.ALTRES.getApiParamValue());
			// }
			//
			// for (PersonesRDTO personaSollicitud :
			// sollicitudCrearRDTO.getPersonesInteressades()) {
			// if (personaSollicitud.getRelacio() == null)
			// personaSollicitud.setRelacio(RelacioPersonaApiParamValue.ALTRES.getApiParamValue());
			// }

			SollicitudCrearHelper sollicitudCrearHelper = new SollicitudCrearHelper(sollicitudCrearRDTO, internalTramitsOvtRDTO.getId(),
					dadesExpedientBDTO.getExpedientsRDTO().getId());

			SollicitudsRDTO sollicitudsRDTO = modelMapper.map(sollicitudCrearHelper, SollicitudsRDTO.class);
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

		// Datos principales de la solicitud
		DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud);

		// El identificador de la solicitud debe ser válido
		if (dadesSollicitudBDTO.getSollicitudsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_SOLLICITUDS_NOT_FOUND.getDescripcio());
		}
		SollicitudConsultaRDTO sollicitudConsultaRDTO = modelMapper.map(dadesSollicitudBDTO, SollicitudConsultaRDTO.class);

		respostaConsultaSollicitudsRDTO.setSollicitud(sollicitudConsultaRDTO);

		return respostaConsultaSollicitudsRDTO;
	}

	@GetMapping(value = "/sollicituds/{idSollicitud}/report/exportacio-xml", produces = MediaType.TEXT_PLAIN_VALUE)
	@ApiOperation(value = "Exporta les dades de la sol·licitud en format XML", tags = { "Serveis Portal API" }, extensions = {
	        @Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "consulta", value = "Perfil usuari consulta") }) })
	public ResponseEntity<String> exportarDadesSollicitudXml(
	        @ApiParam(value = "Identificador de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud)
	        throws GPAServeisServiceException {

		// Datos principales de la solicitud
		DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitud(idSollicitud);

		// El identificador de la solicitud debe ser válido
		if (dadesSollicitudBDTO.getSollicitudsRDTO() == null) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_SOLLICITUDS_NOT_FOUND.getDescripcio());
		}

		// TODO Validación de que la solicitud se encuentre registrada (El XML
		// se recupera de Documentum)

		SollicitudConsultaRDTO sollicitudConsultaRDTO = modelMapper.map(dadesSollicitudBDTO, SollicitudConsultaRDTO.class);

		// TODO Recuperar el XML de Documentum
		String dadesXmlBase64 = serveisService.crearXmlDadesSollicitud(sollicitudConsultaRDTO);

		return new ResponseEntity<String>(dadesXmlBase64, HttpStatus.OK);
	}

}