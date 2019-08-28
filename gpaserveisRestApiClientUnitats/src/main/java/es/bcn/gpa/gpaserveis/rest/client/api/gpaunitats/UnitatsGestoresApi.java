package es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-14T14:06:00.377+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi")
public class UnitatsGestoresApi {
	private ApiClient apiClient;

	public UnitatsGestoresApi() {
		this(new ApiClient());
	}

	@Autowired
	public UnitatsGestoresApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Returns all the unitats that meet the search criteria
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * 
	 * @param absoluteRowNumberOfFirstRowInCurrentPage
	 *            The absoluteRowNumberOfFirstRowInCurrentPage parameter
	 * @param absoluteRowNumberOfLastRowInCurrentPage
	 *            The absoluteRowNumberOfLastRowInCurrentPage parameter
	 * @param currentPageHasNextPage
	 *            The currentPageHasNextPage parameter
	 * @param currentPageHasPreviousPage
	 *            The currentPageHasPreviousPage parameter
	 * @param currentPageIsFirstPage
	 *            The currentPageIsFirstPage parameter
	 * @param currentPageIsLastPage
	 *            The currentPageIsLastPage parameter
	 * @param currentPageNumber
	 *            The currentPageNumber parameter
	 * @param darreraSincronitzacio
	 *            The darreraSincronitzacio parameter
	 * @param dataCreacio
	 *            The dataCreacio parameter
	 * @param dataModificacio
	 *            The dataModificacio parameter
	 * @param descUnitatOrganigrama
	 *            The descUnitatOrganigrama parameter
	 * @param descripcio
	 *            The descripcio parameter
	 * @param dir
	 *            The dir parameter
	 * @param id
	 *            The id parameter
	 * @param nextPageNumber
	 *            The nextPageNumber parameter
	 * @param nom
	 *            The nom parameter
	 * @param pageSize
	 *            The pageSize parameter
	 * @param previousPageNumber
	 *            The previousPageNumber parameter
	 * @param sort
	 *            The sort parameter
	 * @param totalElements
	 *            The totalElements parameter
	 * @param totalPages
	 *            The totalPages parameter
	 * @param unitatOrganigrama
	 *            The unitatOrganigrama parameter
	 * @param unitatOrganigramaList
	 *            The unitatOrganigramaList parameter
	 * @param vigent
	 *            The vigent parameter
	 * @return PageDataOfUnitatsGestoresRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public PageDataOfUnitatsGestoresRDTO cercaUnitatsGestores(Integer absoluteRowNumberOfFirstRowInCurrentPage,
	        Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage,
	        Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime darreraSincronitzacio,
	        DateTime dataCreacio, DateTime dataModificacio, String descUnitatOrganigrama, String descripcio, String dir, BigDecimal id,
	        Integer nextPageNumber, String nom, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements,
	        Integer totalPages, BigDecimal unitatOrganigrama, List<BigDecimal> unitatOrganigramaList, Integer vigent)
	        throws RestClientException {
		Object postBody = null;

		String path = UriComponentsBuilder.fromPath("/unitats/search").build().toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfFirstRowInCurrentPage",
		        absoluteRowNumberOfFirstRowInCurrentPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfLastRowInCurrentPage",
		        absoluteRowNumberOfLastRowInCurrentPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasNextPage", currentPageHasNextPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasPreviousPage", currentPageHasPreviousPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsFirstPage", currentPageIsFirstPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsLastPage", currentPageIsLastPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageNumber", currentPageNumber));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "darreraSincronitzacio", darreraSincronitzacio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataCreacio", dataCreacio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataModificacio", dataModificacio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "descUnitatOrganigrama", descUnitatOrganigrama));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "descripcio", descripcio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dir", dir));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nom", nom));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "unitatOrganigrama", unitatOrganigrama));
		queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()),
		        "unitatOrganigramaList", unitatOrganigramaList));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "vigent", vigent));

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<PageDataOfUnitatsGestoresRDTO> returnType = new ParameterizedTypeReference<PageDataOfUnitatsGestoresRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
		        returnType);
	}

	/**
	 * Returns the requested unitat
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * 
	 * @param id
	 *            id
	 * @return UnitatsGestoresRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public UnitatsGestoresRDTO consultarDadesUnitatGestora(BigDecimal id) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
			        "Missing the required parameter 'id' when calling consultarDadesUnitatGestora");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", id);
		String path = UriComponentsBuilder.fromPath("/unitats/{id}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<UnitatsGestoresRDTO> returnType = new ParameterizedTypeReference<UnitatsGestoresRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
		        returnType);
	}

	/**
	 * Returns the requested unitat
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * 
	 * @param nom
	 *            nom
	 * @return UnitatsGestoresRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public UnitatsGestoresRDTO consultarDadesUnitatGestoraPerNom(String nom) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'nom' is set
		if (nom == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
			        "Missing the required parameter 'nom' when calling consultarDadesUnitatGestoraPerNom");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("nom", nom);
		String path = UriComponentsBuilder.fromPath("/unitats/perNom/{nom}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<UnitatsGestoresRDTO> returnType = new ParameterizedTypeReference<UnitatsGestoresRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
		        returnType);
	}
}
