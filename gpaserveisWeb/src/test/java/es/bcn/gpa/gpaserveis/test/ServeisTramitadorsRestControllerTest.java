package es.bcn.gpa.gpaserveis.test;

import static org.mockito.Mockito.when;
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
 * The Class ServeisTramitadorsRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisTramitadorsRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	private final static String BASE_URL = "/rest/serveis/tramitadors";

	@Test
	public void testStage01_PostValidarSolicitudExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/validar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage02_PostPausarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/pausar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"motiu\":\"tramitAllegacions\",\"dataLimit\":22}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage03_PostReactivarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/reactivar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage04_PostArxivarSolicitudExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/arxivar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage05_PostRetornarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/tramitar/retornar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage06_PostProposarResolucioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/resolucio/proposar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage07_PostTancarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/tancar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage08_PostTornarEnrereExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/tornar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage09_PostValidarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/validar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage10_PostRebutjarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/rebutjar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage11_PostValidarResolucioDocument() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/resolucio/1/validar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage12_PostSignarDocumentSegell() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/signar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"modalitatSignatura\":\"SEGELL\", \"politicaSignatura\":\"politica signatura\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage12_PostSignarDocumentManuscrita() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/signar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"modalitatSignatura\":\"MANUSCRITA\", \"politicaSignatura\":\"politica signatura\", \"usuariManuscrita\":{ \"idTabletUsuari\":\"idTabletUsuari\", \"documentUsuari\":\"79688341B\" } }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage12_PostSignarDocumentPortasignatures() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/signar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"modalitatSignatura\":\"PORTASIGNATURES\", \"politicaSignatura\":\"politica signatura\", \"usuariPortasig\":{ \"matricula\":\"123456A\" } }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage13_PostConvidarTramitarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/tramitar/convidar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"codiUnitatGestora\":\"UG3\", \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage14_PostCanviarUnitatGestoraExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/unitat";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"codiUnitatGestora\":\"UG1\", \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage15_PostIncorporarNouDocumentAportadaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"revisio\": \"CORRECTE\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\" }}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage16_PostIncorporarNouDocumentGeneradaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\" }}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage18_PostCompletarDocumentAportadaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/completar";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}}}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage19_PostCompletarDocumentGeneradaExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/completar";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"requeriment\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}}}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage20_PostPresentarDeclaracioResponsableExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/declaracio/responsable";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"document\": { \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\" }}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage21_PostPrepararRequerimentExpedient() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/requeriment";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("requeriment",
		                "{ \"document\": { \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"} }, \"dadesOperacioRequerits\": [{\"codi\": \"DO1\"}, {\"codi\": \"DO2\"}], \"documentacioRequerida\": [{\"configuracioDocumentacio\": \"42\"}, {\"configuracioDocumentacio\": \"43\"}]}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage22_PostAcumularExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/acumular";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"codiExpedient\":\"2\", \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage23_PostAccesExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/acces";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"documentsIdentitatRDTO\": { \"tipusDocument\": \"NIF\", \"numeroDocument\": \"79688341B\", \"pais\": \"108\" }}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage24_PostRegistrarComunicacioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/comunicat";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"canal\":\"TELEFON\",\"dataComunicacio\":\"22/05/2019 18:24:36\",\"comentari\":\"Expedient comunicat\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage25_PostNotificarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/notificar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\r\n\"destinataris\": \r\n[{  \r\n   \"tipusPersona\":\"FISICA\",\r\n   \"nom\":\"Carmen\",\r\n   \"cognom1\":\"Rodrigo\",\r\n   \"cognom2\":\"D\u00EDaz\",\r\n   \"documentIdentitat\":{\r\n      \"tipusDocument\":\"NIF\",\r\n      \"numeroDocument\":\"35278573T\"\r\n   },\r\n   \"dadesNotificacio\":{\r\n      \"email\":\"email@email.com\",\r\n\t  \"telefon\":\"235466356\",\r\n\t  \"mobil\":\"578239506\",\r\n\t  \"tipusVia\":\"Carrer\",\r\n\t  \"nomVia\":\"Gran V\u00EDa\",\r\n\t  \"numero\":\"15\",\r\n\t  \"bloc\":\"4\",\r\n\t  \"porta\":\"B\",\r\n\t  \"pis\":\"2\",\r\n      \"codiPostal\":\"13004\",\r\n\t  \"municipi\":\"Miguelturra\",\r\n      \"provincia\":\"Ciudad Real\",\r\n      \"viaNotificacio\":\"ELECTRONICA\"\r\n   }\r\n}]\r\n}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage26_PostDocumentSignatExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/signat";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage27_PostDigitalitzarDocumentAportadaExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/digitalitzar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"revisio\": \"CORRECTE\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\", \"codi\": \"0907a13480249616\" }}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage28_PostDigitalitzarDocumentGeneradaExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/digitalitzar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"} }}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage29_PostObtenirDocumentIntraoperabilitatExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/documentacio/1/intraoperabilitat";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"configuracio\":\"APORTADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\"}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage30_GetCercaExpedients() throws Exception {
		String url = BASE_URL
		        + "/expedients?resultatsPerPagina=20&numeroPagina=1&ordenarPer=DARRERA_MODIFICACIO&sentitOrdenacio=DESC&codiExpedient=PROC-01/2018&sollicitant=40954862G&dataPresentacioInici=22/06/2018&dataPresentacioFi=22/01/2019&codiProcediment=PROC-01,PROC-02,PROC-03&versioProcediment=TOTES_LES_VERSIONS&estat=EN_PREPARACIO,SOL_LICITUD_EN_REVISIO,PENDENT_ESMENES,EN_TRAMITACIO,PENDENT_AL_LEGACIONS,PENDENT_D_INFORMES,PROPOSTA_DE_FINALITZACIO,FINALITZAT_I_COMUNICAT,TANCAT&unitatGestora=U&tramitador=APLICACIO_DE_NEGOCI&aplicacioNegoci=quiosc";
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
		                "{\"procediment\":{\"id\":2},\"unitatGestora\":{\"codi\":\"TRANS\"},\"numeroRegistre\":\"1524/2018\",\"sollicitant\":{\"id\":null,\"dadesContacte\":null,\"docIndentitat\":null,\"tipusPersona\":\"FISICA\",\"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}},\"representant\":null, \"expedientObjecteDeRecurs\":\"2019_EXP_0001\"}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage33_AnotarOperacioComptable() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/operacioComptable/anotar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage35_InscriureEnRegistre() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/registre/inscriure";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage36_ObtenirPerInteroperabilitat() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/interoperabilitat";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"codiServei\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage37_ObtenirCertificat() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/obtenirCertificat";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage38_Consultar() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/consultar";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage39_AbandonarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/abandonar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage40_PublicarPerAInformacioPublica() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/publicar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{\"codi\":\"2019_EXP_0001\", \"comentaris\":[], \"documents\":[]}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage41_PostProposarResolucioExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/resolucio/proposar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"err\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage42_PostRetornarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0002/tramitar/retornar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"err\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage43_PostValidarSolicitudExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/validar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"err\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage44_PostActualitzarSolicitudExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"sollicitant\":{\"id\":null,\"dadesContacte\":null,\"docIndentitat\":null,\"tipusPersona\":\"FISICA\",\"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}},\"representant\":null,\"dadesOperacio\":[{\"codi\":\"metros\",\"valor\":[\"30\"]}],\"personesInteressades\":[{\"tipusPersona\":\"Física\",\"nomRaoSocial\":\"TEST\",\"cognom1\":\"PROVA\",\"cognom2\":\"PRUEBA\",\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"dadesNotificacio\":{\"email\":\"a@a.com\",\"telefon\":\"654654654\",\"mobil\":\"654654654\",\"fax\":\"987654987\",\"tipusVia\":\"C\",\"nomVia\":\"Calle\",\"numero\":\"15\",\"escala\":\"-\",\"bloc\":\"-\",\"pis\":\"-\",\"codiPostal\":\"13600\",\"municipi\":\"85\",\"provincia\":\"15\",\"pais\":\"1\",\"municipiEstranger\":\"-\",\"provinciaEstranger\":\"-\"},\"tipusIniciacio\":null}],\"personesImplicades\":[{\"tipusPersona\":\"Física\",\"nomRaoSocial\":\"TEST\",\"cognom1\":\"PROVA\",\"cognom2\":\"PRUEBA\",\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"dadesNotificacio\":{\"email\":\"a@a.com\",\"telefon\":\"654654654\",\"mobil\":\"654654654\",\"fax\":\"987654987\",\"tipusVia\":\"C\",\"nomVia\":\"Calle\",\"numero\":\"15\",\"escala\":\"-\",\"bloc\":\"-\",\"pis\":\"-\",\"codiPostal\":\"13600\",\"municipi\":\"85\",\"provincia\":\"15\",\"pais\":\"1\",\"municipiEstranger\":\"-\",\"provinciaEstranger\":\"-\"},\"tipusIniciacio\":null}]}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage45_PostActualitzarSolicitudExpedientDadesOperacioNull() throws Exception {
		String url = BASE_URL + "/expedients/1";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"sollicitant\":{\"id\":null,\"dadesContacte\":null,\"docIndentitat\":null,\"tipusPersona\":\"FISICA\",\"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}},\"representant\":null,\"dadesOperacio\":null,\"personesInteressades\":null,\"personesImplicades\":null,\"tipusIniciacio\":null}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage46_PostActualitzarSolicitudExpedientKOExpedient() throws Exception {
		String url = BASE_URL + "/expedients/a";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"sollicitant\":{\"id\":null,\"dadesContacte\":null,\"docIndentitat\":null,\"tipusPersona\":\"FISICA\",\"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIdentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}},\"representant\":null,\"dadesOperacio\":null,\"personesInteressades\":null,\"personesImplicades\":null,\"tipusIniciacio\":null}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage47_PostActualitzarSolicitudExpedientKOSollicitant() throws Exception {
		String url = BASE_URL + "/expedients/a";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"sollicitant\":null,\"representant\":null,\"dadesOperacio\":null,\"personesInteressades\":null,\"personesImplicades\":null,\"tipusIniciacio\":null}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage48_PostPausarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/pausar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"motiu\":\"tramitAllegacions\",\"dataLimit\":22}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage49_PostReactivarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/reactivar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage50_PostArxivarSolicitudExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/arxivar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage51_PostTancarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/tancar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage52_PostTornarEnrereExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/tornar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage53_PostValidarDocumentExpedientKOExpedient() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/validar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage54_PostRebutjarDocumentExpedientKOExpedient() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/rebutjar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage55_PostValidarResolucioDocumentKOExpedient() throws Exception {
		String url = BASE_URL + "/expedients/a/resolucio/1/validar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage56_PostSignarDocumentKOExpedient() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/signar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage57_PostConvidarTramitarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/tramitar/convidar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"codiUnitatGestora\":\"UG3\", \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage58_PostCanviarUnitatGestoraExpedient2() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/unitat";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"codiUnitatGestora\":\"TRANS\", \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage59_PostIncorporarNouDocumentAportadaExpedientKO() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/a/documentacio";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"revisio\": \"CORRECTE\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\" }}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage60_PostIncorporarNouDocumentGeneradaExpedientKO() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/a/documentacio";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}, \"numeroRegistre\": \"123456\" }}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage61_PostSignarDocumentKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/signar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{ \"matricula\":\"123456A\", \"documentIdentitat\":\"789456L\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage62_PostCompletarDocumentAportadaExpedientKO() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/a/documentacio/1/completar";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"APORTADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}}}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage63_PostCompletarDocumentGeneradaExpedientKO() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/a/documentacio/1/completar";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("document",
		                "{ \"document\": { \"configuracio\": \"GENERADA\", \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"requeriment\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"}}}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage64_PostPresentarDeclaracioResponsableExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/declaracio/responsable";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"document\": { \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\" }}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage65_PostPrepararRequerimentExpedientKO() throws Exception {
		MockMultipartFile mockMultipartFileFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/a/documentacio/requeriment";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFileFile)
		        .param("requeriment",
		                "{ \"document\": { \"configuracioDocumentacio\": \"42\", \"origen\": \"INTERN\", \"plantillaPdf\": \"false\", \"comentari\": \"comentari\", \"idioma\": \"CATALA\", \"digitalitzat\": true, \"digitalitzacio\": {\"idioma\": \"CASTELLA\", \"dataDigitalitzacio\": \"19/05/2019 18:45:22\"}, \"fitxer\": {\"nom\": \"prova.txt\", \"format\": \"TXT\"} }, \"dadesOperacioRequerits\": [{\"codi\": \"DO1\"}, {\"codi\": \"DO2\"}], \"documentacioRequerida\": [{\"configuracioDocumentacio\": \"42\"}, {\"configuracioDocumentacio\": \"43\"}]}")
		        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print());
	}

	// No funciona
	// @Test
	// public void testStage66_PostAcumularExpedientKO() throws Exception {
	// String url = BASE_URL + "/expedients/2019_EXP_0001/acumular";
	// getMockMvc()
	// .perform(post(url).contentType(APPLICATION_JSON_UTF8)
	// .content("{ \"codiExpedient\":\"a\", \"comentari\":\"S'executa l'acció.\"
	// }"))
	// .andExpect(status().isOk()).andDo(print());
	// }

	@Test
	public void testStage67_PostAccesExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/acces";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"documentsIdentitatRDTO\": { \"tipusDocument\": \"NIF\", \"numeroDocument\": \"79688341B\", \"pais\": \"108\" }}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage68_PostRegistrarComunicacioExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/comunicat";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"canal\":\"TELEFON\",\"dataComunicacio\":\"22/05/2019 18:24:36\",\"comentari\":\"Expedient comunicat\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage69_PostNotificarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/notificar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\r\n\"destinataris\": \r\n[{  \r\n   \"tipusPersona\":\"FISICA\",\r\n   \"nom\":\"Carmen\",\r\n   \"cognom1\":\"Rodrigo\", \r\n   \"documentIdentitat\":{\r\n      \"tipusDocument\":\"NIF\",\r\n      \"numeroDocument\":\"35278573T\"\r\n   },\r\n   \"dadesNotificacio\":{\r\n      \"email\":\"email@email.com\",\r\n\t  \"telefon\":\"235466356\",\r\n\t  \"mobil\":\"578239506\",\r\n\t  \"tipusVia\":\"Carrer\",\r\n\t  \"nomVia\":\"Gran V\u00EDa\",\r\n\t  \"numero\":\"15\",\r\n\t  \"bloc\":\"4\",\r\n\t  \"porta\":\"B\",\r\n\t  \"pis\":\"2\",\r\n      \"codiPostal\":\"13004\",\r\n\t  \"municipi\":\"Miguelturra\",\r\n      \"provincia\":\"Ciudad Real\",\r\n      \"viaNotificacio\":\"ELECTRONICA\"\r\n   }\r\n}]\r\n}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage70_PostDocumentSignatExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/signat";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage71_PostDigitalitzarDocumentExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/digitalitzar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"document\": {\"configuracio\":\"APORTADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\",\"numeroRegistre\":\"1524/2018\"}}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage72_PostDigitalitzarDocumentExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/digitalitzar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"document\": {\"configuracio\":\"GENERADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\"}}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage73_PostObtenirDocumentIntraoperabilitatExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/intraoperabilitat";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"configuracio\":\"APORTADA\",\"configuracioDocumentacio\":\"42\",\"origen\":\"EXTERN\",\"comentari\":\"Document digitalizat des de portal de tramitació\"}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage74_AnotarOperacioComptableKO() throws Exception {
		String url = BASE_URL + "/expedients/a/operacioComptable/anotar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage75_EsborrarDocumentKO() throws Exception {
		String url = BASE_URL + "/expedients/a/documentacio/1/esborrar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"configuracio\":\"APORTADA\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage76_InscriureEnRegistreKO() throws Exception {
		String url = BASE_URL + "/expedients/a/registre/inscriure";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage77_ObtenirDocumentInteroperabilitatKO() throws Exception {
		String url = BASE_URL + "/expedients/a/interoperabilitat";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"codiServei\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage78_ObtenirCertificatKO() throws Exception {
		String url = BASE_URL + "/expedients/a/obtenirCertificat";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage79_ConsultarKO() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_0001/consultar";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage80_AbandonarExpedientKO() throws Exception {
		String url = BASE_URL + "/expedients/a/abandonar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"comentari\":\"S'executa l'acció.\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage81_PublicarPerAInformacioPublicaKO() throws Exception {
		String url = BASE_URL + "/expedients/a/publicar";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8)
		                .content("{\"codi\":\"2019_EXP_0001\", \"comentaris\":[], \"documents\":[]}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage82_EsborrarDocument() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/esborrar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"configuracio\":\"APORTADA\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage83_PostSignarDocumentOnline() throws Exception {
		String url = BASE_URL + "/expedients/documentacio/1,2/signar/online";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"valorToken\":\"1\", \"informacioToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c\", \"politicaSignatura\":\"politica_1\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage84_PostFinalitzarSignarManuscrita() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/signar/manuscrita/finalitzar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage85_PostCrearTerceraPersonaOK() throws Exception {
		String url = BASE_URL + "/expedients/1/persones";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"persona\":{\"relacio\":null, \"relacioTerceraPersona\":\"Testimoni\", \"visibilitatOvt\":false, \"tipusPersona\":\"FISICA\", \"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIndentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}}}}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage86_PutActualitzarTerceraPersonaOK() throws Exception {
		String url = BASE_URL + "/expedients/1/persones";
		getMockMvc()
		        .perform(put(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{\"persona\":{\"relacio\":null, \"relacioTerceraPersona\":\"Testimoni\", \"visibilitatOvt\":false, \"tipusPersona\":\"FISICA\", \"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIndentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}}}}"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage87_DeleteTerceraPersonaOK() throws Exception {
		String url = BASE_URL + "/expedients/1/persones/1";
		getMockMvc().perform(delete(url)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage88_PostPrepararSignaturaDocumentOnlineCriptografica() throws Exception {
		String url = BASE_URL + "/expedients/documentacio/preparar/signatura/online/criptografica";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"documents\": [{\"idDocument\": 1, \"politicaSignatura\": \"Politica_1\"}, {\"idDocument\": 2, \"politicaSignatura\": \"Politica_2\"}],  \"urlRetorn\":\"http://localhost:4201/#/\" }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage89_GetDescarregarDocumentExpedient() throws Exception {

		when(clientEntity.getUsuariInteressat()).thenReturn("79688341B");

		String url = BASE_URL + "/expedients/1/documents/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void testStage90_GetReprendreTramitacio() throws Exception {
		String url = BASE_URL + "/expedients/1/reprendre";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("")).andExpect(status().isOk()).andDo(print());
	}
}