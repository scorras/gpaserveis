package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-24T15:03:39.598+02:00")
public class ConfiguracioDocumentacioTramitacioApi {
  private ApiClient apiClient;

  public ConfiguracioDocumentacioTramitacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConfiguracioDocumentacioTramitacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * create the doc config
   * 
   * @param docTramitacio docTramitacio (required)
   * @return ConfiguracioDocsTramitacioResponse
   * @throws ApiException if fails to make API call
   */
  public ConfiguracioDocsTramitacioResponse createDocumentacioTramitacioUsingPOST(ConfiguracioDocsTramitacioRDTO docTramitacio) throws ApiException {
    Object localVarPostBody = docTramitacio;
    
    // verify the required parameter 'docTramitacio' is set
    if (docTramitacio == null) {
      throw new ApiException(400, "Missing the required parameter 'docTramitacio' when calling createDocumentacioTramitacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/docTramitacio";

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

    GenericType<ConfiguracioDocsTramitacioResponse> localVarReturnType = new GenericType<ConfiguracioDocsTramitacioResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
