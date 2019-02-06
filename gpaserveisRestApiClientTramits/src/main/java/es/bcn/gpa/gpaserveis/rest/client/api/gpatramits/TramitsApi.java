package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import org.joda.time.DateTime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-04T01:52:41.089+01:00")
public class TramitsApi {
  private ApiClient apiClient;

  public TramitsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TramitsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns all the tramits that meet the search criteria
   * 
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param darreraModificacio  (optional)
   * @param dataGestioElectronica  (optional)
   * @param descripcio  (optional)
   * @param dir  (optional)
   * @param esTramitIniciacio  (optional)
   * @param exclusiuIntern  (optional)
   * @param gestioElectronica  (optional)
   * @param id  (optional)
   * @param informacioTramitador  (optional)
   * @param nextPageNumber  (optional)
   * @param nom  (optional)
   * @param normaAltresAplicacio  (optional)
   * @param normaReferenciaPrincipal  (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param rolUsuari  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @param ultimaModificacio  (optional)
   * @return PageDataOfTramitsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfTramitsRDTO cercaTramits(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime darreraModificacio, DateTime dataGestioElectronica, String descripcio, String dir, Integer esTramitIniciacio, Integer exclusiuIntern, String gestioElectronica, BigDecimal id, String informacioTramitador, Integer nextPageNumber, String nom, String normaAltresAplicacio, String normaReferenciaPrincipal, Integer pageSize, Integer previousPageNumber, String rolUsuari, String sort, Long totalElements, Integer totalPages, BigDecimal ultimaModificacio) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/tramits/search";

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
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "darreraModificacio", darreraModificacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataGestioElectronica", dataGestioElectronica));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descripcio", descripcio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "esTramitIniciacio", esTramitIniciacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "exclusiuIntern", exclusiuIntern));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "gestioElectronica", gestioElectronica));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "informacioTramitador", informacioTramitador));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nom", nom));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "normaAltresAplicacio", normaAltresAplicacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "normaReferenciaPrincipal", normaReferenciaPrincipal));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rolUsuari", rolUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ultimaModificacio", ultimaModificacio));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfTramitsRDTO> localVarReturnType = new GenericType<PageDataOfTramitsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the tramits that meet the search criteria and are associated with a procediment
   * 
   * @param idProcediment idProcediment (required)
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param darreraModificacio  (optional)
   * @param dataGestioElectronica  (optional)
   * @param descripcio  (optional)
   * @param dir  (optional)
   * @param esTramitIniciacio  (optional)
   * @param exclusiuIntern  (optional)
   * @param gestioElectronica  (optional)
   * @param id  (optional)
   * @param informacioTramitador  (optional)
   * @param nextPageNumber  (optional)
   * @param nom  (optional)
   * @param normaAltresAplicacio  (optional)
   * @param normaReferenciaPrincipal  (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param rolUsuari  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @param ultimaModificacio  (optional)
   * @return PageDataOfTramitsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfTramitsRDTO cercaTramitsProcediment(BigDecimal idProcediment, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime darreraModificacio, DateTime dataGestioElectronica, String descripcio, String dir, Integer esTramitIniciacio, Integer exclusiuIntern, String gestioElectronica, BigDecimal id, String informacioTramitador, Integer nextPageNumber, String nom, String normaAltresAplicacio, String normaReferenciaPrincipal, Integer pageSize, Integer previousPageNumber, String rolUsuari, String sort, Long totalElements, Integer totalPages, BigDecimal ultimaModificacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling cercaTramitsProcediment");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/searchAssociated/procediment/{idProcediment}"
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "darreraModificacio", darreraModificacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataGestioElectronica", dataGestioElectronica));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descripcio", descripcio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "esTramitIniciacio", esTramitIniciacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "exclusiuIntern", exclusiuIntern));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "gestioElectronica", gestioElectronica));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "informacioTramitador", informacioTramitador));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nom", nom));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "normaAltresAplicacio", normaAltresAplicacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "normaReferenciaPrincipal", normaReferenciaPrincipal));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rolUsuari", rolUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ultimaModificacio", ultimaModificacio));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfTramitsRDTO> localVarReturnType = new GenericType<PageDataOfTramitsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested tramits
   * 
   * @param id id (required)
   * @return TramitsRDTO
   * @throws ApiException if fails to make API call
   */
  public TramitsRDTO consultarDadesTramit(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling consultarDadesTramit");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/{id}"
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

    GenericType<TramitsRDTO> localVarReturnType = new GenericType<TramitsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the tramits
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
   * @return PageDataOfTramitsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfTramitsRDTO getAllTramitsUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/tramits";

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

    GenericType<PageDataOfTramitsRDTO> localVarReturnType = new GenericType<PageDataOfTramitsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Insert  tramits
   * 
   * @param tramitsRDTO tramitsRDTO (required)
   * @return TramitsRDTO
   * @throws ApiException if fails to make API call
   */
  public TramitsRDTO saveTramitUsingPOST(TramitsRDTO tramitsRDTO) throws ApiException {
    Object localVarPostBody = tramitsRDTO;
    
    // verify the required parameter 'tramitsRDTO' is set
    if (tramitsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'tramitsRDTO' when calling saveTramitUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits";

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

    GenericType<TramitsRDTO> localVarReturnType = new GenericType<TramitsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the historic entries for the procedure that meet the search criteria
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
   * @param tipus tipus (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @return PageDataOfHistoricsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfHistoricsRDTO searchHistoricsUsingGET(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, List<Integer> tipus, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling searchHistoricsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/historic/{id}"
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
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "tipus", tipus));
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

    GenericType<PageDataOfHistoricsRDTO> localVarReturnType = new GenericType<PageDataOfHistoricsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the tramits that meet the search criteria and are not associated with a procediment
   * 
   * @param idProcediment idProcediment (required)
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param darreraModificacio  (optional)
   * @param dataGestioElectronica  (optional)
   * @param descripcio  (optional)
   * @param dir  (optional)
   * @param esTramitIniciacio  (optional)
   * @param exclusiuIntern  (optional)
   * @param gestioElectronica  (optional)
   * @param id  (optional)
   * @param informacioTramitador  (optional)
   * @param nextPageNumber  (optional)
   * @param nom  (optional)
   * @param normaAltresAplicacio  (optional)
   * @param normaReferenciaPrincipal  (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param rolUsuari  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @param ultimaModificacio  (optional)
   * @return PageDataOfTramitsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfTramitsRDTO searchTramitsNotAssociatedProcedimentUsingGET(BigDecimal idProcediment, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime darreraModificacio, DateTime dataGestioElectronica, String descripcio, String dir, Integer esTramitIniciacio, Integer exclusiuIntern, String gestioElectronica, BigDecimal id, String informacioTramitador, Integer nextPageNumber, String nom, String normaAltresAplicacio, String normaReferenciaPrincipal, Integer pageSize, Integer previousPageNumber, String rolUsuari, String sort, Long totalElements, Integer totalPages, BigDecimal ultimaModificacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling searchTramitsNotAssociatedProcedimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/searchNotAssociated/procediment/{idProcediment}"
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "darreraModificacio", darreraModificacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataGestioElectronica", dataGestioElectronica));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descripcio", descripcio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "esTramitIniciacio", esTramitIniciacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "exclusiuIntern", exclusiuIntern));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "gestioElectronica", gestioElectronica));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "informacioTramitador", informacioTramitador));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nom", nom));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "normaAltresAplicacio", normaAltresAplicacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "normaReferenciaPrincipal", normaReferenciaPrincipal));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rolUsuari", rolUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ultimaModificacio", ultimaModificacio));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfTramitsRDTO> localVarReturnType = new GenericType<PageDataOfTramitsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * check if the tramits are associated to procediments
   * 
   * @param idTramitsList idTramitsList (required)
   * @throws ApiException if fails to make API call
   */
  public void tramitsAssociatedProcedimentUsingPOST(List<BigDecimal> idTramitsList) throws ApiException {
    Object localVarPostBody = idTramitsList;
    
    // verify the required parameter 'idTramitsList' is set
    if (idTramitsList == null) {
      throw new ApiException(400, "Missing the required parameter 'idTramitsList' when calling tramitsAssociatedProcedimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/tramits/delete";

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
