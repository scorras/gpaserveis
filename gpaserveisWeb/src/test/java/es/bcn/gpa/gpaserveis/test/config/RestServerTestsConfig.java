package es.bcn.gpa.gpaserveis.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import es.bcn.gpa.gpaserveis.business.config.BusinessConfig;
import es.bcn.gpa.gpaserveis.web.rest.config.RestServerConfig;

@Configuration
@Import({ BusinessConfig.class, RestServerConfig.class, TestsConfig.class })
@Lazy(true)
public class RestServerTestsConfig {
}
