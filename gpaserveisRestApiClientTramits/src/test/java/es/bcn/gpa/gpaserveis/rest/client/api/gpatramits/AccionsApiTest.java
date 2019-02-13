/*
 * API gpatramits
 * API gpatramits
 *
 * OpenAPI spec version: 1.3.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import static java.math.BigDecimal.ONE;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfAccionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;

/**
 * API tests for AccionsApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccionsApiTest extends ParentTest {

	@InjectMocks
	private AccionsApi api = new AccionsApi();

	/**
	 * Returns the requested accions
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getAccionsUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/accions/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new AccionsRDTO());

		BigDecimal id = ONE;
		AccionsRDTO response = api.getAccionsUsingGET(id);

		assertTrue(response != null);
	}

	/**
	 * Returns all the accions
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getAllAccionsUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/accions"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new PageDataOfAccionsRDTO());

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
		PageDataOfAccionsRDTO response = api.getAllAccionsUsingGET(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns all the accions that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchAccionsUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/accions/search"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new PageDataOfAccionsRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		String activador = null;
		String codi = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		String dir = null;
		BigDecimal id = null;
		Integer nextPageNumber = null;
		String nom = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String receptor = null;
		String resum = null;
		String rolUsuari = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		Integer visible = null;
		PageDataOfAccionsRDTO response = api.searchAccionsUsingGET(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, activador, codi, currentPageHasNextPage, currentPageHasPreviousPage,
		        currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, id, nextPageNumber, nom, pageSize,
		        previousPageNumber, receptor, resum, rolUsuari, sort, totalElements, totalPages, visible);

		assertTrue(response != null);
	}

}