package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ActualitzarNotificacionDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-27T11:58:05.753+02:00")
public class NotificacionsApi {
  private ApiClient apiClient;

  public NotificacionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public NotificacionsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * actualitzarNotificacio
   * 
   * @param actualitzarNotificacionDocumentRDTO actualitzarNotificacionDocumentRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void actualitzarNotificacio(ActualitzarNotificacionDocument actualitzarNotificacionDocumentRDTO) throws ApiException {
    Object localVarPostBody = actualitzarNotificacionDocumentRDTO;
    
    // verify the required parameter 'actualitzarNotificacionDocumentRDTO' is set
    if (actualitzarNotificacionDocumentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'actualitzarNotificacionDocumentRDTO' when calling actualitzarNotificacio");
    }
    
    // create path and map variables
    String localVarPath = "/notificacions/actualitzarNotificacio";

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
   * crearNotificacio
   * 
   * @param crearNotificacioRDTO crearNotificacioRDTO (required)
   * @return NotificacionsRDTO
   * @throws ApiException if fails to make API call
   */
  public NotificacionsRDTO crearNotificacio(CrearNotificacio crearNotificacioRDTO) throws ApiException {
    Object localVarPostBody = crearNotificacioRDTO;
    
    // verify the required parameter 'crearNotificacioRDTO' is set
    if (crearNotificacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'crearNotificacioRDTO' when calling crearNotificacio");
    }
    
    // create path and map variables
    String localVarPath = "/notificacions/crearNotificacio";

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

    GenericType<NotificacionsRDTO> localVarReturnType = new GenericType<NotificacionsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
