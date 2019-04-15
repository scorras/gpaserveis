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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.BloquejosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientOpenTextRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfComentarisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;

/**
 * API tests for ExpedientsApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExpedientsApiTest extends ParentTest {

	@InjectMocks
	private ExpedientsApi api = new ExpedientsApi();

	/**
	 * Locks the provided procediment for editing
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void bloquejarExpedientUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/bloquejar/1"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(null);

		BloquejosRDTO bloquejosRDTO = new BloquejosRDTO();
		BigDecimal id = ONE;
		api.bloquejarExpedientUsingPOST(bloquejosRDTO, id);

		assertTrue(true);
	}

	/**
	 * Returns all the historic entries for the procedure that meet the search
	 * criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaHistoricsExpedientTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/historic/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfHistoricsRDTO());

		BigDecimal id = ONE;
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
		List<BigDecimal> tipus = null;
		Long totalElements = null;
		Integer totalPages = null;
		PageDataOfHistoricsRDTO response = api.cercaHistoricsExpedient(id, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, tipus, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Unlocks the provided procediment
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void desbloquejarExpedientUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/desbloquejar/1"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(null);

		BigDecimal id = ONE;
		api.desbloquejarExpedientUsingPOST(id);

		assertTrue(true);
	}

	/**
	 * Returns all the historic entries for the id list
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getHistoricsListUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/historic/list/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<HistoricsRDTO>());

		String ids = ONE.toString();
		List<HistoricsRDTO> response = api.getHistoricsListUsingGET(ids);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested registre
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getRegistresAssentamentListUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/registre/list/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<RegistreAssentamentRDTO>());

		String ids = ONE.toString();
		List<RegistreAssentamentRDTO> response = api.getRegistresAssentamentListUsingGET(ids);

		assertTrue(response != null);
	}

	/**
	 * Inserts new historic
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void registrarHistoricDocumentacioUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/historic/insert"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(ONE);

		HistoricsRDTO historicsRDTO = new HistoricsRDTO();
		BigDecimal response = api.registrarHistoricDocumentacioUsingPOST(historicsRDTO);

		assertTrue(response != null);
	}

	/**
	 * Returns all the comentaris entries for the procedure that meet the search
	 * criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchComentarisUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/comentaris/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfComentarisRDTO());

		BigDecimal id = ONE;
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
		PageDataOfComentarisRDTO response = api.searchComentarisUsingGET(id, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * ExpedientBloquejatPerUnAltreUsuari
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void expedientBloquejatPerUnAltreUsuariUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/expedientBloquejatPerUnAltreUsuari/1"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new BloquejosRDTO());

		BigDecimal id = ONE;
		BloquejosRDTO response = api.expedientBloquejatPerUnAltreUsuariUsingGET(id);

		assertTrue(response != null);
	}

	/**
	 * Return expedient data for OpenText
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getExpedientDataOpenTextUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/expedientDataOpenText/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ExpedientOpenTextRDTO());

		BigDecimal id = ONE;
		ExpedientOpenTextRDTO response = api.getExpedientDataOpenTextUsingGET(id);

		assertTrue(response != null);
	}

}
