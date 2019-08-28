package es.bcn.gpa.gpaserveis.test.parent;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.bcn.gpa.gpaserveis.test.config.RestServerTestsConfig;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.web.test.servlet.setup.ServletBaseContextReplacer;

/**
 * The Class RestServerParentTest.
 */
@ContextConfiguration(classes = { RestServerTestsConfig.class })
@WebAppConfiguration
@CommonsLog
public abstract class RestServerParentTest extends ParentTest {

	/** The wac. */
	@Autowired
	private WebApplicationContext wac;

	/** The mock mvc. */
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		if (log.isDebugEnabled()) {
			log.debug("setUp() - inici"); //$NON-NLS-1$
		}

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).apply(new ServletBaseContextReplacer("/rest", "")).addFilter(new HystrixRequestContextServletFilter()).build();
		super.setUp();

		if (log.isDebugEnabled()) {
			log.debug("setUp() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Gets the mock mvc.
	 *
	 * @return the mock mvc
	 */
	protected MockMvc getMockMvc() {
		return mockMvc;
	}

}