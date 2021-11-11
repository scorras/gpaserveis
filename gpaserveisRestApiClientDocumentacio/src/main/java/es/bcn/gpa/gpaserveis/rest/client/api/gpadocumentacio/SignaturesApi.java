package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ByteArrayResource;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackManuscrita;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CancelarPeticioTabletResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocsTramPolitiquesSigRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConsultarSignaturaResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DadesSignatura;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsSignaturesPendentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfRespostaCercaDocumentsPendentSignarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RebutjarDocumentsPendentsSignar;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocumentMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarPortasignaturesDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UsuariTabletResponseRDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-04T14:21:11.408+01:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.SignaturesApi")
public class SignaturesApi {
    private ApiClient apiClient;

    public SignaturesApi() {
        this(new ApiClient());
    }

    @Autowired
    public SignaturesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Callback per actualitzar l&#39;estat dels documents enviats a portasig
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param callbackPortaSigRDTO callbackPortaSigRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void callbackPortaSig(CallbackPortaSig callbackPortaSigRDTO) throws RestClientException {
        Object postBody = callbackPortaSigRDTO;
        
        // verify the required parameter 'callbackPortaSigRDTO' is set
        if (callbackPortaSigRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'callbackPortaSigRDTO' when calling callbackPortaSig");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/callbackPortaSig").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar un document en la tablet
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocument idDocument
     * @return CancelarPeticioTabletResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CancelarPeticioTabletResponse cancelarPeticioTablet(Integer idDocument) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocument' is set
        if (idDocument == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocument' when calling cancelarPeticioTablet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocument", idDocument);
        String path = UriComponentsBuilder.fromPath("/signatures/cancelarPeticioTablet/{idDocument}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CancelarPeticioTabletResponse> returnType = new ParameterizedTypeReference<CancelarPeticioTabletResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Cancel·lar una petició per signar o validar un document
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocument idDocument
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void cancelarSignarDocumentUsingPOST(Integer idDocument) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocument' is set
        if (idDocument == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocument' when calling cancelarSignarDocumentUsingPOST");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocument", idDocument);
        String path = UriComponentsBuilder.fromPath("/signatures/cancelarPeticioPortaSig/{idDocument}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Cercar documents pendents signar
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param absoluteRowNumberOfFirstRowInCurrentPage The absoluteRowNumberOfFirstRowInCurrentPage parameter
     * @param absoluteRowNumberOfLastRowInCurrentPage The absoluteRowNumberOfLastRowInCurrentPage parameter
     * @param currentPageHasNextPage The currentPageHasNextPage parameter
     * @param currentPageHasPreviousPage The currentPageHasPreviousPage parameter
     * @param currentPageIsFirstPage The currentPageIsFirstPage parameter
     * @param currentPageIsLastPage The currentPageIsLastPage parameter
     * @param currentPageNumber The currentPageNumber parameter
     * @param dir The dir parameter
     * @param expedientCodi Codi de l&#39;expedient
     * @param nextPageNumber The nextPageNumber parameter
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param procedimentId Identificador del procediment
     * @param sort The sort parameter
     * @param tipusDocument Tipus del document
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @return PageDataOfRespostaCercaDocumentsPendentSignarRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfRespostaCercaDocumentsPendentSignarRDTO cercarDocumentsPendentsSignarUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, String expedientCodi, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, BigDecimal procedimentId, String sort, String tipusDocument, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/signatures/cercarDocumentsPendentsSignar").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasNextPage", currentPageHasNextPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasPreviousPage", currentPageHasPreviousPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsFirstPage", currentPageIsFirstPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsLastPage", currentPageIsLastPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageNumber", currentPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dir", dir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "expedientCodi", expedientCodi));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "procedimentId", procedimentId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tipusDocument", tipusDocument));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageDataOfRespostaCercaDocumentsPendentSignarRDTO> returnType = new ParameterizedTypeReference<PageDataOfRespostaCercaDocumentsPendentSignarRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Consultar dades signatura
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codiPeticio codiPeticio
     * @return DadesSignatura
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DadesSignatura consultarDadesSignatura(String codiPeticio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codiPeticio' is set
        if (codiPeticio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codiPeticio' when calling consultarDadesSignatura");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codiPeticio", codiPeticio);
        String path = UriComponentsBuilder.fromPath("/signatures/dadesSignatura/{codiPeticio}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<DadesSignatura> returnType = new ParameterizedTypeReference<DadesSignatura>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Consultar l&#39;id de gestor documental de el document signat generat a partir d&#39;una petició de signatura i un document original
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocumentGestorDocumental idDocumentGestorDocumental
     * @param idPeticio idPeticio
     * @return ConsultarSignaturaResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ConsultarSignaturaResponse consultarSignatura(String idDocumentGestorDocumental, String idPeticio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocumentGestorDocumental' is set
        if (idDocumentGestorDocumental == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocumentGestorDocumental' when calling consultarSignatura");
        }
        
        // verify the required parameter 'idPeticio' is set
        if (idPeticio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idPeticio' when calling consultarSignatura");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocumentGestorDocumental", idDocumentGestorDocumental);
        uriVariables.put("idPeticio", idPeticio);
        String path = UriComponentsBuilder.fromPath("/signatures/{idPeticio}/consultarSignatura/{idDocumentGestorDocumental}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<ConsultarSignaturaResponse> returnType = new ParameterizedTypeReference<ConsultarSignaturaResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar o validar un document
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param signarPortasignaturesDocumentRDTO signarPortasignaturesDocumentRDTO
     * @return PeticionsPortasig
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PeticionsPortasig crearPeticioPortaSig(SignarPortasignaturesDocument signarPortasignaturesDocumentRDTO) throws RestClientException {
        Object postBody = signarPortasignaturesDocumentRDTO;
        
        // verify the required parameter 'signarPortasignaturesDocumentRDTO' is set
        if (signarPortasignaturesDocumentRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'signarPortasignaturesDocumentRDTO' when calling crearPeticioPortaSig");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/crearPeticioPortaSig").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PeticionsPortasig> returnType = new ParameterizedTypeReference<PeticionsPortasig>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar o validar un document sota diverses modalitats i polítiques
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param signarDocumentMassiuRDTO signarDocumentMassiuRDTO
     * @return List&lt;PeticionsPortasig&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PeticionsPortasig> crearPeticioSignaturaMassiuUsingPOST(SignarDocumentMassiu signarDocumentMassiuRDTO) throws RestClientException {
        Object postBody = signarDocumentMassiuRDTO;
        
        // verify the required parameter 'signarDocumentMassiuRDTO' is set
        if (signarDocumentMassiuRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'signarDocumentMassiuRDTO' when calling crearPeticioSignaturaMassiuUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/crearPeticioSignaturaMassiu").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<PeticionsPortasig>> returnType = new ParameterizedTypeReference<List<PeticionsPortasig>>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * downloadUltimaSignatura
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idUltimaSignatura idUltimaSignatura
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] descarregarDocumentExpedientSignat(Integer idUltimaSignatura) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idUltimaSignatura' is set
        if (idUltimaSignatura == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idUltimaSignatura' when calling descarregarDocumentExpedientSignat");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idUltimaSignatura", idUltimaSignatura);
        String path = UriComponentsBuilder.fromPath("/signatures/descarregarDocumentExpedientSignat/{idUltimaSignatura}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<byte[]> returnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * downloadUltimaSignaturaFile
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDoc idDoc
     * @param idExpedient idExpedient
     * @return ByteArrayResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ByteArrayResource downloadUltimaSignaturaFileUsingGET(Integer idDoc, Integer idExpedient) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDoc' is set
        if (idDoc == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDoc' when calling downloadUltimaSignaturaFileUsingGET");
        }
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling downloadUltimaSignaturaFileUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDoc", idDoc);
        uriVariables.put("idExpedient", idExpedient);
        String path = UriComponentsBuilder.fromPath("/signatures/downloadUltimaSignaturaFile/{idExpedient}/{idDoc}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<ByteArrayResource> returnType = new ParameterizedTypeReference<ByteArrayResource>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Callback per actualitzar l&#39;estat dels documents enviats a tablet
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param callbackManuscritaRDTO callbackManuscritaRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void finalitzarSignaturaTablet(CallbackManuscrita callbackManuscritaRDTO) throws RestClientException {
        Object postBody = callbackManuscritaRDTO;
        
        // verify the required parameter 'callbackManuscritaRDTO' is set
        if (callbackManuscritaRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'callbackManuscritaRDTO' when calling finalitzarSignaturaTablet");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/finalitzarSignaturaTablet").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the DocsSignatures
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocumentacio idDocumentacio
     * @return List&lt;DocsSignaturesPendentRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DocsSignaturesPendentRDTO> getDocsSignaturesByDocsTramitacioUsingGET(Integer idDocumentacio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocumentacio' is set
        if (idDocumentacio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocumentacio' when calling getDocsSignaturesByDocsTramitacioUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocumentacio", idDocumentacio);
        String path = UriComponentsBuilder.fromPath("/signatures/{idDocumentacio}/tramitacio/evidences").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<DocsSignaturesPendentRDTO>> returnType = new ParameterizedTypeReference<List<DocsSignaturesPendentRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the DocsSignatures
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocumentacio idDocumentacio
     * @return List&lt;DocsSignaturesPendentRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DocsSignaturesPendentRDTO> getDocsSignaturesPendentsUsingGET(Integer idDocumentacio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocumentacio' is set
        if (idDocumentacio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocumentacio' when calling getDocsSignaturesPendentsUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocumentacio", idDocumentacio);
        String path = UriComponentsBuilder.fromPath("/signatures/{idDocumentacio}/tramitacio/signatures").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<DocsSignaturesPendentRDTO>> returnType = new ParameterizedTypeReference<List<DocsSignaturesPendentRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the PolitiquesSignatura
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocumentacio idDocumentacio
     * @return List&lt;ConfDocsTramPolitiquesSigRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ConfDocsTramPolitiquesSigRDTO> getPolitiquesSignaturaDocsTramitacioUsingGET(Integer idDocumentacio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocumentacio' is set
        if (idDocumentacio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocumentacio' when calling getPolitiquesSignaturaDocsTramitacioUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocumentacio", idDocumentacio);
        String path = UriComponentsBuilder.fromPath("/signatures/{idDocumentacio}/tramitacio/politiquesSignatura").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<ConfDocsTramPolitiquesSigRDTO>> returnType = new ParameterizedTypeReference<List<ConfDocsTramPolitiquesSigRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Incrementa els reintents de la signatura
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocument idDocument
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void incrementarReintentsSignatura(Integer idDocument) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocument' is set
        if (idDocument == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocument' when calling incrementarReintentsSignatura");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocument", idDocument);
        String path = UriComponentsBuilder.fromPath("/signatures/incrementarReintentsSignatura/{idDocument}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * ObtenirIndicadorDocumentsPendentsSignar
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return Integer
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Integer obtenirIndicadorDocumentsPendentsSignarUsingGET() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/signatures/obtenirIndicadorDocumentsPendentsSignar").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Integer> returnType = new ParameterizedTypeReference<Integer>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * obté l&#39;identificador de la tauleta a partir de l&#39;usuari
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param usuari usuari
     * @return UsuariTabletResponseRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UsuariTabletResponseRDTO obtenirTabletDusuariUsingGET(String usuari) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'usuari' is set
        if (usuari == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'usuari' when calling obtenirTabletDusuariUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("usuari", usuari);
        String path = UriComponentsBuilder.fromPath("/signatures/obtenirTabletDusuari/{usuari}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<UsuariTabletResponseRDTO> returnType = new ParameterizedTypeReference<UsuariTabletResponseRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Consultar si una petició de signatura tien documents signats
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idPeticio idPeticio
     * @return Boolean
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Boolean peticioAmbDocumentsSignats(String idPeticio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idPeticio' is set
        if (idPeticio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idPeticio' when calling peticioAmbDocumentsSignats");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idPeticio", idPeticio);
        String path = UriComponentsBuilder.fromPath("/signatures/peticioAmbDocumentsSignats/{idPeticio}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Boolean> returnType = new ParameterizedTypeReference<Boolean>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar una llista de documents amb signatura criptogràfica mitjançant el Mòdul Comú de Signatura
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param prepararSignaturaCriptograficaDocumentMassiuRDTO prepararSignaturaCriptograficaDocumentMassiuRDTO
     * @return PrepararSignaturaCriptograficaDocumentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptografica(PrepararSignaturaCriptograficaDocumentMassiu prepararSignaturaCriptograficaDocumentMassiuRDTO) throws RestClientException {
        Object postBody = prepararSignaturaCriptograficaDocumentMassiuRDTO;
        
        // verify the required parameter 'prepararSignaturaCriptograficaDocumentMassiuRDTO' is set
        if (prepararSignaturaCriptograficaDocumentMassiuRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'prepararSignaturaCriptograficaDocumentMassiuRDTO' when calling prepararSignaturaCriptografica");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/prepararSignaturaCriptografica").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PrepararSignaturaCriptograficaDocumentResponse> returnType = new ParameterizedTypeReference<PrepararSignaturaCriptograficaDocumentResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * RebutjarDocumentsPendentsSignar
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param rebutjarDocumentsPendentsSignarList rebutjarDocumentsPendentsSignarList
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void rebutjarDocumentsPendentsSignarUsingPOST(List<RebutjarDocumentsPendentsSignar> rebutjarDocumentsPendentsSignarList) throws RestClientException {
        Object postBody = rebutjarDocumentsPendentsSignarList;
        
        // verify the required parameter 'rebutjarDocumentsPendentsSignarList' is set
        if (rebutjarDocumentsPendentsSignarList == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'rebutjarDocumentsPendentsSignarList' when calling rebutjarDocumentsPendentsSignarUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/rebutjarDocumentsPendentsSignar").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Actualitzar l&#39;estat dels documents enviats a MCI Signatura
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param signarCriptograficaDocumentRDTO signarCriptograficaDocumentRDTO
     * @return SignarCriptograficaDocumentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SignarCriptograficaDocumentResponse signarCriptografica(SignarCriptograficaDocument signarCriptograficaDocumentRDTO) throws RestClientException {
        Object postBody = signarCriptograficaDocumentRDTO;
        
        // verify the required parameter 'signarCriptograficaDocumentRDTO' is set
        if (signarCriptograficaDocumentRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'signarCriptograficaDocumentRDTO' when calling signarCriptografica");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/signarCriptografica").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<SignarCriptograficaDocumentResponse> returnType = new ParameterizedTypeReference<SignarCriptograficaDocumentResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar un document
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param signarSegellDocumentRDTO signarSegellDocumentRDTO
     * @return SignarSegellDocument
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SignarSegellDocument signarSegell(SignarSegellDocument signarSegellDocumentRDTO) throws RestClientException {
        Object postBody = signarSegellDocumentRDTO;
        
        // verify the required parameter 'signarSegellDocumentRDTO' is set
        if (signarSegellDocumentRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'signarSegellDocumentRDTO' when calling signarSegell");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/signarSegell").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<SignarSegellDocument> returnType = new ParameterizedTypeReference<SignarSegellDocument>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar un document en la tablet
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param signarTabletDocumentRDTO signarTabletDocumentRDTO
     * @return SignarTabletDocumentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SignarTabletDocumentResponse signarTablet(SignarTabletDocument signarTabletDocumentRDTO) throws RestClientException {
        Object postBody = signarTabletDocumentRDTO;
        
        // verify the required parameter 'signarTabletDocumentRDTO' is set
        if (signarTabletDocumentRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'signarTabletDocumentRDTO' when calling signarTablet");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/signarTablet").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<SignarTabletDocumentResponse> returnType = new ParameterizedTypeReference<SignarTabletDocumentResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per signar un document en IMI Valid
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param signarValidDocumentRDTO signarValidDocumentRDTO
     * @return SignarValidDocumentResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SignarValidDocumentResponse signarValid(SignarValidDocument signarValidDocumentRDTO) throws RestClientException {
        Object postBody = signarValidDocumentRDTO;
        
        // verify the required parameter 'signarValidDocumentRDTO' is set
        if (signarValidDocumentRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'signarValidDocumentRDTO' when calling signarValid");
        }
        
        String path = UriComponentsBuilder.fromPath("/signatures/signarValid").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<SignarValidDocumentResponse> returnType = new ParameterizedTypeReference<SignarValidDocumentResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
