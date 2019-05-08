package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaDocumentacioVinculadaCompletaRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-08T10:20:12.289+02:00")
public class DocumentacioVinculadaCompletaApi {
  private ApiClient apiClient;

  public DocumentacioVinculadaCompletaApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DocumentacioVinculadaCompletaApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns DocumentacioVinculadaCompleta
   * 
   * @param idConfiguracioDocumentacio idConfiguracioDocumentacio (required)
   * @return RespostaDocumentacioVinculadaCompletaRDTO
   * @throws ApiException if fails to make API call
   */
  public RespostaDocumentacioVinculadaCompletaRDTO obtenirDocumentacioVinculadaCompletaUsingGET(BigDecimal idConfiguracioDocumentacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idConfiguracioDocumentacio' is set
    if (idConfiguracioDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfiguracioDocumentacio' when calling obtenirDocumentacioVinculadaCompletaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/documentacioVinculadaCompleta/{idConfiguracioDocumentacio}"
      .replaceAll("\\{" + "idConfiguracioDocumentacio" + "\\}", apiClient.escapeString(idConfiguracioDocumentacio.toString()));

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

    GenericType<RespostaDocumentacioVinculadaCompletaRDTO> localVarReturnType = new GenericType<RespostaDocumentacioVinculadaCompletaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
