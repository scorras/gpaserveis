package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaDocumentacioVinculadaCompletaRDTO;

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
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioVinculadaCompletaApi")
public class DocumentacioVinculadaCompletaApi {
    private ApiClient apiClient;

    public DocumentacioVinculadaCompletaApi() {
        this(new ApiClient());
    }

    @Autowired
    public DocumentacioVinculadaCompletaApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns DocumentacioVinculadaCompleta
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param idConfiguracioDocumentacio idConfiguracioDocumentacio
     * @return RespostaDocumentacioVinculadaCompletaRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaDocumentacioVinculadaCompletaRDTO obtenirDocumentacioVinculadaCompletaUsingGET(BigDecimal idConfiguracioDocumentacio) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'idConfiguracioDocumentacio' is set
        if (idConfiguracioDocumentacio == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idConfiguracioDocumentacio' when calling obtenirDocumentacioVinculadaCompletaUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idConfiguracioDocumentacio", idConfiguracioDocumentacio);
        String path = UriComponentsBuilder.fromPath("/configuracioDocumentacio/documentacioVinculadaCompleta/{idConfiguracioDocumentacio}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaDocumentacioVinculadaCompletaRDTO> returnType = new ParameterizedTypeReference<RespostaDocumentacioVinculadaCompletaRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
