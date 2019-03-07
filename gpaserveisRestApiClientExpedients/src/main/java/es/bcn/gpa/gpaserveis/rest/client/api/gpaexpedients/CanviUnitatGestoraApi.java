package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T09:42:46.833+01:00")
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
   * @param canviUnitatGestoraRDTO canviUnitatGestoraRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void canviUnitatGestoraUsingPOST(CanviUnitatGestoraRDTO canviUnitatGestoraRDTO) throws ApiException {
    Object localVarPostBody = canviUnitatGestoraRDTO;
    
    // verify the required parameter 'canviUnitatGestoraRDTO' is set
    if (canviUnitatGestoraRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'canviUnitatGestoraRDTO' when calling canviUnitatGestoraUsingPOST");
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
