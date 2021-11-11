package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstadisticDadesExpedients;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.InputStreamResource;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.MunicipisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ProvinciesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusViesRDTO;

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

<<<<<<< HEAD
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-15T11:38:28.065+02:00")
=======
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T15:53:07.446+01:00")
>>>>>>> feature/GPA-4046
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
     * @param nivellAutenticacio Nivell d&#39;autenticacio del procediment
     * @param nomCognomSollicitant Nom i cognom del sol·licitant
     * @param numeroDocumentInteressat Numero de document d&#39;identitat de l&#39;ciutada interessat en nom de qui es realitza la consulta o tramit
     * @param numeroDocumentSollicitant Numero de document d&#39;identificació del sol·licitant
     * @param numeroDocumentSollicitantEstricte Numero de document d&#39;identificació del sol·licitant estricte
     * @param numeroRegistre Numero de registre de sollicitud
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
    public PageDataOfExpedientsRDTO cercaExpedients(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String aplicacioNegoci, List<String> avisList, String codi, BigDecimal criteriDeCercaDadesOperacioList0Id, BigDecimal criteriDeCercaDadesOperacioList0Tipus, String criteriDeCercaDadesOperacioList0Valor, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dataPresentacioDes, String dataPresentacioFinsA, String dir, List<BigDecimal> estatList, BigDecimal id, BigDecimal idUsuari, Boolean isOge, Integer nextPageNumber, Integer nivellAutenticacio, String nomCognomSollicitant, String numeroDocumentInteressat, String numeroDocumentSollicitant, String numeroDocumentSollicitantEstricte, String numeroRegistre, Integer pageSize, Integer previousPageNumber, List<String> procedimentCodisList, BigDecimal procedimentId, BigDecimal procedimentVersio, String sort, Long totalElements, Integer totalPages, String tramitador, List<BigDecimal> unitatsGestoresList) throws RestClientException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nivellAutenticacio", nivellAutenticacio));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nomCognomSollicitant", nomCognomSollicitant));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentInteressat", numeroDocumentInteressat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentSollicitant", numeroDocumentSollicitant));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentSollicitantEstricte", numeroDocumentSollicitantEstricte));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroRegistre", numeroRegistre));
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
    public ExpedientsRDTO consultarDadesExpedient(Integer id) throws RestClientException {
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
    public BigDecimal consultarExpedientPerDocumentacioIdExt(Integer idDocumentacio) throws RestClientException {
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
     * Returns the requested municipi
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codiMunicipi codiMunicipi
     * @param codiProvincia codiProvincia
     * @return MunicipisRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MunicipisRDTO consultarMunicipiByCodi(String codiMunicipi, String codiProvincia) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codiMunicipi' is set
        if (codiMunicipi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codiMunicipi' when calling consultarMunicipiByCodi");
        }
        
        // verify the required parameter 'codiProvincia' is set
        if (codiProvincia == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codiProvincia' when calling consultarMunicipiByCodi");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codiMunicipi", codiMunicipi);
        uriVariables.put("codiProvincia", codiProvincia);
        String path = UriComponentsBuilder.fromPath("/geoCod/municipis/{codiProvincia}/{codiMunicipi}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<MunicipisRDTO> returnType = new ParameterizedTypeReference<MunicipisRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested pais
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return PaisosRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PaisosRDTO consultarPaisosByCodi(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling consultarPaisosByCodi");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        String path = UriComponentsBuilder.fromPath("/geoCod/paisos/{codi}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<PaisosRDTO> returnType = new ParameterizedTypeReference<PaisosRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested provincia
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return ProvinciesRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProvinciesRDTO consultarProvinciesByCodi(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling consultarProvinciesByCodi");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        String path = UriComponentsBuilder.fromPath("/geoCod/provincies/{codi}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ProvinciesRDTO> returnType = new ParameterizedTypeReference<ProvinciesRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested tipus vies
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return TipusViesRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TipusViesRDTO consultarTipusViesByCodi(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling consultarTipusViesByCodi");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        String path = UriComponentsBuilder.fromPath("/geoCod/tipusVies/{codi}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<TipusViesRDTO> returnType = new ParameterizedTypeReference<TipusViesRDTO>() {};
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
    public RespostaCrearRegistreExpedient crearRegistreSolicitudExpedient(Integer accio, CrearRegistre registrarSolicitudExpedientRDTO) throws RestClientException {
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
     * Returns all the expedients related with the idProcediment
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idProcediment idProcediment
     * @param idUsuari idUsuari
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
     * @return List&lt;EstadisticDadesExpedients&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<EstadisticDadesExpedients> estadisticDadesExpedients(Integer idProcediment, String idUsuari, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idProcediment' is set
        if (idProcediment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idProcediment' when calling estadisticDadesExpedients");
        }
        
        // verify the required parameter 'idUsuari' is set
        if (idUsuari == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idUsuari' when calling estadisticDadesExpedients");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idProcediment", idProcediment);
        uriVariables.put("idUsuari", idUsuari);
        String path = UriComponentsBuilder.fromPath("/expedients/estadisticDadesExpedients/{idProcediment}/{idUsuari}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<EstadisticDadesExpedients>> returnType = new ParameterizedTypeReference<List<EstadisticDadesExpedients>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the expedients related with the idProcediment
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idExpedient idExpedient
     * @param idProcediment idProcediment
     * @param idUsuari idUsuari
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
     * @return List&lt;EstadisticDadesExpedients&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<EstadisticDadesExpedients> estadisticDadesExpedients1(Integer idExpedient, Integer idProcediment, String idUsuari, Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling estadisticDadesExpedients1");
        }
        
        // verify the required parameter 'idProcediment' is set
        if (idProcediment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idProcediment' when calling estadisticDadesExpedients1");
        }
        
        // verify the required parameter 'idUsuari' is set
        if (idUsuari == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idUsuari' when calling estadisticDadesExpedients1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idExpedient", idExpedient);
        uriVariables.put("idProcediment", idProcediment);
        uriVariables.put("idUsuari", idUsuari);
        String path = UriComponentsBuilder.fromPath("/expedients/estadisticDadesExpedients/{idProcediment}/{idExpedient}/{idUsuari}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<EstadisticDadesExpedients>> returnType = new ParameterizedTypeReference<List<EstadisticDadesExpedients>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns excel file with all the expedients that meet the search criteria
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param aplicacioNegoci Aplicació de negoci
     * @param avisList Llista d&#39;avisos de l&#39;expedient
     * @param codi Codi de l&#39;expedient
     * @param criteriDeCercaDadesOperacioList0Id Identificador de la dada d&#39;operació
     * @param criteriDeCercaDadesOperacioList0Tipus Tipus de la dada d&#39;operació
     * @param criteriDeCercaDadesOperacioList0Valor Valor de la dada d&#39;operació
     * @param dataPresentacioDes Data presentació des de
     * @param dataPresentacioFinsA Data presentació fins a
     * @param estatList Llista d&#39;estats de l&#39;expedient
     * @param id Identificador pel qual es realitza la cerca
     * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca
     * @param isOge Invocació des de OGE
     * @param nivellAutenticacio Nivell d&#39;autenticacio del procediment
     * @param nomCognomSollicitant Nom i cognom del sol·licitant
     * @param numeroDocumentInteressat Numero de document d&#39;identitat de l&#39;ciutada interessat en nom de qui es realitza la consulta o tramit
     * @param numeroDocumentSollicitant Numero de document d&#39;identificació del sol·licitant
     * @param numeroDocumentSollicitantEstricte Numero de document d&#39;identificació del sol·licitant estricte
     * @param numeroRegistre Numero de registre de sollicitud
     * @param procedimentCodisList Llista dels codis dels procediments
     * @param procedimentId Identificador del procediment
     * @param procedimentVersio Versió del procediment
     * @param tramitador Tramitador de l&#39;expedient
     * @param unitatsGestoresList Llista d&#39;unitats gestores
     * @return InputStreamResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InputStreamResource exportarCercaExpedientExcelUsingGET(String aplicacioNegoci, List<String> avisList, String codi, BigDecimal criteriDeCercaDadesOperacioList0Id, BigDecimal criteriDeCercaDadesOperacioList0Tipus, String criteriDeCercaDadesOperacioList0Valor, String dataPresentacioDes, String dataPresentacioFinsA, List<BigDecimal> estatList, BigDecimal id, BigDecimal idUsuari, Boolean isOge, Integer nivellAutenticacio, String nomCognomSollicitant, String numeroDocumentInteressat, String numeroDocumentSollicitant, String numeroDocumentSollicitantEstricte, String numeroRegistre, List<String> procedimentCodisList, BigDecimal procedimentId, BigDecimal procedimentVersio, String tramitador, List<BigDecimal> unitatsGestoresList) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients/exportarCercaExpedientExcel").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "aplicacioNegoci", aplicacioNegoci));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "avisList", avisList));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codi", codi));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "criteriDeCercaDadesOperacioList[0].id", criteriDeCercaDadesOperacioList0Id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "criteriDeCercaDadesOperacioList[0].tipus", criteriDeCercaDadesOperacioList0Tipus));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "criteriDeCercaDadesOperacioList[0].valor", criteriDeCercaDadesOperacioList0Valor));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataPresentacioDes", dataPresentacioDes));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataPresentacioFinsA", dataPresentacioFinsA));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "estatList", estatList));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idUsuari", idUsuari));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isOge", isOge));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nivellAutenticacio", nivellAutenticacio));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nomCognomSollicitant", nomCognomSollicitant));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentInteressat", numeroDocumentInteressat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentSollicitant", numeroDocumentSollicitant));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroDocumentSollicitantEstricte", numeroDocumentSollicitantEstricte));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "numeroRegistre", numeroRegistre));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "procedimentCodisList", procedimentCodisList));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "procedimentId", procedimentId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "procedimentVersio", procedimentVersio));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tramitador", tramitador));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "unitatsGestoresList", unitatsGestoresList));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InputStreamResource> returnType = new ParameterizedTypeReference<InputStreamResource>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns al the expedients
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;ExpedientsRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ExpedientsRDTO> getExpedientsUsingGET() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients/all").build().toUriString();
        
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

        ParameterizedTypeReference<List<ExpedientsRDTO>> returnType = new ParameterizedTypeReference<List<ExpedientsRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns all the expedients gestores
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
     * @param nextPageNumber The nextPageNumber parameter
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param sort The sort parameter
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @return PageDataOfExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfExpedientsRDTO getExpedientsUsingGET1(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, Integer nextPageNumber, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients").build().toUriString();
        
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

        ParameterizedTypeReference<PageDataOfExpedientsRDTO> returnType = new ParameterizedTypeReference<PageDataOfExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * ObtenirIdExpedientPerCodi
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return BigDecimal
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BigDecimal obtenirIdExpedientPerCodiUsingGET(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling obtenirIdExpedientPerCodiUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        String path = UriComponentsBuilder.fromPath("/expedients/obtenirIdExpedientPerCodi/{codi}").buildAndExpand(uriVariables).toUriString();
        
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
     * Returns all the expedients gestores
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return Integer
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Integer obtenirIndicadorExpedientsUsingGET() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/expedients/obtenirIndicadorExpedients").build().toUriString();
        
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
    /**
     * Returns all the expedients that meet the search criteria
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param absoluteRowNumberOfFirstRowInCurrentPage The absoluteRowNumberOfFirstRowInCurrentPage parameter
     * @param absoluteRowNumberOfLastRowInCurrentPage The absoluteRowNumberOfLastRowInCurrentPage parameter
     * @param codi Codi de l&#39;expedient
     * @param currentPageHasNextPage The currentPageHasNextPage parameter
     * @param currentPageHasPreviousPage The currentPageHasPreviousPage parameter
     * @param currentPageIsFirstPage The currentPageIsFirstPage parameter
     * @param currentPageIsLastPage The currentPageIsLastPage parameter
     * @param currentPageNumber The currentPageNumber parameter
     * @param dir The dir parameter
     * @param id Identificador pel qual es realitza la cerca
     * @param idExpedientAcumulador Identificador de l&#39;expedient acumulador
     * @param idProcedimentAcumulat Identificador del procediment de l&#39;expedient a acumular
     * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca
     * @param nextPageNumber The nextPageNumber parameter
     * @param nombreDocument Nombre del document del sol·licitant
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param sollicitant Nom del sol·licitant
     * @param sort The sort parameter
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @return PageDataOfExpedientsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfExpedientsRDTO searchExpedientsAcumuladorsUsingGET(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, String codi, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, BigDecimal id, BigDecimal idExpedientAcumulador, BigDecimal idProcedimentAcumulat, BigDecimal idUsuari, Integer nextPageNumber, String nombreDocument, Integer pageSize, Integer previousPageNumber, String sollicitant, String sort, Long totalElements, Integer totalPages) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/acumulacioExpedients/searchExpedientsAcumuladors").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codi", codi));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasNextPage", currentPageHasNextPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasPreviousPage", currentPageHasPreviousPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsFirstPage", currentPageIsFirstPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsLastPage", currentPageIsLastPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageNumber", currentPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dir", dir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idExpedientAcumulador", idExpedientAcumulador));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idProcedimentAcumulat", idProcedimentAcumulat));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idUsuari", idUsuari));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nombreDocument", nombreDocument));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sollicitant", sollicitant));
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

        ParameterizedTypeReference<PageDataOfExpedientsRDTO> returnType = new ParameterizedTypeReference<PageDataOfExpedientsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates the provided expedient
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
    public ExpedientsRDTO updateExpedientUsingPUT(ExpedientsRDTO expedientsRDTO) throws RestClientException {
        Object postBody = expedientsRDTO;
        
        // verify the required parameter 'expedientsRDTO' is set
        if (expedientsRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'expedientsRDTO' when calling updateExpedientUsingPUT");
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
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
