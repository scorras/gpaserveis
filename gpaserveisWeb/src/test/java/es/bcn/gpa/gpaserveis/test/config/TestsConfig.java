package es.bcn.gpa.gpaserveis.test.config;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DownloadApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.NotificacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.SignaturesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AcumulaciExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AvisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ComentarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.EstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsRelacionatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesSollicitudApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.SollicitudsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesOperacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UsuarisApi;
import es.bcn.gpa.gpaserveis.web.initialization.interceptor.ClientEntity;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.security.config.RootApplicationContextSecurityDefaultConfiguration;

/**
 * The Class TestsConfig.
 */
@Configuration
@Import({ RootApplicationContextSecurityDefaultConfiguration.class })
@Lazy(true)
@CommonsLog
public class TestsConfig implements EnvironmentAware {

	/** Logger for this class. */
	private static final Log LOGGER = LogFactory.getLog(TestsConfig.class);

	/** The jndi name. */
	@Value("${persistence.dataSource.jndiName}")
	private String jndiName;

	/** The provider. */
	@Value("${DS.gpaserveisDs.provider}")
	private String provider;

	/** The dsname. */
	@Value("${DS.gpaserveisDs.dsname}")
	private String dsname;

	/** The db url. */
	@Value("${DS.gpaserveisDs.dbUrl}")
	private String dbUrl;

	/** The db user. */
	@Value("${DS.gpaserveisDs.dbuser}")
	private String dbUser;

