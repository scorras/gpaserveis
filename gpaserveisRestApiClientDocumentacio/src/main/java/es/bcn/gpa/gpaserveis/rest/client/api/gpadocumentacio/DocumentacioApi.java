package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AcumularDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AportarDocumentacioExpedient;
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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaUploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SubstituirDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TransicionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UploadDocumentExpedient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-03-26T12:10:29.973+01:00")
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
   * Stores the documentation provided
   * 
   * @param aportarDocumentacioExpedientRDTO aportarDocumentacioExpedientRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return RespostaAportarDocumentacioExpedientRDTO
   * @throws ApiException if fails to make API call
   */
  public RespostaAportarDocumentacioExpedientRDTO aportarDocumentacioExpedient(AportarDocumentacioExpedient aportarDocumentacioExpedientRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = aportarDocumentacioExpedientRDTO;
    
    // verify the required parameter 'aportarDocumentacioExpedientRDTO' is set
    if (aportarDocumentacioExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'aportarDocumentacioExpedientRDTO' when calling aportarDocumentacioExpedient");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling aportarDocumentacioExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/aportarDocumentacio/{idExpedient}"
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

    GenericType<RespostaAportarDocumentacioExpedientRDTO> localVarReturnType = new GenericType<RespostaAportarDocumentacioExpedientRDTO>() {};
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
   * Returns the requested documentacio entrada grouped by tràmit OVT
   * 
   * @param idDocumentacio idDocumentacio (required)
   * @return List&lt;DocsEntradaRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DocsEntradaRDTO> cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDocumentacio' is set
    if (idDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocumentacio' when calling cercaDocumentsEntradaAgrupatsPerTramitOvt");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/{idDocumentacio}/entrada/agrupatPerTramitOvt"
      .replaceAll("\\{" + "idDocumentacio" + "\\}", apiClient.escapeString(idDocumentacio.toString()));

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

    GenericType<List<DocsEntradaRDTO>> localVarReturnType = new GenericType<List<DocsEntradaRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested document
   * 
   * @param id id (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling consultarDadesDocumentAportat");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/{id}"
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

    GenericType<DocsEntradaRDTO> localVarReturnType = new GenericType<DocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
   * Delete all selected DocsEntrada
   * 
   * @param docsEntradaIds docsEntradaIds (required)
   * @param idExpedient idExpedient (required)
   * @throws ApiException if fails to make API call
   */
  public void esborrarDocumentExpedient(List<BigDecimal> docsEntradaIds, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaIds;
    
    // verify the required parameter 'docsEntradaIds' is set
    if (docsEntradaIds == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaIds' when calling esborrarDocumentExpedient");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling esborrarDocumentExpedient");
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
   * Returns the requested dades operacio requerit
   * 
   * @param idDoc idDoc (required)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> obteneriDadesOperRequeritUsingGET(BigDecimal idDoc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDoc' is set
    if (idDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idDoc' when calling obteneriDadesOperRequeritUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/dadesOperRequerit/{idDoc}"
      .replaceAll("\\{" + "idDoc" + "\\}", apiClient.escapeString(idDoc.toString()));

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
   * @param idsDadesOperList idsDadesOperList (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO saveRequerimentUsingPOST(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient, String idsConfDocEntradaList, String idsDadesOperList) throws ApiException {
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
    
    // verify the required parameter 'idsDadesOperList' is set
    if (idsDadesOperList == null) {
      throw new ApiException(400, "Missing the required parameter 'idsDadesOperList' when calling saveRequerimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/saveRequeriment/{idExpedient}/{idsConfDocEntradaList}/{idsDadesOperList}"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()))
      .replaceAll("\\{" + "idsConfDocEntradaList" + "\\}", apiClient.escapeString(idsConfDocEntradaList.toString()))
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates the document provided
   * 
   * @param idExpedient idExpedient (required)
   * @param substituirDocumentExpedientRDTO substituirDocumentExpedientRDTO (required)
   * @return RespostaSubstituirDocumentExpedientRDTO
   * @throws ApiException if fails to make API call
   */
  public RespostaSubstituirDocumentExpedientRDTO substituirDocumentExpedient(BigDecimal idExpedient, SubstituirDocumentExpedient substituirDocumentExpedientRDTO) throws ApiException {
    Object localVarPostBody = substituirDocumentExpedientRDTO;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling substituirDocumentExpedient");
    }
    
    // verify the required parameter 'substituirDocumentExpedientRDTO' is set
    if (substituirDocumentExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'substituirDocumentExpedientRDTO' when calling substituirDocumentExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/substituirDocument/{idExpedient}"
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

    GenericType<RespostaSubstituirDocumentExpedientRDTO> localVarReturnType = new GenericType<RespostaSubstituirDocumentExpedientRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Upload the document provided
   * 
   * @param idExpedient idExpedient (required)
   * @param uploadDocumentExpedientRDTO uploadDocumentExpedientRDTO (required)
   * @return RespostaUploadDocumentExpedient
   * @throws ApiException if fails to make API call
   */
  public RespostaUploadDocumentExpedient uploadDocumentExpedient(BigDecimal idExpedient, UploadDocumentExpedient uploadDocumentExpedientRDTO) throws ApiException {
    Object localVarPostBody = uploadDocumentExpedientRDTO;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling uploadDocumentExpedient");
    }
    
    // verify the required parameter 'uploadDocumentExpedientRDTO' is set
    if (uploadDocumentExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'uploadDocumentExpedientRDTO' when calling uploadDocumentExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/uploadDocument/{idExpedient}"
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

    GenericType<RespostaUploadDocumentExpedient> localVarReturnType = new GenericType<RespostaUploadDocumentExpedient>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
