/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.3.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.FaseProcedimentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;

/**
 * API tests for FaseProcedimentApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FaseProcedimentApiTest extends ParentTest {

	@InjectMocks
	private FaseProcedimentApi api = new FaseProcedimentApi();

	/**
	 * Returns all the fase procediments
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getFaseProcedimentUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/catalog/faseProcediment"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<FaseProcedimentRDTO>());

		List<FaseProcedimentRDTO> response = api.getFaseProcedimentUsingGET();

		assertTrue(response != null);
	}

}
