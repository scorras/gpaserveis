package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ProcedimentsServiceImpl.
 */
@Service

/** The Constant log. */
@CommonsLog
public class ProcedimentsServiceImpl implements ProcedimentsService {

	/** The procediments api. */
	@Autowired
	private ProcedimentsApi procedimentsApi;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.ProcedimentsService#cercaProcediments(es.
	 * bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaProcediments")
	public PageDataOfProcedimentsRDTO cercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaProcediments(UnitatsGestoresCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfProcedimentsRDTO pageDataOfProcedimentsRDTO = procedimentsApi.cercaProcediments(null, null,
			        procedimentsCercaBDTO.getActivableFormatElectronic(), procedimentsCercaBDTO.getActuacio(),
			        procedimentsCercaBDTO.getAplicacioNegoci(), procedimentsCercaBDTO.getCodi(), procedimentsCercaBDTO.getCompetencies(),
			        null, null, null, null, procedimentsCercaBDTO.getCurrentPageNumber(), procedimentsCercaBDTO.getDir(),
			        procedimentsCercaBDTO.getEstats(), procedimentsCercaBDTO.getFamilies(), null, null, procedimentsCercaBDTO.getIntern(),
			        null, procedimentsCercaBDTO.getNom(), procedimentsCercaBDTO.getOperador(), procedimentsCercaBDTO.getOrganResolutori(),
			        procedimentsCercaBDTO.getPageSize(), null, procedimentsCercaBDTO.getSort(), null, null,
			        procedimentsCercaBDTO.getUgos());

			if (log.isDebugEnabled()) {
				log.debug("cercaProcediments(UnitatsGestoresCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfProcedimentsRDTO;
		} catch (ApiException e) {
			log.error("cercaProcediments(UnitatsGestoresCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca procediments.
	 *
	 * @return the page data of procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfProcedimentsRDTO fallbackCercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaProcediments() - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ProcedimentsService#
	 * consultarDadesProcediment(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesProcediment")
	public ProcedimentsRDTO consultarDadesProcediment(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesProcediment(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			ProcedimentsRDTO procedimentsRDTO = procedimentsApi.consultarDadesProcediment(id);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesProcediment(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return procedimentsRDTO;
		} catch (ApiException e) {
			log.error("consultarDadesProcediment(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades procediment.
	 *
	 * @param id
	 *            the id
	 * @return the procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public ProcedimentsRDTO fallbackConsultarDadesProcediment(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesProcediment(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.ProcedimentsService#
	 * consultarDadesProcedimentPerCodi(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesProcedimentPerCodi")
	public ProcedimentsRDTO consultarDadesProcedimentPerCodi(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesProcedimentPerCodi(String) - inici"); //$NON-NLS-1$
		}

		try {
			ProcedimentsRDTO procedimentsRDTO = procedimentsApi.consultarDadesProcedimentPerCodi(codi);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesProcedimentPerCodi(String) - fi"); //$NON-NLS-1$
			}
			return procedimentsRDTO;
		} catch (ApiException e) {
			log.error("consultarDadesProcedimentPerCodi(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades procediment per codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public ProcedimentsRDTO fallbackConsultarDadesProcedimentPerCodi(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesProcedimentPerCodi(String) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}
}
