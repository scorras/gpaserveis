package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-12T12:40:33.333+01:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesApi")
public class DadesEspecifiquesApi {
    private ApiClient apiClient;

    public DadesEspecifiquesApi() {
        this(new ApiClient());
    }

    @Autowired
    public DadesEspecifiquesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the requested dades especifiques
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idExpedient idExpedient
     * @param visibilitat visibilitat
     * @return List&lt;DadesEspecifiquesRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DadesEspecifiquesRDTO> consultarDadesEspecifiquesExpedient(Integer idExpedient, Integer visibilitat) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling consultarDadesEspecifiquesExpedient");
        }
        
        // verify the required parameter 'visibilitat' is set
        if (visibilitat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'visibilitat' when calling consultarDadesEspecifiquesExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idExpedient", idExpedient);
        uriVariables.put("visibilitat", visibilitat);
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiques/{idExpedient}/{visibilitat}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<DadesEspecifiquesRDTO>> returnType = new ParameterizedTypeReference<List<DadesEspecifiquesRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested dades especifiques by Sol·licitud
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idSollicitud idSollicitud
     * @param visibilitat visibilitat
     * @return List&lt;DadesEspecifiquesRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DadesEspecifiquesRDTO> consultarDadesEspecifiquesSollicitud(Integer idSollicitud, Integer visibilitat) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idSollicitud' is set
        if (idSollicitud == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idSollicitud' when calling consultarDadesEspecifiquesSollicitud");
        }
        
        // verify the required parameter 'visibilitat' is set
        if (visibilitat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'visibilitat' when calling consultarDadesEspecifiquesSollicitud");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idSollicitud", idSollicitud);
        uriVariables.put("visibilitat", visibilitat);
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiques/sollicitud/{idSollicitud}/{visibilitat}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<DadesEspecifiquesRDTO>> returnType = new ParameterizedTypeReference<List<DadesEspecifiquesRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Save the specific data of a Sollicitud in the Expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idSollicitud idSollicitud
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void guardarDadesEspecifiquesSollicitud(Integer idSollicitud) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idSollicitud' is set
        if (idSollicitud == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idSollicitud' when calling guardarDadesEspecifiquesSollicitud");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idSollicitud", idSollicitud);
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiques/sollicitud/{idSollicitud}").buildAndExpand(uriVariables).toUriString();
        
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
