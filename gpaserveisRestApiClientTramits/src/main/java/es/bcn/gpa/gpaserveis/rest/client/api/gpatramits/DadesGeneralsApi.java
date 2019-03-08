package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-07T11:09:49.340+01:00")
public class DadesGeneralsApi {
  private ApiClient apiClient;

  public DadesGeneralsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DadesGeneralsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Update the provided dadesGenerales to the tramit
   * 
   * @param tramitsRDTO tramitsRDTO (required)
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse updateIdentificacionsUsingPOST(TramitsRDTO tramitsRDTO) throws ApiException {
    Object localVarPostBody = tramitsRDTO;
    
    // verify the required parameter 'tramitsRDTO' is set
    if (tramitsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'tramitsRDTO' when calling updateIdentificacionsUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/dadesGenerals";

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
