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
 * The Class ServeisPortalRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisPortalRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	/** The Constant BASE_URL. */
	private final static String BASE_URL = "/rest/serveis/portal";

	/**
	 * Test stage 01 get cerca procediments.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage01_GetCercaProcediments() throws Exception {
		String url = BASE_URL
				+ "/procediments?resultatsPerPagina=20&numeroPagina=1&ordenarPer=CODI&sentitOrdenacio=ASC&codi=PROC-01&estat=EN_ELABORACIO,FINALITZAT,PUBLICAT&nom=Procediment1&tramitador=APLICACIO_DE_NEGOCI&aplicacioNegoci=quiosc&ugr=UG1&exclusivamentIntern=SI&activableFormatElectronic=PORTAL_TRAMITS,ALTRA_WEB,MOBIL,QUIOSC,PER_CANAL_GENERALISTA,PER_CANAL_ESPECIFIC&organResolutori=ple&competenciaAssociada=ACCIO_SOCIAL,AFERS_JURIDICS,BENS_I_PATRIMONI,COMERC_I_CONSUM,CULTURA,EDUCACIO,ESPORTS_I_LLEURE,HABITATGE,MEDI_AMBIENT,MOVILITAT_TRANSPORT_I_CIRCULACIO,OBRES_I_INFRAESTRUCTURES,ORGANITZACIO_I_COORDINACIO_ADMINISTRATIVA,ORGANS_DE_GOVERN,POBLACIO_I_DEMARCACIO,POTESTATS_DE_PLANIFICACIO_I_NORMATIVA,PRESSUPOSTOS_I_FINANCES,PROMOCIO_ECONOMICA,RECURSOS_HUMANS&familia=ATENCIO_SOCIAL_I_RESIDENCIAL,AUTORITZACIONS_I_COMUNICATS,CERTAMENS_I_PREMIS,COL_LABORACIO,CONSULTES_I_SUGGERIMENTS,CONTRACTACIO_PUBLICA,DISCIPLINA_INSPECCIO_I_PROTECCIO_DE_LA_LEGALITAT,DRETS_D_ACCES_A_LA_INFORMACIO,DRETS_I_ACTIVITAT_CIVIL,ENS_DEPENDENTS_I_PARTICIPATS,EXECUCIO_URBANISTICA,GESTIO_DEL_PERSONAL,GESTIO_PRESSUPOSTARIA_I_FINANCERA,GESTIO_TRIBUTARIA,INFORMES_I_CERTIFICATS,INSCRIPCIONS_REGISTRALS,MEDIACIO_I_ARBITRATGE,NORMATIVA,OCUPACIO_I_SERVEIS_A_LA_VIA_PUBLICA,PARTICIPACIO,PLANEJAMENT_URBANISTIC,PREVENCIO,QUEIXES_I_RECLAMACIONS,REGIM_DE_BENS_I_PATRIMONI,REGIM_SANCIONADOR,RESPONSABILITAT_PATRIMONIAL,REVISIO_DE_L_ACTUACIO_ADMINISTRATIVA,SUBVENCIONS_I_AJUTS,TARGETES_CARNETS_I_IDENTIFICACIONS,ALTRES&actuacio=actuació";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 02 get consultar dades procediment.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage02_GetConsultarDadesProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 03 get consultar dades operacio tramit.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage03_GetConsultarDadesOperacioTramit() throws Exception {
		String url = BASE_URL + "/procediments/1/tramits/SOL/atributs";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 04 get consultar documentacio procediment.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage04_GetConsultarDocumentacioProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1/tramits/APO/documentacio";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 05 get cerca expedients.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage05_GetCercaExpedients() throws Exception {
		String url = BASE_URL
				+ "/expedients?resultatsPerPagina=20&numeroPagina=1&ordenarPer=DARRERA_MODIFICACIO&sentitOrdenacio=DESC&codiExpedient=PROC-01/2018&sollicitant=40954862G&dataPresentacioInici=22/06/2018&dataPresentacioFi=22/01/2019&codiProcediment=PROC-01,PROC-02,PROC-03&versioProcediment=TOTES_LES_VERSIONS&estat=ESBORRANY,EN_CURS,PENDENT_ESMENES,PENDENT_ALEGACIONS,RESOLT,TANCAT&unitatGestora=U&tramitador=APLICACIO_DE_NEGOCI&aplicacioNegoci=quiosc";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 06 get consultar dades expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage06_GetConsultarDadesExpedient() throws Exception {
		String url = BASE_URL + "/expedients/2019_EXP_00001";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Test stage 07 post crear solicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage07_PostCrearSolicitud() throws Exception {
		String url = BASE_URL + "/expedients";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"procediment\": { \"id\": 1 }, \"unitatGestora\": { \"codi\": \"CODI UG2\" }, \"sollicitant\": {\t\"tipusPersona\": \"FISICA\",\t\"nomRaoSocial\": \"Carmen\", \"cognom1\": \"Rodrigo\", \"cognom2\": \"Díaz\",\t\"sexe\": \"DONA\", \"dadesNotificacio\": { \"bloc\": \"4\", \"codiPostal\": \"13004\", \"email\": \"email@email.com\", \"escala\": \"9\", \"fax\": \"926354637\", \"mobil\": \"578239506\", \"municipi\": \"13034\", \"municipiEstranger\": \"M6\", \"nomVia\": \"Gran Vía\", \"numero\": \"15\", \"pais\": \"108\", \"pis\": \"2\", \"porta\": \"B\", \"provincia\": \"13\", \"provinciaEstranger\": \"P102\", \"telefon\": \"235466356\", \"tipusVia\": \"CARRER\" }, \"documentIdentitat\": { \"numeroDocument\": \"35278573T\", \"pais\": \"108\", \"tipusDocument\": \"NIF\" } }, \"representant\": {\t\"tipusPersona\": \"FISICA\",\t\"nomRaoSocial\": \"Ronald\", \"cognom1\": \"Pérez\", \"cognom2\": \"Sánchez\",\t\"sexe\": \"HOME\", \"dadesNotificacio\": { \"bloc\": \"4\", \"codiPostal\": \"13004\", \"email\": \"email@email.com\", \"escala\": \"9\", \"fax\": \"926354637\", \"mobil\": \"578239506\", \"municipi\": \"13034\", \"municipiEstranger\": \"M6\", \"nomVia\": \"Gran Vía\", \"numero\": \"15\", \"pais\": \"108\", \"pis\": \"2\", \"porta\": \"B\", \"provincia\": \"13\", \"provinciaEstranger\": \"P102\", \"telefon\": \"235466356\", \"tipusVia\": \"TRAVESSIA\" }, \"documentIdentitat\": { \"numeroDocument\": \"96442832Z\", \"pais\": \"108\", \"tipusDocument\": \"NIF\" } }}"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 08 post actualitzar solicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage08_PostActualitzarSolicitud() throws Exception {
		String url = BASE_URL + "/expedients/1";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"sollicitant\": {\t\"tipusPersona\": \"FISICA\",\t\"nomRaoSocial\": \"Carmen\", \"cognom1\": \"Rodrigo\", \"cognom2\": \"Díaz\",\t\"sexe\": \"DONA\", \"dadesNotificacio\": { \"bloc\": \"4\", \"codiPostal\": \"13004\", \"email\": \"email@email.com\", \"escala\": \"9\", \"fax\": \"926354637\", \"mobil\": \"578239506\", \"municipi\": \"13034\", \"municipiEstranger\": \"M6\", \"nomVia\": \"Gran Vía\", \"numero\": \"15\", \"pais\": \"108\", \"pis\": \"2\", \"porta\": \"B\", \"provincia\": \"13\", \"provinciaEstranger\": \"P102\", \"telefon\": \"235466356\", \"tipusVia\": \"CARRER\" }, \"documentIdentitat\": { \"numeroDocument\": \"35278573T\", \"pais\": \"108\", \"tipusDocument\": \"NIF\" } }, \"representant\": {\t\"tipusPersona\": \"FISICA\",\t\"nomRaoSocial\": \"Ronald\", \"cognom1\": \"Pérez\", \"cognom2\": \"Sánchez\",\t\"sexe\": \"HOME\", \"dadesNotificacio\": { \"bloc\": \"4\", \"codiPostal\": \"13004\", \"email\": \"email@email.com\", \"escala\": \"9\", \"fax\": \"926354637\", \"mobil\": \"578239506\", \"municipi\": \"13034\", \"municipiEstranger\": \"M6\", \"nomVia\": \"Gran Vía\", \"numero\": \"15\", \"pais\": \"108\", \"pis\": \"2\", \"porta\": \"B\", \"provincia\": \"13\", \"provinciaEstranger\": \"P102\", \"telefon\": \"235466356\", \"tipusVia\": \"TRAVESSIA\" }, \"documentIdentitat\": { \"numeroDocument\": \"96442832Z\", \"pais\": \"108\", \"tipusDocument\": \"NIF\" } }, \"dadesOperacio\": [\t{\t\t\"codi\": \"DO\",\t\t\"valor\": [\t\t\t\"1234\"\t\t]\t}]}"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 09 post registrar solicitud.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage09_PostRegistrarSolicitud() throws Exception {
		String url = BASE_URL + "/expedients/1/registre";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{ \"signaturaSolicitud\": \"1\" }"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 10 post aportar documentacio expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage10_PostAportarDocumentacioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"documentacio\": [ { \"configuracioDocumentacio\": \"42\",\t \"origen\": \"EXTERN\",\t \"comentari\": \"Document aportat des de portal de tramitació\",\t \"idioma\": \"CATALA\", \"fitxer\": {\t \"nom\": \"DNI.pdf\", \"format\": \"PDF\" } },\t{ \"configuracioDocumentacio\": \"43\",\t \"origen\": \"INTERN\",\t \"comentari\": \"Document aportat des de portal de tramitació\",\t \"idioma\": \"CASTELLA\", \"fitxer\": {\t \"nom\": \"DNI.pdf\", \"format\": \"PDF\" } } ], \"registrar\": true}"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 11 post substituir document expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage11_PostSubstituirDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/substituir";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"configuracioDocumentacio\": \"43\", \"origen\": \"EXTERN\", \"comentari\": \"Document substituït des de portal de tramitació\", \"idioma\": \"CASTELLA\", \"fitxer\": {\t\"nom\": \"DNI_H.pdf\",\t\"format\": \"PDF\" }}"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 12 delete esborrar document expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage12_DeleteEsborrarDocument() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1";
		getMockMvc().perform(delete(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 13 post esmenar expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage13_PostEsmenarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/esmena";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{ \"comentari\":\"S'adjunten els documents i les dades d'operació requerides.\", \"documentacio\": [ { \"configuracioDocumentacio\": \"42\",\t \"origen\": \"EXTERN\",\t \"comentari\": \"Document aportat des de portal de tramitació\",\t \"idioma\": \"CATALA\", \"fitxer\": {\t \"nom\": \"DNI.pdf\", \"format\": \"PDF\" } },\t{ \"configuracioDocumentacio\": \"43\",\t \"origen\": \"INTERN\",\t \"comentari\": \"Document aportat des de portal de tramitació\",\t \"idioma\": \"CASTELLA\", \"fitxer\": {\t \"nom\": \"DNI.pdf\", \"format\": \"PDF\" } } ], \"dadesOperacio\": [\t{\t\t\"codi\": \"DO\",\t\t\"valor\": [\t\t\t\"1234\"\t\t]\t}]}"))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 14 post abandonar expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage14_PostAbandonarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/desistir";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content("{}")).andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 15 post upload document expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage15_PostUploadDocumentExpedient() throws Exception {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "prova.txt", "text/plain", "prova".getBytes());
		String url = BASE_URL + "/expedients/1/documentacio/1/upload";
		getMockMvc().perform(MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());

	}

	/**
	 * Test stage 16 get descarregar document expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage16_GetDescarregarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documents/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());

	}

	// TODO Pendiente de ser modificado para que se pueda digitalizar desde Open
	// Text
	// @Test
	// public void testStage17_PostDigitalitzarDocumentacioExpedient() throws
	// Exception {
	// String url = BASE_URL + "/expedients/1/documentacio/digitalitzar";
	// getMockMvc()
	// .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
	// "{ \"documentacio\": [ { \"configuracioDocumentacio\": \"42\",\t
	// \"origen\": \"EXTERN\",\t \"comentari\": \"Document aportat des de portal
	// de tramitació\",\t \"idioma\": \"CATALA\", \"fitxer\": {\t \"nom\":
	// \"DNI.pdf\", \"format\": \"PDF\" } },\t{ \"configuracioDocumentacio\":
	// \"43\",\t \"origen\": \"INTERN\",\t \"comentari\": \"Document aportat des
	// de portal de tramitació\",\t \"idioma\": \"CASTELLA\", \"fitxer\": {\t
	// \"nom\": \"DNI.pdf\", \"format\": \"PDF\" } } ], \"registrar\": true}"))
	// .andExpect(status().isOk()).andDo(print());
	//
	// }

	/**
	 * Test stage 18 consultar dades document aportat.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage18_ConsultarDadesDocumentAportat() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/APORTADA/779041efafc68fc4761cb916b8287199d459af2a7505301139cf85854545be53";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());

	}

	/**
	 * Test stage 19 consultar dades document generat.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage19_ConsultarDadesDocumentGenerat() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/GENERADA/779041efafc68fc4761cb916b8287199d459af2a7505301139cf85854545be53";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());

	}

	/**
	 * Test stage 20 export xml expedient.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage20_GetExportarXML() throws Exception {
		String url = BASE_URL + "/expedients/1/report/exportacio-xml";
		getMockMvc().perform(get(url).accept(MediaType.TEXT_PLAIN_VALUE)).andDo(print()).andExpect(status().isOk());

	}

	/**
	 * Test stage 21 incorporar tercera persona
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStage21_PostCrearTerceraPersonaOK() throws Exception {
		String url = BASE_URL + "/expedients/1/persones";
		getMockMvc()
				.perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"persona\":{\"relacio\":null, \"relacioTerceraPersona\":\"Testimoni\", \"visibilitatOvt\":false, \"tipusPersona\":\"FISICA\", \"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIndentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}}}}"))
				.andExpect(status().isOk()).andDo(print());
	}

	/**
	 * Test stage 22 actualitzar tercera persona
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStage22_PutActualitzarTerceraPersonaOK() throws Exception {
		String url = BASE_URL + "/expedients/1/persones";
		getMockMvc()
				.perform(put(url).contentType(APPLICATION_JSON_UTF8).content(
						"{\"persona\":{\"relacio\":null, \"relacioTerceraPersona\":\"Testimoni\", \"visibilitatOvt\":false, \"tipusPersona\":\"FISICA\", \"nomRaoSocial\":\"El Àlvar\",\"cognom1\":\"Perau\",\"cognom2\":null,\"documentIndentitat\":{\"tipusDocument\":\"NIE\",\"numeroDocument\":\"00914091\",\"pais\":\"108\"},\"personesDadescontacte\":{}}}}"))
				.andExpect(status().isOk()).andDo(print());
	}

	/**
	 * Test stage 23 esborrar tercera persona
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStage23_EsborrarTerceraPersonaOK() throws Exception {
		String url = BASE_URL + "/expedients/1/persones/1";
		getMockMvc().perform(delete(url)).andExpect(status().isOk()).andDo(print());
	}
}