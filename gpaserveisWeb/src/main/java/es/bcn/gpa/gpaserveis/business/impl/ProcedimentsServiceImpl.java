package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.handler.ServeisServiceExceptionHandler;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
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
					procedimentsCercaBDTO.getEstats(), procedimentsCercaBDTO.getFamilies(), null, null,
					procedimentsCercaBDTO.getIniciacions(), procedimentsCercaBDTO.getIntern(), null, procedimentsCercaBDTO.getNom(),
					procedimentsCercaBDTO.getOperador(), procedimentsCercaBDTO.getOrganResolutori(), procedimentsCercaBDTO.getPageSize(),
					null, procedimentsCercaBDTO.getSort(), null, null, procedimentsCercaBDTO.getUgos());

			if (log.isDebugEnabled()) {
				log.debug("cercaProcediments(UnitatsGestoresCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfProcedimentsRDTO;
		} catch (RestClientException e) {
			log.error("cercaProcediments(UnitatsGestoresCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	public PageDataOfProcedimentsRDTO fallbackCercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaProcediments(ProcedimentsCercaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesProcediment")
	public ProcedimentsRDTO consultarDadesProcediment(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesProcediment(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			ProcedimentsRDTO procedimentsRDTO = procedimentsApi.consultarDadesProcediment(Integer.valueOf(id.intValueExact()));

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesProcediment(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return procedimentsRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesProcediment(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	public ProcedimentsRDTO fallbackConsultarDadesProcediment(BigDecimal id, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesProcediment(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

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
		} catch (RestClientException e) {
			log.error("consultarDadesProcedimentPerCodi(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	public ProcedimentsRDTO fallbackConsultarDadesProcedimentPerCodi(String codi, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesProcedimentPerCodi(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}
}
