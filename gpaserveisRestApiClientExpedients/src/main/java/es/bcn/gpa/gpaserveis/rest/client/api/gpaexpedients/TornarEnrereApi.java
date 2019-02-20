package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviEstatRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-19T12:01:33.083+01:00")
public class TornarEnrereApi {
  private ApiClient apiClient;

  public TornarEnrereApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TornarEnrereApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Tornar Enrere of the provided expedient
   * 
   * @param canviEstatRDTO canviEstatRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void tornarEnrereUsingPOST(CanviEstatRDTO canviEstatRDTO) throws ApiException {
    Object localVarPostBody = canviEstatRDTO;
    
    // verify the required parameter 'canviEstatRDTO' is set
    if (canviEstatRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'canviEstatRDTO' when calling tornarEnrereUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/tornarEnrere";

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
