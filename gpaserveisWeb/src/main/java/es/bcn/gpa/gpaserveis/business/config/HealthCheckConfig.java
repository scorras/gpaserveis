package es.bcn.gpa.gpaserveis.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import es.bcn.gpa.gpaserveis.business.healthcheck.impl.HealthCheckerImpl;
import net.opentrends.openframe.services.core.healthcheck.HealthChecker;

@Configuration
@Lazy(true)
public class HealthCheckConfig {

	@Bean(name = "healthChecker")
	public HealthChecker healthChecker() {
		return new HealthCheckerImpl();
	}

}