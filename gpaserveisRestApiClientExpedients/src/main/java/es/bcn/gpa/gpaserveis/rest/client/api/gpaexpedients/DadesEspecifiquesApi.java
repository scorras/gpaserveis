package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T18:12:02.441+02:00")
public class DadesEspecifiquesApi {
  private ApiClient apiClient;

  public DadesEspecifiquesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DadesEspecifiquesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns the requested dades especifiques
   * 
   * @param idExpedient idExpedient (required)
   * @return List&lt;DadesEspecifiquesRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DadesEspecifiquesRDTO> consultarDadesEspecifiquesExpedient(BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling consultarDadesEspecifiquesExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/dadesEspecifiques/{idExpedient}"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

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

    GenericType<List<DadesEspecifiquesRDTO>> localVarReturnType = new GenericType<List<DadesEspecifiquesRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Insert  or updates the provided dades especifiques
   * 
   * @param dadesEspecifiquesRDTOList dadesEspecifiquesRDTOList (required)
   * @throws ApiException if fails to make API call
   */
  public void saveOrUpdateUsingPOST(List<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList) throws ApiException {
    Object localVarPostBody = dadesEspecifiquesRDTOList;
    
    // verify the required parameter 'dadesEspecifiquesRDTOList' is set
    if (dadesEspecifiquesRDTOList == null) {
      throw new ApiException(400, "Missing the required parameter 'dadesEspecifiquesRDTOList' when calling saveOrUpdateUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/dadesEspecifiques";

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
