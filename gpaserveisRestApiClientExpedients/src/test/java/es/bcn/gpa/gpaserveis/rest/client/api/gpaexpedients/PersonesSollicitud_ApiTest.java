/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 2.11.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PersonesSollicitud_Api
 */
@Ignore
public class PersonesSollicitud_ApiTest {

    private final PersonesSollicitud_Api api = new PersonesSollicitud_Api();

    
    /**
     * Returns the requested person
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void consultarDadesAllPersonaSollicitudByPersonaIdextTest() {
        String listPersonaIdext = null;
        List<PersonesSollicitudRDTO> response = api.consultarDadesAllPersonaSollicitudByPersonaIdext(listPersonaIdext);

        // TODO: test validations
    }
    
    /**
     * Returns the requested person
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void consultarDadesPersonaSollicitudTest() {
        Integer idPersonesSollicitud = null;
        PersonesSollicitudRDTO response = api.consultarDadesPersonaSollicitud(idPersonesSollicitud);

        // TODO: test validations
    }
    
}
