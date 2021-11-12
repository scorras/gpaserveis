/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.16.2
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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitudSollicituds;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudActualitzarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient.CollectionFormat;

/**
 * API tests for SollicitudsApi.
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SollicitudsApiTest extends ParentTest {

	/** The api. */
	@InjectMocks
	private SollicitudsApi api = new SollicitudsApi();

	/**
	 * Returns the requested sollicitud.
	 */
	@Test
	public void consultarDadesSollicitudsTest() {
		when(apiClient.invokeAPI(eq("/sollicituds/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new SollicitudsRDTO());

		BigDecimal id = ONE;
		SollicitudsRDTO response = api.consultarDadesSollicituds(id);

		assertTrue(response != null);
	}

	/**
	 * Creates the sollicitud.
	 */
	@Test
	public void crearSollicitudTest() {
		when(apiClient.invokeAPI(eq("/sollicituds"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new SollicitudsRDTO());

		SollicitudsRDTO sollicitudsRDTO = new SollicitudsRDTO();
		SollicitudsRDTO response = api.crearSollicitud(sollicitudsRDTO);

		assertTrue(response != null);
	}

	/**
	 * Consultar sollicituds expedient test.
	 */
	@Test
	public void consultarSollicitudsExpedientTest() {
		when(apiClient.invokeAPI(eq("/sollicituds/consultarSollicitudsExpedient/1"), eq(HttpMethod.GET), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new ArrayList<SollicitudsRDTO>());

		Integer idExpedient = 1;
		List<SollicitudsRDTO> response = api.consultarSollicitudsExpedient(idExpedient);
		assertTrue(response != null);
	}

	/**
	 * Associa el registre a la sol·licitud
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void associarRegistreSollicitudTest() {
		when(apiClient.invokeAPI(eq("/sollicituds/associarRegistreSollicitud"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		SollicitudActualitzarRegistre sollicitudActualitzarRegistreRDTO = new SollicitudActualitzarRegistre();
		api.associarRegistreSollicitud(sollicitudActualitzarRegistreRDTO);

		assertTrue(true);
	}

	/**
	 * Returns all the sollicituds that meet the search criteria
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaSollicitudsTest() {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.parameterToMultiValueMap(any(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/sollicituds/search"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new PageDataOfSollicitudsRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		Boolean currentPageHasNextPage = null;
		Boolean currentPageHasPreviousPage = null;
		Boolean currentPageIsFirstPage = null;
		Boolean currentPageIsLastPage = null;
		Integer currentPageNumber = null;
		String dir = null;
		BigDecimal id = null;
		BigDecimal idExpedient = null;
		BigDecimal idTramitOvt = null;
		BigDecimal idUsuari = null;
		Integer nextPageNumber = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		PageDataOfSollicitudsRDTO response = api.cercaSollicituds(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage,
		        currentPageIsLastPage, currentPageNumber, dir, id, idExpedient, idTramitOvt, idUsuari, nextPageNumber, pageSize,
		        previousPageNumber, sort, totalElements, totalPages);

		assertTrue(response != null);
	}

	/**
	 * Register the provided sollicitud
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void crearRegistreSolicitudTest() {

		when(apiClient.invokeAPI(eq("/expedients/registre/crearSollicitud/1"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new RespostaCrearRegistreExpedient());

		Integer accio = 1;
		CrearSollicitud registrarSolicitudRDTO = new CrearSollicitud();
		RespostaCrearRegistreExpedient response = api.crearRegistreSolicitud(accio, registrarSolicitudRDTO);

		assertTrue(response != null);
	}

	/**
	 * Actualitzar dades sollicitud sollicituds.
	 */
	@Test
	public void actualitzarDadesSollicitudSollicitudsTest() {
		when(apiClient.invokeAPI(eq("/sollicituds/actualitzarDadesSollicitudSollicituds"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new SollicitudsRDTO());

		ActualitzarDadesSollicitudSollicituds actualitzarDadesSollicitudSollicitudsRDTO = new ActualitzarDadesSollicitudSollicituds();
		SollicitudsRDTO response = api.actualitzarDadesSollicitudSollicituds(actualitzarDadesSollicitudSollicitudsRDTO);

		assertTrue(response != null);
	}

	/**
	 * Update sollicitud.
	 */
	@Test
	public void updateSollicitudTest() {
		when(apiClient.invokeAPI(eq("/sollicituds"), eq(HttpMethod.PUT), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new SollicitudsRDTO());

		SollicitudsRDTO sollicitudsRDTO = new SollicitudsRDTO();
		SollicitudsRDTO response = api.updateSollicitud(sollicitudsRDTO);

		assertTrue(response != null);
	}
}
