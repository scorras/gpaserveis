package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ExpedientOpenTextRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-27T18:14:43.653+02:00")
public class ExpedientsApi {
  private ApiClient apiClient;

  public ExpedientsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ExpedientsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * donar d&#39;alta un expedient en Opentext
   * 
   * @param expedientOpenTextRDTO expedientOpenTextRDTO (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String altaExpedientOpentextUsingPOST(ExpedientOpenTextRDTO expedientOpenTextRDTO) throws ApiException {
    Object localVarPostBody = expedientOpenTextRDTO;
    
    // verify the required parameter 'expedientOpenTextRDTO' is set
    if (expedientOpenTextRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'expedientOpenTextRDTO' when calling altaExpedientOpentextUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/altaExpedientOpentext";

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

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
