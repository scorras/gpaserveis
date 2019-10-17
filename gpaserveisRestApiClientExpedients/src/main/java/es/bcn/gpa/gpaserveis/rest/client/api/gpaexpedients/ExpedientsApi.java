package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.BloquejosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CercaExpedientsIntraoperabilitatRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientOpenTextRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfComentarisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PeticioDgt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaUnitatsExpedient;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-17T09:06:51.509+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi")
public class ExpedientsApi {
    private ApiClient apiClient;

    public ExpedientsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExpedientsApi(ApiClient apiClient) {
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
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param bloquejosRDTO bloquejosRDTO
     * @param id id
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void bloquejarExpedientUsingPOST(BloquejosRDTO bloquejosRDTO, BigDecimal id) throws RestClientException {
        Object postBody = bloquejosRDTO;
        
        // verify the required parameter 'bloquejosRDTO' is set
        if (bloquejosRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bloquejosRDTO' when calling bloquejarExpedientUsingPOST");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling bloquejarExpedientUsingPOST");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/bloquejar/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Canvia l&#39;estat d&#39;un expedient en funció de l&#39;acció executada
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idAccio Identificador de l&#39;acció
     * @param idExpedient Identificador de l&#39;expedient
     * @param expedientCanviEstatAccioRDTO Dades del canvi d&#39;estat
     * @return RespostaCanviarEstatAccioExpedient
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaCanviarEstatAccioExpedient canviarEstatAccioExpedient(BigDecimal idAccio, BigDecimal idExpedient, ExpedientCanviEstatAccio expedientCanviEstatAccioRDTO) throws RestClientException {
        Object postBody = expedientCanviEstatAccioRDTO;
        
        // verify the required parameter 'idAccio' is set
        if (idAccio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idAccio' when calling canviarEstatAccioExpedient");
        }
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling canviarEstatAccioExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idAccio", idAccio);
        uriVariables.put("idExpedient", idExpedient);
        String path = UriComponentsBuilder.fromPath("/expedients/{idExpedient}/accions/{idAccio}/canviEstat").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaCanviarEstatAccioExpedient> returnType = new ParameterizedTypeReference<RespostaCanviarEstatAccioExpedient>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * cercaExpedientsIntraoperabilitat
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codiExpedient codiExpedient
     * @param idExpedient idExpedient
     * @param nifSolicitant nifSolicitant
     * @return List&lt;CercaExpedientsIntraoperabilitatRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CercaExpedientsIntraoperabilitatRDTO> cercaExpedientsIntraoperabilitat(String codiExpedient, BigDecimal idExpedient, String nifSolicitant) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients/cercaExpedientsIntraoperabilitat").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codiExpedient", codiExpedient));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idExpedient", idExpedient));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nifSolicitant", nifSolicitant));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<CercaExpedientsIntraoperabilitatRDTO>> returnType = new ParameterizedTypeReference<List<CercaExpedientsIntraoperabilitatRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the historic entries for the procedure that meet the search criteria
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @param absoluteRowNumberOfFirstRowInCurrentPage The absoluteRowNumberOfFirstRowInCurrentPage parameter
     * @param absoluteRowNumberOfLastRowInCurrentPage The absoluteRowNumberOfLastRowInCurrentPage parameter
     * @param currentPageHasNextPage The currentPageHasNextPage parameter
     * @param currentPageHasPreviousPage The currentPageHasPreviousPage parameter
     * @param currentPageIsFirstPage The currentPageIsFirstPage parameter
     * @param currentPageIsLastPage The currentPageIsLastPage parameter
     * @param currentPageNumber The currentPageNumber parameter
     * @param dir The dir parameter
     * @param nextPageNumber The nextPageNumber parameter
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param sort The sort parameter
     * @param tipus tipus
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @return PageDataOfHistoricsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfHistoricsRDTO cercaHistoricsExpedient(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, List<BigDecimal> tipus, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling cercaHistoricsExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/historic/{id}").buildAndExpand(uriVariables).toUriString();
        
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "tipus", tipus));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageDataOfHistoricsRDTO> returnType = new ParameterizedTypeReference<PageDataOfHistoricsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Unlocks the provided procediment
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void desbloquejarExpedientUsingPOST(BigDecimal id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling desbloquejarExpedientUsingPOST");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/desbloquejar/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * DesbloquejarTotsElsExpedientsUsuari
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void desbloquejarTotsElsExpedientsUsuari() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients/desbloquejarTotsElsExpedientsUsuari").build().toUriString();
        
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
        apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Esborrar registre solicitud expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param registrarSolicitudExpedientRDTO registrarSolicitudExpedientRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void esborrarRegistreSolicitudExpedient(CrearRegistre registrarSolicitudExpedientRDTO) throws RestClientException {
        Object postBody = registrarSolicitudExpedientRDTO;
        
        // verify the required parameter 'registrarSolicitudExpedientRDTO' is set
        if (registrarSolicitudExpedientRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'registrarSolicitudExpedientRDTO' when calling esborrarRegistreSolicitudExpedient");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/registre/esborrar").build().toUriString();
        
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
     * ExpedientBloquejatPerUnAltreUsuari
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @return BloquejosRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BloquejosRDTO expedientBloquejatPerUnAltreUsuariUsingGET(BigDecimal id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling expedientBloquejatPerUnAltreUsuariUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/expedientBloquejatPerUnAltreUsuari/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<BloquejosRDTO> returnType = new ParameterizedTypeReference<BloquejosRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Return expedient data for OpenText
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @return ExpedientOpenTextRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExpedientOpenTextRDTO getExpedientDataOpenTextUsingGET(BigDecimal id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getExpedientDataOpenTextUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/expedientDataOpenText/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ExpedientOpenTextRDTO> returnType = new ParameterizedTypeReference<ExpedientOpenTextRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the historic entries for the id list
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param ids ids
     * @return List&lt;HistoricsRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<HistoricsRDTO> getHistoricsListUsingGET(String ids) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'ids' is set
        if (ids == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ids' when calling getHistoricsListUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ids", ids);
        String path = UriComponentsBuilder.fromPath("/expedients/historic/list/{ids}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<HistoricsRDTO>> returnType = new ParameterizedTypeReference<List<HistoricsRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested registre
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param ids ids
     * @return List&lt;RegistreAssentamentRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<RegistreAssentamentRDTO> getRegistresAssentamentListUsingGET(String ids) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'ids' is set
        if (ids == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ids' when calling getRegistresAssentamentListUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ids", ids);
        String path = UriComponentsBuilder.fromPath("/expedients/registre/list/{ids}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<RegistreAssentamentRDTO>> returnType = new ParameterizedTypeReference<List<RegistreAssentamentRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retorna les unitats gestores de l&#39;expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idExpedient idExpedient
     * @return RespostaUnitatsExpedient
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaUnitatsExpedient getUnitasGestoresExpedientUsingGET(BigDecimal idExpedient) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling getUnitasGestoresExpedientUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idExpedient", idExpedient);
        String path = UriComponentsBuilder.fromPath("/expedients/unitasExpedient/{idExpedient}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaUnitatsExpedient> returnType = new ParameterizedTypeReference<RespostaUnitatsExpedient>() {};
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
     * @param procObjecteDeRecursId procObjecteDeRecursId
     * @return ExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExpedientsRDTO obtenirExpedientObjecteDeRecurs(String codi, BigDecimal procObjecteDeRecursId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling obtenirExpedientObjecteDeRecurs");
        }
        
        // verify the required parameter 'procObjecteDeRecursId' is set
        if (procObjecteDeRecursId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'procObjecteDeRecursId' when calling obtenirExpedientObjecteDeRecurs");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        uriVariables.put("procObjecteDeRecursId", procObjecteDeRecursId);
        String path = UriComponentsBuilder.fromPath("/expedients/obtenirExpedientObjecteDeRecurs/{codi}/{procObjecteDeRecursId}").buildAndExpand(uriVariables).toUriString();
        
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
     * obtenirInfoInteroperabilitat
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param peticioDgtRDTO peticioDgtRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void obtenirInfoInteroperabilitat(PeticioDgt peticioDgtRDTO) throws RestClientException {
        Object postBody = peticioDgtRDTO;
        
        // verify the required parameter 'peticioDgtRDTO' is set
        if (peticioDgtRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'peticioDgtRDTO' when calling obtenirInfoInteroperabilitat");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/obtenirInfoInteroperabilitat").build().toUriString();
        
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
     * Inserts new historic
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param historicsRDTO historicsRDTO
     * @return BigDecimal
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BigDecimal registrarHistoricDocumentacioUsingPOST(HistoricsRDTO historicsRDTO) throws RestClientException {
        Object postBody = historicsRDTO;
        
        // verify the required parameter 'historicsRDTO' is set
        if (historicsRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'historicsRDTO' when calling registrarHistoricDocumentacioUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/historic/insert").build().toUriString();
        
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

        ParameterizedTypeReference<BigDecimal> returnType = new ParameterizedTypeReference<BigDecimal>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the comentaris entries for the procedure that meet the search criteria
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @param absoluteRowNumberOfFirstRowInCurrentPage The absoluteRowNumberOfFirstRowInCurrentPage parameter
     * @param absoluteRowNumberOfLastRowInCurrentPage The absoluteRowNumberOfLastRowInCurrentPage parameter
     * @param currentPageHasNextPage The currentPageHasNextPage parameter
     * @param currentPageHasPreviousPage The currentPageHasPreviousPage parameter
     * @param currentPageIsFirstPage The currentPageIsFirstPage parameter
     * @param currentPageIsLastPage The currentPageIsLastPage parameter
     * @param currentPageNumber The currentPageNumber parameter
     * @param dir The dir parameter
     * @param nextPageNumber The nextPageNumber parameter
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param sort The sort parameter
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @return PageDataOfComentarisRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfComentarisRDTO searchComentarisUsingGET(BigDecimal id, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling searchComentarisUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/expedients/comentaris/{id}").buildAndExpand(uriVariables).toUriString();
        
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageDataOfComentarisRDTO> returnType = new ParameterizedTypeReference<PageDataOfComentarisRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
