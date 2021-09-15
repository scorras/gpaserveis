package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisCreacioAccio;
import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.GestionarAvisosPerAccio;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-15T11:38:28.065+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.AvisosApi")
public class AvisosApi {
    private ApiClient apiClient;

    public AvisosApi() {
        this(new ApiClient());
    }

    @Autowired
    public AvisosApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Crea un nou avís per a l&#39;expedient en funció de l&#39;acció executada
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idAccio Identificador de l&#39;acció
     * @param idExpedient Identificador de l&#39;expedient
     * @param avisCreacioAccioRDTO Dades del avís
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void crearAvisAccio(BigDecimal idAccio, BigDecimal idExpedient, AvisCreacioAccio avisCreacioAccioRDTO) throws RestClientException {
        Object postBody = avisCreacioAccioRDTO;
        
        // verify the required parameter 'idAccio' is set
        if (idAccio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idAccio' when calling crearAvisAccio");
        }
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling crearAvisAccio");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idAccio", idAccio);
        uriVariables.put("idExpedient", idExpedient);
        String path = UriComponentsBuilder.fromPath("/avisos/{idExpedient}/accions/{idAccio}/crear").buildAndExpand(uriVariables).toUriString();
        
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
     * Crea  o elimina un avís per a l&#39;expedient en funció de l&#39;acció executada
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idExpedient Identificador de l&#39;expedient
     * @param gestionarAvisosPerAccioRDTO Dades per a la gestió dels avisos
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void gestionarAvisosPerAccio(BigDecimal idExpedient, GestionarAvisosPerAccio gestionarAvisosPerAccioRDTO) throws RestClientException {
        Object postBody = gestionarAvisosPerAccioRDTO;
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling gestionarAvisosPerAccio");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idExpedient", idExpedient);
        String path = UriComponentsBuilder.fromPath("/avisos/{idExpedient}/gestionarAvisosPerAccio").buildAndExpand(uriVariables).toUriString();
        
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
