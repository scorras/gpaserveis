package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class UnitatsGestoresServiceImpl.
 */
@Service

/** The Constant log. */
@CommonsLog
public class UnitatsGestoresServiceImpl implements UnitatsGestoresService {

	/** The unitats gestores api. */
	@Autowired
	private UnitatsGestoresApi unitatsGestoresApi;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.UnitatsGestoresService#
	 * cercaUnitatsGestores(es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.
	 * UnitatsGestoresCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaUnitatsGestores")
	public PageDataOfUnitatsGestoresRDTO cercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaUnitatsGestores(UnitatsGestoresCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfUnitatsGestoresRDTO pageDataOfUnitatsGestoresRDTO = unitatsGestoresApi.cercaUnitatsGestores(null, null, null, null,
			        null, null, null, null, null, null, null, null, null, unitatsGestoresCercaBDTO.getNom(), null, null, null, null, null,
			        null);

			if (log.isDebugEnabled()) {
				log.debug("cercaUnitatsGestores(UnitatsGestoresCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfUnitatsGestoresRDTO;
		} catch (ApiException e) {
			log.error("cercaUnitatsGestores(UnitatsGestoresCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca unitats gestores.
	 *
	 * @return the page data of unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfUnitatsGestoresRDTO fallbackCercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaUnitatsGestores() - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de unitats gestores no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.UnitatsGestoresService#
	 * consultarDadesUnitatGestora(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesUnitatGestora")
	public UnitatsGestoresRDTO consultarDadesUnitatGestora(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesUnitatGestora(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresApi.consultarDadesUnitatGestora(id);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesUnitatGestora(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return unitatsGestoresRDTO;
		} catch (ApiException e) {
			log.error("consultarDadesUnitatGestora(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades unitat gestora.
	 *
	 * @param id
	 *            the id
	 * @return the procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public UnitatsGestoresRDTO fallbackConsultarDadesUnitatGestora(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesUnitatGestora(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de unitats gestores no està disponible");
	}
}
