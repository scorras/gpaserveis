package es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaprocediments.ApiClient;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-08-10T10:43:10.984+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaprocediments.ProcedimentsApi")
public class ProcedimentsApi {
    private ApiClient apiClient;

    public ProcedimentsApi() {
        this(new ApiClient());
    }

    @Autowired
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
     * Returns all procedures that meet the search criteria
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param absoluteRowNumberOfFirstRowInCurrentPage The absoluteRowNumberOfFirstRowInCurrentPage parameter
     * @param absoluteRowNumberOfLastRowInCurrentPage The absoluteRowNumberOfLastRowInCurrentPage parameter
     * @param activableFormatElectronic Canals d&#39;activació en format electrònic
     * @param actuacio Actuació
     * @param aplicacioNegoci Nom de l&#39;aplicació de negoci
     * @param codi Codi del procediment
     * @param competencies Competències associades al procediment
     * @param currentPageHasNextPage The currentPageHasNextPage parameter
     * @param currentPageHasPreviousPage The currentPageHasPreviousPage parameter
     * @param currentPageIsFirstPage The currentPageIsFirstPage parameter
     * @param currentPageIsLastPage The currentPageIsLastPage parameter
     * @param currentPageNumber The currentPageNumber parameter
     * @param dir The dir parameter
     * @param estats Estats
     * @param families Famílies del procediment
     * @param id Identificador pel qual es realitza la cerca
     * @param idUsuari Identificador d&#39;usuari pel qual es realitza la cerca
     * @param iniciacions Iniciacions del procediment
     * @param intern Exclusivament intern
     * @param nextPageNumber The nextPageNumber parameter
     * @param nom Nom del procediment
     * @param operador operador tramitador
     * @param organResolutori Òrgan resolutori
     * @param pageSize The pageSize parameter
     * @param previousPageNumber The previousPageNumber parameter
     * @param sort The sort parameter
     * @param totalElements The totalElements parameter
     * @param totalPages The totalPages parameter
     * @param ugos Unitats gestores responsables
     * @return PageDataOfProcedimentsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public PageDataOfProcedimentsRDTO cercaProcediments(Integer absoluteRowNumberOfFirstRowInCurrentPage, Integer absoluteRowNumberOfLastRowInCurrentPage, List<String> activableFormatElectronic, String actuacio, String aplicacioNegoci, String codi, List<BigDecimal> competencies, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage, Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, String dir, List<BigDecimal> estats, List<BigDecimal> families, BigDecimal id, BigDecimal idUsuari, List<BigDecimal> iniciacions, Integer intern, Integer nextPageNumber, String nom, Integer operador, String organResolutori, Integer pageSize, Integer previousPageNumber, String sort, Long totalElements, Integer totalPages, List<BigDecimal> ugos) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/procediments/search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfFirstRowInCurrentPage", absoluteRowNumberOfFirstRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfLastRowInCurrentPage", absoluteRowNumberOfLastRowInCurrentPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "activableFormatElectronic", activableFormatElectronic));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "actuacio", actuacio));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "aplicacioNegoci", aplicacioNegoci));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "codi", codi));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "competencies", competencies));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasNextPage", currentPageHasNextPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasPreviousPage", currentPageHasPreviousPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsFirstPage", currentPageIsFirstPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsLastPage", currentPageIsLastPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageNumber", currentPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dir", dir));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "estats", estats));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "families", families));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "idUsuari", idUsuari));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "iniciacions", iniciacions));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "intern", intern));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nom", nom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "operador", operador));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organResolutori", organResolutori));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "ugos", ugos));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<PageDataOfProcedimentsRDTO> returnType = new ParameterizedTypeReference<PageDataOfProcedimentsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested procediment
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @return ProcedimentsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProcedimentsRDTO consultarDadesProcediment(Integer id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling consultarDadesProcediment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/procediments/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ProcedimentsRDTO> returnType = new ParameterizedTypeReference<ProcedimentsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested procediment
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param codi codi
     * @return ProcedimentsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProcedimentsRDTO consultarDadesProcedimentPerCodi(String codi) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'codi' is set
        if (codi == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'codi' when calling consultarDadesProcedimentPerCodi");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("codi", codi);
        String path = UriComponentsBuilder.fromPath("/procediments/perCodi/{codi}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<ProcedimentsRDTO> returnType = new ParameterizedTypeReference<ProcedimentsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
