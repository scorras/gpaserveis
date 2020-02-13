package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.DateTime;
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
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.handler.ServeisRestControllerExceptionHandler;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.ServeisRestControllerValidationHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.OrigenApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.RevisioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs.DadesOperacioApiParamToInternalMapper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds.SollicitudAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentacioAportarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaSollicitudAportarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.RespostaCrearSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.SollicitudCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudCrearHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;

/**
 * The Class ServeisPortalRestController.
 */
@RestController
@RequestMapping(value = "/serveis/portal", produces = MediaType.APPLICATION_JSON_VALUE)
@Lazy(true)
@Api(value = "Serveis Portal API", tags = "Serveis Portal API")
@CommonsLog
@EntornPropertySource(value = { "classpath:/app/config/gpaserveis.properties" })
public class ServeisPortalSollicitudRestController extends BaseRestController {

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
	 * Aportar documentacio sol·licitud.
	 *
	 * @param idSollicitud
	 *            the codi sollicitud
	 * @param documentacioAportar
	 *            the documentacio aportar
	 * @return the resposta sollicitud aportar document RDTO
	 */
	@PostMapping("/sollicitud/{idSollicitud}/documentacio")
	@ApiOperation(value = "Aportar documentació a la sol·licitud", tags = { "Serveis Portal API" }, extensions = {
			@Extension(name = "x-imi-roles", properties = { @ExtensionProperty(name = "gestor", value = "Perfil usuari gestor") }) })
	public RespostaSollicitudAportarDocumentRDTO sollicitudAportarDocumentacioExpedient(
			@ApiParam(value = "Codi de la sol·licitud", required = true) @PathVariable BigDecimal idSollicitud,
			@ApiParam(value = "Dades de la creació del document") @RequestBody DocumentacioAportarRDTO documentacioAportar) {

		RespostaSollicitudAportarDocumentRDTO respostaSollicitudAportarDocumentRDTO = null;
		RespostaResultatBDTO respostaResultatBDTO = new RespostaResultatBDTO(Resultat.OK_APORTAR_DOCUMENTACIO_EXPEDIENT);
		DadesExpedientBDTO dadesExpedientBDTO = null;
		List<DocsEntradaRDTO> docsEntradaRDTORespostaList = null;
		DocsTramitacioRDTO respostaCrearJustificant = null;
		RespostaCrearRegistreExpedient respostaCrearRegistreExpedient = null;
		try {
			// Buscar la sol y a partir de la sol obtener el expedient
			// TODO: recuperar del servicio de obtener sol
			SollicitudsRDTO sol = new SollicitudsRDTO();
			dadesExpedientBDTO = serveisService.consultarDadesBasiquesExpedient(sol.getExpedient());
			ServeisRestControllerValidationHelper.validateExpedient(dadesExpedientBDTO, Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT);

			// Las configuraciones de documentación indicadas deben estar
			// asociadas al procedimiento del expediente
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO = new DocumentsEntradaCercaBDTO(
					dadesExpedientBDTO.getExpedientsRDTO().getConfiguracioDocumentacioProc(), null);
			RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = serveisService
					.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
			HashMap<String, ConfiguracioDocsEntradaRDTO> map = ServeisRestControllerValidationHelper
					.validateConfiguracioDocumentacioAportada(respostaDocumentsEntradaCercaBDTO.getConfiguracioDocsEntradaRDTOList(),
							documentacioAportar.getDocumentacio(), Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT);

			// Aportar documentación si la acción es permitida
			ServeisRestControllerValidationHelper.validateAccioDisponibleExpedient(dadesExpedientBDTO,
					AccioTramitadorApiParamValue.APORTAR_DOCUMENTACIO, Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT);

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
					// docsEntradaRDTO.setSollicitudIdext(idSollicitud);

					if (BooleanUtils.isTrue(documentAportatCrearRDTO.getDeclaracioResponsable())) {
						CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO = new CrearDeclaracioResponsableBDTO(
								dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
						docsEntradaRDTOResposta = serveisService.crearDeclaracioResponsable(crearDeclaracioResponsableBDTO);
					} else {
						CrearDocumentEntradaBDTO crearDocumentEntradaBDTO = new CrearDocumentEntradaBDTO(
								dadesExpedientBDTO.getExpedientsRDTO().getId(), docsEntradaRDTO);
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
			respostaResultatBDTO = ServeisRestControllerExceptionHandler.handleException(Resultat.ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT, e);
		}

		RespostaAportarDocumentExpedientBDTO respostaAportarDocumentExpedientBDTO = new RespostaAportarDocumentExpedientBDTO(
				docsEntradaRDTORespostaList,
				(dadesExpedientBDTO != null && dadesExpedientBDTO.getExpedientsRDTO() != null) ? dadesExpedientBDTO.getExpedientsRDTO()
						: null,
				(respostaCrearRegistreExpedient != null && respostaCrearRegistreExpedient.getRegistreAssentament() != null)
						? respostaCrearRegistreExpedient.getRegistreAssentament() : null,
				respostaCrearJustificant != null ? respostaCrearJustificant.getId() : null, respostaResultatBDTO);
		respostaSollicitudAportarDocumentRDTO = modelMapper.map(respostaAportarDocumentExpedientBDTO,
				RespostaSollicitudAportarDocumentRDTO.class);
		SollicitudAccioRDTO sollicitudAccio = new SollicitudAccioRDTO();
		sollicitudAccio.setId(idSollicitud);
		respostaSollicitudAportarDocumentRDTO.setSollicitud(sollicitudAccio);

		return respostaSollicitudAportarDocumentRDTO;
	}

	/**
	 * Crear sollicitud by dades expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @return the sollicituds crear BDTO
	 */
	public SollicitudsCrearBDTO crearSollicitudByDadesExpedient(DadesExpedientBDTO dadesExpedientBDTO, BigDecimal tramitOvtIdext) {
		SollicitudsRDTO sollicitud = new SollicitudsRDTO();

		if (dadesExpedientBDTO.getExpedientsRDTO() != null) {
			sollicitud.setExpedient(dadesExpedientBDTO.getExpedientsRDTO().getId());
			sollicitud.setTramitador(dadesExpedientBDTO.getExpedientsRDTO().getTramitador());
			sollicitud.setProcedimentIdext(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());
			sollicitud.setUnitatGestoraIdext(dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
		}
		DateTime currentDateTime = new DateTime();
		sollicitud.setDataSollicitud(currentDateTime);
		sollicitud.setDataPresentacio(currentDateTime);
		sollicitud.setTramitOvtIdext(tramitOvtIdext);

		return new SollicitudsCrearBDTO(sollicitud);
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
			es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO tramitsOvtRDTO = modelMapper
					.map(internalTramitsOvtRDTO, es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO.class);

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

			SollicitudCrearHelper sollicitudCrearHelper = new SollicitudCrearHelper(sollicitudCrearRDTO, tramitsOvtCercaBDTO.getId());

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

}