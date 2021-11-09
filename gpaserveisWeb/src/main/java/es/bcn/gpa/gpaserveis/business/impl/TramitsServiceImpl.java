package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.handler.ServeisServiceExceptionHandler;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class TramitsServiceImpl.
 */
@Service

/** The Constant log. */
@CommonsLog
public class TramitsServiceImpl implements TramitsService {

	/** The tramits ovt api. */
	@Autowired
	private TramitsOvtApi tramitsOvtApi;

	/** The accions estats api. */
	@Autowired
	private AccionsEstatsApi accionsEstatsApi;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.TramitsService#consultarDadesTramitOvt(
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesTramitOvt") 
	public TramitsOvtRDTO consultarDadesTramitOvt(BigDecimal idTramitOvt) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesTramitOvt(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			TramitsOvtRDTO tramitsOvtRDTO = tramitsOvtApi.consultarDadesTramitOvt(idTramitOvt);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesTramitOvt(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return tramitsOvtRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesTramitOvt(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback consultar dades tramit ovt.
	 *
	 * @param idTramitOvt
	 *            the id tramit ovt
	 * @param e
	 *            the e
	 * @return the tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public TramitsOvtRDTO fallbackConsultarDadesTramitOvt(BigDecimal idTramitOvt, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesTramitOvt(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.TramitsService#cercaAccionsPossibles(java.
	 * math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaAccionsPossibles")
	public List<AccionsEstatsRDTO> cercaAccionsPossibles(BigDecimal idAccioEstat) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaAccionsPossibles(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = accionsEstatsApi.cercaAccionsPossibles(idAccioEstat);

			if (log.isDebugEnabled()) {
				log.debug("cercaAccionsPossibles(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return accionsEstatsRDTOList;
		} catch (RestClientException e) {
			log.error("cercaAccionsPossibles(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca accions possibles.
	 *
	 * @param idAccioEstat
	 *            the id accio estat
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<AccionsEstatsRDTO> fallbackCercaAccionsPossibles(BigDecimal idAccioEstat, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaAccionsPossibles(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaTransicioCanviEstat")
	public List<AccionsEstatsRDTO> cercaTransicioCanviEstat(BigDecimal idAccio, BigDecimal idEstatActual)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaTransicioCanviEstat(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<AccionsEstatsRDTO> accionsEstatsRDTOList = accionsEstatsApi.cercaTransicioCanviEstat(idAccio, idEstatActual);

			if (log.isDebugEnabled()) {
				log.debug("cercaTransicioCanviEstat(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return accionsEstatsRDTOList;
		} catch (RestClientException e) {
			log.error("cercaTransicioCanviEstat(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca transicio canvi estat.
	 *
	 * @param idAccioEstat
	 *            the id accio estat
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<AccionsEstatsRDTO> fallbackCercaTransicioCanviEstat(BigDecimal idAccio, BigDecimal idEstatActual, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaTransicioCanviEstat(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

}
