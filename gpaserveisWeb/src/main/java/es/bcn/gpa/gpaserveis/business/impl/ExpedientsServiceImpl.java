package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.ExpedientsService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
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
			        expedientsCercaBDTO.getAplicacioNegoci(), expedientsCercaBDTO.getCodi(), null, null, null, null, null, null, null,
			        expedientsCercaBDTO.getCurrentPageNumber(), expedientsCercaBDTO.getDataPresentacioDes(),
			        expedientsCercaBDTO.getDataPresentacioFinsA(), expedientsCercaBDTO.getDir(), expedientsCercaBDTO.getEstatList(), null,
			        null, null, expedientsCercaBDTO.getPageSize(), null, expedientsCercaBDTO.getProcedimentCodisList(),
			        expedientsCercaBDTO.getProcedimentVersio(), expedientsCercaBDTO.getSollicitant(), expedientsCercaBDTO.getSort(), null,
			        null, expedientsCercaBDTO.getTramitador(), expedientsCercaBDTO.getUnitatsGestoresList());

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
}
