/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.11.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.EstatsRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EstatsDocumentApi
 */
@Ignore
public class EstatsDocumentApiTest {

    private final EstatsDocumentApi api = new EstatsDocumentApi();

    
    /**
     * Returns all the estatsDocument
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEstatsDocumentUsingGETTest() {
        List<EstatsRDTO> response = api.getEstatsDocumentUsingGET();

        // TODO: test validations
    }
    
}
