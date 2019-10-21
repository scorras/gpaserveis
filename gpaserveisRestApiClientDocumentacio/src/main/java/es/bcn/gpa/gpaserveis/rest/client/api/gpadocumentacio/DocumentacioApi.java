package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsAssociatsIntra;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRegistrarComunicat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentRevisio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-10-17T12:21:43.485+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi")
public class DocumentacioApi {
	private ApiClient apiClient;

	public DocumentacioApi() {
		this(new ApiClient());
	}

	@Autowired
	public DocumentacioApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * updates the doc entrada responsable
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
	 * @param docsEntradaRDTO
	 *            docsEntradaRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO actualitzarDeclaracioResponsable(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsEntradaRDTO;

		// verify the required parameter 'docsEntradaRDTO' is set
		if (docsEntradaRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntradaRDTO' when calling actualitzarDeclaracioResponsable");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling actualitzarDeclaracioResponsable");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/responsable/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * actualitzar el document d&#39;entrada
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
	 * @param docsEntradaRDTO
	 *            docsEntradaRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO actualitzarDocumentEntrada(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws RestClientException {
		Object postBody = docsEntradaRDTO;

		// verify the required parameter 'docsEntradaRDTO' is set
		if (docsEntradaRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntradaRDTO' when calling actualitzarDocumentEntrada");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling actualitzarDocumentEntrada");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/{idExpedient}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea el document digitalitzat d&#39;entrada
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
	 * @param docsEntradaRDTO
	 *            docsEntradaRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO actualitzarDocumentEntradaDigitalitzat(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsEntradaRDTO;

		// verify the required parameter 'docsEntradaRDTO' is set
		if (docsEntradaRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntradaRDTO' when calling actualitzarDocumentEntradaDigitalitzat");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling actualitzarDocumentEntradaDigitalitzat");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/digitalitzar/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * actualitzar document tramitacio
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
	 * @param docsTramitacioRDTO
	 *            docsTramitacioRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO actualitzarDocumentTramitacio(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsTramitacioRDTO;

		// verify the required parameter 'docsTramitacioRDTO' is set
		if (docsTramitacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsTramitacioRDTO' when calling actualitzarDocumentTramitacio");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling actualitzarDocumentTramitacio");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/{idExpedient}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * actualitzar el document digitalitzat de tramitació
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
	 * @param docsTramitacioRDTO
	 *            docsTramitacioRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO actualitzarDocumentTramitacioDigitalitzat(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsTramitacioRDTO;

		// verify the required parameter 'docsTramitacioRDTO' is set
		if (docsTramitacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsTramitacioRDTO' when calling actualitzarDocumentTramitacioDigitalitzat");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling actualitzarDocumentTramitacioDigitalitzat");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/digitalitzar/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * updates the requeriment
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
	 * @param guardarRequerimentExpedientRDTO
	 *            guardarRequerimentExpedientRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO actualitzarRequeriment(GuardarRequerimentExpedient guardarRequerimentExpedientRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = guardarRequerimentExpedientRDTO;

		// verify the required parameter 'guardarRequerimentExpedientRDTO' is
		// set
		if (guardarRequerimentExpedientRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'guardarRequerimentExpedientRDTO' when calling actualitzarRequeriment");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling actualitzarRequeriment");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/requeriment/{idExpedient}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * associa el registre a la llista de documentació
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
	 * @param docsEntActualizarRegistreRDTO
	 *            docsEntActualizarRegistreRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void associarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistreRDTO) throws RestClientException {
		Object postBody = docsEntActualizarRegistreRDTO;

		// verify the required parameter 'docsEntActualizarRegistreRDTO' is set
		if (docsEntActualizarRegistreRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntActualizarRegistreRDTO' when calling associarRegistreDocsEnt");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/associarRegistreDocsEnt").build().toUriString();

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

	/**
	 * associa el registre a la documentació de l&#39;expedient
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
	 * @param documentActualizarRegistreRDTO
	 *            documentActualizarRegistreRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void associarRegistreDocumentacio(DocumentActualizarRegistre documentActualizarRegistreRDTO) throws RestClientException {
		Object postBody = documentActualizarRegistreRDTO;

		// verify the required parameter 'documentActualizarRegistreRDTO' is set
		if (documentActualizarRegistreRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'documentActualizarRegistreRDTO' when calling associarRegistreDocumentacio");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/associarRegistreDocumentacio").build().toUriString();

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

	/**
	 * Associar els documents d&#39;entrada
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
	 * @param docsAssociatsIntraRDTO
	 *            docsAssociatsIntraRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void associatsDocsIntra(DocsAssociatsIntra docsAssociatsIntraRDTO) throws RestClientException {
		Object postBody = docsAssociatsIntraRDTO;

		// verify the required parameter 'docsAssociatsIntraRDTO' is set
		if (docsAssociatsIntraRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsAssociatsIntraRDTO' when calling associatsDocsIntra");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/docsEntrada/associatsDocsIntra").build().toUriString();

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

	/**
	 * Callback per actualitzar l&#39;estat dels documents digitalitzats
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
	 * @param callbackDigitalitzacioRDTO
	 *            callbackDigitalitzacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void callbackDigitalitzacio(CallbackDigitalitzacio callbackDigitalitzacioRDTO) throws RestClientException {
		Object postBody = callbackDigitalitzacioRDTO;

		// verify the required parameter 'callbackDigitalitzacioRDTO' is set
		if (callbackDigitalitzacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'callbackDigitalitzacioRDTO' when calling callbackDigitalitzacio");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/callbackDigitalitzacio").build().toUriString();

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

	/**
	 * Callback per actualitzar l&#39;estat dels documents enviats a portasig
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
	 * @param callbackPortaSigRDTO
	 *            callbackPortaSigRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void callbackPortaSig(CallbackPortaSig callbackPortaSigRDTO) throws RestClientException {
		Object postBody = callbackPortaSigRDTO;

		// verify the required parameter 'callbackPortaSigRDTO' is set
		if (callbackPortaSigRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'callbackPortaSigRDTO' when calling callbackPortaSig");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/callbackPortaSig").build().toUriString();

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

	/**
	 * Returns the requested dades operacio requerit
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
	 * @return List&lt;BigDecimal&gt;
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public List<BigDecimal> cercaDadesOperacioRequerits(BigDecimal idDoc) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDoc' is set
		if (idDoc == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDoc' when calling cercaDadesOperacioRequerits");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDoc", idDoc);
		String path = UriComponentsBuilder.fromPath("/documentacio/dadesOperRequerit/{idDoc}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<List<BigDecimal>> returnType = new ParameterizedTypeReference<List<BigDecimal>>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Returns the requested documentacio entrada grouped by tràmit OVT
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
	 * @param idDocumentacio
	 *            idDocumentacio
	 * @return List&lt;DocsEntradaRDTO&gt;
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public List<DocsEntradaRDTO> cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDocumentacio' is set
		if (idDocumentacio == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDocumentacio' when calling cercaDocumentsEntradaAgrupatsPerTramitOvt");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDocumentacio", idDocumentacio);
		String path = UriComponentsBuilder.fromPath("/documentacio/{idDocumentacio}/entrada/agrupatPerTramitOvt")
				.buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<List<DocsEntradaRDTO>> returnType = new ParameterizedTypeReference<List<DocsEntradaRDTO>>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * ComprovarDocumentsSignatsExpedient
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
	 * @param idDocumentacio
	 *            idDocumentacio
	 * @return Boolean
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public Boolean comprovarDocumentsSignatsExpedient(BigDecimal idDocumentacio) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDocumentacio' is set
		if (idDocumentacio == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDocumentacio' when calling comprovarDocumentsSignatsExpedient");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDocumentacio", idDocumentacio);
		String path = UriComponentsBuilder.fromPath("/documentacio/comprovarDocumentsSignatsExpedient/{idDocumentacio}")
				.buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<Boolean> returnType = new ParameterizedTypeReference<Boolean>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Returns the requested document
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
	 * @param id
	 *            id
	 * @return DocsRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsRDTO consultarDadesDocument(BigDecimal id) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'id' when calling consultarDadesDocument");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", id);
		String path = UriComponentsBuilder.fromPath("/documentacio/{id}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsRDTO> returnType = new ParameterizedTypeReference<DocsRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Returns the requested document
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
	 * @param id
	 *            id
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal id) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'id' when calling consultarDadesDocumentAportat");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", id);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/dades/{id}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Returns the requested document
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
	 * @param id
	 *            id
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO consultarDadesDocumentGenerat(BigDecimal id) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'id' is set
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'id' when calling consultarDadesDocumentGenerat");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", id);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/dades/{id}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * updates the doc entrada responsable
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
	 * @param docsEntradaRDTO
	 *            docsEntradaRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO crearDeclaracioResponsable(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws RestClientException {
		Object postBody = docsEntradaRDTO;

		// verify the required parameter 'docsEntradaRDTO' is set
		if (docsEntradaRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntradaRDTO' when calling crearDeclaracioResponsable");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling crearDeclaracioResponsable");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/responsable/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea el document d&#39;entrada
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
	 * @param docsEntradaRDTO
	 *            docsEntradaRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO crearDocumentEntrada(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient) throws RestClientException {
		Object postBody = docsEntradaRDTO;

		// verify the required parameter 'docsEntradaRDTO' is set
		if (docsEntradaRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntradaRDTO' when calling crearDocumentEntrada");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling crearDocumentEntrada");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/{idExpedient}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea el document digitalitzat d&#39;entrada
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
	 * @param docsEntradaRDTO
	 *            docsEntradaRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO crearDocumentEntradaDigitalitzat(DocsEntradaRDTO docsEntradaRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsEntradaRDTO;

		// verify the required parameter 'docsEntradaRDTO' is set
		if (docsEntradaRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntradaRDTO' when calling crearDocumentEntradaDigitalitzat");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling crearDocumentEntradaDigitalitzat");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/digitalitzar/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea el document de tramitació
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
	 * @param docsTramitacioRDTO
	 *            docsTramitacioRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO crearDocumentTramitacio(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsTramitacioRDTO;

		// verify the required parameter 'docsTramitacioRDTO' is set
		if (docsTramitacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsTramitacioRDTO' when calling crearDocumentTramitacio");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling crearDocumentTramitacio");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/{idExpedient}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea el document digitalitzat de tramitació
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
	 * @param docsTramitacioRDTO
	 *            docsTramitacioRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO crearDocumentTramitacioDigitalitzat(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsTramitacioRDTO;

		// verify the required parameter 'docsTramitacioRDTO' is set
		if (docsTramitacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsTramitacioRDTO' when calling crearDocumentTramitacioDigitalitzat");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling crearDocumentTramitacioDigitalitzat");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/digitalitzar/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Crear una petició per signar o validar un document
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
	 * @param signarDocumentRDTO
	 *            signarDocumentRDTO
	 * @return PeticionsPortasig
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public PeticionsPortasig crearPeticioPortaSig(SignarDocument signarDocumentRDTO) throws RestClientException {
		Object postBody = signarDocumentRDTO;

		// verify the required parameter 'signarDocumentRDTO' is set
		if (signarDocumentRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'signarDocumentRDTO' when calling crearPeticioPortaSig");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/crearPeticioPortaSig").build().toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<PeticionsPortasig> returnType = new ParameterizedTypeReference<PeticionsPortasig>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Delete DocsEntrada
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>204</b> - No Content
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * 
	 * @param idDocument
	 *            idDocument
	 * @param idExpedient
	 *            idExpedient
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void esBorrarDocumentacioEntrada(BigDecimal idDocument, BigDecimal idExpedient) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDocument' is set
		if (idDocument == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDocument' when calling esBorrarDocumentacioEntrada");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling esBorrarDocumentacioEntrada");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDocument", idDocument);
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/esBorrar/{idExpedient}/entrada/{idDocument}")
				.buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
		};
		apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Delete DocsTramitacio
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>204</b> - No Content
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * 
	 * @param idDocument
	 *            idDocument
	 * @param idExpedient
	 *            idExpedient
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void esBorrarDocumentacioTramitacio(BigDecimal idDocument, BigDecimal idExpedient) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDocument' is set
		if (idDocument == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDocument' when calling esBorrarDocumentacioTramitacio");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling esBorrarDocumentacioTramitacio");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDocument", idDocument);
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/esBorrar/{idExpedient}/tramitacio/{idDocument}")
				.buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
		};
		apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * updates the doc entrada
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
	 * @param docsEntrada
	 *            docsEntrada
	 * @param file
	 *            file
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsEntradaRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsEntradaRDTO guardarDocumentEntradaFitxer(String docsEntrada, File file, BigDecimal idExpedient) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'docsEntrada' is set
		if (docsEntrada == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsEntrada' when calling guardarDocumentEntradaFitxer");
		}

		// verify the required parameter 'file' is set
		if (file == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'file' when calling guardarDocumentEntradaFitxer");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling guardarDocumentEntradaFitxer");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/fitxer/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		formParams.add("docsEntrada", docsEntrada);
		formParams.add("file", new FileSystemResource(file));

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "multipart/form-data" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsEntradaRDTO> returnType = new ParameterizedTypeReference<DocsEntradaRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * save the doc tramitacio i fitxer
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
	 * @param docsTramitacio
	 *            docsTramitacio
	 * @param file
	 *            file
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO guardarDocumentTramitacioFitxer(String docsTramitacio, File file, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'docsTramitacio' is set
		if (docsTramitacio == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsTramitacio' when calling guardarDocumentTramitacioFitxer");
		}

		// verify the required parameter 'file' is set
		if (file == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'file' when calling guardarDocumentTramitacioFitxer");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling guardarDocumentTramitacioFitxer");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/fitxer/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		formParams.add("docsTramitacio", docsTramitacio);
		formParams.add("file", new FileSystemResource(file));

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "multipart/form-data" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * save the doc tramitacio i plantilla
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
	 * @param docsTramitacioRDTO
	 *            docsTramitacioRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO guardarDocumentTramitacioPlantilla(DocsTramitacioRDTO docsTramitacioRDTO, BigDecimal idExpedient)
			throws RestClientException {
		Object postBody = docsTramitacioRDTO;

		// verify the required parameter 'docsTramitacioRDTO' is set
		if (docsTramitacioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'docsTramitacioRDTO' when calling guardarDocumentTramitacioPlantilla");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling guardarDocumentTramitacioPlantilla");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/plantilla/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea o actualitza el requeriment i desa el document
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
	 * @param file
	 *            file
	 * @param idExpedient
	 *            idExpedient
	 * @param requerimentExpedient
	 *            requerimentExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO guardarRequerimentFitxer(File file, BigDecimal idExpedient, String requerimentExpedient)
			throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'file' is set
		if (file == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'file' when calling guardarRequerimentFitxer");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling guardarRequerimentFitxer");
		}

		// verify the required parameter 'requerimentExpedient' is set
		if (requerimentExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'requerimentExpedient' when calling guardarRequerimentFitxer");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/requeriment/fitxer/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		formParams.add("file", new FileSystemResource(file));
		formParams.add("requerimentExpedient", requerimentExpedient);

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "multipart/form-data" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * crea o actualitza el requeriment i desa la plantilla
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
	 * @param guardarRequerimentExpedientRDTO
	 *            guardarRequerimentExpedientRDTO
	 * @param idExpedient
	 *            idExpedient
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO guardarRequerimentPlantilla(GuardarRequerimentExpedient guardarRequerimentExpedientRDTO,
			BigDecimal idExpedient) throws RestClientException {
		Object postBody = guardarRequerimentExpedientRDTO;

		// verify the required parameter 'guardarRequerimentExpedientRDTO' is
		// set
		if (guardarRequerimentExpedientRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'guardarRequerimentExpedientRDTO' when calling guardarRequerimentPlantilla");
		}

		// verify the required parameter 'idExpedient' is set
		if (idExpedient == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idExpedient' when calling guardarRequerimentPlantilla");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idExpedient", idExpedient);
		String path = UriComponentsBuilder.fromPath("/documentacio/requeriment/plantilla/{idExpedient}").buildAndExpand(uriVariables)
				.toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Returns the requested documentacio tramitacio
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
	 * @param idNotificacio
	 *            idNotificacio
	 * @return DocsTramitacioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public DocsTramitacioRDTO obtenirDocsTramitacioByNotificationId(BigDecimal idNotificacio) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idNotificacio' is set
		if (idNotificacio == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idNotificacio' when calling obtenirDocsTramitacioByNotificationId");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idNotificacio", idNotificacio);
		String path = UriComponentsBuilder.fromPath("/documentacio/docsTramitacioByNotificationId/{idNotificacio}")
				.buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<DocsTramitacioRDTO> returnType = new ParameterizedTypeReference<DocsTramitacioRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Updates the selected DocsTramitacio with the comunicat specified
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
	 * @param documentRegistrarComunicatRDTO
	 *            documentRegistrarComunicatRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void registrarComunicatDocumentTramitacio(DocumentRegistrarComunicat documentRegistrarComunicatRDTO) throws RestClientException {
		Object postBody = documentRegistrarComunicatRDTO;

		// verify the required parameter 'documentRegistrarComunicatRDTO' is set
		if (documentRegistrarComunicatRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'documentRegistrarComunicatRDTO' when calling registrarComunicatDocumentTramitacio");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/tramitacio/comunicat").build().toUriString();

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

	/**
	 * Updates all selected DocsEntrada with the EstatRevisio specified
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
	 * @param documentRevisioRDTO
	 *            documentRevisioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void revisarDocumentacioEntrada(DocumentRevisio documentRevisioRDTO) throws RestClientException {
		Object postBody = documentRevisioRDTO;

		// verify the required parameter 'documentRevisioRDTO' is set
		if (documentRevisioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'documentRevisioRDTO' when calling revisarDocumentacioEntrada");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/revisar").build().toUriString();

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

	/**
	 * Updates all selected DocsEntrada with the EstatRevisio specified
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
	 * @param documentRevisioRDTO
	 *            documentRevisioRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void revisarDocumentacioEntradaMassiu(DocumentRevisio documentRevisioRDTO) throws RestClientException {
		Object postBody = documentRevisioRDTO;

		// verify the required parameter 'documentRevisioRDTO' is set
		if (documentRevisioRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'documentRevisioRDTO' when calling revisarDocumentacioEntradaMassiu");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/entrada/revisarMassiu").build().toUriString();

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

	/**
	 * Crear una petició per signar un document
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
	 * @param signarSegellDocumentRDTO
	 *            signarSegellDocumentRDTO
	 * @return SignarSegellDocument
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public SignarSegellDocument signarSegell(SignarSegellDocument signarSegellDocumentRDTO) throws RestClientException {
		Object postBody = signarSegellDocumentRDTO;

		// verify the required parameter 'signarSegellDocumentRDTO' is set
		if (signarSegellDocumentRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'signarSegellDocumentRDTO' when calling signarSegell");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/signarSegell").build().toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = { "application/json" };
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<SignarSegellDocument> returnType = new ParameterizedTypeReference<SignarSegellDocument>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}

	/**
	 * Closes the expedient&#39;s requirements
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
	 * @param idDocumentacio
	 *            idDocumentacio
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void tancarRequerimentsExpedient(BigDecimal idDocumentacio) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idDocumentacio' is set
		if (idDocumentacio == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'idDocumentacio' when calling tancarRequerimentsExpedient");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idDocumentacio", idDocumentacio);
		String path = UriComponentsBuilder.fromPath("/documentacio/tancarRequeriments/{idDocumentacio}").buildAndExpand(uriVariables)
				.toUriString();

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

	/**
	 * desassocia el registre de la documentació de l&#39;expedient
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
	 * @param documentActualizarRegistreRDTO
	 *            documentActualizarRegistreRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public void desassociarRegistreDocumentacio(DocumentActualizarRegistre documentActualizarRegistreRDTO) throws RestClientException {
		Object postBody = documentActualizarRegistreRDTO;

		// verify the required parameter 'documentActualizarRegistreRDTO' is set
		if (documentActualizarRegistreRDTO == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'documentActualizarRegistreRDTO' when calling desassociarRegistreDocumentacio");
		}

		String path = UriComponentsBuilder.fromPath("/documentacio/desassociarRegistreDocumentacio").build().toUriString();

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
		apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
				returnType);
	}
}
