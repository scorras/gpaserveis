package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ProcedimentSerieDocRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSincronitzarCheckRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSincronitzarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SerieDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-25T11:59:46.009+02:00")
public class SeriesCatalegApi {
  private ApiClient apiClient;

  public SeriesCatalegApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SeriesCatalegApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Sincronitzar la configuració de la documentació del procediment
   * 
   * @param serieDocumental serieDocumental (required)
   * @return RespostaSincronitzarCheckRDTO
   * @throws ApiException if fails to make API call
   */
  public RespostaSincronitzarCheckRDTO checkSerieDocumentalUsingGET(String serieDocumental) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'serieDocumental' is set
    if (serieDocumental == null) {
      throw new ApiException(400, "Missing the required parameter 'serieDocumental' when calling checkSerieDocumentalUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/serie/{serieDocumental}"
      .replaceAll("\\{" + "serieDocumental" + "\\}", apiClient.escapeString(serieDocumental.toString()));

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

    GenericType<RespostaSincronitzarCheckRDTO> localVarReturnType = new GenericType<RespostaSincronitzarCheckRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the series
   * 
   * @return List&lt;SerieDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<SerieDTO> getSeriesUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/series";

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

    GenericType<List<SerieDTO>> localVarReturnType = new GenericType<List<SerieDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Sincronitzar la configuració de la documentació del procediment
   * 
   * @param procedimentSerieDocRDTO procedimentSerieDocRDTO (required)
   * @return RespostaSincronitzarRDTO
   * @throws ApiException if fails to make API call
   */
  public RespostaSincronitzarRDTO sincronitzarSeriesToProcUsingPOST(ProcedimentSerieDocRDTO procedimentSerieDocRDTO) throws ApiException {
    Object localVarPostBody = procedimentSerieDocRDTO;
    
    // verify the required parameter 'procedimentSerieDocRDTO' is set
    if (procedimentSerieDocRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentSerieDocRDTO' when calling sincronitzarSeriesToProcUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/sincronitzarSeriesToProc";

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

    GenericType<RespostaSincronitzarRDTO> localVarReturnType = new GenericType<RespostaSincronitzarRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Sincronitzar la configuració de la documentació del procediment
   * 
   * @param procedimentSerieDocRDTO procedimentSerieDocRDTO (required)
   * @return RespostaSincronitzarRDTO
   * @throws ApiException if fails to make API call
   */
  public RespostaSincronitzarRDTO sincronitzarUsingPOST(ProcedimentSerieDocRDTO procedimentSerieDocRDTO) throws ApiException {
    Object localVarPostBody = procedimentSerieDocRDTO;
    
    // verify the required parameter 'procedimentSerieDocRDTO' is set
    if (procedimentSerieDocRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentSerieDocRDTO' when calling sincronitzarUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/sincronitzar";

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

    GenericType<RespostaSincronitzarRDTO> localVarReturnType = new GenericType<RespostaSincronitzarRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
