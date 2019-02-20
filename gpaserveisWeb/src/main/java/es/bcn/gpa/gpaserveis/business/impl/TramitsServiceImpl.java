package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class TramitsServiceImpl.
 */
@Service
@CommonsLog
public class TramitsServiceImpl implements TramitsService {

	/** The tramits api. */
	@Autowired
	private TramitsApi tramitsApi;

	/** The tramits ovt api. */
	@Autowired
	private TramitsOvtApi tramitsOvtApi;

	/** The accions estats api. */
	@Autowired
	private AccionsEstatsApi accionsEstatsApi;

	/**
	 * Cerca tramits procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the page data of tramits RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.TramitsService#cercaTramitsProcediment(
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaTramitsProcediment")
	public PageDataOfTramitsRDTO cercaTramitsProcediment(BigDecimal idProcediment) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaTramitsProcediment(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfTramitsRDTO pageDataOfTramitsRDTO = tramitsApi.cercaTramitsProcediment(idProcediment, null, null, null, null, null,
			        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
			        null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaTramitsProcediment(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return pageDataOfTramitsRDTO;
		} catch (ApiException e) {
			log.error("cercaTramitsProcediment(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca tramits procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the page data of tramits RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfTramitsRDTO fallbackCercaTramitsProcediment(BigDecimal idProcediment) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaTramitsProcediment(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de tràmits no està disponible");
	}

	/**
	 * Consultar dades tramit ovt.
	 *
	 * @param idTramitOvt
	 *            the id tramit ovt
	 * @return the tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
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
		} catch (ApiException e) {
			log.error("consultarDadesTramitOvt(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallback consultar dades tramit ovt.
	 *
	 * @param idTramitOvt
	 *            the id tramit ovt
	 * @return the tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public TramitsOvtRDTO fallbackConsultarDadesTramitOvt(BigDecimal idTramitOvt) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesTramitOvt(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de tràmits no està disponible");
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
		} catch (ApiException e) {
			log.error("cercaAccionsPossibles(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca accions possibles.
	 *
	 * @param idAccioEstat
	 *            the id accio estat
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<AccionsEstatsRDTO> fallbackCercaAccionsPossibles(BigDecimal idAccioEstat) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaAccionsPossibles(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de tràmits no està disponible");
	}

}
