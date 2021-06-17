package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import java.io.File;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-17T17:20:36.241+02:00")
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
     * Actualitzar una notificació
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param actualitzarNotificacionDocument actualitzarNotificacionDocument
     * @param docEvidenciaElectronic docEvidenciaElectronic
     * @param docEvidenciaPaper docEvidenciaPaper
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void callbackNotificacio(String actualitzarNotificacionDocument, File docEvidenciaElectronic, File docEvidenciaPaper) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'actualitzarNotificacionDocument' is set
        if (actualitzarNotificacionDocument == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'actualitzarNotificacionDocument' when calling callbackNotificacio");
        }
        
        String path = UriComponentsBuilder.fromPath("/notificacions/retornNotificacio").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (actualitzarNotificacionDocument != null)
            formParams.add("actualitzarNotificacionDocument", actualitzarNotificacionDocument);
        if (docEvidenciaElectronic != null)
            formParams.add("docEvidenciaElectronic", new FileSystemResource(docEvidenciaElectronic));
        if (docEvidenciaPaper != null)
            formParams.add("docEvidenciaPaper", new FileSystemResource(docEvidenciaPaper));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Crear una petició per notificar un document signat
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
        
        String path = UriComponentsBuilder.fromPath("/notificacions").build().toUriString();
        
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
