package es.bcn.gpa.gpaserveis.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import es.bcn.gpa.gpaserveis.business.ServeisPortalService;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;
import es.bcn.gpa.gpaserveis.web.rest.controller.ServeisPortalRestController;
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.rest.exception.ResourceNotFoundException;

/**
 * The Class BaseRestControllerTest.
 */
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@CommonsLog
public class BaseRestControllerTest extends RestServerParentTest {

	/** The serveis portal rest controller. */
	@Autowired
	@InjectMocks
	private ServeisPortalRestController serveisPortalRestController;

	/** The serveis portal service. */
	@Mock
	private ServeisPortalService serveisPortalService;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		if (log.isDebugEnabled()) {
			log.debug("setup() - inici"); //$NON-NLS-1$
		}

		MockitoAnnotations.initMocks(this);

		if (log.isDebugEnabled()) {
			log.debug("setup() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 01 handle GPA serveis service exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage01_HandleGPAServeisServiceException() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("testStage01_HandleGPAServeisServiceException() - inici"); //$NON-NLS-1$
		}

		when(serveisPortalService.cercaProcediments(any(ProcedimentsCercaBDTO.class)))
		        .thenThrow(new GPAServeisServiceException("Service Exception"));

		String url = "/rest/serveis/portal/procediments";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isInternalServerError())
		        .andExpect(jsonPath("$.errorMessage").value("Service Exception"));

		if (log.isDebugEnabled()) {
			log.debug("testStage01_HandleGPAServeisServiceException() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 02 handle GPA serveis runtime exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage02_HandleGPAServeisRuntimeException() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("testStage02_HandleGPAServeisRuntimeException() - inici"); //$NON-NLS-1$
		}

		when(serveisPortalService.cercaProcediments(any(ProcedimentsCercaBDTO.class)))
		        .thenThrow(new GPAServeisRuntimeException("Runtime Exception"));

		String url = "/rest/serveis/portal/procediments";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isInternalServerError())
		        .andExpect(jsonPath("$.errorMessage").value("Runtime Exception"));

		if (log.isDebugEnabled()) {
			log.debug("testStage02_HandleGPAServeisRuntimeException() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 03 handle runtime exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_HandleRuntimeException() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("testStage03_HandleRuntimeException() - inici"); //$NON-NLS-1$
		}

		when(serveisPortalService.cercaProcediments(any(ProcedimentsCercaBDTO.class))).thenThrow(new RuntimeException("Runtime Exception"));

		String url = "/rest/serveis/portal/procediments";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isInternalServerError())
		        .andExpect(jsonPath("$.errorMessage").value("Runtime Exception"));

		if (log.isDebugEnabled()) {
			log.debug("testStage03_HandleRuntimeException() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 04 handle resource not found exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@Ignore
	public void testStage04_HandleResourceNotFoundException() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("testStage04_HandleResourceNotFoundException() - inici"); //$NON-NLS-1$
		}

		when(serveisPortalService.cercaProcediments(any(ProcedimentsCercaBDTO.class)))
		        .thenThrow(new ResourceNotFoundException(new Throwable("Resource Not Exception")));

		String url = "/rest/serveis/portal/procediments";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isInternalServerError())
		        .andExpect(jsonPath("$.errorMessage").value("Resource Not Exception"));

		if (log.isDebugEnabled()) {
			log.debug("testStage04_HandleResourceNotFoundException() - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Test stage 05 handle throwable.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@Ignore
	public void testStage05_HandleThrowable() throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("testStage05_HandleThrowable() - inici"); //$NON-NLS-1$
		}

		when(serveisPortalService.cercaProcediments(any(ProcedimentsCercaBDTO.class))).thenThrow(new Throwable("Throwable"));

		String url = "/rest/serveis/portal/procediments";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isInternalServerError())
		        .andExpect(jsonPath("$.errorMessage").value("Throwable"));

		if (log.isDebugEnabled()) {
			log.debug("testStage05_HandleThrowable() - fi"); //$NON-NLS-1$
		}
	}

}