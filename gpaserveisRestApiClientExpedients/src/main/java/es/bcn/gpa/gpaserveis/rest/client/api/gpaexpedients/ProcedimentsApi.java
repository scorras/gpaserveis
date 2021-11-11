package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaGetUgByReglesAssignacioRDTO;

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
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ProcedimentsApi")
public class ProcedimentsApi {
    private ApiClient apiClient;

    public ProcedimentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ProcedimentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets the resulting ug from applying the rules
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param estatIdext estatIdext
     * @param idExpedient idExpedient
     * @param idProcediment idProcediment
     * @return RespostaGetUgByReglesAssignacioRDTO
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RespostaGetUgByReglesAssignacioRDTO getUgByIdExpedientIdProcedimentAndEstatUsingGET(Integer estatIdext, Integer idExpedient, Integer idProcediment) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'estatIdext' is set
        if (estatIdext == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'estatIdext' when calling getUgByIdExpedientIdProcedimentAndEstatUsingGET");
        }
        
        // verify the required parameter 'idExpedient' is set
        if (idExpedient == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idExpedient' when calling getUgByIdExpedientIdProcedimentAndEstatUsingGET");
        }
        
        // verify the required parameter 'idProcediment' is set
        if (idProcediment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'idProcediment' when calling getUgByIdExpedientIdProcedimentAndEstatUsingGET");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("estatIdext", estatIdext);
        uriVariables.put("idExpedient", idExpedient);
        uriVariables.put("idProcediment", idProcediment);
        String path = UriComponentsBuilder.fromPath("/expedients/{idExpedient}/procediment/{idProcediment}/ug/estat/{estatIdext}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<RespostaGetUgByReglesAssignacioRDTO> returnType = new ParameterizedTypeReference<RespostaGetUgByReglesAssignacioRDTO>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
