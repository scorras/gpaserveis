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
import static org.apache.commons.lang.math.NumberUtils.INTEGER_ONE;
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

import org.joda.time.DateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.InputStreamResource;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;

/**
 * API tests for Expedients_Api
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Expedients_ApiTest extends ParentTest {

	@InjectMocks
	private Expedients_Api api = new Expedients_Api();

	/**
	 * Returns all the expedients that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaExpedientsTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/search"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfExpedientsRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		String aplicacioNegoci = null;
		List<String> avisList = null;
		String codi = null;
		BigDecimal criteriDeCercaDadesOperacioList0Id = null;
		BigDecimal criteriDeCercaDadesOperacioList0Tipus = null;
		String criteriDeCercaDadesOperacioList0Valor = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		DateTime dataPresentacioDes = null;
		DateTime dataPresentacioFinsA = null;
		String dir = null;
		List<BigDecimal> estatList = null;
		BigDecimal id = null;
		BigDecimal idUsuari = null;
		Integer nextPageNumber = null;
		String numeroDocumentSollicitant = null;
		String numeroDocumentSollicitantEstricte = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		List<String> procedimentCodisList = null;
		String procedimentVersio = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		String tramitador = null;
		List<BigDecimal> unitatsGestoresList = null;
		PageDataOfExpedientsRDTO response = api.cercaExpedients(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, aplicacioNegoci, avisList, codi, criteriDeCercaDadesOperacioList0Id,
		        criteriDeCercaDadesOperacioList0Tipus, criteriDeCercaDadesOperacioList0Valor, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dataPresentacioDes,
		        dataPresentacioFinsA, dir, estatList, id, idUsuari, nextPageNumber, numeroDocumentSollicitant,
		        numeroDocumentSollicitantEstricte, pageSize, previousPageNumber, procedimentCodisList, procedimentVersio, sort,
		        totalElements, totalPages, tramitador, unitatsGestoresList);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void consultarDadesExpedientTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class))).thenReturn(new ExpedientsRDTO());

		BigDecimal id = ONE;
		ExpedientsRDTO response = api.consultarDadesExpedient(id);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void consultarDadesExpedientPerCodiTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn("Codi%20%2F2018%2F000001");
		when(apiClient.invokeAPI(eq("/expedients/perCodi/Codi%20%2F2018%2F000001"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ExpedientsRDTO());

		String codiBaseName = "Codi /2018/000001";
		ExpedientsRDTO response = api.consultarDadesExpedientPerCodi(codiBaseName);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested child expedients
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getChildExpedientsUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/acumulacioExpedients/1/acumulacio/children"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfExpedientsRDTO());

		BigDecimal idExpedient = ONE;
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
		PageDataOfExpedientsRDTO response = api.getChildExpedientsUsingGET(idExpedient, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns al the expedients
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getExpedientsUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/all"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ArrayList<ExpedientsRDTO>());

		List<ExpedientsRDTO> response = api.getExpedientsUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Returns all the expedients gestores
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getExpedientsUsingGET1Test() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfExpedientsRDTO());

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
		PageDataOfExpedientsRDTO response = api.getExpedientsUsingGET1(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested parent&#39;s expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getParentExpedientUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/acumulacioExpedients/1/acumulacio/parent"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfExpedientsRDTO());

		BigDecimal idExpedient = ONE;
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
		PageDataOfExpedientsRDTO response = api.getParentExpedientUsingGET(idExpedient, absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements,
		        totalPages);

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
	public void getRegistreAssentamentUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/registre"), eq("GET"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new RegistreAssentamentRDTO());

		String codi = "Reg";
		RegistreAssentamentRDTO response = api.getRegistreAssentamentUsingGET(codi);

		assertTrue(response != null);
	}

	/**
	 * Returns all the expedients gestores
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirIndicadorExpedientsUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/obtenirIndicadorExpedients"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(INTEGER_ONE);

		Integer response = api.obtenirIndicadorExpedientsUsingGET();

		assertTrue(response != null);
	}

	/**
	 * Insert the provided expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void crearSollicitudExpedientTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients"), eq("POST"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(new ExpedientsRDTO());

		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();
		ExpedientsRDTO response = api.crearSollicitudExpedient(expedientsRDTO);

		assertTrue(response != null);
	}

	/**
	 * Updates the provided expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void actualitzarDadesSollicitudTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/dadesSollicitud"), eq("PUT"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new ExpedientsRDTO());

		ActualitzarDadesSollicitud actualitzarDadesSollicitud = new ActualitzarDadesSollicitud();
		ExpedientsRDTO response = api.actualitzarDadesSollicitud(actualitzarDadesSollicitud);

		assertTrue(response != null);
	}

	/**
	 * Returns all the expedients that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchExpedientsAcumuladorsUsingGETTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/acumulacioExpedients/searchExpedientsAcumuladors"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new PageDataOfExpedientsRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		String codi = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		String dir = null;
		BigDecimal id = null;
		BigDecimal idProcedimentAcumulat = null;
		BigDecimal idUsuari = null;
		List<BigDecimal> idsExpedientAcumulatList = null;
		Integer nextPageNumber = null;
		String nombreDocument = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String sollicitant = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		PageDataOfExpedientsRDTO response = api.searchExpedientsAcumuladorsUsingGET(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, codi, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, id, idProcedimentAcumulat, idUsuari, idsExpedientAcumulatList,
		        nextPageNumber, nombreDocument, pageSize, previousPageNumber, sollicitant, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Returns excel file with all the expedients that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void exportarCercaExpedientExcelTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients/exportarCercaExpedientExcel"), eq("GET"), any(List.class), any(Object.class),
		        any(Map.class), any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new InputStreamResource());

		String aplicacioNegoci = null;
		List<String> avisList = null;
		String codi = null;
		BigDecimal criteriDeCercaDadesOperacioList0Id = null;
		BigDecimal criteriDeCercaDadesOperacioList0Tipus = null;
		String criteriDeCercaDadesOperacioList0Valor = null;
		DateTime dataPresentacioDes = null;
		DateTime dataPresentacioFinsA = null;
		List<BigDecimal> estatList = null;
		BigDecimal id = null;
		BigDecimal idUsuari = null;
		String numeroDocumentSollicitant = null;
		String numeroDocumentSollicitantEstricte = null;
		List<String> procedimentCodisList = null;
		String procedimentVersio = null;
		String tramitador = null;
		List<BigDecimal> unitatsGestoresList = null;
		InputStreamResource response = api.exportarCercaExpedientExcel(aplicacioNegoci, avisList, codi, criteriDeCercaDadesOperacioList0Id,
		        criteriDeCercaDadesOperacioList0Tipus, criteriDeCercaDadesOperacioList0Valor, dataPresentacioDes, dataPresentacioFinsA,
		        estatList, id, idUsuari, numeroDocumentSollicitant, numeroDocumentSollicitantEstricte, procedimentCodisList,
		        procedimentVersio, tramitador, unitatsGestoresList);

		assertTrue(response != null);
	}

	/**
	 * jexl
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirXmlEvaluateUsingGETTest() throws ApiException {
		when(apiClient.escapeString(any(String.class))).thenReturn(ONE.toString());
		when(apiClient.invokeAPI(eq("/expedients/obtenirXmlEvaluate/1"), eq("GET"), any(List.class), any(Object.class), any(Map.class),
		        any(Map.class), any(String.class), any(String.class), any(String[].class), any(GenericType.class)))
		                .thenReturn(new String());

		BigDecimal idExpedient = ONE;
		String response = api.obtenirXmlEvaluateUsingGET(idExpedient);

		assertTrue(response != null);
	}

	/**
	 * Updates the provided expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void updateExpedientUsingPUTTest() throws ApiException {
		when(apiClient.invokeAPI(eq("/expedients"), eq("PUT"), any(List.class), any(Object.class), any(Map.class), any(Map.class),
		        isNull(String.class), isNull(String.class), any(String[].class), any(GenericType.class))).thenReturn(new ExpedientsRDTO());

		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();
		ExpedientsRDTO response = api.updateExpedientUsingPUT(expedientsRDTO);

		assertTrue(response != null);
	}

}
