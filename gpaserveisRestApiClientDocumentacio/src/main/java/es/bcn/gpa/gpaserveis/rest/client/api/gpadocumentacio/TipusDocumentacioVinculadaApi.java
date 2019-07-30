package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentacioVinculadaRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-26T10:13:20.464+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.TipusDocumentacioVinculadaApi")
public class TipusDocumentacioVinculadaApi {
    private ApiClient apiClient;

    public TipusDocumentacioVinculadaApi() {
        this(new ApiClient());
    }

    @Autowired
    public TipusDocumentacioVinculadaApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns all the TipusDocumentacioVinculada
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;TipusDocumentacioVinculadaRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TipusDocumentacioVinculadaRDTO> obtenirTipusDocumentacioVinculadaUsingGET() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/documentacio/catalog/tipusDocumentacioVinculada").build().toUriString();
        
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

        ParameterizedTypeReference<List<TipusDocumentacioVinculadaRDTO>> returnType = new ParameterizedTypeReference<List<TipusDocumentacioVinculadaRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
