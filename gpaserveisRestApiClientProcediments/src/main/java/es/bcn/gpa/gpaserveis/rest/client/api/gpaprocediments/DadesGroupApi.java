package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRelacionatsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T16:38:17.843+02:00")
public class DadesGroupApi {
  private ApiClient apiClient;

  public DadesGroupApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DadesGroupApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Inserts the provided dadesGrup
   * 
   * @param procedimentsRelacionatsRDTOList procedimentsRelacionatsRDTOList (required)
   * @throws ApiException if fails to make API call
   */
  public void associarUsingPOST(List<ProcedimentsRelacionatsRDTO> procedimentsRelacionatsRDTOList) throws ApiException {
    Object localVarPostBody = procedimentsRelacionatsRDTOList;
    
    // verify the required parameter 'procedimentsRelacionatsRDTOList' is set
    if (procedimentsRelacionatsRDTOList == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentsRelacionatsRDTOList' when calling associarUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/associar";

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
   * Inserts the provided dadesGrup
   * 
   * @param procedimentsRelacionatsRDTOList procedimentsRelacionatsRDTOList (required)
   * @throws ApiException if fails to make API call
   */
  public void desassociarUsingPOST(List<ProcedimentsRelacionatsRDTO> procedimentsRelacionatsRDTOList) throws ApiException {
    Object localVarPostBody = procedimentsRelacionatsRDTOList;
    
    // verify the required parameter 'procedimentsRelacionatsRDTOList' is set
    if (procedimentsRelacionatsRDTOList == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentsRelacionatsRDTOList' when calling desassociarUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/desassociar";

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
   * Inserts the provided dadesGrup
   * 
   * @param dadesGrupsRDTO dadesGrupsRDTO (required)
   * @return DadesGrupsRDTO
   * @throws ApiException if fails to make API call
   */
  public DadesGrupsRDTO saveDadesGrupUsingPOST(DadesGrupsRDTO dadesGrupsRDTO) throws ApiException {
    Object localVarPostBody = dadesGrupsRDTO;
    
    // verify the required parameter 'dadesGrupsRDTO' is set
    if (dadesGrupsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'dadesGrupsRDTO' when calling saveDadesGrupUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/saveDadesGrup";

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

    GenericType<DadesGrupsRDTO> localVarReturnType = new GenericType<DadesGrupsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
