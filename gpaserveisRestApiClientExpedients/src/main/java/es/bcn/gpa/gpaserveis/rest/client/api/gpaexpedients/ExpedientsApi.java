package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-14T14:00:28.664+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients.ExpedientsApi")
public class ExpedientsApi {
	private ApiClient apiClient;

	public ExpedientsApi() {
		this(new ApiClient());
	}

	@Autowired
	public ExpedientsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Canvia l&#39;estat d&#39;un expedient en funció de l&#39;acció executada
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
	 * @param idAccio
	 *            Identificador de l&#39;acció
	 * @param idExpedient
	 *            Identificador de l&#39;expedient
	 * @param expedientCanviEstatAccioRDTO
	 *            Dades del canvi d&#39;estat
	 * @return RespostaCanviarEstatAccioExpedient
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public RespostaCanviarEstatAccioExpedient canviarEstatAccioExpedient(BigDecimal idAccio, BigDecimal idExpedient,
	        ExpedientCanviEstatAccio expedientCanviEstatAccioRDTO) throws RestClientException {
		Object postBody = expedientCanviEstatAccioRDTO;

		// verify the required parameter 'idAccio' is set
		if (idAccio == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
			        "Missing the required parameter 'idAccio' when calling canviarEstatAccioExpedient");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
			        "Missing the required parameter 'idExpedient' when calling canviarEstatAccioExpedient");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idAccio", idAccio);
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/expedients/{idExpedient}/accions/{idAccio}/canviEstat").buildAndExpand(uriVariables)
		        .toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<RespostaCanviarEstatAccioExpedient> returnType = new ParameterizedTypeReference<RespostaCanviarEstatAccioExpedient>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
		        returnType);
	}
}
