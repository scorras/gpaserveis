package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DadesOperacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-13T13:50:42.299+02:00")
public class ConfiguracioDocumentacioApi {
  private ApiClient apiClient;

  public ConfiguracioDocumentacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ConfiguracioDocumentacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Returns the requested entrada configuracio
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
   * @return PageDataOfConfiguracioDocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntrada(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling cercaConfiguracioDocumentacioEntrada");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/entrada/{id}"
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

    GenericType<PageDataOfConfiguracioDocsEntradaRDTO> localVarReturnType = new GenericType<PageDataOfConfiguracioDocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested entrada configuracio
   * 
   * @param id id (required)
   * @param idTramitOvt idTramitOvt (required)
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
   * @return PageDataOfConfiguracioDocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntradaPerTramitOvt(BigDecimal id, BigDecimal idTramitOvt, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling cercaConfiguracioDocumentacioEntradaPerTramitOvt");
    }
    
    // verify the required parameter 'idTramitOvt' is set
    if (idTramitOvt == null) {
      throw new ApiException(400, "Missing the required parameter 'idTramitOvt' when calling cercaConfiguracioDocumentacioEntradaPerTramitOvt");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/entrada/{id}/{idTramitOvt}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "idTramitOvt" + "\\}", apiClient.escapeString(idTramitOvt.toString()));

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

    GenericType<PageDataOfConfiguracioDocsEntradaRDTO> localVarReturnType = new GenericType<PageDataOfConfiguracioDocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * comprovarDocumentacioConfDocsEntPerEstat
   * 
   * @param confDocsEntrada confDocsEntrada (required)
   * @param estatFuturo estatFuturo (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   */
  public Boolean comprovarDocumentacioConfDocsEntPerEstatUsingGET(BigDecimal confDocsEntrada, BigDecimal estatFuturo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'confDocsEntrada' is set
    if (confDocsEntrada == null) {
      throw new ApiException(400, "Missing the required parameter 'confDocsEntrada' when calling comprovarDocumentacioConfDocsEntPerEstatUsingGET");
    }
    
    // verify the required parameter 'estatFuturo' is set
    if (estatFuturo == null) {
      throw new ApiException(400, "Missing the required parameter 'estatFuturo' when calling comprovarDocumentacioConfDocsEntPerEstatUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/comprovarDocumentacioConfDocsEntPerEstat/{confDocsEntrada}/{estatFuturo}"
      .replaceAll("\\{" + "confDocsEntrada" + "\\}", apiClient.escapeString(confDocsEntrada.toString()))
      .replaceAll("\\{" + "estatFuturo" + "\\}", apiClient.escapeString(estatFuturo.toString()));

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

    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * comprovarDocumentacioConfDocsEntPerEstat
   * 
   * @param confDocsTramitacio confDocsTramitacio (required)
   * @param estatFuturo estatFuturo (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   */
  public Boolean comprovarDocumentacioConfDocsTramPerEstatUsingGET(BigDecimal confDocsTramitacio, BigDecimal estatFuturo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'confDocsTramitacio' is set
    if (confDocsTramitacio == null) {
      throw new ApiException(400, "Missing the required parameter 'confDocsTramitacio' when calling comprovarDocumentacioConfDocsTramPerEstatUsingGET");
    }
    
    // verify the required parameter 'estatFuturo' is set
    if (estatFuturo == null) {
      throw new ApiException(400, "Missing the required parameter 'estatFuturo' when calling comprovarDocumentacioConfDocsTramPerEstatUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/comprovarDocumentacioConfDocsTramPerEstat/{confDocsTramitacio}/{estatFuturo}"
      .replaceAll("\\{" + "confDocsTramitacio" + "\\}", apiClient.escapeString(confDocsTramitacio.toString()))
      .replaceAll("\\{" + "estatFuturo" + "\\}", apiClient.escapeString(estatFuturo.toString()));

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

    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested entrada configuracio associada al requeriment
   * 
   * @param idRequeriment idRequeriment (required)
   * @return List&lt;ConfiguracioDocsEntradaRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ConfiguracioDocsEntradaRDTO> getConfDocAssociadaRequerimentUsingGET(BigDecimal idRequeriment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idRequeriment' is set
    if (idRequeriment == null) {
      throw new ApiException(400, "Missing the required parameter 'idRequeriment' when calling getConfDocAssociadaRequerimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/getConfDocAssociadaRequeriment/{idRequeriment}"
      .replaceAll("\\{" + "idRequeriment" + "\\}", apiClient.escapeString(idRequeriment.toString()));

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

    GenericType<List<ConfiguracioDocsEntradaRDTO>> localVarReturnType = new GenericType<List<ConfiguracioDocsEntradaRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested tramitacio configuracio
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
   * @return PageDataOfConfiguracioDocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfConfiguracioDocsTramitacioRDTO getConfiguracioDocumentacioTramitacioUsingGET(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getConfiguracioDocumentacioTramitacioUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/tramitacio/{id}"
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

    GenericType<PageDataOfConfiguracioDocsTramitacioRDTO> localVarReturnType = new GenericType<PageDataOfConfiguracioDocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested dadas operacio associada al requeriment
   * 
   * @param idRequeriment idRequeriment (required)
   * @return List&lt;DadesOperacioRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DadesOperacioRDTO> getDadesOperAssociadaRequerimentUsingGET(BigDecimal idRequeriment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idRequeriment' is set
    if (idRequeriment == null) {
      throw new ApiException(400, "Missing the required parameter 'idRequeriment' when calling getDadesOperAssociadaRequerimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/getDadesOperAssociadaRequeriment/{idRequeriment}"
      .replaceAll("\\{" + "idRequeriment" + "\\}", apiClient.escapeString(idRequeriment.toString()));

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

    GenericType<List<DadesOperacioRDTO>> localVarReturnType = new GenericType<List<DadesOperacioRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested plantilla for the documentacio Vinculada
   * 
   * @param idConfDoc idConfDoc (required)
   * @param idDocVinculada idDocVinculada (required)
   * @return RespostaPlantillaDocVinculada
   * @throws ApiException if fails to make API call
   */
  public RespostaPlantillaDocVinculada getPlantillaDocVinculada(BigDecimal idConfDoc, BigDecimal idDocVinculada) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idConfDoc' is set
    if (idConfDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfDoc' when calling getPlantillaDocVinculada");
    }
    
    // verify the required parameter 'idDocVinculada' is set
    if (idDocVinculada == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocVinculada' when calling getPlantillaDocVinculada");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/plantillaDocVinculada/{idConfDoc}/{idDocVinculada}"
      .replaceAll("\\{" + "idConfDoc" + "\\}", apiClient.escapeString(idConfDoc.toString()))
      .replaceAll("\\{" + "idDocVinculada" + "\\}", apiClient.escapeString(idDocVinculada.toString()));

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

    GenericType<RespostaPlantillaDocVinculada> localVarReturnType = new GenericType<RespostaPlantillaDocVinculada>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested entrada configuracio
   * 
   * @param idConfiguracioDocumentacio idConfiguracioDocumentacio (required)
   * @param idsConfEntrAssociarReq idsConfEntrAssociarReq (required)
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
   * @return PageDataOfConfiguracioDocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfConfiguracioDocsEntradaRDTO obtenirConfiguracioDocEntAssociarRequerimentUsingGET(BigDecimal idConfiguracioDocumentacio, String idsConfEntrAssociarReq, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idConfiguracioDocumentacio' is set
    if (idConfiguracioDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfiguracioDocumentacio' when calling obtenirConfiguracioDocEntAssociarRequerimentUsingGET");
    }
    
    // verify the required parameter 'idsConfEntrAssociarReq' is set
    if (idsConfEntrAssociarReq == null) {
      throw new ApiException(400, "Missing the required parameter 'idsConfEntrAssociarReq' when calling obtenirConfiguracioDocEntAssociarRequerimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/entradaAssociarRequeriment/{idConfiguracioDocumentacio}/{idsConfEntrAssociarReq}"
      .replaceAll("\\{" + "idConfiguracioDocumentacio" + "\\}", apiClient.escapeString(idConfiguracioDocumentacio.toString()))
      .replaceAll("\\{" + "idsConfEntrAssociarReq" + "\\}", apiClient.escapeString(idsConfEntrAssociarReq.toString()));

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

    GenericType<PageDataOfConfiguracioDocsEntradaRDTO> localVarReturnType = new GenericType<PageDataOfConfiguracioDocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested tramitacio configuracio
   * 
   * @param id id (required)
   * @return List&lt;ConfiguracioDocsTramitacioRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ConfiguracioDocsTramitacioRDTO> obtenirConfiguracioDocumentacioTramitacioUsingGET(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling obtenirConfiguracioDocumentacioTramitacioUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/configuracioDocsTramitacio/{id}"
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

    GenericType<List<ConfiguracioDocsTramitacioRDTO>> localVarReturnType = new GenericType<List<ConfiguracioDocsTramitacioRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates the doc config
   * 
   * @param docEntrada docEntrada (required)
   * @param procId procId (required)
   * @throws ApiException if fails to make API call
   */
  public void updateDocumentacioEntradaUsingPUT(ConfiguracioDocsEntradaRDTO docEntrada, BigDecimal procId) throws ApiException {
    Object localVarPostBody = docEntrada;
    
    // verify the required parameter 'docEntrada' is set
    if (docEntrada == null) {
      throw new ApiException(400, "Missing the required parameter 'docEntrada' when calling updateDocumentacioEntradaUsingPUT");
    }
    
    // verify the required parameter 'procId' is set
    if (procId == null) {
      throw new ApiException(400, "Missing the required parameter 'procId' when calling updateDocumentacioEntradaUsingPUT");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/docEntrada/{procId}"
      .replaceAll("\\{" + "procId" + "\\}", apiClient.escapeString(procId.toString()));

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


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * updates the doc config
   * 
   * @param docTramitacio docTramitacio (required)
   * @param procId procId (required)
   * @throws ApiException if fails to make API call
   */
  public void updateDocumentacioTramitacioUsingPUT(ConfiguracioDocsTramitacioRDTO docTramitacio, BigDecimal procId) throws ApiException {
    Object localVarPostBody = docTramitacio;
    
    // verify the required parameter 'docTramitacio' is set
    if (docTramitacio == null) {
      throw new ApiException(400, "Missing the required parameter 'docTramitacio' when calling updateDocumentacioTramitacioUsingPUT");
    }
    
    // verify the required parameter 'procId' is set
    if (procId == null) {
      throw new ApiException(400, "Missing the required parameter 'procId' when calling updateDocumentacioTramitacioUsingPUT");
    }
    
    // create path and map variables
    String localVarPath = "/configuracioDocumentacio/docTramitacio/{procId}"
      .replaceAll("\\{" + "procId" + "\\}", apiClient.escapeString(procId.toString()));

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


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
