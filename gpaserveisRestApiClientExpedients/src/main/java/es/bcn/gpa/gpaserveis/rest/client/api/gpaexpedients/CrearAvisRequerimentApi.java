package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearAvisRequeriment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-03T18:51:19.536+02:00")
public class CrearAvisRequerimentApi {
  private ApiClient apiClient;

  public CrearAvisRequerimentApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CrearAvisRequerimentApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Crear Avis Requeriment
   * 
   * @param crearAvisRequerimentRDTO crearAvisRequerimentRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void crearAvisRequerimentUsingPOST(CrearAvisRequeriment crearAvisRequerimentRDTO) throws ApiException {
    Object localVarPostBody = crearAvisRequerimentRDTO;
    
    // verify the required parameter 'crearAvisRequerimentRDTO' is set
    if (crearAvisRequerimentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'crearAvisRequerimentRDTO' when calling crearAvisRequerimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/avisos/crearAvisRequeriment";

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
