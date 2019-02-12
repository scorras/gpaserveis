package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AcumularDocumentacioRDTO;
import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaIdsAndEstatRevisioId;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioIdsAndEstatFinalId;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatRevisioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TransicionsEstatsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-11T17:30:09.381+01:00")
public class DocumentacioApi {
  private ApiClient apiClient;

  public DocumentacioApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DocumentacioApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Acumulació de la documentació
   * 
   * @param acumularDocumentacioRDTO acumularDocumentacioRDTO (required)
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse acumularDocumentacioUsingPOST(AcumularDocumentacioRDTO acumularDocumentacioRDTO) throws ApiException {
    Object localVarPostBody = acumularDocumentacioRDTO;
    
    // verify the required parameter 'acumularDocumentacioRDTO' is set
    if (acumularDocumentacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'acumularDocumentacioRDTO' when calling acumularDocumentacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/acumularDocumentacio";

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

    GenericType<RestClientResponse> localVarReturnType = new GenericType<RestClientResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates all selected DocsTramitacio with the EstatsDocument specified
   * 
   * @param docsEntradaIdsAndEstatRevisioId docsEntradaIdsAndEstatRevisioId (required)
   * @throws ApiException if fails to make API call
   */
  public void canviEstatDocumentacioTramitacioUsingPOST(DocsTramitacioIdsAndEstatFinalId docsEntradaIdsAndEstatRevisioId) throws ApiException {
    Object localVarPostBody = docsEntradaIdsAndEstatRevisioId;
    
    // verify the required parameter 'docsEntradaIdsAndEstatRevisioId' is set
    if (docsEntradaIdsAndEstatRevisioId == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaIdsAndEstatRevisioId' when calling canviEstatDocumentacioTramitacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/canviEstat";

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
   * Delete all selected DocsEntrada
   * 
   * @param docsEntradaIds docsEntradaIds (required)
   * @param idExpedient idExpedient (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteDocumentacioEntradaUsingPOST(List<BigDecimal> docsEntradaIds, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaIds;
    
    // verify the required parameter 'docsEntradaIds' is set
    if (docsEntradaIds == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaIds' when calling deleteDocumentacioEntradaUsingPOST");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling deleteDocumentacioEntradaUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/delete/{idExpedient}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Delete all selected DocsEntrada
   * 
   * @param docsTramitacioIds docsTramitacioIds (required)
   * @param idExpedient idExpedient (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteDocumentacioTramitacioUsingPOST(List<BigDecimal> docsTramitacioIds, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsTramitacioIds;
    
    // verify the required parameter 'docsTramitacioIds' is set
    if (docsTramitacioIds == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacioIds' when calling deleteDocumentacioTramitacioUsingPOST");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling deleteDocumentacioTramitacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/delete/{idExpedient}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Returns the requested documentacio entrada
   * 
   * @param estatsFutursList estatsFutursList (required)
   * @param idConfiguracioDocumentacio idConfiguracioDocumentacio (required)
   * @param idDocumentacio idDocumentacio (required)
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
   * @return PageDataOfDocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDocsEntradaRDTO getDocumentacioEntradaUsingGET(String estatsFutursList, BigDecimal idConfiguracioDocumentacio, BigDecimal idDocumentacio, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'estatsFutursList' is set
    if (estatsFutursList == null) {
      throw new ApiException(400, "Missing the required parameter 'estatsFutursList' when calling getDocumentacioEntradaUsingGET");
    }
    
    // verify the required parameter 'idConfiguracioDocumentacio' is set
    if (idConfiguracioDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfiguracioDocumentacio' when calling getDocumentacioEntradaUsingGET");
    }
    
    // verify the required parameter 'idDocumentacio' is set
    if (idDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocumentacio' when calling getDocumentacioEntradaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/{idDocumentacio}/entrada/{idConfiguracioDocumentacio}/{estatsFutursList}"
      .replaceAll("\\{" + "estatsFutursList" + "\\}", apiClient.escapeString(estatsFutursList.toString()))
      .replaceAll("\\{" + "idConfiguracioDocumentacio" + "\\}", apiClient.escapeString(idConfiguracioDocumentacio.toString()))
      .replaceAll("\\{" + "idDocumentacio" + "\\}", apiClient.escapeString(idDocumentacio.toString()));

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

    GenericType<PageDataOfDocsEntradaRDTO> localVarReturnType = new GenericType<PageDataOfDocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested documentacio tramitacio
   * 
   * @param estatsFutursList estatsFutursList (required)
   * @param idConfiguracioDocumentacio idConfiguracioDocumentacio (required)
   * @param idDocumentacio idDocumentacio (required)
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
   * @return PageDataOfDocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfDocsTramitacioRDTO getDocumentacioTramitacioUsingGET(String estatsFutursList, BigDecimal idConfiguracioDocumentacio, BigDecimal idDocumentacio, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'estatsFutursList' is set
    if (estatsFutursList == null) {
      throw new ApiException(400, "Missing the required parameter 'estatsFutursList' when calling getDocumentacioTramitacioUsingGET");
    }
    
    // verify the required parameter 'idConfiguracioDocumentacio' is set
    if (idConfiguracioDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfiguracioDocumentacio' when calling getDocumentacioTramitacioUsingGET");
    }
    
    // verify the required parameter 'idDocumentacio' is set
    if (idDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocumentacio' when calling getDocumentacioTramitacioUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/{idDocumentacio}/tramitacio/{idConfiguracioDocumentacio}/{estatsFutursList}"
      .replaceAll("\\{" + "estatsFutursList" + "\\}", apiClient.escapeString(estatsFutursList.toString()))
      .replaceAll("\\{" + "idConfiguracioDocumentacio" + "\\}", apiClient.escapeString(idConfiguracioDocumentacio.toString()))
      .replaceAll("\\{" + "idDocumentacio" + "\\}", apiClient.escapeString(idDocumentacio.toString()));

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

    GenericType<PageDataOfDocsTramitacioRDTO> localVarReturnType = new GenericType<PageDataOfDocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the EstatRevisio
   * 
   * @return List&lt;EstatRevisioRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<EstatRevisioRDTO> getEstatsRevisioDocumentacioEntradaUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/estatsRevisio";

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

    GenericType<List<EstatRevisioRDTO>> localVarReturnType = new GenericType<List<EstatRevisioRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the tipus grup entries for the idConfigDoc
   * 
   * @param idConfigDoc idConfigDoc (required)
   * @return List&lt;ConfiguracioDocsEntradaRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ConfiguracioDocsEntradaRDTO> getTipusGrupEntradaUsingGET(BigDecimal idConfigDoc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idConfigDoc' is set
    if (idConfigDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfigDoc' when calling getTipusGrupEntradaUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/listTipusGrup/{idConfigDoc}"
      .replaceAll("\\{" + "idConfigDoc" + "\\}", apiClient.escapeString(idConfigDoc.toString()));

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
   * Returns all the tipus grup entries for the idConfigDoc
   * 
   * @param idConfigDoc idConfigDoc (required)
   * @return List&lt;ConfiguracioDocsTramitacioRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ConfiguracioDocsTramitacioRDTO> getTipusGrupTramitacioUsingGET(BigDecimal idConfigDoc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idConfigDoc' is set
    if (idConfigDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfigDoc' when calling getTipusGrupTramitacioUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/listTipusGrup/{idConfigDoc}"
      .replaceAll("\\{" + "idConfigDoc" + "\\}", apiClient.escapeString(idConfigDoc.toString()));

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
   * create new documentacio
   * 
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse newDocumentacioUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/documentacio/newDocumentacio";

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

    GenericType<RestClientResponse> localVarReturnType = new GenericType<RestClientResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested documentacio entrada
   * 
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> obteneriDocumentacioEntradaEnRevisioUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/documentacio/documentacioEntradaEnRevisio";

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

    GenericType<List<BigDecimal>> localVarReturnType = new GenericType<List<BigDecimal>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get all estats documentació tramitació
   * 
   * @param estatDocTramitacio estatDocTramitacio (required)
   * @return List&lt;TransicionsEstatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<TransicionsEstatsRDTO> obtenirTransicionsEstatsByEstatDocTramUsingGET(BigDecimal estatDocTramitacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'estatDocTramitacio' is set
    if (estatDocTramitacio == null) {
      throw new ApiException(400, "Missing the required parameter 'estatDocTramitacio' when calling obtenirTransicionsEstatsByEstatDocTramUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/estatsDocTramCanviEstat/{estatDocTramitacio}"
      .replaceAll("\\{" + "estatDocTramitacio" + "\\}", apiClient.escapeString(estatDocTramitacio.toString()));

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

    GenericType<List<TransicionsEstatsRDTO>> localVarReturnType = new GenericType<List<TransicionsEstatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates all selected DocsEntrada with the EstatRevisio specified
   * 
   * @param docsEntradaIdsAndEstatRevisioId docsEntradaIdsAndEstatRevisioId (required)
   * @throws ApiException if fails to make API call
   */
  public void revisarDocumentacioEntradaUsingPOST(DocsEntradaIdsAndEstatRevisioId docsEntradaIdsAndEstatRevisioId) throws ApiException {
    Object localVarPostBody = docsEntradaIdsAndEstatRevisioId;
    
    // verify the required parameter 'docsEntradaIdsAndEstatRevisioId' is set
    if (docsEntradaIdsAndEstatRevisioId == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaIdsAndEstatRevisioId' when calling revisarDocumentacioEntradaUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/revisar";

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
   * updates the doc entrada
   * 
   * @param docsEntradaRDTO docsEntradaRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO saveDocumentacioEntradaUsingPOST(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaRDTO;
    
    // verify the required parameter 'docsEntradaRDTO' is set
    if (docsEntradaRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaRDTO' when calling saveDocumentacioEntradaUsingPOST");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling saveDocumentacioEntradaUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/saveDocEntrada/{idExpedient}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<DocsEntradaRDTO> localVarReturnType = new GenericType<DocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates the doc tramitacio
   * 
   * @param docsTramitacioRDTO docsTramitacioRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO saveDocumentacioTramitacioUsingPOST(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsTramitacioRDTO;
    
    // verify the required parameter 'docsTramitacioRDTO' is set
    if (docsTramitacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacioRDTO' when calling saveDocumentacioTramitacioUsingPOST");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling saveDocumentacioTramitacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/saveDocTramitacio/{idExpedient}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates the requeriment
   * 
   * @param docsTramitacioRDTO docsTramitacioRDTO (required)
   * @param idExpedient idExpedient (required)
   * @param idsConfDocEntradaList idsConfDocEntradaList (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO saveRequerimentUsingPOST(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient, String idsConfDocEntradaList) throws ApiException {
    Object localVarPostBody = docsTramitacioRDTO;
    
    // verify the required parameter 'docsTramitacioRDTO' is set
    if (docsTramitacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacioRDTO' when calling saveRequerimentUsingPOST");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling saveRequerimentUsingPOST");
    }
    
    // verify the required parameter 'idsConfDocEntradaList' is set
    if (idsConfDocEntradaList == null) {
      throw new ApiException(400, "Missing the required parameter 'idsConfDocEntradaList' when calling saveRequerimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/saveRequeriment/{idExpedient}/{idsConfDocEntradaList}"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()))
      .replaceAll("\\{" + "idsConfDocEntradaList" + "\\}", apiClient.escapeString(idsConfDocEntradaList.toString()));

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

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
