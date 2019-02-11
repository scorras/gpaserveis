package es.bcn.gpa.gpaserveis.web.rest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.HistoricsExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesProcedimentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.CercaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.CercaProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs.CercaDadesOperacioRDTO;

/**
 * The Class ServeisPortalRestControllerHelper.
 */
public class ServeisPortalRestControllerHelper {

	/**
	 * Load unitats gestores RDTO list.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static List<UnitatsGestoresRDTO> loadUnitatsGestoresRDTOList(UnitatsGestoresService unitatsGestoresService,
	        UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException {
		PageDataOfUnitatsGestoresRDTO pageDataOfUnitatsGestoresRDTO = unitatsGestoresService.cercaUnitatsGestores(unitatsGestoresCercaBDTO);
		List<UnitatsGestoresRDTO> unitatsGestoresRDTOList = pageDataOfUnitatsGestoresRDTO.getData();
		return unitatsGestoresRDTOList;
	}

	/**
	 * Load cerca procediments RDTO.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param procedimentsCercaBDTO
	 *            the procediments cerca BDTO
	 * @return the cerca procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static CercaProcedimentsRDTO loadCercaProcedimentsRDTO(ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException {
		CercaProcedimentsRDTO cercaProcedimentsRDTO = new CercaProcedimentsRDTO();
		ArrayList<DadesProcedimentRDTO> dadesProcedimentRDTOList = new ArrayList<DadesProcedimentRDTO>();
		DadesProcedimentRDTO dadesProcedimentRDTO = null;

		PageDataOfProcedimentsRDTO pageDataOfProcedimentsRDTO = procedimentsService.cercaProcediments(procedimentsCercaBDTO);

		for (ProcedimentsRDTO procedimentsRDTO : pageDataOfProcedimentsRDTO.getData()) {
			dadesProcedimentRDTO = new DadesProcedimentRDTO();
			dadesProcedimentRDTO.setProcedimentsRDTO(procedimentsRDTO);

			loadUgrRDTO(unitatsGestoresService, dadesProcedimentRDTO, procedimentsRDTO.getUgrIdext());
			loadUgoRDTOList(unitatsGestoresService, dadesProcedimentRDTO, procedimentsRDTO.getUgosList());

			dadesProcedimentRDTOList.add(dadesProcedimentRDTO);
		}

		cercaProcedimentsRDTO.setDadesProcedimentRDTOList(dadesProcedimentRDTOList);
		cercaProcedimentsRDTO.setPaginationAttributes(pageDataOfProcedimentsRDTO.getPage());

		return cercaProcedimentsRDTO;
	}

	/**
	 * Load dades procediment RDTO.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesProcedimentRDTO loadDadesProcedimentRDTO(ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, BigDecimal idProcediment) throws GPAServeisServiceException {
		DadesProcedimentRDTO dadesProcedimentRDTO = new DadesProcedimentRDTO();

		loadProcedimentsRDTO(procedimentsService, dadesProcedimentRDTO, idProcediment);
		// TODO De momento quitar de la respuesta los trámites
		// loadTramitsRDTOList(dadesProcedimentRDTO, idProcediment);
		loadUgrRDTO(unitatsGestoresService, dadesProcedimentRDTO, dadesProcedimentRDTO.getProcedimentsRDTO().getUgrIdext());
		loadUgoRDTOList(unitatsGestoresService, dadesProcedimentRDTO, dadesProcedimentRDTO.getProcedimentsRDTO().getUgosList());

		return dadesProcedimentRDTO;
	}

	/**
	 * Load cerca expedients RDTO.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the cerca expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static CercaExpedientsRDTO loadCercaExpedientsRDTO(ExpedientsService expedientsService,
	        UnitatsGestoresService unitatsGestoresService, ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException {
		CercaExpedientsRDTO cercaExpedientsRDTO = new CercaExpedientsRDTO();
		ArrayList<DadesExpedientRDTO> dadesExpedientRDTOList = new ArrayList<DadesExpedientRDTO>();
		DadesExpedientRDTO dadesExpedientRDTO = null;

		PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = expedientsService.cercaExpedients(expedientsCercaBDTO);

		for (ExpedientsRDTO expedientsRDTO : pageDataOfExpedientsRDTO.getData()) {
			dadesExpedientRDTO = new DadesExpedientRDTO();
			dadesExpedientRDTO.setExpedientsRDTO(expedientsRDTO);

			loadUnitatGestoraRDTO(unitatsGestoresService, dadesExpedientRDTO, expedientsRDTO.getUnitatGestoraIdext());

			dadesExpedientRDTOList.add(dadesExpedientRDTO);
		}

		cercaExpedientsRDTO.setDadesExpedientRDTOList(dadesExpedientRDTOList);
		cercaExpedientsRDTO.setPaginationAttributes(pageDataOfExpedientsRDTO.getPage());

		return cercaExpedientsRDTO;
	}

	/**
	 * Load dades expedient RDTO.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param idExpedient
	 *            the id expedient
	 * @param historicsExpedientsCercaBDTO
	 *            the historics expedients cerca BDTO
	 * @return the dades expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesExpedientRDTO loadDadesExpedientRDTO(ExpedientsService expedientsService,
	        UnitatsGestoresService unitatsGestoresService, BigDecimal idExpedient,
	        HistoricsExpedientsCercaBDTO historicsExpedientsCercaBDTO) throws GPAServeisServiceException {
		DadesExpedientRDTO dadesExpedientRDTO = new DadesExpedientRDTO();

		loadExpedientsRDTO(expedientsService, dadesExpedientRDTO, idExpedient);
		loadUnitatGestoraRDTO(unitatsGestoresService, dadesExpedientRDTO, dadesExpedientRDTO.getExpedientsRDTO().getUnitatGestoraIdext());
		loadHistoricsRDTOList(expedientsService, dadesExpedientRDTO, historicsExpedientsCercaBDTO);
		loadPersonesInteressades(expedientsService, dadesExpedientRDTO, dadesExpedientRDTO.getExpedientsRDTO().getSollicitud());
		loadAltresPersonesImplicades(expedientsService, dadesExpedientRDTO, dadesExpedientRDTO.getExpedientsRDTO().getSollicitud());

		return dadesExpedientRDTO;
	}

	/**
	 * Load procediments RDTO.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param dadesProcedimentRDTO
	 *            the dades procediment RDTO
	 * @param idProcediment
	 *            the id procediment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadProcedimentsRDTO(ProcedimentsService procedimentsService, DadesProcedimentRDTO dadesProcedimentRDTO,
	        BigDecimal idProcediment) throws GPAServeisServiceException {
		ProcedimentsRDTO procedimentsRDTO = procedimentsService.consultarDadesProcediment(idProcediment);
		dadesProcedimentRDTO.setProcedimentsRDTO(procedimentsRDTO);
	}

	/**
	 * Load tramits RDTO list.
	 *
	 * @param tramitsService
	 *            the tramits service
	 * @param dadesProcedimentRDTO
	 *            the dades procediment RDTO
	 * @param idProcediment
	 *            the id procediment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadTramitsRDTOList(TramitsService tramitsService, DadesProcedimentRDTO dadesProcedimentRDTO,
	        BigDecimal idProcediment) throws GPAServeisServiceException {
		PageDataOfTramitsRDTO pageDataOfTramitsRDTO = tramitsService.cercaTramitsProcediment(idProcediment);
		dadesProcedimentRDTO.setTramitsRDTOList(pageDataOfTramitsRDTO.getData());
	}

	/**
	 * Load ugr RDTO.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param dadesProcedimentRDTO
	 *            the dades procediment RDTO
	 * @param idUgr
	 *            the id ugr
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUgrRDTO(UnitatsGestoresService unitatsGestoresService, DadesProcedimentRDTO dadesProcedimentRDTO,
	        BigDecimal idUgr) throws GPAServeisServiceException {
		UnitatsGestoresRDTO ugrRDTO = unitatsGestoresService.consultarDadesUnitatGestora(idUgr);
		dadesProcedimentRDTO.setUgrRDTO(ugrRDTO);
	}

	/**
	 * Load ugo RDTO list.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param dadesProcedimentRDTO
	 *            the dades procediment RDTO
	 * @param procedimentsUgosList
	 *            the procediments ugos list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUgoRDTOList(UnitatsGestoresService unitatsGestoresService, DadesProcedimentRDTO dadesProcedimentRDTO,
	        List<ProcedimentsUgos> procedimentsUgosList) throws GPAServeisServiceException {
		ArrayList<UnitatsGestoresRDTO> ugoRDTOList = new ArrayList<UnitatsGestoresRDTO>();
		if (CollectionUtils.isNotEmpty(procedimentsUgosList)) {
			UnitatsGestoresRDTO ugoRDTO = null;
			for (ProcedimentsUgos procedimentsUgos : procedimentsUgosList) {
				ugoRDTO = unitatsGestoresService.consultarDadesUnitatGestora(procedimentsUgos.getUgoIdext());
				ugoRDTOList.add(ugoRDTO);
			}
		}
		dadesProcedimentRDTO.setUgoRDTOList(ugoRDTOList);
	}

	/**
	 * Load unitat gestora RDTO.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param dadesExpedientRDTO
	 *            the dades expedient RDTO
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUnitatGestoraRDTO(UnitatsGestoresService unitatsGestoresService, DadesExpedientRDTO dadesExpedientRDTO,
	        BigDecimal idUnitatGestora) throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresService.consultarDadesUnitatGestora(idUnitatGestora);
		dadesExpedientRDTO.setUnitatsGestoresRDTO(unitatsGestoresRDTO);
	}

	/**
	 * Load historics RDTO list.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientRDTO
	 *            the dades expedient RDTO
	 * @param historicsExpedientsCercaBDTO
	 *            the historics expedients cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadHistoricsRDTOList(ExpedientsService expedientsService, DadesExpedientRDTO dadesExpedientRDTO,
	        HistoricsExpedientsCercaBDTO historicsExpedientsCercaBDTO) throws GPAServeisServiceException {
		PageDataOfHistoricsRDTO pageDataOfHistoricsRDTO = expedientsService.cercaHistoricsExpedient(historicsExpedientsCercaBDTO);
		dadesExpedientRDTO.setHistoricsRDTOList(pageDataOfHistoricsRDTO.getData());
	}

	/**
	 * Load persones interessades.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientRDTO
	 *            the dades expedient RDTO
	 * @param idSolicitud
	 *            the id solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadPersonesInteressades(ExpedientsService expedientsService, DadesExpedientRDTO dadesExpedientRDTO,
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
		dadesExpedientRDTO.setSollicitant(sollicitantPrincipal);
		dadesExpedientRDTO.setRepresentant(representantPrincipal);
		dadesExpedientRDTO.setPersonesInteressades(personesInteressadesList);
	}

	/**
	 * Load altres persones implicades.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientRDTO
	 *            the dades expedient RDTO
	 * @param idSolicitud
	 *            the id solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadAltresPersonesImplicades(ExpedientsService expedientsService, DadesExpedientRDTO dadesExpedientRDTO,
	        BigDecimal idSolicitud) throws GPAServeisServiceException {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = expedientsService
		        .cercaAltresPersonesImplicadesExpedient(idSolicitud);
		ArrayList<Persones> altresPersonesImplicadesList = new ArrayList<Persones>();
		for (PersonesSollicitudRDTO personesSollicitudRDTO : pageDataOfPersonesSollicitudRDTO.getData()) {
			altresPersonesImplicadesList.add(personesSollicitudRDTO.getPersones());
		}
		dadesExpedientRDTO.setPersonesImplicades(altresPersonesImplicadesList);
	}

	/**
	 * Load expedients RDTO.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientRDTO
	 *            the dades expedient RDTO
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadExpedientsRDTO(ExpedientsService expedientsService, DadesExpedientRDTO dadesExpedientRDTO,
	        BigDecimal idExpedient) throws GPAServeisServiceException {
		ExpedientsRDTO expedientsRDTO = expedientsService.consultarDadesExpedient(idExpedient);
		dadesExpedientRDTO.setExpedientsRDTO(expedientsRDTO);
	}

	/**
	 * Load cerca dades operacio RDTO.
	 *
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the cerca dades operacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static CercaDadesOperacioRDTO loadCercaDadesOperacioRDTO(DadesOperacioService dadesOperacioService,
	        DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException {
		CercaDadesOperacioRDTO cercaDadesOperacioRDTO = new CercaDadesOperacioRDTO();
		PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = dadesOperacioService.cercaDadesOperacio(dadesOperacioCercaBDTO);
		cercaDadesOperacioRDTO.setDadesGrupsRDTOList(pageDataOfDadesGrupsRDTO.getData());
		return cercaDadesOperacioRDTO;
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