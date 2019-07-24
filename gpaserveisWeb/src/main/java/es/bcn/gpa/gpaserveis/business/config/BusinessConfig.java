package es.bcn.gpa.gpaserveis.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DownloadApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.NotificacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AcumulaciExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AvisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.CanviUnitatGestoraApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ComentarisApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ConvidarATramitartApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.EstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsRelacionatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PaisosApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesInteressades_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.PersonesSollicitudApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Persones_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.RetornarLaTramitacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesGrupsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.DadesOperacionsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsOvtApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;
import net.opentrends.openframe.services.configuration.config.ConfigurationServiceDefaultConfiguration;
import net.opentrends.openframe.services.core.config.CoreServiceDefaultConfiguration;

@Configuration
@Import({ ConfigurationServiceDefaultConfiguration.class, CoreServiceDefaultConfiguration.class })
@ComponentScan(basePackages = "es.bcn.gpa.gpaserveis.business")
@Lazy(true)
@EntornPropertySource(value = { "classpath:/app/config/rest-clients.properties", "classpath:/app/config/hystrix.properties" })
public class BusinessConfig {

	@Value("${procediments.service.url}")
	private String URL_SERVICES_PROCEDIMENTS;

	@Value("${unitats.service.url}")
	private String URL_SERVICES_UNITATS;

	@Value("${tramits.service.url}")
	private String URL_SERVICES_TRAMITS;

	@Value("${expedients.service.url}")
	private String URL_SERVICES_EXPEDIENTS;

	@Value("${documentacio.service.url}")
	private String URL_SERVICES_DOCUMENTACIO;

	@Bean
	public ProcedimentsApi clientApiProcediments() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient();
		apiClient.setBasePath(URL_SERVICES_PROCEDIMENTS);
		ProcedimentsApi procedimentsApi = new ProcedimentsApi(apiClient);

