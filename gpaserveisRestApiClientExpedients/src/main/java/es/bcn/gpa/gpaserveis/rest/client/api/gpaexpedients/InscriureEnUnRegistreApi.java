package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.InscriureEnRegistreRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-18T17:48:56.871+02:00")
public class InscriureEnUnRegistreApi {
  private ApiClient apiClient;

  public InscriureEnUnRegistreApi() {
    this(Configuration.getDefaultApiClient());
  }

  public InscriureEnUnRegistreApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * inscriureEnRegistre
   * 
   * @param inscriureEnRegistreRDTO inscriureEnRegistreRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void inscriureEnRegistre(InscriureEnRegistreRDTO inscriureEnRegistreRDTO) throws ApiException {
    Object localVarPostBody = inscriureEnRegistreRDTO;
    
    // verify the required parameter 'inscriureEnRegistreRDTO' is set
    if (inscriureEnRegistreRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'inscriureEnRegistreRDTO' when calling inscriureEnRegistre");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/inscriureEnRegistre";

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
