package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T01:52:41.089+01:00")
public class AccionsEstatsApi {
  private ApiClient apiClient;

  public AccionsEstatsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AccionsEstatsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns the accio estat inicial
   * 
   * @return BigDecimal
   * @throws ApiException if fails to make API call
   */
  public BigDecimal getAccioEstatInicialUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/tramits/accioEstatInicial";

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
  /**
   * Returns all the accions estats descs
   * 
   * @param estatsIds estatsIds (required)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> getAccioEstatsByEstatUsingPOST(List<BigDecimal> estatsIds) throws ApiException {
    Object localVarPostBody = estatsIds;
    
    // verify the required parameter 'estatsIds' is set
    if (estatsIds == null) {
      throw new ApiException(400, "Missing the required parameter 'estatsIds' when calling getAccioEstatsByEstatUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/accioEstatsByEstat";

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

    GenericType<List<BigDecimal>> localVarReturnType = new GenericType<List<BigDecimal>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the accion estats to transit
   * 
   * @param accioEstatId accioEstatId (required)
   * @return List&lt;AccionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AccionsEstatsRDTO> getAccionsEstatsForDocumentacioAportadaUsingGET(BigDecimal accioEstatId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accioEstatId' is set
    if (accioEstatId == null) {
      throw new ApiException(400, "Missing the required parameter 'accioEstatId' when calling getAccionsEstatsForDocumentacioAportadaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/accionsEstatsForDocumentacioAportada/{accioEstatId}"
      .replaceAll("\\{" + "accioEstatId" + "\\}", apiClient.escapeString(accioEstatId.toString()));

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

    GenericType<List<AccionsEstatsRDTO>> localVarReturnType = new GenericType<List<AccionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the accion estats to transit
   * 
   * @param accioEstatId accioEstatId (required)
   * @return List&lt;AccionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AccionsEstatsRDTO> getAccionsEstatsForDocumentacioGeneradaUsingGET(BigDecimal accioEstatId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accioEstatId' is set
    if (accioEstatId == null) {
      throw new ApiException(400, "Missing the required parameter 'accioEstatId' when calling getAccionsEstatsForDocumentacioGeneradaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/accionsEstatsForDocumentacioGenerada/{accioEstatId}"
      .replaceAll("\\{" + "accioEstatId" + "\\}", apiClient.escapeString(accioEstatId.toString()));

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

    GenericType<List<AccionsEstatsRDTO>> localVarReturnType = new GenericType<List<AccionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the accion estats to transit
   * 
   * @param accioEstatId accioEstatId (required)
   * @return List&lt;AccionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AccionsEstatsRDTO> getAccionsEstatsForDocumentacioTramitacioUsingGET(BigDecimal accioEstatId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accioEstatId' is set
    if (accioEstatId == null) {
      throw new ApiException(400, "Missing the required parameter 'accioEstatId' when calling getAccionsEstatsForDocumentacioTramitacioUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/accionsEstatsForDocumentacioTramitacio/{accioEstatId}"
      .replaceAll("\\{" + "accioEstatId" + "\\}", apiClient.escapeString(accioEstatId.toString()));

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

    GenericType<List<AccionsEstatsRDTO>> localVarReturnType = new GenericType<List<AccionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the accion estats to transit
   * 
   * @param accioEstatId accioEstatId (required)
   * @return List&lt;AccionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AccionsEstatsRDTO> getAccionsEstatsForOperationUsingGET(BigDecimal accioEstatId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accioEstatId' is set
    if (accioEstatId == null) {
      throw new ApiException(400, "Missing the required parameter 'accioEstatId' when calling getAccionsEstatsForOperationUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/accionsEstatsForOperation/{accioEstatId}"
      .replaceAll("\\{" + "accioEstatId" + "\\}", apiClient.escapeString(accioEstatId.toString()));

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

    GenericType<List<AccionsEstatsRDTO>> localVarReturnType = new GenericType<List<AccionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the accion estats to transit
   * 
   * @param accioEstatId accioEstatId (required)
   * @return List&lt;AccionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AccionsEstatsRDTO> getAccionsEstatsForTransitionUsingGET(BigDecimal accioEstatId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accioEstatId' is set
    if (accioEstatId == null) {
      throw new ApiException(400, "Missing the required parameter 'accioEstatId' when calling getAccionsEstatsForTransitionUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/accionsEstatsForTransition/{accioEstatId}"
      .replaceAll("\\{" + "accioEstatId" + "\\}", apiClient.escapeString(accioEstatId.toString()));

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

    GenericType<List<AccionsEstatsRDTO>> localVarReturnType = new GenericType<List<AccionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the accions estats descs
   * 
   * @param accionsEstatsIds accionsEstatsIds (required)
   * @return List&lt;AccionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<AccionsEstatsRDTO> getInfoAccionsEstatsUsingPOST(List<BigDecimal> accionsEstatsIds) throws ApiException {
    Object localVarPostBody = accionsEstatsIds;
    
    // verify the required parameter 'accionsEstatsIds' is set
    if (accionsEstatsIds == null) {
      throw new ApiException(400, "Missing the required parameter 'accionsEstatsIds' when calling getInfoAccionsEstatsUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/infoEstats";

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

    GenericType<List<AccionsEstatsRDTO>> localVarReturnType = new GenericType<List<AccionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
