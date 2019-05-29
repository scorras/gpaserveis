package es.bcn.gpa.gpaserveis.business.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AcumulaciExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AvisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.CanviUnitatGestoraApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ComentarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ConvidarATramitartApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.EstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesSollicitudApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.RetornarLaTramitacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaObtenirXmlExpedient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ExpedientsServiceImpl.
 */
@Service

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@CommonsLog
public class ExpedientsServiceImpl implements ExpedientsService {

	/** The expedients api. */
	@Autowired
	private Expedients_Api expedients_Api;

	/** The expedients api. */
	@Autowired
	private ExpedientsApi expedientsApi;

	/** The persones interessades api. */
	@Autowired
	private PersonesInteressades_Api personesInteressades_Api;

	/** The persones api. */
	@Autowired
	private Persones_Api persones_Api;

	/** The estats api. */
	@Autowired
	private EstatsApi estatsApi;

	/** The dades especifiques api. */
	@Autowired
	private DadesEspecifiquesApi dadesEspecifiquesApi;

	/** The comentaris api. */
	@Autowired
	private ComentarisApi comentarisApi;

	/** The avisos api. */
	@Autowired
	private AvisosApi avisosApi;

	/** The convidar A tramitart api. */
	@Autowired
	private ConvidarATramitartApi convidarATramitartApi;

	/** The retornar la tramitacio api. */
	@Autowired
	private RetornarLaTramitacioApi retornarLaTramitacioApi;

	/** The Canvi unitat gestora api. */
	@Autowired
	private CanviUnitatGestoraApi canviUnitatGestoraApi;

	/** The acumulaci expedients api. */
	@Autowired
	private AcumulaciExpedientsApi acumulaciExpedientsApi;

	/** The Persones sollicitud api. */
	@Autowired
	private PersonesSollicitudApi personesSollicitudApi;

