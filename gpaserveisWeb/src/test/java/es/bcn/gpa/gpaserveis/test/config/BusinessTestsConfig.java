package es.bcn.gpa.gpaserveis.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import es.bcn.gpa.gpaserveis.business.config.BusinessConfig;
import es.bcn.gpa.gpaserveis.business.config.HystrixConfiguration;

@Configuration
@Import({ BusinessConfig.class, HystrixConfiguration.class, TestsConfig.class })
@Lazy(true)
public class BusinessTestsConfig {
}
