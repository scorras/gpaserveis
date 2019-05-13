package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ServeisTramitadorsRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisTramitadorsRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	private final static String BASE_URL = "/rest/serveis/tramitadors";

	@Test
	public void testStage01_PostValidarSolicitudExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/validar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage02_PostPausarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/pausar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"motiu\":\"tramitAllegacions\",\"dataLimit\":\"26/04/2019 18:24:36\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage03_PostReactivarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/reactivar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage04_PostArxivarSolicitudExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/arxivar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage05_PostRetornarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/tramitar/retornar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage06_PostProposarResolucioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/resolucio/proposar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage07_PostTancarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/tancar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage08_PostTornarEnrereExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/tornar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage09_PostValidarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/validar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage10_PostRebutjarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/rebutjar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage11_PostValidarResolucioDocument() throws Exception {
		String url = BASE_URL + "/expedients/1/resolucio/1/validar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage12_PostSignarDocument() throws Exception {
		String url = BASE_URL + "/expedients/1/resolucio/1/signar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

}