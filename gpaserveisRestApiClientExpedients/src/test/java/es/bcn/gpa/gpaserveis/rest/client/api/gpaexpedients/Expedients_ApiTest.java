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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaObtenirXmlExpedient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient.CollectionFormat;

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
	public void cercaExpedientsTest() {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.parameterToMultiValueMap(any(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/expedients/search"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new PageDataOfExpedientsRDTO());

		Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
		Integer absoluteRowNumberOfLastRowInCurrentPage = null;
		String aplicacioNegoci = null;
		List<String> avisList = new ArrayList<String>();
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
		Boolean isOge = null;
		Integer nextPageNumber = null;
		String numeroDocumentSollicitant = null;
		String numeroDocumentSollicitantEstricte = null;
		Integer pageSize = null;
		Integer previousPageNumber = null;
		List<String> procedimentCodisList = null;
		BigDecimal procedimentId = null;
		BigDecimal procedimentVersio = null;
		String sort = null;
		Long totalElements = null;
		Integer totalPages = null;
		String tramitador = null;
		List<BigDecimal> unitatsGestoresList = null;
		PageDataOfExpedientsRDTO response = api.cercaExpedients(absoluteRowNumberOfFirstRowInCurrentPage,
		        absoluteRowNumberOfLastRowInCurrentPage, aplicacioNegoci, avisList, codi, criteriDeCercaDadesOperacioList0Id,
		        criteriDeCercaDadesOperacioList0Tipus, criteriDeCercaDadesOperacioList0Valor, currentPageHasNextPage,
		        currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dataPresentacioDes,
		        dataPresentacioFinsA, dir, estatList, id, idUsuari, isOge, nextPageNumber, numeroDocumentSollicitant,
		        numeroDocumentSollicitantEstricte, pageSize, previousPageNumber, procedimentCodisList, procedimentId, procedimentVersio,
		        sort, totalElements, totalPages, tramitador, unitatsGestoresList);

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
	public void consultarDadesExpedientTest() {
		when(apiClient.invokeAPI(eq("/expedients/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new ExpedientsRDTO());

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
	public void consultarDadesExpedientPerCodiTest() {
		when(apiClient.invokeAPI(eq("/expedients/perCodi/Codi000001"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new ExpedientsRDTO());

		String codi = "Codi000001";
		ExpedientsRDTO response = api.consultarDadesExpedientPerCodi(codi);

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
	public void consultarDadesRegistreAssentamentTest() {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/expedients/registre"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new RegistreAssentamentRDTO());

		String codi = ONE.toString();
		RegistreAssentamentRDTO response = api.consultarDadesRegistreAssentament(codi);

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
	public void crearSollicitudExpedientTest() {
		when(apiClient.invokeAPI(eq("/expedients"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new ExpedientsRDTO());

		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();
		ExpedientsRDTO response = api.crearSollicitudExpedient(expedientsRDTO);

		assertTrue(response != null);
	}

	/**
	 * Updates the provided expedient including specific data
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void actualitzarDadesSollicitudTest() {
		when(apiClient.invokeAPI(eq("/expedients/dadesSollicitud"), eq(HttpMethod.PUT), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new ExpedientsRDTO());

		ActualitzarDadesSollicitud actualitzarDadesSollicitudRDTO = new ActualitzarDadesSollicitud();
		ExpedientsRDTO response = api.actualitzarDadesSollicitud(actualitzarDadesSollicitudRDTO);

		assertTrue(response != null);
	}

	/**
	 * Retorna el xml de la informació de l&#39;expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirXmlExpedientTest() {
		when(apiClient.invokeAPI(eq("/expedients/obtenirXmlEvaluate/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new RespostaObtenirXmlExpedient());

		BigDecimal idExpedient = ONE;
		RespostaObtenirXmlExpedient response = api.obtenirXmlExpedient(idExpedient);

		assertTrue(response != null);
	}

	/**
	 * Register the provided expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void crearRegistreSolicitudExpedientTest() {
		when(apiClient.invokeAPI(eq("/expedients/registre/crear/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new RespostaCrearRegistreExpedient());

		BigDecimal accio = ONE;
		CrearRegistre registrarSolicitudExpedientRDTO = new CrearRegistre();
		RespostaCrearRegistreExpedient response = api.crearRegistreSolicitudExpedient(accio, registrarSolicitudExpedientRDTO);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested id expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void getIdExpedientByDocumentacioIdExtTest() {
		when(apiClient.invokeAPI(eq("/expedients/expedientByIdDoc/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(ONE);

		BigDecimal idDocumentacio = ONE;
		BigDecimal response = api.getIdExpedientByDocumentacioIdExt(idDocumentacio);

		assertTrue(response != null);
	}

	/**
	 * Register the provided documentacio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void registreDocumentacioAriadnaTest() {
		when(apiClient.invokeAPI(eq("/expedients/registre/registreDoc"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		RegistreDocumentacioExpedient registreDocumentacioExpedientRDTO = new RegistreDocumentacioExpedient();
		api.registreDocumentacioAriadna(registreDocumentacioExpedientRDTO);

		assertTrue(true);
	}

}
