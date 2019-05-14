package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AdrecaNormalitzadaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T14:36:36.923+02:00")
public class AdrecaApi {
	private ApiClient apiClient;

	public AdrecaApi() {
		this(Configuration.getDefaultApiClient());
	}

	public AdrecaApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Returns the normalitzada adreca
	 * 
	 * @param nomVia
	 *            nomVia (required)
	 * @param numero
	 *            numero (required)
	 * @return AdrecaNormalitzadaRDTO
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public AdrecaNormalitzadaRDTO normalitzarAdrecaPostalUsingGET(String nomVia, String numero) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'nomVia' is set
		if (nomVia == null) {
			throw new ApiException(400, "Missing the required parameter 'nomVia' when calling normalitzarAdrecaPostalUsingGET");
		}

		// verify the required parameter 'numero' is set
		if (numero == null) {
			throw new ApiException(400, "Missing the required parameter 'numero' when calling normalitzarAdrecaPostalUsingGET");
		}

		// create path and map variables
		String localVarPath = "/expedients/catalog/normalitzarAdrecaPostal/{nomVia}/{numero}"
		        .replaceAll("\\{" + "nomVia" + "\\}", apiClient.escapeString(nomVia.toString()))
		        .replaceAll("\\{" + "numero" + "\\}", apiClient.escapeString(numero.toString()));

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

		GenericType<AdrecaNormalitzadaRDTO> localVarReturnType = new GenericType<AdrecaNormalitzadaRDTO>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams,
		        localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}
}
