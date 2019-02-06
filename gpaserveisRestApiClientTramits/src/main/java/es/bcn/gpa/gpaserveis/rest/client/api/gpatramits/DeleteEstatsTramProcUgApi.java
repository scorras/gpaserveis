package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T01:52:41.089+01:00")
public class DeleteEstatsTramProcUgApi {
  private ApiClient apiClient;

  public DeleteEstatsTramProcUgApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DeleteEstatsTramProcUgApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Deletes the requested estats tramitacio
   * 
   * @param idProcediment idProcediment (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteEstatsTramProcUgUsingDELETE(BigDecimal idProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling deleteEstatsTramProcUgUsingDELETE");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/deleteEstatsTramProcUg/{idProcediment}"
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
