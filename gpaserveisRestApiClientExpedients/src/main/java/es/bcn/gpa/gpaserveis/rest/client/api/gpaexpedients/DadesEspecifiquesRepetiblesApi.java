package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AfegirRepeticioGrupRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRepetiblesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EsborrarRepeticioGrupRDTO;

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
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.DadesEspecifiquesRepetiblesApi")
public class DadesEspecifiquesRepetiblesApi {
    private ApiClient apiClient;

    public DadesEspecifiquesRepetiblesApi() {
        this(new ApiClient());
    }

    @Autowired
    public DadesEspecifiquesRepetiblesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * AfegirRepeticioGrup
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param afegirRepeticioGrup afegirRepeticioGrup
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void afegirRepeticioGrupUsingPOST(AfegirRepeticioGrupRDTO afegirRepeticioGrup) throws RestClientException {
        Object postBody = afegirRepeticioGrup;
        
        // verify the required parameter 'afegirRepeticioGrup' is set
        if (afegirRepeticioGrup == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'afegirRepeticioGrup' when calling afegirRepeticioGrupUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiquesRepetibles/afegirRepeticioGrup").build().toUriString();
        
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
     * Returns the requested dades especifiques repetibles
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idExpedient idExpedient
     * @param visibilitat visibilitat
     * @return List&lt;DadesEspecifiquesRepetiblesRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DadesEspecifiquesRepetiblesRDTO> consultarDadesEspecifiquesRepetiblesExpedient(Integer idExpedient, Integer visibilitat) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling consultarDadesEspecifiquesRepetiblesExpedient");
        }
        
        // verify the required parameter 'visibilitat' is set
        if (visibilitat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'visibilitat' when calling consultarDadesEspecifiquesRepetiblesExpedient");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idExpedient", idExpedient);
        uriVariables.put("visibilitat", visibilitat);
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiquesRepetibles/{idExpedient}/{visibilitat}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<DadesEspecifiquesRepetiblesRDTO>> returnType = new ParameterizedTypeReference<List<DadesEspecifiquesRepetiblesRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns the requested dades especifiques repetibles by Sol·licitud
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idSollicitud idSollicitud
     * @param visibilitat visibilitat
     * @return List&lt;DadesEspecifiquesRepetiblesRDTO&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DadesEspecifiquesRepetiblesRDTO> consultarDadesEspecifiquesRepetiblesSollicitud(Integer idSollicitud, Integer visibilitat) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idSollicitud' is set
        if (idSollicitud == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idSollicitud' when calling consultarDadesEspecifiquesRepetiblesSollicitud");
        }
        
        // verify the required parameter 'visibilitat' is set
        if (visibilitat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'visibilitat' when calling consultarDadesEspecifiquesRepetiblesSollicitud");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idSollicitud", idSollicitud);
        uriVariables.put("visibilitat", visibilitat);
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiquesRepetibles/sollicitud/{idSollicitud}/{visibilitat}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<DadesEspecifiquesRepetiblesRDTO>> returnType = new ParameterizedTypeReference<List<DadesEspecifiquesRepetiblesRDTO>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * EsborrarRepeticioGrup
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param esborrarRepeticioGrup esborrarRepeticioGrup
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void esborrarRepeticioGrupUsingPOST(EsborrarRepeticioGrupRDTO esborrarRepeticioGrup) throws RestClientException {
        Object postBody = esborrarRepeticioGrup;
        
        // verify the required parameter 'esborrarRepeticioGrup' is set
        if (esborrarRepeticioGrup == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'esborrarRepeticioGrup' when calling esborrarRepeticioGrupUsingPOST");
        }
        
        String path = UriComponentsBuilder.fromPath("/expedients/dadesEspecifiquesRepetibles/esborrarRepeticioGrup").build().toUriString();
        
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
