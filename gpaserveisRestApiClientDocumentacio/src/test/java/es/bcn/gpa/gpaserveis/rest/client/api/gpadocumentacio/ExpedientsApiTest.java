/*
 * API gpadocumentacio
 * API gpadocumentacio
 *
 * OpenAPI spec version: 1.17.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ExpedientGestorDocumentalRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ExpedientsApi
 */
@Ignore
public class ExpedientsApiTest {

    private final ExpedientsApi api = new ExpedientsApi();

    
    /**
     * donar d&#39;alta un expedient en Gestor Documental
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void altaExpedientGestorDocumentalUsingPOSTTest() {
        ExpedientGestorDocumentalRDTO expedientGestorDocumentalRDTO = null;
        String response = api.altaExpedientGestorDocumentalUsingPOST(expedientGestorDocumentalRDTO);

        // TODO: test validations
    }
    
}