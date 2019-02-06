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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;

/**
 * API tests for TramitsApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TramitsApiTest extends ParentTest {

	@InjectMocks
	private TramitsApi api = new TramitsApi();

	/**
	 * Returns all the tramits that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaTramitsTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/tramits/search"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new PageDataOfTramitsRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		DateTime darreraModificacio = null;
		DateTime dataGestioElectronica = null;
		String descripcio = null;
		String dir = null;
		Integer esTramitIniciacio = null;
		Integer exclusiuIntern = null;
		String gestioElectronica = null;
		BigDecimal id = null;
		String informacioTramitador = null;
		Integer nextPageNumber = null;
		String nom = null;
		String normaAltresAplicacio = null;
		String normaReferenciaPrincipal = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String rolUsuari = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		BigDecimal ultimaModificacio = null;
		PageDataOfTramitsRDTO response = api.cercaTramits(absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage,
		        currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber,
		        darreraModificacio, dataGestioElectronica, descripcio, dir, esTramitIniciacio, exclusiuIntern, gestioElectronica, id,
		        informacioTramitador, nextPageNumber, nom, normaAltresAplicacio, normaReferenciaPrincipal, pageSize, previousPageNumber,
		        rolUsuari, sort, totalElements, totalPages, ultimaModificacio);

		assertTrue(response != null);
	}

	/**
	 * Returns all the tramits that meet the search criteria and are associated
	 * with a procediment
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaTramitsProcedimentTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/tramits/searchAssociated/procediment/1"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfTramitsRDTO());

		BigDecimal idProcediment = ONE;
		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		DateTime darreraModificacio = null;
		DateTime dataGestioElectronica = null;
		String descripcio = null;
		String dir = null;
		Integer esTramitIniciacio = null;
		Integer exclusiuIntern = null;
		String gestioElectronica = null;
		BigDecimal id = null;
		String informacioTramitador = null;
		Integer nextPageNumber = null;
		String nom = null;
		String normaAltresAplicacio = null;
		String normaReferenciaPrincipal = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String rolUsuari = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		BigDecimal ultimaModificacio = null;
		PageDataOfTramitsRDTO response = api.cercaTramitsProcediment(idProcediment, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, darreraModificacio, dataGestioElectronica, descripcio, dir, esTramitIniciacio,
		        exclusiuIntern, gestioElectronica, id, informacioTramitador, nextPageNumber, nom, normaAltresAplicacio,
		        normaReferenciaPrincipal, pageSize, previousPageNumber, rolUsuari, sort, totalElements, totalPages, ultimaModificacio);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested tramits
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void consultarDadesTramitTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/tramits/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new TramitsRDTO());

		BigDecimal id = ONE;
		TramitsRDTO response = api.consultarDadesTramit(id);

		assertTrue(response != null);
	}

	/**
	 * Returns all the tramits
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getAllTramitsUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/tramits"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new PageDataOfTramitsRDTO());

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
		PageDataOfTramitsRDTO response = api.getAllTramitsUsingGET(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Insert tramits
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveTramitUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/tramits"), eq("POST"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(new TramitsRDTO());

		TramitsRDTO tramitsRDTO = new TramitsRDTO();
		TramitsRDTO response = api.saveTramitUsingPOST(tramitsRDTO);

		assertTrue(response != null);
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
	public void searchHistoricsUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/tramits/historic/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
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
		List<Integer> tipus = null;
		Long totalElements = null;
		Integer totalPages = null;
		PageDataOfHistoricsRDTO response = api.searchHistoricsUsingGET(id, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, tipus, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns all the tramits that meet the search criteria and are not
	 * associated with a procediment
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchTramitsNotAssociatedProcedimentUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/tramits/searchNotAssociated/procediment/1"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfTramitsRDTO());

		BigDecimal idProcediment = ONE;
		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		DateTime darreraModificacio = null;
		DateTime dataGestioElectronica = null;
		String descripcio = null;
		String dir = null;
		Integer esTramitIniciacio = null;
		Integer exclusiuIntern = null;
		String gestioElectronica = null;
		BigDecimal id = null;
		String informacioTramitador = null;
		Integer nextPageNumber = null;
		String nom = null;
		String normaAltresAplicacio = null;
		String normaReferenciaPrincipal = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String rolUsuari = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		BigDecimal ultimaModificacio = null;
		PageDataOfTramitsRDTO response = api.searchTramitsNotAssociatedProcedimentUsingGET(idProcediment,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, darreraModificacio,
		        dataGestioElectronica, descripcio, dir, esTramitIniciacio, exclusiuIntern, gestioElectronica, id, informacioTramitador,
		        nextPageNumber, nom, normaAltresAplicacio, normaReferenciaPrincipal, pageSize, previousPageNumber, rolUsuari, sort,
		        totalElements, totalPages, ultimaModificacio);

		assertTrue(response != null);
	}

	/**
	 * check if the tramits are associated to procediments
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void tramitsAssociatedProcedimentUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/tramits/delete"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new ArrayList<BigDecimal>());

		List<BigDecimal> idTramitsList = Arrays.asList(ONE);
		api.tramitsAssociatedProcedimentUsingPOST(idTramitsList);

		assertTrue(true);
	}

}
