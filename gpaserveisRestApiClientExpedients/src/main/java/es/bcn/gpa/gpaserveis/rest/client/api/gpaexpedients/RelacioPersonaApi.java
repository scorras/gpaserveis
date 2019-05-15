package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RelacioPersonaRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-14T18:24:51.718+02:00")
public class RelacioPersonaApi {
  private ApiClient apiClient;

  public RelacioPersonaApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RelacioPersonaApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the relacioPersona
   * 
   * @param esInteressada esInteressada (required)
   * @return List&lt;RelacioPersonaRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<RelacioPersonaRDTO> getRelacioPersonaUsingGET(Integer esInteressada) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'esInteressada' is set
    if (esInteressada == null) {
      throw new ApiException(400, "Missing the required parameter 'esInteressada' when calling getRelacioPersonaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/catalog/relacioPersona/{esInteressada}"
      .replaceAll("\\{" + "esInteressada" + "\\}", apiClient.escapeString(esInteressada.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<RelacioPersonaRDTO>> localVarReturnType = new GenericType<List<RelacioPersonaRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
