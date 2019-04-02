package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-02T16:38:17.843+02:00")
public class DadesOperacionsApi {
  private ApiClient apiClient;

  public DadesOperacionsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DadesOperacionsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the dades operacions entries for the procedure
   * 
   * @param idsDadesOperList idsDadesOperList (required)
   * @return List&lt;DadesOperacionsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DadesOperacionsRDTO> getDadesOperacionsListUsingGET(String idsDadesOperList) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idsDadesOperList' is set
    if (idsDadesOperList == null) {
      throw new ApiException(400, "Missing the required parameter 'idsDadesOperList' when calling getDadesOperacionsListUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/dadesOperacio/{idsDadesOperList}"
      .replaceAll("\\{" + "idsDadesOperList" + "\\}", apiClient.escapeString(idsDadesOperList.toString()));

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

    GenericType<List<DadesOperacionsRDTO>> localVarReturnType = new GenericType<List<DadesOperacionsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the dades operacions entries for the procedure
   * 
   * @param id id (required)
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dir  (optional)
   * @param nextPageNumber  (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @return PageDataOfDadesOperacionsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDadesOperacionsRDTO getDadesOperacionsRequeritUsingGET(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDadesOperacionsRequeritUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}/dadesOperRequerit"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the dades operacions entries for the procedure
   * 
   * @param id id (required)
   * @param idsJaExisteix idsJaExisteix (required)
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dir  (optional)
   * @param nextPageNumber  (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @return PageDataOfDadesOperacionsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDadesOperacionsRDTO getDadesOperacionsRequeritWithIdsUsingGET(BigDecimal id, String idsJaExisteix, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDadesOperacionsRequeritWithIdsUsingGET");
    }
    
    // verify the required parameter 'idsJaExisteix' is set
    if (idsJaExisteix == null) {
      throw new ApiException(400, "Missing the required parameter 'idsJaExisteix' when calling getDadesOperacionsRequeritWithIdsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}/dadesOperRequerit/{idsJaExisteix}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "idsJaExisteix" + "\\}", apiClient.escapeString(idsJaExisteix.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the dades operacions entries for the procedure
   * 
   * @param id id (required)
   * @param dir  (optional)
   * @param sort  (optional)
   * @return PageDataOfDadesOperacionsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDadesOperacionsRDTO getDadesOperacionsUsingGET1(BigDecimal id, String dir, String sort) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDadesOperacionsUsingGET1");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}/dades"
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

    GenericType<PageDataOfDadesOperacionsRDTO> localVarReturnType = new GenericType<PageDataOfDadesOperacionsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
