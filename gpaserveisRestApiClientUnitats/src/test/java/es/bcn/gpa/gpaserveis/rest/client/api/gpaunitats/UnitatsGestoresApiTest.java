/*
 * API gpaunitats
 * API gpaunitats
 *
 * OpenAPI spec version: 1.3.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats;

import static java.math.BigDecimal.ONE;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.joda.time.DateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException;

/**
 * API tests for UnitatsGestoresApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitatsGestoresApiTest extends ParentTest {

	@InjectMocks
	private UnitatsGestoresApi api = new UnitatsGestoresApi();

	/**
	 * Deletes the requested unitats list
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void bulkDeleteUnitatListUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/unitats/delete"), eq("POST"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), isNull(GenericType.class))).thenReturn(null);

		List<BigDecimal> unitatIdList = Arrays.asList(ONE);
		api.bulkDeleteUnitatListUsingPOST(unitatIdList);

		assertTrue(true);
	}

	/**
	 * Returns all the unitats that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaUnitatsGestoresTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/unitats/search"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfUnitatsGestoresRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		DateTime dataCreacio = null;
		DateTime dataModificacio = null;
		String descUnitatOrganigrama = null;
		String descripcio = null;
		String dir = null;
		BigDecimal id = null;
		Integer nextPageNumber = null;
		String nom = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		BigDecimal unitatOrganigrama = null;
		Integer vigent = null;
		PageDataOfUnitatsGestoresRDTO response = api.cercaUnitatsGestores(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dataCreacio, dataModificacio, descUnitatOrganigrama, descripcio, dir, id,
		        nextPageNumber, nom, pageSize, previousPageNumber, sort, totalElements, totalPages, unitatOrganigrama, vigent);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested unitat
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void consultarDadesUnitatGestoraTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/unitats/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new UnitatsGestoresRDTO());

		BigDecimal id = ONE;
		UnitatsGestoresRDTO response = api.consultarDadesUnitatGestora(id);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested unitat
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getAllUnitatsGestoresUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/unitats/all"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<UnitatsGestoresRDTO>());

		List<UnitatsGestoresRDTO> response = api.getAllUnitatsGestoresUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Returns all the unitats gestores
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getUnitatsGestoresUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/unitats"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfUnitatsGestoresRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		String dir = null;
		Integer nextPageNumber = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		PageDataOfUnitatsGestoresRDTO response = api.getUnitatsGestoresUsingGET(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Insert or updates the provided unitat
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveOrUpdateUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/unitats"), eq("POST"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new UnitatsGestoresRDTO());

		UnitatsGestoresRDTO unitatsGestoresRDTO = new UnitatsGestoresRDTO();
		UnitatsGestoresRDTO response = api.saveOrUpdateUsingPOST(unitatsGestoresRDTO);

		assertTrue(response != null);
	}

	/**
	 * Selects the requested unitats list
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void selectUnitatListUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/unitats/list"), eq("POST"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<UnitatsGestoresRDTO>());

		List<BigDecimal> unitatIdList = Arrays.asList(ONE);
		List<UnitatsGestoresRDTO> response = api.selectUnitatListUsingPOST(unitatIdList);

		assertTrue(response != null);
	}
}
