package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.ServeisPortalService;
import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.documents.AportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.SubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.UploadDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAbandonarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.impl.helper.ServeisPortalServiceHelper;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.InputStreamResource;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaUploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaAbandonarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaRegistrarSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ServeisPortalServiceImpl.
 */
@Service
@CommonsLog
public class ServeisPortalServiceImpl implements ServeisPortalService {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisPortalService#cercaProcediments(es.
	 * bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO)
	 */
	@Override
	public RespostaProcedimentsCercaBDTO cercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException {
		RespostaProcedimentsCercaBDTO respostaProcedimentsCercaBDTO = ServeisPortalServiceHelper.loadCercaProcediments(procedimentsService,
		        unitatsGestoresService, procedimentsCercaBDTO);
		return respostaProcedimentsCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisPortalService#cercaUnitatsGestores(
	 * es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.
	 * UnitatsGestoresCercaBDTO)
	 */
	@Override
	public List<UnitatsGestoresRDTO> cercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
	        throws GPAServeisServiceException {
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = ServeisPortalServiceHelper.loadUnitatsGestoresList(unitatsGestoresService,
		        unitatsGestoresCercaBDTO);

		return unitatsGestoresRDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultaDadesUnitatGestora(es.bcn.gpa.gpaserveis.business.dto.
	 * unitatsgestores.UnitatsGestoresCercaBDTO)
	 */
	@Override
	public UnitatsGestoresRDTO consultaDadesUnitatGestora(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
	        throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = ServeisPortalServiceHelper.loadUnitatGestora(unitatsGestoresService,
		        unitatsGestoresCercaBDTO);
		return unitatsGestoresRDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesBasiquesProcediment(java.math.BigDecimal)
	 */
	@Override
	public DadesProcedimentBDTO consultarDadesBasiquesProcediment(BigDecimal idProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisPortalServiceHelper.loadDadesBasiquesProcediment(procedimentsService,
		        idProcediment);
		return dadesProcedimentBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesProcediment(java.math.BigDecimal)
	 */
	@Override
	public DadesProcedimentBDTO consultarDadesProcediment(BigDecimal idProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisPortalServiceHelper.loadDadesProcediment(procedimentsService,
		        unitatsGestoresService, idProcediment);
		return dadesProcedimentBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesProcediment(java.lang.String)
	 */
	@Override
	public DadesProcedimentBDTO consultarDadesProcediment(String codiProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisPortalServiceHelper.loadDadesProcediment(procedimentsService,
		        unitatsGestoresService, codiProcediment);
		return dadesProcedimentBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesTramitOvt(es.bcn.gpa.gpaserveis.business.dto.tramits.
	 * TramitsOvtCercaBDTO)
	 */
	@Override
	public TramitsOvtRDTO consultarDadesTramitOvt(TramitsOvtCercaBDTO tramitsOvtCercaBDTO) throws GPAServeisServiceException {
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = ServeisPortalServiceHelper
		        .loadTramitsOvtRDTO(tramitsService, tramitsOvtCercaBDTO);
		return internalTramitsOvtRDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisPortalService#cercaDadesOperacio(es
	 * .bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO)
	 */
	@Override
	public RespostaDadesOperacioCercaBDTO cercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException {
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = ServeisPortalServiceHelper
		        .loadCercaDadesOperacio(dadesOperacioService, dadesOperacioCercaBDTO);
		return respostaDadesOperacioCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * cercaConfiguracioDocumentacioEntrada(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	public RespostaDocumentsEntradaCercaBDTO cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = ServeisPortalServiceHelper
		        .loadCercaConfiguracioDocumentacioEntrada(documentsService, documentsEntradaCercaBDTO);
		return respostaDocumentsEntradaCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * cercaConfiguracioDocumentacioEntradaPerTramitOvt(es.bcn.gpa.gpaserveis.
	 * business.dto.documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	public RespostaDocumentsEntradaCercaBDTO cercaConfiguracioDocumentacioEntradaPerTramitOvt(
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = ServeisPortalServiceHelper
		        .loadCercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsService, documentsEntradaCercaBDTO);
		return respostaDocumentsEntradaCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisPortalService#cercaExpedients(es.
	 * bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO)
	 */
	@Override
	public RespostaExpedientsCercaBDTO cercaExpedients(ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException {
		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = ServeisPortalServiceHelper.loadCercaExpedients(expedientsService,
		        unitatsGestoresService, expedientsCercaBDTO);
		return respostaExpedientsCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesBasiquesExpedient(java.math.BigDecimal)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesBasiquesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisPortalServiceHelper.loadDadesBasiquesExpedient(expedientsService, tramitsService,
		        idExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesExpedient(java.math.BigDecimal)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisPortalServiceHelper.loadDadesExpedient(expedientsService, unitatsGestoresService,
		        tramitsService, documentsService, dadesOperacioService, idExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesExpedient(java.lang.String)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesExpedient(String codiExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisPortalServiceHelper.loadDadesExpedient(expedientsService, unitatsGestoresService,
		        tramitsService, documentsService, dadesOperacioService, codiExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * crearSollicitudExpedient(es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsCrearBDTO)
	 */
	@Override
	public ExpedientsRDTO crearSollicitudExpedient(ExpedientsCrearBDTO expedientsCrearBDTO) throws GPAServeisServiceException {
		return expedientsService.crearSollicitudExpedient(expedientsCrearBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisPortalService#cercaAccionsPossibles
	 * (java.math.BigDecimal)
	 */
	@Override
	public List<AccionsEstatsRDTO> cercaAccionsPossibles(BigDecimal idAccioEstat) throws GPAServeisServiceException {
		List<AccionsEstatsRDTO> accionsEstatsRDTOList = tramitsService.cercaAccionsPossibles(idAccioEstat);
		return accionsEstatsRDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * actualitzarSolicitudExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsActualitzarBDTO)
	 */
	@Override
	public ExpedientsRDTO actualitzarSolicitudExpedient(ExpedientsActualitzarBDTO expedientsActualitzarBDTO)
	        throws GPAServeisServiceException {
		return expedientsService.actualitzarSolicitudExpedient(expedientsActualitzarBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * aportarDocumentacioExpedient(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .AportarDocumentExpedientBDTO)
	 */
	@Override
	public RespostaAportarDocumentacioExpedientRDTO aportarDocumentacioExpedient(AportarDocumentExpedientBDTO aportarDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		return documentsService.aportarDocumentacioExpedient(aportarDocumentExpedientBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * substituirDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * SubstituirDocumentExpedientBDTO)
	 */
	@Override
	public RespostaSubstituirDocumentExpedientRDTO substituirDocumentExpedient(
	        SubstituirDocumentExpedientBDTO substituirDocumentExpedientBDTO) throws GPAServeisServiceException {
		return documentsService.substituirDocumentExpedient(substituirDocumentExpedientBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * consultarDadesDocumentAportat(java.math.BigDecimal)
	 */
	@Override
	public DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal idExpedient) throws GPAServeisServiceException {
		return documentsService.consultarDadesDocumentAportat(idExpedient);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * esborrarDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * EsborrarDocumentExpedientBDTO)
	 */
	@Override
	public void esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO) throws GPAServeisServiceException {
		documentsService.esborrarDocumentExpedient(esborrarDocumentExpedientBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * descarregarDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .DescarregarDocumentExpedientBDTO)
	 */
	@Override
	public byte[] descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		InputStreamResource inputStreamResource = documentsService.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO);
		// TODO Cambiar el return type de downloadFileEntrada en
		// DocumentacioRestController a ResponseEntity<byte[]>
		// return IOUtils.toByteArray(inputStreamResource.getInputStream());
		return "test".getBytes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * uploadDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * UploadDocumentExpedientBDTO)
	 */
	@Override
	public RespostaUploadDocumentExpedient uploadDocumentExpedient(UploadDocumentExpedientBDTO uploadDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		return documentsService.uploadDocumentExpedient(uploadDocumentExpedientBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisPortalService#
	 * registrarSolicitudExpedient(es.bcn.gpa.gpaserveis.business.dto.expedients
	 * .ExpedientsRegistrarBDTO)
	 */
	@Override
	public RespostaRegistrarSolicitudExpedient registrarSolicitudExpedient(ExpedientsRegistrarBDTO expedientsRegistrarBDTO)
	        throws GPAServeisServiceException {
		return expedientsService.registrarSolicitudExpedient(expedientsRegistrarBDTO);
	}

	@Override
	public RespostaAbandonarExpedient abandonarExpedient(ExpedientsAbandonarBDTO expedientsAbandonarBDTO)
	        throws GPAServeisServiceException {

		RespostaAbandonarExpedient respostaAbandonarExpedient = null;

		switch (expedientsAbandonarBDTO.getAbandonarApiParamValue()) {
		case DESISTIR:
			respostaAbandonarExpedient = expedientsService.abandonarDesistirExpedient(expedientsAbandonarBDTO);
			break;

		case RENUNCIAR:
			respostaAbandonarExpedient = expedientsService.abandonarRenunciarExpedient(expedientsAbandonarBDTO);
			break;

		default:
			break;

		}

		return respostaAbandonarExpedient;
	}

}
