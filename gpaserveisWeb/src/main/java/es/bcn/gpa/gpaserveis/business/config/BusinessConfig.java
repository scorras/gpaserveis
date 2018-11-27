package es.bcn.gpa.gpaserveis.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import es.bcn.gpa.gpaserveis.rest.client.api.Expedients_Api;
import es.bcn.gpa.gpaserveis.rest.client.invoker.ApiClient;
import net.opentrends.openframe.services.configuration.annotation.EntornPropertySource;
import net.opentrends.openframe.services.configuration.config.ConfigurationServiceDefaultConfiguration;
import net.opentrends.openframe.services.core.config.CoreServiceDefaultConfiguration;

@Configuration
@Import({ ConfigurationServiceDefaultConfiguration.class, CoreServiceDefaultConfiguration.class })
@Lazy(true)
@EntornPropertySource(value = { "classpath:/app/config/rest-clients.properties" })
public class BusinessConfig {
	
	@Value("${expedients.service.url}")
	private String URL_SERVICES_EXPEDIENTS;
	
	@Bean
	public Expedients_Api clientApiProcediments(){
		
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(URL_SERVICES_EXPEDIENTS);
		Expedients_Api expedientsApi = new Expedients_Api(apiClient);
		
		return expedientsApi;
	}
	
	
	
	
}