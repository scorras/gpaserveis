package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import org.joda.time.DateTime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaObtenirXmlExpedient;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-18T09:30:38.826+01:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.Expedients_Api")
public class Expedients_Api {
    private ApiClient apiClient;

    public Expedients_Api() {
        this(new ApiClient());
    }

    @Autowired
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
     * Updates the provided expedient including specific data
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param actualitzarDadesSollicitudRDTO actualitzarDadesSollicitudRDTO
     * @return ExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExpedientsRDTO actualitzarDadesSollicitud(ActualitzarDadesSollicitud actualitzarDadesSollicitudRDTO) throws RestClientException {
        Object postBody = actualitzarDadesSollicitudRDTO;
        
        // verify the required parameter 'actualitzarDadesSollicitudRDTO' is set
        if (actualitzarDadesSollicitudRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'actualitzarDadesSollicitudRDTO' when calling actualitzarDadesSollicitud");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/dadesSollicitud").build().toUriString();
        
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

        ParameterizedTypeReference<ExpedientsRDTO> returnType = new ParameterizedTypeReference<ExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the expedients that meet the search criteria
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param absoluteRowNumberOfFirstRowInCurrentPage The absoluteRowNumberOfFirstRowInCurrentPage parameter
     * @param absoluteRowNumberOfLastRowInCurrentPage The absoluteRowNumberOfLastRowInCurrentPage parameter
     * @param aplicacioNegoci Aplicació de negoci
     * @param avisList Llista d&#39;avisos de l&#39;expedient
     * @param codi Codi de l&#39;expedient
     * @param criteriDeCercaDadesOperacioList0Id Identificador de la dada d&#39;operació
     * @param criteriDeCercaDadesOperacioList0Tipus Tipus de la dada d&#39;operació
     * @param criteriDeCercaDadesOperacioList0Valor Valor de la dada d&#39;operació
     * @param currentPageHasNextPage The currentPageHasNextPage parameter
     * @param currentPageHasPreviousPage The currentPageHasPreviousPage parameter
     * @param currentPageIsFirstPage The currentPageIsFirstPage parameter
     * @param currentPageIsLastPage The currentPageIsLastPage parameter
     * @param currentPageNumber The currentPageNumber parameter
     * @param dataPresentacioDes Data presentació des de
     * @param dataPresentacioFinsA Data presentació fins a
     * @param dir The dir parameter
     * @param estatList Llista d&#39;estats de l&#39;expedient
     * @param id Identificador pel qual es realitza la cerca
     * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca
     * @param isOge Invocació des de OGE
     * @param nextPageNumber The nextPageNumber parameter
     * @param numeroDocumentSollicitant Numero de document d&#39;identificació del sol·licitant
     * @param numeroDocumentSollicitantEstricte Numero de document d&#39;identificació del sol·licitant estricte
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param procedimentCodisList Llista dels codis dels procediments
     * @param procedimentId Identificador del procediment
     * @param procedimentVersio Versió del procediment
     * @param sort The sort parameter
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @param tramitador Tramitador de l&#39;expedient
     * @param unitatsGestoresList Llista d&#39;unitats gestores
     * @return PageDataOfExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfExpedientsRDTO cercaExpedients(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String aplicacioNegoci, List<String> avisList, String codi, BigDecimal criteriDeCercaDadesOperacioList0Id, BigDecimal criteriDeCercaDadesOperacioList0Tipus, String criteriDeCercaDadesOperacioList0Valor, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime dataPresentacioDes, DateTime dataPresentacioFinsA, String dir, List<BigDecimal> estatList, BigDecimal id, BigDecimal idUsuari, Boolean isOge, Integer nextPageNumber, String numeroDocumentSollicitant, String numeroDocumentSollicitantEstricte, Integer pageSize, Integer previousPageNumber, List<String> procedimentCodisList, BigDecimal procedimentId, BigDecimal procedimentVersio, String sort, Long totalElements, Integer totalPages, String tramitador, List<BigDecimal> unitatsGestoresList) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients/search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "aplicacioNegoci", aplicacioNegoci));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "avisList", avisList));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codi", codi));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "criteriDeCercaDadesOperacioList[0].id", criteriDeCercaDadesOperacioList0Id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "criteriDeCercaDadesOperacioList[0].tipus", criteriDeCercaDadesOperacioList0Tipus));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "criteriDeCercaDadesOperacioList[0].valor", criteriDeCercaDadesOperacioList0Valor));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasNextPage", currentPageHasNextPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasPreviousPage", currentPageHasPreviousPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsFirstPage", currentPageIsFirstPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsLastPage", currentPageIsLastPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageNumber", currentPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataPresentacioDes", dataPresentacioDes));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataPresentacioFinsA", dataPresentacioFinsA));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dir", dir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "estatList", estatList));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idUsuari", idUsuari));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isOge", isOge));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentSollicitant", numeroDocumentSollicitant));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentSollicitantEstricte", numeroDocumentSollicitantEstricte));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "procedimentCodisList", procedimentCodisList));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "procedimentId", procedimentId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "procedimentVersio", procedimentVersio));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tramitador", tramitador));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "unitatsGestoresList", unitatsGestoresList));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageDataOfExpedientsRDTO> returnType = new ParameterizedTypeReference<PageDataOfExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @return ExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExpedientsRDTO consultarDadesExpedient(BigDecimal id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling consultarDadesExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ExpedientsRDTO> returnType = new ParameterizedTypeReference<ExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return ExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExpedientsRDTO consultarDadesExpedientPerCodi(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling consultarDadesExpedientPerCodi");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        String path = UriComponentsBuilder.fromPath("/expedients/perCodi/{codi}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ExpedientsRDTO> returnType = new ParameterizedTypeReference<ExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested unitat
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return RegistreAssentamentRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RegistreAssentamentRDTO consultarDadesRegistreAssentament(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling consultarDadesRegistreAssentament");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/registre").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codi", codi));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<RegistreAssentamentRDTO> returnType = new ParameterizedTypeReference<RegistreAssentamentRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested id expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idDocumentacio idDocumentacio
     * @return BigDecimal
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BigDecimal consultarExpedientPerDocumentacioIdExt(BigDecimal idDocumentacio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idDocumentacio' is set
        if (idDocumentacio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idDocumentacio' when calling consultarExpedientPerDocumentacioIdExt");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idDocumentacio", idDocumentacio);
        String path = UriComponentsBuilder.fromPath("/expedients/expedientByIdDoc/{idDocumentacio}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<BigDecimal> returnType = new ParameterizedTypeReference<BigDecimal>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Register the provided expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param accio accio
     * @param registrarSolicitudExpedientRDTO registrarSolicitudExpedientRDTO
     * @return RespostaCrearRegistreExpedient
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaCrearRegistreExpedient crearRegistreSolicitudExpedient(BigDecimal accio, CrearRegistre registrarSolicitudExpedientRDTO) throws RestClientException {
        Object postBody = registrarSolicitudExpedientRDTO;
        
        // verify the required parameter 'accio' is set
        if (accio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accio' when calling crearRegistreSolicitudExpedient");
        }
        
        // verify the required parameter 'registrarSolicitudExpedientRDTO' is set
        if (registrarSolicitudExpedientRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'registrarSolicitudExpedientRDTO' when calling crearRegistreSolicitudExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("accio", accio);
        String path = UriComponentsBuilder.fromPath("/expedients/registre/crear/{accio}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaCrearRegistreExpedient> returnType = new ParameterizedTypeReference<RespostaCrearRegistreExpedient>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Insert the provided expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param expedientsRDTO expedientsRDTO
     * @return ExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExpedientsRDTO crearSollicitudExpedient(ExpedientsRDTO expedientsRDTO) throws RestClientException {
        Object postBody = expedientsRDTO;
        
        // verify the required parameter 'expedientsRDTO' is set
        if (expedientsRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'expedientsRDTO' when calling crearSollicitudExpedient");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients").build().toUriString();
        
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

        ParameterizedTypeReference<ExpedientsRDTO> returnType = new ParameterizedTypeReference<ExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retorna el xml de la informació de l&#39;expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idExpedient idExpedient
     * @return RespostaObtenirXmlExpedient
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaObtenirXmlExpedient obtenirXmlExpedient(BigDecimal idExpedient) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling obtenirXmlExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idExpedient", idExpedient);
        String path = UriComponentsBuilder.fromPath("/expedients/obtenirXmlEvaluate/{idExpedient}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaObtenirXmlExpedient> returnType = new ParameterizedTypeReference<RespostaObtenirXmlExpedient>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Register the provided documentacio
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param registreDocumentacioExpedientRDTO registreDocumentacioExpedientRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void registreDocumentacioAriadna(RegistreDocumentacioExpedient registreDocumentacioExpedientRDTO) throws RestClientException {
        Object postBody = registreDocumentacioExpedientRDTO;
        
        // verify the required parameter 'registreDocumentacioExpedientRDTO' is set
        if (registreDocumentacioExpedientRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'registreDocumentacioExpedientRDTO' when calling registreDocumentacioAriadna");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/registre/registreDoc").build().toUriString();
        
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
}
