package es.bcn.gpa.gpaserveis.test.config;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.apache.commons.lang.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;
import static org.apache.commons.lang.math.NumberUtils.LONG_ONE;
import static org.joda.time.DateTime.now;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AtributsDocs;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntrada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfHistoricsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Paisos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesDadescontacte;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentament;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaRegistrarSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Sollicituds;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusDocumentIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesoperEstatsExp;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Estats;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.EstatsProcediment;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Identificacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsIniciacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RequerimentsOperatius;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

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
		procedimentsRDTO.setConfiguracioDocumentacio(ONE);
		procedimentsRDTO.setDarreraModificacio(now());
		procedimentsRDTO.setDescripcioEstat("En elaboració");
		procedimentsRDTO.setEstatProcediment(ONE);
		EstatsProcediment estatsProcediment = new EstatsProcediment();
		estatsProcediment.setEstat(ONE);
		Estats estats = new Estats();
		estats.setId(ONE);
		estats.setDescripcio("En elaboració");
		estatsProcediment.setEstats(estats);
		estatsProcediment.setHistoric(ONE);
		estatsProcediment.setId(ONE);
		procedimentsRDTO.setEstatsProcediment(estatsProcediment);
		procedimentsRDTO.setId(ONE);
		procedimentsRDTO.setIdentificacio(ONE);
		Identificacions identificacions = new Identificacions();
		identificacions.setId(ONE);
		procedimentsRDTO.setIdentificacions(identificacions);
		procedimentsRDTO.setNom("Procediment 1");
		procedimentsRDTO.setNumerador(ONE);
		RequerimentsOperatius requerimentsOperatius = new RequerimentsOperatius();
		requerimentsOperatius.setAplicacioNegoci("quiosc");
		requerimentsOperatius.setId(ONE);
		procedimentsRDTO.setReqOperatius(requerimentsOperatius);
		procedimentsRDTO.setRequerimentsOperatius(ONE);
		procedimentsRDTO.setSerieDocumental("A");
		procedimentsRDTO.setTramitador("quiosc");
		ArrayList<ProcedimentsUgos> procedimentsUgosList = new ArrayList<ProcedimentsUgos>();
		ProcedimentsUgos procedimentsUgos1 = new ProcedimentsUgos();
		procedimentsUgos1.setProcediment(ONE);
		procedimentsUgos1.setUgoIdext(new BigDecimal(1));
		procedimentsUgosList.add(procedimentsUgos1);
		ProcedimentsUgos procedimentsUgos2 = new ProcedimentsUgos();
		procedimentsUgos2.setProcediment(ONE);
		procedimentsUgos2.setUgoIdext(new BigDecimal(2));
		procedimentsUgosList.add(procedimentsUgos2);
		ProcedimentsUgos procedimentsUgos3 = new ProcedimentsUgos();
		procedimentsUgos3.setProcediment(ONE);
		procedimentsUgos3.setUgoIdext(new BigDecimal(3));
		procedimentsUgosList.add(procedimentsUgos3);
		ProcedimentsUgos procedimentsUgos4 = new ProcedimentsUgos();
		procedimentsUgos4.setProcediment(ONE);
		procedimentsUgos4.setUgoIdext(new BigDecimal(4));
		procedimentsUgosList.add(procedimentsUgos4);
		procedimentsRDTO.setUgosList(procedimentsUgosList);
		procedimentsRDTO.setUgosNoms("UG1, UG2, UG3, UG4");
		procedimentsRDTO.setUgrIdext(ONE);
		procedimentsRDTO.setUgrNom("UG1");
		procedimentsRDTO.setUltimaModificacio(ONE);
		procedimentsRDTO.setVersio("1");
		procedimentsRDTOList.add(procedimentsRDTO);
		pageDataOfProcedimentsRDTO.setData(procedimentsRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(20));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(LONG_ONE);
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfProcedimentsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.SortInfo();
		sortInfo.setSort("codi");
		sortInfo.setDir("asc");
		pageDataOfProcedimentsRDTO.setSortInfo(sortInfo);

		return pageDataOfProcedimentsRDTO;
	}

	/**
	 * Consultar dades procediment response.
	 *
	 * @return the procediments RDTO
	 */
	public static ProcedimentsRDTO consultarDadesProcedimentResponse() {
		ProcedimentsRDTO procedimentsRDTO = new ProcedimentsRDTO();

		procedimentsRDTO.setId(ONE);
		procedimentsRDTO.setCodi("PROC-01");
		procedimentsRDTO.setVersio("1");
		procedimentsRDTO.setNom("Procediment 1");
		procedimentsRDTO.setDescripcio("Descripció Procediment 1");
		procedimentsRDTO.setUgrIdext(ONE);
		ArrayList<ProcedimentsUgos> procedimentsUgosList = new ArrayList<ProcedimentsUgos>();
		ProcedimentsUgos procedimentsUgos1 = new ProcedimentsUgos();
		procedimentsUgos1.setProcediment(ONE);
		procedimentsUgos1.setUgoIdext(new BigDecimal(1));
		procedimentsUgosList.add(procedimentsUgos1);
		ProcedimentsUgos procedimentsUgos2 = new ProcedimentsUgos();
		procedimentsUgos2.setProcediment(ONE);
		procedimentsUgos2.setUgoIdext(new BigDecimal(2));
		procedimentsUgosList.add(procedimentsUgos2);
		ProcedimentsUgos procedimentsUgos3 = new ProcedimentsUgos();
		procedimentsUgos3.setProcediment(ONE);
		procedimentsUgos3.setUgoIdext(new BigDecimal(3));
		procedimentsUgosList.add(procedimentsUgos3);
		procedimentsRDTO.setUgosList(procedimentsUgosList);
		Identificacions identificacions = new Identificacions();
		identificacions.setOrganResolutori("Òrgan resolutori Procediment 1");
		identificacions.setInformacioCiutada("Per al ciutadà Procediment 1");
		identificacions.setNivellAutenticacio(INTEGER_ONE);
		identificacions.setTerminiMaxim(INTEGER_ONE);
		identificacions.setEspecTerminiMaxim(new Integer(7));
		identificacions.setPeriodicitatTermini(INTEGER_ONE);
		identificacions.setVigenciaInici(now());
		identificacions.setVigenciaFi(now());
		procedimentsRDTO.setIdentificacions(identificacions);
		ArrayList<ProcedimentsIniciacions> procedimentsIniciacionsList = new ArrayList<ProcedimentsIniciacions>();
		ProcedimentsIniciacions procedimentsIniciacions1 = new ProcedimentsIniciacions();
		procedimentsIniciacions1.setProcediment(ONE);
		procedimentsIniciacions1.setIniciacio(Integer.valueOf(1));
		procedimentsIniciacionsList.add(procedimentsIniciacions1);
		ProcedimentsIniciacions procedimentsIniciacions2 = new ProcedimentsIniciacions();
		procedimentsIniciacions2.setProcediment(ONE);
		procedimentsIniciacions2.setIniciacio(Integer.valueOf(2));
		procedimentsIniciacionsList.add(procedimentsIniciacions2);
		ProcedimentsIniciacions procedimentsIniciacions3 = new ProcedimentsIniciacions();
		procedimentsIniciacions3.setProcediment(ONE);
		procedimentsIniciacions3.setIniciacio(Integer.valueOf(3));
		procedimentsIniciacionsList.add(procedimentsIniciacions3);
		ProcedimentsIniciacions procedimentsIniciacions4 = new ProcedimentsIniciacions();
		procedimentsIniciacions4.setProcediment(ONE);
		procedimentsIniciacions4.setIniciacio(Integer.valueOf(4));
		procedimentsIniciacionsList.add(procedimentsIniciacions4);
		procedimentsRDTO.setIniciacionsList(procedimentsIniciacionsList);
		EstatsProcediment estatsProcediment = new EstatsProcediment();
		Estats estats = new Estats();
		estats.setId(new BigDecimal(3));
		estatsProcediment.setEstats(estats);
		estatsProcediment.setEstat(new BigDecimal(3));
		procedimentsRDTO.setEstatsProcediment(estatsProcediment);

		return procedimentsRDTO;
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
		unitatsGestoresRDTO1.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO1);
		UnitatsGestoresRDTO unitatsGestoresRDTO2 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO2.setDataCreacio(now());
		unitatsGestoresRDTO2.setDataModificacio(now());
		unitatsGestoresRDTO2.setDescripcio("Descripció UG2");
		unitatsGestoresRDTO2.setId(new BigDecimal(2));
		unitatsGestoresRDTO2.setNom("UG2");
		unitatsGestoresRDTO2.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO2);
		UnitatsGestoresRDTO unitatsGestoresRDTO3 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO3.setDataCreacio(now());
		unitatsGestoresRDTO3.setDataModificacio(now());
		unitatsGestoresRDTO3.setDescripcio("Descripció UG3");
		unitatsGestoresRDTO3.setId(new BigDecimal(3));
		unitatsGestoresRDTO3.setNom("UG3");
		unitatsGestoresRDTO3.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO3);
		UnitatsGestoresRDTO unitatsGestoresRDTO4 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO4.setDataCreacio(now());
		unitatsGestoresRDTO4.setDataModificacio(now());
		unitatsGestoresRDTO4.setDescripcio("Descripció UG4");
		unitatsGestoresRDTO4.setId(new BigDecimal(4));
		unitatsGestoresRDTO4.setNom("UG4");
		unitatsGestoresRDTO4.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO4);
		pageDataOfUnitatsGestoresRDTO.setData(unitatsGestoresRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(new Integer(4));
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(4));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(new Long(4));
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfUnitatsGestoresRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.SortInfo();
		sortInfo.setSort("dataModificacio");
		sortInfo.setDir("DESC");
		pageDataOfUnitatsGestoresRDTO.setSortInfo(sortInfo);

		return pageDataOfUnitatsGestoresRDTO;
	}

	/**
	 * Consultar dades unitat gestora response.
	 *
	 * @return the unitats gestores RDTO
	 */
	public static UnitatsGestoresRDTO consultarDadesUnitatGestoraResponse() {
		UnitatsGestoresRDTO unitatsGestoresRDTO = new UnitatsGestoresRDTO();

		unitatsGestoresRDTO.setId(ONE);
		unitatsGestoresRDTO.setNom("UG1");
		unitatsGestoresRDTO.setDescripcio("Descripció UG1");

		return unitatsGestoresRDTO;
	}

	/**
	 * Cerca tramits procediment response.
	 *
	 * @return the page data of tramits RDTO
	 */
	public static PageDataOfTramitsRDTO cercaTramitsProcedimentResponse() {
		PageDataOfTramitsRDTO pageDataOfTramitsRDTO = new PageDataOfTramitsRDTO();

		// Data
		ArrayList<TramitsRDTO> tramitsRDTOList = new ArrayList<TramitsRDTO>();
		TramitsRDTO tramitsRDTO1 = new TramitsRDTO();
		tramitsRDTO1.setId(new BigDecimal(1));
		tramitsRDTO1.setNom("");
		tramitsRDTO1.setDescripcio("");
		tramitsRDTOList.add(tramitsRDTO1);
		TramitsRDTO tramitsRDTO2 = new TramitsRDTO();
		tramitsRDTO2.setId(new BigDecimal(2));
		tramitsRDTO2.setNom("");
		tramitsRDTO2.setDescripcio("");
		tramitsRDTOList.add(tramitsRDTO2);
		TramitsRDTO tramitsRDTO3 = new TramitsRDTO();
		tramitsRDTO3.setId(new BigDecimal(3));
		tramitsRDTO3.setNom("");
		tramitsRDTO3.setDescripcio("");
		tramitsRDTOList.add(tramitsRDTO3);
		pageDataOfTramitsRDTO.setData(tramitsRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(new Integer(3));
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(10));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(new Long(3));
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfTramitsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.SortInfo();
		sortInfo.setSort("nom");
		sortInfo.setDir("DESC");
		pageDataOfTramitsRDTO.setSortInfo(sortInfo);

		return pageDataOfTramitsRDTO;
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
		expedientsRDTO.setId(ONE);
		expedientsRDTO.setCodi("PROC-01/2019/000001");
		expedientsRDTO.setSollicitud(ONE);
		expedientsRDTO.setProcedimentIdext(ONE);
		expedientsRDTO.setDocumentacioIdext(ONE);
		expedientsRDTO.setEstatActual(ONE);
		expedientsRDTO.setUltimaModificacio(ONE);
		expedientsRDTO.setDarreraModificacio(now());
		expedientsRDTO.setDataPresentacio(now());
		expedientsRDTO.setNomProcediment("PROC-01");
		expedientsRDTO.setSollicitant("La Caixa");
		expedientsRDTO.setAccioEstatIdext(ONE);
		expedientsRDTO.setUnitatGestoraIdext(ONE);
		expedientsRDTO.setDescUnitatGestora("Descripció UG1");
		expedientsRDTO.setTramitador("APLICACIO_DE_NEGOCI");
		expedientsRDTO.setDescEstat("En tramitació");
		expedientsRDTO.setIdEstat(ONE);
		expedientsRDTO.setAplicacioNegoci("quiosc");
		expedientsRDTO.setEditable(TRUE);
		expedientsRDTO.setSeleccionable(TRUE);
		expedientsRDTO.setConfiguracioDocumentacioProc(ONE);
		PersonesSollicitud personesSollicitud = new PersonesSollicitud();
		personesSollicitud.setId(ONE);
		Persones persones = new Persones();
		persones.setId(ONE);
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom1");
		persones.setCognom2("Cognom2");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(ONE);
		documentsIdentitat.setNumeroDocument("79688341B");
		TipusDocumentIdentitat tipusDocumentIdentitat = new TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ZERO);
		tipusDocumentIdentitat.setDescripcio("NIF");
		Paisos paisos = new Paisos();
		paisos.setCodiIne("108");
		paisos.setCodiIso("ES");
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		personesDadescontacte.setSexe(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		personesSollicitud.setPersones(persones);
		expedientsRDTO.setSollicitantPrincipal(personesSollicitud);
		expedientsRDTOList.add(expedientsRDTO);
		pageDataOfExpedientsRDTO.setData(expedientsRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(20));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(LONG_ONE);
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfExpedientsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo();
		sortInfo.setSort("darreraModificacio");
		sortInfo.setDir("desc");
		pageDataOfExpedientsRDTO.setSortInfo(sortInfo);

		return pageDataOfExpedientsRDTO;
	}

	/**
	 * Consultar dades expedient response.
	 *
	 * @return the expedients RDTO
	 */
	public static ExpedientsRDTO consultarDadesExpedientResponse() {
		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();

		expedientsRDTO.setId(ONE);
		expedientsRDTO.setCodi("Codi/2019/000001");
		expedientsRDTO.setSollicitud(ONE);
		expedientsRDTO.setProcedimentIdext(ONE);
		expedientsRDTO.setDocumentacioIdext(ONE);
		expedientsRDTO.setEstatActual(ONE);
		expedientsRDTO.setUltimaModificacio(ONE);
		expedientsRDTO.setDarreraModificacio(now());
		expedientsRDTO.setDataPresentacio(now());
		expedientsRDTO.setNomProcediment("Nom PROC01");
		expedientsRDTO.setSollicitant("Sol·licitant");
		expedientsRDTO.setAccioEstatIdext(ONE);
		expedientsRDTO.setUnitatGestoraIdext(ONE);
		expedientsRDTO.setDescUnitatGestora("UG1");
		expedientsRDTO.setTramitador("quiosc");
		expedientsRDTO.setDescEstat("En preparació");
		expedientsRDTO.setIdEstat(ONE);
		expedientsRDTO.setProcedimentCodi("PROC01");

		Sollicituds sollicituds = new Sollicituds();
		sollicituds.setId(ONE);
		sollicituds.setDataSollicitud(now());
		sollicituds.setDataPresentacio(now());
		sollicituds.setRegistre(ONE);

		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(ONE);
		registreAssentament.setCodi("REG01");
		registreAssentament.setUsuari(ONE);
		registreAssentament.setTipus(ONE);
		registreAssentament.setDataRegistre(now());

		Persones persones = new Persones();
		persones.setId(ONE);
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("NomRaoSocial");
		persones.setCognom1("Cognom1");
		persones.setCognom2("Cognom2");

		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(ONE);
		documentsIdentitat.setNumeroDocument("12345678H");

		TipusDocumentIdentitat tipusDocumentIdentitat = new TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ONE);
		tipusDocumentIdentitat.setDescripcio("NIF");

		Paisos paisos = new Paisos();
		paisos.setCodiIne("108");
		paisos.setCodiIso("ES");

		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		personesDadescontacte.setSexe(ONE);

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats estats = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats();
		estats.setId(ONE);
		estats.setDataCreacio(now());
		estats.setAccioEstatIdext(ONE);
		estats.setEstatAnterior(ONE);
		estats.setUsuari(ONE);
		estats.setUnitatGestoraIdext(ONE);

		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		registreAssentament.setPersones(persones);
		sollicituds.setRegistreAssentament(registreAssentament);
		expedientsRDTO.setSollicituds(sollicituds);
		expedientsRDTO.setEstat(estats);

		return expedientsRDTO;
	}

	/**
	 * Cerca historics expedient response.
	 *
	 * @return the page data of historics RDTO
	 */
	public static PageDataOfHistoricsRDTO cercaHistoricsExpedientResponse() {
		PageDataOfHistoricsRDTO pageDataOfHistoricsRDTO = new PageDataOfHistoricsRDTO();

		// Data
		ArrayList<HistoricsRDTO> historicsRDTOList = new ArrayList<HistoricsRDTO>();
		HistoricsRDTO historicsRDTO1 = new HistoricsRDTO();
		historicsRDTO1.setDataCreacio(now());
		historicsRDTO1.setDescripcio("S'ha realitzat un canvi d'estat de l'expedient de \"En preparació\" a \"Sol·licitud en revisió\"");
		historicsRDTOList.add(historicsRDTO1);
		HistoricsRDTO historicsRDTO2 = new HistoricsRDTO();
		historicsRDTO2.setDataCreacio(now());
		historicsRDTO2.setDescripcio("S'ha realitzat un canvi d'estat de l'expedient de \"Sol·licitud en revisió\" a \"Pendent esmenes\"");
		historicsRDTOList.add(historicsRDTO2);
		HistoricsRDTO historicsRDTO3 = new HistoricsRDTO();
		historicsRDTO3.setDataCreacio(now());
		historicsRDTO3.setDescripcio("S'ha realitzat un canvi d'estat de l'expedient de \"Pendent esmenes\" a \"En tramitació\"");
		historicsRDTOList.add(historicsRDTO3);
		pageDataOfHistoricsRDTO.setData(historicsRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(new Integer(3));
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(10));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(new Long(3));
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfHistoricsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo();
		sortInfo.setSort("nom");
		sortInfo.setDir("DESC");
		pageDataOfHistoricsRDTO.setSortInfo(sortInfo);

		return pageDataOfHistoricsRDTO;
	}

	/**
	 * Cerca persones interesades expedient response.
	 *
	 * @return the page data of persones sollicitud RDTO
	 */
	public static PageDataOfPersonesSollicitudRDTO cercaPersonesInteresadesExpedientResponse() {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = new PageDataOfPersonesSollicitudRDTO();

		// Data
		ArrayList<PersonesSollicitudRDTO> personesSollicitudRDTOList = new ArrayList<PersonesSollicitudRDTO>();
		PersonesSollicitudRDTO personesSollicitudRDTO1 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO1.setId(ONE);
		personesSollicitudRDTO1.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_PRINCIPAL);
		personesSollicitudRDTO1.setRelacio(Constants.PERSONES_SOLLICITUD_RELACIO_SOLLICITANT);
		personesSollicitudRDTO1.setPersona(ONE);
		personesSollicitudRDTO1.setSollicitud(ONE);
		personesSollicitudRDTO1.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO1);
		PersonesSollicitudRDTO personesSollicitudRDTO2 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO2.setId(ONE);
		personesSollicitudRDTO2.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL);
		personesSollicitudRDTO2.setRelacio(Constants.PERSONES_SOLLICITUD_RELACIO_SOLLICITANT);
		personesSollicitudRDTO2.setPersona(ONE);
		personesSollicitudRDTO2.setSollicitud(ONE);
		personesSollicitudRDTO2.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO2);
		PersonesSollicitudRDTO personesSollicitudRDTO3 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO3.setId(ONE);
		personesSollicitudRDTO3.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_PRINCIPAL);
		personesSollicitudRDTO3.setRelacio(Constants.PERSONES_SOLLICITUD_RELACIO_REPRESENTANT);
		personesSollicitudRDTO3.setPersona(ONE);
		personesSollicitudRDTO3.setSollicitud(ONE);
		personesSollicitudRDTO3.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO3);
		PersonesSollicitudRDTO personesSollicitudRDTO4 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO4.setId(ONE);
		personesSollicitudRDTO4.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL);
		personesSollicitudRDTO4.setRelacio(Constants.PERSONES_SOLLICITUD_RELACIO_REPRESENTANT);
		personesSollicitudRDTO4.setPersona(ONE);
		personesSollicitudRDTO4.setSollicitud(ONE);
		personesSollicitudRDTO4.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO4);

		pageDataOfPersonesSollicitudRDTO.setData(personesSollicitudRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(new Integer(4));
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(10));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(new Long(4));
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfPersonesSollicitudRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo();
		sortInfo.setSort("nom");
		sortInfo.setDir("DESC");
		pageDataOfPersonesSollicitudRDTO.setSortInfo(sortInfo);

		return pageDataOfPersonesSollicitudRDTO;
	}

	/**
	 * Cerca altres persones implicades expedient response.
	 *
	 * @return the page data of persones sollicitud RDTO
	 */
	public static PageDataOfPersonesSollicitudRDTO cercaAltresPersonesImplicadesExpedientResponse() {
		PageDataOfPersonesSollicitudRDTO pageDataOfPersonesSollicitudRDTO = new PageDataOfPersonesSollicitudRDTO();

		// Data
		ArrayList<PersonesSollicitudRDTO> personesSollicitudRDTOList = new ArrayList<PersonesSollicitudRDTO>();
		PersonesSollicitudRDTO personesSollicitudRDTO1 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO1.setId(ONE);
		personesSollicitudRDTO1.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL);
		personesSollicitudRDTO1.setRelacio(Constants.PERSONES_SOLLICITUD_RELACIO_TESTIMONI);
		personesSollicitudRDTO1.setPersona(ONE);
		personesSollicitudRDTO1.setSollicitud(ONE);
		personesSollicitudRDTO1.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO1);
		PersonesSollicitudRDTO personesSollicitudRDTO2 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO2.setId(ONE);
		personesSollicitudRDTO2.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL);
		personesSollicitudRDTO2.setRelacio(Constants.PERSONES_SOLLICITUD_RELACIO_ALTRES);
		personesSollicitudRDTO2.setPersona(ONE);
		personesSollicitudRDTO2.setSollicitud(ONE);
		personesSollicitudRDTO2.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO2);

		pageDataOfPersonesSollicitudRDTO.setData(personesSollicitudRDTOList);

		// Page
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes paginationAttributes = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes();
		paginationAttributes.setAbsoluteRowNumberOfFirstRowInCurrentPage(INTEGER_ONE);
		paginationAttributes.setAbsoluteRowNumberOfLastRowInCurrentPage(new Integer(2));
		paginationAttributes.setCurrentPageHasNextPage(FALSE);
		paginationAttributes.setCurrentPageHasPreviousPage(FALSE);
		paginationAttributes.setCurrentPageIsFirstPage(TRUE);
		paginationAttributes.setCurrentPageIsLastPage(TRUE);
		paginationAttributes.setCurrentPageNumber(INTEGER_ONE);
		paginationAttributes.setNextPageNumber(INTEGER_ZERO);
		paginationAttributes.setPageSize(new Integer(10));
		paginationAttributes.setPreviousPageNumber(INTEGER_ZERO);
		paginationAttributes.setTotalElements(new Long(2));
		paginationAttributes.setTotalPages(INTEGER_ONE);
		pageDataOfPersonesSollicitudRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo();
		sortInfo.setSort("nom");
		sortInfo.setDir("DESC");
		pageDataOfPersonesSollicitudRDTO.setSortInfo(sortInfo);

		return pageDataOfPersonesSollicitudRDTO;
	}

	/**
	 * Builds the persones.
	 *
	 * @return the persones
	 */
	private static Persones buildPersones() {
		Persones persones = new Persones();
		persones.setId(ONE);
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom1");
		persones.setCognom2("Cognom2");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(ONE);
		documentsIdentitat.setNumeroDocument("79688341B");
		TipusDocumentIdentitat tipusDocumentIdentitat = new TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ZERO);
		tipusDocumentIdentitat.setDescripcio("NIF");
		Paisos paisos = new Paisos();
		paisos.setCodiIne("108");
		paisos.setCodiIso("ES");
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		personesDadescontacte.setSexe(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);

		return persones;
	}

	/**
	 * Consultar dades tramit ovt response.
	 *
	 * @return the tramits ovt RDTO
	 */
	public static TramitsOvtRDTO consultarDadesTramitOvtResponse() {
		TramitsOvtRDTO tramitsOvtRDTO = new TramitsOvtRDTO();
		tramitsOvtRDTO.setId(ONE);
		tramitsOvtRDTO.setDescripcio("Sol·licitud");
		return tramitsOvtRDTO;
	}

	/**
	 * Cerca dades operacio agrupats 1 response.
	 *
	 * @return the page data of dades grups RDTO
	 */
	public static PageDataOfDadesGrupsRDTO cercaDadesOperacioResponse() {
		PageDataOfDadesGrupsRDTO pageDataOfDadesGrupsRDTO = new PageDataOfDadesGrupsRDTO();

		ArrayList<DadesGrupsRDTO> dadesGrupsRDTOList = new ArrayList<DadesGrupsRDTO>();
		DadesGrupsRDTO dadesGrupsRDTO = new DadesGrupsRDTO();
		dadesGrupsRDTO.setDescripcio("Descripcio G1");
		dadesGrupsRDTO.setId(ONE);
		dadesGrupsRDTO.setNomColumnes(INTEGER_ONE);
		dadesGrupsRDTO.setOrdre(INTEGER_ONE);
		dadesGrupsRDTO.setProcediment(ONE);
		dadesGrupsRDTO.setTitol("Tìtol G1");
		dadesGrupsRDTO.setUrlValidacio("URL Validació G1");
		dadesGrupsRDTO.setVigent(INTEGER_ONE);
		ArrayList<DadesOperacions> dadesOperacionsList = new ArrayList<DadesOperacions>();
		DadesOperacions dadesOperacions = new DadesOperacions();
		dadesOperacions.setCercable(INTEGER_ONE);
		dadesOperacions.setCodi("DO");
		dadesOperacions.setComentari("Comentari DO");
		dadesOperacions.setDescripcio("Descripció DO");
		dadesOperacions.setDesTipusCamp("Numèric");
		dadesOperacions.setDetallValidacio("Detall validació 1");
		DadesoperEstatsExp dadesoperEstatsExp = new DadesoperEstatsExp();
		dadesoperEstatsExp.setDadesOperacio(ONE);
		dadesoperEstatsExp.setEstatExpIdext(ONE);
		dadesOperacions.setDadesoperEstatsExpList(Arrays.asList(dadesoperEstatsExp));
		dadesOperacions.setGrup(ONE);
		dadesOperacions.setId(ONE);
		dadesOperacions.setOrdre(INTEGER_ONE);
		dadesOperacions.setProcediment(ONE);
		dadesOperacions.setTipus(INTEGER_ONE);
		dadesOperacions.setTitol("Tìtol DO");
		dadesOperacions.setTitolGrup("Tìtol G1");
		dadesOperacions.setUrlOrigen("URL Origen DO");
		dadesOperacions.setValidacio(INTEGER_ONE);
		dadesOperacions.setVigent(INTEGER_ONE);
		ArrayList<DadesOperacionsValidacio> dadesOperacionsValidacioList = new ArrayList<DadesOperacionsValidacio>();
		DadesOperacionsValidacio dadesOperacionsValidacio = new DadesOperacionsValidacio();
		dadesOperacionsValidacio.setDadesOperacions(ONE);
		dadesOperacionsValidacio.setId(ONE);
		dadesOperacionsValidacio.setTipusValidacio(ONE);
		ArrayList<DadesOperValidVal> DadesOperValidValList = new ArrayList<DadesOperValidVal>();
		DadesOperValidVal dadesOperValidVal = new DadesOperValidVal();
		dadesOperValidVal.setDadesOperValid(ONE);
		dadesOperValidVal.setId(ONE);
		dadesOperValidVal.setOrdre(LONG_ONE);
		dadesOperValidVal.setValor("10000");
		DadesOperValidValList.add(dadesOperValidVal);
		dadesOperacionsValidacio.setDadesOperacionsValidValors(DadesOperValidValList);
		dadesOperacionsValidacioList.add(dadesOperacionsValidacio);
		dadesOperacions.setDadesOperacionsValidacio(dadesOperacionsValidacioList);
		ArrayList<DadesOperTramitsOvt> dadesOperTramitsOvtList = new ArrayList<DadesOperTramitsOvt>();
		DadesOperTramitsOvt dadesOperTramitsOvt = new DadesOperTramitsOvt();
		dadesOperTramitsOvt.setDadaOper(ONE);
		dadesOperTramitsOvt.setTramitOvtIdext(ONE);
		dadesOperTramitsOvtList.add(dadesOperTramitsOvt);
		dadesOperacions.setDadesOperTramitsOvtList(dadesOperTramitsOvtList);
		ArrayList<Items> itemsList = new ArrayList<Items>();
		Items items = new Items();
		items.setDadesOperacions(ONE);
		items.setId(ONE);
		items.setItemDescripcio("Descripció Item");
		items.setItemId(INTEGER_ONE);
		items.setItemOrdre(INTEGER_ONE);
		itemsList.add(items);
		dadesOperacions.setItemsList(itemsList);
		dadesOperacionsList.add(dadesOperacions);
		dadesGrupsRDTO.setDadesOperacionsList(dadesOperacionsList);
		dadesGrupsRDTOList.add(dadesGrupsRDTO);
		pageDataOfDadesGrupsRDTO.setData(dadesGrupsRDTOList);

		return pageDataOfDadesGrupsRDTO;
	}

	/**
	 * Cerca configuracio documentacio entrada response.
	 *
	 * @return the page data of configuracio docs entrada RDTO
	 */
	public static PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntradaResponse() {
		PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = new PageDataOfConfiguracioDocsEntradaRDTO();

		ArrayList<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList = new ArrayList<ConfiguracioDocsEntradaRDTO>();
		AtributsDocs atributsDocs = new AtributsDocs();
		atributsDocs.setObligatori(INTEGER_ONE);
		atributsDocs.setRepetible(INTEGER_ONE);
		ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO1 = new ConfiguracioDocsEntradaRDTO();
		configuracioDocsEntradaRDTO1.setId(ONE);
		configuracioDocsEntradaRDTO1.setNom("Nom Doc");
		configuracioDocsEntradaRDTO1.setDescripcioAmpliada("Descripció Ampliada Doc");
		configuracioDocsEntradaRDTO1.setAtributsDocs(atributsDocs);
		configuracioDocsEntradaRDTO1.setSuportConfeccio(INTEGER_ONE);
		configuracioDocsEntradaRDTO1.setSuportEnllac("Suport Enllac Doc");
		configuracioDocsEntradaRDTO1.setUniqueId(new BigDecimal(42));
		configuracioDocsEntradaRDTOList.add(configuracioDocsEntradaRDTO1);
		ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO2 = new ConfiguracioDocsEntradaRDTO();
		configuracioDocsEntradaRDTO2.setId(ONE);
		configuracioDocsEntradaRDTO2.setNom("Nom Doc");
		configuracioDocsEntradaRDTO2.setDescripcioAmpliada("Descripció Ampliada Doc");
		configuracioDocsEntradaRDTO2.setAtributsDocs(atributsDocs);
		configuracioDocsEntradaRDTO2.setSuportConfeccio(INTEGER_ONE);
		configuracioDocsEntradaRDTO2.setSuportEnllac("Suport Enllac Doc");
		configuracioDocsEntradaRDTO2.setUniqueId(new BigDecimal(43));
		configuracioDocsEntradaRDTOList.add(configuracioDocsEntradaRDTO2);
		pageDataOfConfiguracioDocsEntradaRDTO.setData(configuracioDocsEntradaRDTOList);

		return pageDataOfConfiguracioDocsEntradaRDTO;
	}

	/**
	 * Cerca accions possibles response.
	 *
	 * @return the list
	 */
	public static List<AccionsEstatsRDTO> cercaAccionsPossiblesResponse() {
		ArrayList<AccionsEstatsRDTO> accionsEstatsRDTOList = new ArrayList<AccionsEstatsRDTO>();

		AccionsEstatsRDTO accionsEstatsRDTO1 = new AccionsEstatsRDTO();
		accionsEstatsRDTO1.setId(ONE);
		accionsEstatsRDTO1.setNomAccio("Aportar documentació");
		accionsEstatsRDTO1.setAccio(new BigDecimal(2));
		accionsEstatsRDTOList.add(accionsEstatsRDTO1);

		AccionsEstatsRDTO accionsEstatsRDTO2 = new AccionsEstatsRDTO();
		accionsEstatsRDTO2.setId(ONE);
		accionsEstatsRDTO2.setNomAccio("Informar dades de l’expedient");
		accionsEstatsRDTO2.setAccio(new BigDecimal(39));
		accionsEstatsRDTOList.add(accionsEstatsRDTO2);

		AccionsEstatsRDTO accionsEstatsRDTO3 = new AccionsEstatsRDTO();
		accionsEstatsRDTO3.setId(ONE);
		accionsEstatsRDTO3.setNomAccio("Esborrar Document");
		accionsEstatsRDTO3.setAccio(new BigDecimal(42));
		accionsEstatsRDTOList.add(accionsEstatsRDTO3);

		AccionsEstatsRDTO accionsEstatsRDTO4 = new AccionsEstatsRDTO();
		accionsEstatsRDTO4.setId(ONE);
		accionsEstatsRDTO4.setNomAccio("Substituir document");
		accionsEstatsRDTO4.setAccio(new BigDecimal(17));
		accionsEstatsRDTOList.add(accionsEstatsRDTO4);

		AccionsEstatsRDTO accionsEstatsRDTO5 = new AccionsEstatsRDTO();
		accionsEstatsRDTO5.setId(ONE);
		accionsEstatsRDTO5.setNomAccio("Desistir / Renunciar");
		accionsEstatsRDTO5.setAccio(new BigDecimal(40));
		accionsEstatsRDTOList.add(accionsEstatsRDTO5);

		AccionsEstatsRDTO accionsEstatsRDTO6 = new AccionsEstatsRDTO();
		accionsEstatsRDTO6.setId(ONE);
		accionsEstatsRDTO6.setNomAccio("Registrar la sol·licitud");
		accionsEstatsRDTO6.setAccio(new BigDecimal(4));
		accionsEstatsRDTOList.add(accionsEstatsRDTO6);

		AccionsEstatsRDTO accionsEstatsRDTO7 = new AccionsEstatsRDTO();
		accionsEstatsRDTO7.setId(ONE);
		accionsEstatsRDTO7.setNomAccio("Respondre a requeriment o tràmit d'al·legacions o IP");
		accionsEstatsRDTO7.setAccio(new BigDecimal(3));
		accionsEstatsRDTOList.add(accionsEstatsRDTO7);

		return accionsEstatsRDTOList;
	}

	/**
	 * Cerca documents entrada agrupats per tramit ovt response.
	 *
	 * @return the list
	 */
	public static List<DocsEntradaRDTO> cercaDocumentsEntradaAgrupatsPerTramitOvtResponse() {
		ArrayList<DocsEntradaRDTO> docsEntradaRDTOList = new ArrayList<DocsEntradaRDTO>();

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(ONE);
		docsEntradaRDTO.setTramitOvtIdext(ONE);
		docsEntradaRDTO.setDataPresentacio(now());
		docsEntradaRDTO.setRevisio(INTEGER_ONE);
		docsEntradaRDTO.setRegistreIdext(ONE);
		docsEntradaRDTO.setDocsFisicsNom("fitxer.pdf");

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones persones = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones();
		persones.setId(ONE);
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("NomRaoSocial");
		persones.setCognom1("Cognom1");
		persones.setCognom2("Cognom2");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat documentsIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat();
		documentsIdentitat.setId(ONE);
		documentsIdentitat.setNumeroDocument("12345678H");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentIdentitat tipusDocumentIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ONE);
		tipusDocumentIdentitat.setDescripcio("NIF");
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Paisos paisos = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Paisos();
		paisos.setCodiIne("108");
		paisos.setCodiIso("ES");
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte personesDadescontacte = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		personesDadescontacte.setSexe(ONE);
		persones.setPersonesDadescontacte(personesDadescontacte);

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RegistreAssentament registreAssentament = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RegistreAssentament();
		registreAssentament.setCodi("RADOC1");
		registreAssentament.setDataRegistre(now());
		registreAssentament.setId(ONE);
		registreAssentament.setPersona(ONE);
		registreAssentament.setTipus(ONE);
		registreAssentament.setUsuari(ONE);
		registreAssentament.setPersones(persones);
		docsEntradaRDTO.setRegistreAssentament(registreAssentament);

		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(ONE);
		configuracioDocsEntrada.setDescripcioAmpliada("Configuració Documentació Entrada");
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);

		docsEntradaRDTOList.add(docsEntradaRDTO);

		return docsEntradaRDTOList;
	}

	/**
	 * Cerca configuracio documentacio entrada requerida response.
	 *
	 * @return the list
	 */
	public static List<ConfDocEntradaRequeritRDTO> cercaConfiguracioDocumentacioEntradaRequeridaResponse() {
		ArrayList<ConfDocEntradaRequeritRDTO> confDocEntradaRequeritRDTOList = new ArrayList<ConfDocEntradaRequeritRDTO>();
		ConfDocEntradaRequeritRDTO confDocEntradaRequeritRDTO = new ConfDocEntradaRequeritRDTO();
		confDocEntradaRequeritRDTO.setId(ONE);
		confDocEntradaRequeritRDTO.setNom("Nom Doc");
		confDocEntradaRequeritRDTO.setDescripcioAmpliada("Descripció Ampliada Doc");
		AtributsDocs atributsDocs = new AtributsDocs();
		atributsDocs.setObligatori(INTEGER_ONE);
		atributsDocs.setRepetible(INTEGER_ONE);
		confDocEntradaRequeritRDTO.setAtributsDocs(atributsDocs);
		confDocEntradaRequeritRDTO.setSuportConfeccio(INTEGER_ONE);
		confDocEntradaRequeritRDTO.setSuportEnllac("Suport Enllac Doc");
		confDocEntradaRequeritRDTOList.add(confDocEntradaRequeritRDTO);
		return confDocEntradaRequeritRDTOList;
	}

	/**
	 * Consultar dades especifiques expedient response.
	 *
	 * @return the list
	 */
	public static List<DadesEspecifiquesRDTO> consultarDadesEspecifiquesExpedientResponse() {
		ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = new ArrayList<DadesEspecifiquesRDTO>();

		DadesEspecifiquesRDTO dadesEspecifiquesRDTO1 = new DadesEspecifiquesRDTO();
		dadesEspecifiquesRDTO1.setCampIdext(ONE);
		dadesEspecifiquesRDTO1.setExpedient(ONE);
		dadesEspecifiquesRDTO1.setId(ONE);
		dadesEspecifiquesRDTO1.setTipus(ONE);
		ArrayList<DadesEspecifiquesValors> dadesEspecifiquesValorsList1 = new ArrayList<DadesEspecifiquesValors>();
		DadesEspecifiquesValors dadesEspecifiquesValors1 = new DadesEspecifiquesValors();
		dadesEspecifiquesValors1.setId(ONE);
		dadesEspecifiquesValors1.setValorDouble(3.14D);
		dadesEspecifiquesValorsList1.add(dadesEspecifiquesValors1);
		dadesEspecifiquesRDTO1.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList1);
		dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO1);

		DadesEspecifiquesRDTO dadesEspecifiquesRDTO2 = new DadesEspecifiquesRDTO();
		dadesEspecifiquesRDTO2.setCampIdext(ONE);
		dadesEspecifiquesRDTO2.setExpedient(ONE);
		dadesEspecifiquesRDTO2.setId(ONE);
		dadesEspecifiquesRDTO2.setTipus(ONE);
		ArrayList<DadesEspecifiquesValors> dadesEspecifiquesValorsList2 = new ArrayList<DadesEspecifiquesValors>();
		DadesEspecifiquesValors dadesEspecifiquesValors2 = new DadesEspecifiquesValors();
		dadesEspecifiquesValors2.setId(ONE);
		dadesEspecifiquesValors2.setValorCalendar(now());
		dadesEspecifiquesRDTO2.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList2);
		dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO2);

		DadesEspecifiquesRDTO dadesEspecifiquesRDTO3 = new DadesEspecifiquesRDTO();
		dadesEspecifiquesRDTO3.setCampIdext(ONE);
		dadesEspecifiquesRDTO3.setExpedient(ONE);
		dadesEspecifiquesRDTO3.setId(ONE);
		dadesEspecifiquesRDTO3.setTipus(ONE);
		ArrayList<DadesEspecifiquesValors> dadesEspecifiquesValorsList3 = new ArrayList<DadesEspecifiquesValors>();
		DadesEspecifiquesValors dadesEspecifiquesValors3 = new DadesEspecifiquesValors();
		dadesEspecifiquesValors3.setId(ONE);
		ArrayList<Integer> valoresListaMultiple = new ArrayList<Integer>();
		valoresListaMultiple.add(INTEGER_ZERO);
		valoresListaMultiple.add(INTEGER_ONE);
		dadesEspecifiquesValors3.setValorListaMultipleList(valoresListaMultiple);
		dadesEspecifiquesRDTO3.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList3);
		dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO3);

		return dadesEspecifiquesRDTOList;
	}

	/**
	 * Consultar dades pais response.
	 *
	 * @return the paisos RDTO
	 */
	public static PaisosRDTO consultarDadesPaisResponse() {
		PaisosRDTO paisosRDTO = new PaisosRDTO();

		paisosRDTO.setCodiIne("108");
		paisosRDTO.setCodiIso("ES");
		paisosRDTO.setNom("España");

		return paisosRDTO;
	}

	/**
	 * Crear sollicitud expedient response.
	 *
	 * @return the expedients RDTO
	 */
	public static ExpedientsRDTO crearSollicitudExpedientResponse() {
		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();

		expedientsRDTO.setId(ONE);
		expedientsRDTO.setCodi("Codi/2019/000001");

		return expedientsRDTO;
	}

	public static RespostaAportarDocumentacioExpedientRDTO aportarDocumentacioExpedientResponse() {
		RespostaAportarDocumentacioExpedientRDTO respostaAportarDocumentacioExpedientRDTO = new RespostaAportarDocumentacioExpedientRDTO();
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(ONE);
		configuracioDocsEntrada.setNom("Nom");
		ArrayList<DocsEntradaRDTO> docsEntradaRDTOList = new ArrayList<DocsEntradaRDTO>();
		DocsEntradaRDTO docsEntradaRDTO1 = new DocsEntradaRDTO();
		docsEntradaRDTO1.setId(ONE);
		docsEntradaRDTO1.setDocsFisics(docsFisics);
		docsEntradaRDTO1.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO1.setConfiguracioDocsEntradaNom("Nom");
		docsEntradaRDTO1.setOrigen(INTEGER_ONE);
		docsEntradaRDTO1.setRevisio(INTEGER_ONE);
		docsEntradaRDTO1.setDataPresentacio(now());
		docsEntradaRDTO1.setDataUltimaModificacio(now());
		docsEntradaRDTOList.add(docsEntradaRDTO1);
		DocsEntradaRDTO docsEntradaRDTO2 = new DocsEntradaRDTO();
		docsEntradaRDTO2.setId(ONE);
		docsEntradaRDTO2.setDocsFisics(docsFisics);
		docsEntradaRDTO2.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO2.setConfiguracioDocsEntradaNom("Nom");
		docsEntradaRDTO2.setOrigen(INTEGER_ONE);
		docsEntradaRDTO2.setRevisio(INTEGER_ONE);
		docsEntradaRDTO2.setDataPresentacio(now());
		docsEntradaRDTO2.setDataUltimaModificacio(now());
		docsEntradaRDTOList.add(docsEntradaRDTO2);
		respostaAportarDocumentacioExpedientRDTO.setDocsEntrada(docsEntradaRDTOList);
		ExpedientRDTO expedientRDTO = new ExpedientRDTO();
		expedientRDTO.setId(ONE);
		expedientRDTO.setCodi("Codi");
		respostaAportarDocumentacioExpedientRDTO.setExpedient(expedientRDTO);
		RegistreAssentamentRDTO registreAssentamentRDTO = new RegistreAssentamentRDTO();
		registreAssentamentRDTO.setCodi("Codi");
		registreAssentamentRDTO.setDataRegistre(now());
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones persones = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones();
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom 1");
		persones.setCognom2("Cognom 2");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat documentsIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat();
		documentsIdentitat.setTipus(ONE);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentIdentitat tipusDocumentIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setNumeroDocument("00000000T");
		documentsIdentitat.setPais("108");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Paisos paisos = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Paisos();
		paisos.setCodiIne("108");
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		registreAssentamentRDTO.setPersones(persones);
		respostaAportarDocumentacioExpedientRDTO.setRegistreAssentament(registreAssentamentRDTO);

		return respostaAportarDocumentacioExpedientRDTO;
	}

	public static DocsEntradaRDTO consultarDadesDocumentAportat() {
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(ONE);
		configuracioDocsEntrada.setNom("Nom");
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(ONE);
		docsEntradaRDTO.setDocsFisics(docsFisics);
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Nom");
		docsEntradaRDTO.setOrigen(INTEGER_ONE);
		docsEntradaRDTO.setRevisio(INTEGER_ONE);
		docsEntradaRDTO.setDataPresentacio(now());
		docsEntradaRDTO.setDataUltimaModificacio(now());
		docsEntradaRDTO.setDocumentacio(ONE);

		return docsEntradaRDTO;
	}

	public static RespostaSubstituirDocumentExpedientRDTO substituirDocumentExpedientResponse() {
		RespostaSubstituirDocumentExpedientRDTO respostaSubstituirDocumentExpedientRDTO = new RespostaSubstituirDocumentExpedientRDTO();
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		ConfiguracioDocsEntrada configuracioDocsEntrada = new ConfiguracioDocsEntrada();
		configuracioDocsEntrada.setId(ONE);
		configuracioDocsEntrada.setNom("Nom");
		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(ONE);
		docsEntradaRDTO.setDocsFisics(docsFisics);
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);
		docsEntradaRDTO.setConfiguracioDocsEntradaNom("Nom");
		docsEntradaRDTO.setOrigen(INTEGER_ONE);
		docsEntradaRDTO.setRevisio(INTEGER_ONE);
		docsEntradaRDTO.setDataPresentacio(now());
		docsEntradaRDTO.setDataUltimaModificacio(now());
		respostaSubstituirDocumentExpedientRDTO.setDocEntrada(docsEntradaRDTO);
		ExpedientRDTO expedientRDTO = new ExpedientRDTO();
		expedientRDTO.setId(ONE);
		expedientRDTO.setCodi("Codi");
		respostaSubstituirDocumentExpedientRDTO.setExpedient(expedientRDTO);
		RegistreAssentamentRDTO registreAssentamentRDTO = new RegistreAssentamentRDTO();
		registreAssentamentRDTO.setCodi("Codi");
		registreAssentamentRDTO.setDataRegistre(now());
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones persones = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones();
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom 1");
		persones.setCognom2("Cognom 2");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat documentsIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentsIdentitat();
		documentsIdentitat.setTipus(ONE);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentIdentitat tipusDocumentIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setNumeroDocument("00000000T");
		documentsIdentitat.setPais("108");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Paisos paisos = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Paisos();
		paisos.setCodiIne("108");
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		registreAssentamentRDTO.setPersones(persones);
		respostaSubstituirDocumentExpedientRDTO.setRegistreAssentament(registreAssentamentRDTO);

		return respostaSubstituirDocumentExpedientRDTO;
	}

	public static byte[] descarregarDocumentExpedientResponse() {
		return "prova".getBytes();
	}

	public static RespostaRegistrarSolicitudExpedient registrarSolicitudExpedientResponse() {
		RespostaRegistrarSolicitudExpedient respostaRegistrarSolicitudExpedient = new RespostaRegistrarSolicitudExpedient();

		respostaRegistrarSolicitudExpedient.setComprovant("prova".getBytes());
		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();
		expedientsRDTO.setId(ONE);
		expedientsRDTO.setCodi("Codi");
		respostaRegistrarSolicitudExpedient.setExpedient(expedientsRDTO);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO registreAssentamentRDTO = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO();
		registreAssentamentRDTO.setCodi("Codi");
		registreAssentamentRDTO.setDataRegistre(now());
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones persones = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones();
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom 1");
		persones.setCognom2("Cognom 2");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat documentsIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat();
		documentsIdentitat.setTipus(ONE);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusDocumentIdentitat tipusDocumentIdentitat = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setNumeroDocument("00000000T");
		documentsIdentitat.setPais("108");
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Paisos paisos = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Paisos();
		paisos.setCodiIne("108");
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		registreAssentamentRDTO.setPersones(persones);
		respostaRegistrarSolicitudExpedient.setRegistreAssentament(registreAssentamentRDTO);

		return respostaRegistrarSolicitudExpedient;
	}
}