		return procedimentsApi;
	}

	@Bean
	public UnitatsGestoresApi clientApiUnitats() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient();
		apiClient.setBasePath(URL_SERVICES_UNITATS);
		UnitatsGestoresApi unitatsGestoresApi = new UnitatsGestoresApi(apiClient);

		return unitatsGestoresApi;
	}

	@Bean
	public TramitsApi clientApiTramits() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient();
		apiClient.setBasePath(URL_SERVICES_TRAMITS);
		TramitsApi tramitsApi = new TramitsApi(apiClient);

		return tramitsApi;
	}

	@Bean
	public Expedients_Api clientApiExpedients_() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		Expedients_Api expedients_Api = new Expedients_Api(apiClient);

		return expedients_Api;
	}

	@Bean
	public ExpedientsApi clientApiExpedients() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		ExpedientsApi expedientsApi = new ExpedientsApi(apiClient);

		return expedientsApi;
	}

	@Bean
	public PersonesInteressades_Api clientApiPersonesInteressades_() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		PersonesInteressades_Api personesInteressades_Api = new PersonesInteressades_Api(apiClient);

		return personesInteressades_Api;
	}

	@Bean
	public Persones_Api clientApiPersones_() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		Persones_Api persones_Api = new Persones_Api(apiClient);

		return persones_Api;
	}

	@Bean
	public DadesGrupsApi clientApiDadesGrups() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient();
		apiClient.setBasePath(URL_SERVICES_PROCEDIMENTS);
		DadesGrupsApi dadesGrupsApi = new DadesGrupsApi(apiClient);

		return dadesGrupsApi;
	}

	@Bean
	public TramitsOvtApi clientApiTramitsOvt() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient();
		apiClient.setBasePath(URL_SERVICES_TRAMITS);
		TramitsOvtApi tramitsOvtApi = new TramitsOvtApi(apiClient);

		return tramitsOvtApi;
	}

	@Bean
	public ConfiguracioDocumentacioApi clientApiConfiguracioDocumentacio() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient();
		apiClient.setBasePath(URL_SERVICES_DOCUMENTACIO);
		ConfiguracioDocumentacioApi configuracioDocumentacioApi = new ConfiguracioDocumentacioApi(apiClient);

		return configuracioDocumentacioApi;
	}

	@Bean
	public EstatsApi clientApiEstats() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		EstatsApi estatsApi = new EstatsApi(apiClient);

		return estatsApi;
	}

	@Bean
	public AccionsEstatsApi clientApiAccionsEstats() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient();
		apiClient.setBasePath(URL_SERVICES_TRAMITS);
		AccionsEstatsApi accionsEstatsApi = new AccionsEstatsApi(apiClient);

		return accionsEstatsApi;
	}

	@Bean
	public DocumentacioApi clientApiDocumentacio() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient();
		apiClient.setBasePath(URL_SERVICES_DOCUMENTACIO);
		DocumentacioApi documentacioApi = new DocumentacioApi(apiClient);

		return documentacioApi;
	}

	@Bean
	public DocumentacioRequeritApi clientApiDocumentacioRequerit() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient();
		apiClient.setBasePath(URL_SERVICES_DOCUMENTACIO);
		DocumentacioRequeritApi documentacioRequeritApi = new DocumentacioRequeritApi(apiClient);

		return documentacioRequeritApi;
	}

	@Bean
	public DadesEspecifiquesApi clientApiDadesEspecifiques() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		DadesEspecifiquesApi dadesEspecifiquesApi = new DadesEspecifiquesApi(apiClient);

		return dadesEspecifiquesApi;
	}

	@Bean
	public PaisosApi clientApiPaisos() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		PaisosApi paisosApi = new PaisosApi(apiClient);

		return paisosApi;
	}

	@Bean
	public DownloadApi clientApiDownload() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient();
		apiClient.setBasePath(URL_SERVICES_DOCUMENTACIO);
		DownloadApi downloadApi = new DownloadApi(apiClient);

		return downloadApi;
	}

	@Bean
	public NotificacionsApi clientApiNotificacionsApi() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient();
		apiClient.setBasePath(URL_SERVICES_DOCUMENTACIO);
		NotificacionsApi notificacionsApi = new NotificacionsApi(apiClient);

		return notificacionsApi;
	}

	@Bean
	public ComentarisApi clientApiComentaris() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		ComentarisApi comentarisApi = new ComentarisApi(apiClient);

		return comentarisApi;
	}

	@Bean
	public AvisosApi clientApiAvisos() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		AvisosApi avisosApi = new AvisosApi(apiClient);

		return avisosApi;
	}

	@Bean
	public CanviUnitatGestoraApi clientApiCanviUnitatGestora() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		CanviUnitatGestoraApi canviUnitatGestoraApi = new CanviUnitatGestoraApi(apiClient);

		return canviUnitatGestoraApi;
	}

	@Bean
	public DadesOperacionsApi clientApiDadesOperacions() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient();
		apiClient.setBasePath(URL_SERVICES_PROCEDIMENTS);
		DadesOperacionsApi dadesOperacionsApi = new DadesOperacionsApi(apiClient);

		return dadesOperacionsApi;
	}

	@Bean
	public ConvidarATramitartApi clientApiConvidarATramitart() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		ConvidarATramitartApi convidarATramitartApi = new ConvidarATramitartApi(apiClient);

		return convidarATramitartApi;
	}

	@Bean
	public AcumulaciExpedientsApi clientApiAcumulaciExpedients() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		AcumulaciExpedientsApi acumulaciExpedientsApi = new AcumulaciExpedientsApi(apiClient);

		return acumulaciExpedientsApi;
	}

	@Bean
	public RetornarLaTramitacioApi clientApiRetornarLaTramitacio() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		RetornarLaTramitacioApi retornarLaTramitacioApi = new RetornarLaTramitacioApi(apiClient);

		return retornarLaTramitacioApi;
	}

	@Bean
	public PersonesSollicitudApi clientApiPersonesSollicitud() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		PersonesSollicitudApi personesSollicitudApi = new PersonesSollicitudApi(apiClient);

		return personesSollicitudApi;
	}

	@Bean
	public ExpedientsRelacionatsApi clientApiExpedientsRelacionats() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		ExpedientsRelacionatsApi expedientsRelacionatsApi = new ExpedientsRelacionatsApi(apiClient);

		return expedientsRelacionatsApi;
	}
}