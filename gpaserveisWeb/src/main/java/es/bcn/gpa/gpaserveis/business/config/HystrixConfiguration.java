package es.bcn.gpa.gpaserveis.business.config;

import javax.annotation.PostConstruct;

import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;

import es.bcn.gpa.gpaserveis.web.initialization.strategy.SecurityContextConcurrencyStrategy;

@Configuration
@EnableAspectJAutoProxy
public class HystrixConfiguration {

	@Value("${execution.isolation.thread.timeoutInMilliseconds}")
	private String EXECUTION_ISOLATION_THREAD_TIMEOUTINMILLISECONDS;

	// @Autowired(required = false)
	// private List<HystrixCallableWrapper> wrappers = new ArrayList<>();
	@Autowired(required = false)
	// private CustomHystrixConcurrencyStrategy existingConcurrencyStrategy;
	private HystrixConcurrencyStrategy existingConcurrencyStrategy;

	@Bean
	public HystrixCommandAspect hystrixAspect() {
		return new HystrixCommandAspect();
	}

	@Bean
	public AbstractConfiguration configurationManager() {
		AbstractConfiguration abstractConfiguration = ConfigurationManager.getConfigInstance();

		// Execution
		abstractConfiguration.setProperty("hystrix.command.default.execution.isolation.strategy", "THREAD");
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

	@PostConstruct
	public void init() {
		HystrixPlugins.reset();
		// Mantenemos los otros plugins que existan
		HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance().getEventNotifier();
		HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();
		HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance().getPropertiesStrategy();
		HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();

		HystrixPlugins.reset();

		// Registramos plugins que habia e incluimos la nueva estrategia que
		// mantiene el contexto de seguridad (aunque le pasemos uno nulo,
		// utiliza SecurityContextHolder.getContext()
		HystrixPlugins.getInstance().registerConcurrencyStrategy(new SecurityContextConcurrencyStrategy(existingConcurrencyStrategy));
		HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
		HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
		HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
		HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
	}

}