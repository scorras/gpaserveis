package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.Pair;

import javax.ws.rs.core.GenericType;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.BloquejosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import org.joda.time.DateTime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.InfoDocProcedimentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfComentarisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentSerieDocRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsForTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsForUnitatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.UnitatsGestoresRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-08T18:12:32.660+02:00")
public class ProcedimentsApi {
  private ApiClient apiClient;

  public ProcedimentsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProcedimentsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Locks the provided procediment for editing
   * 
   * @param bloquejosRDTO bloquejosRDTO (required)
   * @param id id (required)
   * @throws ApiException if fails to make API call
   */
  public void bloquejarProcedimentUsingPOST(BloquejosRDTO bloquejosRDTO, BigDecimal id) throws ApiException {
    Object localVarPostBody = bloquejosRDTO;
    
    // verify the required parameter 'bloquejosRDTO' is set
    if (bloquejosRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'bloquejosRDTO' when calling bloquejarProcedimentUsingPOST");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling bloquejarProcedimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/bloquejar/{id}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Deletes the requested procediment list
   * 
   * @param procedimentIdList procedimentIdList (required)
   * @throws ApiException if fails to make API call
   */
  public void bulkDeleteProcedimentsListUsingPOST(List<BigDecimal> procedimentIdList) throws ApiException {
    Object localVarPostBody = procedimentIdList;
    
    // verify the required parameter 'procedimentIdList' is set
    if (procedimentIdList == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentIdList' when calling bulkDeleteProcedimentsListUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/delete";

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
   * Change the state of a procediment
   * 
   * @param id id (required)
   * @param procedimentRDTO procedimentRDTO (required)
   * @return ProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsRDTO canviEstatProcedimentsUsingPOST(BigDecimal id, ProcedimentsRDTO procedimentRDTO) throws ApiException {
    Object localVarPostBody = procedimentRDTO;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling canviEstatProcedimentsUsingPOST");
    }
    
    // verify the required parameter 'procedimentRDTO' is set
    if (procedimentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentRDTO' when calling canviEstatProcedimentsUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/canviEstat/{id}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<ProcedimentsRDTO> localVarReturnType = new GenericType<ProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all procedures that meet the search criteria
   * 
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param activableFormatElectronic Canals d&#39;activació en format electrònic (optional)
   * @param actuacio Actuació (optional)
   * @param aplicacioNegoci Nom de l&#39;aplicació de negoci (optional)
   * @param codi Codi del procediment (optional)
   * @param competencies Competències associades al procediment (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dir  (optional)
   * @param estats Estats (optional)
   * @param families Famílies del procediment (optional)
   * @param id Identificador pel qual es realitza la cerca (optional)
   * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca (optional)
   * @param intern Exclusivament intern (optional)
   * @param nextPageNumber  (optional)
   * @param nom Nom del procediment (optional)
   * @param operador operador tramitador (optional)
   * @param organResolutori Òrgan resolutori (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @param ugos Unitats gestores responsables (optional)
   * @return PageDataOfProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfProcedimentsRDTO cercaProcediments(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, List<String> activableFormatElectronic, String actuacio, String aplicacioNegoci, String codi, List<BigDecimal> competencies, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, List<BigDecimal> estats, List<BigDecimal> families, BigDecimal id, BigDecimal idUsuari, Integer intern, Integer nextPageNumber, String nom, Integer operador, String organResolutori, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages, List<BigDecimal> ugos) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/search";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "activableFormatElectronic", activableFormatElectronic));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "actuacio", actuacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "aplicacioNegoci", aplicacioNegoci));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "codi", codi));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "competencies", competencies));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "estats", estats));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "families", families));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idUsuari", idUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "intern", intern));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nom", nom));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "operador", operador));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "organResolutori", organResolutori));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "ugos", ugos));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfProcedimentsRDTO> localVarReturnType = new GenericType<PageDataOfProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns true/false if the published procediment has expedients
   * 
   * @param idProcediment idProcediment (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   */
  public Boolean checkExpedientsUsingGET(BigDecimal idProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling checkExpedientsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/checkExpedients/{idProcediment}"
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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
   * Clone the provided procediment
   * 
   * @param id id (required)
   * @param procedimentRDTO procedimentRDTO (required)
   * @return ProcedimentsResponse
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsResponse cloneProcedimentUsingPOST(BigDecimal id, ProcedimentsRDTO procedimentRDTO) throws ApiException {
    Object localVarPostBody = procedimentRDTO;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling cloneProcedimentUsingPOST");
    }
    
    // verify the required parameter 'procedimentRDTO' is set
    if (procedimentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentRDTO' when calling cloneProcedimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/clonar/{id}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<ProcedimentsResponse> localVarReturnType = new GenericType<ProcedimentsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested procediment
   * 
   * @param id id (required)
   * @return ProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsRDTO consultarDadesProcediment(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling consultarDadesProcediment");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}"
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

    GenericType<ProcedimentsRDTO> localVarReturnType = new GenericType<ProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested procediment
   * 
   * @param codi codi (required)
   * @return ProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsRDTO consultarDadesProcedimentPerCodi(String codi) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codi' is set
    if (codi == null) {
      throw new ApiException(400, "Missing the required parameter 'codi' when calling consultarDadesProcedimentPerCodi");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/perCodi/{codi}"
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

    GenericType<ProcedimentsRDTO> localVarReturnType = new GenericType<ProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Deletes the requested procediment
   * 
   * @param id id (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteProcedimentsUsingDELETE(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteProcedimentsUsingDELETE");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/{id}"
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


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Unlocks the provided procediment
   * 
   * @param id id (required)
   * @throws ApiException if fails to make API call
   */
  public void desbloquejarProcedimentUsingPOST(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling desbloquejarProcedimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/desbloquejar/{id}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Retorna les dades d&#39;operació de la darrera versió del procediment
   * 
   * @param codi codi (required)
   * @return List&lt;DadesOperacionsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DadesOperacionsRDTO> getDadesOperacioForCercaExpedientUsingGET(String codi) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codi' is set
    if (codi == null) {
      throw new ApiException(400, "Missing the required parameter 'codi' when calling getDadesOperacioForCercaExpedientUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/dadesOperacioForCercaExpedient/{codi}"
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

    GenericType<List<DadesOperacionsRDTO>> localVarReturnType = new GenericType<List<DadesOperacionsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns dades operacions from procediment
   * 
   * @param idProcediment idProcediment (required)
   * @return List&lt;DadesOperacionsBDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<DadesOperacionsBDTO> getDadesOperacionsUsingGET(BigDecimal idProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling getDadesOperacionsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/dadesOperacions/{idProcediment}"
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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

    GenericType<List<DadesOperacionsBDTO>> localVarReturnType = new GenericType<List<DadesOperacionsBDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the procediments names
   * 
   * @param procList procList (required)
   * @return List&lt;ProcedimentsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProcedimentsRDTO> getNomProcedimentsForOgeUsingPOST(List<BigDecimal> procList) throws ApiException {
    Object localVarPostBody = procList;
    
    // verify the required parameter 'procList' is set
    if (procList == null) {
      throw new ApiException(400, "Missing the required parameter 'procList' when calling getNomProcedimentsForOgeUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/infoProcediments";

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

    GenericType<List<ProcedimentsRDTO>> localVarReturnType = new GenericType<List<ProcedimentsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns procediments associated to tramits
   * 
   * @param idTramitList idTramitList (required)
   * @return List&lt;ProcedimentsForTramitsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProcedimentsForTramitsRDTO> getProcedimentsAssociatedTramitsUsingGET(String idTramitList) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idTramitList' is set
    if (idTramitList == null) {
      throw new ApiException(400, "Missing the required parameter 'idTramitList' when calling getProcedimentsAssociatedTramitsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/getProcedimentsAssociatedTramits/{idTramitList}"
      .replaceAll("\\{" + "idTramitList" + "\\}", apiClient.escapeString(idTramitList.toString()));

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

    GenericType<List<ProcedimentsForTramitsRDTO>> localVarReturnType = new GenericType<List<ProcedimentsForTramitsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * ProcedimentsForOgeForDropdown
   * 
   * @return List&lt;ProcedimentsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProcedimentsRDTO> getProcedimentsForOgeForDropdownUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/procedimentsForOgeForDropdown";

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

    GenericType<List<ProcedimentsRDTO>> localVarReturnType = new GenericType<List<ProcedimentsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the procediments for OGE
   * 
   * @return List&lt;ProcedimentsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProcedimentsRDTO> getProcedimentsForOgeUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/procedimentsForOge";

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

    GenericType<List<ProcedimentsRDTO>> localVarReturnType = new GenericType<List<ProcedimentsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the associated  procediment list 
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
   * @return PageDataOfProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfProcedimentsRDTO getProcedimentsRelacionatsUsingGET(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcedimentsRelacionatsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/relacionats/{id}"
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

    GenericType<PageDataOfProcedimentsRDTO> localVarReturnType = new GenericType<PageDataOfProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the procediments
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
   * @return PageDataOfProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfProcedimentsRDTO getProcedimentsUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments";

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

    GenericType<PageDataOfProcedimentsRDTO> localVarReturnType = new GenericType<PageDataOfProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns UGR and UGOs from procediment
   * 
   * @param idProcediment idProcediment (required)
   * @return List&lt;UnitatsGestoresRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<UnitatsGestoresRDTO> getUgsByIdProcedimentUsingGET(BigDecimal idProcediment) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProcediment' is set
    if (idProcediment == null) {
      throw new ApiException(400, "Missing the required parameter 'idProcediment' when calling getUgsByIdProcedimentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/getUgsByIdProcediment/{idProcediment}"
      .replaceAll("\\{" + "idProcediment" + "\\}", apiClient.escapeString(idProcediment.toString()));

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
   * Inserts the provided procediment
   * 
   * @param procedimentRDTO procedimentRDTO (required)
   * @return ProcedimentsResponse
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsResponse insertProcedimentsUsingPOST(ProcedimentsRDTO procedimentRDTO) throws ApiException {
    Object localVarPostBody = procedimentRDTO;
    
    // verify the required parameter 'procedimentRDTO' is set
    if (procedimentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentRDTO' when calling insertProcedimentsUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments";

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

    GenericType<ProcedimentsResponse> localVarReturnType = new GenericType<ProcedimentsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * ProcedimentBloquejatPerUnAltreUsuari
   * 
   * @param id id (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   */
  public Boolean procedimentBloquejatPerUnAltreUsuariUsingGET(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling procedimentBloquejatPerUnAltreUsuariUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/procedimentBloquejatPerUnAltreUsuari/{id}"
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

    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the procediment ids by codi
   * 
   * @param aplicacio aplicacio (optional)
   * @param procedimentCodis procedimentCodis (optional)
   * @param procedimentVersio procedimentVersio (optional)
   * @param tramitador tramitador (optional)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> procedimentIdsByCodiAndTramitadorUsingGET(String aplicacio, List<String> procedimentCodis, String procedimentVersio, String tramitador) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/procedimentIdsByCodiAndTramitador";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "aplicacio", aplicacio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "procedimentCodis", procedimentCodis));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "procedimentVersio", procedimentVersio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tramitador", tramitador));

    
    
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
   * Inserts new historic for documentacio
   * 
   * @param historicsRDTO historicsRDTO (required)
   * @return BigDecimal
   * @throws ApiException if fails to make API call
   */
  public BigDecimal registrarHistoricDocumentacioUsingPOST(HistoricsRDTO historicsRDTO) throws ApiException {
    Object localVarPostBody = historicsRDTO;
    
    // verify the required parameter 'historicsRDTO' is set
    if (historicsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'historicsRDTO' when calling registrarHistoricDocumentacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/historic/insertForDocumentacio";

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

    GenericType<BigDecimal> localVarReturnType = new GenericType<BigDecimal>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Inserts new historic
   * 
   * @param unitatsGestoresRDTO unitatsGestoresRDTO (required)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> registrarHistoricSincronitzacioUnitatsGestoresUsingPOST(List<UnitatsGestoresRDTO> unitatsGestoresRDTO) throws ApiException {
    Object localVarPostBody = unitatsGestoresRDTO;
    
    // verify the required parameter 'unitatsGestoresRDTO' is set
    if (unitatsGestoresRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'unitatsGestoresRDTO' when calling registrarHistoricSincronitzacioUnitatsGestoresUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/historic/sincronitzarUnitatsGestores";

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

    GenericType<List<BigDecimal>> localVarReturnType = new GenericType<List<BigDecimal>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Inserts new historic
   * 
   * @param historicsRDTO historicsRDTO (required)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> registrarHistoricTramitUsingPOST(List<HistoricsRDTO> historicsRDTO) throws ApiException {
    Object localVarPostBody = historicsRDTO;
    
    // verify the required parameter 'historicsRDTO' is set
    if (historicsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'historicsRDTO' when calling registrarHistoricTramitUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/historic/insert";

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

    GenericType<List<BigDecimal>> localVarReturnType = new GenericType<List<BigDecimal>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all procedures that meet the search criteria
   * 
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param codi Codi del procediment (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dir  (optional)
   * @param id Identificador pel qual es realitza la cerca (optional)
   * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca (optional)
   * @param ids Identificadors dels procediments ja associats (optional)
   * @param nextPageNumber  (optional)
   * @param nom Nom del procediment (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @return PageDataOfProcedimentsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfProcedimentsRDTO searchAssoaciatsUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String codi, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, BigDecimal id, BigDecimal idUsuari, List<BigDecimal> ids, Integer nextPageNumber, String nom, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/procediments/searchAssociats";

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
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idUsuari", idUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "ids", ids));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nom", nom));
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

    GenericType<PageDataOfProcedimentsRDTO> localVarReturnType = new GenericType<PageDataOfProcedimentsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the comentaris entries for the procedure that meet the search criteria
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
   * @return PageDataOfComentarisRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfComentarisRDTO searchComentarisUsingGET(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling searchComentarisUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/comentaris/{id}"
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

    GenericType<PageDataOfComentarisRDTO> localVarReturnType = new GenericType<PageDataOfComentarisRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
    String localVarPath = "/procediments/historic/{id}"
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
   * check if the units are being used
   * 
   * @param ugIdList ugIdList (required)
   * @return List&lt;ProcedimentsForUnitatsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProcedimentsForUnitatsRDTO> unitatsInUseUsingGET(String ugIdList) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'ugIdList' is set
    if (ugIdList == null) {
      throw new ApiException(400, "Missing the required parameter 'ugIdList' when calling unitatsInUseUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/unitatsInUse/{ugIdList}"
      .replaceAll("\\{" + "ugIdList" + "\\}", apiClient.escapeString(ugIdList.toString()));

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

    GenericType<List<ProcedimentsForUnitatsRDTO>> localVarReturnType = new GenericType<List<ProcedimentsForUnitatsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates the requested conf doc
   * 
   * @param idConfDoc idConfDoc (required)
   * @param idProc idProc (required)
   * @throws ApiException if fails to make API call
   */
  public void updateConfDocUsingPOST(BigDecimal idConfDoc, BigDecimal idProc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idConfDoc' is set
    if (idConfDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idConfDoc' when calling updateConfDocUsingPOST");
    }
    
    // verify the required parameter 'idProc' is set
    if (idProc == null) {
      throw new ApiException(400, "Missing the required parameter 'idProc' when calling updateConfDocUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/updateConfDoc/{idProc}/{idConfDoc}"
      .replaceAll("\\{" + "idConfDoc" + "\\}", apiClient.escapeString(idConfDoc.toString()))
      .replaceAll("\\{" + "idProc" + "\\}", apiClient.escapeString(idProc.toString()));

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
   * updates de requested darrera sincronitzacio
   * 
   * @param idProc idProc (required)
   * @return DateTime
   * @throws ApiException if fails to make API call
   */
  public DateTime updateDarreraSincronitzacioUsingPOST(BigDecimal idProc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProc' is set
    if (idProc == null) {
      throw new ApiException(400, "Missing the required parameter 'idProc' when calling updateDarreraSincronitzacioUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/darreraSincronitzacio/{idProc}"
      .replaceAll("\\{" + "idProc" + "\\}", apiClient.escapeString(idProc.toString()));

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

    GenericType<DateTime> localVarReturnType = new GenericType<DateTime>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates de requested doc info
   * 
   * @param infoDocProcedimentRDTO infoDocProcedimentRDTO (required)
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse updateDocUsingPOST(InfoDocProcedimentRDTO infoDocProcedimentRDTO) throws ApiException {
    Object localVarPostBody = infoDocProcedimentRDTO;
    
    // verify the required parameter 'infoDocProcedimentRDTO' is set
    if (infoDocProcedimentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'infoDocProcedimentRDTO' when calling updateDocUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/updateDoc";

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
   * Update the documentary version of the procedure
   * 
   * @param idProc idProc (required)
   * @param versioDoc versioDoc (required)
   * @return RestClientResponse
   * @throws ApiException if fails to make API call
   */
  public RestClientResponse updateVersioDocumentalUsingPOST(BigDecimal idProc, BigDecimal versioDoc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProc' is set
    if (idProc == null) {
      throw new ApiException(400, "Missing the required parameter 'idProc' when calling updateVersioDocumentalUsingPOST");
    }
    
    // verify the required parameter 'versioDoc' is set
    if (versioDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'versioDoc' when calling updateVersioDocumentalUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/versioDocumental/{idProc}/{versioDoc}"
      .replaceAll("\\{" + "idProc" + "\\}", apiClient.escapeString(idProc.toString()))
      .replaceAll("\\{" + "versioDoc" + "\\}", apiClient.escapeString(versioDoc.toString()));

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
   * Version the provided procediment
   * 
   * @param procedimentSerieDocRDTO procedimentSerieDocRDTO (required)
   * @return ProcedimentsResponse
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsResponse versionProcedimentProcUsingPOST(ProcedimentSerieDocRDTO procedimentSerieDocRDTO) throws ApiException {
    Object localVarPostBody = procedimentSerieDocRDTO;
    
    // verify the required parameter 'procedimentSerieDocRDTO' is set
    if (procedimentSerieDocRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'procedimentSerieDocRDTO' when calling versionProcedimentProcUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/versionar";

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

    GenericType<ProcedimentsResponse> localVarReturnType = new GenericType<ProcedimentsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Version the provided procediment
   * 
   * @param idProc idProc (required)
   * @return ProcedimentsResponse
   * @throws ApiException if fails to make API call
   */
  public ProcedimentsResponse versionProcedimentUsingPOST(BigDecimal idProc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idProc' is set
    if (idProc == null) {
      throw new ApiException(400, "Missing the required parameter 'idProc' when calling versionProcedimentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/versionarProcediment/{idProc}"
      .replaceAll("\\{" + "idProc" + "\\}", apiClient.escapeString(idProc.toString()));

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

    GenericType<ProcedimentsResponse> localVarReturnType = new GenericType<ProcedimentsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Get all versions of the provided codi
   * 
   * @param codi codi (required)
   * @return List&lt;ProcedimentsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ProcedimentsRDTO> versionsByCodiUsingGET(String codi) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codi' is set
    if (codi == null) {
      throw new ApiException(400, "Missing the required parameter 'codi' when calling versionsByCodiUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/procediments/versions/{codi}"
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

    GenericType<List<ProcedimentsRDTO>> localVarReturnType = new GenericType<List<ProcedimentsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
