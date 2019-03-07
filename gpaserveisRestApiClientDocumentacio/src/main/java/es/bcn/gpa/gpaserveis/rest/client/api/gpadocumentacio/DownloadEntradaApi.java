package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.InputStreamResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T18:07:53.693+01:00")
public class DownloadEntradaApi {
  private ApiClient apiClient;

  public DownloadEntradaApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DownloadEntradaApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * download the fileEntrada
   * 
   * @param idDoc idDoc (required)
   * @param idExpedient idExpedient (required)
   * @return InputStreamResource
   * @throws ApiException if fails to make API call
   */
  public InputStreamResource downloadFileEntradaUsingGET(BigDecimal idDoc, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDoc' is set
    if (idDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idDoc' when calling downloadFileEntradaUsingGET");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling downloadFileEntradaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/downloadFileEntrada/{idExpedient}/{idDoc}"
      .replaceAll("\\{" + "idDoc" + "\\}", apiClient.escapeString(idDoc.toString()))
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

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

    GenericType<InputStreamResource> localVarReturnType = new GenericType<InputStreamResource>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
