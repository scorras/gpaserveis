package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ProcedimentSerieDocRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSincronitzarCheckRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSincronitzarRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SerieDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-24T01:04:59.179+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.SeriesCatalegApi")
public class SeriesCatalegApi {
    private ApiClient apiClient;

    public SeriesCatalegApi() {
        this(new ApiClient());
    }

    @Autowired
    public SeriesCatalegApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Sincronitzar la configuració de la documentació del procediment
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param serieDocumental serieDocumental
     * @return RespostaSincronitzarCheckRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaSincronitzarCheckRDTO checkSerieDocumentalUsingGET(String serieDocumental) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'serieDocumental' is set
        if (serieDocumental == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serieDocumental' when calling checkSerieDocumentalUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("serieDocumental", serieDocumental);
        String path = UriComponentsBuilder.fromPath("/configuracioDocumentacio/serie/{serieDocumental}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaSincronitzarCheckRDTO> returnType = new ParameterizedTypeReference<RespostaSincronitzarCheckRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the series
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;SerieDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<SerieDTO> getSeriesUsingGET() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/configuracioDocumentacio/series").build().toUriString();
        
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

        ParameterizedTypeReference<List<SerieDTO>> returnType = new ParameterizedTypeReference<List<SerieDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Sincronitzar la configuració de la documentació del procediment
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param procedimentSerieDocRDTO procedimentSerieDocRDTO
     * @return RespostaSincronitzarRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaSincronitzarRDTO sincronitzarSeriesToProcUsingPOST(ProcedimentSerieDocRDTO procedimentSerieDocRDTO) throws RestClientException {
        Object postBody = procedimentSerieDocRDTO;
        
        // verify the required parameter 'procedimentSerieDocRDTO' is set
        if (procedimentSerieDocRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'procedimentSerieDocRDTO' when calling sincronitzarSeriesToProcUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/configuracioDocumentacio/sincronitzarSeriesToProc").build().toUriString();
        
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

        ParameterizedTypeReference<RespostaSincronitzarRDTO> returnType = new ParameterizedTypeReference<RespostaSincronitzarRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Sincronitzar la configuració de la documentació del procediment
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param procedimentSerieDocRDTO procedimentSerieDocRDTO
     * @return RespostaSincronitzarRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaSincronitzarRDTO sincronitzarUsingPOST(ProcedimentSerieDocRDTO procedimentSerieDocRDTO) throws RestClientException {
        Object postBody = procedimentSerieDocRDTO;
        
        // verify the required parameter 'procedimentSerieDocRDTO' is set
        if (procedimentSerieDocRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'procedimentSerieDocRDTO' when calling sincronitzarUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/configuracioDocumentacio/sincronitzar").build().toUriString();
        
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

        ParameterizedTypeReference<RespostaSincronitzarRDTO> returnType = new ParameterizedTypeReference<RespostaSincronitzarRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
