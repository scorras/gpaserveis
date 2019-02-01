/*
 * API gpaprocediments
 * API gpaprocediments
 *
 * OpenAPI spec version: 1.3.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import static java.math.BigDecimal.ONE;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;

/**
 * API tests for DadesOperacioApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DadesOperacioApiTest extends ParentTest {

	@InjectMocks
	private DadesOperacioApi api = new DadesOperacioApi();

	/**
	 * Deletes the requested dades operacio list
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deleteDadesOperacioUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/procediments/dadesOperacions/delete"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), isNull(GenericType.class))).thenReturn(null);

		List<BigDecimal> idList = Arrays.asList(ONE);
		api.deleteDadesOperacioUsingPOST(idList);

		assertTrue(true);
	}

	/**
	 * Inserts the provided dadesOperacio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveDadesOperacioUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/procediments/saveDadesOperacio"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfDadesOperacionsRDTO());

		DadesOperacionsRDTO dadesOperacionsRDTO = new DadesOperacionsRDTO();
		String dir = null;
		String sort = null;
		PageDataOfDadesOperacionsRDTO response = api.saveDadesOperacioUsingPOST(dadesOperacionsRDTO, dir, sort);

		assertTrue(response != null);
	}

}
