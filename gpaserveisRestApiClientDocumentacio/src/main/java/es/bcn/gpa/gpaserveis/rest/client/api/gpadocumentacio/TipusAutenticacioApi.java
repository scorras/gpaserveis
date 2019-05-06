package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusAutenticacioRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-06T11:28:11.327+02:00")
public class TipusAutenticacioApi {
  private ApiClient apiClient;

  public TipusAutenticacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TipusAutenticacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the tipusAutenticacios
   * 
   * @return List&lt;TipusAutenticacioRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TipusAutenticacioRDTO> getTipusAutenticacioUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/documentacio/catalog/tipusAutenticacio";

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

    GenericType<List<TipusAutenticacioRDTO>> localVarReturnType = new GenericType<List<TipusAutenticacioRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
