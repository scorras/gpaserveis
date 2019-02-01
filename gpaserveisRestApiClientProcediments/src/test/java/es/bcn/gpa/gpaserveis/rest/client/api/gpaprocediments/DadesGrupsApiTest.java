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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;

/**
 * API tests for DadesGrupsApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DadesGrupsApiTest extends ParentTest {

	@InjectMocks
	private DadesGrupsApi api = new DadesGrupsApi();

	/**
	 * Returns all the grups entries for the procedure
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getDadesGrupsUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/procediments/1/grups"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfDadesGrupsRDTO());

		BigDecimal id = ONE;
		String dir = null;
		String sort = null;
		PageDataOfDadesGrupsRDTO response = api.getDadesGrupsUsingGET(id, dir, sort);

		assertTrue(response != null);
	}

	/**
	 * Returns all the dades operacions entries for the procedure
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getDadesGrupsWithDadesOperacioUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/procediments/1/dadesGrupsWithDadesOperacio"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<DadesGrupsRDTO>());

		BigDecimal id = ONE;
		List<DadesGrupsRDTO> response = api.getDadesGrupsWithDadesOperacioUsingGET(id);

		assertTrue(response != null);
	}

}
