package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ActualitzarNotificacionDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-05T13:25:08.238+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.NotificacionsApi")
public class NotificacionsApi {
    private ApiClient apiClient;

    public NotificacionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public NotificacionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * actualitzarNotificacio
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param actualitzarNotificacionDocumentRDTO actualitzarNotificacionDocumentRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void actualitzarNotificacio(ActualitzarNotificacionDocument actualitzarNotificacionDocumentRDTO) throws RestClientException {
        Object postBody = actualitzarNotificacionDocumentRDTO;
        
        // verify the required parameter 'actualitzarNotificacionDocumentRDTO' is set
        if (actualitzarNotificacionDocumentRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'actualitzarNotificacionDocumentRDTO' when calling actualitzarNotificacio");
        }
        
        String path = UriComponentsBuilder.fromPath("/notificacions/actualitzarNotificacio").build().toUriString();
        
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
     * crearNotificacio
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param crearNotificacioRDTO crearNotificacioRDTO
     * @return NotificacionsRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public NotificacionsRDTO crearNotificacio(CrearNotificacio crearNotificacioRDTO) throws RestClientException {
        Object postBody = crearNotificacioRDTO;
        
        // verify the required parameter 'crearNotificacioRDTO' is set
        if (crearNotificacioRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'crearNotificacioRDTO' when calling crearNotificacio");
        }
        
        String path = UriComponentsBuilder.fromPath("/notificacions/crearNotificacio").build().toUriString();
        
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

        ParameterizedTypeReference<NotificacionsRDTO> returnType = new ParameterizedTypeReference<NotificacionsRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
