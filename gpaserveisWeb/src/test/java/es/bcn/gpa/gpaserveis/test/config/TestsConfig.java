package es.bcn.gpa.gpaserveis.test.config;

import org.mockito.Mockito;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class TestsConfig.
 */
@Configuration
@Lazy(true)

/** The Constant log. */
@CommonsLog
public class TestsConfig implements EnvironmentAware {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.EnvironmentAware#setEnvironment(org.
	 * springframework.core.env.Environment)
	 */
	@Override
	public void setEnvironment(Environment environment) {
	}

	/**
	 * Procediments api.
	 *
	 * @return the procediments api
	 */
	@Bean
	public ProcedimentsApi procedimentsApi() {
		if (log.isDebugEnabled()) {
			log.debug("procedimentsApi() - inici"); //$NON-NLS-1$
		}

		ProcedimentsApi procedimentsApi = Mockito.mock(ProcedimentsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("procedimentsApi() - fi"); //$NON-NLS-1$
		}
		return procedimentsApi;
	}

	/**
	 * Unitats gestores api.
	 *
	 * @return the unitats gestores api
	 */
	@Bean
	public UnitatsGestoresApi unitatsGestoresApi() {
		if (log.isDebugEnabled()) {
			log.debug("unitatsGestoresApi() - inici"); //$NON-NLS-1$
		}

		UnitatsGestoresApi unitatsGestoresApi = Mockito.mock(UnitatsGestoresApi.class);

		if (log.isDebugEnabled()) {
			log.debug("unitatsGestoresApi() - fi"); //$NON-NLS-1$
		}
		return unitatsGestoresApi;
	}

	/**
	 * Expedients api.
	 *
	 * @return the expedients api
	 */
	@Bean
	public Expedients_Api expedients_Api() {
		if (log.isDebugEnabled()) {
			log.debug("expedients_Api() - inici"); //$NON-NLS-1$
		}

		Expedients_Api expedients_Api = Mockito.mock(Expedients_Api.class);

		if (log.isDebugEnabled()) {
			log.debug("expedients_Api() - fi"); //$NON-NLS-1$
		}
		return expedients_Api;
	}

}
