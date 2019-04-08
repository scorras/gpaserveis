package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T18:54:04.705+02:00")
public class DadesGrupsApi {
  private ApiClient apiClient;

  public DadesGrupsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DadesGrupsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the grups entries for the procedure
   * 
   * @param id id (required)
   * @param dir  (optional)
   * @param sort  (optional)
   * @return PageDataOfDadesGrupsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDadesGrupsRDTO cercaDadesOperacio(BigDecimal id, String dir, String sort) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling cercaDadesOperacio");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}/grups"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfDadesGrupsRDTO> localVarReturnType = new GenericType<PageDataOfDadesGrupsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the grups entries for the procedure
   * 
   * @param id id (required)
   * @param idTramitOvt idTramitOvt (required)
   * @param dir  (optional)
   * @param sort  (optional)
   * @return PageDataOfDadesGrupsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDadesGrupsRDTO cercaDadesOperacioAgrupatsPerTramitOvt(BigDecimal id, BigDecimal idTramitOvt, String dir, String sort) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling cercaDadesOperacioAgrupatsPerTramitOvt");
    }
    
    // verify the required parameter 'idTramitOvt' is set
    if (idTramitOvt == null) {
      throw new ApiException(400, "Missing the required parameter 'idTramitOvt' when calling cercaDadesOperacioAgrupatsPerTramitOvt");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}/grups/{idTramitOvt}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "idTramitOvt" + "\\}", apiClient.escapeString(idTramitOvt.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfDadesGrupsRDTO> localVarReturnType = new GenericType<PageDataOfDadesGrupsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the dades operacions entries for the procedure
   * 
   * @param id id (required)
   * @return List&lt;DadesGrupsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DadesGrupsRDTO> getDadesGrupsWithDadesOperacioUsingGET(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDadesGrupsWithDadesOperacioUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}/dadesGrupsWithDadesOperacio"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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

    GenericType<List<DadesGrupsRDTO>> localVarReturnType = new GenericType<List<DadesGrupsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
