package es.bcn.gpa.gpaserveis.web.initialization.servlet;

import es.bcn.gpa.gpaserveis.web.rest.config.RestServerConfig;
import net.opentrends.openframe.services.web.servlet.support.AbstractAnnotationConfigRootApplicationContextlessDispatcherServletInitializer;

public class RestDispatcherServletInitializer extends AbstractAnnotationConfigRootApplicationContextlessDispatcherServletInitializer {

	private static final String SERVLET_NAME = "restDispatcher";

	@Override
	protected Class<?>[] getServletApplicationContextSecurityConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletApplicationContextApplicationConfigClasses() {
		return new Class[] { RestServerConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/rest/*" };
	}

	@Override
	protected String getServletName() {
		return SERVLET_NAME;
	}

}