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
import java.util.List;

import org.joda.time.DateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient.CollectionFormat;

/**
 * API tests for UnitatsGestoresApi
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitatsGestoresApiTest extends ParentTest {

	@InjectMocks
	private UnitatsGestoresApi api = new UnitatsGestoresApi();

	/**
	 * Returns all the unitats that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaUnitatsGestoresTest() {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.parameterToMultiValueMap(any(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/unitats/search"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new PageDataOfUnitatsGestoresRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		DateTime darreraSincronitzacio = null;
		DateTime dataCreacio = null;
		DateTime dataModificacio = null;
		String descUnitatOrganigrama = null;
		String descripcio = null;
		String dir = null;
		Boolean editable = null;
		BigDecimal id = null;
		Long idGrup = null;
		Integer nextPageNumber = null;
		String nom = null;
		String nomDescripcio = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		Boolean seleccionable = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		BigDecimal unitatOrganigrama = null;
		List<BigDecimal> unitatOrganigramaList = null;
		Integer vigent = null;
		PageDataOfUnitatsGestoresRDTO response = api.cercaUnitatsGestores(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, darreraSincronitzacio, dataCreacio, dataModificacio, descUnitatOrganigrama,
		        descripcio, dir, editable, id, idGrup, nextPageNumber, nom, nomDescripcio, pageSize, previousPageNumber, seleccionable,
		        sort, totalElements, totalPages, unitatOrganigrama, unitatOrganigramaList, vigent);

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
	public void consultarDadesUnitatGestoraTest() {
		when(apiClient.invokeAPI(eq("/unitats/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class), any(HttpHeaders.class),
		        any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new UnitatsGestoresRDTO());

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
	public void consultarDadesUnitatGestoraPerNomTest() {
		when(apiClient.invokeAPI(eq("/unitats/perNom/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new UnitatsGestoresRDTO());

		String nom = ONE.toString();
		UnitatsGestoresRDTO response = api.consultarDadesUnitatGestoraPerNom(nom);

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
	public void consultarDadesUnitatGestoraPerNomListTest() {
		when(apiClient.invokeAPI(eq("/unitats/obtenirIdsUnitatsPerNomList/1"), eq(HttpMethod.GET), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new ArrayList<BigDecimal>());

		String nom = ONE.toString();
		List<BigDecimal> response = api.consultarDadesUnitatGestoraPerNomList(nom);

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
	public void consultarUnitatOrganigrama() {
		when(apiClient.invokeAPI(eq("/unitats/1/unitatOrganigrama"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new UnitatsOrganigramaRDTO());

		BigDecimal id = ONE;
		UnitatsOrganigramaRDTO response = api.consultarUnitatOrganigrama(id);

		assertTrue(response != null);
	}

}
