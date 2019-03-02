package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.EstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PaisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ExpedientsServiceImpl.
 */
@Service

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

	/** The paisos api. */
	@Autowired
	private PaisosApi paisosApi;

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
			        null, null, null, expedientsCercaBDTO.getNifSollicitant(), expedientsCercaBDTO.getPageSize(), null,
			        expedientsCercaBDTO.getProcedimentCodisList(), expedientsCercaBDTO.getProcedimentVersio(),
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

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
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
	 */
	public ExpedientsRDTO fallbackCrearSollicitudExpedient(ExpedientsCrearBDTO expedientsCrearBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearSollicitudExpedient(ExpedientsCrearBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

	/**
	 * Consultar dades pais per codi iso.
	 *
	 * @param codiIso
	 *            the codi iso
	 * @return the paisos RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesPaisPerCodiIso")
	public PaisosRDTO consultarDadesPaisPerCodiIso(String codiIso) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadespaisPerCodiIso(String) - inici"); //$NON-NLS-1$
		}

		try {
			PaisosRDTO paisosRDTO = paisosApi.consultarDadesPaisPerCodiIso(codiIso);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadespaisPerCodiIso(String) - fi"); //$NON-NLS-1$
			}
			return paisosRDTO;
		} catch (ApiException e) {
			log.error("consultarDadespaisPerCodiIso(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades pais per codi iso.
	 *
	 * @param codiIso
	 *            the codi iso
	 * @return the paisos RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PaisosRDTO fallbackConsultarDadesPaisPerCodiIso(String codiIso) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadespaisPerCodiIso(String) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}
}
