package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-27T11:58:05.753+02:00")
public class DocumentacioRequeritApi {
  private ApiClient apiClient;

  public DocumentacioRequeritApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DocumentacioRequeritApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * returns the required documentation for the documentation of a expedient
   * 
   * @param idDoc idDoc (required)
   * @return List&lt;ConfDocEntradaRequeritRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ConfDocEntradaRequeritRDTO> cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal idDoc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDoc' is set
    if (idDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idDoc' when calling cercaConfiguracioDocumentacioEntradaRequerida");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/docsEntradaRequerit/{idDoc}"
      .replaceAll("\\{" + "idDoc" + "\\}", apiClient.escapeString(idDoc.toString()));

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

    GenericType<List<ConfDocEntradaRequeritRDTO>> localVarReturnType = new GenericType<List<ConfDocEntradaRequeritRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
