/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.4.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import static java.math.BigDecimal.ONE;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;

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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatDigitalitzacioDocumentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.GuardarRequerimentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiClient.CollectionFormat;

/**
 * API tests for DocumentacioApi.
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentacioApiTest extends ParentTest {

	/** The api. */
	@InjectMocks
	private DocumentacioApi api = new DocumentacioApi();

	/** The test folder. */
	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();

	/**
	 * Delete DocsEntrada
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void esBorrarDocumentacioEntradaTest() {
		when(apiClient.invokeAPI(eq("/documentacio/esBorrar/1/entrada/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		BigDecimal idDocsEntrada = BigDecimal.ONE;
		BigDecimal idExpedient = BigDecimal.ONE;
		api.esBorrarDocumentacioEntrada(idDocsEntrada, idExpedient);

		assertTrue(true);
	}

	/**
	 * Delete DocsTramitacio
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void esBorrarDocumentacioTramitacioTest() {
		when(apiClient.invokeAPI(eq("/documentacio/esBorrar/1/tramitacio/1"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		BigDecimal idDocsTramitacio = BigDecimal.ONE;
		BigDecimal idExpedient = BigDecimal.ONE;
		api.esBorrarDocumentacioTramitacio(idDocsTramitacio, idExpedient);

		assertTrue(true);
	}

	/**
	 * Returns the requested documentacio entrada by Sol·licitud
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void cercaDocumentsEntradaPerSollicitudTest() {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/sollicitud/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new ArrayList<DocsEntradaRDTO>());

		BigDecimal idSollicitud = ONE;
		List<DocsEntradaRDTO> response = api.cercaDocumentsEntradaPerSollicitud(idSollicitud);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested documentacio entrada grouped by tràmit OVT.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void cercaDocumentsEntradaAgrupatsPerTramitOvtTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/1/entrada/agrupatPerTramitOvt"), eq(HttpMethod.GET), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new ArrayList<DocsEntradaRDTO>());

		BigDecimal idDocumentacio = ONE;
		List<DocsEntradaRDTO> response = api.cercaDocumentsEntradaAgrupatsPerTramitOvt(idDocumentacio);

		assertTrue(response != null);
	}

	/**
	 * Updates all selected DocsEntrada with the EstatRevisio specified.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void revisarDocumentacioEntradaUsingPOSTTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/revisar"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		DocumentRevisio documentRevisioRDTO = new DocumentRevisio();
		api.revisarDocumentacioEntrada(documentRevisioRDTO);

		assertTrue(true);
	}

	/**
	 * Returns the requested document.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void consultarDadesDocumentAportatTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/dades/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		BigDecimal id = ONE;
		DocsEntradaRDTO response = api.consultarDadesDocumentAportat(id);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested dades operacio requerit.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void cercaDadesOperacioRequeritsTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/dadesOperRequerit/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new ArrayList<BigDecimal>());

		BigDecimal idDoc = ONE;
		List<BigDecimal> response = api.cercaDadesOperacioRequerits(idDoc);

		assertTrue(response != null);
	}

	/**
	 * associa el registre a la llista de documentació.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void associarRegistreDocsEntTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/associarRegistreDocsEnt"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		DocsEntActualizarRegistre docsEntActualizarRegistreRDTO = new DocsEntActualizarRegistre();
		api.associarRegistreDocsEnt(docsEntActualizarRegistreRDTO);

		assertTrue(true);
	}

	/**
	 * associa el registre a la documentació de l&#39;expedient.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void associarRegistreDocumentacioTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/associarRegistreDocsEnt"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		DocumentActualizarRegistre documentActualizarRegistreRDTO = new DocumentActualizarRegistre();
		api.associarRegistreDocumentacio(documentActualizarRegistreRDTO);

		assertTrue(true);
	}

	/**
	 * Crear peticio porta sig test.
	 *
	 * @throws RestClientException
	 *             the api exception
	 */
	@Test
	public void crearPeticioPortaSigTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/crearPeticioPortaSig"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		SignarDocument signarDocumentRDTO = new SignarDocument();
		api.crearPeticioPortaSig(signarDocumentRDTO);

		assertTrue(true);
	}

	/**
	 * Returns the requested document.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void consultarDadesDocumentGeneratTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/dades/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		BigDecimal id = ONE;
		DocsTramitacioRDTO response = api.consultarDadesDocumentGenerat(id);

		assertTrue(response != null);
	}

	/**
	 * updates the doc entrada responsable.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void crearDeclaracioResponsableTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/responsable/1"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.crearDeclaracioResponsable(docsEntradaRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * crea el document d&#39;entrada.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void crearDocumentEntradaTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.crearDocumentEntrada(docsEntradaRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * crea o actualitza el requeriment i desa el document.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void guardarRequerimentFitxerTest() throws RestClientException, IOException {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/documentacio/requeriment/fitxer/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		File file = testFolder.newFolder("test");
		BigDecimal idExpedient = ONE;
		String requerimentExpedient = StringUtils.EMPTY;
		DocsTramitacioRDTO response = api.guardarRequerimentFitxer(file, idExpedient, requerimentExpedient);

		assertTrue(response != null);
	}

	/**
	 * Returns the requested documentacio tramitacio.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void obtenirDocsTramitacioByNotificationIdTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/docsTramitacioByNotificationId/1"), eq(HttpMethod.GET), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		BigDecimal idNotificacio = ONE;
		DocsTramitacioRDTO response = api.obtenirDocsTramitacioByNotificationId(idNotificacio);

		assertTrue(response != null);
	}

	/**
	 * updates the doc entrada.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void guardarDocumentEntradaFitxerTest() throws RestClientException, IOException {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/documentacio/entrada/fitxer/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		String docsEntrada = StringUtils.EMPTY;
		File file = testFolder.newFolder("test");
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.guardarDocumentEntradaFitxer(docsEntrada, file, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * save the doc tramitacio i fitxer.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void guardarDocumentTramitacioFitxerTest() throws RestClientException, IOException {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/fitxer/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		String docsTramitacio = StringUtils.EMPTY;
		File file = testFolder.newFolder("test");
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.guardarDocumentTramitacioFitxer(docsTramitacio, file, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * save the doc tramitacio i plantilla.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void guardarDocumentTramitacioPlantillaTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/plantilla/1"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.guardarDocumentTramitacioPlantilla(docsTramitacioRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * save the doc tramitacio i plantilla
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void guardarDocumentTramitacioJustificantPlantillaTest() {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/justificant/plantilla/1/sollicitud/1"), eq(HttpMethod.POST),
		        any(MultiValueMap.class), any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class),
		        any(MediaType.class), any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		BigDecimal idSollicitud = ONE;
		DocsTramitacioRDTO response = api.guardarDocumentTramitacioJustificantPlantilla(docsTramitacioRDTO, idExpedient, idSollicitud);

		assertTrue(response != null);
	}

	/**
	 * updates the doc entrada responsable.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void actualitzarDeclaracioResponsableTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/responsable/1"), eq(HttpMethod.PUT), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.actualitzarDeclaracioResponsable(docsEntradaRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * actualitzar el document d&#39;entrada.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void actualitzarDocumentEntradaTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/1"), eq(HttpMethod.PUT), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.actualitzarDocumentEntrada(docsEntradaRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * actualitzar document tramitacio.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void actualitzarDocumentTramitacioTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/1"), eq(HttpMethod.PUT), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.actualitzarDocumentTramitacio(docsTramitacioRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * Callback per actualitzar l&#39;estat dels documents enviats a portasig.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void callbackPortaSigTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/callbackPortaSig"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		CallbackPortaSig callbackPortaSigRDTO = new CallbackPortaSig();
		api.callbackPortaSig(callbackPortaSigRDTO);
		assertTrue(true);
	}

	/**
	 * Closes the expedient&#39;s requirements.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void tancarRequerimentsExpedientTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/tancarRequeriments/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		BigDecimal idDocumentacio = ONE;
		api.tancarRequerimentsExpedient(idDocumentacio);
		assertTrue(true);
	}

	/**
	 * crea el document de tramitació.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void crearDocumentTramitacioTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.crearDocumentTramitacio(docsTramitacioRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * crea el document digitalitzat d&#39;entrada.
	 */
	@Test
	public void crearDocumentEntradaDigitalitzatTest() {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/digitalitzar/1"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.crearDocumentEntradaDigitalitzat(docsEntradaRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * crea el document digitalitzat de tramitacio.
	 */
	@Test
	public void crearDocumentTramitacioDigitalitzatTest() {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/digitalitzar/1"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.crearDocumentTramitacioDigitalitzat(docsTramitacioRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * Updates the selected DocsTramitacio with the comunicat specified.
	 */
	@Test
	public void registrarComunicatDocumentTramitacioTest() {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/comunicat"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		DocumentRegistrarComunicat documentRegistrarComunicatRDTO = new DocumentRegistrarComunicat();
		api.registrarComunicatDocumentTramitacio(documentRegistrarComunicatRDTO);

		assertTrue(true);
	}

	/**
	 * Callback per actualitzar l&#39;estat dels documents digitalitzats.
	 */
	@Test
	public void callbackDigitalitzacioTest() {
		when(apiClient.invokeAPI(eq("/documentacio/callbackDigitalitzacio"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		CallbackDigitalitzacio callbackDigitalitzacioRDTO = new CallbackDigitalitzacio();
		api.callbackDigitalitzacio(callbackDigitalitzacioRDTO);

		assertTrue(true);
	}

	/**
	 * Returns the requested document.
	 */
	@Test
	public void consultarDadesDocumentTest() {
		when(apiClient.invokeAPI(eq("/documentacio/1"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsRDTO());

		BigDecimal id = ONE;
		DocsRDTO response = api.consultarDadesDocument(id);

		assertTrue(response != null);
	}

	/**
	 * Associar els documents d&#39;entrada.
	 */
	@Test
	public void associatsDocsIntraTest() {
		when(apiClient.invokeAPI(eq("/documentacio/docsEntrada/associatsDocsIntra"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		DocsAssociatsIntra docsAssociatsIntraRDTO = new DocsAssociatsIntra();
		api.associatsDocsIntra(docsAssociatsIntraRDTO);

		assertTrue(true);
	}

	/**
	 * Signar segell test.
	 */
	@Test
	public void signarSegellTest() {
		when(apiClient.invokeAPI(eq("/documentacio/signarSegell"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new SignarSegellDocument());

		SignarSegellDocument signarSegellDocumentRDTO = new SignarSegellDocument();
		SignarSegellDocument response = api.signarSegell(signarSegellDocumentRDTO);

		assertTrue(response != null);
	}

	/**
	 * actualitzar Document Tramitacio
	 * 
	 * @throws RestClientException
	 */
	@Test
	public void actualitzarDocumentEntradaDigitalitzatTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/digitalitzar/1"), eq(HttpMethod.PUT), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaoRDTO = new DocsEntradaRDTO();
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.actualitzarDocumentEntradaDigitalitzat(docsEntradaoRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * actualitzar Document Tramitacio Digitalitzat
	 * 
	 * @throws RestClientException
	 */
	@Test
	public void actualitzarDocumentTramitacioDigitalitzatTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/tramitacio/digitalitzar/1"), eq(HttpMethod.PUT), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.actualitzarDocumentTramitacioDigitalitzat(docsTramitacioRDTO, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * actualitzar Requeriment
	 * 
	 * @throws RestClientException
	 */
	@Test
	public void actualitzarRequerimentTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/requeriment/1"), eq(HttpMethod.PUT), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.actualitzarRequeriment(guardarRequerimentExpedient, idExpedient);

		assertTrue(response != null);
	}

	/**
	 * actualitzar Requeriment
	 * 
	 * @throws RestClientException
	 */
	@Test
	public void guardarRequerimentPlantillaTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/requeriment/plantilla/1"), eq(HttpMethod.PUT), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(new DocsTramitacioRDTO());

		GuardarRequerimentExpedient guardarRequerimentExpedient = new GuardarRequerimentExpedient();
		BigDecimal idExpedient = ONE;
		DocsTramitacioRDTO response = api.guardarRequerimentPlantilla(guardarRequerimentExpedient, idExpedient);

		assertTrue(true);
	}

	/**
	 * desassocia el registre de la documentació de l&#39;expedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void desassociarRegistreDocumentacioTest() {

		when(apiClient.invokeAPI(eq("/documentacio/desassociarRegistreDocumentacio"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);

		DocumentActualizarRegistre documentActualizarRegistre = new DocumentActualizarRegistre();
		api.desassociarRegistreDocumentacio(documentActualizarRegistre);

		assertTrue(true);
	}

	/**
	 * ComprovarDocumentsSignatsExpedient
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void comprovarDocumentsSignatsExpedientTest() {
		when(apiClient.invokeAPI(eq("/comprovarDocumentsSignatsExpedient/1"), eq(HttpMethod.GET), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(Boolean.class);

		BigDecimal idDocumentacio = ONE;
		Boolean response = api.comprovarDocumentsSignatsExpedient(idDocumentacio);

		assertTrue(true);
	}

	/**
	 * Obre els requeriments de l&#39;expedient
	 *
	 * 
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 */
	@Test
	public void obrirRequerimentsExpedientTest() throws RestClientException {
		when(apiClient.invokeAPI(eq("/documentacio/obrirRequeriments/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		BigDecimal idDocumentacio = ONE;
		api.obrirRequerimentsExpedient(idDocumentacio);
		assertTrue(true);
	}

	/**
	 * actualitza l&#39;aneu del gestor documental
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void guardarDocumentEntradaGestorDocumentalTest() {

		when(apiClient.invokeAPI(eq("/documentacio/entrada/fitxer/1/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new DocsEntradaRDTO());

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		String idGestorDocumental = "1";
		BigDecimal idExpedient = ONE;
		DocsEntradaRDTO response = api.guardarDocumentEntradaGestorDocumental(docsEntradaRDTO, idExpedient, idGestorDocumental);

		assertTrue(response != null);

	}

	/**
	 * Updates all selected DocsEntrada with the EstatRevisio specified
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void revisarDocumentacioEntradaTest() {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/revisar"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		DocumentRevisio documentRevisioRDTO = new DocumentRevisio();
		api.revisarDocumentacioEntrada(documentRevisioRDTO);
		assertTrue(true);
	}

	/**
	 * Updates all selected DocsEntrada with the EstatRevisio specified
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void revisarDocumentacioEntradaMassiuTest() {
		when(apiClient.invokeAPI(eq("/documentacio/entrada/revisarMassiu"), eq(HttpMethod.POST), any(MultiValueMap.class),
		        any(Object.class), any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class),
		        any(String[].class), any(ParameterizedTypeReference.class))).thenReturn(null);
		DocumentRevisio documentRevisioRDTO = new DocumentRevisio();
		api.revisarDocumentacioEntradaMassiu(documentRevisioRDTO);
		assertTrue(true);
	}

	/**
	 * Obtenir estat de digitalització del document
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void estatDigitalitzacioTest() {

		when(apiClient.invokeAPI(eq("/documentacio/1/estatDigitalitzacio"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(new EstatDigitalitzacioDocumentRDTO());

		Long idDocumentacio = 1L;
		EstatDigitalitzacioDocumentRDTO response = api.estatDigitalitzacio(idDocumentacio);
		assertTrue(response != null);
	}

	/**
	 * Obté la manera d&#39;emmagatzematge en ús
	 *
	 * 
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void storageModeTest() {
		when(apiClient.invokeAPI(eq("/documentacio/storageMode"), eq(HttpMethod.GET), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(StringUtils.EMPTY);
		String response = api.storageMode();
		assertTrue(response != null);
	}

	/**
	 * saves the xml sollicitud.
	 *
	 * @throws RestClientException
	 *             if the Api call fails
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void guardarXmlSollicitudTest() throws RestClientException, IOException {
		when(apiClient.parameterToMultiValueMap(isNull(CollectionFormat.class), any(String.class), any(Object.class)))
		        .thenReturn(new LinkedMultiValueMap<String, String>());
		when(apiClient.invokeAPI(eq("/documentacio/xml/sollicitud/1"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		String idDocumentum = ONE.toString();
		File file = testFolder.newFolder("test");
		api.guardarXmlSollicitud(idDocumentum, file);

		assertTrue(true);
	}

}
