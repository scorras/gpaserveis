package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.TramitsService#cercaTramitsProcediment(
	 * java.math.BigDecimal)
	 */
	@Override
	// @HystrixCommand(fallbackMethod = "fallbackCercaTramitsProcediment")
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
	 * @return the page data of tramits RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfTramitsRDTO fallbackCercaTramitsProcediment() throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaTramitsProcediment() - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de tràmits no està disponible");
	}

}
