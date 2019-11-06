package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-17T12:21:43.485+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi")
public class DocumentacioRequeritApi {
	private ApiClient apiClient;

	public DocumentacioRequeritApi() {
		this(new ApiClient());
	}

	@Autowired
	public DocumentacioRequeritApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * returns the required documentation for the documentation of a expedient
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * 
	 * @param idDoc
	 *            idDoc
	 * @return List&lt;ConfDocEntradaRequeritRDTO&gt;
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public List<ConfDocEntradaRequeritRDTO> cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal idDoc) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDoc' is set
		if (idDoc == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDoc' when calling cercaConfiguracioDocumentacioEntradaRequerida");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDoc", idDoc);
		String path = UriComponentsBuilder.fromPath("/configuracioDocumentacio/docsEntradaRequerit/{idDoc}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<List<ConfDocEntradaRequeritRDTO>> returnType = new ParameterizedTypeReference<List<ConfDocEntradaRequeritRDTO>>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}
}
