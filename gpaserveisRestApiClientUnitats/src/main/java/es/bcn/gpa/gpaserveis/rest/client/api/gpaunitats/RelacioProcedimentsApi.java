package es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-21T03:13:50.567+01:00")
public class RelacioProcedimentsApi {
  private ApiClient apiClient;

  public RelacioProcedimentsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RelacioProcedimentsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the unitats Organigrama
   * 
   * @return List&lt;UnitatsOrganigramaRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<UnitatsOrganigramaRDTO> getUnitatsOrganigramaUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/unitats/unitatsOrganigrama";

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

    GenericType<List<UnitatsOrganigramaRDTO>> localVarReturnType = new GenericType<List<UnitatsOrganigramaRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
