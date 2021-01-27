package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ServeisPortalSollicitudRestControllerTest.
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
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage01_PostCrearSollicitud() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/sollicituds";
		String body = "{\"codiTramit\": \"APO\",\"sollicitant\": {\"nomRaoSocial\": \"Hernán\",\"cognom1\": \"Pérez de Inestrosa\",\"cognom2\": \"Sánchez\",\"sexe\": \"HOME\",\"tipusPersona\": \"FISICA\",\"dadesNotificacio\": {\"bloc\": \"string\",\"codiPostal\": \"string\",\"email\": \"string\",\"escala\": \"string\",\"fax\": \"string\",\"mobil\": \"string\",\"municipi\": \"9045\",\"municipiEstranger\": \"9045\",\"nomVia\": \"string\",\"numero\": \"string\",\"pais\": \"108\",\"pis\": \"string\",\"porta\": \"string\",\"provincia\": \"008\",\"provinciaEstranger\": \"008\",\"telefon\": \"string\",\"tipusVia\": \"FAGEDA\"},\"documentIndentitat\": {\"numeroDocument\": \"05686723L\",\"pais\": \"108\",\"tipusDocument\": \"NIF\"}},\"representant\": {\"nomRaoSocial\": \"Rosa María\",\"cognom1\": \"Díaz\",\"cognom2\": \"Gómez\",\"sexe\": \"DONA\",\"tipusPersona\": \"FISICA\",\"dadesNotificacio\": {\"bloc\": \"string\", \"codiPostal\": \"string\",\"email\": \"string\",\"escala\": \"string\", \"fax\": \"string\",\"mobil\": \"string\",\"municipi\": \"9045\",\"municipiEstranger\": \"9045\",\"nomVia\": \"string\",\"numero\": \"string\",\"pais\": \"108\",\"pis\": \"string\",\"porta\": \"string\",\"provincia\": \"008\",\"provinciaEstranger\": \"008\",\"telefon\": \"string\",\"tipusVia\": \"FAGEDA\"},\"documentIndentitat\": {\"numeroDocument\": \"81322159R\",\"pais\": \"108\",\"tipusDocument\": \"NIF\"}}}";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(body)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 02 post aportar documentacio sollicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage02_PostAportarDocumentacioSollicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/2/documentacio";
		String body = "{\"documentacio\": [{\"configuracioDocumentacio\": \"42\",\"origen\": \"EXTERN\",\"comentari\": \"Document aportat des de portal de tramitació\",\"idioma\": \"CATALA\",\"fitxer\": {\"nom\": \"DNI.pdf\",\"format\": \"PDF\"}},{\"configuracioDocumentacio\": \"43\",\"origen\": \"EXTERN\",\"comentari\": \"Document de declaració responsable\",\"idioma\": \"CATALA\",\"declaracioResponsable\": \"true\"}],\"registrar\": false}";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(body)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 03 get consultar dades sollicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_GetConsultarDadesSollicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/4";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 04 get exportar dades sollicitud xml.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage04_GetExportarDadesSollicitudXml() throws Exception {
		String url = BASE_URL + "/sollicituds/4/report/exportacio-xml";
		getMockMvc().perform(get(url).accept(MediaType.TEXT_PLAIN_VALUE)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 05 post aportar documentacio sollicitud GPA api param
	 * validation exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage05_PostAportarDocumentacioSollicitudGPAApiParamValidationException() throws Exception {
		String url = BASE_URL + "/sollicituds/2/documentacio";
		String body = "{\"documentacio\": [{\"configuracioDocumentacio\": \"1\",\"origen\": \"EXTERN\",\"comentari\": \"Document aportat des de portal de tramitació\",\"idioma\": \"CATALA\",\"fitxer\": {\"nom\": \"DNI.pdf\",\"format\": \"PDF\"}},{\"configuracioDocumentacio\": \"2\",\"origen\": \"EXTERN\",\"comentari\": \"Document de declaració responsable\",\"idioma\": \"CATALA\",\"declaracioResponsable\": \"true\"}],\"registrar\": false}";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(body)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 06 post aportar documentacio sollicitud exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage06_PostAportarDocumentacioSollicitudException() throws Exception {
		String url = BASE_URL + "/sollicituds/100/documentacio";
		String body = "{\"documentacio\": [{\"configuracioDocumentacio\": \"1\",\"origen\": \"EXTERN\",\"comentari\": \"Document aportat des de portal de tramitació\",\"idioma\": \"CATALA\",\"fitxer\": {\"nom\": \"DNI.pdf\",\"format\": \"PDF\"}},{\"configuracioDocumentacio\": \"2\",\"origen\": \"EXTERN\",\"comentari\": \"Document de declaració responsable\",\"idioma\": \"CATALA\",\"declaracioResponsable\": \"true\"}],\"registrar\": false}";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(body)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 07 delete esborrar document.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage07_DeleteEsborrarDocument() throws Exception {
		String url = BASE_URL + "/sollicituds/2/documentacio/1";
		getMockMvc().perform(delete(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 08 delete esborrar document GPA api param validation
	 * exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage08_DeleteEsborrarDocumentGPAApiParamValidationException() throws Exception {
		String url = BASE_URL + "/sollicituds/1/documentacio/1";
		getMockMvc().perform(delete(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 09 delete esborrar document exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage09_DeleteEsborrarDocumentException() throws Exception {
		String url = BASE_URL + "/sollicituds/3/documentacio/2";
		getMockMvc().perform(delete(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 10 post upload document sollicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage10_PostUploadDocumentSollicitud() throws Exception {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/sollicituds/2/documentacio/1/upload";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 11 post upload document sollicitud GPA api param validation
	 * exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage11_PostUploadDocumentSollicitudGPAApiParamValidationException() throws Exception {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/sollicituds/3/documentacio/3/upload";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 12 get descarregar document sollicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage12_GetDescarregarDocumentSollicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/2/documentacio/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());

	}

	/**
	 * Test stage 13 get descarregar document sollicitud GPA api param
	 * validation exception.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage13_GetDescarregarDocumentSollicitudGPAApiParamValidationException() throws Exception {
		String url = BASE_URL + "/sollicituds/3/documentacio/3";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().is5xxServerError());

	}

	/**
	 * Test stage 14 post substituir document sollicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage14_PostSubstituirDocumentSollicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/1/documentacio/1/substituir";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"configuracioDocumentacio\": \"43\", \"origen\": \"EXTERN\", \"comentari\": \"Document substituït des de portal de tramitació\", \"idioma\": \"CASTELLA\", \"fitxer\": {\t\"nom\": \"DNI_H.pdf\",\t\"format\": \"PDF\" }}"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 15 post registrar solicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage15_PostRegistrarSolicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/4/registre";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"signaturaSolicitud\": \"1\" }"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 16 post actualitzar sollicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage16_PostActualitzarSollicitud() throws Exception {
		String url = BASE_URL + "/sollicituds/2";
		String body = "{\"sollicitant\": {\"nomRaoSocial\": \"Hernán\",\"cognom1\": \"Pérez de Inestrosa\",\"cognom2\": \"Sánchez\",\"sexe\": \"HOME\",\"tipusPersona\": \"FISICA\",\"dadesNotificacio\": {\"bloc\": \"string\",\"codiPostal\": \"string\",\"email\": \"string\",\"escala\": \"string\",\"fax\": \"string\",\"mobil\": \"string\",\"municipi\": \"9045\",\"municipiEstranger\": \"9045\",\"nomVia\": \"string\",\"numero\": \"string\",\"pais\": \"108\",\"pis\": \"string\",\"porta\": \"string\",\"provincia\": \"008\",\"provinciaEstranger\": \"008\",\"telefon\": \"string\",\"tipusVia\": \"FAGEDA\"},\"documentIndentitat\": {\"numeroDocument\": \"05686723L\",\"pais\": \"108\",\"tipusDocument\": \"NIF\"}},\"representant\": {\"nomRaoSocial\": \"Rosa María\",\"cognom1\": \"Díaz\",\"cognom2\": \"Gómez\",\"sexe\": \"DONA\",\"tipusPersona\": \"FISICA\",\"dadesNotificacio\": {\"bloc\": \"string\", \"codiPostal\": \"string\",\"email\": \"string\",\"escala\": \"string\", \"fax\": \"string\",\"mobil\": \"string\",\"municipi\": \"9045\",\"municipiEstranger\": \"9045\",\"nomVia\": \"string\",\"numero\": \"string\",\"pais\": \"108\",\"pis\": \"string\",\"porta\": \"string\",\"provincia\": \"008\",\"provinciaEstranger\": \"008\",\"telefon\": \"string\",\"tipusVia\": \"FAGEDA\"},\"documentIndentitat\": {\"numeroDocument\": \"81322159R\",\"pais\": \"108\",\"tipusDocument\": \"NIF\"}},\"dadesOperacio\":[{\"codi\":\"DO\",\"valor\":[\"35\"]}]}";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(body)).andExpect(status().isOk()).andDo(print());
	}

	/**
	 * Test stage 17 incorporar tercera persona sollicitud
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStage17_PostCrearTerceraPersonaSollicitudOK() throws Exception {
		String url = BASE_URL + "/sollicituds/2/persones";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"persona\":{\"relacio\":null, \"relacioTerceraPersona\":\"Testimoni\", \"visibilitatOvt\":false, \"tipusPersona\":\"FISICA\", \"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIndentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}}}}"))
				.andExpect(status().isOk()).andDo(print());
	}

	/**
	 * Test stage 18 actualitzar tercera persona sollicitud
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStage18_PutActualitzarTerceraPersonaSollicitudOK() throws Exception {
		String url = BASE_URL + "/sollicituds/2/persones";
		getMockMvc()
				.perform(put(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"persona\":{\"relacio\":null, \"relacioTerceraPersona\":\"Testimoni\", \"visibilitatOvt\":false, \"tipusPersona\":\"FISICA\", \"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIndentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}}}}"))
				.andExpect(status().isOk()).andDo(print());
	}

	/**
	 * Test stage 19 esborrar tercera persona sollicitud
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStage19_EsborrarTerceraPersonaSollicitudOK() throws Exception {
		String url = BASE_URL + "/sollicituds/2/persones/1";
		getMockMvc().perform(delete(url)).andExpect(status().isOk()).andDo(print());
	}
}