package es.bcn.gpa.gpaserveis.business.healthcheck.impl;

import net.opentrends.openframe.services.core.healthcheck.HealthChecker;
import net.opentrends.openframe.services.core.healthcheck.dto.HealthCheckResults;
import net.opentrends.openframe.services.core.healthcheck.exception.LivenessException;
import net.opentrends.openframe.services.core.healthcheck.exception.ReadinessException;
import net.opentrends.openframe.services.core.healthcheck.impl.HealthCheckerAbstractImpl;

public class HealthCheckerImpl extends HealthCheckerAbstractImpl {

	@Override
	@SuppressWarnings({ "squid:S1166", "squid:S1181" })
	public HealthCheckResults checkApplicationLiveness() throws LivenessException {
		HealthCheckResults healthCheckResults = new HealthCheckResults();
		try {
			// Do whatever is needed to check for a possible resource shortage
			healthCheckResults.addProbeResult("gpaserveis", HealthChecker.OK_RESULT);
		} catch (Throwable t) {
			// squid:S1166 = The catched exception should be traced or
			// rethrown... in this case
			healthCheckResults.addProbeResult("gpaserveis", HealthChecker.NOK_RESULT);
			throw new LivenessException(healthCheckResults);
		}
		return healthCheckResults;
	}

	@Override
	@SuppressWarnings({ "squid:S1166", "squid:S1181" })
	public HealthCheckResults checkApplicationReadiness() throws ReadinessException {
		HealthCheckResults healthCheckResults = new HealthCheckResults();
		try {
			// Do whatever is needed to check if a required element is accesible
			// or not
			healthCheckResults.addProbeResult("gpaserveis", HealthChecker.OK_RESULT);
		} catch (Throwable t) {
			// squid:S1166, squid:S1181
			healthCheckResults.addProbeResult("gpaserveis", HealthChecker.NOK_RESULT);
			throw new ReadinessException(healthCheckResults);
		}
		return healthCheckResults;
	}

}