	/**
	 * Cerca expedients.
	 *
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#cercaExpedients(es.bcn.
	 * gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaExpedients")
	public PageDataOfExpedientsRDTO cercaExpedients(ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaExpedients(ExpedientsCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = expedients_Api.cercaExpedients(null, null,
					expedientsCercaBDTO.getAplicacioNegoci(), null, expedientsCercaBDTO.getCodi(), null, null, null, null, null, null, null,
					expedientsCercaBDTO.getCurrentPageNumber(), expedientsCercaBDTO.getDataPresentacioDes(),
					expedientsCercaBDTO.getDataPresentacioFinsA(), expedientsCercaBDTO.getDir(), expedientsCercaBDTO.getEstatList(), null,
					null, null, null, null, expedientsCercaBDTO.getNifSollicitant(), expedientsCercaBDTO.getPageSize(), null,
					expedientsCercaBDTO.getProcedimentCodisList(), null, expedientsCercaBDTO.getProcedimentVersio(),
					expedientsCercaBDTO.getSort(), null, null, expedientsCercaBDTO.getTramitador(),
					expedientsCercaBDTO.getUnitatsGestoresList());

			if (log.isDebugEnabled()) {
				log.debug("cercaExpedients(ExpedientsCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfExpedientsRDTO;
		} catch (ApiException e) {
			log.error("cercaExpedients(ExpedientsCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca expedients.
	 *
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfExpedientsRDTO fallbackCercaExpedients(ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaExpedients() - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/**
	 * Consultar dades expedient.
	 *
	 * @param id
	 *            the id
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#consultarDadesExpedient(
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesExpedient")
	public ExpedientsRDTO consultarDadesExpedient(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			ExpedientsRDTO expedientsRDTO = expedients_Api.consultarDadesExpedient(id);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return expedientsRDTO;
		} catch (ApiException e) {
			log.error("consultarDadesExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades expedient.
	 *
	 * @param id
	 *            the id
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public ExpedientsRDTO fallbackConsultarDadesExpedient(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * consultarDadesExpedientPerCodi(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesExpedientPerCodi")
	public ExpedientsRDTO consultarDadesExpedientPerCodi(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesExpedientPerCodi(String) - inici"); //$NON-NLS-1$
		}

		try {
			ExpedientsRDTO expedientsRDTO = expedients_Api.consultarDadesExpedientPerCodi(codi);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesExpedientPerCodi(String) - fi"); //$NON-NLS-1$
			}
			return expedientsRDTO;
		} catch (ApiException e) {
			log.error("consultarDadesExpedientPerCodi(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades expedient per codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public ExpedientsRDTO fallbackConsultarDadesExpedientPerCodi(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesExpedientPerCodi(String) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/**
	 * Cerca historics estats expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * cercaHistoricsEstatsExpedient(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaHistoricsEstatsExpedient")
	public List<EstatsRDTO> cercaHistoricsEstatsExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaHistoricsEstatsExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<EstatsRDTO> estatsRDTOList = estatsApi.cercaHistoricsEstats(idExpedient);

			if (log.isDebugEnabled()) {
				log.debug("cercaHistoricsEstatsExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return estatsRDTOList;
		} catch (ApiException e) {
			log.error("cercaHistoricsEstatsExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca historics estats expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<EstatsRDTO> fallbackCercaHistoricsEstatsExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaHistoricsEstatsExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/**
	 * Cerca persones interesades expedient.
	 *
	 * @param idSolicitud
	 *            the id solicitud
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * cercaPersonesInteresadesExpedient(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaPersonesInteresadesExpedient")
	public PageDataOfPersonesSollicitudRDTO cercaPersonesInteresadesExpedient(BigDecimal idSolicitud) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaPersonesInteresadesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = personesInteressades_Api.cercaPersonesInteresadesExpedient(
					idSolicitud, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaPersonesInteresadesExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return pageDataOfPersonesSollicitudRDTO;
		} catch (ApiException e) {
			log.error("cercaPersonesInteresadesExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca persones interesades expedient.
	 *
	 * @param idSolicitud
	 *            the id solicitud
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfPersonesSollicitudRDTO fallbackCercaPersonesInteresadesExpedient(BigDecimal idSolicitud)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaPersonesInteresadesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/**
	 * Cerca altres persones implicades expedient.
	 *
	 * @param idSolicitud
	 *            the id solicitud
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * cercaAltresPersonesImplicadesExpedient(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaAltresPersonesImplicadesExpedient")
	public PageDataOfPersonesSollicitudRDTO cercaAltresPersonesImplicadesExpedient(BigDecimal idSolicitud)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaAltresPersonesImplicadesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = persones_Api.cercaAltresPersonesImplicadesExpedient(
					idSolicitud, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaAltresPersonesImplicadesExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return pageDataOfPersonesSollicitudRDTO;
		} catch (ApiException e) {
			log.error("cercaAltresPersonesImplicadesExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca altres persones implicades expedient.
	 *
	 * @param idSolicitud
	 *            the id solicitud
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfPersonesSollicitudRDTO fallbackCercaAltresPersonesImplicadesExpedient(BigDecimal idSolicitud)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaAltresPersonesImplicadesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * actualitzarDadesAltraPersonaImplicada(es.bcn.gpa.gpaserveis.rest.client.
	 * api.model.gpaexpedients.PersonesSollicitudRDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarDadesAltraPersonaImplicada")
	public PageDataOfPersonesSollicitudRDTO actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO personesSollicitudRDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = personesSollicitudApi.actualitzarDadesAltraPersonaImplicada(
					personesSollicitudRDTO, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfPersonesSollicitudRDTO;
		} catch (ApiException e) {
			log.error("actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback actualitzar dades altra persona implicada.
	 *
	 * @param personesSollicitudRDTO
	 *            the persones sollicitud RDTO
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfPersonesSollicitudRDTO fallbackActualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO personesSollicitudRDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/**
	 * Cerca dades especifiques expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDadesEspecifiquesExpedient")
	public List<DadesEspecifiquesRDTO> cercaDadesEspecifiquesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDadesEspecifiquesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = dadesEspecifiquesApi.consultarDadesEspecifiquesExpedient(idExpedient);

			if (log.isDebugEnabled()) {
				log.debug("cercaDadesEspecifiquesExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return dadesEspecifiquesRDTOList;
		} catch (ApiException e) {
			log.error("cercaDadesEspecifiquesExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca dades especifiques expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<DadesEspecifiquesRDTO> fallbackCercaDadesEspecifiquesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDadesEspecifiquesExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
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
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#crearSollicitudExpedient
	 * (es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearSollicitudExpedient")
	public ExpedientsRDTO crearSollicitudExpedient(ExpedientsCrearBDTO expedientsCrearBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearSollicitudExpedient(ExpedientsCrearBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			ExpedientsRDTO returnExpedientsRDTO = expedients_Api.crearSollicitudExpedient(expedientsCrearBDTO.getExpedientsRDTO());

			if (log.isDebugEnabled()) {
				log.debug("crearSollicitudExpedient(ExpedientsCrearBDTO) - fi"); //$NON-NLS-1$
			}
			return returnExpedientsRDTO;
		} catch (ApiException e) {
			log.error("crearSollicitudExpedient(ExpedientsCrearBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}

	}

	/**
	 * Fallback crear sollicitud expedient.
	 *
	 * @param expedientsCrearBDTO
	 *            the expedients crear BDTO
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 * @throws IOException
	 * @throws JsonParseException
	 */
	public ExpedientsRDTO fallbackCrearSollicitudExpedient(ExpedientsCrearBDTO expedientsCrearBDTO, Throwable e)
			throws GPAServeisServiceException, JsonParseException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearSollicitudExpedient(ExpedientsCrearBDTO) - inici"); //$NON-NLS-1$
		}

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		JsonParser parser = factory.createParser(e.getMessage());
		JsonNode actualObj = mapper.readTree(parser);
		ObjectReader reader = mapper.readerFor(new TypeReference<String>() {
		});
		String message = String.valueOf(reader.readValue(actualObj.get("errorMessage")));

		throw new GPAServeisServiceException(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * actualitzarSolicitudExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsActualitzarBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarSolicitudExpedient")
	public ExpedientsRDTO actualitzarSolicitudExpedient(ExpedientsActualitzarBDTO expedientsActualitzarBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarSolicitudExpedient(ExpedientsActualitzarBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			ExpedientsRDTO returnExpedientsRDTO = expedients_Api
					.actualitzarDadesSollicitud(expedientsActualitzarBDTO.getActualitzarDadesSollicitud());

			if (log.isDebugEnabled()) {
				log.debug("actualitzarSolicitudExpedient(ExpedientsActualitzarBDTO) - fi"); //$NON-NLS-1$
			}
			return returnExpedientsRDTO;
		} catch (ApiException e) {
			log.error("actualitzarSolicitudExpedient(ExpedientsActualitzarBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback actualitzar solicitud expedient.
	 *
	 * @param expedientsActualitzarBDTO
	 *            the expedients actualitzar BDTO
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public ExpedientsRDTO fallbackActualitzarSolicitudExpedient(ExpedientsActualitzarBDTO expedientsActualitzarBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackActualitzarSolicitudExpedient(ExpedientsActualitzarBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * crearRegistreSolicitudExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsRegistrarBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearRegistre")
	public RespostaCrearRegistreExpedient crearRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO, BigDecimal tipusDocVinculada)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearRegistre(ExpedientsRegistrarBDTO, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaCrearRegistreExpedient respostaCrearRegistreSolicitudExpedient = expedients_Api
					.crearRegistreSolicitudExpedient(tipusDocVinculada, expedientsRegistrarBDTO.getCrearRegistre());

			if (log.isDebugEnabled()) {
				log.debug("crearRegistre(ExpedientsRegistrarBDTO, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return respostaCrearRegistreSolicitudExpedient;
		} catch (ApiException e) {
			log.error("crearRegistre(ExpedientsRegistrarBDTO, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback crear registre solicitud expedient.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @param tipusDocVinculada
	 *            the tipus doc vinculada
	 * @return the resposta crear registre solicitud expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RespostaCrearRegistreExpedient fallbackCrearRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO,
			BigDecimal tipusDocVinculada) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearRegistre(ExpedientsRegistrarBDTO, BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * canviarEstatAccioExpedient(es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsCanviarEstatAccioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCanviarEstatAccioExpedient")
	public RespostaCanviarEstatAccioExpedient canviarEstatAccioExpedient(ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("canviarEstatAccioExpedient(ExpedientsCanviarEstatAccioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaCanviarEstatAccioExpedient respostaCanviarEstatAccioExpedient = expedientsApi.canviarEstatAccioExpedient(
					expedientsCanviarEstatAccioBDTO.getIdAccio(), expedientsCanviarEstatAccioBDTO.getIdExpedient(),
					expedientsCanviarEstatAccioBDTO.getExpedientCanviEstatAccio());

			if (log.isDebugEnabled()) {
				log.debug("canviarEstatAccioExpedient(ExpedientsCanviarEstatAccioBDTO) - fi"); //$NON-NLS-1$
			}
			return respostaCanviarEstatAccioExpedient;
		} catch (ApiException e) {
			log.error("canviarEstatAccioExpedient(ExpedientsCanviarEstatAccioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback canviar estat accio expedient.
	 *
	 * @param expedientsCanviarEstatAccioBDTO
	 *            the expedients canviar estat accio BDTO
	 * @return the resposta canviar estat accio expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RespostaCanviarEstatAccioExpedient fallbackCanviarEstatAccioExpedient(
			ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCanviarEstatAccioExpedient(ExpedientsCanviarEstatAccioBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#crearComentariAccio(es.
	 * bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearComentariAccio")
	public void crearComentariAccio(ComentarisCrearAccioBDTO comentarisCrearAccioBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearComentariAccio(ComentarisCrearAccioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			comentarisApi.crearComentariAccio(comentarisCrearAccioBDTO.getIdAccio(), comentarisCrearAccioBDTO.getIdExpedient(),
					comentarisCrearAccioBDTO.getComentariCreacioAccio());

			if (log.isDebugEnabled()) {
				log.debug("crearComentariAccio(ComentarisCrearAccioBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("crearComentariAccio(ComentarisCrearAccioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback crear comentari accio.
	 *
	 * @param comentarisCrearAccioBDTO
	 *            the comentaris crear accio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackCrearComentariAccio(ComentarisCrearAccioBDTO comentarisCrearAccioBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearComentariAccio(ComentarisCrearAccioBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#crearAvisAccio(es.bcn.
	 * gpa.gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearAvisAccio")
	public void crearAvisAccio(AvisosCrearAccioBDTO avisosCrearAccioBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearAvisAccio(AvisosCrearAccioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			avisosApi.crearAvisAccio(avisosCrearAccioBDTO.getIdAccio(), avisosCrearAccioBDTO.getIdExpedient(),
					avisosCrearAccioBDTO.getAvisCreacioAccio());

			if (log.isDebugEnabled()) {
				log.debug("crearAvisAccio(AvisosCrearAccioBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("crearAvisAccio(AvisosCrearAccioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback crear avis accio.
	 *
	 * @param avisosCrearAccioBDTO
	 *            the avisos crear accio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackCrearAvisAccio(AvisosCrearAccioBDTO avisosCrearAccioBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearAvisAccio(AvisosCrearAccioBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#crearDataXmlExpedient(
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearDataXmlExpedient")
	public RespostaObtenirXmlExpedient crearDataXmlExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearDataXmlExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaObtenirXmlExpedient xmlDataExpedient = expedients_Api.obtenirXmlExpedient(idExpedient);

			if (log.isDebugEnabled()) {
				log.debug("crearDataXmlExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return xmlDataExpedient;
		} catch (ApiException e) {
			log.error("crearDataXmlExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear data xml expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackCrearDataXmlExpedient(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDataXmlExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * convidarTramitarExpedient(es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsConvidarTramitarBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConvidarTramitarExpedient")
	public void convidarTramitarExpedient(ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("convidarTramitarExpedient(ExpedientsConvidarTramitarBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			convidarATramitartApi.convidarTramitarExpedient(expedientsConvidarTramitarBDTO.getConvidarTramitarRDTO());

			if (log.isDebugEnabled()) {
				log.debug("convidarTramitarExpedient(ExpedientsConvidarTramitarBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("convidarTramitarExpedient(ExpedientsConvidarTramitarBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback convidar tramitar expedient.
	 *
	 * @param expedientsConvidarTramitarBDTO
	 *            the expedients convidar tramitar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackConvidarTramitarExpedient(ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConvidarTramitarExpedient(ExpedientsConvidarTramitarBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * retornarTramitacioExpedient(es.bcn.gpa.gpaserveis.business.dto.expedients
	 * .ExpedientsRetornarTramitacioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackRetornarTramitacioExpedient")
	public void retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			retornarLaTramitacioApi.retornarTramitacioExpedient(expedientsRetornarTramitacioBDTO.getRetornarLaTramitacioRDTO());

			if (log.isDebugEnabled()) {
				log.debug("retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback retornar tramitacio expedient.
	 *
	 * @param expedientsRetornarTramitacioBDTO
	 *            the expedients retornar tramitacio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackRetornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackRetornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * registreDocumentacioAriadna(es.bcn.gpa.gpaserveis.rest.client.api.model.
	 * gpaexpedients.RegistreDocumentacioExpedient)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackRegistreDocumentacioAriadna")
	public void registreDocumentacioAriadna(RegistreDocumentacioExpedient registreDocumentacioExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("registreDocumentacioAriadna(RegistreDocumentacioExpedient) - inici"); //$NON-NLS-1$
		}

		try {
			expedients_Api.registreDocumentacioAriadna(registreDocumentacioExpedient);

			if (log.isDebugEnabled()) {
				log.debug("registreDocumentacioAriadna(RegistreDocumentacioExpedient) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("registreDocumentacioAriadna(RegistreDocumentacioExpedient)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback registre documentacio ariadna.
	 *
	 * @param registreDocumentacioExpedient
	 *            the registre documentacio expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackRegistreDocumentacioAriadna(RegistreDocumentacioExpedient registreDocumentacioExpedient)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearAvisAccio(AvisosCrearAccioBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * canviarUnitatGestoraExpedient(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.ExpedientsCanviarUnitatGestoraBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCanviarUnitatGestoraExpedient")
	public void canviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO expedientsCanviarUnitatGestoraBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("canviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			canviUnitatGestoraApi.canviarUnitatGestoraExpedient(expedientsCanviarUnitatGestoraBDTO.getCanviUnitatGestoraRDTO());

			if (log.isDebugEnabled()) {
				log.debug("canviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("canviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback canviar unitat gestora expedient.
	 *
	 * @param expedientsCanviarUnitatGestoraBDTO
	 *            the expedients canviar unitat gestora BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackCanviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO expedientsCanviarUnitatGestoraBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCanviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * consultarDadesRegistreAssentament(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesRegistreAssentament")
	public RegistreAssentamentRDTO consultarDadesRegistreAssentament(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesRegistreAssentament(String) - inici"); //$NON-NLS-1$
		}

		try {
			RegistreAssentamentRDTO registreAssentamentRDTO = expedients_Api.consultarDadesRegistreAssentament(codi);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesRegistreAssentament(String) - fi"); //$NON-NLS-1$
			}
			return registreAssentamentRDTO;
		} catch (ApiException e) {
			log.error("consultarDadesRegistreAssentament(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades registre assentament.
	 *
	 * @param codi
	 *            the codi
	 * @return the registre assentament RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RegistreAssentamentRDTO fallbackConsultarDadesRegistreAssentament(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesRegistreAssentament(String) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ExpedientsService#
	 * getIdExpedientByDocumentacioIdExt(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGetIdExpedientByDocumentacioIdExt")
	public BigDecimal getIdExpedientByDocumentacioIdExt(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("getIdExpedientByDocumentacioIdExt(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			BigDecimal idExpedient = expedients_Api.getIdExpedientByDocumentacioIdExt(idDocumentacio);

			if (log.isDebugEnabled()) {
				log.debug("getIdExpedientByDocumentacioIdExt(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return idExpedient;
		} catch (ApiException e) {
			log.error("getIdExpedientByDocumentacioIdExt(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback get id expedient by documentacio id ext.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the big decimal
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public BigDecimal fallbackGetIdExpedientByDocumentacioIdExt(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGetIdExpedientByDocumentacioIdExt(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#cercaExpedientsAcumular(
	 * es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * ExpedientsCercaAcumularBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaExpedientsAcumular")
	public PageDataOfExpedientsRDTO cercaExpedientsAcumular(ExpedientsCercaAcumularBDTO expedientsCercaAcumularBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaExpedientsAcumular(ExpedientsCercaAcumularBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = expedients_Api.cercaExpedientsAcumular(null, null, null, null, null, null,
					null, null, null, null, expedientsCercaAcumularBDTO.getIdProcediment(), null, null, null, null, null, null, null, null,
					null);

			if (log.isDebugEnabled()) {
				log.debug("cercaExpedientsAcumular(ExpedientsCercaAcumularBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfExpedientsRDTO;
		} catch (ApiException e) {
			log.error("cercaExpedientsAcumular(ExpedientsCercaAcumularBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca expedients acumular.
	 *
	 * @param expedientsCercaAcumularBDTO
	 *            the expedients cerca acumular BDTO
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfExpedientsRDTO fallbackCercaExpedientsAcumular(ExpedientsCercaAcumularBDTO expedientsCercaAcumularBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaExpedientsAcumular(ExpedientsCercaAcumularBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#acumularExpedient(es.bcn
	 * .gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackAcumularExpedient")
	public void acumularExpedient(ExpedientsAcumularBDTO expedientsAcumularBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("acumularExpedient(ExpedientsAcumularBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			acumulaciExpedientsApi.acumularExpedient(expedientsAcumularBDTO.getAcumularExpedientRDTO());

			if (log.isDebugEnabled()) {
				log.debug("acumularExpedient(ExpedientsAcumularBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("acumularExpedient(ExpedientsAcumularBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback acumular expedient.
	 *
	 * @param expedientsAcumularBDTO
	 *            the expedients acumular BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackAcumularExpedient(ExpedientsAcumularBDTO expedientsAcumularBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackAcumularExpedient(ExpedientsAcumularBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#cercaExpedientsAcumulats
	 * (java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaExpedientsAcumulats")
	public PageDataOfExpedientsRDTO cercaExpedientsAcumulats(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaExpedientsAcumulats(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = expedients_Api.cercaExpedientsAcumulats(idExpedient, null, null, null, null,
					null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaExpedientsAcumulats(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return pageDataOfExpedientsRDTO;
		} catch (ApiException e) {
			log.error("cercaExpedientsAcumulats(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca expedients acumulats.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfExpedientsRDTO fallbackCercaExpedientsAcumulats(BigDecimal idExpedient) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaExpedientsAcumulats(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}
}
