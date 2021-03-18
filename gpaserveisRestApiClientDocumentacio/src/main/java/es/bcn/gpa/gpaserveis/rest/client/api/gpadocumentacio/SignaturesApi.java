package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackManuscrita;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DadesSignatura;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarPortasignaturesDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocumentResponse;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-03-18T13:42:05.746+01:00")
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
    public byte[] descarregarDocumentExpedientSignat(BigDecimal idUltimaSignatura) throws RestClientException {
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
    public void incrementarReintentsSignatura(BigDecimal idDocument) throws RestClientException {
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
