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

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaDocumentacioVinculadaCompletaRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DocumentacioVinculadaCompletaApi
 */
@Ignore
public class DocumentacioVinculadaCompletaApiTest {

    private final DocumentacioVinculadaCompletaApi api = new DocumentacioVinculadaCompletaApi();

    
    /**
     * Returns DocumentacioVinculadaCompleta
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void obtenirDocumentacioVinculadaCompletaUsingGETTest() {
        BigDecimal idConfiguracioDocumentacio = null;
        RespostaDocumentacioVinculadaCompletaRDTO response = api.obtenirDocumentacioVinculadaCompletaUsingGET(idConfiguracioDocumentacio);

        // TODO: test validations
    }
    
}