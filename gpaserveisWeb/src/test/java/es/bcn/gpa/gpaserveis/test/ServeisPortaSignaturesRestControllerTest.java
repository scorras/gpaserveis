package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ServeisPortaSignaturesRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisPortaSignaturesRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	/** The Constant BASE_URL. */
	private final static String BASE_URL = "/rest/serveis/portasignatures";

	@Test
	public void testStage01_PostResultatEstatPeticioCompletada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "resultat_peticio");
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"codiAplicacio\": \"1\", \"codiPeticio\": \"1\", \"codiEstat\": \"COMPLETADA\", \"raoRetorn\": \"1\", \"detallSignataris\": [ { \"codiUsuari\": \"1\", \"nifUsuari\": \"00000000T\",\t \"nomCompletUsuari\": \"Nom complet usuari\", \"tipusPeticio\": \"SIGNATURA\", \"tipusDocument\": \"NIF\", \"ordreIntervencio\": 1, \"esObligada\": true, \"dataCaducitat\": \"22/12/1980 06:04:22\", \"codiEstat\": \"COMPLETADA\", \"raoRetorn\": \"1\", \"ticketPeticio\": 1, \"carrec\": 1, \"tractament\": 1, \"instantSignatura\": \"27/08/2019 10:22:48\"} ]}"))
		        .andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testStage02_PostResultatEstatPeticioRetornada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "resultat_peticio");
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"codiAplicacio\": \"1\", \"codiPeticio\": \"1\", \"codiEstat\": \"RETORNADA\", \"raoRetorn\": \"1\", \"detallSignataris\": [ { \"codiUsuari\": \"1\", \"nifUsuari\": \"00000000T\",\t \"nomCompletUsuari\": \"Nom complet usuari\", \"tipusPeticio\": \"SIGNATURA\", \"tipusDocument\": \"NIF\", \"ordreIntervencio\": 1, \"esObligada\": true, \"dataCaducitat\": \"22/12/1980 06:04:22\", \"codiEstat\": \"RETORNADA\", \"raoRetorn\": \"1\", \"ticketPeticio\": 1, \"carrec\": 1, \"tractament\": 1, \"instantSignatura\": \"27/08/2019 10:22:48\"} ]}"))
		        .andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testStage03_PostResultatEstatPeticioCaducada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "resultat_peticio");
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"codiAplicacio\": \"1\", \"codiPeticio\": \"1\", \"codiEstat\": \"CADUCADA\", \"raoRetorn\": \"1\", \"detallSignataris\": [ { \"codiUsuari\": \"1\", \"nifUsuari\": \"00000000T\",\t \"nomCompletUsuari\": \"Nom complet usuari\", \"tipusPeticio\": \"SIGNATURA\", \"tipusDocument\": \"NIF\", \"ordreIntervencio\": 1, \"esObligada\": true, \"dataCaducitat\": \"22/12/1980 06:04:22\", \"codiEstat\": \"CADUCADA\", \"raoRetorn\": \"1\", \"ticketPeticio\": 1, \"carrec\": 1, \"tractament\": 1, \"instantSignatura\": \"27/08/2019 10:22:48\"} ]}"))
		        .andExpect(status().isOk()).andDo(print());

	}

}