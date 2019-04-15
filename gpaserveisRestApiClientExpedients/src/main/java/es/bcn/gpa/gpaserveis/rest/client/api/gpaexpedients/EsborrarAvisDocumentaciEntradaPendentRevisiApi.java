package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EsborrarAvisDocEntradaPendentRevisio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-15T18:01:19.219+02:00")
public class EsborrarAvisDocumentaciEntradaPendentRevisiApi {
  private ApiClient apiClient;

  public EsborrarAvisDocumentaciEntradaPendentRevisiApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EsborrarAvisDocumentaciEntradaPendentRevisiApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Esborrar Avis Documentació Entrada Pendent Revisió
   * 
   * @param esborrarAvisDocEntradaPendentRevisioRDTO esborrarAvisDocEntradaPendentRevisioRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void esborrarAvisDocEntradaPendentRevisioUsingPOST(EsborrarAvisDocEntradaPendentRevisio esborrarAvisDocEntradaPendentRevisioRDTO) throws ApiException {
    Object localVarPostBody = esborrarAvisDocEntradaPendentRevisioRDTO;
    
    // verify the required parameter 'esborrarAvisDocEntradaPendentRevisioRDTO' is set
    if (esborrarAvisDocEntradaPendentRevisioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'esborrarAvisDocEntradaPendentRevisioRDTO' when calling esborrarAvisDocEntradaPendentRevisioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/avisos/esborrarAvisDocEntradaPendentRevisio";

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
