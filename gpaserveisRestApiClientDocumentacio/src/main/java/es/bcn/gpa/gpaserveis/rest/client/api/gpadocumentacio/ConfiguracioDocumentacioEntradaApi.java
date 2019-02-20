package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-20T14:00:48.668+01:00")
public class ConfiguracioDocumentacioEntradaApi {
  private ApiClient apiClient;

  public ConfiguracioDocumentacioEntradaApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConfiguracioDocumentacioEntradaApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * create the doc entrada
   * 
   * @param docEntrada docEntrada (required)
   * @return ConfiguracioDocsEntradaResponse
   * @throws ApiException if fails to make API call
   */
  public ConfiguracioDocsEntradaResponse createDocumentacioEntradaUsingPOST(ConfiguracioDocsEntradaRDTO docEntrada) throws ApiException {
    Object localVarPostBody = docEntrada;
    
    // verify the required parameter 'docEntrada' is set
    if (docEntrada == null) {
      throw new ApiException(400, "Missing the required parameter 'docEntrada' when calling createDocumentacioEntradaUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/docEntrada";

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

    GenericType<ConfiguracioDocsEntradaResponse> localVarReturnType = new GenericType<ConfiguracioDocsEntradaResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
