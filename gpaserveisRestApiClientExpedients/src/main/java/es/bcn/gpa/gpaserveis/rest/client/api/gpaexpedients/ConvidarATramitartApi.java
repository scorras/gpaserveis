package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-08T13:33:09.050+02:00")
public class ConvidarATramitartApi {
  private ApiClient apiClient;

  public ConvidarATramitartApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConvidarATramitartApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * ConvidarATramitart
   * 
   * @param convidarTramitarRDTO convidarTramitarRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void convidarTramitarExpedient(ConvidarTramitarRDTO convidarTramitarRDTO) throws ApiException {
    Object localVarPostBody = convidarTramitarRDTO;
    
    // verify the required parameter 'convidarTramitarRDTO' is set
    if (convidarTramitarRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'convidarTramitarRDTO' when calling convidarTramitarExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/convidarATramitar";

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
