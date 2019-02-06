package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.HistoricsExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
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
			        null, null, expedientsCercaBDTO.getNifSollicitant(), expedientsCercaBDTO.getPageSize(), null,
			        expedientsCercaBDTO.getProcedimentCodisList(), expedientsCercaBDTO.getProcedimentVersio(), null,
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
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ExpedientsService#cercaHistoricsExpedient(
	 * es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * HistoricsExpedientsCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaHistoricsExpedient")
	public PageDataOfHistoricsRDTO cercaHistoricsExpedient(HistoricsExpedientsCercaBDTO historicsExpedientsCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaHistoricsExpedient(HistoricsExpedientsCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfHistoricsRDTO pageDataOfHistoricsRDTO = expedientsApi.cercaHistoricsExpedient(
			        historicsExpedientsCercaBDTO.getIdExpedient(), null, null, null, null, null, null, null, null, null, null, null, null,
			        historicsExpedientsCercaBDTO.getTipusList(), null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaHistoricsExpedient(HistoricsExpedientsCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfHistoricsRDTO;
		} catch (ApiException e) {
			log.error("cercaHistoricsExpedient(HistoricsExpedientsCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca historics expedient.
	 *
	 * @param historicsExpedientsCercaBDTO
	 *            the historics expedients cerca BDTO
	 * @return the page data of historics RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfHistoricsRDTO fallbackCercaHistoricsExpedient(HistoricsExpedientsCercaBDTO historicsExpedientsCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaHistoricsExpedient(HistoricsExpedientsCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de expedients no està disponible");
	}

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
}
