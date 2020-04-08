package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ServeisModulDigitalitzacioRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisModulDigitalitzacioRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	/** The Constant BASE_URL. */
	private final static String BASE_URL = "/rest/serveis/mds";

	/**
	 * Test stage 01 post resposta notificacio escaneig.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage01_PostRespostaNotificacioEscaneig() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "evidencia_digitalitzacio");
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"idDocumentum\": [\"0907a13480249616\",\"0907a13480249617\"], \"idPeticio\": \"1\", \"estatECompulsa\": \"OK\" }"))
		        .andExpect(status().isOk()).andDo(print());

	}

}