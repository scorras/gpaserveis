package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocsAssociatsIntraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentTramitacioFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AnotarOperacioComptableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentGeneratRegistrarComunicatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.InscriureEnRegistreBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ObtenirPerInteroperabilitatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioRequeritsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.impl.helper.ServeisServiceHelper;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatDigitalitzacioDocumentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaInteroperabilitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaObtenirXmlExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ServeisServiceImpl.
 */
@Service

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
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

	/**
	 * Cerca procediments.
	 *
	 * @param procedimentsCercaBDTO
	 *            the procediments cerca BDTO
	 * @return the resposta procediments cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Cerca unitats gestores.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades unitat gestora.
	 *
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#consultarDadesUnitatGestora
	 * (java.math.BigDecimal)
	 */
	@Override
	public UnitatsGestoresRDTO consultarDadesUnitatGestora(BigDecimal idUnitatGestora) throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = ServeisServiceHelper.loadUnitatGestora(unitatsGestoresService, idUnitatGestora);
		return unitatsGestoresRDTO;
	}

	/**
	 * Consultar dades unitat gestora.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesUnitatGestora(es.bcn.gpa.gpaserveis.business.dto.
	 * unitatsgestores.UnitatsGestoresCercaBDTO)
	 */
	@Override
	public UnitatsGestoresRDTO consultarDadesUnitatGestora(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
			throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = ServeisServiceHelper.loadUnitatGestora(unitatsGestoresService, unitatsGestoresCercaBDTO);
		return unitatsGestoresRDTO;
	}

	/**
	 * Consultar dades basiques procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades procediment.
	 *
	 * @param codiProcediment
	 *            the codi procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades tramit ovt.
	 *
	 * @param tramitsOvtCercaBDTO
	 *            the tramits ovt cerca BDTO
	 * @return the tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Cerca dades operacio.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the resposta dades operacio cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Cerca dades operacio requerits.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the resposta dades operacio requerits cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#cercaDadesOperacioRequerits
	 * (es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO)
	 */
	@Override
	public RespostaDadesOperacioRequeritsCercaBDTO cercaDadesOperacioRequerits(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
			throws GPAServeisServiceException {
		RespostaDadesOperacioRequeritsCercaBDTO respostaDadesOperacioRequeritsCercaBDTO = ServeisServiceHelper
				.loadCercaDadesOperacioRequerits(dadesOperacioService, dadesOperacioCercaBDTO);
		return respostaDadesOperacioRequeritsCercaBDTO;
	}

	/**
	 * Cerca configuracio documentacio entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Cerca configuracio documentacio entrada per tramit ovt.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Cerca configuracio documentacio tramitacio.
	 *
	 * @param documentsTramitacioCercaBDTO
	 *            the documents tramitacio cerca BDTO
	 * @return the resposta documents tramitacio cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * cercaConfiguracioDocumentacioTramitacio(es.bcn.gpa.gpaserveis.business.
	 * dto.documents.DocumentsTramitacioCercaBDTO)
	 */
	@Override
	public RespostaDocumentsTramitacioCercaBDTO cercaConfiguracioDocumentacioTramitacio(
			DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = ServeisServiceHelper
				.loadCercaConfiguracioDocumentacioTramitacio(documentsService, documentsTramitacioCercaBDTO);
		return respostaDocumentsTramitacioCercaBDTO;
	}

	/**
	 * Cerca expedients.
	 *
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the resposta expedients cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades basiques expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades basiques expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Consultar dades expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Crear sollicitud expedient.
	 *
	 * @param expedientsCrearBDTO
	 *            the expedients crear BDTO
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Cerca accions possibles.
	 *
	 * @param idAccioEstat
	 *            the id accio estat
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Actualitzar solicitud expedient.
	 *
	 * @param expedientsActualitzarBDTO
	 *            the expedients actualitzar BDTO
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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

	/**
	 * Crear document entrada.
	 *
	 * @param crearDocumentEntradaBDTO
	 *            the crear document entrada BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearDocumentEntrada(es.bcn
	 * .gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO)
	 */
	@Override
	public DocsEntradaRDTO crearDocumentEntrada(CrearDocumentEntradaBDTO crearDocumentEntradaBDTO) throws GPAServeisServiceException {
		return documentsService.crearDocumentEntrada(crearDocumentEntradaBDTO);
	}

	/**
	 * Crear declaracio responsable.
	 *
	 * @param crearDeclaracioResponsableBDTO
	 *            the crear declaracio responsable BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearDeclaracioResponsable(
	 * es.bcn.gpa.gpaserveis.business.dto.documents.
	 * CrearDeclaracioResponsableBDTO)
	 */
	@Override
	public DocsEntradaRDTO crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO)
			throws GPAServeisServiceException {
		return documentsService.crearDeclaracioResponsable(crearDeclaracioResponsableBDTO);
	}

	/**
	 * Crear document tramitacio.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearDocumentTramitacio(es.
	 * bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO)
	 */
	@Override
	public DocsTramitacioRDTO crearDocumentTramitacio(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
			throws GPAServeisServiceException {
		return documentsService.crearDocumentTramitacio(crearDocumentTramitacioBDTO);
	}

	/**
	 * Actualitzar document entrada.
	 *
	 * @param actualitzarDocumentEntradaBDTO
	 *            the actualitzar document entrada BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#actualitzarDocumentEntrada(
	 * es.bcn.gpa.gpaserveis.business.dto.documents.
	 * ActualitzarDocumentEntradaBDTO)
	 */
	@Override
	public DocsEntradaRDTO actualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO)
			throws GPAServeisServiceException {
		return documentsService.actualitzarDocumentEntrada(actualitzarDocumentEntradaBDTO);
	}

	/**
	 * Actualitzar declaracio responsable.
	 *
	 * @param actualitzarDeclaracioResponsableBDTO
	 *            the actualitzar declaracio responsable BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * actualitzarDeclaracioResponsable(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.ActualitzarDeclaracioResponsableBDTO)
	 */
	@Override
	public DocsEntradaRDTO actualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsableBDTO)
			throws GPAServeisServiceException {
		return documentsService.actualitzarDeclaracioResponsable(actualitzarDeclaracioResponsableBDTO);
	}

	/**
	 * Actualitzar document tramitacio.
	 *
	 * @param actualitzarDocumentTramitacioBDTO
	 *            the actualitzar document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * actualitzarDocumentTramitacio(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.ActualitzarDocumentTramitacioBDTO)
	 */
	@Override
	public DocsTramitacioRDTO actualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO)
			throws GPAServeisServiceException {
		return documentsService.actualitzarDocumentTramitacio(actualitzarDocumentTramitacioBDTO);
	}

	/**
	 * Guardar document entrada fitxer.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * guardarDocumentEntradaFitxer(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .GuardarDocumentEntradaFitxerBDTO)
	 */
	@Override
	public DocsEntradaRDTO guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
			throws GPAServeisServiceException {
		return documentsService.guardarDocumentEntradaFitxer(guardarDocumentEntradaFitxerBDTO);
	}

	/**
	 * Guardar document tramitacio fitxer.
	 *
	 * @param guardarDocumentTramitacioFitxerBDTO
	 *            the guardar document tramitacio fitxer BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * guardarDocumentTramitacioFitxer(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.GuardarDocumentTramitacioFitxerBDTO)
	 */
	@Override
	public DocsTramitacioRDTO guardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO)
			throws GPAServeisServiceException {
		return documentsService.guardarDocumentTramitacioFitxer(guardarDocumentTramitacioFitxerBDTO);
	}

	/**
	 * Guardar requeriment fitxer.
	 *
	 * @param guardarRequerimentFitxerBDTO
	 *            the guardar requeriment fitxer BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#guardarRequerimentFitxer(es
	 * .bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO)
	 */
	@Override
	public DocsTramitacioRDTO guardarRequerimentFitxer(GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO)
			throws GPAServeisServiceException {
		return documentsService.guardarRequerimentFitxer(guardarRequerimentFitxerBDTO);
	}

	/**
	 * Guardar requeriment plantilla.
	 *
	 * @param crearRequerimentBDTO
	 *            the crear requeriment BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#guardarRequerimentPlantilla
	 * (es.bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO)
	 */
	@Override
	public DocsTramitacioRDTO guardarRequerimentPlantilla(CrearRequerimentBDTO crearRequerimentBDTO) throws GPAServeisServiceException {
		return documentsService.guardarRequerimentPlantilla(crearRequerimentBDTO);
	}

	/**
	 * Consultar dades document.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#consultarDadesDocument(java
	 * .math.BigDecimal)
	 */
	@Override
	public DocsRDTO consultarDadesDocument(BigDecimal idDocument) throws GPAServeisServiceException {
		return documentsService.consultarDadesDocument(idDocument);
	}

	/**
	 * Consultar dades document aportat.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesDocumentAportat(java.math.BigDecimal)
	 */
	@Override
	public DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal idDocument) throws GPAServeisServiceException {
		return documentsService.consultarDadesDocumentAportat(idDocument);
	}

	/**
	 * Consultar dades document generat.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesDocumentGenerat(java.math.BigDecimal)
	 */
	@Override
	public DocsTramitacioRDTO consultarDadesDocumentGenerat(BigDecimal idDocument) throws GPAServeisServiceException {
		return documentsService.consultarDadesDocumentGenerat(idDocument);
	}

	/**
	 * Descarregar document entrada expedient.
	 *
	 * @param descarregarDocumentExpedientBDTO
	 *            the descarregar document expedient BDTO
	 * @return the byte[]
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * descarregarDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.DescarregarDocumentExpedientBDTO)
	 */
	@Override
	public byte[] descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO)
			throws GPAServeisServiceException {
		return documentsService.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO);
	}

	/**
	 * Crear registre.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @param tipusDocVinculada
	 *            the tipus doc vinculada
	 * @return the resposta crear registre expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * crearRegistreSolicitudExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsRegistrarBDTO)
	 */
	@Override
	public RespostaCrearRegistreExpedient crearRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO, BigDecimal tipusDocVinculada)
			throws GPAServeisServiceException {
		return expedientsService.crearRegistre(expedientsRegistrarBDTO, tipusDocVinculada);
	}

	/**
	 * Canviar estat expedient.
	 *
	 * @param expedientsCanviarEstatBDTO
	 *            the expedients canviar estat BDTO
	 * @return the resposta canviar estat expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#canviarEstatExpedient(
	 * es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsCanviarEstatBDTO)
	 */
	@Override
	public RespostaCanviarEstatAccioExpedient canviarEstatExpedient(ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO)
			throws GPAServeisServiceException {
		return expedientsService.canviarEstatExpedient(expedientsCanviarEstatBDTO);
	}

	/**
	 * Crear comentari accio.
	 *
	 * @param comentarisCrearAccioBDTO
	 *            the comentaris crear accio BDTO
	 * @return the integer
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearComentariAccio(es.bcn.
	 * gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO)
	 */
	@Override
	public Integer crearComentariAccio(ComentarisCrearAccioBDTO comentarisCrearAccioBDTO) throws GPAServeisServiceException {
		return expedientsService.crearComentariAccio(comentarisCrearAccioBDTO);
	}

	/**
	 * Crear avis accio.
	 *
	 * @param avisosCrearAccioBDTO
	 *            the avisos crear accio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearAvisAccio(es.bcn.gpa.
	 * gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO)
	 */
	@Override
	public void crearAvisAccio(AvisosCrearAccioBDTO avisosCrearAccioBDTO) throws GPAServeisServiceException {
		expedientsService.crearAvisAccio(avisosCrearAccioBDTO);
	}

	/**
	 * Revisar documentacio entrada.
	 *
	 * @param documentAportatValidarBDTO
	 *            the document aportat validar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#revisarDocumentacioEntrada(
	 * es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO)
	 */
	@Override
	public void revisarDocumentacioEntrada(DocumentAportatValidarBDTO documentAportatValidarBDTO) throws GPAServeisServiceException {
		documentsService.revisarDocumentacioEntrada(documentAportatValidarBDTO);
	}

	/**
	 * Crear data xml expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta obtenir xml expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearDataXmlExpedient(java.
	 * math.BigDecimal)
	 */
	@Override
	public RespostaObtenirXmlExpedient crearDataXmlExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		return expedientsService.crearDataXmlExpedient(idExpedient);
	}

	/**
	 * Convidar tramitar expedient.
	 *
	 * @param expedientsConvidarTramitarBDTO
	 *            the expedients convidar tramitar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#convidarTramitarExpedient(
	 * es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsConvidarTramitarBDTO)
	 */
	@Override
	public void convidarTramitarExpedient(ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO) throws GPAServeisServiceException {
		expedientsService.convidarTramitarExpedient(expedientsConvidarTramitarBDTO);
	}

	/**
	 * Gets the plantilla doc vinculada.
	 *
	 * @param idConfDoc
	 *            the id conf doc
	 * @param idDocVinculada
	 *            the id doc vinculada
	 * @return the plantilla doc vinculada
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#getPlantillaDocVinculada(
	 * java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	public RespostaPlantillaDocVinculada getPlantillaDocVinculada(BigDecimal idConfDoc, BigDecimal idDocVinculada)
			throws GPAServeisServiceException {
		return documentsService.getPlantillaDocVinculada(idConfDoc, idDocVinculada);
	}

	/**
	 * Retornar tramitacio expedient.
	 *
	 * @param expedientsRetornarTramitacioBDTO
	 *            the expedients retornar tramitacio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#retornarTramitacioExpedient
	 * (es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsRetornarTramitacioBDTO)
	 */
	@Override
	public void retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO)
			throws GPAServeisServiceException {
		expedientsService.retornarTramitacioExpedient(expedientsRetornarTramitacioBDTO);
	}

	/**
	 * Canviar unitat gestora expedient.
	 *
	 * @param expedientsCanviarUnitatGestoraBDTO
	 *            the expedients canviar unitat gestora BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * canviarUnitatGestoraExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsCanviarUnitatGestoraBDTO)
	 */
	@Override
	public void canviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO expedientsCanviarUnitatGestoraBDTO)
			throws GPAServeisServiceException {
		expedientsService.canviarUnitatGestoraExpedient(expedientsCanviarUnitatGestoraBDTO);
	}

	/**
	 * Associar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * associarRegistreDocumentacioExpedient(es.bcn.gpa.gpaserveis.rest.client.
	 * api.model.gpadocumentacio.DocumentActualizarRegistre)
	 */
	@Override
	public void associarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO)
			throws GPAServeisServiceException {
		documentsService.associarRegistreDocumentacioExpedient(documentActualizarRegistreRDTO);
	}

	/**
	 * Consultar dades registre assentament.
	 *
	 * @param codi
	 *            the codi
	 * @return the registre assentament RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesRegistreAssentament(java.lang.String)
	 */
	@Override
	public RegistreAssentamentRDTO consultarDadesRegistreAssentament(String codi) throws GPAServeisServiceException {
		return expedientsService.consultarDadesRegistreAssentament(codi);
	}

	/**
	 * Associar registre docs ent.
	 *
	 * @param docsEntActualizarRegistreRDTO
	 *            the docs ent actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#associarRegistreDocsEnt(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 * DocsEntActualizarRegistre)
	 */
	@Override
	public void associarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistreRDTO) throws GPAServeisServiceException {
		documentsService.associarRegistreDocsEnt(docsEntActualizarRegistreRDTO);
	}

	/**
	 * Registre documentacio ariadna.
	 *
	 * @param registreDocumentacioExpedient
	 *            the registre documentacio expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#registreDocumentacioAriadna
	 * (es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.
	 * RegistreDocumentacioExpedient)
	 */
	@Override
	public void registreDocumentacioAriadna(RegistreDocumentacioExpedient registreDocumentacioExpedient) throws GPAServeisServiceException {
		expedientsService.registreDocumentacioAriadna(registreDocumentacioExpedient);
	}

	/**
	 * Signar validar document.
	 *
	 * @param signarDocument
	 *            the signar document
	 * @return the peticions portasig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#signarValidarDocument(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument)
	 */
	@Override
	public PeticionsPortasig signarValidarDocument(SignarDocument signarDocument) throws GPAServeisServiceException {
		return documentsService.signarValidarDocument(signarDocument);
	}

	/**
	 * Acumular expedient.
	 *
	 * @param expedientsAcumularBDTO
	 *            the expedients acumular BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#acumularExpedient(es.bcn.
	 * gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO)
	 */
	@Override
	public void acumularExpedient(ExpedientsAcumularBDTO expedientsAcumularBDTO) throws GPAServeisServiceException {
		expedientsService.acumularExpedient(expedientsAcumularBDTO);
	}

	/**
	 * Cerca expedients acumulats.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the resposta expedients cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#cercaExpedientsAcumulats(
	 * java.math.BigDecimal)
	 */
	@Override
	public List<ExpedientsRDTO> cercaExpedientsAcumulats(BigDecimal idExpedient) throws GPAServeisServiceException {
		List<ExpedientsRDTO> expedientsAcumulatsRDTOList = ServeisServiceHelper.loadCercaExpedientsAcumulats(expedientsService,
				idExpedient);
		return expedientsAcumulatsRDTOList;
	}

	/**
	 * Actualitzar dades altra persona implicada.
	 *
	 * @param personesSollicitudRDTO
	 *            the persones sollicitud RDTO
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * actualitzarDadesAltraPersonaImplicada(es.bcn.gpa.gpaserveis.rest.client.
	 * api.model.gpaexpedients.PersonesSollicitudRDTO)
	 */
	@Override
	public List<PersonesSollicitudRDTO> actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO personesSollicitudRDTO)
			throws GPAServeisServiceException {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = expedientsService
				.donarAccesAltraPersonaImplicada(personesSollicitudRDTO);
		return pageDataOfPersonesSollicitudRDTO.getData();
	}

	/**
	 * Obtenir docs tramitacio by notification id.
	 *
	 * @param notificacioId
	 *            the notificacio id
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * obtenirDocsTramitacioByNotificationId(java.lang.Long)
	 */
	@Override
	public DocsTramitacioRDTO obtenirDocsTramitacioByNotificationId(Long notificacioId) throws GPAServeisServiceException {
		return documentsService.obtenirDocsTramitacioByNotificationId(notificacioId);
	}

	/**
	 * Gets the id expedient by documentacio id ext.
	 *
	 * @param documentacio
	 *            the documentacio
	 * @return the id expedient by documentacio id ext
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * getIdExpedientByDocumentacioIdExt(java.math.BigDecimal)
	 */
	@Override
	public BigDecimal getIdExpedientByDocumentacioIdExt(BigDecimal documentacio) throws GPAServeisServiceException {
		return expedientsService.getIdExpedientByDocumentacioIdExt(documentacio);
	}

	/**
	 * Crear notificacio.
	 *
	 * @param documentCrearNotificacioBDTO
	 *            the document crear notificacio BDTO
	 * @return the notificacions RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#crearNotificacio(es.bcn.gpa
	 * .gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO)
	 */
	@Override
	public NotificacionsRDTO crearNotificacio(DocumentCrearNotificacioBDTO documentCrearNotificacioBDTO) throws GPAServeisServiceException {
		return documentsService.crearNotificacio(documentCrearNotificacioBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#callbackNotificacio(es.bcn.
	 * gpa.gpaserveis.business.dto.documents.ActualitzarNotificacioBDTO,
	 * org.springframework.web.multipart.MultipartFile,
	 * org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public void callbackNotificacio(ActualitzarNotificacioBDTO actualitzarNotificacio, MultipartFile docEvidenciaElectronic,
			MultipartFile docEvidenciaPaper) throws GPAServeisServiceException {
		documentsService.callbackNotificacio(actualitzarNotificacio, docEvidenciaElectronic, docEvidenciaPaper);

	}

	/**
	 * Tancar requeriments expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#tancarRequerimentsExpedient
	 * (java.math.BigDecimal)
	 */
	@Override
	public void tancarRequerimentsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		documentsService.tancarRequerimentsExpedient(idDocumentacio);
	}

	/**
	 * Callback porta sig.
	 *
	 * @param callbackPortaSig
	 *            the callback porta sig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#callbackPortaSig(es.bcn.gpa
	 * .gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig)
	 */
	@Override
	public void callbackPortaSig(CallbackPortaSig callbackPortaSig) throws GPAServeisServiceException {
		documentsService.callbackPortaSig(callbackPortaSig);

	}

	/**
	 * Guardar document tramitacio plantilla.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * guardarDocumentTramitacioPlantilla(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.CrearDocumentTramitacioBDTO)
	 */
	@Override
	public DocsTramitacioRDTO guardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
			throws GPAServeisServiceException {
		return documentsService.guardarDocumentTramitacioPlantilla(crearDocumentTramitacioBDTO);
	}

	/**
	 * Crear document entrada digitalitzat.
	 *
	 * @param crearDocumentEntradaDigitalitzarBDTO
	 *            the crear document entrada digitalitzar BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * crearDocumentEntradaDigitalitzat(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.CrearDocumentEntradaDigitalitzarBDTO)
	 */
	@Override
	public DocsEntradaRDTO crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO)
			throws GPAServeisServiceException {
		return documentsService.crearDocumentEntradaDigitalitzat(crearDocumentEntradaDigitalitzarBDTO);
	}

	/**
	 * Crear document tramitacio digitalitzat.
	 *
	 * @param crearDocumentTramitacioDigitalitzarBDTO
	 *            the crear document tramitacio digitalitzar BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * crearDocumentTramitacioDigitalitzat(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.GuardarDocumentTramitacioDigitalitzarBDTO)
	 */
	@Override
	public DocsTramitacioRDTO crearDocumentTramitacioDigitalitzat(
			CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO) throws GPAServeisServiceException {
		return documentsService.crearDocumentTramitacioDigitalitzat(crearDocumentTramitacioDigitalitzarBDTO);
	}

	/**
	 * Registrar comunicat document tramitacio.
	 *
	 * @param documentGeneratRegistrarComunicatBDTO
	 *            the document generat registrar comunicat BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * registrarComunicatDocumentTramitacio(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.DocumentGeneratRegistrarComunicatBDTO)
	 */
	@Override
	public void registrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO documentGeneratRegistrarComunicatBDTO)
			throws GPAServeisServiceException {
		documentsService.registrarComunicatDocumentTramitacio(documentGeneratRegistrarComunicatBDTO);
	}

	/**
	 * Callback digitalitzacio.
	 *
	 * @param callbackDigitalitzacio
	 *            the callback digitalitzacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#callbackDigitalitzacio(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 * CallbackDigitalitzacio)
	 */
	@Override
	public void callbackDigitalitzacio(CallbackDigitalitzacio callbackDigitalitzacio) throws GPAServeisServiceException {
		documentsService.callbackDigitalitzacio(callbackDigitalitzacio);
	}

	/**
	 * Obtenir expedients relacionats.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * obtenirExpedientsRelacionats(java.math.BigDecimal)
	 */
	@Override
	public PageDataOfExpedientsRDTO obtenirExpedientsRelacionats(BigDecimal idExpedient) throws GPAServeisServiceException {
		return expedientsService.obtenirExpedientsRelacionats(idExpedient);
	}

	/**
	 * Associats docs intra.
	 *
	 * @param docsAssociatsIntraBDTO
	 *            the docs associats intra BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#associatsDocsIntra(es.bcn.
	 * gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsAssociatsIntra)
	 */
	@Override
	public void associatsDocsIntra(DocsAssociatsIntraBDTO docsAssociatsIntraBDTO) throws GPAServeisServiceException {
		documentsService.associatsDocsIntra(docsAssociatsIntraBDTO);

	}

	/**
	 * Consultar dades basiques expedient by id documentacio.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * consultarDadesBasiquesExpedientByIdDocumentacio(java.math.BigDecimal)
	 */
	@Override
	public DadesExpedientBDTO consultarDadesBasiquesExpedientByIdDocumentacio(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		BigDecimal idExpedientByDocumentacioIdExt = expedientsService.getIdExpedientByDocumentacioIdExt(idDocumentacio);
		return consultarDadesBasiquesExpedient(idExpedientByDocumentacioIdExt);
	}

	/**
	 * Actualitzar requeriment.
	 *
	 * @param crearRequerimentBDTO
	 *            the crear requeriment BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#actualitzarRequeriment(es.
	 * bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO)
	 */
	@Override
	public DocsTramitacioRDTO actualitzarRequeriment(CrearRequerimentBDTO crearRequerimentBDTO) throws GPAServeisServiceException {
		return documentsService.actualitzarRequeriment(crearRequerimentBDTO);
	}

	/**
	 * Anotar operacio comptable.
	 *
	 * @param anotarOperacioComptableBDTO
	 *            the anotar operacio comptable BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#anotarOperacioComptable(es.
	 * bcn.gpa.gpaserveis.business.dto.expedients.AnotarOperacioComptableBDTO)
	 */
	@Override
	public void anotarOperacioComptable(AnotarOperacioComptableBDTO anotarOperacioComptableBDTO) throws GPAServeisServiceException {
		expedientsService.anotarOperacioComptable(anotarOperacioComptableBDTO);
	}

	/**
	 * Inscriure en registre.
	 *
	 * @param inscriureEnRegistreBDTO
	 *            the inscriure en registre BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#inscriureEnRegistre(es.bcn.
	 * gpa.gpaserveis.business.dto.expedients.InscriureEnRegistreBDTO)
	 */
	@Override
	public void inscriureEnRegistre(InscriureEnRegistreBDTO inscriureEnRegistreBDTO) throws GPAServeisServiceException {
		expedientsService.inscriureEnRegistre(inscriureEnRegistreBDTO);
	}

	/**
	 * Es borrar documentacio entrada.
	 *
	 * @param esborrarDocumentBDTO
	 *            the esborrar document BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	public void esBorrarDocumentacioEntrada(EsborrarDocumentBDTO esborrarDocumentBDTO) throws GPAServeisServiceException {
		documentsService.esBorrarDocumentacioEntrada(esborrarDocumentBDTO);

	}

	/**
	 * Es borrar documentacio tramitacio.
	 *
	 * @param esborrarDocumentBDTO
	 *            the esborrar document BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	public void esBorrarDocumentacioTramitacio(EsborrarDocumentBDTO esborrarDocumentBDTO) throws GPAServeisServiceException {
		documentsService.esBorrarDocumentacioTramitacio(esborrarDocumentBDTO);

	}

	/**
	 * Cerca transicio canvi estat.
	 *
	 * @param idAccio
	 *            the id accio
	 * @param idEstatActual
	 *            the id estat actual
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#cercaTransicioCanviEstat(
	 * java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	public List<AccionsEstatsRDTO> cercaTransicioCanviEstat(BigDecimal idAccio, BigDecimal idEstatActual)
			throws GPAServeisServiceException {

		return tramitsService.cercaTransicioCanviEstat(idAccio, idEstatActual);

	}

	/**
	 * Esborrar registre.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * 
	 * esborrarRegistre(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsRegistrarBDTO)
	 */
	@Override
	public void esborrarRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO) throws GPAServeisServiceException {
		expedientsService.esborrarRegistre(expedientsRegistrarBDTO);
	}

	/**
	 * Desassociar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * desassociarRegistreDocumentacioExpedient(es.bcn.gpa.gpaserveis.rest.
	 * client. api.model.gpadocumentacio.DocumentActualizarRegistre)
	 */
	@Override
	public void desassociarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO)
			throws GPAServeisServiceException {
		documentsService.desassociarRegistreDocumentacioExpedient(documentActualizarRegistreRDTO);
	}

	/**
	 * Comprovar documents signats expedient.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @return the boolean
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * comprovarDocumentsSignatsExpedient(java.math.BigDecimal)
	 */
	@Override
	public Boolean comprovarDocumentsSignatsExpedient(BigDecimal documentacioIdext) throws GPAServeisServiceException {
		return documentsService.comprovarDocumentsSignatsExpedient(documentacioIdext);
	}

	/**
	 * Guardar document entrada fitxer.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * guardarDocumentEntradaGestorDocumental(es.bcn.gpa.gpaserveis.business.dto
	 * .documents .GuardarDocumentEntradaFitxerBDTO)
	 */
	@Override
	public DocsEntradaRDTO guardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
			throws GPAServeisServiceException {
		return documentsService.guardarDocumentEntradaGestorDocumental(guardarDocumentEntradaFitxerBDTO);
	}

	/**
	 * Esborrar comentari.
	 *
	 * @param idComentari
	 *            the id comentari
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#esborrarComentari(java.math
	 * .BigDecimal, java.math.BigDecimal)
	 */
	@Override
	public void esborrarComentari(BigDecimal idComentari, BigDecimal idExpedient) throws GPAServeisServiceException {

		expedientsService.esborrarComentari(idComentari, idComentari);
	}

	/**
	 * Obrir requeriments expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ServeisService#tancarRequerimentsExpedient
	 * (java.math.BigDecimal)
	 */
	@Override
	public void obrirRequerimentsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		documentsService.obrirRequerimentsExpedient(idDocumentacio);
	}

	/**
	 * Tornar enrere expedient.
	 *
	 * @param expedientsTornarEnrereBDTO
	 *            the expedients tornar enrere BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	public void tornarEnrereExpedient(ExpedientsTornarEnrereBDTO expedientsTornarEnrereBDTO) throws GPAServeisServiceException {
		expedientsService.tornarEnrereExpedient(expedientsTornarEnrereBDTO);

	}

	/**
	 * Obtenir per interoperabilitat.
	 *
	 * @param obtenirPerInteroperabilitatBDTO
	 *            the obtenir per interoperabilitat BDTO
	 * @return the resposta interoperabilitat
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	public RespostaInteroperabilitat obtenirPerInteroperabilitat(ObtenirPerInteroperabilitatBDTO obtenirPerInteroperabilitatBDTO)
			throws GPAServeisServiceException {
		return expedientsService.obtenirPerInteroperabilitat(obtenirPerInteroperabilitatBDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ServeisService#
	 * obtenirEstatDigitalitzacioDocument(java.lang.Long)
	 */
	@Override
	public EstatDigitalitzacioDocumentRDTO obtenirEstatDigitalitzacioDocument(Long idDocument) throws GPAServeisServiceException {

		return documentsService.obtenirEstatDigitalitzacioDocument(idDocument);
	}

}
