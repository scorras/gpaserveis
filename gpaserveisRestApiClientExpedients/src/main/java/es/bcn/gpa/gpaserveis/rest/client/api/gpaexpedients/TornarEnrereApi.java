package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaTornarEnrereMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TornarEnrereMassiuRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-08T15:53:07.446+01:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.TornarEnrereApi")
public class TornarEnrereApi {
    private ApiClient apiClient;

    public TornarEnrereApi() {
        this(new ApiClient());
    }

    @Autowired
    public TornarEnrereApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Tornar Enrere of the provided list of expedients
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param tornarEnrereMassiuRDTO tornarEnrereMassiuRDTO
     * @return RespostaTornarEnrereMassiu
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaTornarEnrereMassiu tornarEnrereMassiuUsingPOST(TornarEnrereMassiuRDTO tornarEnrereMassiuRDTO) throws RestClientException {
        Object postBody = tornarEnrereMassiuRDTO;
        
        // verify the required parameter 'tornarEnrereMassiuRDTO' is set
        if (tornarEnrereMassiuRDTO == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tornarEnrereMassiuRDTO' when calling tornarEnrereMassiuUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/tornarEnrereMassiu").build().toUriString();
        
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

        ParameterizedTypeReference<RespostaTornarEnrereMassiu> returnType = new ParameterizedTypeReference<RespostaTornarEnrereMassiu>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
