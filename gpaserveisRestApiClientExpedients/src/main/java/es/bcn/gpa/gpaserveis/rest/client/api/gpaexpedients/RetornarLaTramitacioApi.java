package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import java.util.List;

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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarLaTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-14T11:11:38.011+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.RetornarLaTramitacioApi")
public class RetornarLaTramitacioApi {
	private ApiClient apiClient;

	public RetornarLaTramitacioApi() {
		this(new ApiClient());
	}

	@Autowired
	public RetornarLaTramitacioApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * RetornarLaTramitacio
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>201</b> - Created
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * 
	 * @param retornarLaTramitacioRDTO
	 *            retornarLaTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void retornarTramitacioExpedient(RetornarLaTramitacioRDTO retornarLaTramitacioRDTO) throws RestClientException {
		Object postBody = retornarLaTramitacioRDTO;

		// verify the required parameter 'retornarLaTramitacioRDTO' is set
		if (retornarLaTramitacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'retornarLaTramitacioRDTO' when calling retornarTramitacioExpedient");
		}

		String path = UriComponentsBuilder.fromPath("/expedients/retornarLaTramitacio").build().toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
		};
		apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}
}
