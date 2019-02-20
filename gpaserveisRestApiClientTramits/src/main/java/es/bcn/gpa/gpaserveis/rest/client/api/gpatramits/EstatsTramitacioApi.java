package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.RestClientResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-19T18:19:09.667+01:00")
public class EstatsTramitacioApi {
  private ApiClient apiClient;

  public EstatsTramitacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EstatsTramitacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Generar estats de tramitacio per al procediment sol licitat
   * 
   * @param idProcediment idProcediment (required)
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse generaEstatsTramitacioUsingPOST(BigDecimal idProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling generaEstatsTramitacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/estatsTramitacio/{idProcediment}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<RestClientResponse> localVarReturnType = new GenericType<RestClientResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
