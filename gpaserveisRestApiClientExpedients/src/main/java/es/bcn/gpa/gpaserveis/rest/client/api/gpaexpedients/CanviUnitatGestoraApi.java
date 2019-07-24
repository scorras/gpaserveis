package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraMassiuRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-24T01:06:10.329+02:00")
public class CanviUnitatGestoraApi {
  private ApiClient apiClient;

  public CanviUnitatGestoraApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CanviUnitatGestoraApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Changes the unitat gestora of the provided expedient
   * 
   * @param canviUnitatGestoraMassiuRDTO canviUnitatGestoraMassiuRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void canviarUnitatGestoraExpedient(CanviUnitatGestoraMassiuRDTO canviUnitatGestoraMassiuRDTO) throws ApiException {
    Object localVarPostBody = canviUnitatGestoraMassiuRDTO;
    
    // verify the required parameter 'canviUnitatGestoraMassiuRDTO' is set
    if (canviUnitatGestoraMassiuRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'canviUnitatGestoraMassiuRDTO' when calling canviarUnitatGestoraExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/canviUnitatGestora";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
