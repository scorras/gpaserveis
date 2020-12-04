package es.bcn.gpa.gpaserveis.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;

import es.bcn.gpa.gpaserveis.test.parent.RestServerParentTest;

/**
 * The Class ServeisPortaSignaturesRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisSignaturesRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	/** The Constant BASE_URL. */
	private final static String BASE_URL = "/rest/serveis/signatures";

	/**
	 * Test stage 01 post signar document online criptografica.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage01_PostSignarDocumentOnlineCriptografica() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "listenerMciSignatura");
		getMockMvc()
		        .perform(post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		                .content(buildUrlEncodedFormEntity("formSignResume", "formSignRedirect", "ticket",
		                        "PGVzLmJjbi5tY2kuc2lnbmF0dXJhLndlYlNlcnZpY2Uuc2NoZW1hcy5UaWNrZXQ+CiAgPGlkUGV0aWNpbz4xNjAzNjczNzg0MDgxMjwvaWRQZXRpY2lvPgogIDxtaXNzYXRnZUVycm9yPgogICAgPGNvZGlFcnJvcj4xMDAwNzwvY29kaUVycm9yPgogICAgPGRlc2NyaXBjaW9FcnJvcj5FbCBkb2N1bWVudCBqYSBoYSBlc3RhdCBzaWduYXQgcGVyIGxhIG1hdGVpeGEgcGVyc29uYSBhbnRlcmlvcm1lbnQ8L2Rlc2NyaXBjaW9FcnJvcj4KICA8L21pc3NhdGdlRXJyb3I+CiAgPGVycm9ycz4KICAgIDxlcy5iY24ubWNpLnNpZ25hdHVyYS53ZWJTZXJ2aWNlLnNjaGVtYXMuRGV0YWxsRXJyb3JzPgogICAgICA8aWREb2N1bWVudD4wOTA3YTEzNDgwMmE0MGM1PC9pZERvY3VtZW50PgogICAgICA8c2lnbmF0dXJhUmVzdWx0YXQ+CiAgICAgICAgPGlkU2lnbmF0dXJhPlBlbmRlbnQgZGVsIEdlc3RvciBEb2N1bWVudGFsPC9pZFNpZ25hdHVyYT4KICAgICAgICA8cmVmRG9jdW1lbnRTaWduYXQ+MDkwN2ExMzQ4MDJhNDBjNTwvcmVmRG9jdW1lbnRTaWduYXQ+CiAgICAgICAgPGVzdGF0U2lnbmF0dXJhPgogICAgICAgICAgPGNvZGk+VkFMSU48L2NvZGk+CiAgICAgICAgICA8ZGVzY3JpcGNpbz5WYWxpZGFkYSBpbmljaWFsbWVudDwvZGVzY3JpcGNpbz4KICAgICAgICA8L2VzdGF0U2lnbmF0dXJhPgogICAgICAgIDxtZXRhZGFkZXM+CiAgICAgICAgICA8Y29kaT4xNjAzNjczNzg0MDgxMjwvY29kaT4KICAgICAgICAgIDxub20+SEVSTkFOIFBFUkVaIERFIElORVNUUk9TQSBTQU5DSEVaPC9ub20+CiAgICAgICAgICA8bmlmPjA1Njg2NzIzTDwvbmlmPgogICAgICAgICAgPGVudGl0YXRDZXJ0aWZpY2Fkb3JhPkNlcmVzPC9lbnRpdGF0Q2VydGlmaWNhZG9yYT4KICAgICAgICAgIDx0aXB1c1NpZ25hdHVyYT5ncGFfc2lnX2NlcnRpZmljYV8wMDE8L3RpcHVzU2lnbmF0dXJhPgogICAgICAgICAgPHNpZ25UaW1lPgogICAgICAgICAgICA8dGltZT4xNjAzNjczNTU4MzYwPC90aW1lPgogICAgICAgICAgICA8dGltZXpvbmU+RXVyb3BlL01hZHJpZDwvdGltZXpvbmU+CiAgICAgICAgICA8L3NpZ25UaW1lPgogICAgICAgICAgPHZpc3RpcGxhdT5mYWxzZTwvdmlzdGlwbGF1PgogICAgICAgIDwvbWV0YWRhZGVzPgogICAgICA8L3NpZ25hdHVyYVJlc3VsdGF0PgogICAgPC9lcy5iY24ubWNpLnNpZ25hdHVyYS53ZWJTZXJ2aWNlLnNjaGVtYXMuRGV0YWxsRXJyb3JzPgogICAgPGVzLmJjbi5tY2kuc2lnbmF0dXJhLndlYlNlcnZpY2Uuc2NoZW1hcy5EZXRhbGxFcnJvcnM+CiAgICAgIDxpZERvY3VtZW50PjA5MDdhMTM0ODAyYTQwMTY8L2lkRG9jdW1lbnQ+CiAgICAgIDxkZXRhbGxFcnJvcj4KICAgICAgICA8Y29kaUVycm9yPjEwMDA3PC9jb2RpRXJyb3I+CiAgICAgICAgPGRlc2NyaXBjaW9FcnJvcj5FbCBkb2N1bWVudCBqYSBoYSBlc3RhdCBzaWduYXQgcGVyIGxhIG1hdGVpeGEgcGVyc29uYSBhbnRlcmlvcm1lbnQ8L2Rlc2NyaXBjaW9FcnJvcj4KICAgICAgICA8c2lnbmF0dXJhT3JpZ2luYWw+CiAgICAgICAgICA8aWRTaWduYXR1cmE+MDkwN2ExMzQ4MDJhNDBiYzwvaWRTaWduYXR1cmE+CiAgICAgICAgICA8cmVmRG9jdW1lbnRTaWduYXQ+MDkwN2ExMzQ4MDJhNDAxNjwvcmVmRG9jdW1lbnRTaWduYXQ+CiAgICAgICAgICA8ZXN0YXRTaWduYXR1cmE+CiAgICAgICAgICAgIDxjb2RpPlZBTElOPC9jb2RpPgogICAgICAgICAgICA8ZGVzY3JpcGNpbz5WYWxpZGFkYSBpbmljaWFsbWVudDwvZGVzY3JpcGNpbz4KICAgICAgICAgIDwvZXN0YXRTaWduYXR1cmE+CiAgICAgICAgICA8bWV0YWRhZGVzPgogICAgICAgICAgICA8Y29kaT4xNjAzNjcyNDQ2ODE2NDwvY29kaT4KICAgICAgICAgICAgPG5vbT5IRVJOQU4gUEVSRVogREUgSU5FU1RST1NBIFNBTkNIRVo8L25vbT4KICAgICAgICAgICAgPG5pZj4wNTY4NjcyM0w8L25pZj4KICAgICAgICAgICAgPGVudGl0YXRDZXJ0aWZpY2Fkb3JhPkNlcmVzPC9lbnRpdGF0Q2VydGlmaWNhZG9yYT4KICAgICAgICAgICAgPHRpcHVzU2lnbmF0dXJhPmdwYV9zaWdfY2VydGlmaWNhXzAwMTwvdGlwdXNTaWduYXR1cmE+CiAgICAgICAgICAgIDxzaWduVGltZT4KICAgICAgICAgICAgICA8dGltZT4xNjAzNjcyMjU1MzI4PC90aW1lPgogICAgICAgICAgICAgIDx0aW1lem9uZT5FdXJvcGUvTWFkcmlkPC90aW1lem9uZT4KICAgICAgICAgICAgPC9zaWduVGltZT4KICAgICAgICAgICAgPHZpc3RpcGxhdT5mYWxzZTwvdmlzdGlwbGF1PgogICAgICAgICAgPC9tZXRhZGFkZXM+CiAgICAgICAgPC9zaWduYXR1cmFPcmlnaW5hbD4KICAgICAgICA8aWRQZXRpY2lvT3JpZ2luYWw+MTYwMzY3MjQ0NjgxNjQ8L2lkUGV0aWNpb09yaWdpbmFsPgogICAgICA8L2RldGFsbEVycm9yPgogICAgPC9lcy5iY24ubWNpLnNpZ25hdHVyYS53ZWJTZXJ2aWNlLnNjaGVtYXMuRGV0YWxsRXJyb3JzPgogIDwvZXJyb3JzPgo8L2VzLmJjbi5tY2kuc2lnbmF0dXJhLndlYlNlcnZpY2Uuc2NoZW1hcy5UaWNrZXQ+")))
		        .andExpect(status().isFound()).andDo(print());
	}

	/**
	 * Test stage 02 post signar document online criptografica.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testStage02_PostSignarDocumentOnlineCriptografica() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "resultatPeticio");
		getMockMvc()
		        .perform(post(url).contentType(APPLICATION_JSON_UTF8).content(
		                "{ \"idPeticio\": 16036737840812, \"urlSignaturaBrowser\": \"http://romsubip.ls/oto\", \"missatgeError\": { \"codiError\": 10007, \"descripcioError\": \"El document ja ha estat signat per la mateixa persona anteriorment\" }, \"errors\": [ { \"idDocument\": \"0907a134802a40c5\", \"signaturaResultat\": { \"idSignatura\": \"Pendent del Gestor Documental\", \"refDocumentSignat\": \"0907a134802a40c5\", \"estatSignatura\": { \"codi\": \"VALIN\", \"descripcio\": \"Validada inicialment\" }, \"metadades\": { \"codi\": 16036737840812, \"nom\": \"HERNAN PEREZ DE INESTROSA SANCHEZ\", \"nif\": \"05686723L\", \"entitatCertificadora\": \"Ceres\", \"tipusSignatura\": \"gpa_sig_certifica_001\", \"signTime\": \"1603673558360\", \"vistiplau\": \"false\" } } }, { \"idDocument\": \"0907a134802a4016\", \"detallError\": { \"codiError\": 10007, \"descripcioError\": \"El document ja ha estat signat per la mateixa persona anteriorment\", \"signaturaOriginal\": { \"idSignatura\": \"0907a134802a40bc\", \"refDocumentSignat\": \"0907a134802a4016\", \"estatSignatura\": { \"codi\": \"VALIN\", \"descripcio\": \"Validada inicialment\" }, \"metadades\": { \"codi\": 16036724468164, \"nom\": \"HERNAN PEREZ DE INESTROSA SANCHEZ\", \"nif\": \"05686723L\", \"entitatCertificadora\": \"Ceres\", \"tipusSignatura\": \"gpa_sig_certifica_001\", \"signTime\": \"1603672255328\", \"vistiplau\": \"false\" } }, \"idPeticioOriginal\": 16036724468164 } } ] }"))
		        .andExpect(status().isOk()).andDo(print());
	}

	/**
	 * Builds the url encoded form entity.
	 *
	 * @param params
	 *            the params
	 * @return the string
	 */
	private String buildUrlEncodedFormEntity(String... params) {
		if ((params.length % 2) > 0) {
			throw new IllegalArgumentException("Need to give an even number of parameters");
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < params.length; i += 2) {
			if (i > 0) {
				result.append('&');
			}
			try {
				result.append(URLEncoder.encode(params[i], StandardCharsets.UTF_8.name())).append('=')
				        .append(URLEncoder.encode(params[i + 1], StandardCharsets.UTF_8.name()));
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		return result.toString();
	}

}