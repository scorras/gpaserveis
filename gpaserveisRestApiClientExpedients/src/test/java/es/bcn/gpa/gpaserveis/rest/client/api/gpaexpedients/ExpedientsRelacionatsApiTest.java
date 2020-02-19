/*
 * API gpaexpedients
 * API gpaexpedients
 *
 * OpenAPI spec version: 1.17.0
 * Contact: sergio.corras@iecisa.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package es.bcn.gpa.gpaserveis.rest.client.api.gpaexpedients;

import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ExpedientsRelacionatsApi
 */
@Ignore
public class ExpedientsRelacionatsApiTest {

    private final ExpedientsRelacionatsApi api = new ExpedientsRelacionatsApi();

    
    /**
     * Returns all the expedients relacionats
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void obtenirExpedientsRelacionatsTest() {
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
        PageDataOfExpedientsRDTO response = api.obtenirExpedientsRelacionats(id, absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements, totalPages);

        // TODO: test validations
    }
    
}
