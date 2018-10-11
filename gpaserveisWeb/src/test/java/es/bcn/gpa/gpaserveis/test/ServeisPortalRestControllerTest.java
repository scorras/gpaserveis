package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ExpedientsRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisPortalRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";
	
	private final static String BASE_URL = "/rest/serveis/portal";

	@Test
	public void testStage01_GetCercaProcediments() throws Exception {
		String url = BASE_URL + "/procediments";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testStage02_GetConsultarDadesProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testStage03_GetConsultarDadesOperacioProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1/tramits/1/atributs";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage04_GetConsultarDocumentacioProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1/tramits/1/documentacio";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testStage05_GetCercaExpedients() throws Exception {
		String url = BASE_URL + "/expedients";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testStage06_GetConsultarDadesExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}



}