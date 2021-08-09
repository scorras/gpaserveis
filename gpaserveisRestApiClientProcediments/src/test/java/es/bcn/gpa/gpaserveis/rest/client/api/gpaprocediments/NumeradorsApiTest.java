package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

@SuppressWarnings("unchecked")
public class NumeradorsApiTest extends ParentTest {

	@InjectMocks
	 NumeradorsApi api = new  NumeradorsApi();
	
	@Test
	public void getSequenceNextValExpUsingGETTest(){
		when(apiClient.invokeAPI(eq("/procediments/sequenceNextValExp/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(StringUtils.EMPTY);
		
		Integer idProcediment = 1;
		String response = api.getSequenceNextValExpUsingGET(idProcediment);
		assertTrue(response != null);
	}
}
