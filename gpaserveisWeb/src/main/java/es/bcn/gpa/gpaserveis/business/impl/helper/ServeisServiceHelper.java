/*
 * 
 */
package es.bcn.gpa.gpaserveis.business.impl.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.SollicitudsService;
import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadaEspecificaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioRequeritsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusRelacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusRelacioApiParamValueTranslator;

/**
 * The Class ServeisServiceHelper.
 */
public class ServeisServiceHelper {

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
		if (dadesProcedimentBDTO.getProcedimentsRDTO() != null) {
			loadUgr(unitatsGestoresService, dadesProcedimentBDTO, dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext());
			loadUgoList(unitatsGestoresService, dadesProcedimentBDTO, dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList());
		}

		return dadesProcedimentBDTO;
	}

	/**
	 * Load dades procediment.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param codiProcediment
	 *            the codi procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesProcedimentBDTO loadDadesProcediment(ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, String codiProcediment) throws GPAServeisServiceException {
		DadesProcedimentBDTO dadesProcedimentBDTO = new DadesProcedimentBDTO();

		loadProcediments(procedimentsService, dadesProcedimentBDTO, codiProcediment);
		// TODO De momento quitar de la respuesta los trámites
		// loadTramitsRDTOList(dadesProcedimentRDTO, idProcediment);
		if (dadesProcedimentBDTO.getProcedimentsRDTO() != null) {
			loadUgr(unitatsGestoresService, dadesProcedimentBDTO, dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext());
			loadUgoList(unitatsGestoresService, dadesProcedimentBDTO, dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList());
		}

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
	 * Load cerca expedients acumulats.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static List<ExpedientsRDTO> loadCercaExpedientsAcumulats(ExpedientsService expedientsService, BigDecimal idExpedient)
	        throws GPAServeisServiceException {

		ArrayList<ExpedientsRDTO> expedientsAcumulatsRDTOList = new ArrayList<ExpedientsRDTO>();
		PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = expedientsService.obtenirExpedientsRelacionats(idExpedient);

		TipusRelacioApiParamValueTranslator tipusRelacioApiParamValueTranslator = new TipusRelacioApiParamValueTranslator();
		TipusRelacioApiParamValue tipusRelacioApiParamValue = null;
		if (pageDataOfExpedientsRDTO != null && CollectionUtils.isNotEmpty(pageDataOfExpedientsRDTO.getData())) {
			for (ExpedientsRDTO expedientsRDTO : pageDataOfExpedientsRDTO.getData()) {
				tipusRelacioApiParamValue = tipusRelacioApiParamValueTranslator
				        .getEnumByInternalValue(expedientsRDTO.getRelacioTipusRelacio());
				switch (tipusRelacioApiParamValue) {
				case ACUMULAT:
					expedientsAcumulatsRDTOList.add(expedientsRDTO);
				default:
					break;
				}
			}
		}

		return expedientsAcumulatsRDTOList;
	}

	/**
	 * Load dades sollicitud.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param documentsService
	 *            the documents service
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param idSollicitud
	 *            the id sollicitud
	 * @return the dades sollicitud BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesSollicitudBDTO loadDadesSollicitud(ExpedientsService expedientsService, ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, DocumentsService documentsService, DadesOperacioService dadesOperacioService,
	        BigDecimal idSollicitud) throws GPAServeisServiceException {
		DadesSollicitudBDTO dadesSollicitudBDTO = new DadesSollicitudBDTO();

		loadSollicituds(expedientsService, dadesSollicitudBDTO, idSollicitud);
		loadDadesSollicitud(expedientsService, procedimentsService, unitatsGestoresService, documentsService, dadesOperacioService,
		        dadesSollicitudBDTO);

		return dadesSollicitudBDTO;
	}

	/**
	 * Load dades sollicitud.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param procedimentsService
	 *            the procediments service
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param documentsService
	 *            the documents service
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDadesSollicitud(ExpedientsService expedientsService, ProcedimentsService procedimentsService,
	        UnitatsGestoresService unitatsGestoresService, DocumentsService documentsService, DadesOperacioService dadesOperacioService,
	        DadesSollicitudBDTO dadesSollicitudBDTO) throws GPAServeisServiceException {

		if (dadesSollicitudBDTO.getSollicitudsRDTO() != null) {
			loadExpedients(expedientsService, dadesSollicitudBDTO, dadesSollicitudBDTO.getSollicitudsRDTO().getExpedient());
			loadUnitatGestora(unitatsGestoresService, dadesSollicitudBDTO, dadesSollicitudBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
			loadPersonesInteressades(expedientsService, dadesSollicitudBDTO, dadesSollicitudBDTO.getSollicitudsRDTO().getId());
			loadAltresPersonesImplicades(expedientsService, dadesSollicitudBDTO, dadesSollicitudBDTO.getSollicitudsRDTO().getId());
			loadDocumentsAportats(documentsService, dadesSollicitudBDTO);
			loadDadesEspecifiques(expedientsService, dadesOperacioService, dadesSollicitudBDTO,
			        dadesSollicitudBDTO.getSollicitudsRDTO().getId(), dadesSollicitudBDTO.getExpedientsRDTO().getProcedimentIdext());
		}
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
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param sollicitudsService
	 *            the sollicituds service
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesExpedientBDTO loadDadesExpedient(ExpedientsService expedientsService, UnitatsGestoresService unitatsGestoresService,
	        TramitsService tramitsService, DocumentsService documentsService, DadesOperacioService dadesOperacioService,
	        SollicitudsService sollicitudsService, BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = new DadesExpedientBDTO();

		loadExpedients(expedientsService, dadesExpedientBDTO, idExpedient);
		loadDadesExpedient(expedientsService, unitatsGestoresService, tramitsService, documentsService, dadesOperacioService,
		        sollicitudsService, dadesExpedientBDTO);

		return dadesExpedientBDTO;
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
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param sollicitudsService
	 *            the sollicituds service
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesExpedientBDTO loadDadesExpedient(ExpedientsService expedientsService, UnitatsGestoresService unitatsGestoresService,
	        TramitsService tramitsService, DocumentsService documentsService, DadesOperacioService dadesOperacioService,
	        SollicitudsService sollicitudsService, String codiExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = new DadesExpedientBDTO();

		loadExpedients(expedientsService, dadesExpedientBDTO, codiExpedient);
		loadDadesExpedient(expedientsService, unitatsGestoresService, tramitsService, documentsService, dadesOperacioService,
		        sollicitudsService, dadesExpedientBDTO);

		return dadesExpedientBDTO;
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
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param sollicitudsService
	 *            the sollicituds service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDadesExpedient(ExpedientsService expedientsService, UnitatsGestoresService unitatsGestoresService,
	        TramitsService tramitsService, DocumentsService documentsService, DadesOperacioService dadesOperacioService,
	        SollicitudsService sollicitudsService, DadesExpedientBDTO dadesExpedientBDTO) throws GPAServeisServiceException {

		if (dadesExpedientBDTO.getExpedientsRDTO() != null) {
			loadUnitatGestora(unitatsGestoresService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getUnitatGestoraIdext());
			loadHistoricsList(expedientsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getId());
			loadPersonesInteressades(expedientsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getSollicitud());
			loadAltresPersonesImplicades(expedientsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getSollicitud());
			loadAccionsPossibles(tramitsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());
			loadDocumentsAportats(documentsService, tramitsService, dadesExpedientBDTO,
			        dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext());
			loadDocumentsRequerits(documentsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext());
			loadDadesEspecifiques(expedientsService, dadesOperacioService, dadesExpedientBDTO,
			        dadesExpedientBDTO.getExpedientsRDTO().getId());
			loadDadesOperacioRequerits(documentsService, dadesOperacioService, dadesExpedientBDTO,
			        dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext());
			loadSollicituds(sollicitudsService, dadesExpedientBDTO.getExpedientsRDTO().getId(), dadesExpedientBDTO);
		}
	}

	/**
	 * Load dades basiques expedient.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param tramitsService
	 *            the tramits service
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesExpedientBDTO loadDadesBasiquesExpedient(ExpedientsService expedientsService, TramitsService tramitsService,
	        BigDecimal idExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = new DadesExpedientBDTO();

		loadExpedients(expedientsService, dadesExpedientBDTO, idExpedient);
		loadDadesBasiquesExpedient(expedientsService, tramitsService, dadesExpedientBDTO);

		return dadesExpedientBDTO;
	}

	/**
	 * Load dades basiques expedient.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param tramitsService
	 *            the tramits service
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static DadesExpedientBDTO loadDadesBasiquesExpedient(ExpedientsService expedientsService, TramitsService tramitsService,
	        String codiExpedient) throws GPAServeisServiceException {
		DadesExpedientBDTO dadesExpedientBDTO = new DadesExpedientBDTO();

		loadExpedients(expedientsService, dadesExpedientBDTO, codiExpedient);
		loadDadesBasiquesExpedient(expedientsService, tramitsService, dadesExpedientBDTO);

		return dadesExpedientBDTO;
	}

	/**
	 * Load dades basiques expedient.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param tramitsService
	 *            the tramits service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDadesBasiquesExpedient(ExpedientsService expedientsService, TramitsService tramitsService,
	        DadesExpedientBDTO dadesExpedientBDTO) throws GPAServeisServiceException {
		if (dadesExpedientBDTO.getExpedientsRDTO() != null) {
			loadAccionsPossibles(tramitsService, dadesExpedientBDTO, dadesExpedientBDTO.getExpedientsRDTO().getIdEstat());
		}
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
	 * Load procediments.
	 *
	 * @param procedimentsService
	 *            the procediments service
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param codiProcediment
	 *            the codi procediment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadProcediments(ProcedimentsService procedimentsService, DadesProcedimentBDTO dadesProcedimentBDTO,
	        String codiProcediment) throws GPAServeisServiceException {
		ProcedimentsRDTO procedimentsRDTO = procedimentsService.consultarDadesProcedimentPerCodi(codiProcediment);
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
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadUnitatGestora(UnitatsGestoresService unitatsGestoresService, DadesSollicitudBDTO dadesSollicitudBDTO,
	        BigDecimal idUnitatGestora) throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresService.consultarDadesUnitatGestora(idUnitatGestora);
		dadesSollicitudBDTO.setUnitatsGestoresRDTO(unitatsGestoresRDTO);
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
	 * Load unitat gestora.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static UnitatsGestoresRDTO loadUnitatGestora(UnitatsGestoresService unitatsGestoresService, BigDecimal idUnitatGestora)
	        throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresService.consultarDadesUnitatGestora(idUnitatGestora);
		return unitatsGestoresRDTO;
	}

	/**
	 * Load unitat gestora.
	 *
	 * @param unitatsGestoresService
	 *            the unitats gestores service
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static UnitatsGestoresRDTO loadUnitatGestora(UnitatsGestoresService unitatsGestoresService,
	        UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException {
		UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresService
		        .consultarDadesUnitatGestoraPerCodi(unitatsGestoresCercaBDTO.getCodi());
		return unitatsGestoresRDTO;
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
		ArrayList<PersonesSollicitudRDTO> personesInteressadesList = new ArrayList<PersonesSollicitudRDTO>();
		for (PersonesSollicitudRDTO personesSollicitudRDTO : pageDataOfPersonesSollicitudRDTO.getData()) {
			if (personesSollicitudRDTO.getRelacioPrincipal().equals(Constants.PERSONES_SOLLICITUD_RELACIO_PRINCIPAL)) {
				if (personesSollicitudRDTO.getRelacio().equals(Constants.PERSONES_SOLLICITUD_RELACIO_SOLLICITANT)) {
					sollicitantPrincipal = personesSollicitudRDTO.getPersones();
				} else if (personesSollicitudRDTO.getRelacio().equals(Constants.PERSONES_SOLLICITUD_RELACIO_REPRESENTANT)) {
					representantPrincipal = personesSollicitudRDTO.getPersones();
				}
			} else {
				personesInteressadesList.add(personesSollicitudRDTO);
			}
		}
		dadesExpedientBDTO.setSollicitant(sollicitantPrincipal);
		dadesExpedientBDTO.setRepresentant(representantPrincipal);
		dadesExpedientBDTO.setPersonesInteressades(personesInteressadesList);
	}

	/**
	 * Load persones interessades.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idSolicitud
	 *            the id solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadPersonesInteressades(ExpedientsService expedientsService, DadesSollicitudBDTO dadesSollicitudBDTO,
	        BigDecimal idSolicitud) throws GPAServeisServiceException {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = expedientsService
		        .cercaPersonesInteresadesExpedient(idSolicitud);
		// Se separan el solicitante principal y representante principal del
		// resto de personas interesadas
		Persones sollicitantPrincipal = null;
		Persones representantPrincipal = null;
		ArrayList<PersonesSollicitudRDTO> personesInteressadesList = new ArrayList<PersonesSollicitudRDTO>();
		for (PersonesSollicitudRDTO personesSollicitudRDTO : pageDataOfPersonesSollicitudRDTO.getData()) {
			if (personesSollicitudRDTO.getRelacioPrincipal().equals(Constants.PERSONES_SOLLICITUD_RELACIO_PRINCIPAL)) {
				if (personesSollicitudRDTO.getRelacio().equals(Constants.PERSONES_SOLLICITUD_RELACIO_SOLLICITANT)) {
					sollicitantPrincipal = personesSollicitudRDTO.getPersones();
				} else if (personesSollicitudRDTO.getRelacio().equals(Constants.PERSONES_SOLLICITUD_RELACIO_REPRESENTANT)) {
					representantPrincipal = personesSollicitudRDTO.getPersones();
				}
			} else {
				personesInteressadesList.add(personesSollicitudRDTO);
			}
		}
		dadesSollicitudBDTO.setSollicitant(sollicitantPrincipal);
		dadesSollicitudBDTO.setRepresentant(representantPrincipal);
		dadesSollicitudBDTO.setPersonesInteressades(personesInteressadesList);
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
		dadesExpedientBDTO.setPersonesImplicades(pageDataOfPersonesSollicitudRDTO.getData());
	}

	/**
	 * Load altres persones implicades.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idSolicitud
	 *            the id solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadAltresPersonesImplicades(ExpedientsService expedientsService, DadesSollicitudBDTO dadesSollicitudBDTO,
	        BigDecimal idSolicitud) throws GPAServeisServiceException {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = expedientsService
		        .cercaAltresPersonesImplicadesExpedient(idSolicitud);
		dadesSollicitudBDTO.setPersonesImplicades(pageDataOfPersonesSollicitudRDTO.getData());
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
		dadesExpedientBDTO.setAccionsDisponibles(accionsEstatsRDTOList);
	}

	/**
	 * Load documents aportats.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDocumentsAportats(DocumentsService documentsService, DadesSollicitudBDTO dadesSollicitudBDTO)
	        throws GPAServeisServiceException {
		List<DocsEntradaRDTO> docsEntradaRDTOList = documentsService
		        .cercaDocumentsEntradaPerSollicitud(dadesSollicitudBDTO.getSollicitudsRDTO().getId());
		dadesSollicitudBDTO.setDocumentsAportats(docsEntradaRDTOList);
	}

	/**
	 * Load documents aportats.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param tramitsService
	 *            the tramits service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDocumentsAportats(DocumentsService documentsService, TramitsService tramitsService,
	        DadesExpedientBDTO dadesExpedientBDTO, BigDecimal documentacioIdext) throws GPAServeisServiceException {
		List<DocsEntradaRDTO> docsEntradaRDTOList = documentsService.cercaDocumentsEntradaAgrupatsPerTramitOvt(documentacioIdext);
		dadesExpedientBDTO.setDocumentsAportats(docsEntradaRDTOList);

		// Es necesario recuperar el código y la descripción de los trámites OVT
		// asociados a los documentos aportados. Para facilitar el manejo de la
		// información, se utiliza un Map dentro de DadesExpedientBDTO
		if (dadesExpedientBDTO.getTramitsOvtMap() == null) {
			dadesExpedientBDTO.setTramitsOvtMap(new HashMap<BigDecimal, TramitsOvtRDTO>());
		}
		TramitsOvtCercaBDTO tramitsOvtCercaBDTO = null;
		TramitsOvtRDTO tramitsOvtRDTO = null;
		for (DocsEntradaRDTO docsEntradaRDTO : docsEntradaRDTOList) {
			if (docsEntradaRDTO.getTramitOvtIdext() != null
			        && !dadesExpedientBDTO.getTramitsOvtMap().containsKey(docsEntradaRDTO.getTramitOvtIdext())) {
				tramitsOvtCercaBDTO = new TramitsOvtCercaBDTO(docsEntradaRDTO.getTramitOvtIdext());
				tramitsOvtRDTO = loadTramitsOvtRDTO(tramitsService, tramitsOvtCercaBDTO);
				dadesExpedientBDTO.getTramitsOvtMap().put(docsEntradaRDTO.getTramitOvtIdext(), tramitsOvtRDTO);
			}
		}
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
	 * Load dades operacio requerits.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDadesOperacioRequerits(DocumentsService documentsService, DadesOperacioService dadesOperacioService,
	        DadesExpedientBDTO dadesExpedientBDTO, BigDecimal documentacioIdext) throws GPAServeisServiceException {
		List<BigDecimal> dadesOperacioRequeritsIdList = documentsService.cercaDadesOperacioRequerits(documentacioIdext);
		if (CollectionUtils.isNotEmpty(dadesOperacioRequeritsIdList)) {
			ArrayList<DadesOperacions> dadesOperacioRequerits = new ArrayList<DadesOperacions>();
			DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
			PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = dadesOperacioService.cercaDadesOperacio(dadesOperacioCercaBDTO);
			for (DadesGrupsRDTO dadesGrupsRDTO : pageDataOfDadesGrupsRDTO.getData()) {
				for (DadesOperacions dadesOperacions : dadesGrupsRDTO.getDadesOperacionsList()) {
					if (dadesOperacioRequeritsIdList.contains(dadesOperacions.getId())) {
						dadesOperacioRequerits.add(dadesOperacions);
					}
				}
			}
			dadesExpedientBDTO.setDadesOperacioRequerits(dadesOperacioRequerits);
		}
	}

	/**
	 * Load dades especifiques.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param idProcediment
	 *            the id procediment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDadesEspecifiques(ExpedientsService expedientsService, DadesOperacioService dadesOperacioService,
	        DadesSollicitudBDTO dadesSollicitudBDTO, BigDecimal idSollicitud, BigDecimal idProcediment) throws GPAServeisServiceException {
		ArrayList<DadaEspecificaBDTO> dadaEspecificaBDTOList = null;
		DadaEspecificaBDTO dadaEspecificaBDTO = null;
		List<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = expedientsService
		        .cercaDadesEspecifiquesSollicitud(dadesSollicitudBDTO.getSollicitudsRDTO().getId());
		if (CollectionUtils.isNotEmpty(dadesEspecifiquesRDTOList)) {
			dadaEspecificaBDTOList = new ArrayList<DadaEspecificaBDTO>();
			HashMap<BigDecimal, DadesOperacions> dadesOperacionsMap = new HashMap<BigDecimal, DadesOperacions>();
			DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(idProcediment, null);
			PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = dadesOperacioService.cercaDadesOperacio(dadesOperacioCercaBDTO);
			if (CollectionUtils.isNotEmpty(pageDataOfDadesGrupsRDTO.getData())) {
				for (DadesGrupsRDTO dadesGrupsRDTO : pageDataOfDadesGrupsRDTO.getData()) {
					if (CollectionUtils.isNotEmpty(dadesGrupsRDTO.getDadesOperacionsList())) {
						for (DadesOperacions dadesOperacions : dadesGrupsRDTO.getDadesOperacionsList()) {
							dadesOperacionsMap.put(dadesOperacions.getId(), dadesOperacions);
						}
					}
				}
			}
			for (DadesEspecifiquesRDTO dadesEspecifiquesRDTO : dadesEspecifiquesRDTOList) {
				dadaEspecificaBDTO = new DadaEspecificaBDTO();
				dadaEspecificaBDTO.setDadaOperacio(dadesOperacionsMap.get(dadesEspecifiquesRDTO.getCampIdext()));
				dadaEspecificaBDTO.setDadaEspecifica(dadesEspecifiquesRDTO);
				dadaEspecificaBDTOList.add(dadaEspecificaBDTO);
			}
		}
		dadesSollicitudBDTO.setDadesOperacio(dadaEspecificaBDTOList);
	}

	/**
	 * Load dades especifiques.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadDadesEspecifiques(ExpedientsService expedientsService, DadesOperacioService dadesOperacioService,
	        DadesExpedientBDTO dadesExpedientBDTO, BigDecimal idExpedient) throws GPAServeisServiceException {
		ArrayList<DadaEspecificaBDTO> dadaEspecificaBDTOList = null;
		DadaEspecificaBDTO dadaEspecificaBDTO = null;
		List<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = expedientsService.cercaDadesEspecifiquesExpedient(idExpedient);
		if (CollectionUtils.isNotEmpty(dadesEspecifiquesRDTOList)) {
			dadaEspecificaBDTOList = new ArrayList<DadaEspecificaBDTO>();
			HashMap<BigDecimal, DadesOperacions> dadesOperacionsMap = new HashMap<BigDecimal, DadesOperacions>();
			DadesOperacioCercaBDTO dadesOperacioCercaBDTO = new DadesOperacioCercaBDTO(
			        dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext(), null);
			PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = dadesOperacioService.cercaDadesOperacio(dadesOperacioCercaBDTO);
			if (CollectionUtils.isNotEmpty(pageDataOfDadesGrupsRDTO.getData())) {
				for (DadesGrupsRDTO dadesGrupsRDTO : pageDataOfDadesGrupsRDTO.getData()) {
					if (CollectionUtils.isNotEmpty(dadesGrupsRDTO.getDadesOperacionsList())) {
						for (DadesOperacions dadesOperacions : dadesGrupsRDTO.getDadesOperacionsList()) {
							dadesOperacionsMap.put(dadesOperacions.getId(), dadesOperacions);
						}
					}
				}
			}
			for (DadesEspecifiquesRDTO dadesEspecifiquesRDTO : dadesEspecifiquesRDTOList) {
				dadaEspecificaBDTO = new DadaEspecificaBDTO();
				dadaEspecificaBDTO.setDadaOperacio(dadesOperacionsMap.get(dadesEspecifiquesRDTO.getCampIdext()));
				dadaEspecificaBDTO.setDadaEspecifica(dadesEspecifiquesRDTO);
				dadaEspecificaBDTOList.add(dadaEspecificaBDTO);
			}
		}
		dadesExpedientBDTO.setDadesOperacio(dadaEspecificaBDTOList);
	}

	/**
	 * Load sollicituds.
	 *
	 * @param sollicitudsService
	 *            the sollicituds service
	 * @param idExpedient
	 *            the id expedient
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	private static void loadSollicituds(SollicitudsService sollicitudsService, BigDecimal idExpedient,
	        DadesExpedientBDTO dadesExpedientBDTO) throws GPAServeisServiceException {
		List<SollicitudsRDTO> sollicitudsRDTOList = sollicitudsService.consultarSollicitudsExpedient(idExpedient);
		dadesExpedientBDTO.setSollicituds(sollicitudsRDTOList);
	}

	/**
	 * Load sollicituds.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idSollicitud
	 *            the id sollicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadSollicituds(ExpedientsService expedientsService, DadesSollicitudBDTO dadesSollicitudBDTO,
	        BigDecimal idSollicitud) throws GPAServeisServiceException {
		SollicitudsRDTO sollicitudsRDTO = expedientsService.consultarDadesSollicitud(idSollicitud);
		dadesSollicitudBDTO.setSollicitudsRDTO(sollicitudsRDTO);
	}

	/**
	 * Load expedients.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadExpedients(ExpedientsService expedientsService, DadesSollicitudBDTO dadesSollicitudBDTO, BigDecimal idExpedient)
	        throws GPAServeisServiceException {
		ExpedientsRDTO expedientsRDTO = expedientsService.consultarDadesExpedient(idExpedient);
		dadesSollicitudBDTO.setExpedientsRDTO(expedientsRDTO);
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
	 * Load expedients.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param codiExpedient
	 *            the codi expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static void loadExpedients(ExpedientsService expedientsService, DadesExpedientBDTO dadesExpedientBDTO, String codiExpedient)
	        throws GPAServeisServiceException {
		ExpedientsRDTO expedientsRDTO = expedientsService.consultarDadesExpedientPerCodi(codiExpedient);
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
	 * Load cerca dades operacio requerits.
	 *
	 * @param dadesOperacioService
	 *            the dades operacio service
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the resposta dades operacio requerits cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaDadesOperacioRequeritsCercaBDTO loadCercaDadesOperacioRequerits(DadesOperacioService dadesOperacioService,
	        DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException {
		RespostaDadesOperacioRequeritsCercaBDTO respostaDadesOperacioRequeritsCercaBDTO = new RespostaDadesOperacioRequeritsCercaBDTO();
		PageDataOfDadesOperacionsRDTO pageDataOfDadesOperacionsRDTO = dadesOperacioService
		        .cercaDadesOperacioRequerits(dadesOperacioCercaBDTO);
		respostaDadesOperacioRequeritsCercaBDTO.setDadesOperacionsRDTOList(pageDataOfDadesOperacionsRDTO.getData());
		return respostaDadesOperacioRequeritsCercaBDTO;
	}

	/**
	 * Load cerca configuracio documentacio entrada.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaDocumentsEntradaCercaBDTO loadCercaConfiguracioDocumentacioEntrada(DocumentsService documentsService,
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = new RespostaDocumentsEntradaCercaBDTO();
		PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = documentsService
		        .cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO);
		respostaDocumentsEntradaCercaBDTO.setConfiguracioDocsEntradaRDTOList(pageDataOfConfiguracioDocsEntradaRDTO.getData());
		return respostaDocumentsEntradaCercaBDTO;
	}

	/**
	 * Load cerca configuracio documentacio entrada per tramit ovt.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaDocumentsEntradaCercaBDTO loadCercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsService documentsService,
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsEntradaCercaBDTO respostaDocumentsEntradaCercaBDTO = new RespostaDocumentsEntradaCercaBDTO();
		PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = documentsService
		        .cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO);
		respostaDocumentsEntradaCercaBDTO.setConfiguracioDocsEntradaRDTOList(pageDataOfConfiguracioDocsEntradaRDTO.getData());
		return respostaDocumentsEntradaCercaBDTO;
	}

	/**
	 * Load cerca configuracio documentacio tramitacio.
	 *
	 * @param documentsService
	 *            the documents service
	 * @param documentsTramitacioCercaBDTO
	 *            the documents tramitacio cerca BDTO
	 * @return the resposta documents tramitacio cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaDocumentsTramitacioCercaBDTO loadCercaConfiguracioDocumentacioTramitacio(DocumentsService documentsService,
	        DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO) throws GPAServeisServiceException {
		RespostaDocumentsTramitacioCercaBDTO respostaDocumentsTramitacioCercaBDTO = new RespostaDocumentsTramitacioCercaBDTO();
		PageDataOfConfiguracioDocsTramitacioRDTO pageDataOfConfiguracioDocsTramitacioRDTO = documentsService
		        .cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO);
		respostaDocumentsTramitacioCercaBDTO.setConfiguracioDocsTramitacioRDTOList(pageDataOfConfiguracioDocsTramitacioRDTO.getData());
		return respostaDocumentsTramitacioCercaBDTO;
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

	/**
	 * Load cerca sollicituds.
	 *
	 * @param expedientsService
	 *            the expedients service
	 * @param sollicitudsCercaBDTO
	 *            the sollicituds cerca BDTO
	 * @return the resposta sollicituds cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public static RespostaSollicitudsCercaBDTO loadCercaSollicituds(ExpedientsService expedientsService,
	        SollicitudsCercaBDTO sollicitudsCercaBDTO) throws GPAServeisServiceException {
		RespostaSollicitudsCercaBDTO respostaSollicitudsCercaBDTO = new RespostaSollicitudsCercaBDTO();
		ArrayList<DadesSollicitudBDTO> dadesSollicitudBDTOList = new ArrayList<DadesSollicitudBDTO>();
		DadesSollicitudBDTO dadesSollicitudBDTO = null;

		PageDataOfSollicitudsRDTO pageDataOfSollicitudsRDTO = expedientsService.cercaSollicituds(sollicitudsCercaBDTO);

		for (SollicitudsRDTO sollicitudsRDTO : pageDataOfSollicitudsRDTO.getData()) {
			dadesSollicitudBDTO = new DadesSollicitudBDTO();
			dadesSollicitudBDTO.setSollicitudsRDTO(sollicitudsRDTO);

			loadExpedients(expedientsService, dadesSollicitudBDTO, sollicitudsRDTO.getId());

			dadesSollicitudBDTOList.add(dadesSollicitudBDTO);
		}

		respostaSollicitudsCercaBDTO.setDadesSollicitudBDTOList(dadesSollicitudBDTOList);
		respostaSollicitudsCercaBDTO.setPaginationAttributes(pageDataOfSollicitudsRDTO.getPage());

		return respostaSollicitudsCercaBDTO;
	}

}