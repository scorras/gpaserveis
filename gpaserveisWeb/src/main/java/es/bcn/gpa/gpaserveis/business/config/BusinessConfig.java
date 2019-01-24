package es.bcn.gpa.gpaserveis.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;
import net.opentrends.openframe.services.configuration.config.ConfigurationServiceDefaultConfiguration;
import net.opentrends.openframe.services.core.config.CoreServiceDefaultConfiguration;

@Configuration
@Import({ ConfigurationServiceDefaultConfiguration.class, CoreServiceDefaultConfiguration.class })
@ComponentScan(basePackages = "es.bcn.gpa.gpaserveis.business")
@Lazy(true)
@EntornPropertySource(value = { "classpath:/app/config/rest-clients.properties" })
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
	public Expedients_Api clientApiExpedients() {
		es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient apiClient = new es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		Expedients_Api expedientsApi = new Expedients_Api(apiClient);

		return expedientsApi;
	}

}