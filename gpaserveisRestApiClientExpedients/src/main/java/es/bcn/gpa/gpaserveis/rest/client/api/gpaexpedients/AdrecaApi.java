package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AdrecaNormalitzadaRDTO;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-17T09:06:51.509+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AdrecaApi")
public class AdrecaApi {
    private ApiClient apiClient;

    public AdrecaApi() {
        this(new ApiClient());
    }

    @Autowired
    public AdrecaApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the normalitzada adreca
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param nomVia nomVia
     * @param numero numero
     * @return AdrecaNormalitzadaRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AdrecaNormalitzadaRDTO normalitzarAdrecaPostalUsingGET(String nomVia, String numero) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'nomVia' is set
        if (nomVia == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nomVia' when calling normalitzarAdrecaPostalUsingGET");
        }
        
        // verify the required parameter 'numero' is set
        if (numero == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'numero' when calling normalitzarAdrecaPostalUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nomVia", nomVia);
        uriVariables.put("numero", numero);
        String path = UriComponentsBuilder.fromPath("/expedients/catalog/normalitzarAdrecaPostal/{nomVia}/{numero}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<AdrecaNormalitzadaRDTO> returnType = new ParameterizedTypeReference<AdrecaNormalitzadaRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
