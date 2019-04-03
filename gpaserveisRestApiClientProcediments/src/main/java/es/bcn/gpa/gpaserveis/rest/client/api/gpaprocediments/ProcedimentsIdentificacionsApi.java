package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RestClientResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-03T18:17:51.243+02:00")
public class ProcedimentsIdentificacionsApi {
  private ApiClient apiClient;

  public ProcedimentsIdentificacionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProcedimentsIdentificacionsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Inserts the provided identificacions to the procediment
   * 
   * @param procedimentsRDTO procedimentsRDTO (required)
   * @param tipo tipo (optional)
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse updateIdentificacionsUsingPOST(ProcedimentsRDTO procedimentsRDTO, Integer tipo) throws ApiException {
    Object localVarPostBody = procedimentsRDTO;
    
    // verify the required parameter 'procedimentsRDTO' is set
    if (procedimentsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentsRDTO' when calling updateIdentificacionsUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/identificacions";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tipo", tipo));

    
    
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
