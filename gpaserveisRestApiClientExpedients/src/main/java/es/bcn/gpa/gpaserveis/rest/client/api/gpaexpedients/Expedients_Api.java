package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Configuration;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.Pair;

import javax.ws.rs.core.GenericType;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AbandonarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import java.math.BigDecimal;
import org.joda.time.DateTime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.InputStreamResource;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistrarSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaAbandonarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaRegistrarSolicitudExpedient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-12T13:12:30.658+02:00")
public class Expedients_Api {
  private ApiClient apiClient;

  public Expedients_Api() {
    this(Configuration.getDefaultApiClient());
  }

  public Expedients_Api(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Desist the provided expedient
   * 
   * @param abandonarExpedientRDTO abandonarExpedientRDTO (required)
   * @return RespostaAbandonarExpedient
   * @throws ApiException if fails to make API call
   */
  public RespostaAbandonarExpedient abandonarDesistirExpedient(AbandonarExpedient abandonarExpedientRDTO) throws ApiException {
    Object localVarPostBody = abandonarExpedientRDTO;
    
    // verify the required parameter 'abandonarExpedientRDTO' is set
    if (abandonarExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'abandonarExpedientRDTO' when calling abandonarDesistirExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/desistir";

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

    GenericType<RespostaAbandonarExpedient> localVarReturnType = new GenericType<RespostaAbandonarExpedient>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Renounce the provided expedient
   * 
   * @param abandonarExpedientRDTO abandonarExpedientRDTO (required)
   * @return RespostaAbandonarExpedient
   * @throws ApiException if fails to make API call
   */
  public RespostaAbandonarExpedient abandonarRenunciarExpedient(AbandonarExpedient abandonarExpedientRDTO) throws ApiException {
    Object localVarPostBody = abandonarExpedientRDTO;
    
    // verify the required parameter 'abandonarExpedientRDTO' is set
    if (abandonarExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'abandonarExpedientRDTO' when calling abandonarRenunciarExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/renunciar";

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

    GenericType<RespostaAbandonarExpedient> localVarReturnType = new GenericType<RespostaAbandonarExpedient>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates the provided expedient including specific data
   * 
   * @param actualitzarDadesSollicitudRDTO actualitzarDadesSollicitudRDTO (required)
   * @return ExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public ExpedientsRDTO actualitzarDadesSollicitud(ActualitzarDadesSollicitud actualitzarDadesSollicitudRDTO) throws ApiException {
    Object localVarPostBody = actualitzarDadesSollicitudRDTO;
    
    // verify the required parameter 'actualitzarDadesSollicitudRDTO' is set
    if (actualitzarDadesSollicitudRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'actualitzarDadesSollicitudRDTO' when calling actualitzarDadesSollicitud");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/dadesSollicitud";

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

    GenericType<ExpedientsRDTO> localVarReturnType = new GenericType<ExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the expedients that meet the search criteria
   * 
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param aplicacioNegoci Aplicació de negoci (optional)
   * @param avisList Llista d&#39;avisos de l&#39;expedient (optional)
   * @param codi Codi de l&#39;expedient (optional)
   * @param criteriDeCercaDadesOperacioList0Id Identificador de la dada d&#39;operació (optional)
   * @param criteriDeCercaDadesOperacioList0Tipus Tipus de la dada d&#39;operació (optional)
   * @param criteriDeCercaDadesOperacioList0Valor Valor de la dada d&#39;operació (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dataPresentacioDes Data presentació des de (optional)
   * @param dataPresentacioFinsA Data presentació fins a (optional)
   * @param dir  (optional)
   * @param estatList Llista d&#39;estats de l&#39;expedient (optional)
   * @param id Identificador pel qual es realitza la cerca (optional)
   * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca (optional)
   * @param isOge Invocació des de OGE (optional)
   * @param nextPageNumber  (optional)
   * @param numeroDocumentSollicitant Numero de document d&#39;identificació del sol·licitant (optional)
   * @param numeroDocumentSollicitantEstricte Numero de document d&#39;identificació del sol·licitant estricte (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param procedimentCodisList Llista dels codis dels procediments (optional)
   * @param procedimentId Identificador del procediment (optional)
   * @param procedimentVersio Versió del procediment (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @param tramitador Tramitador de l&#39;expedient (optional)
   * @param unitatsGestoresList Llista d&#39;unitats gestores (optional)
   * @return PageDataOfExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfExpedientsRDTO cercaExpedients(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String aplicacioNegoci, List<String> avisList, String codi, BigDecimal criteriDeCercaDadesOperacioList0Id, BigDecimal criteriDeCercaDadesOperacioList0Tipus, String criteriDeCercaDadesOperacioList0Valor, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime dataPresentacioDes, DateTime dataPresentacioFinsA, String dir, List<BigDecimal> estatList, BigDecimal id, BigDecimal idUsuari, Boolean isOge, Integer nextPageNumber, String numeroDocumentSollicitant, String numeroDocumentSollicitantEstricte, Integer pageSize, Integer previousPageNumber, List<String> procedimentCodisList, BigDecimal procedimentId, String procedimentVersio, String sort, Long totalElements, Integer totalPages, String tramitador, List<BigDecimal> unitatsGestoresList) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/expedients/search";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "aplicacioNegoci", aplicacioNegoci));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "avisList", avisList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "codi", codi));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "criteriDeCercaDadesOperacioList[0].id", criteriDeCercaDadesOperacioList0Id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "criteriDeCercaDadesOperacioList[0].tipus", criteriDeCercaDadesOperacioList0Tipus));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "criteriDeCercaDadesOperacioList[0].valor", criteriDeCercaDadesOperacioList0Valor));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasNextPage", currentPageHasNextPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageHasPreviousPage", currentPageHasPreviousPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsFirstPage", currentPageIsFirstPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageIsLastPage", currentPageIsLastPage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "currentPageNumber", currentPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataPresentacioDes", dataPresentacioDes));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataPresentacioFinsA", dataPresentacioFinsA));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dir", dir));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "estatList", estatList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idUsuari", idUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "isOge", isOge));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "numeroDocumentSollicitant", numeroDocumentSollicitant));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "numeroDocumentSollicitantEstricte", numeroDocumentSollicitantEstricte));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "procedimentCodisList", procedimentCodisList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "procedimentId", procedimentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "procedimentVersio", procedimentVersio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalElements", totalElements));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "totalPages", totalPages));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tramitador", tramitador));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "unitatsGestoresList", unitatsGestoresList));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<PageDataOfExpedientsRDTO> localVarReturnType = new GenericType<PageDataOfExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested expedient
   * 
   * @param id id (required)
   * @return ExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public ExpedientsRDTO consultarDadesExpedient(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling consultarDadesExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/{id}"
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

    GenericType<ExpedientsRDTO> localVarReturnType = new GenericType<ExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested expedient
   * 
   * @param codi codi (required)
   * @return ExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public ExpedientsRDTO consultarDadesExpedientPerCodi(String codi) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codi' is set
    if (codi == null) {
      throw new ApiException(400, "Missing the required parameter 'codi' when calling consultarDadesExpedientPerCodi");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/perCodi/{codi}"
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

    GenericType<ExpedientsRDTO> localVarReturnType = new GenericType<ExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Insert the provided expedient
   * 
   * @param expedientsRDTO expedientsRDTO (required)
   * @return ExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public ExpedientsRDTO crearSollicitudExpedient(ExpedientsRDTO expedientsRDTO) throws ApiException {
    Object localVarPostBody = expedientsRDTO;
    
    // verify the required parameter 'expedientsRDTO' is set
    if (expedientsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'expedientsRDTO' when calling crearSollicitudExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients";

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

    GenericType<ExpedientsRDTO> localVarReturnType = new GenericType<ExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns excel file with all the expedients that meet the search criteria
   * 
   * @param aplicacioNegoci Aplicació de negoci (optional)
   * @param avisList Llista d&#39;avisos de l&#39;expedient (optional)
   * @param codi Codi de l&#39;expedient (optional)
   * @param criteriDeCercaDadesOperacioList0Id Identificador de la dada d&#39;operació (optional)
   * @param criteriDeCercaDadesOperacioList0Tipus Tipus de la dada d&#39;operació (optional)
   * @param criteriDeCercaDadesOperacioList0Valor Valor de la dada d&#39;operació (optional)
   * @param dataPresentacioDes Data presentació des de (optional)
   * @param dataPresentacioFinsA Data presentació fins a (optional)
   * @param estatList Llista d&#39;estats de l&#39;expedient (optional)
   * @param id Identificador pel qual es realitza la cerca (optional)
   * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca (optional)
   * @param isOge Invocació des de OGE (optional)
   * @param numeroDocumentSollicitant Numero de document d&#39;identificació del sol·licitant (optional)
   * @param numeroDocumentSollicitantEstricte Numero de document d&#39;identificació del sol·licitant estricte (optional)
   * @param procedimentCodisList Llista dels codis dels procediments (optional)
   * @param procedimentId Identificador del procediment (optional)
   * @param procedimentVersio Versió del procediment (optional)
   * @param tramitador Tramitador de l&#39;expedient (optional)
   * @param unitatsGestoresList Llista d&#39;unitats gestores (optional)
   * @return InputStreamResource
   * @throws ApiException if fails to make API call
   */
  public InputStreamResource exportarCercaExpedientExcel(String aplicacioNegoci, List<String> avisList, String codi, BigDecimal criteriDeCercaDadesOperacioList0Id, BigDecimal criteriDeCercaDadesOperacioList0Tipus, String criteriDeCercaDadesOperacioList0Valor, DateTime dataPresentacioDes, DateTime dataPresentacioFinsA, List<BigDecimal> estatList, BigDecimal id, BigDecimal idUsuari, Boolean isOge, String numeroDocumentSollicitant, String numeroDocumentSollicitantEstricte, List<String> procedimentCodisList, BigDecimal procedimentId, String procedimentVersio, String tramitador, List<BigDecimal> unitatsGestoresList) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/expedients/exportarCercaExpedientExcel";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "aplicacioNegoci", aplicacioNegoci));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "avisList", avisList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "codi", codi));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "criteriDeCercaDadesOperacioList[0].id", criteriDeCercaDadesOperacioList0Id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "criteriDeCercaDadesOperacioList[0].tipus", criteriDeCercaDadesOperacioList0Tipus));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "criteriDeCercaDadesOperacioList[0].valor", criteriDeCercaDadesOperacioList0Valor));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataPresentacioDes", dataPresentacioDes));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataPresentacioFinsA", dataPresentacioFinsA));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "estatList", estatList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idUsuari", idUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "isOge", isOge));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "numeroDocumentSollicitant", numeroDocumentSollicitant));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "numeroDocumentSollicitantEstricte", numeroDocumentSollicitantEstricte));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "procedimentCodisList", procedimentCodisList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "procedimentId", procedimentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "procedimentVersio", procedimentVersio));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tramitador", tramitador));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "unitatsGestoresList", unitatsGestoresList));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<InputStreamResource> localVarReturnType = new GenericType<InputStreamResource>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested child expedients
   * 
   * @param idExpedient idExpedient (required)
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
   * @return PageDataOfExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfExpedientsRDTO getChildExpedientsUsingGET(BigDecimal idExpedient, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling getChildExpedientsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/acumulacioExpedients/{idExpedient}/acumulacio/children"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

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

    GenericType<PageDataOfExpedientsRDTO> localVarReturnType = new GenericType<PageDataOfExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns al the expedients
   * 
   * @return List&lt;ExpedientsRDTO&gt;
   * @throws ApiException if fails to make API call
   */
  public List<ExpedientsRDTO> getExpedientsUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/expedients/all";

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

    GenericType<List<ExpedientsRDTO>> localVarReturnType = new GenericType<List<ExpedientsRDTO>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the expedients gestores
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
   * @return PageDataOfExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfExpedientsRDTO getExpedientsUsingGET1(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/expedients";

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

    GenericType<PageDataOfExpedientsRDTO> localVarReturnType = new GenericType<PageDataOfExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested parent&#39;s expedient
   * 
   * @param idExpedient idExpedient (required)
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
   * @return PageDataOfExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfExpedientsRDTO getParentExpedientUsingGET(BigDecimal idExpedient, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling getParentExpedientUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/acumulacioExpedients/{idExpedient}/acumulacio/parent"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

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

    GenericType<PageDataOfExpedientsRDTO> localVarReturnType = new GenericType<PageDataOfExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns the requested unitat
   * 
   * @param codi codi (required)
   * @return RegistreAssentamentRDTO
   * @throws ApiException if fails to make API call
   */
  public RegistreAssentamentRDTO getRegistreAssentamentUsingGET(String codi) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codi' is set
    if (codi == null) {
      throw new ApiException(400, "Missing the required parameter 'codi' when calling getRegistreAssentamentUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/registre";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "codi", codi));

    
    
    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<RegistreAssentamentRDTO> localVarReturnType = new GenericType<RegistreAssentamentRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the expedients gestores
   * 
   * @return Integer
   * @throws ApiException if fails to make API call
   */
  public Integer obtenirIndicadorExpedientsUsingGET() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/expedients/obtenirIndicadorExpedients";

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

    GenericType<Integer> localVarReturnType = new GenericType<Integer>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * jexl
   * 
   * @param idExpedient idExpedient (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String obtenirXmlEvaluateUsingGET(BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling obtenirXmlEvaluateUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/obtenirXmlEvaluate/{idExpedient}"
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

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Register the provided expedient
   * 
   * @param registrarSolicitudExpedientRDTO registrarSolicitudExpedientRDTO (required)
   * @return RespostaRegistrarSolicitudExpedient
   * @throws ApiException if fails to make API call
   */
  public RespostaRegistrarSolicitudExpedient registrarSolicitudExpedient(RegistrarSolicitudExpedient registrarSolicitudExpedientRDTO) throws ApiException {
    Object localVarPostBody = registrarSolicitudExpedientRDTO;
    
    // verify the required parameter 'registrarSolicitudExpedientRDTO' is set
    if (registrarSolicitudExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'registrarSolicitudExpedientRDTO' when calling registrarSolicitudExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/expedients/registrar";

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

    GenericType<RespostaRegistrarSolicitudExpedient> localVarReturnType = new GenericType<RespostaRegistrarSolicitudExpedient>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns all the expedients that meet the search criteria
   * 
   * @param absoluteRowNumberOfFirstRowInCurrentPage  (optional)
   * @param absoluteRowNumberOfLastRowInCurrentPage  (optional)
   * @param codi Codi de l&#39;expedient (optional)
   * @param currentPageHasNextPage  (optional)
   * @param currentPageHasPreviousPage  (optional)
   * @param currentPageIsFirstPage  (optional)
   * @param currentPageIsLastPage  (optional)
   * @param currentPageNumber  (optional)
   * @param dir  (optional)
   * @param id Identificador pel qual es realitza la cerca (optional)
   * @param idProcedimentAcumulat Identificador del procediment de l&#39;expedient a acumular (optional)
   * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca (optional)
   * @param idsExpedientAcumulatList Identificador de l&#39;expedient a acumular (optional)
   * @param nextPageNumber  (optional)
   * @param nombreDocument Nombre del document del sol·licitant (optional)
   * @param pageSize  (optional)
   * @param previousPageNumber  (optional)
   * @param sollicitant Nom del sol·licitant (optional)
   * @param sort  (optional)
   * @param totalElements  (optional)
   * @param totalPages  (optional)
   * @return PageDataOfExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public PageDataOfExpedientsRDTO searchExpedientsAcumuladorsUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String codi, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, BigDecimal id, BigDecimal idProcedimentAcumulat, BigDecimal idUsuari, List<BigDecimal> idsExpedientAcumulatList, Integer nextPageNumber, String nombreDocument, Integer pageSize, Integer previousPageNumber, String sollicitant, String sort, Long totalElements, Integer totalPages) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/acumulacioExpedients/searchExpedientsAcumuladors";

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
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idProcedimentAcumulat", idProcedimentAcumulat));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idUsuari", idUsuari));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "idsExpedientAcumulatList", idsExpedientAcumulatList));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nextPageNumber", nextPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nombreDocument", nombreDocument));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "previousPageNumber", previousPageNumber));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sollicitant", sollicitant));
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

    GenericType<PageDataOfExpedientsRDTO> localVarReturnType = new GenericType<PageDataOfExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates the provided expedient
   * 
   * @param expedientsRDTO expedientsRDTO (required)
   * @return ExpedientsRDTO
   * @throws ApiException if fails to make API call
   */
  public ExpedientsRDTO updateExpedientUsingPUT(ExpedientsRDTO expedientsRDTO) throws ApiException {
    Object localVarPostBody = expedientsRDTO;
    
    // verify the required parameter 'expedientsRDTO' is set
    if (expedientsRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'expedientsRDTO' when calling updateExpedientUsingPUT");
    }
    
    // create path and map variables
    String localVarPath = "/expedients";

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

    GenericType<ExpedientsRDTO> localVarReturnType = new GenericType<ExpedientsRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
