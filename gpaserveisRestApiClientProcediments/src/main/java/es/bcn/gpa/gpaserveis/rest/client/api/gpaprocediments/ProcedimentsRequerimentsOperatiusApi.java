package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T17:18:13.226+02:00")
public class ProcedimentsRequerimentsOperatiusApi {
  private ApiClient apiClient;

  public ProcedimentsRequerimentsOperatiusApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProcedimentsRequerimentsOperatiusApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Inserts the provided Requeriments Operatius to the procediment
   * 
   * @param procedimentsRDTO procedimentsRDTO (required)
   * @return ProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsRDTO updateRequerimentsOperatiusUsingPOST(ProcedimentsRDTO procedimentsRDTO) throws ApiException {
    Object localVarPostBody = procedimentsRDTO;
    
    // verify the required parameter 'procedimentsRDTO' is set
    if (procedimentsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentsRDTO' when calling updateRequerimentsOperatiusUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/requerimentsOperatius";

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

    GenericType<ProcedimentsRDTO> localVarReturnType = new GenericType<ProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
