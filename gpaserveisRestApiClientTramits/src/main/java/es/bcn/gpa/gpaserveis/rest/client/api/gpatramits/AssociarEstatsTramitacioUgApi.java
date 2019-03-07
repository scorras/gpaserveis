package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.EstatsProcUgRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T11:09:49.340+01:00")
public class AssociarEstatsTramitacioUgApi {
  private ApiClient apiClient;

  public AssociarEstatsTramitacioUgApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AssociarEstatsTramitacioUgApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Associar unitat gestora a estats de tramitació d&#39;un procediment
   * 
   * @param estatsProcUgRDTOList estatsProcUgRDTOList (required)
   * @throws ApiException if fails to make API call
   */
  public void associarEstatTramProcUgUsingPOST(List<EstatsProcUgRDTO> estatsProcUgRDTOList) throws ApiException {
    Object localVarPostBody = estatsProcUgRDTOList;
    
    // verify the required parameter 'estatsProcUgRDTOList' is set
    if (estatsProcUgRDTOList == null) {
      throw new ApiException(400, "Missing the required parameter 'estatsProcUgRDTOList' when calling associarEstatTramProcUgUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/associarEstatTramProcUg";

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
