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
import java.math.BigDecimal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.BloquejosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientOpenTextRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfComentarisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
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
     * Locks the provided procediment for editing
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void bloquejarExpedientUsingPOSTTest() throws ApiException {
        BloquejosRDTO bloquejosRDTO = null;
        BigDecimal id = null;
        api.bloquejarExpedientUsingPOST(bloquejosRDTO, id);

        // TODO: test validations
    }
    
    /**
     * Canvia l&#39;estat d&#39;un expedient en funció de l&#39;acció executada
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void canviarEstatAccioExpedientTest() throws ApiException {
        BigDecimal idAccio = null;
        BigDecimal idExpedient = null;
        ExpedientCanviEstatAccio expedientCanviEstatAccioRDTO = null;
        RespostaCanviarEstatAccioExpedient response = api.canviarEstatAccioExpedient(idAccio, idExpedient, expedientCanviEstatAccioRDTO);

        // TODO: test validations
    }
    
    /**
     * Returns all the historic entries for the procedure that meet the search criteria
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void cercaHistoricsExpedientTest() throws ApiException {
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
        List<BigDecimal> tipus = null;
        Long totalElements = null;
        Integer totalPages = null;
        PageDataOfHistoricsRDTO response = api.cercaHistoricsExpedient(id, absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, tipus, totalElements, totalPages);

        // TODO: test validations
    }
    
    /**
     * Unlocks the provided procediment
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void desbloquejarExpedientUsingPOSTTest() throws ApiException {
        BigDecimal id = null;
        api.desbloquejarExpedientUsingPOST(id);

        // TODO: test validations
    }
    
    /**
     * ExpedientBloquejatPerUnAltreUsuari
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void expedientBloquejatPerUnAltreUsuariUsingGETTest() throws ApiException {
        BigDecimal id = null;
        BloquejosRDTO response = api.expedientBloquejatPerUnAltreUsuariUsingGET(id);

        // TODO: test validations
    }
    
    /**
     * Return expedient data for OpenText
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getExpedientDataOpenTextUsingGETTest() throws ApiException {
        BigDecimal id = null;
        ExpedientOpenTextRDTO response = api.getExpedientDataOpenTextUsingGET(id);

        // TODO: test validations
    }
    
    /**
     * Returns all the historic entries for the id list
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getHistoricsListUsingGETTest() throws ApiException {
        String ids = null;
        List<HistoricsRDTO> response = api.getHistoricsListUsingGET(ids);

        // TODO: test validations
    }
    
    /**
     * Returns the requested registre
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRegistresAssentamentListUsingGETTest() throws ApiException {
        String ids = null;
        List<RegistreAssentamentRDTO> response = api.getRegistresAssentamentListUsingGET(ids);

        // TODO: test validations
    }
    
    /**
     * Inserts new historic
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void registrarHistoricDocumentacioUsingPOSTTest() throws ApiException {
        HistoricsRDTO historicsRDTO = null;
        BigDecimal response = api.registrarHistoricDocumentacioUsingPOST(historicsRDTO);

        // TODO: test validations
    }
    
    /**
     * Returns all the comentaris entries for the procedure that meet the search criteria
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchComentarisUsingGETTest() throws ApiException {
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
        PageDataOfComentarisRDTO response = api.searchComentarisUsingGET(id, absoluteRowNumberOfFirstRowInCurrentPage, absoluteRowNumberOfLastRowInCurrentPage, currentPageHasNextPage, currentPageHasPreviousPage, currentPageIsFirstPage, currentPageIsLastPage, currentPageNumber, dir, nextPageNumber, pageSize, previousPageNumber, sort, totalElements, totalPages);

        // TODO: test validations
    }
    
}
