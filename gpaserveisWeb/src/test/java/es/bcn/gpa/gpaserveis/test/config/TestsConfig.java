package es.bcn.gpa.gpaserveis.test.config;

import org.mockito.Mockito;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
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
	 * Tramits api.
	 *
	 * @return the tramits api
	 */
	@Bean
	public TramitsApi tramitsApi() {
		if (log.isDebugEnabled()) {
			log.debug("tramitsApi() - inici"); //$NON-NLS-1$
		}

		TramitsApi tramitsApi = Mockito.mock(TramitsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("tramitsApi() - fi"); //$NON-NLS-1$
		}
		return tramitsApi;
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

	@Bean
	public ExpedientsApi expedientsApi() {
		if (log.isDebugEnabled()) {
			log.debug("expedientsApi() - inici"); //$NON-NLS-1$
		}

		ExpedientsApi expedientsApi = Mockito.mock(ExpedientsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("expedientsApi() - fi"); //$NON-NLS-1$
		}
		return expedientsApi;
	}

	@Bean
	public PersonesInteressades_Api personesInteressades_Api() {
		if (log.isDebugEnabled()) {
			log.debug("personesInteressades_Api() - inici"); //$NON-NLS-1$
		}

		PersonesInteressades_Api personesInteressades_Api = Mockito.mock(PersonesInteressades_Api.class);

		if (log.isDebugEnabled()) {
			log.debug("personesInteressades_Api() - fi"); //$NON-NLS-1$
		}
		return personesInteressades_Api;
	}

	@Bean
	public Persones_Api persones_Api() {
		if (log.isDebugEnabled()) {
			log.debug("persones_Api() - inici"); //$NON-NLS-1$
		}

		Persones_Api persones_Api = Mockito.mock(Persones_Api.class);

		if (log.isDebugEnabled()) {
			log.debug("persones_Api() - fi"); //$NON-NLS-1$
		}
		return persones_Api;
	}

	@Bean
	public TramitsOvtApi tramitsOvtApi() {
		if (log.isDebugEnabled()) {
			log.debug("tramitsOvtApi() - inici"); //$NON-NLS-1$
		}

		TramitsOvtApi tramitsOvtApi = Mockito.mock(TramitsOvtApi.class);

		if (log.isDebugEnabled()) {
			log.debug("tramitsOvtApi() - fi"); //$NON-NLS-1$
		}
		return tramitsOvtApi;
	}

	@Bean
	public DadesGrupsApi dadesGrupsApi() {
		if (log.isDebugEnabled()) {
			log.debug("dadesGrupsApi() - inici"); //$NON-NLS-1$
		}

		DadesGrupsApi dadesGrupsApi = Mockito.mock(DadesGrupsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("dadesGrupsApi() - fi"); //$NON-NLS-1$
		}
		return dadesGrupsApi;
	}

	@Bean
	public ConfiguracioDocumentacioApi configuracioDocumentacioApi() {
		if (log.isDebugEnabled()) {
			log.debug("configuracioDocumentacioApi() - inici"); //$NON-NLS-1$
		}

		ConfiguracioDocumentacioApi configuracioDocumentacioApi = Mockito.mock(ConfiguracioDocumentacioApi.class);

		if (log.isDebugEnabled()) {
			log.debug("configuracioDocumentacioApi() - fi"); //$NON-NLS-1$
		}
		return configuracioDocumentacioApi;
	}

}
