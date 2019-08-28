package es.bcn.gpa.gpaserveis.rest.client.api.gpatramits;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
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

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpatramits.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-14T14:05:54.907+02:00")
@Component("es.bcn.gpa.gpaserveis.rest.client.api.gpatramits.TramitsApi")
public class TramitsApi {
	private ApiClient apiClient;

	public TramitsApi() {
		this(new ApiClient());
	}

	@Autowired
	public TramitsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Returns all the tramits that meet the search criteria and are associated
	 * with a procediment
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
	 * @param idProcediment
	 *            idProcediment
	 * @param absoluteRowNumberOfFirstRowInCurrentPage
	 *            The absoluteRowNumberOfFirstRowInCurrentPage parameter
	 * @param absoluteRowNumberOfLastRowInCurrentPage
	 *            The absoluteRowNumberOfLastRowInCurrentPage parameter
	 * @param currentPageHasNextPage
	 *            The currentPageHasNextPage parameter
	 * @param currentPageHasPreviousPage
	 *            The currentPageHasPreviousPage parameter
	 * @param currentPageIsFirstPage
	 *            The currentPageIsFirstPage parameter
	 * @param currentPageIsLastPage
	 *            The currentPageIsLastPage parameter
	 * @param currentPageNumber
	 *            The currentPageNumber parameter
	 * @param darreraModificacio
	 *            The darreraModificacio parameter
	 * @param dataGestioElectronica
	 *            The dataGestioElectronica parameter
	 * @param descripcio
	 *            The descripcio parameter
	 * @param dir
	 *            The dir parameter
	 * @param esTramitIniciacio
	 *            The esTramitIniciacio parameter
	 * @param exclusiuIntern
	 *            The exclusiuIntern parameter
	 * @param gestioElectronica
	 *            The gestioElectronica parameter
	 * @param id
	 *            The id parameter
	 * @param informacioTramitador
	 *            The informacioTramitador parameter
	 * @param nextPageNumber
	 *            The nextPageNumber parameter
	 * @param nom
	 *            The nom parameter
	 * @param normaAltresAplicacio
	 *            The normaAltresAplicacio parameter
	 * @param normaReferenciaPrincipal
	 *            The normaReferenciaPrincipal parameter
	 * @param pageSize
	 *            The pageSize parameter
	 * @param previousPageNumber
	 *            The previousPageNumber parameter
	 * @param rolUsuari
	 *            The rolUsuari parameter
	 * @param sort
	 *            The sort parameter
	 * @param totalElements
	 *            The totalElements parameter
	 * @param totalPages
	 *            The totalPages parameter
	 * @param ultimaModificacio
	 *            The ultimaModificacio parameter
	 * @return PageDataOfTramitsRDTO
	 * @throws RestClientException
	 *             if an error occurs while attempting to invoke the API
	 */
	public PageDataOfTramitsRDTO cercaTramitsProcediment(BigDecimal idProcediment, Integer absoluteRowNumberOfFirstRowInCurrentPage,
	        Integer absoluteRowNumberOfLastRowInCurrentPage, Boolean currentPageHasNextPage, Boolean currentPageHasPreviousPage,
	        Boolean currentPageIsFirstPage, Boolean currentPageIsLastPage, Integer currentPageNumber, DateTime darreraModificacio,
	        DateTime dataGestioElectronica, String descripcio, String dir, Integer esTramitIniciacio, Integer exclusiuIntern,
	        String gestioElectronica, BigDecimal id, String informacioTramitador, Integer nextPageNumber, String nom,
	        String normaAltresAplicacio, String normaReferenciaPrincipal, Integer pageSize, Integer previousPageNumber, String rolUsuari,
	        String sort, Long totalElements, Integer totalPages, BigDecimal ultimaModificacio) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'idProcediment' is set
		if (idProcediment == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
			        "Missing the required parameter 'idProcediment' when calling cercaTramitsProcediment");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("idProcediment", idProcediment);
		String path = UriComponentsBuilder.fromPath("/tramits/searchAssociated/procediment/{idProcediment}").buildAndExpand(uriVariables)
		        .toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfFirstRowInCurrentPage",
		        absoluteRowNumberOfFirstRowInCurrentPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "absoluteRowNumberOfLastRowInCurrentPage",
		        absoluteRowNumberOfLastRowInCurrentPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasNextPage", currentPageHasNextPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageHasPreviousPage", currentPageHasPreviousPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsFirstPage", currentPageIsFirstPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageIsLastPage", currentPageIsLastPage));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "currentPageNumber", currentPageNumber));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "darreraModificacio", darreraModificacio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dataGestioElectronica", dataGestioElectronica));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "descripcio", descripcio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dir", dir));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "esTramitIniciacio", esTramitIniciacio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclusiuIntern", exclusiuIntern));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "gestioElectronica", gestioElectronica));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "informacioTramitador", informacioTramitador));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPageNumber", nextPageNumber));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nom", nom));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "normaAltresAplicacio", normaAltresAplicacio));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "normaReferenciaPrincipal", normaReferenciaPrincipal));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "previousPageNumber", previousPageNumber));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "rolUsuari", rolUsuari));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort", sort));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalElements", totalElements));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "totalPages", totalPages));
		queryParams.putAll(apiClient.parameterToMultiValueMap(null, "ultimaModificacio", ultimaModificacio));

		final String[] accepts = { "*/*" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<PageDataOfTramitsRDTO> returnType = new ParameterizedTypeReference<PageDataOfTramitsRDTO>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
		        returnType);
	}
}
