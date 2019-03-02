package es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-28T11:16:14.422+01:00")
public class UsuarisApi {
  private ApiClient apiClient;

  public UsuarisApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UsuarisApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns the requested usuari
   * 
   * @param matricula matricula (required)
   * @return UsuarisRDTO
   * @throws ApiException if fails to make API call
   */
  public UsuarisRDTO obtenirUsuariPorMatricula(String matricula) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'matricula' is set
    if (matricula == null) {
      throw new ApiException(400, "Missing the required parameter 'matricula' when calling obtenirUsuariPorMatricula");
    }
    
    // create path and map variables
    String localVarPath = "/usuaris/{matricula}"
      .replaceAll("\\{" + "matricula" + "\\}", apiClient.escapeString(matricula.toString()));

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

    GenericType<UsuarisRDTO> localVarReturnType = new GenericType<UsuarisRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
