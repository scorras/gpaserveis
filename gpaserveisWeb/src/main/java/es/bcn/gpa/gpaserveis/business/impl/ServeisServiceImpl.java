package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.ServeisService;
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
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.impl.helper.ServeisServiceHelper;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaUploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaAbandonarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaRegistrarSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaValidarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ServeisServiceImpl.
 */
@Service
@CommonsLog
public class ServeisServiceImpl implements ServeisService {

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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#cercaProcediments(es.
	 * bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO)
	 */
	@Override
	public RespostaProcedimentsCercaBDTO cercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException {
		RespostaProcedimentsCercaBDTO respostaProcedimentsCercaBDTO = ServeisServiceHelper.loadCercaProcediments(procedimentsService,
		        unitatsGestoresService, procedimentsCercaBDTO);
		return respostaProcedimentsCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#cercaUnitatsGestores(
	 * es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.
	 * UnitatsGestoresCercaBDTO)
	 */
	@Override
	public List<UnitatsGestoresRDTO> cercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
	        throws GPAServeisServiceException {
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = ServeisServiceHelper.loadUnitatsGestoresList(unitatsGestoresService,
		        unitatsGestoresCercaBDTO);

		return unitatsGestoresRDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultaDadesUnitatGestora(es.bcn.gpa.gpaserveis.business.dto.
	 * unitatsgestores.UnitatsGestoresCercaBDTO)
	 */
	@Override
	public UnitatsGestoresRDTO consultaDadesUnitatGestora(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
	        throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = ServeisServiceHelper.loadUnitatGestora(unitatsGestoresService, unitatsGestoresCercaBDTO);
		return unitatsGestoresRDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesBasiquesProcediment(java.math.BigDecimal)
	 */
	@Override
	public DadesProcedimentBDTO consultarDadesBasiquesProcediment(BigDecimal idProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisServiceHelper.loadDadesBasiquesProcediment(procedimentsService, idProcediment);
		return dadesProcedimentBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesProcediment(java.math.BigDecimal)
	 */
	@Override
	public DadesProcedimentBDTO consultarDadesProcediment(BigDecimal idProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisServiceHelper.loadDadesProcediment(procedimentsService, unitatsGestoresService,
		        idProcediment);
		return dadesProcedimentBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesProcediment(java.lang.String)
	 */
	@Override
	public DadesProcedimentBDTO consultarDadesProcediment(String codiProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = ServeisServiceHelper.loadDadesProcediment(procedimentsService, unitatsGestoresService,
		        codiProcediment);
		return dadesProcedimentBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesTramitOvt(es.bcn.gpa.gpaserveis.business.dto.tramits.
	 * TramitsOvtCercaBDTO)
	 */
	@Override
	public TramitsOvtRDTO consultarDadesTramitOvt(TramitsOvtCercaBDTO tramitsOvtCercaBDTO) throws GPAServeisServiceException {
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO internalTramitsOvtRDTO = ServeisServiceHelper
		        .loadTramitsOvtRDTO(tramitsService, tramitsOvtCercaBDTO);
		return internalTramitsOvtRDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#cercaDadesOperacio(es
	 * .bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO)
	 */
	@Override
	public RespostaDadesOperacioCercaBDTO cercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException {
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = ServeisServiceHelper.loadCercaDadesOperacio(dadesOperacioService,
		        dadesOperacioCercaBDTO);
		return respostaDadesOperacioCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * cercaConfiguracioDocumentacioEntrada(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	public RespostaDocumentsEntradaCercaBDTO cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = ServeisServiceHelper
		        .loadCercaConfiguracioDocumentacioEntrada(documentsService, documentsEntradaCercaBDTO);
		return respostaDocumentsEntradaCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * cercaConfiguracioDocumentacioEntradaPerTramitOvt(es.bcn.gpa.gpaserveis.
	 * business.dto.documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	public RespostaDocumentsEntradaCercaBDTO cercaConfiguracioDocumentacioEntradaPerTramitOvt(
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = ServeisServiceHelper
		        .loadCercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsService, documentsEntradaCercaBDTO);
		return respostaDocumentsEntradaCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#cercaExpedients(es.
	 * bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO)
	 */
	@Override
	public RespostaExpedientsCercaBDTO cercaExpedients(ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException {
		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = ServeisServiceHelper.loadCercaExpedients(expedientsService,
		        unitatsGestoresService, expedientsCercaBDTO);
		return respostaExpedientsCercaBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesBasiquesExpedient(java.math.BigDecimal)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesBasiquesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisServiceHelper.loadDadesBasiquesExpedient(expedientsService, tramitsService,
		        idExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesBasiquesExpedient(java.lang.String)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesBasiquesExpedient(String codiExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisServiceHelper.loadDadesBasiquesExpedient(expedientsService, tramitsService,
		        codiExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesExpedient(java.math.BigDecimal)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisServiceHelper.loadDadesExpedient(expedientsService, unitatsGestoresService,
		        tramitsService, documentsService, dadesOperacioService, idExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesExpedient(java.lang.String)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesExpedient(String codiExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = ServeisServiceHelper.loadDadesExpedient(expedientsService, unitatsGestoresService,
		        tramitsService, documentsService, dadesOperacioService, codiExpedient);
		return dadesExpedientBDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#cercaAccionsPossibles
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesDocumentAportat(java.math.BigDecimal)
	 */
	@Override
	public DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal idExpedient) throws GPAServeisServiceException {
		return documentsService.consultarDadesDocumentAportat(idExpedient);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * descarregarDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .DescarregarDocumentExpedientBDTO)
	 */
	@Override
	public byte[] descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		return documentsService.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#validarSolicitudExpedient(
	 * es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsValidarBDTO)
	 */
	@Override
	public RespostaValidarExpedient validarSolicitudExpedient(ExpedientsValidarBDTO expedientsValidarBDTO)
	        throws GPAServeisServiceException {
		return expedientsService.validarSolicitudExpedient(expedientsValidarBDTO);
	}

}
