package es.bcn.gpa.gpaserveis.web.initialization.strategy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;

import es.bcn.gpa.gpaserveis.web.initialization.strategy.concurrent.DelegatingSecurityContextCallable;

@Component
public class SecurityContextConcurrencyStrategy extends HystrixConcurrencyStrategy {

	private HystrixConcurrencyStrategy existingConcurrencyStrategy;

	public SecurityContextConcurrencyStrategy(HystrixConcurrencyStrategy existingConcurrencyStrategy) {
		this.existingConcurrencyStrategy = existingConcurrencyStrategy;
	}

	@Override
	public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
		return existingConcurrencyStrategy != null ? existingConcurrencyStrategy.getBlockingQueue(maxQueueSize)
		        : super.getBlockingQueue(maxQueueSize);
	}

	@Override
	public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
		return existingConcurrencyStrategy != null ? existingConcurrencyStrategy.getRequestVariable(rv) : super.getRequestVariable(rv);
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize,
	        HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
	        BlockingQueue<Runnable> workQueue) {
		return existingConcurrencyStrategy != null
		        ? existingConcurrencyStrategy.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
		        : super.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public <T> Callable<T> wrapCallable(Callable<T> callable) {
		return existingConcurrencyStrategy != null
		        ? existingConcurrencyStrategy.wrapCallable(new DelegatingSecurityContextCallable<T>(callable))
		        : super.wrapCallable(new DelegatingSecurityContextCallable<T>(callable));
	}

}
