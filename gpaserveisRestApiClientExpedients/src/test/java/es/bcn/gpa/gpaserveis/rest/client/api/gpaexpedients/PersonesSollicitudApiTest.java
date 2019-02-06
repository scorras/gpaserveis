/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.3.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;

/**
 * API tests for PersonesSollicitudApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonesSollicitudApiTest extends ParentTest {

	@InjectMocks
	private PersonesSollicitudApi api = new PersonesSollicitudApi();

	/**
	 * Deletes the requested personesSollicitud list
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deleteAltresImplicadesListUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/personesSollicitud/altresImplidades/delete"), eq("POST"), any(List.class),
		        any(Object.class), any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class),
		        any(GenericType.class))).thenReturn(new PageDataOfPersonesSollicitudRDTO());

		List<PersonesSollicitudRDTO> personesSollicitudRDTOList = Arrays.asList(new PersonesSollicitudRDTO());
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
		PageDataOfPersonesSollicitudRDTO response = api.deleteAltresImplicadesListUsingPOST(personesSollicitudRDTOList,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Deletes the requested personesSollicitud list
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deletePersonesInteresadesListUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/personesSollicitud/interessades/delete"), eq("POST"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfPersonesSollicitudRDTO());

		List<PersonesSollicitudRDTO> personesSollicitudRDTOList = Arrays.asList(new PersonesSollicitudRDTO());
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
		PageDataOfPersonesSollicitudRDTO response = api.deletePersonesInteresadesListUsingPOST(personesSollicitudRDTOList,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Save the provided persone
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveAltresImplicadesUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/personesSollicitud/altresImplidades"), eq("POST"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfPersonesSollicitudRDTO());

		PersonesSollicitudRDTO personesSollicitudRDTO = new PersonesSollicitudRDTO();
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
		PageDataOfPersonesSollicitudRDTO response = api.saveAltresImplicadesUsingPOST(personesSollicitudRDTO,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Save the provided comment
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void savePersonesInteresadesUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/personesSollicitud/interessades"), eq("POST"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfPersonesSollicitudRDTO());

		PersonesSollicitudRDTO personesSollicitudRDTO = new PersonesSollicitudRDTO();
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
		PageDataOfPersonesSollicitudRDTO response = api.savePersonesInteresadesUsingPOST(personesSollicitudRDTO,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

}
