package es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaunitats.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import org.joda.time.DateTime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-28T11:16:14.422+01:00")
public class UnitatsGestoresApi {
  private ApiClient apiClient;

  public UnitatsGestoresApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UnitatsGestoresApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Deletes the requested unitats list
   * 
   * @param unitatIdList unitatIdList (required)
   * @throws ApiException if fails to make API call
   */
  public void bulkDeleteUnitatListUsingPOST(List<BigDecimal> unitatIdList) throws ApiException {
    Object localVarPostBody = unitatIdList;
    
    // verify the required parameter 'unitatIdList' is set
    if (unitatIdList == null) {
      throw new ApiException(400, "Missing the required parameter 'unitatIdList' when calling bulkDeleteUnitatListUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/unitats/delete";

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
   * Returns all the unitats that meet the search criteria
   * 
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param codi  (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dataCreacio  (optional)
   * @param dataModificacio  (optional)
   * @param descUnitatOrganigrama  (optional)
   * @param descripcio  (optional)
   * @param dir  (optional)
   * @param id  (optional)
   * @param nextPageNumber  (optional)
   * @param nom  (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @param unitatOrganigrama  (optional)
   * @param vigent  (optional)
   * @return PageDataOfUnitatsGestoresRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfUnitatsGestoresRDTO cercaUnitatsGestores(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String codi, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime dataCreacio, DateTime dataModificacio, String descUnitatOrganigrama, String descripcio, String dir, BigDecimal id, Integer nextPageNumber, String nom, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages, BigDecimal unitatOrganigrama, Integer vigent) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/unitats/search";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "codi", codi));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataCreacio", dataCreacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataModificacio", dataModificacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descUnitatOrganigrama", descUnitatOrganigrama));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descripcio", descripcio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nom", nom));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "unitatOrganigrama", unitatOrganigrama));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "vigent", vigent));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfUnitatsGestoresRDTO> localVarReturnType = new GenericType<PageDataOfUnitatsGestoresRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested unitat
   * 
   * @param id id (required)
   * @return UnitatsGestoresRDTO
   * @throws ApiException if fails to make API call
   */
  public UnitatsGestoresRDTO consultarDadesUnitatGestora(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling consultarDadesUnitatGestora");
    }
    
    // create path and map variables
    String localVarPath = "/unitats/{id}"
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

    GenericType<UnitatsGestoresRDTO> localVarReturnType = new GenericType<UnitatsGestoresRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested unitat
   * 
   * @param codi codi (required)
   * @return UnitatsGestoresRDTO
   * @throws ApiException if fails to make API call
   */
  public UnitatsGestoresRDTO consultarDadesUnitatGestoraPerCodi(String codi) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codi' is set
    if (codi == null) {
      throw new ApiException(400, "Missing the required parameter 'codi' when calling consultarDadesUnitatGestoraPerCodi");
    }
    
    // create path and map variables
    String localVarPath = "/unitats/perCodi/{codi}"
      .replaceAll("\\{" + "codi" + "\\}", apiClient.escapeString(codi.toString()));

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

    GenericType<UnitatsGestoresRDTO> localVarReturnType = new GenericType<UnitatsGestoresRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested unitat
   * 
   * @return List&lt;UnitatsGestoresRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<UnitatsGestoresRDTO> getAllUnitatsGestoresUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/unitats/all";

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

    GenericType<List<UnitatsGestoresRDTO>> localVarReturnType = new GenericType<List<UnitatsGestoresRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the unitats gestores
   * 
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
   * @return PageDataOfUnitatsGestoresRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfUnitatsGestoresRDTO getUnitatsGestoresUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/unitats";

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

    GenericType<PageDataOfUnitatsGestoresRDTO> localVarReturnType = new GenericType<PageDataOfUnitatsGestoresRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Insert  or updates the provided unitat
   * 
   * @param unitatsGestoresRDTO unitatsGestoresRDTO (required)
   * @return UnitatsGestoresRDTO
   * @throws ApiException if fails to make API call
   */
  public UnitatsGestoresRDTO saveOrUpdateUsingPOST(UnitatsGestoresRDTO unitatsGestoresRDTO) throws ApiException {
    Object localVarPostBody = unitatsGestoresRDTO;
    
    // verify the required parameter 'unitatsGestoresRDTO' is set
    if (unitatsGestoresRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'unitatsGestoresRDTO' when calling saveOrUpdateUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/unitats";

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

    GenericType<UnitatsGestoresRDTO> localVarReturnType = new GenericType<UnitatsGestoresRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Selects the requested unitats list
   * 
   * @param unitatIdList unitatIdList (required)
   * @return List&lt;UnitatsGestoresRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<UnitatsGestoresRDTO> selectUnitatListUsingPOST(List<BigDecimal> unitatIdList) throws ApiException {
    Object localVarPostBody = unitatIdList;
    
    // verify the required parameter 'unitatIdList' is set
    if (unitatIdList == null) {
      throw new ApiException(400, "Missing the required parameter 'unitatIdList' when calling selectUnitatListUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/unitats/list";

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

    GenericType<List<UnitatsGestoresRDTO>> localVarReturnType = new GenericType<List<UnitatsGestoresRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
