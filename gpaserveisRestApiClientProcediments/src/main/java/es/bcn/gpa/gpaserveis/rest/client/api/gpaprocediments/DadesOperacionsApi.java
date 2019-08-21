package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.MarquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

/**
 * The Class DadesOperacionsApi.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-17T14:27:24.410+02:00")
public class DadesOperacionsApi {

	/** The api client. */
	private ApiClient apiClient;

	/**
	 * Instantiates a new dades operacions api.
	 */
	public DadesOperacionsApi() {
		this(Configuration.getDefaultApiClient());
	}

	/**
	 * Instantiates a new dades operacions api.
	 *
	 * @param apiClient
	 *            the api client
	 */
	public DadesOperacionsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Gets the api client.
	 *
	 * @return the api client
	 */
	public ApiClient getApiClient() {
		return apiClient;
	}

	/**
	 * Sets the api client.
	 *
	 * @param apiClient
	 *            the new api client
	 */
	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Returns all the dades operacions entries for the procedure.
	 *
	 * @param id
	 *            id (required)
	 * @param absoluteRowNumberOfFirstRowInCurrentPage
	 *            (optional)
	 * @param absoluteRowNumberOfLastRowInCurrentPage
	 *            (optional)
	 * @param currentPageHasNextPage
	 *            (optional)
	 * @param currentPageHasPreviousPage
	 *            (optional)
	 * @param currentPageIsFirstPage
	 *            (optional)
	 * @param currentPageIsLastPage
	 *            (optional)
	 * @param currentPageNumber
	 *            (optional)
	 * @param dir
	 *            (optional)
	 * @param nextPageNumber
	 *            (optional)
	 * @param pageSize
	 *            (optional)
	 * @param previousPageNumber
	 *            (optional)
	 * @param sort
	 *            (optional)
	 * @param totalElements
	 *            (optional)
	 * @param totalPages
	 *            (optional)
	 * @return PageDataOfDadesOperacionsRDTO
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public PageDataOfDadesOperacionsRDTO cercaDadesOperacioRequerits(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage,
			Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage,
			Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber,
			Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new ApiException(400, "Missing the required parameter 'id' when calling cercaDadesOperacioRequerits");
		}

		// create path and map variables
		String localVarPath = "/procediments/{id}/dadesOperRequerit".replaceAll("\\{" + "id" + "\\}",
				apiClient.escapeString(id.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(
				apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
		localVarQueryParams
				.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));

		final String[] localVarAccepts = { "*/*" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
				localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Returns all the dades operacions entries for the procedure.
	 *
	 * @param idsDadesOperList
	 *            idsDadesOperList (required)
	 * @return List&lt;DadesOperacionsRDTO&gt;
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public List<DadesOperacionsRDTO> getDadesOperacionsListUsingGET(String idsDadesOperList) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'idsDadesOperList' is set
		if (idsDadesOperList == null) {
			throw new ApiException(400, "Missing the required parameter 'idsDadesOperList' when calling getDadesOperacionsListUsingGET");
		}

		// create path and map variables
		String localVarPath = "/procediments/dadesOperacio/{idsDadesOperList}".replaceAll("\\{" + "idsDadesOperList" + "\\}",
				apiClient.escapeString(idsDadesOperList.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "*/*" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<List<DadesOperacionsRDTO>> localVarReturnType = new GenericType<List<DadesOperacionsRDTO>>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
				localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Returns all the dades operacions entries for the procedure.
	 *
	 * @param id
	 *            id (required)
	 * @param idsJaExisteix
	 *            idsJaExisteix (required)
	 * @param absoluteRowNumberOfFirstRowInCurrentPage
	 *            (optional)
	 * @param absoluteRowNumberOfLastRowInCurrentPage
	 *            (optional)
	 * @param currentPageHasNextPage
	 *            (optional)
	 * @param currentPageHasPreviousPage
	 *            (optional)
	 * @param currentPageIsFirstPage
	 *            (optional)
	 * @param currentPageIsLastPage
	 *            (optional)
	 * @param currentPageNumber
	 *            (optional)
	 * @param dir
	 *            (optional)
	 * @param nextPageNumber
	 *            (optional)
	 * @param pageSize
	 *            (optional)
	 * @param previousPageNumber
	 *            (optional)
	 * @param sort
	 *            (optional)
	 * @param totalElements
	 *            (optional)
	 * @param totalPages
	 *            (optional)
	 * @return PageDataOfDadesOperacionsRDTO
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public PageDataOfDadesOperacionsRDTO getDadesOperacionsRequeritWithIdsUsingGET(BigDecimal id, String idsJaExisteix,
			Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage,
			Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage,
			Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize,
			Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new ApiException(400, "Missing the required parameter 'id' when calling getDadesOperacionsRequeritWithIdsUsingGET");
		}

		// verify the required parameter 'idsJaExisteix' is set
		if (idsJaExisteix == null) {
			throw new ApiException(400,
					"Missing the required parameter 'idsJaExisteix' when calling getDadesOperacionsRequeritWithIdsUsingGET");
		}

		// create path and map variables
		String localVarPath = "/procediments/{id}/dadesOperRequerit/{idsJaExisteix}"
				.replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
				.replaceAll("\\{" + "idsJaExisteix" + "\\}", apiClient.escapeString(idsJaExisteix.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(
				apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
		localVarQueryParams
				.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));

		final String[] localVarAccepts = { "*/*" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
				localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Returns all the dades operacions entries for the procedure.
	 *
	 * @param id
	 *            id (required)
	 * @param dir
	 *            (optional)
	 * @param sort
	 *            (optional)
	 * @return PageDataOfDadesOperacionsRDTO
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public PageDataOfDadesOperacionsRDTO getDadesOperacionsUsingGET1(BigDecimal id, String dir, String sort) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new ApiException(400, "Missing the required parameter 'id' when calling getDadesOperacionsUsingGET1");
		}

		// create path and map variables
		String localVarPath = "/procediments/{id}/dades".replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

		final String[] localVarAccepts = { "*/*" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
				localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Obtenir marques dades operacio procediment using GET.
	 *
	 * @param procedimentCodi
	 *            the procediment codi
	 * @param procedimentVersio
	 *            the procediment versio
	 * @return the list
	 * @throws ApiException
	 *             the api exception
	 */
	public List<MarquesRDTO> obtenirMarquesDadesOperacioProcedimentUsingGET(String procedimentCodi, BigDecimal procedimentVersio)
			throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'procedimentCodi' is set
		if (procedimentCodi == null) {
			throw new ApiException(400,
					"Missing the required parameter 'procedimentCodi' when calling obtenirMarquesDadesOperacioProcedimentUsingGET");
		}

		// verify the required parameter 'procedimentVersio' is set
		if (procedimentVersio == null) {
			throw new ApiException(400,
					"Missing the required parameter 'procedimentVersio' when calling obtenirMarquesDadesOperacioProcedimentUsingGET");
		}

		// create path and map variables
		String localVarPath = "/procediments/obtenirMarquesDadesOperacioProcediment/{procedimentCodi}/{procedimentVersio}"
				.replaceAll("\\{" + "procedimentCodi" + "\\}", apiClient.escapeString(procedimentCodi.toString()))
				.replaceAll("\\{" + "procedimentVersio" + "\\}", apiClient.escapeString(procedimentVersio.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "*/*" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<List<MarquesRDTO>> localVarReturnType = new GenericType<List<MarquesRDTO>>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
				localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}
}
