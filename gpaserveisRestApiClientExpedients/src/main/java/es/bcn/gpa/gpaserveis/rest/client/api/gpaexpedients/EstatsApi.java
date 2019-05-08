package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviEstatRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DropdownItemRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-08T14:08:13.234+02:00")
public class EstatsApi {
  private ApiClient apiClient;

  public EstatsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EstatsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns the historic of states through which the expedient has passed
   * 
   * @param idExpedient idExpedient (required)
   * @return List&lt;EstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<EstatsRDTO> cercaHistoricsEstats(BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling cercaHistoricsEstats");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/estats/{idExpedient}/historics"
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

    GenericType<List<EstatsRDTO>> localVarReturnType = new GenericType<List<EstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested estats
   * 
   * @param idExpedient idExpedient (required)
   * @return CanviEstatRDTO
   * @throws ApiException if fails to make API call
   */
  public CanviEstatRDTO getEstatsByIdExpedientUsingGET(BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling getEstatsByIdExpedientUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/estats/{idExpedient}"
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

    GenericType<CanviEstatRDTO> localVarReturnType = new GenericType<CanviEstatRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested estats
   * 
   * @param accioEstatIdext accioEstatIdext (required)
   * @return List&lt;DropdownItemRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DropdownItemRDTO> getOperacionsByAccioEstatIdextUsingGET(BigDecimal accioEstatIdext) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'accioEstatIdext' is set
    if (accioEstatIdext == null) {
      throw new ApiException(400, "Missing the required parameter 'accioEstatIdext' when calling getOperacionsByAccioEstatIdextUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/operacions/{accioEstatIdext}"
      .replaceAll("\\{" + "accioEstatIdext" + "\\}", apiClient.escapeString(accioEstatIdext.toString()));

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

    GenericType<List<DropdownItemRDTO>> localVarReturnType = new GenericType<List<DropdownItemRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
