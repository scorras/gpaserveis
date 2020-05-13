package es.bcn.gpa.gpaserveis.business.config;

import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

@Configuration
@EnableAspectJAutoProxy
public class HystrixConfiguration {

	@Value("${execution.isolation.thread.timeoutInMilliseconds}")
	private String EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS;

	@Bean
	public HystrixCommandAspect hystrixAspect() {
		return new HystrixCommandAspect();
	}

	@Bean
	public AbstractConfiguration configurationManager() {
		AbstractConfiguration abstractConfiguration = ConfigurationManager.getConfigInstance();

		// Execution
		abstractConfiguration.setProperty("hystrix.command.default.execution.isolation.strategy", "SEMAPHORE");
		abstractConfiguration.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds",
		        EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS);
		abstractConfiguration.setProperty("hystrix.command.default.execution.timeout.enabled", "true");
		abstractConfiguration.setProperty("hystrix.command.default.execution.isolation.thread.interruptOnTimeout", "false");
		abstractConfiguration.setProperty("hystrix.command.default.execution.isolation.thread.interruptOnCancel", "true");

		// Circuit Breaker
		abstractConfiguration.setProperty("hystrix.command.default.circuitBreaker.enabled", "true");
		abstractConfiguration.setProperty("hystrix.command.default.circuitBreaker.requestVolumeThreshold", "20");
		abstractConfiguration.setProperty("hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds", "20000");
		abstractConfiguration.setProperty("hystrix.command.default.circuitBreaker.errorThresholdPercentage", "50");

		// Metrics
		abstractConfiguration.setProperty("hystrix.command.default.metrics.rollingStats.timeInMilliseconds", "10000");
		abstractConfiguration.setProperty("hystrix.command.default.metrics.rollingStats.numBuckets", "10");
		abstractConfiguration.setProperty("hystrix.command.default.metrics.healthSnapshot.intervalInMilliseconds", "500");

		// ThreadPool Properties
		abstractConfiguration.setProperty("hystrix.threadpool.default.coreSize", "25");
		abstractConfiguration.setProperty("hystrix.threadpool.default.maximumSize", "250");
		abstractConfiguration.setProperty("hystrix.threadpool.default.allowMaximumSizeToDivergeFromCoreSize", "true");
		abstractConfiguration.setProperty("hystrix.threadpool.default.maxQueueSize", "-1");

		return abstractConfiguration;
	}

}