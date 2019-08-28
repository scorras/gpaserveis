package es.bcn.gpa.gpaserveis.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DadesOperacioService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesOperacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DadesOperacioServiceImpl.
 */
@Service
@CommonsLog
public class DadesOperacioServiceImpl implements DadesOperacioService {

	/** The dades grups api. */
	@Autowired
	private DadesGrupsApi dadesGrupsApi;

	/** The dades operacions api. */
	@Autowired
	private DadesOperacionsApi dadesOperacionsApi;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DadesOperacioService#cercaDadesOperacio(es
	 * .bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDadesOperacio")
	public PageDataOfDadesGrupsRDTO cercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDadesOperacio(DadesOperacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = null;
			if (dadesOperacioCercaBDTO.getIdTramitOvt() != null) {
				pageDataOfDadesGrupsRDTO = dadesGrupsApi.cercaDadesOperacioAgrupatsPerTramitOvt(dadesOperacioCercaBDTO.getIdProcediment(),
				        dadesOperacioCercaBDTO.getIdTramitOvt(), null, null);
			} else {
				pageDataOfDadesGrupsRDTO = dadesGrupsApi.cercaDadesOperacio(dadesOperacioCercaBDTO.getIdProcediment(), null, null);
			}

			if (log.isDebugEnabled()) {
				log.debug("cercaDadesOperacio(DadesOperacioCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfDadesGrupsRDTO;
		} catch (RestClientException e) {
			log.error("cercaDadesOperacio(DadesOperacioCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca dades operacio.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the page data of dades grups RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfDadesGrupsRDTO fallbackCercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDadesOperacio(DadesOperacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DadesOperacioService#
	 * cercaDadesOperacioRequerits(es.bcn.gpa.gpaserveis.business.dto.
	 * procediments.DadesOperacioCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDadesOperacioRequerits")
	public PageDataOfDadesOperacionsRDTO cercaDadesOperacioRequerits(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDadesOperacioRequerits(DadesOperacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfDadesOperacionsRDTO pageDataOfDadesOperacionsRDTO = dadesOperacionsApi.cercaDadesOperacioRequerits(
			        dadesOperacioCercaBDTO.getIdProcediment(), null, null, null, null, null, null, null, null, null, null, null, null, null,
			        null);

			if (log.isDebugEnabled()) {
				log.debug("cercaDadesOperacioRequerits(DadesOperacioCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfDadesOperacionsRDTO;
		} catch (RestClientException e) {
			log.error("cercaDadesOperacioRequerits(DadesOperacioCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca dades operacio requerits.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the page data of dades operacions RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfDadesOperacionsRDTO fallbackCercaDadesOperacioRequerits(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDadesOperacioRequerits(DadesOperacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}

}
