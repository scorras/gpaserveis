package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraMassiuRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-14T11:11:38.011+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.CanviUnitatGestoraApi")
public class CanviUnitatGestoraApi {
    private ApiClient apiClient;

    public CanviUnitatGestoraApi() {
        this(new ApiClient());
    }

    @Autowired
    public CanviUnitatGestoraApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Changes the unitat gestora of the provided expedient
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param canviUnitatGestoraMassiuRDTO canviUnitatGestoraMassiuRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void canviarUnitatGestoraExpedient(CanviUnitatGestoraMassiuRDTO canviUnitatGestoraMassiuRDTO) throws RestClientException {
        Object postBody = canviUnitatGestoraMassiuRDTO;
        
        // verify the required parameter 'canviUnitatGestoraMassiuRDTO' is set
        if (canviUnitatGestoraMassiuRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'canviUnitatGestoraMassiuRDTO' when calling canviarUnitatGestoraExpedient");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/canviUnitatGestora").build().toUriString();
        
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
