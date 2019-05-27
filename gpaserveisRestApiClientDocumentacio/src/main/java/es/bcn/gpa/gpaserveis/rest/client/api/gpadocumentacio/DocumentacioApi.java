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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentCanviEstat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatRevisioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RestClientResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TransicionsEstatsRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-27T11:58:05.753+02:00")
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
   * updates the doc entrada responsable
   * 
   * @param docsEntradaRDTO docsEntradaRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO actualitzarDeclaracioResponsable(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaRDTO;
    
    // verify the required parameter 'docsEntradaRDTO' is set
    if (docsEntradaRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaRDTO' when calling actualitzarDeclaracioResponsable");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling actualitzarDeclaracioResponsable");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/responsable/{idExpedient}"
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
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * actualitzar el document d&#39;entrada
   * 
   * @param docsEntradaRDTO docsEntradaRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO actualitzarDocumentEntrada(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaRDTO;
    
    // verify the required parameter 'docsEntradaRDTO' is set
    if (docsEntradaRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaRDTO' when calling actualitzarDocumentEntrada");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling actualitzarDocumentEntrada");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/{idExpedient}"
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
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * actualitzar document tramitacio
   * 
   * @param docsTramitacioRDTO docsTramitacioRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO actualitzarDocumentTramitacio(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsTramitacioRDTO;
    
    // verify the required parameter 'docsTramitacioRDTO' is set
    if (docsTramitacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacioRDTO' when calling actualitzarDocumentTramitacio");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling actualitzarDocumentTramitacio");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/{idExpedient}"
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
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates the requeriment
   * 
   * @param guardarRequerimentExpedientRDTO guardarRequerimentExpedientRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO actualitzarRequeriment(GuardarRequerimentExpedient guardarRequerimentExpedientRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = guardarRequerimentExpedientRDTO;
    
    // verify the required parameter 'guardarRequerimentExpedientRDTO' is set
    if (guardarRequerimentExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'guardarRequerimentExpedientRDTO' when calling actualitzarRequeriment");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling actualitzarRequeriment");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/requeriment/{idExpedient}"
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
    return apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
   * associa el registre a la llista de documentació
   * 
   * @param docsEntActualizarRegistreRDTO docsEntActualizarRegistreRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void associarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistreRDTO) throws ApiException {
    Object localVarPostBody = docsEntActualizarRegistreRDTO;
    
    // verify the required parameter 'docsEntActualizarRegistreRDTO' is set
    if (docsEntActualizarRegistreRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntActualizarRegistreRDTO' when calling associarRegistreDocsEnt");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/associarRegistreDocsEnt";

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
   * associa el registre a la documentació de l&#39;expedient
   * 
   * @param documentActualizarRegistreRDTO documentActualizarRegistreRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void associarRegistreDocumentacio(DocumentActualizarRegistre documentActualizarRegistreRDTO) throws ApiException {
    Object localVarPostBody = documentActualizarRegistreRDTO;
    
    // verify the required parameter 'documentActualizarRegistreRDTO' is set
    if (documentActualizarRegistreRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'documentActualizarRegistreRDTO' when calling associarRegistreDocumentacio");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/associarRegistreDocumentacio";

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
   * Cancel·lar una petició per signar o validar un document
   * 
   * @param idDocument idDocument (required)
   * @throws ApiException if fails to make API call
   */
  public void cancelarSignarDocumentUsingPOST(BigDecimal idDocument) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDocument' is set
    if (idDocument == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocument' when calling cancelarSignarDocumentUsingPOST");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/cancelarPeticioPortaSig/{idDocument}"
      .replaceAll("\\{" + "idDocument" + "\\}", apiClient.escapeString(idDocument.toString()));

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
   * Updates all selected DocsTramitacio with the EstatsDocument specified
   * 
   * @param documentCanviEstatRDTO documentCanviEstatRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void canviEstatDocumentacioTramitacioUsingPOST(DocumentCanviEstat documentCanviEstatRDTO) throws ApiException {
    Object localVarPostBody = documentCanviEstatRDTO;
    
    // verify the required parameter 'documentCanviEstatRDTO' is set
    if (documentCanviEstatRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'documentCanviEstatRDTO' when calling canviEstatDocumentacioTramitacioUsingPOST");
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
   * Returns the requested dades operacio requerit
   * 
   * @param idDoc idDoc (required)
   * @return List&lt;BigDecimal&gt;
   * @throws ApiException if fails to make API call
   */
  public List<BigDecimal> cercaDadesOperacioRequerits(BigDecimal idDoc) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDoc' is set
    if (idDoc == null) {
      throw new ApiException(400, "Missing the required parameter 'idDoc' when calling cercaDadesOperacioRequerits");
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
   * ComprovarDocumentsSignats
   * 
   * @param idDocumentacio idDocumentacio (required)
   * @return Boolean
   * @throws ApiException if fails to make API call
   */
  public Boolean comprovarDocumentsSignatsUsingGET(BigDecimal idDocumentacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDocumentacio' is set
    if (idDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocumentacio' when calling comprovarDocumentsSignatsUsingGET");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/comprovarDocumentsSignats/{idDocumentacio}"
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

    GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {};
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
   * Returns the requested document
   * 
   * @param id id (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO consultarDadesDocumentGenerat(BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling consultarDadesDocumentGenerat");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/{id}"
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

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * updates the doc entrada responsable
   * 
   * @param docsEntradaRDTO docsEntradaRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO crearDeclaracioResponsable(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaRDTO;
    
    // verify the required parameter 'docsEntradaRDTO' is set
    if (docsEntradaRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaRDTO' when calling crearDeclaracioResponsable");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling crearDeclaracioResponsable");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/responsable/{idExpedient}"
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
   * crea el document d&#39;entrada
   * 
   * @param docsEntradaRDTO docsEntradaRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO crearDocumentEntrada(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsEntradaRDTO;
    
    // verify the required parameter 'docsEntradaRDTO' is set
    if (docsEntradaRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntradaRDTO' when calling crearDocumentEntrada");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling crearDocumentEntrada");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/{idExpedient}"
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
   * crea el document de tramitació
   * 
   * @param docsTramitacioRDTO docsTramitacioRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO crearDocumentTramitacio(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsTramitacioRDTO;
    
    // verify the required parameter 'docsTramitacioRDTO' is set
    if (docsTramitacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacioRDTO' when calling crearDocumentTramitacio");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling crearDocumentTramitacio");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/{idExpedient}"
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
   * Crear una petició per signar o validar un document
   * 
   * @param signarDocumentRDTO signarDocumentRDTO (required)
   * @return PeticionsPortasig
   * @throws ApiException if fails to make API call
   */
  public PeticionsPortasig crearPeticioPortaSig(SignarDocument signarDocumentRDTO) throws ApiException {
    Object localVarPostBody = signarDocumentRDTO;
    
    // verify the required parameter 'signarDocumentRDTO' is set
    if (signarDocumentRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'signarDocumentRDTO' when calling crearPeticioPortaSig");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/crearPeticioPortaSig";

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

    GenericType<PeticionsPortasig> localVarReturnType = new GenericType<PeticionsPortasig>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
   * updates the doc entrada
   * 
   * @param docsEntrada docsEntrada (required)
   * @param file file (required)
   * @param idExpedient idExpedient (required)
   * @return DocsEntradaRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsEntradaRDTO guardarDocumentEntradaFitxer(String docsEntrada, org.springframework.web.multipart.MultipartFile file, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'docsEntrada' is set
    if (docsEntrada == null) {
      throw new ApiException(400, "Missing the required parameter 'docsEntrada' when calling guardarDocumentEntradaFitxer");
    }
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling guardarDocumentEntradaFitxer");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling guardarDocumentEntradaFitxer");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/entrada/fitxer/{idExpedient}"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "docsEntrada", docsEntrada));

    
    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<DocsEntradaRDTO> localVarReturnType = new GenericType<DocsEntradaRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * save the doc tramitacio i fitxer
   * 
   * @param docsTramitacio docsTramitacio (required)
   * @param file file (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO guardarDocumentTramitacioFitxer(String docsTramitacio, org.springframework.web.multipart.MultipartFile file, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'docsTramitacio' is set
    if (docsTramitacio == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacio' when calling guardarDocumentTramitacioFitxer");
    }
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling guardarDocumentTramitacioFitxer");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling guardarDocumentTramitacioFitxer");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/fitxer/{idExpedient}"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "docsTramitacio", docsTramitacio));

    
    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * save the doc tramitacio i plantilla
   * 
   * @param docsTramitacioRDTO docsTramitacioRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO guardarDocumentTramitacioPlantilla(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = docsTramitacioRDTO;
    
    // verify the required parameter 'docsTramitacioRDTO' is set
    if (docsTramitacioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'docsTramitacioRDTO' when calling guardarDocumentTramitacioPlantilla");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling guardarDocumentTramitacioPlantilla");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tramitacio/plantilla/{idExpedient}"
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
   * crea o actualitza el requeriment i desa el document
   * 
   * @param file file (required)
   * @param idExpedient idExpedient (required)
   * @param requerimentExpedient requerimentExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO guardarRequerimentFitxer(org.springframework.web.multipart.MultipartFile file, BigDecimal idExpedient, String requerimentExpedient) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling guardarRequerimentFitxer");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling guardarRequerimentFitxer");
    }
    
    // verify the required parameter 'requerimentExpedient' is set
    if (requerimentExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'requerimentExpedient' when calling guardarRequerimentFitxer");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/requeriment/fitxer/{idExpedient}"
      .replaceAll("\\{" + "idExpedient" + "\\}", apiClient.escapeString(idExpedient.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "requerimentExpedient", requerimentExpedient));

    
    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      "*/*"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * crea o actualitza el requeriment i desa la plantilla
   * 
   * @param guardarRequerimentExpedientRDTO guardarRequerimentExpedientRDTO (required)
   * @param idExpedient idExpedient (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO guardarRequerimentPlantilla(GuardarRequerimentExpedient guardarRequerimentExpedientRDTO, BigDecimal idExpedient) throws ApiException {
    Object localVarPostBody = guardarRequerimentExpedientRDTO;
    
    // verify the required parameter 'guardarRequerimentExpedientRDTO' is set
    if (guardarRequerimentExpedientRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'guardarRequerimentExpedientRDTO' when calling guardarRequerimentPlantilla");
    }
    
    // verify the required parameter 'idExpedient' is set
    if (idExpedient == null) {
      throw new ApiException(400, "Missing the required parameter 'idExpedient' when calling guardarRequerimentPlantilla");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/requeriment/plantilla/{idExpedient}"
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
   * Returns the requested documentacio tramitacio
   * 
   * @param idNotificacio idNotificacio (required)
   * @return DocsTramitacioRDTO
   * @throws ApiException if fails to make API call
   */
  public DocsTramitacioRDTO obtenirDocsTramitacioByNotificationId(BigDecimal idNotificacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idNotificacio' is set
    if (idNotificacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idNotificacio' when calling obtenirDocsTramitacioByNotificationId");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/docsTramitacioByNotificationId/{idNotificacio}"
      .replaceAll("\\{" + "idNotificacio" + "\\}", apiClient.escapeString(idNotificacio.toString()));

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

    GenericType<DocsTramitacioRDTO> localVarReturnType = new GenericType<DocsTramitacioRDTO>() {};
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
   * @param documentRevisioRDTO documentRevisioRDTO (required)
   * @throws ApiException if fails to make API call
   */
  public void revisarDocumentacioEntrada(DocumentRevisio documentRevisioRDTO) throws ApiException {
    Object localVarPostBody = documentRevisioRDTO;
    
    // verify the required parameter 'documentRevisioRDTO' is set
    if (documentRevisioRDTO == null) {
      throw new ApiException(400, "Missing the required parameter 'documentRevisioRDTO' when calling revisarDocumentacioEntrada");
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
   * Closes the expedient&#39;s requirements
   * 
   * @param idDocumentacio idDocumentacio (required)
   * @throws ApiException if fails to make API call
   */
  public void tancarRequerimentsExpedient(BigDecimal idDocumentacio) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idDocumentacio' is set
    if (idDocumentacio == null) {
      throw new ApiException(400, "Missing the required parameter 'idDocumentacio' when calling tancarRequerimentsExpedient");
    }
    
    // create path and map variables
    String localVarPath = "/documentacio/tancarRequeriments/{idDocumentacio}"
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
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
