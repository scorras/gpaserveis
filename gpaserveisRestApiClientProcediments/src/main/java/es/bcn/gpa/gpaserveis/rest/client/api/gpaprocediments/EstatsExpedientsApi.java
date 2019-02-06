package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.CompetenciesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.EstatsExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RecursosRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T01:52:21.804+01:00")
public class EstatsExpedientsApi {
  private ApiClient apiClient;

  public EstatsExpedientsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EstatsExpedientsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the estats expedients
   * 
   * @return List&lt;CompetenciesRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<CompetenciesRDTO> getCompetenciesUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/catalog/competencies";

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

    GenericType<List<CompetenciesRDTO>> localVarReturnType = new GenericType<List<CompetenciesRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the estats expedients
   * 
   * @return List&lt;EstatsExpedientsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<EstatsExpedientsRDTO> getEstatsExpedientsUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/catalog/estatsExpedients";

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

    GenericType<List<EstatsExpedientsRDTO>> localVarReturnType = new GenericType<List<EstatsExpedientsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the estats expedients
   * 
   * @return List&lt;RecursosRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<RecursosRDTO> getRecursosUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/catalog/recursos";

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

    GenericType<List<RecursosRDTO>> localVarReturnType = new GenericType<List<RecursosRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
