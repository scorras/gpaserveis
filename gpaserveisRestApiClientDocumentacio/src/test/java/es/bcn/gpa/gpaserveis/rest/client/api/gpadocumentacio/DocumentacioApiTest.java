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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AcumularDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaIdsAndEstatRevisioId;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioIdsAndEstatFinalId;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatRevisioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TransicionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;

/**
 * API tests for DocumentacioApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentacioApiTest extends ParentTest {

	@InjectMocks
	private DocumentacioApi api = new DocumentacioApi();

	/**
	 * Acumulació de la documentació
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void acumularDocumentacioUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/acumularDocumentacio"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RestClientResponse());

		AcumularDocumentacioRDTO acumularDocumentacioRDTO = new AcumularDocumentacioRDTO();
		RestClientResponse response = api.acumularDocumentacioUsingPOST(acumularDocumentacioRDTO);

		assertTrue(response != null);
	}

	/**
	 * Updates all selected DocsTramitacio with the EstatsDocument specified
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void canviEstatDocumentacioTramitacioUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/canviEstat"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(null);

		DocsTramitacioIdsAndEstatFinalId docsEntradaIdsAndEstatRevisioId = new DocsTramitacioIdsAndEstatFinalId();
		api.canviEstatDocumentacioTramitacioUsingPOST(docsEntradaIdsAndEstatRevisioId);

		assertTrue(true);
	}

	/**
	 * Delete all selected DocsEntrada
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deleteDocumentacioEntradaUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/entrada/delete/1"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), isNull(GenericType.class))).thenReturn(null);

		List<BigDecimal> docsEntradaIds = Arrays.asList(ONE);
		BigDecimal idExpedient = ONE;
		api.deleteDocumentacioEntradaUsingPOST(docsEntradaIds, idExpedient);

		assertTrue(true);
	}

	/**
	 * Delete all selected DocsEntrada
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void deleteDocumentacioTramitacioUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/delete/1"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), isNull(GenericType.class))).thenReturn(null);

		List<BigDecimal> docsTramitacioIds = Arrays.asList(ONE);
		BigDecimal idExpedient = ONE;
		api.deleteDocumentacioTramitacioUsingPOST(docsTramitacioIds, idExpedient);

		assertTrue(true);
	}

	/**
	 * Returns the requested documentacio entrada
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getDocumentacioEntradaUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/1/entrada/1/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfDocsEntradaRDTO());

		String estatsFutursList = ONE.toString();
		BigDecimal idConfiguracioDocumentacio = ONE;
		BigDecimal idDocumentacio = ONE;
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
		PageDataOfDocsEntradaRDTO response = api.getDocumentacioEntradaUsingGET(estatsFutursList, idConfiguracioDocumentacio,
		        idDocumentacio, absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested documentacio entrada grouped by tràmit OVT
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaDocumentsEntradaAgrupatsPerTramitOvtTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/1/entrada/agrupatPerTramitOvt"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<DocsEntradaRDTO>());

		BigDecimal idDocumentacio = ONE;
		List<DocsEntradaRDTO> response = api.cercaDocumentsEntradaAgrupatsPerTramitOvt(idDocumentacio);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested documentacio tramitacio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getDocumentacioTramitacioUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/1/tramitacio/1/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfDocsTramitacioRDTO());

		String estatsFutursList = ONE.toString();
		BigDecimal idConfiguracioDocumentacio = ONE;
		BigDecimal idDocumentacio = ONE;
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
		PageDataOfDocsTramitacioRDTO response = api.getDocumentacioTramitacioUsingGET(estatsFutursList, idConfiguracioDocumentacio,
		        idDocumentacio, absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns all the EstatRevisio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getEstatsRevisioDocumentacioEntradaUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/estatsRevisio"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<EstatRevisioRDTO>());

		List<EstatRevisioRDTO> response = api.getEstatsRevisioDocumentacioEntradaUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Returns all the tipus grup entries for the idConfigDoc
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getTipusGrupEntradaUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/entrada/listTipusGrup/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<ConfiguracioDocsEntradaRDTO>());

		BigDecimal idConfigDoc = ONE;
		List<ConfiguracioDocsEntradaRDTO> response = api.getTipusGrupEntradaUsingGET(idConfigDoc);

		assertTrue(response != null);
	}

	/**
	 * Returns all the tipus grup entries for the idConfigDoc
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getTipusGrupTramitacioUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/listTipusGrup/1"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<ConfiguracioDocsTramitacioRDTO>());

		BigDecimal idConfigDoc = ONE;
		List<ConfiguracioDocsTramitacioRDTO> response = api.getTipusGrupTramitacioUsingGET(idConfigDoc);

		assertTrue(response != null);
	}

	/**
	 * create new documentacio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void newDocumentacioUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/newDocumentacio"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RestClientResponse());

		RestClientResponse response = api.newDocumentacioUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Returns the requested documentacio entrada
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obteneriDocumentacioEntradaEnRevisioUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/documentacioEntradaEnRevisio"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<BigDecimal>());

		List<BigDecimal> response = api.obteneriDocumentacioEntradaEnRevisioUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Get all estats documentació tramitació
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirTransicionsEstatsByEstatDocTramUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/estatsDocTramCanviEstat/1"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<TransicionsEstatsRDTO>());

		BigDecimal estatDocTramitacio = ONE;
		List<TransicionsEstatsRDTO> response = api.obtenirTransicionsEstatsByEstatDocTramUsingGET(estatDocTramitacio);

		assertTrue(response != null);
	}

	/**
	 * Updates all selected DocsEntrada with the EstatRevisio specified
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void revisarDocumentacioEntradaUsingPOSTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/revisar"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(null);

		DocsEntradaIdsAndEstatRevisioId docsEntradaIdsAndEstatRevisioId = new DocsEntradaIdsAndEstatRevisioId();
		api.revisarDocumentacioEntradaUsingPOST(docsEntradaIdsAndEstatRevisioId);

		assertTrue(true);
	}

	/**
	 * updates the doc entrada
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveDocumentacioEntradaUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/entrada/saveDocEntrada/1"), eq("POST"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.saveDocumentacioEntradaUsingPOST(docsEntradaRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * updates the doc tramitacio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveDocumentacioTramitacioUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/saveDocTramitacio/1"), eq("POST"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.saveDocumentacioTramitacioUsingPOST(docsTramitacioRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * updates the requeriment
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void saveRequerimentUsingPOSTTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/documentacio/saveRequeriment/1/1"), eq("POST"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		String idsConfDocEntradaList = ONE.toString();
		DocsTramitacioRDTO response = api.saveRequerimentUsingPOST(docsTramitacioRDTO, idExpedient, idsConfDocEntradaList);

		assertTrue(response != null);
	}

}
