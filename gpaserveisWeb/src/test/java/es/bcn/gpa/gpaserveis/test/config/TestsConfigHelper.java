package es.bcn.gpa.gpaserveis.test.config;

import static org.joda.time.DateTime.now;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang.math.NumberUtils;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Estats;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.EstatsProcediment;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Identificacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RequerimentsOperatius;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;

/**
 * The Class TestsConfigHelper.
 */
public class TestsConfigHelper {

	/**
	 * Cerca procediments response.
	 *
	 * @return the page data of procediments RDTO
	 */
	public static PageDataOfProcedimentsRDTO cercaProcedimentsResponse() {
		PageDataOfProcedimentsRDTO pageDataOfProcedimentsRDTO = new PageDataOfProcedimentsRDTO();

		// Data
		ArrayList<ProcedimentsRDTO> procedimentsRDTOList = new ArrayList<ProcedimentsRDTO>();
		ProcedimentsRDTO procedimentsRDTO = new ProcedimentsRDTO();
		procedimentsRDTO.setCodi("PROC-01");
		procedimentsRDTO.setConfiguracioDocumentacio(BigDecimal.ONE);
		procedimentsRDTO.setDarreraModificacio(now());
		procedimentsRDTO.setDescripcioEstat("En elaboració");
		procedimentsRDTO.setEstatProcediment(BigDecimal.ONE);
		EstatsProcediment estatsProcediment = new EstatsProcediment();
		estatsProcediment.setEstat(BigDecimal.ONE);
		Estats estats = new Estats();
		estats.setId(BigDecimal.ONE);
		estats.setDescripcio("En elaboració");
		estatsProcediment.setEstats(estats);
		estatsProcediment.setHistoric(BigDecimal.ONE);
		estatsProcediment.setId(BigDecimal.ONE);
		procedimentsRDTO.setEstatsProcediment(estatsProcediment);
		procedimentsRDTO.setId(BigDecimal.ONE);
		procedimentsRDTO.setIdentificacio(BigDecimal.ONE);
		Identificacions identificacions = new Identificacions();
		identificacions.setId(BigDecimal.ONE);
		procedimentsRDTO.setIdentificacions(identificacions);
		procedimentsRDTO.setNom("Procediment 1");
		procedimentsRDTO.setNumerador(BigDecimal.ONE);
		RequerimentsOperatius requerimentsOperatius = new RequerimentsOperatius();
		requerimentsOperatius.setAplicacioNegoci("quiosc");
		requerimentsOperatius.setId(BigDecimal.ONE);
		procedimentsRDTO.setReqOperatius(requerimentsOperatius);
		procedimentsRDTO.setRequerimentsOperatius(BigDecimal.ONE);
		procedimentsRDTO.setSerieDocumental("A");
		procedimentsRDTO.setTramitador("quiosc");
		ArrayList<ProcedimentsUgos> procedimentsUgosList = new ArrayList<ProcedimentsUgos>();
		ProcedimentsUgos procedimentsUgos1 = new ProcedimentsUgos();
		procedimentsUgos1.setProcediment(BigDecimal.ONE);
		procedimentsUgos1.setUgoIdext(new BigDecimal(1));
		procedimentsUgosList.add(procedimentsUgos1);
		ProcedimentsUgos procedimentsUgos2 = new ProcedimentsUgos();
		procedimentsUgos2.setProcediment(BigDecimal.ONE);
		procedimentsUgos2.setUgoIdext(new BigDecimal(2));
		procedimentsUgosList.add(procedimentsUgos2);
		ProcedimentsUgos procedimentsUgos3 = new ProcedimentsUgos();
		procedimentsUgos3.setProcediment(BigDecimal.ONE);
		procedimentsUgos3.setUgoIdext(new BigDecimal(3));
		procedimentsUgosList.add(procedimentsUgos3);
		ProcedimentsUgos procedimentsUgos4 = new ProcedimentsUgos();
		procedimentsUgos4.setProcediment(BigDecimal.ONE);
		procedimentsUgos4.setUgoIdext(new BigDecimal(4));
		procedimentsUgosList.add(procedimentsUgos4);
		procedimentsRDTO.setUgosList(procedimentsUgosList);
		procedimentsRDTO.setUgosNoms("UG1, UG2, UG3, UG4");
		procedimentsRDTO.setUgrIdext(BigDecimal.ONE);
		procedimentsRDTO.setUgrNom("UG1");
		procedimentsRDTO.setUltimaModificacio(BigDecimal.ONE);
		procedimentsRDTO.setVersio("1");
		procedimentsRDTOList.add(procedimentsRDTO);
		pageDataOfProcedimentsRDTO.setData(procedimentsRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(NumberUtils.INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(NumberUtils.INTEGER_ONE);
		paginationAttributes.setCurrentPageHasNextPage(Boolean.FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(Boolean.FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(Boolean.TRUE);
		paginationAttributes.setCurrentPageIsLastPage(Boolean.TRUE);
		paginationAttributes.setCurrentPageNumber(NumberUtils.INTEGER_ONE);
		paginationAttributes.setNextPageNumber(NumberUtils.INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(20));
		paginationAttributes.setPreviousPageNumber(NumberUtils.INTEGER_ZERO);
		paginationAttributes.setTotalElements(NumberUtils.LONG_ONE);
		paginationAttributes.setTotalPages(NumberUtils.INTEGER_ONE);
		pageDataOfProcedimentsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.SortInfo();
		sortInfo.setSort("codi");
		sortInfo.setDir("asc");
		pageDataOfProcedimentsRDTO.setSortInfo(sortInfo);

		return pageDataOfProcedimentsRDTO;
	}

	/**
	 * Cerca unitats gestores response.
	 *
	 * @return the page data of unitats gestores RDTO
	 */
	public static PageDataOfUnitatsGestoresRDTO cercaUnitatsGestoresResponse() {
		PageDataOfUnitatsGestoresRDTO pageDataOfUnitatsGestoresRDTO = new PageDataOfUnitatsGestoresRDTO();

		// Data
		ArrayList<UnitatsGestoresRDTO> unitatsGestoresRDTOList = new ArrayList<UnitatsGestoresRDTO>();
		UnitatsGestoresRDTO unitatsGestoresRDTO1 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO1.setDataCreacio(now());
		unitatsGestoresRDTO1.setDataModificacio(now());
		unitatsGestoresRDTO1.setDescripcio("Descripció UG1");
		unitatsGestoresRDTO1.setId(new BigDecimal(1));
		unitatsGestoresRDTO1.setNom("UG1");
		unitatsGestoresRDTO1.setVigent(NumberUtils.INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO1);
		UnitatsGestoresRDTO unitatsGestoresRDTO2 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO2.setDataCreacio(now());
		unitatsGestoresRDTO2.setDataModificacio(now());
		unitatsGestoresRDTO2.setDescripcio("Descripció UG2");
		unitatsGestoresRDTO2.setId(new BigDecimal(2));
		unitatsGestoresRDTO2.setNom("UG2");
		unitatsGestoresRDTO2.setVigent(NumberUtils.INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO2);
		UnitatsGestoresRDTO unitatsGestoresRDTO3 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO3.setDataCreacio(now());
		unitatsGestoresRDTO3.setDataModificacio(now());
		unitatsGestoresRDTO3.setDescripcio("Descripció UG3");
		unitatsGestoresRDTO3.setId(new BigDecimal(3));
		unitatsGestoresRDTO3.setNom("UG3");
		unitatsGestoresRDTO3.setVigent(NumberUtils.INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO3);
		UnitatsGestoresRDTO unitatsGestoresRDTO4 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO4.setDataCreacio(now());
		unitatsGestoresRDTO4.setDataModificacio(now());
		unitatsGestoresRDTO4.setDescripcio("Descripció UG4");
		unitatsGestoresRDTO4.setId(new BigDecimal(4));
		unitatsGestoresRDTO4.setNom("UG4");
		unitatsGestoresRDTO4.setVigent(NumberUtils.INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO4);
		pageDataOfUnitatsGestoresRDTO.setData(unitatsGestoresRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(NumberUtils.INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(new Integer(4));
		paginationAttributes.setCurrentPageHasNextPage(Boolean.FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(Boolean.FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(Boolean.TRUE);
		paginationAttributes.setCurrentPageIsLastPage(Boolean.TRUE);
		paginationAttributes.setCurrentPageNumber(NumberUtils.INTEGER_ONE);
		paginationAttributes.setNextPageNumber(NumberUtils.INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(4));
		paginationAttributes.setPreviousPageNumber(NumberUtils.INTEGER_ZERO);
		paginationAttributes.setTotalElements(new Long(4));
		paginationAttributes.setTotalPages(NumberUtils.INTEGER_ONE);
		pageDataOfUnitatsGestoresRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.SortInfo();
		sortInfo.setSort("dataModificacio");
		sortInfo.setDir("DESC");
		pageDataOfUnitatsGestoresRDTO.setSortInfo(sortInfo);

		return pageDataOfUnitatsGestoresRDTO;
	}

	/**
	 * Cerca expedients response.
	 *
	 * @return the page data of expedients RDTO
	 */
	public static PageDataOfExpedientsRDTO cercaExpedientsResponse() {
		PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = new PageDataOfExpedientsRDTO();

		// Data
		ArrayList<ExpedientsRDTO> expedientsRDTOList = new ArrayList<ExpedientsRDTO>();
		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();
		expedientsRDTO.setId(BigDecimal.ONE);
		expedientsRDTO.setCodi("PROC-01/2019/000001");
		expedientsRDTO.setSollicitud(BigDecimal.ONE);
		expedientsRDTO.setProcedimentIdext(BigDecimal.ONE);
		expedientsRDTO.setDocumentacioIdext(BigDecimal.ONE);
		expedientsRDTO.setEstatActual(BigDecimal.ONE);
		expedientsRDTO.setUltimaModificacio(BigDecimal.ONE);
		expedientsRDTO.setDarreraModificacio(now());
		expedientsRDTO.setDataPresentacio(now());
		expedientsRDTO.setNomProcediment("PROC-01");
		expedientsRDTO.setSollicitant("La Caixa");
		expedientsRDTO.setAccioEstatIdext(BigDecimal.ONE);
		expedientsRDTO.setUnitatGestoraIdext(BigDecimal.ONE);
		expedientsRDTO.setDescUnitatGestora("Descripció UG1");
		expedientsRDTO.setTramitador("APLICACIO_DE_NEGOCI");
		expedientsRDTO.setDescEstat("En tramitació");
		expedientsRDTO.setAplicacioNegoci("quiosc");
		expedientsRDTO.setEditable(Boolean.TRUE);
		expedientsRDTO.setSeleccionable(Boolean.TRUE);
		expedientsRDTO.setConfiguracioDocumentacioProc(BigDecimal.ONE);
		expedientsRDTOList.add(expedientsRDTO);
		pageDataOfExpedientsRDTO.setData(expedientsRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(NumberUtils.INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(NumberUtils.INTEGER_ONE);
		paginationAttributes.setCurrentPageHasNextPage(Boolean.FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(Boolean.FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(Boolean.TRUE);
		paginationAttributes.setCurrentPageIsLastPage(Boolean.TRUE);
		paginationAttributes.setCurrentPageNumber(NumberUtils.INTEGER_ONE);
		paginationAttributes.setNextPageNumber(NumberUtils.INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(20));
		paginationAttributes.setPreviousPageNumber(NumberUtils.INTEGER_ZERO);
		paginationAttributes.setTotalElements(NumberUtils.LONG_ONE);
		paginationAttributes.setTotalPages(NumberUtils.INTEGER_ONE);
		pageDataOfExpedientsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo();
		sortInfo.setSort("darreraModificacio");
		sortInfo.setDir("desc");
		pageDataOfExpedientsRDTO.setSortInfo(sortInfo);

		return pageDataOfExpedientsRDTO;
	}
}
