package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.handler.ServeisServiceExceptionHandler;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UsuarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;
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

	/** The usuaris api. */
	@Autowired
	private UsuarisApi usuarisApi;

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
			        null, null, null, null, null, null, null, null, null, null, null, null, null, unitatsGestoresCercaBDTO.getCodi(), null,
			        null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaUnitatsGestores(UnitatsGestoresCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfUnitatsGestoresRDTO;
		} catch (RestClientException e) {
			log.error("cercaUnitatsGestores(UnitatsGestoresCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca unitats gestores.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @param e
	 *            the e
	 * @return the page data of unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfUnitatsGestoresRDTO fallbackCercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaUnitatsGestores(UnitatsGestoresCercaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.UnitatsGestoresService#
	 * consultarDadesUnitatGestora(java.math.BigDecimal)
	 */
	@Override
	@CacheResult
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesUnitatGestora")
	public UnitatsGestoresRDTO consultarDadesUnitatGestora(@CacheKey BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesUnitatGestora(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresApi.consultarDadesUnitatGestora(id);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesUnitatGestora(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return unitatsGestoresRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesUnitatGestora(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades unitat gestora.
	 *
	 * @param id
	 *            the id
	 * @param e
	 *            the e
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public UnitatsGestoresRDTO fallbackConsultarDadesUnitatGestora(BigDecimal id, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesUnitatGestora(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.UnitatsGestoresService#
	 * consultarDadesUnitatGestoraPerCodi(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesUnitatGestoraPerCodi")
	public UnitatsGestoresRDTO consultarDadesUnitatGestoraPerCodi(String codi) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesUnitatGestoraPerCodi(String) - inici"); //$NON-NLS-1$
		}

		try {
			UnitatsGestoresRDTO unitatsGestoresRDTO = unitatsGestoresApi.consultarDadesUnitatGestoraPerNom(codi);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesUnitatGestoraPerCodi(String) - fi"); //$NON-NLS-1$
			}
			return unitatsGestoresRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesUnitatGestoraPerCodi(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades unitat gestora per codi.
	 *
	 * @param codi
	 *            the codi
	 * @param e
	 *            the e
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public UnitatsGestoresRDTO fallbackConsultarDadesUnitatGestoraPerCodi(String codi, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesUnitatGestoraPerCodi(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesUsuari")
	public UsuarisRDTO consultarDadesUsuari(String matricula) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesUsuari(String) - inici"); //$NON-NLS-1$
		}

		try {
			UsuarisRDTO usuarisRDTO = usuarisApi.consultarDadesUsuari(matricula);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesUsuari(String) - fi"); //$NON-NLS-1$
			}
			return usuarisRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesUsuari(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	public UsuarisRDTO fallbackConsultarDadesUsuari(String matricula, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesUsuari(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.UnitatsGestoresService#
	 * consultarDadesUnitatOrganigrama(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesUnitatOrganigrama")
	public UnitatsOrganigramaRDTO consultarDadesUnitatOrganigrama(BigDecimal idUnitatGestora) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesUnitatOrganigrama(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			UnitatsOrganigramaRDTO unitatsOrganigramaRDTO = unitatsGestoresApi.consultarUnitatOrganigrama(idUnitatGestora);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesUnitatOrganigrama(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return unitatsOrganigramaRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesUnitatOrganigrama(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades unitat organigrama.
	 *
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @param e
	 *            the e
	 * @return the unitats organigrama RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public UnitatsOrganigramaRDTO fallbackConsultarDadesUnitatOrganigrama(BigDecimal idUnitatGestora, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesUnitatOrganigrama(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}
}
