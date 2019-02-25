package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class ServeisPortalRestControllerHelper.
 */
public class ServeisPortalRestControllerHelper {

	/**
	 * Load unitats gestores list.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static List<UnitatsGestoresRDTO> loadUnitatsGestoresList(UnitatsGestoresService unitatsGestoresService,
	        UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException {
		PageDataOfUnitatsGestoresRDTO pageDataOfUnitatsGestoresRDTO = unitatsGestoresService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = pageDataOfUnitatsGestoresRDTO.getData();
		return unitatsGestoresRDTOList;
	}

	/**
	 * Load cerca procediments.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param procedimentsCercaBDTO
	 *            the procediments cerca BDTO
	 * @return the resposta procediments cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaProcedimentsCercaBDTO loadCercaProcediments(ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException {
		RespostaProcedimentsCercaBDTO respostaProcedimentsCercaBDTO = new RespostaProcedimentsCercaBDTO();
		ArrayList<DadesProcedimentBDTO> dadesProcedimentBDTOList = new ArrayList<DadesProcedimentBDTO>();
		DadesProcedimentBDTO dadesProcedimentBDTO = null;

		PageDataOfProcedimentsRDTO pageDataOfProcedimentsRDTO = procedimentsService.cercaProcediments(procedimentsCercaBDTO);

		for (ProcedimentsRDTO procedimentsRDTO : pageDataOfProcedimentsRDTO.getData()) {
			dadesProcedimentBDTO = new DadesProcedimentBDTO();
			dadesProcedimentBDTO.setProcedimentsRDTO(procedimentsRDTO);

			loadUgr(unitatsGestoresService, dadesProcedimentBDTO, procedimentsRDTO.getUgrIdext());
			loadUgoList(unitatsGestoresService, dadesProcedimentBDTO, procedimentsRDTO.getUgosList());

			dadesProcedimentBDTOList.add(dadesProcedimentBDTO);
		}

		respostaProcedimentsCercaBDTO.setDadesProcedimentBDTOList(dadesProcedimentBDTOList);
		respostaProcedimentsCercaBDTO.setPaginationAttributes(pageDataOfProcedimentsRDTO.getPage());

		return respostaProcedimentsCercaBDTO;
	}

	/**
	 * Load dades basiques procediment.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesProcedimentBDTO loadDadesBasiquesProcediment(ProcedimentsService procedimentsService, BigDecimal idProcediment)
	        throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = new DadesProcedimentBDTO();

		loadProcediments(procedimentsService, dadesProcedimentBDTO, idProcediment);

		return dadesProcedimentBDTO;
	}

	/**
	 * Load dades procediment.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesProcedimentBDTO loadDadesProcediment(ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, BigDecimal idProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = new DadesProcedimentBDTO();

		loadProcediments(procedimentsService, dadesProcedimentBDTO, idProcediment);
		// TODO De momento quitar de la respuesta los trámites
		// loadTramitsRDTOList(dadesProcedimentRDTO, idProcediment);
		loadUgr(unitatsGestoresService, dadesProcedimentBDTO, dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext());
		loadUgoList(unitatsGestoresService, dadesProcedimentBDTO, dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList());

		return dadesProcedimentBDTO;
	}

	/**
	 * Load cerca expedients.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the resposta expedients cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaExpedientsCercaBDTO loadCercaExpedients(ExpedientsService expedientsService,
	        UnitatsGestoresService unitatsGestoresService, ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException {
		RespostaExpedientsCercaBDTO respostaExpedientsCercaBDTO = new RespostaExpedientsCercaBDTO();
		ArrayList<DadesExpedientBDTO> dadesExpedientBDTOList = new ArrayList<DadesExpedientBDTO>();
		DadesExpedientBDTO dadesExpedientBDTO = null;

		PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = expedientsService.cercaExpedients(expedientsCercaBDTO);

		for (ExpedientsRDTO expedientsRDTO : pageDataOfExpedientsRDTO.getData()) {
			dadesExpedientBDTO = new DadesExpedientBDTO();
			dadesExpedientBDTO.setExpedientsRDTO(expedientsRDTO);

			loadUnitatGestora(unitatsGestoresService, dadesExpedientBDTO, expedientsRDTO.getUnitatGestoraIdext());

			dadesExpedientBDTOList.add(dadesExpedientBDTO);
		}

		respostaExpedientsCercaBDTO.setDadesExpedientBDTOList(dadesExpedientBDTOList);
		respostaExpedientsCercaBDTO.setPaginationAttributes(pageDataOfExpedientsRDTO.getPage());

		return respostaExpedientsCercaBDTO;
	}

	/**
	 * Load dades expedient.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param tramitsService
	 *            the tramits service
	 * @param documentsService
	 *            the documents service
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesExpedientBDTO loadDadesExpedient(ExpedientsService expedientsService, UnitatsGestoresService unitatsGestoresService,
	        TramitsService tramitsService, DocumentsService documentsService, BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = new DadesExpedientBDTO();

		loadExpedients(expedientsService, dadesExpedientBDTO, idExpedient);
		loadUnitatGestora(unitatsGestoresService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
		loadHistoricsList(expedientsService, dadesExpedientBDTO, idExpedient);
		loadPersonesInteressades(expedientsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getSollicitud());
		loadAltresPersonesImplicades(expedientsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getSollicitud());
		loadAccionsPossibles(tramitsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());
		loadDocumentsAportats(documentsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext());
		loadDocumentsRequerits(documentsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext());

		return dadesExpedientBDTO;
	}

	/**
	 * Load procediments.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param idProcediment
	 *            the id procediment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadProcediments(ProcedimentsService procedimentsService, DadesProcedimentBDTO dadesProcedimentBDTO,
	        BigDecimal idProcediment) throws GPAServeisServiceException {
		ProcedimentsRDTO procedimentsRDTO = procedimentsService.consultarDadesProcediment(idProcediment);
		dadesProcedimentBDTO.setProcedimentsRDTO(procedimentsRDTO);
	}

	/**
	 * Load tramits list.
	 *
	 * @param tramitsService
	 *            the tramits service
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param idProcediment
	 *            the id procediment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadTramitsList(TramitsService tramitsService, DadesProcedimentBDTO dadesProcedimentBDTO, BigDecimal idProcediment)
	        throws GPAServeisServiceException {
		PageDataOfTramitsRDTO pageDataOfTramitsRDTO = tramitsService.cercaTramitsProcediment(idProcediment);
		dadesProcedimentBDTO.setTramitsRDTOList(pageDataOfTramitsRDTO.getData());
	}

	/**
	 * Load ugr.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param idUgr
	 *            the id ugr
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUgr(UnitatsGestoresService unitatsGestoresService, DadesProcedimentBDTO dadesProcedimentBDTO, BigDecimal idUgr)
	        throws GPAServeisServiceException {
		UnitatsGestoresRDTO ugrRDTO = unitatsGestoresService.consultarDadesUnitatGestora(idUgr);
		dadesProcedimentBDTO.setUgrRDTO(ugrRDTO);
	}

	/**
	 * Load ugo list.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param procedimentsUgosList
	 *            the procediments ugos list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUgoList(UnitatsGestoresService unitatsGestoresService, DadesProcedimentBDTO dadesProcedimentBDTO,
	        List<ProcedimentsUgos> procedimentsUgosList) throws GPAServeisServiceException {
		ArrayList<UnitatsGestoresRDTO> ugoRDTOList = new ArrayList<UnitatsGestoresRDTO>();
		if (CollectionUtils.isNotEmpty(procedimentsUgosList)) {
			UnitatsGestoresRDTO ugoRDTO = null;
			for (ProcedimentsUgos procedimentsUgos : procedimentsUgosList) {
				ugoRDTO = unitatsGestoresService.consultarDadesUnitatGestora(procedimentsUgos.getUgoIdext());
				ugoRDTOList.add(ugoRDTO);
			}
		}
		dadesProcedimentBDTO.setUgoRDTOList(ugoRDTOList);
	}

	/**
	 * Load unitat gestora.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUnitatGestora(UnitatsGestoresService unitatsGestoresService, DadesExpedientBDTO dadesExpedientBDTO,
	        BigDecimal idUnitatGestora) throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresService.consultarDadesUnitatGestora(idUnitatGestora);
		dadesExpedientBDTO.setUnitatsGestoresRDTO(unitatsGestoresRDTO);
	}

	/**
	 * Load historics list.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadHistoricsList(ExpedientsService expedientsService, DadesExpedientBDTO dadesExpedientBDTO,
	        BigDecimal idExpedient) throws GPAServeisServiceException {
		List<EstatsRDTO> estatsRDTOList = expedientsService.cercaHistoricsEstatsExpedient(idExpedient);
		dadesExpedientBDTO.setHistoricsEstats(estatsRDTOList);
	}

	/**
	 * Load persones interessades.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idSolicitud
	 *            the id solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadPersonesInteressades(ExpedientsService expedientsService, DadesExpedientBDTO dadesExpedientBDTO,
	        BigDecimal idSolicitud) throws GPAServeisServiceException {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = expedientsService
		        .cercaPersonesInteresadesExpedient(idSolicitud);
		// Se separan el solicitante principal y representante principal del
		// resto de personas interesadas
		Persones sollicitantPrincipal = null;
		Persones representantPrincipal = null;
		ArrayList<Persones> personesInteressadesList = new ArrayList<Persones>();
		for (PersonesSollicitudRDTO personesSollicitudRDTO : pageDataOfPersonesSollicitudRDTO.getData()) {
			if (personesSollicitudRDTO.getRelacioPrincipal().equals(Constants.PERSONES_SOLLICITUD_RELACIO_PRINCIPAL)) {
				if (personesSollicitudRDTO.getRelacio().equals(Constants.PERSONES_SOLLICITUD_RELACIO_SOLLICITANT)) {
					sollicitantPrincipal = personesSollicitudRDTO.getPersones();
				} else if (personesSollicitudRDTO.getRelacio().equals(Constants.PERSONES_SOLLICITUD_RELACIO_REPRESENTANT)) {
					representantPrincipal = personesSollicitudRDTO.getPersones();
				}
			} else {
				personesInteressadesList.add(personesSollicitudRDTO.getPersones());
			}
		}
		dadesExpedientBDTO.setSollicitant(sollicitantPrincipal);
		dadesExpedientBDTO.setRepresentant(representantPrincipal);
		dadesExpedientBDTO.setPersonesInteressades(personesInteressadesList);
	}

	/**
	 * Load altres persones implicades.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idSolicitud
	 *            the id solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadAltresPersonesImplicades(ExpedientsService expedientsService, DadesExpedientBDTO dadesExpedientBDTO,
	        BigDecimal idSolicitud) throws GPAServeisServiceException {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = expedientsService
		        .cercaAltresPersonesImplicadesExpedient(idSolicitud);
		ArrayList<Persones> altresPersonesImplicadesList = new ArrayList<Persones>();
		for (PersonesSollicitudRDTO personesSollicitudRDTO : pageDataOfPersonesSollicitudRDTO.getData()) {
			altresPersonesImplicadesList.add(personesSollicitudRDTO.getPersones());
		}
		dadesExpedientBDTO.setPersonesImplicades(altresPersonesImplicadesList);
	}

	/**
	 * Load accions possibles.
	 *
	 * @param tramitsService
	 *            the tramits service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idEstat
	 *            the id estat
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadAccionsPossibles(TramitsService tramitsService, DadesExpedientBDTO dadesExpedientBDTO, BigDecimal idEstat)
	        throws GPAServeisServiceException {
		List<AccionsEstatsRDTO> accionsEstatsRDTOList = tramitsService.cercaAccionsPossibles(idEstat);
		dadesExpedientBDTO.setAccionsPossibles(accionsEstatsRDTOList);
	}

	/**
	 * Load documents aportats.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDocumentsAportats(DocumentsService documentsService, DadesExpedientBDTO dadesExpedientBDTO,
	        BigDecimal documentacioIdext) throws GPAServeisServiceException {
		List<DocsEntradaRDTO> docsEntradaRDTOList = documentsService.cercaDocumentsEntradaAgrupatsPerTramitOvt(documentacioIdext);
		dadesExpedientBDTO.setDocumentsAportats(docsEntradaRDTOList);
	}

	/**
	 * Load documents requerits.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDocumentsRequerits(DocumentsService documentsService, DadesExpedientBDTO dadesExpedientBDTO,
	        BigDecimal documentacioIdext) throws GPAServeisServiceException {
		List<ConfDocEntradaRequeritRDTO> confDocEntradaRequeritRDTOList = documentsService
		        .cercaConfiguracioDocumentacioEntradaRequerida(documentacioIdext);
		dadesExpedientBDTO.setConfiguracioDocumentacioRequerida(confDocEntradaRequeritRDTOList);
	}

	/**
	 * Load expedients.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadExpedients(ExpedientsService expedientsService, DadesExpedientBDTO dadesExpedientBDTO, BigDecimal idExpedient)
	        throws GPAServeisServiceException {
		ExpedientsRDTO expedientsRDTO = expedientsService.consultarDadesExpedient(idExpedient);
		dadesExpedientBDTO.setExpedientsRDTO(expedientsRDTO);
	}

	/**
	 * Load cerca dades operacio.
	 *
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the resposta dades operacio cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaDadesOperacioCercaBDTO loadCercaDadesOperacio(DadesOperacioService dadesOperacioService,
	        DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException {
		RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO = new RespostaDadesOperacioCercaBDTO();
		PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = dadesOperacioService.cercaDadesOperacio(dadesOperacioCercaBDTO);
		respostaDadesOperacioCercaBDTO.setDadesGrupsRDTOList(pageDataOfDadesGrupsRDTO.getData());
		return respostaDadesOperacioCercaBDTO;
	}

	/**
	 * Load cerca documents entrada.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaDocumentsEntradaCercaBDTO loadCercaDocumentsEntrada(DocumentsService documentsService,
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = new RespostaDocumentsEntradaCercaBDTO();
		PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = documentsService
		        .cercaDocumentsEntrada(documentsEntradaCercaBDTO);
		respostaDocumentsEntradaCercaBDTO.setConfiguracioDocsEntradaRDTOList(pageDataOfConfiguracioDocsEntradaRDTO.getData());
		return respostaDocumentsEntradaCercaBDTO;
	}

	/**
	 * Load tramits ovt RDTO.
	 *
	 * @param tramitsService
	 *            the tramits service
	 * @param tramitsOvtCercaBDTO
	 *            the tramits ovt cerca BDTO
	 * @return the tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static TramitsOvtRDTO loadTramitsOvtRDTO(TramitsService tramitsService, TramitsOvtCercaBDTO tramitsOvtCercaBDTO)
	        throws GPAServeisServiceException {
		return tramitsService.consultarDadesTramitOvt(tramitsOvtCercaBDTO.getId());
	}

}