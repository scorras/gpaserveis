/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.3.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import static java.math.BigDecimal.ONE;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.GestionarAvisosPerAccio;

/**
 * API tests for AvisosApi.
 */
@SuppressWarnings("unchecked")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AvisosApiTest extends ParentTest {

	/** The api. */
	@InjectMocks
	private AvisosApi api = new AvisosApi();

	/**
	 * Gestionar avisos per accio test.
	 */
	@Test
	public void gestionarAvisosPerAccioTest() {
		when(apiClient.invokeAPI(eq("/avisos/1/gestionarAvisosPerAccio"), eq(HttpMethod.POST), any(MultiValueMap.class), any(Object.class),
		        any(HttpHeaders.class), any(MultiValueMap.class), any(List.class), any(MediaType.class), any(String[].class),
		        any(ParameterizedTypeReference.class))).thenReturn(null);

		Integer idExpedient = 1;
		GestionarAvisosPerAccio gestionarAvisosPerAccioRDTO = new GestionarAvisosPerAccio();
		gestionarAvisosPerAccioRDTO.setIdAccioEstat(ONE);
		gestionarAvisosPerAccioRDTO.setIdDocTramitacio(ONE);
		gestionarAvisosPerAccioRDTO.setIdUsuariSignatura(ONE);

		api.gestionarAvisosPerAccio(idExpedient, gestionarAvisosPerAccioRDTO);

		assertTrue(true);
	}

}
