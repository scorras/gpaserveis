package es.bcn.gpa.gpaserveis.web.initialization.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

public class HystrixMetricsServletInitializer implements WebApplicationInitializer {

	private static final String SERVLET_NAME = "hystrixMetrics";

	public void onStartup(ServletContext servletContext) throws ServletException {
	
	    ServletRegistration.Dynamic servlet = servletContext.addServlet(
	    		SERVLET_NAME, new HystrixMetricsStreamServlet());
	
	    servlet.setLoadOnStartup(1);
	    servlet.addMapping("/hystrix.stream");
	}

}