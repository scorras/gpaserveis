package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComarquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RelacioPersonaRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T09:42:46.833+01:00")
public class ComarquesApi {
  private ApiClient apiClient;

  public ComarquesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ComarquesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the comarquesProvincia
   * 
   * @param idProvincia idProvincia (required)
   * @return List&lt;RelacioPersonaRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<RelacioPersonaRDTO> getComarquesProvinciaUsingGET(String idProvincia) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProvincia' is set
    if (idProvincia == null) {
      throw new ApiException(400, "Missing the required parameter 'idProvincia' when calling getComarquesProvinciaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/catalog/comarques/{idProvincia}"
      .replaceAll("\\{" + "idProvincia" + "\\}", apiClient.escapeString(idProvincia.toString()));

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
  /**
   * Returns all the comarques
   * 
   * @return List&lt;ComarquesRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ComarquesRDTO> getComarquesUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/expedients/catalog/comarques";

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

    GenericType<List<ComarquesRDTO>> localVarReturnType = new GenericType<List<ComarquesRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
