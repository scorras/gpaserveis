package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ExpedientGestorDocumentalRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-12T12:30:07.914+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ExpedientsApi")
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
     * donar d&#39;alta un expedient en Gestor Documental
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param expedientGestorDocumentalRDTO expedientGestorDocumentalRDTO
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String altaExpedientGestorDocumentalUsingPOST(ExpedientGestorDocumentalRDTO expedientGestorDocumentalRDTO) throws RestClientException {
        Object postBody = expedientGestorDocumentalRDTO;
        
        // verify the required parameter 'expedientGestorDocumentalRDTO' is set
        if (expedientGestorDocumentalRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'expedientGestorDocumentalRDTO' when calling altaExpedientGestorDocumentalUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/documentacio/altaExpedientGestorDocumental").build().toUriString();
        
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

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
