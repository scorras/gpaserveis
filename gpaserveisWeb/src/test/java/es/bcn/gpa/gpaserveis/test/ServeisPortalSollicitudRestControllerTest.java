package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ServeisPortalRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisPortalSollicitudRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	/** The Constant BASE_URL. */
	private final static String BASE_URL = "/rest/serveis/portal";

	/**
	 * Test stage 01 post aportar documentacio sollicitud.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testStage01_PostAportarDocumentacioSollicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/1/documentacio";
		String body = "{\"documentacio\": [{\"configuracioDocumentacio\": \"30354\",\"origen\": \"EXTERN\",\"comentari\": \"Document aportat des de portal de tramitació\",\"idioma\": \"CATALA\",\"fitxer\": {\"nom\": \"DNI.pdf\",\"format\": \"PDF\"}},{\"configuracioDocumentacio\": \"30347\",\"origen\": \"EXTERN\",\"comentari\": \"Document de declaració responsable\",\"idioma\": \"CATALA\",\"declaracioResponsable\": \"true\"}],\"registrar\": false}";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(body))
				.andExpect(status().isOk()).andDo(print());

	}

}