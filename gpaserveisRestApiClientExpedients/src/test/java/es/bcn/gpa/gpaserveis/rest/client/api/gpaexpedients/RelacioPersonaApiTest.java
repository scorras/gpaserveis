/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.11.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.invoker.gpaexpedients.ApiException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RelacioPersonaRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RelacioPersonaApi
 */
@Ignore
public class RelacioPersonaApiTest {

    private final RelacioPersonaApi api = new RelacioPersonaApi();

    
    /**
     * Returns all the relacioPersona
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRelacioPersonaUsingGETTest() throws ApiException {
        Integer esInteressada = null;
        List<RelacioPersonaRDTO> response = api.getRelacioPersonaUsingGET(esInteressada);

        // TODO: test validations
    }
    
}
