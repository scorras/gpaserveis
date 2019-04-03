package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-03T18:17:51.243+02:00")
public class DadesOperacioApi {
  private ApiClient apiClient;

  public DadesOperacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DadesOperacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Deletes the requested dades operacio list
   * 
   * @param idList idList (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteDadesOperacioUsingPOST(List<BigDecimal> idList) throws ApiException {
    Object localVarPostBody = idList;
    
    // verify the required parameter 'idList' is set
    if (idList == null) {
      throw new ApiException(400, "Missing the required parameter 'idList' when calling deleteDadesOperacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/dadesOperacions/delete";

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
   * Inserts the provided dadesOperacio
   * 
   * @param dadesOperacionsRDTO dadesOperacionsRDTO (required)
   * @param dir  (optional)
   * @param sort  (optional)
   * @return PageDataOfDadesOperacionsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDadesOperacionsRDTO saveDadesOperacioUsingPOST(DadesOperacionsRDTO dadesOperacionsRDTO, String dir, String sort) throws ApiException {
    Object localVarPostBody = dadesOperacionsRDTO;
    
    // verify the required parameter 'dadesOperacionsRDTO' is set
    if (dadesOperacionsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'dadesOperacionsRDTO' when calling saveDadesOperacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/saveDadesOperacio";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
