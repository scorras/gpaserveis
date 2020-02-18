package es.bcn.gpa.gpaserveis.test;

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
 * The Class ServeisNotificacionsRestControllerTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServeisNotificacionsRestControllerTest extends RestServerParentTest {

	/** The Constant APPLICATION_JSON_UTF8. */
	private static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";

	/** The Constant BASE_URL. */
	private final static String BASE_URL = "/rest/serveis/notificacions";

	@Test
	public void testStage01_PostRetornEstatNotificacioRegistrada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "retorn_notificacio");
		MockMultipartFile mockMultipartFile = new MockMultipartFile("evidencian", "prova.txt", "text/plain", "prova".getBytes());
		MockMultipartFile jsonFile = new MockMultipartFile("metadata", "", "application/json",
				"{ \"notificacioId\": 1, \"estat\": \"Registrada\", \"numRegistre\": \"1\", \"dataHoraRegistre\": \"25/08/2019 09:32:12\", \"dataEnviament\": \"25/08/2019 09:32:12\", \"dataAcusamentRebuda\": \"25/08/2019 09:32:12\"}"
						.getBytes());

		getMockMvc().perform(
				MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).file(jsonFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage02_PostRetornEstatNotificacioDipositada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "retorn_notificacio");
		MockMultipartFile mockMultipartFile = new MockMultipartFile("evidencian", "prova.txt", "text/plain", "prova".getBytes());
		MockMultipartFile jsonFile = new MockMultipartFile("metadata", "", "application/json",
				"{ \"notificacioId\": 1, \"estat\": \"Dipositada\", \"numRegistre\": \"1\", \"dataHoraRegistre\": \"25/08/2019 09:32:12\", \"dataHoraDiposit\": \"25/08/2019 09:32:12\", \"dataEnviament\": \"25/08/2019 09:32:12\", \"dataAcusamentRebuda\": \"25/08/2019 09:32:12\"}"
						.getBytes());

		getMockMvc().perform(
				MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).file(jsonFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testStage03_PostRetornEstatNotificacioVisualitzada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "retorn_notificacio");
		MockMultipartFile mockMultipartFile = new MockMultipartFile("evidencian", "prova.txt", "text/plain", "prova".getBytes());
		MockMultipartFile jsonFile = new MockMultipartFile("metadata", "", "application/json",
				"{ \"notificacioId\": 1, \"estat\": \"Visualitzada\", \"numRegistre\": \"1\", \"dataHoraRegistre\": \"25/08/2019 09:32:12\", \"dataHoraDiposit\": \"25/08/2019 09:32:12\", \"dataHoraVisualitzacio\": \"25/08/2019 09:32:12\", \"dataEnviament\": \"25/08/2019 09:32:12\", \"dataAcusamentRebuda\": \"25/08/2019 09:32:12\"}"
						.getBytes());

		getMockMvc().perform(
				MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).file(jsonFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void testStage04_PostRetornEstatNotificacioRebutjada() throws Exception {
		String url = String.format("%s/%s", BASE_URL, "retorn_notificacio");
		MockMultipartFile mockMultipartFile = new MockMultipartFile("evidencian", "prova.txt", "text/plain", "prova".getBytes());
		MockMultipartFile jsonFile = new MockMultipartFile("metadata", "", "application/json",
				"{ \"notificacioId\": 1, \"estat\": \"Rebutjada\", \"numRegistre\": \"1\", \"dataHoraRegistre\": \"25/08/2019 09:32:12\", \"dataHoraDiposit\": \"25/08/2019 09:32:12\", \"dataHoraVisualitzacio\": \"25/08/2019 09:32:12\", \"dataHoraAceptacioRebuig\": \"25/08/2019 09:32:12\", \"dataEnviament\": \"25/08/2019 09:32:12\", \"dataAcusamentRebuda\": \"25/08/2019 09:32:12\"}"
						.getBytes());

		getMockMvc().perform(
				MockMvcRequestBuilders.fileUpload(url).file(mockMultipartFile).file(jsonFile).contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk()).andDo(print());
	}

}