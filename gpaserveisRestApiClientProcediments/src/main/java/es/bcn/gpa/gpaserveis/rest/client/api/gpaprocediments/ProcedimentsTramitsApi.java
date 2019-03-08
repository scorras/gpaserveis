package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsTramitsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T17:22:31.104+01:00")
public class ProcedimentsTramitsApi {
  private ApiClient apiClient;

  public ProcedimentsTramitsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProcedimentsTramitsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Inserts the provided tramits for procediment
   * 
   * @param procedimentsTramitsRDTOList procedimentsTramitsRDTOList (required)
   * @throws ApiException if fails to make API call
   */
  public void associarUsingPOST1(List<ProcedimentsTramitsRDTO> procedimentsTramitsRDTOList) throws ApiException {
    Object localVarPostBody = procedimentsTramitsRDTOList;
    
    // verify the required parameter 'procedimentsTramitsRDTOList' is set
    if (procedimentsTramitsRDTOList == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentsTramitsRDTOList' when calling associarUsingPOST1");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/tramits/associar";

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
  /**
   * Removes the provided tramits from procediment
   * 
   * @param procedimentsTramitsRDTOList procedimentsTramitsRDTOList (required)
   * @throws ApiException if fails to make API call
   */
  public void desassociarUsingPOST1(List<ProcedimentsTramitsRDTO> procedimentsTramitsRDTOList) throws ApiException {
    Object localVarPostBody = procedimentsTramitsRDTOList;
    
    // verify the required parameter 'procedimentsTramitsRDTOList' is set
    if (procedimentsTramitsRDTOList == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentsTramitsRDTOList' when calling desassociarUsingPOST1");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/tramits/desassociar";

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
  /**
   * Returns all the tramits for the procedure that meet the search criteria
   * 
   * @param id id (required)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> tramitsForProcedimentUsingGET(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling tramitsForProcedimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/tramits/{id}"
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

    GenericType<List<BigDecimal>> localVarReturnType = new GenericType<List<BigDecimal>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
