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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisCreacioAccio;
import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfAvisosRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AvisosApi
 */
@Ignore
public class AvisosApiTest {

    private final AvisosApi api = new AvisosApi();

    
    /**
     * Crea un nou avís per a l&#39;expedient en funció de l&#39;acció executada
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void crearAvisAccioTest() throws ApiException {
        BigDecimal idAccio = null;
        BigDecimal idExpedient = null;
        AvisCreacioAccio avisCreacioAccioRDTO = null;
        api.crearAvisAccio(idAccio, idExpedient, avisCreacioAccioRDTO);

        // TODO: test validations
    }
    
    /**
     * Returns all avisos 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void obtenirAvisosPorIdExpedientUsingGETTest() throws ApiException {
        BigDecimal id = null;
        Integer absoluteRowNumberOfFirstRowInCurrentPage = null;
        Integer absoluteRowNumberOfLastRowInCurrentPage = null;
        Boolean currentPageHasNextPage = null;
        Boolean currentPageHasPreviousPage = null;
        Boolean currentPageIsFirstPage = null;
        Boolean currentPageIsLastPage = null;
        Integer currentPageNumber = null;
        String dir = null;
        Integer nextPageNumber = null;
        Integer pageSize = null;
        Integer previousPageNumber = null;
        String sort = null;
        Long totalElements = null;
        Integer totalPages = null;
        PageDataOfAvisosRDTO response = api.obtenirAvisosPorIdExpedientUsingGET(id, absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements, totalPages);

        // TODO: test validations
    }
    
    /**
     * Returns criticitat avis 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void obtenirCriticitatAvisPorIdExpedientUsingGETTest() throws ApiException {
        BigDecimal id = null;
        BigDecimal response = api.obtenirCriticitatAvisPorIdExpedientUsingGET(id);

        // TODO: test validations
    }
    
}
