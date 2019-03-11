package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
		String url = BASE_URL
		        + "/procediments?resultatsPerPagina=20&numeroPagina=1&ordenarPer=CODI&sentitOrdenacio=ASC&codi=PROC-01&estat=EN_ELABORACIO,FINALITZAT,PUBLICAT&nom=Procediment1&tramitador=APLICACIO_DE_NEGOCI&aplicacioNegoci=quiosc&ugr=UG1&exclusivamentIntern=SI&activableFormatElectronic=PORTAL_TRAMITS,ALTRA_WEB,MOBIL,QUIOSC,PER_CANAL_GENERALISTA,PER_CANAL_ESPECIFIC&organResolutori=ple&competenciaAssociada=ACCIO_SOCIAL,AFERS_JURIDICS,BENS_I_PATRIMONI,COMERC_I_CONSUM,CULTURA,EDUCACIO,ESPORTS_I_LLEURE,HABITATGE,MEDI_AMBIENT,MOVILITAT_TRANSPORT_I_CIRCULACIO,OBRES_I_INFRAESTRUCTURES,ORGANITZACIO_I_COORDINACIO_ADMINISTRATIVA,ORGANS_DE_GOVERN,POBLACIO_I_DEMARCACIO,POTESTATS_DE_PLANIFICACIO_I_NORMATIVA,PRESSUPOSTOS_I_FINANCES,PROMOCIO_ECONOMICA,RECURSOS_HUMANS&familia=ATENCIO_SOCIAL_I_RESIDENCIAL,AUTORITZACIONS_I_COMUNICATS,CERTAMENS_I_PREMIS,COL_LABORACIO,CONSULTES_I_SUGGERIMENTS,CONTRACTACIO_PUBLICA,DISCIPLINA_INSPECCIO_I_PROTECCIO_DE_LA_LEGALITAT,DRETS_D_ACCES_A_LA_INFORMACIO,DRETS_I_ACTIVITAT_CIVIL,ENS_DEPENDENTS_I_PARTICIPATS,EXECUCIO_URBANISTICA,GESTIO_DEL_PERSONAL,GESTIO_PRESSUPOSTARIA_I_FINANCERA,GESTIO_TRIBUTARIA,INFORMES_I_CERTIFICATS,INSCRIPCIONS_REGISTRALS,MEDIACIO_I_ARBITRATGE,NORMATIVA,OCUPACIO_I_SERVEIS_A_LA_VIA_PUBLICA,PARTICIPACIO,PLANEJAMENT_URBANISTIC,PREVENCIO,QUEIXES_I_RECLAMACIONS,REGIM_DE_BENS_I_PATRIMONI,REGIM_SANCIONADOR,RESPONSABILITAT_PATRIMONIAL,REVISIO_DE_L_ACTUACIO_ADMINISTRATIVA,SUBVENCIONS_I_AJUTS,TARGETES_CARNETS_I_IDENTIFICACIONS,ALTRES&actuacio=actuació";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage02_GetConsultarDadesProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage03_GetConsultarDadesOperacioTramit() throws Exception {
		String url = BASE_URL + "/procediments/1/tramits/SOL/atributs";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage04_GetConsultarDocumentacioProcediment() throws Exception {
		String url = BASE_URL + "/procediments/1/tramits/APO/documentacio";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage05_GetCercaExpedients() throws Exception {
		String url = BASE_URL
		        + "/expedients?resultatsPerPagina=20&numeroPagina=1&ordenarPer=DARRERA_MODIFICACIO&sentitOrdenacio=DESC&codiExpedient=PROC-01/2018&sollicitant=40954862G&dataPresentacioInici=22/06/2018&dataPresentacioFi=22/01/2019&codiProcediment=PROC-01,PROC-02,PROC-03&versioProcediment=TOTES_LES_VERSIONS&estat=REBUT,EN_CURS,PENDENT_ESMENES,PENDENT_ALEGACIONS,RESOLT,TANCAT&unitatGestora=U&tramitador=APLICACIO_DE_NEGOCI&aplicacioNegoci=quiosc";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage06_GetConsultarDadesExpedient() throws Exception {
		String url = BASE_URL + "/expedients/Codi%20%2F2018%2F000001";
		getMockMvc().perform(get(url)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testStage07_PostCrearSolicitud() throws Exception {
		String url = BASE_URL + "/expedients";
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"procediment\": { \"id\": 1 }, \"unitatGestora\": { \"codi\": \"CODI UG2\" }, \"sollicitant\": {\t\"tipusPersona\": \"FISICA\",\t\"nomRaoSocial\": \"Carmen\", \"cognom1\": \"Rodrigo\", \"cognom2\": \"Díaz\",\t\"sexe\": \"FEMENI\", \"dadesContacte\": { \"bloc\": \"4\", \"codiPostal\": \"13004\", \"comarca\": \"13\", \"email\": \"email@email.com\", \"escala\": \"9\", \"fax\": \"926354637\", \"mobil\": \"578239506\", \"municipi\": \"13034\", \"municipiEstranger\": \"M6\", \"nomVia\": \"Gran Vía\", \"numero\": \"15\", \"pais\": \"108\", \"pis\": \"2\", \"porta\": \"B\", \"provincia\": \"13\", \"provinciaEstranger\": \"P102\", \"telefon\": \"235466356\", \"tipusVia\": \"CARRER\" }, \"documentIndentitat\": { \"numeroDocument\": \"35278573T\", \"pais\": \"ES\", \"tipusDocument\": \"NIF\" } }, \"representant\": {\t\"tipusPersona\": \"FISICA\",\t\"nomRaoSocial\": \"Ronald\", \"cognom1\": \"Pérez\", \"cognom2\": \"Sánchez\",\t\"sexe\": \"FEMENI\", \"dadesContacte\": { \"bloc\": \"4\", \"codiPostal\": \"13004\", \"comarca\": \"13\", \"email\": \"email@email.com\", \"escala\": \"9\", \"fax\": \"926354637\", \"mobil\": \"578239506\", \"municipi\": \"13034\", \"municipiEstranger\": \"M6\", \"nomVia\": \"Gran Vía\", \"numero\": \"15\", \"pais\": \"108\", \"pis\": \"2\", \"porta\": \"B\", \"provincia\": \"13\", \"provinciaEstranger\": \"P102\", \"telefon\": \"235466356\", \"tipusVia\": \"TRAVESSIA\" }, \"documentIndentitat\": { \"numeroDocument\": \"96442832Z\", \"pais\": \"ES\", \"tipusDocument\": \"NIF\" } }}"))
		        .andExpect(status().isOk()).andDo(print());

	}

	@Test
	@Ignore
	public void testStage08_PutActualitzarSolicitud() throws Exception {
		String url = BASE_URL + "/expedients/1";
		getMockMvc()
		        .perform(put(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"atributs\": [ null ], \"codi\": \"string\", \"codiProcediment\": \"string\", \"codiUnitatGestora\": \"string\", \"documents\": [ { \"codi\": \"string\", \"id\": \"string\", \"nom\": \"string\" } ], \"id\": 0, \"inici\": \"OFICI\", \"representant\": { \"cognom1\": \"string\", \"cognom2\": \"string\", \"dadesContacte\": { \"bloc\": \"string\", \"codiPostal\": \"string\", \"comarca\": \"string\", \"email\": \"string\", \"escala\": \"string\", \"fax\": \"string\", \"mobil\": \"string\", \"municipi\": \"string\", \"municipiEstranger\": \"string\", \"nomVia\": \"string\", \"numero\": \"string\", \"pais\": \"string\", \"pis\": \"string\", \"porta\": \"string\", \"provincia\": \"string\", \"provinciaEstranger\": \"string\", \"telefon\": \"string\", \"tipusVia\": \"string\" }, \"documentIndentitat\": { \"numeroDocument\": \"string\", \"pais\": \"string\", \"tipusDocument\": \"NIF\" }, \"id\": 0, \"nomRaoSocial\": \"string\", \"tipusPersona\": \"FISICA\" }, \"solicitant\": { \"cognom1\": \"string\", \"cognom2\": \"string\", \"dadesContacte\": { \"bloc\": \"string\", \"codiPostal\": \"string\", \"comarca\": \"string\", \"email\": \"string\", \"escala\": \"string\", \"fax\": \"string\", \"mobil\": \"string\", \"municipi\": \"string\", \"municipiEstranger\": \"string\", \"nomVia\": \"string\", \"numero\": \"string\", \"pais\": \"string\", \"pis\": \"string\", \"porta\": \"string\", \"provincia\": \"string\", \"provinciaEstranger\": \"string\", \"telefon\": \"string\", \"tipusVia\": \"string\" }, \"documentIndentitat\": { \"numeroDocument\": \"string\", \"pais\": \"string\", \"tipusDocument\": \"NIF\" }, \"id\": 0, \"nomRaoSocial\": \"string\", \"tipusPersona\": \"FISICA\" }, \"valor\": \"string\", \"versioProcediment\": \"string\"}"))
		        .andExpect(status().isOk()).andDo(print());

	}

	@Test
	@Ignore
	public void testStage09_PostRegistrarSolicitud() throws Exception {
		String url = BASE_URL + "/expedients/1/registre";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage10_PostAportarDocumentacioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
				"[]"))
		.andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage11_PostSubstituirDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1/versionar";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
				"{}"))
		.andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage12_DeleteEsborrarDocumentExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/documentacio/1";
		getMockMvc().perform(delete(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage13_PostEsmenarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/esmena";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
				"{}"))
		.andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage14_PostAbandonarExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/desistir";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
				"{}"))
		.andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage15_PostAccesExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/acces";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testStage15_PostRegistrarComunicacioExpedient() throws Exception {
		String url = BASE_URL + "/expedients/1/comunicat";
		getMockMvc().perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
				"{}"))
		.andExpect(status().isOk()).andDo(print());

	}	
	
}