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
						"{ \"idDocScan\": \"ES_LO1080193_2019_000000000000000000000000018588\", \"resultat\": \"OK\", \"dataDigitalitzacio\": \"2019-06-06T17:25:00.123Z\", \"idioma\": \"CATALA\"}"))
				.andExpect(status().isOk()).andDo(print());

	}

}