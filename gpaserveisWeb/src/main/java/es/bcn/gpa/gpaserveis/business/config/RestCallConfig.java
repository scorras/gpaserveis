package es.bcn.gpa.gpaserveis.business.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import net.opentrends.openframe.services.rest.config.RestServiceDefaultClientConfiguration;

@Configuration
@Import({ RestServiceDefaultClientConfiguration.class })
@Lazy(true)
public class RestCallConfig {

}
