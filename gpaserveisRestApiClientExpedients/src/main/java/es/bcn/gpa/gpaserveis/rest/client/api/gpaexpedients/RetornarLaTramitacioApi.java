package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarLaTramitacioRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-25T19:08:33.527+02:00")
public class RetornarLaTramitacioApi {
  private ApiClient apiClient;

  public RetornarLaTramitacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RetornarLaTramitacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * RetornarLaTramitacio
   * 
   * @param retornarLaTramitacioRDTO retornarLaTramitacioRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void retornarLaTramitacioUsingPOST(RetornarLaTramitacioRDTO retornarLaTramitacioRDTO) throws ApiException {
    Object localVarPostBody = retornarLaTramitacioRDTO;
    
    // verify the required parameter 'retornarLaTramitacioRDTO' is set
    if (retornarLaTramitacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'retornarLaTramitacioRDTO' when calling retornarLaTramitacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/retornarLaTramitacio";

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