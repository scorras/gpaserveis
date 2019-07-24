package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearAvisDocEntradaPendentRevisio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-24T01:06:10.329+02:00")
public class CrearAvisDocumentaciEntradaPendentRevisiApi {
  private ApiClient apiClient;

  public CrearAvisDocumentaciEntradaPendentRevisiApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CrearAvisDocumentaciEntradaPendentRevisiApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Crear Avis Documentació Entrada Pendent Revisió
   * 
   * @param crearAvisDocEntradaPendentRevisioRDTO crearAvisDocEntradaPendentRevisioRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void crearAvisDocEntradaPendentRevisioUsingPOST(CrearAvisDocEntradaPendentRevisio crearAvisDocEntradaPendentRevisioRDTO) throws ApiException {
    Object localVarPostBody = crearAvisDocEntradaPendentRevisioRDTO;
    
    // verify the required parameter 'crearAvisDocEntradaPendentRevisioRDTO' is set
    if (crearAvisDocEntradaPendentRevisioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'crearAvisDocEntradaPendentRevisioRDTO' when calling crearAvisDocEntradaPendentRevisioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/avisos/crearAvisDocEntradaPendentRevisio";

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
   * Crear Avis
   * 
   * @param avisosRDTO avisosRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void crearAvisUsingPOST(AvisosRDTO avisosRDTO) throws ApiException {
    Object localVarPostBody = avisosRDTO;
    
    // verify the required parameter 'avisosRDTO' is set
    if (avisosRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'avisosRDTO' when calling crearAvisUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/avisos/crearAvis";

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
}
