package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"motiu\":\"tramitAllegacions\",\"dataLimit\":22}"))
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
		String url = BASE_URL + "/expedients/1/documentacio/1/signar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage13_PostConvidarTramitarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/tramitar/convidar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"codiUnitatGestora\":\"UG1\", \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage14_PostCanviarUnitatGestoraExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/unitat";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"codiUnitatGestora\":\"UG1\", \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage15_PostIncorporarNouDocumentAportadaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/1/documentacio";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
				.param("document",
						"{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"revisio\": \"CORRECTE\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\" }}")
				.contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage16_PostIncorporarNouDocumentGeneradaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/1/documentacio";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
				.param("document",
						"{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\" }}")
				.contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage17_PostSignarDocument() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/signar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage18_PostCompletarDocumentAportadaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/1/documentacio/1/completar";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
				.param("document",
						"{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}}}")
				.contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage19_PostCompletarDocumentGeneradaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/1/documentacio/1/completar";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
				.param("document",
						"{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"requeriment\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}}}")
				.contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage20_PostPresentarDeclaracioResponsableExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/declaracio/responsable";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"document\": { \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\" }}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage21_PostPrepararRequerimentExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/1/documentacio/requeriment";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
				.param("requeriment",
						"{ \"document\": { \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"} }, \"dadesOperacioRequerits\": [{\"codi\": \"DO1\"}, {\"codi\": \"DO2\"}], \"documentacioRequerida\": [{\"configuracioDocumentacio\": \"42\"}, {\"configuracioDocumentacio\": \"43\"}]}")
				.contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage22_PostAcumularExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/acumular";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8)
						.content("{ \"codiExpedient\":\"2\", \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage23_PostAccesExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/acces";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"documentIdentitat\": { \"tipusDocument\": \"NIF\", \"numeroDocument\": \"79688341B\", \"pais\": \"108\" }}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage24_PostRegistrarComunicacioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/comunicat";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"canal\":\"TELEFON\",\"dataComunicacio\":\"22/05/2019 18:24:36\",\"comentari\":\"Expedient comunicat\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage25_PostNotificarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/notificar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\r\n\"destinataris\": \r\n[{  \r\n   \"tipusPersona\":\"FISICA\",\r\n   \"nom\":\"Carmen\",\r\n   \"cognom1\":\"Rodrigo\",\r\n   \"cognom2\":\"D\u00EDaz\",\r\n   \"documentIdentitat\":{\r\n      \"tipusDocument\":\"NIF\",\r\n      \"numeroDocument\":\"35278573T\"\r\n   },\r\n   \"dadesNotificacio\":{\r\n      \"email\":\"email@email.com\",\r\n\t  \"telefon\":\"235466356\",\r\n\t  \"mobil\":\"578239506\",\r\n\t  \"tipusVia\":\"Carrer\",\r\n\t  \"nomVia\":\"Gran V\u00EDa\",\r\n\t  \"numero\":\"15\",\r\n\t  \"bloc\":\"4\",\r\n\t  \"porta\":\"B\",\r\n\t  \"pis\":\"2\",\r\n      \"codiPostal\":\"13004\",\r\n\t  \"municipi\":\"Miguelturra\",\r\n      \"provincia\":\"Ciudad Real\",\r\n      \"viaNotificacio\":\"ELECTRONICA\"\r\n   }\r\n}]\r\n}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage26_PostDocumentSignatExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/signat";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage27_PostDigitalitzarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/digitalitzar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"document\": {\"configuracio\":\"APORTADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\",\"numeroRegistre\":\"1524/2018\"}}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage28_PostDigitalitzarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/digitalitzar";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"document\": {\"configuracio\":\"GENERADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\"}}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage29_PostObtenirDocumentIntraoperabilitatExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/intraoperabilitat";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"configuracio\":\"APORTADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\"}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage30_GetCercaExpedients() throws Exception {
		String url = BASE_URL
				+ "/expedients?resultatsPerPagina=20&numeroPagina=1&ordenarPer=DARRERA_MODIFICACIO&sentitOrdenacio=DESC&codiExpedient=PROC-01/2018&sollicitant=40954862G&dataPresentacioInici=22/06/2018&dataPresentacioFi=22/01/2019&codiProcediment=PROC-01,PROC-02,PROC-03&versioProcediment=TOTES_LES_VERSIONS&estat=REBUT,EN_CURS,PENDENT_ESMENES,PENDENT_ALEGACIONS,RESOLT,TANCAT&unitatGestora=U&tramitador=APLICACIO_DE_NEGOCI&aplicacioNegoci=quiosc";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage31_IniciarRevisioExpedient() throws Exception {
		String url = BASE_URL + "/expedients";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"procediment\":{\"id\":2},\"unitatGestora\":{\"codi\":\"TRANS\"},\"numeroRegistre\":\"1524/2018\",\"sollicitant\":{\"id\":null,\"dadesContacte\":null,\"docIndentitat\":null,\"tipusPersona\":\"FISICA\",\"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}},\"representant\":null}"))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage32_PresentarRecursExpedient() throws Exception {
		String url = BASE_URL + "/expedients/recurs";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"procediment\":{\"id\":2},\"unitatGestora\":{\"codi\":\"TRANS\"},\"numeroRegistre\":\"1524/2018\",\"sollicitant\":{\"id\":null,\"dadesContacte\":null,\"docIndentitat\":null,\"tipusPersona\":\"FISICA\",\"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}},\"representant\":null, \"expedientObjecteDeRecurs\":\"2019_EXP_335701\"}"))
				.andExpect(status().isOk()).andDo(print());
	}

}