package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T14:36:36.923+02:00")
public class PaisosApi {
	private ApiClient apiClient;

	public PaisosApi() {
		this(Configuration.getDefaultApiClient());
	}

	public PaisosApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Returns the request paiso
	 * 
	 * @param codi
	 *            codi (required)
	 * @return PaisosRDTO
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public PaisosRDTO getPaisosByCodiUsingGET(String codi) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'codi' is set
		if (codi == null) {
			throw new ApiException(400, "Missing the required parameter 'codi' when calling getPaisosByCodiUsingGET");
		}

		// create path and map variables
		String localVarPath = "/expedients/catalog/paisos/{codi}".replaceAll("\\{" + "codi" + "\\}",
		        apiClient.escapeString(codi.toString()));

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

		GenericType<PaisosRDTO> localVarReturnType = new GenericType<PaisosRDTO>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
		        localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * Returns all the paisos
	 * 
	 * @return List&lt;PaisosRDTO&gt;
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public List<PaisosRDTO> getPaisosUsingGET() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/expedients/catalog/paisos";

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

		GenericType<List<PaisosRDTO>> localVarReturnType = new GenericType<List<PaisosRDTO>>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
		        localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}
}
