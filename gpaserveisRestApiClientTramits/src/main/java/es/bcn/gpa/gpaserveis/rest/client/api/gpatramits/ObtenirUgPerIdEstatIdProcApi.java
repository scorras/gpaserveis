package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T03:58:39.261+02:00")
public class ObtenirUgPerIdEstatIdProcApi {
  private ApiClient apiClient;

  public ObtenirUgPerIdEstatIdProcApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ObtenirUgPerIdEstatIdProcApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * ObtenirUGPerIdEstatIdProc
   * 
   * @param idEstat idEstat (required)
   * @param idProcediment idProcediment (required)
   * @return BigDecimal
   * @throws ApiException if fails to make API call
   */
  public BigDecimal obtenirUGPerIdEstatIdProcUsingGET(BigDecimal idEstat, BigDecimal idProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idEstat' is set
    if (idEstat == null) {
      throw new ApiException(400, "Missing the required parameter 'idEstat' when calling obtenirUGPerIdEstatIdProcUsingGET");
    }
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling obtenirUGPerIdEstatIdProcUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/obtenirUGPerIdEstatIdProc/{idEstat}/{idProcediment}"
      .replaceAll("\\{" + "idEstat" + "\\}", apiClient.escapeString(idEstat.toString()))
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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

    GenericType<BigDecimal> localVarReturnType = new GenericType<BigDecimal>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
