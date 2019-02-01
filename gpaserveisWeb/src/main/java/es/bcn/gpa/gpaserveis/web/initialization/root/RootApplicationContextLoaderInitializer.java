package es.bcn.gpa.gpaserveis.web.initialization.root;

import es.bcn.gpa.gpaserveis.business.config.BusinessConfig;
import es.bcn.gpa.gpaserveis.business.config.HystrixConfiguration;
import net.opentrends.openframe.services.web.context.AbstractAnnotationConfigRootApplicationContextLoaderInitializer;


public class RootApplicationContextLoaderInitializer extends AbstractAnnotationConfigRootApplicationContextLoaderInitializer {

	@Override
	protected Class<?>[] getRootApplicationContextSecurityConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getRootApplicationContextApplicationConfigClasses() {
		return new Class[] { BusinessConfig.class, HystrixConfiguration.class };
	}

}