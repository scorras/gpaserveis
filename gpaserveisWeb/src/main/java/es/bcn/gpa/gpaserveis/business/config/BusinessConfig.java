package es.bcn.gpa.gpaserveis.business.config;

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
}