	/** The db password. */
	@Value("${DS.gpaserveisDs.dbpassword}")
	private String dbPassword;

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
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("dataSource() - inici"); //$NON-NLS-1$
		}

		DataSource returnDataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.setName("testdb;DATABASE_TO_UPPER=false;MODE=Oracle").addScript("classpath:sql/install/01_GPASERVEIS_T.sql")
				.generateUniqueName(true).build();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("dataSource() - fi"); //$NON-NLS-1$
		}
		return returnDataSource;

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

	@Bean
	public EstatsApi estatsApi() {
		if (log.isDebugEnabled()) {
			log.debug("estatsApi() - inici"); //$NON-NLS-1$
		}

		EstatsApi estatsApi = Mockito.mock(EstatsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("estatsApi() - fi"); //$NON-NLS-1$
		}
		return estatsApi;
	}

	@Bean
	public AccionsEstatsApi accionsEstatsApi() {
		if (log.isDebugEnabled()) {
			log.debug("accionsEstatsApi() - inici"); //$NON-NLS-1$
		}

		AccionsEstatsApi accionsEstatsApi = Mockito.mock(AccionsEstatsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("accionsEstatsApi() - fi"); //$NON-NLS-1$
		}
		return accionsEstatsApi;
	}

	@Bean
	public DocumentacioApi documentacioApi() {
		if (log.isDebugEnabled()) {
			log.debug("documentacioApi() - inici"); //$NON-NLS-1$
		}

		DocumentacioApi documentacioApi = Mockito.mock(DocumentacioApi.class);

		if (log.isDebugEnabled()) {
			log.debug("documentacioApi() - fi"); //$NON-NLS-1$
		}
		return documentacioApi;
	}

	@Bean
	public SignaturesApi signaturesApi() {
		if (log.isDebugEnabled()) {
			log.debug("signaturesApi() - inici"); //$NON-NLS-1$
		}

		SignaturesApi signaturesApi = Mockito.mock(SignaturesApi.class);

		if (log.isDebugEnabled()) {
			log.debug("signaturesApi() - fi"); //$NON-NLS-1$
		}
		return signaturesApi;
	}

	@Bean
	public DocumentacioRequeritApi documentacioRequeritApi() {
		if (log.isDebugEnabled()) {
			log.debug("documentacioRequeritApi() - inici"); //$NON-NLS-1$
		}

		DocumentacioRequeritApi documentacioRequeritApi = Mockito.mock(DocumentacioRequeritApi.class);

		if (log.isDebugEnabled()) {
			log.debug("documentacioRequeritApi() - fi"); //$NON-NLS-1$
		}
		return documentacioRequeritApi;
	}

	@Bean
	public DadesEspecifiquesApi dadesEspecifiquesApi() {
		if (log.isDebugEnabled()) {
			log.debug("dadesEspecifiquesApi() - inici"); //$NON-NLS-1$
		}

		DadesEspecifiquesApi dadesEspecifiquesApi = Mockito.mock(DadesEspecifiquesApi.class);

		if (log.isDebugEnabled()) {
			log.debug("dadesEspecifiquesApi() - fi"); //$NON-NLS-1$
		}
		return dadesEspecifiquesApi;
	}

	@Bean
	public DownloadApi downloadApi() {
		if (log.isDebugEnabled()) {
			log.debug("downloadApi() - inici"); //$NON-NLS-1$
		}

		DownloadApi downloadApi = Mockito.mock(DownloadApi.class);

		if (log.isDebugEnabled()) {
			log.debug("downloadApi() - fi"); //$NON-NLS-1$
		}
		return downloadApi;
	}

	@Bean
	public ComentarisApi comentarisApi() {
		if (log.isDebugEnabled()) {
			log.debug("comentarisApi() - inici"); //$NON-NLS-1$
		}

		ComentarisApi comentarisApi = Mockito.mock(ComentarisApi.class);

		if (log.isDebugEnabled()) {
			log.debug("comentarisApi() - fi"); //$NON-NLS-1$
		}
		return comentarisApi;
	}

	@Bean
	public AvisosApi avisosApi() {
		if (log.isDebugEnabled()) {
			log.debug("avisosApi() - inici"); //$NON-NLS-1$
		}

		AvisosApi avisosApi = Mockito.mock(AvisosApi.class);

		if (log.isDebugEnabled()) {
			log.debug("avisosApi() - fi"); //$NON-NLS-1$
		}
		return avisosApi;
	}

	@Bean
	public DadesOperacionsApi dadesOperacionsApi() {
		if (log.isDebugEnabled()) {
			log.debug("dadesOperacionsApi() - inici"); //$NON-NLS-1$
		}

		DadesOperacionsApi dadesOperacionsApi = Mockito.mock(DadesOperacionsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("dadesOperacionsApi() - fi"); //$NON-NLS-1$
		}
		return dadesOperacionsApi;
	}

	@Bean
	public AcumulaciExpedientsApi acumulaciExpedientsApi() {
		if (log.isDebugEnabled()) {
			log.debug("acumulaciExpedientsApi() - inici"); //$NON-NLS-1$
		}

		AcumulaciExpedientsApi acumulaciExpedientsApi = Mockito.mock(AcumulaciExpedientsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("acumulaciExpedientsApi() - fi"); //$NON-NLS-1$
		}
		return acumulaciExpedientsApi;
	}

	@Bean
	public PersonesSollicitudApi personesSollicitudApi() {
		if (log.isDebugEnabled()) {
			log.debug("personesSollicitudApi() - inici"); //$NON-NLS-1$
		}

		PersonesSollicitudApi personesSollicitudApi = Mockito.mock(PersonesSollicitudApi.class);

		if (log.isDebugEnabled()) {
			log.debug("personesSollicitudApi() - fi"); //$NON-NLS-1$
		}
		return personesSollicitudApi;
	}

	@Bean
	public NotificacionsApi notificacionsApi() {
		if (log.isDebugEnabled()) {
			log.debug("notificacionsApi() - inici"); //$NON-NLS-1$
		}

		NotificacionsApi notificacionsApi = Mockito.mock(NotificacionsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("notificacionsApi() - fi"); //$NON-NLS-1$
		}
		return notificacionsApi;
	}

	@Bean
	public ExpedientsRelacionatsApi expedientsRelacionatsApi() {
		if (log.isDebugEnabled()) {
			log.debug("expedientsRelacionatsApi() - inici"); //$NON-NLS-1$
		}

		ExpedientsRelacionatsApi expedientsRelacionatsApi = Mockito.mock(ExpedientsRelacionatsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("expedientsRelacionatsApi() - fi"); //$NON-NLS-1$
		}
		return expedientsRelacionatsApi;
	}

	@Bean
	public SollicitudsApi sollicitudsApi() {
		if (log.isDebugEnabled()) {
			log.debug("sollicitudsApi() - inici"); //$NON-NLS-1$
		}

		SollicitudsApi sollicitudsApi = Mockito.mock(SollicitudsApi.class);

		if (log.isDebugEnabled()) {
			log.debug("sollicitudsApi() - fi"); //$NON-NLS-1$
		}
		return sollicitudsApi;
	}

	@Bean
	public UsuarisApi usuarisApi() {
		if (log.isDebugEnabled()) {
			log.debug("usuarisApi() - inici"); //$NON-NLS-1$
		}

		UsuarisApi usuarisApi = Mockito.mock(UsuarisApi.class);

		if (log.isDebugEnabled()) {
			log.debug("usuarisApi() - fi"); //$NON-NLS-1$
		}
		return usuarisApi;
	}

	@Bean
	public ClientEntity clientEntity() {
		if (log.isDebugEnabled()) {
			log.debug("clientEntity() - inici"); //$NON-NLS-1$
		}

		ClientEntity clientEntity = Mockito.mock(ClientEntity.class);

		if (log.isDebugEnabled()) {
			log.debug("clientEntity() - fi"); //$NON-NLS-1$
		}
		return clientEntity;
	}

}
