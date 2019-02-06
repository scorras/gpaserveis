package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.TipusValidacioRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T01:52:21.804+01:00")
public class TipusCampApi {
  private ApiClient apiClient;

  public TipusCampApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TipusCampApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the validacions entries for the camp
   * 
   * @param idTipusCamp idTipusCamp (required)
   * @return List&lt;TipusValidacioRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TipusValidacioRDTO> getValidacionsByIdCampUsingGET(BigDecimal idTipusCamp) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idTipusCamp' is set
    if (idTipusCamp == null) {
      throw new ApiException(400, "Missing the required parameter 'idTipusCamp' when calling getValidacionsByIdCampUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/camp/{idTipusCamp}/validacio"
      .replaceAll("\\{" + "idTipusCamp" + "\\}", apiClient.escapeString(idTipusCamp.toString()));

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

    GenericType<List<TipusValidacioRDTO>> localVarReturnType = new GenericType<List<TipusValidacioRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
