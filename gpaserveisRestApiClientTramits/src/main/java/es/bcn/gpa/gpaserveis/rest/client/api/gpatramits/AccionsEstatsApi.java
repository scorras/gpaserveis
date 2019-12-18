package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import java.math.BigDecimal;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-12-18T13:04:17.163+01:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.AccionsEstatsApi")
public class AccionsEstatsApi {
    private ApiClient apiClient;

    public AccionsEstatsApi() {
        this(new ApiClient());
    }

    @Autowired
    public AccionsEstatsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the accions allowed for the current expedient&#39;s status
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param estatId estatId
     * @return List&lt;AccionsEstatsRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<AccionsEstatsRDTO> cercaAccionsPossibles(BigDecimal estatId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'estatId' is set
        if (estatId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'estatId' when calling cercaAccionsPossibles");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("estatId", estatId);
        String path = UriComponentsBuilder.fromPath("/tramits/accionsPermesesForEstatActual/{estatId}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<AccionsEstatsRDTO>> returnType = new ParameterizedTypeReference<List<AccionsEstatsRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the transition for the current expedient&#39;s status and action execution
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idAccio idAccio
     * @param idEstatActual idEstatActual
     * @return List&lt;AccionsEstatsRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<AccionsEstatsRDTO> cercaTransicioCanviEstat(BigDecimal idAccio, BigDecimal idEstatActual) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idAccio' is set
        if (idAccio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idAccio' when calling cercaTransicioCanviEstat");
        }
        
        // verify the required parameter 'idEstatActual' is set
        if (idEstatActual == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idEstatActual' when calling cercaTransicioCanviEstat");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idAccio", idAccio);
        uriVariables.put("idEstatActual", idEstatActual);
        String path = UriComponentsBuilder.fromPath("/tramits/accionsEstatsForEstatActualAndAccio/{idEstatActual}/{idAccio}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<AccionsEstatsRDTO>> returnType = new ParameterizedTypeReference<List<AccionsEstatsRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
