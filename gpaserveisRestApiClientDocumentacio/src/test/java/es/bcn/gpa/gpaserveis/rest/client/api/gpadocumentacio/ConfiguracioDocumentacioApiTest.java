/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.4.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ProcedimentsClonarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;

/**
 * API tests for ConfiguracioDocumentacioApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfiguracioDocumentacioApiTest extends ParentTest {

	@InjectMocks
	private ConfiguracioDocumentacioApi api = new ConfiguracioDocumentacioApi();

	/**
	 * create doc configuracio to the proc clon
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void createConfiguracioDocToProcClonUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/newConfiguracioDoc"), eq("POST"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RestClientResponse());

		ProcedimentsClonarRDTO procedimentsClonarBDTO = new ProcedimentsClonarRDTO();
		RestClientResponse response = api.createConfiguracioDocToProcClonUsingPOST(procedimentsClonarBDTO);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested entrada configuracio associada al requeriment
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getConfDocAssociadaRequerimentUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/getConfDocAssociadaRequeriment/1"), eq("GET"), any(List.class),
		        any(Object.class), any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class),
		        any(GenericType.class))).thenReturn(new ArrayList<ConfiguracioDocsEntradaRDTO>());

		BigDecimal idRequeriment = ONE;
		List<ConfiguracioDocsEntradaRDTO> response = api.getConfDocAssociadaRequerimentUsingGET(idRequeriment);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested entrada configuracio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaConfiguracioDocumentacioEntradaTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/entrada/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfConfiguracioDocsEntradaRDTO());

		BigDecimal id = ONE;
		BigDecimal idTramitOvt = ONE;
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
		PageDataOfConfiguracioDocsEntradaRDTO response = api.cercaConfiguracioDocumentacioEntrada(id, idTramitOvt,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested entrada configuracio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaConfiguracioDocumentacioEntrada1Test() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/entrada/1/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfConfiguracioDocsEntradaRDTO());

		BigDecimal id = ONE;
		BigDecimal idTramitOvt = ONE;
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
		PageDataOfConfiguracioDocsEntradaRDTO response = api.cercaConfiguracioDocumentacioEntrada1(id, idTramitOvt,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested tramitacio configuracio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getConfiguracioDocumentacioTramitacioUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/tramitacio/1"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfConfiguracioDocsTramitacioRDTO());

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
		PageDataOfConfiguracioDocsTramitacioRDTO response = api.getConfiguracioDocumentacioTramitacioUsingGET(id,
		        absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * check if the tramits are being used
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void newConfiguracioDocUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/newConfiguracioDoc"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RestClientResponse());

		RestClientResponse response = api.newConfiguracioDocUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Returns the requested entrada configuracio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirConfiguracioDocEntAssociarRequerimentUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/entradaAssociarRequeriment/1/1"), eq("GET"), any(List.class),
		        any(Object.class), any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class),
		        any(GenericType.class))).thenReturn(new PageDataOfConfiguracioDocsEntradaRDTO());

		BigDecimal idConfiguracioDocumentacio = ONE;
		String idsConfEntrAssociarReq = ONE.toString();
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
		PageDataOfConfiguracioDocsEntradaRDTO response = api.obtenirConfiguracioDocEntAssociarRequerimentUsingGET(
		        idConfiguracioDocumentacio, idsConfEntrAssociarReq, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested tramitacio configuracio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirConfiguracioDocumentacioTramitacioUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/configuracioDocsTramitacio/1"), eq("GET"), any(List.class),
		        any(Object.class), any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class),
		        any(GenericType.class))).thenReturn(new ArrayList<ConfiguracioDocsTramitacioRDTO>());

		BigDecimal id = ONE;
		List<ConfiguracioDocsTramitacioRDTO> response = api.obtenirConfiguracioDocumentacioTramitacioUsingGET(id);

		assertTrue(response != null);
	}

	/**
	 * updates the doc config
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void updateDocumentacioEntradaUsingPUTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/docEntrada/1"), eq("PUT"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RestClientResponse());

		ConfiguracioDocsEntradaRDTO docEntrada = new ConfiguracioDocsEntradaRDTO();
		BigDecimal procId = ONE;
		RestClientResponse response = api.updateDocumentacioEntradaUsingPUT(docEntrada, procId);

		assertTrue(response != null);
	}

	/**
	 * updates the doc config
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void updateDocumentacioTramitacioUsingPUTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/configuracioDocumentacio/docTramitacio/1"), eq("PUT"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RestClientResponse());

		ConfiguracioDocsTramitacioRDTO docTramitacio = new ConfiguracioDocsTramitacioRDTO();
		BigDecimal procId = ONE;
		RestClientResponse response = api.updateDocumentacioTramitacioUsingPUT(docTramitacio, procId);

		assertTrue(response != null);
	}

}
