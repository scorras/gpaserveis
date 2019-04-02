package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.EstatsProcedimentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.TransicionsEstatsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T16:38:17.843+02:00")
public class EstatsProcedimentApi {
  private ApiClient apiClient;

  public EstatsProcedimentApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EstatsProcedimentApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get all versions of the provided codi
   * 
   * @param id id (required)
   * @return EstatsProcedimentRDTO
   * @throws ApiException if fails to make API call
   */
  public EstatsProcedimentRDTO getEstatsAnteriorProcedimentUsingGET(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getEstatsAnteriorProcedimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/estatsAnteriorProcediment/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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

    GenericType<EstatsProcedimentRDTO> localVarReturnType = new GenericType<EstatsProcedimentRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get all versions of the provided codi
   * 
   * @param estatProcediment estatProcediment (required)
   * @return List&lt;TransicionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TransicionsEstatsRDTO> getTransicionsEstatsByEstatProcUsingGET(BigDecimal estatProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'estatProcediment' is set
    if (estatProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'estatProcediment' when calling getTransicionsEstatsByEstatProcUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/estatsProcCanviEstat/{estatProcediment}"
      .replaceAll("\\{" + "estatProcediment" + "\\}", apiClient.escapeString(estatProcediment.toString()));

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

    GenericType<List<TransicionsEstatsRDTO>> localVarReturnType = new GenericType<List<TransicionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
