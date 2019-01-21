package es.bcn.gpa.gpaserveis.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bcn.gpa.gpaserveis.business.ProcedimentsService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ProcedimentsServiceImpl.
 */
@Service
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
	// @HystrixCommand(fallbackMethod = "fallbackCercaProcediments")
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
	public PageDataOfProcedimentsRDTO fallbackCercaProcediments() throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaProcediments() - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de procediments no està disponible");
	}
}
