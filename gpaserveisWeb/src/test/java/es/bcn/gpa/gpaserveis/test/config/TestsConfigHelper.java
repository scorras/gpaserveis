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

import org.apache.commons.lang.math.NumberUtils;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AtributsDocs;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocsTramPolitiquesSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntrada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConsultarSignaturaResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsFisics;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsSignatures;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.TipusMime;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviarEstat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfSollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesDadescontacte;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentament;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Sollicituds;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusDocumentIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperTramitsOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesoperEstatsExp;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Estats;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.EstatsProcediment;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Identificacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.Items;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsIniciacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ReqOperatiusTramOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.RequerimentsOperatius;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class TestsConfigHelper.
 */
public class TestsConfigHelper {

	// TODO Meter Factory y limpiar

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
		procedimentsRDTO.setDescripcioEstat("En elaboraci??");
		procedimentsRDTO.setEstatProcediment(ONE);
		EstatsProcediment estatsProcediment = new EstatsProcediment();
		estatsProcediment.setEstat(ONE);
		Estats estats = new Estats();
		estats.setId(ONE);
		estats.setDescripcio("En elaboraci??");
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
		procedimentsRDTO.setVersio(ONE);
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
		procedimentsRDTO.setVersio(ONE);
		procedimentsRDTO.setNom("Procediment 1");
		procedimentsRDTO.setDescripcio("Descripci?? Procediment 1");
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
		identificacions.setOrganResolutori("??rgan resolutori Procediment 1");
		identificacions.setInformacioCiutada("Per al ciutad?? Procediment 1");
		identificacions.setNivellAutenticacio(INTEGER_ONE);
		identificacions.setTerminiMaxim(INTEGER_ONE);
		identificacions.setEspecTerminiMaxim(new Integer(7));
		identificacions.setPeriodicitatTermini(INTEGER_ONE);
		identificacions.setVigenciaInici(now());
		identificacions.setVigenciaFi(now());
		identificacions.setAdministratiu(INTEGER_ZERO);
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

		RequerimentsOperatius requerimentsOperatius = new RequerimentsOperatius();
		requerimentsOperatius.setAplicacioNegoci("quiosc");
		requerimentsOperatius.setId(ONE);
		List<ReqOperatiusTramOvt> reqOperatiusTramOvtList = new ArrayList<ReqOperatiusTramOvt>();
		ReqOperatiusTramOvt reqOperatiusTramOvt = new ReqOperatiusTramOvt();
		reqOperatiusTramOvt.setIdReq(ONE);
		reqOperatiusTramOvt.setTramitOvtIdext(new BigDecimal(2));
		reqOperatiusTramOvt.setTramitGeneric(1);
		reqOperatiusTramOvtList.add(reqOperatiusTramOvt);
		ReqOperatiusTramOvt reqOperatiusTramOvt1 = new ReqOperatiusTramOvt();
		reqOperatiusTramOvt1.setIdReq(ONE);
		reqOperatiusTramOvt1.setTramitOvtIdext(new BigDecimal(1));
		reqOperatiusTramOvt1.setTramitRegistre(INTEGER_ONE);
		reqOperatiusTramOvtList.add(reqOperatiusTramOvt1);
		requerimentsOperatius.setReqOperatiusTramOvtList(reqOperatiusTramOvtList);
		procedimentsRDTO.setReqOperatius(requerimentsOperatius);
		procedimentsRDTO.setRequerimentsOperatius(ONE);

		List<ProcedimentPersones> procedimentPersonesList = new ArrayList<ProcedimentPersones>();
		ProcedimentPersones procedimentPersones = new ProcedimentPersones();
		procedimentPersones.setProcediment(ONE);
		procedimentPersones.setNivellVisibilitat(ONE);
		procedimentPersones.setRelacio("Testimoni");
		procedimentPersonesList.add(procedimentPersones);

		procedimentsRDTO.setProcedimentPersonesList(procedimentPersonesList);

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
		unitatsGestoresRDTO1.setDescripcio("Descripci?? UG1");
		unitatsGestoresRDTO1.setId(new BigDecimal(1));
		unitatsGestoresRDTO1.setNom("UG1");
		unitatsGestoresRDTO1.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO1);
		UnitatsGestoresRDTO unitatsGestoresRDTO2 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO2.setDataCreacio(now());
		unitatsGestoresRDTO2.setDataModificacio(now());
		unitatsGestoresRDTO2.setDescripcio("Descripci?? UG2");
		unitatsGestoresRDTO2.setId(new BigDecimal(2));
		unitatsGestoresRDTO2.setNom("UG2");
		unitatsGestoresRDTO2.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO2);
		UnitatsGestoresRDTO unitatsGestoresRDTO3 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO3.setDataCreacio(now());
		unitatsGestoresRDTO3.setDataModificacio(now());
		unitatsGestoresRDTO3.setDescripcio("Descripci?? UG3");
		unitatsGestoresRDTO3.setId(new BigDecimal(3));
		unitatsGestoresRDTO3.setNom("UG3");
		unitatsGestoresRDTO3.setVigent(INTEGER_ONE);
		unitatsGestoresRDTOList.add(unitatsGestoresRDTO3);
		UnitatsGestoresRDTO unitatsGestoresRDTO4 = new UnitatsGestoresRDTO();
		unitatsGestoresRDTO4.setDataCreacio(now());
		unitatsGestoresRDTO4.setDataModificacio(now());
		unitatsGestoresRDTO4.setDescripcio("Descripci?? UG4");
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
		unitatsGestoresRDTO.setDescripcio("Descripci?? UG1");

		return unitatsGestoresRDTO;
	}

	/**
	 * Consultar dades unitat gestora convidar response.
	 *
	 * @return the unitats gestores RDTO
	 */
	public static UnitatsGestoresRDTO consultarDadesUnitatGestoraConvidarResponse() {
		UnitatsGestoresRDTO unitatsGestoresRDTO = new UnitatsGestoresRDTO();

		unitatsGestoresRDTO.setId(new BigDecimal(3));
		unitatsGestoresRDTO.setNom("UG3");
		unitatsGestoresRDTO.setDescripcio("Descripci?? UG3");

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
		expedientsRDTO.setDescUnitatGestora("Descripci?? UG1");
		expedientsRDTO.setTramitador("APLICACIO_DE_NEGOCI");
		expedientsRDTO.setDescEstat("En tramitaci??");
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
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
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

	public static SollicitudsRDTO consultarDadesSollicitudResponse(BigDecimal id, boolean esRegistrado) {
		SollicitudsRDTO sollicitudsRDTO = new SollicitudsRDTO();

		sollicitudsRDTO.setId(id);
		sollicitudsRDTO.setComentari(ONE);
		sollicitudsRDTO.setDataPresentacio(now());
		sollicitudsRDTO.setDataSollicitud(now());
		sollicitudsRDTO.setExpedient(ONE);
		sollicitudsRDTO.setIniciacio(ONE);
		sollicitudsRDTO.setTramitOvtIdext(new BigDecimal(3));

		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(ONE);
		registreAssentament.setCodi("REG01");
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

		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);

		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		registreAssentament.setPersones(persones);
		if (esRegistrado) {
			sollicitudsRDTO.setRegistreAssentament(registreAssentament);
			sollicitudsRDTO.setRegistre(ONE);
		} else {
			sollicitudsRDTO.setRegistreAssentament(null);
			sollicitudsRDTO.setRegistre(null);
		}

		List<PersonesSollicitudRDTO> personesInteressades = new ArrayList<PersonesSollicitudRDTO>();
		PersonesSollicitudRDTO personesSollicitudRDTO = new PersonesSollicitudRDTO();
		personesSollicitudRDTO.setId(ONE);
		persones = new Persones();
		persones.setId(ONE);
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom1");
		persones.setCognom2("Cognom2");
		documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(ONE);
		documentsIdentitat.setNumeroDocument("79688341B");
		tipusDocumentIdentitat = new TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ZERO);
		tipusDocumentIdentitat.setDescripcio("NIF");
		personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		personesSollicitudRDTO.setPersones(persones);
		personesInteressades.add(personesSollicitudRDTO);
		sollicitudsRDTO.setPersonesInteressades(personesInteressades);

		return sollicitudsRDTO;
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
		expedientsRDTO.setSollicitant("Sol??licitant");
		expedientsRDTO.setAccioEstatIdext(ONE);
		expedientsRDTO.setUnitatGestoraIdext(ONE);
		expedientsRDTO.setDescUnitatGestora("UG1");
		expedientsRDTO.setTramitador("quiosc");
		expedientsRDTO.setDescEstat("En preparaci??");
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

		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats estats = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats();
		estats.setId(ONE);
		estats.setDataCreacio(now());
		estats.setAccioEstatIdext(ONE);
		estats.setEstatAnterior(ONE);
		estats.setUsuari(ONE);
		estats.setUnitatGestoraIdext(ONE);

		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		registreAssentament.setPersones(persones);
		sollicituds.setRegistreAssentament(registreAssentament);
		expedientsRDTO.setSollicituds(sollicituds);
		expedientsRDTO.setEstat(estats);

		PersonesSollicitud personesSollicitud = new PersonesSollicitud();
		personesSollicitud.setId(ONE);
		persones = new Persones();
		persones.setId(ONE);
		persones.setTipusPersona(ONE);
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom1");
		persones.setCognom2("Cognom2");
		documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setId(ONE);
		documentsIdentitat.setNumeroDocument("79688341B");
		tipusDocumentIdentitat = new TipusDocumentIdentitat();
		tipusDocumentIdentitat.setId(ZERO);
		tipusDocumentIdentitat.setDescripcio("NIF");
		personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		personesSollicitud.setPersones(persones);
		expedientsRDTO.setSollicitantPrincipal(personesSollicitud);

		return expedientsRDTO;
	}

	/**
	 * Consultar dades expedient acumular response.
	 *
	 * @return the expedients RDTO
	 */
	public static ExpedientsRDTO consultarDadesExpedientAcumularResponse() {
		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();

		expedientsRDTO.setId(new BigDecimal(2));
		expedientsRDTO.setCodi("Codi/2019/000002");
		expedientsRDTO.setSollicitud(ONE);
		expedientsRDTO.setProcedimentIdext(ONE);
		expedientsRDTO.setDocumentacioIdext(ONE);
		expedientsRDTO.setEstatActual(ONE);
		expedientsRDTO.setUltimaModificacio(ONE);
		expedientsRDTO.setDarreraModificacio(now());
		expedientsRDTO.setDataPresentacio(now());
		expedientsRDTO.setNomProcediment("Nom PROC01");
		expedientsRDTO.setSollicitant("Sol??licitant");
		expedientsRDTO.setAccioEstatIdext(ONE);
		expedientsRDTO.setUnitatGestoraIdext(ONE);
		expedientsRDTO.setDescUnitatGestora("UG1");
		expedientsRDTO.setTramitador("quiosc");
		expedientsRDTO.setDescEstat("En preparaci??");
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

		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats estats = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats();
		estats.setId(ONE);
		estats.setDataCreacio(now());
		estats.setAccioEstatIdext(ONE);
		estats.setEstatAnterior(ONE);
		estats.setUsuari(ONE);
		estats.setUnitatGestoraIdext(ONE);

		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		registreAssentament.setPersones(persones);
		sollicituds.setRegistreAssentament(registreAssentament);
		expedientsRDTO.setSollicituds(sollicituds);
		expedientsRDTO.setEstat(estats);

		return expedientsRDTO;
	}

	public static PageDataOfExpedientsRDTO obtenirExpedientsRelacionatsResponse() {
		PageDataOfExpedientsRDTO pageDataOfExpedientsRDTO = new PageDataOfExpedientsRDTO();
		ArrayList<ExpedientsRDTO> expedientsRDTOList = new ArrayList<ExpedientsRDTO>();

		ExpedientsRDTO expedientsRDTO = new ExpedientsRDTO();

		expedientsRDTO.setId(new BigDecimal(2));
		expedientsRDTO.setCodi("Codi/2019/000002");
		expedientsRDTO.setSollicitud(ONE);
		expedientsRDTO.setProcedimentIdext(ONE);
		expedientsRDTO.setDocumentacioIdext(ONE);
		expedientsRDTO.setEstatActual(ONE);
		expedientsRDTO.setUltimaModificacio(ONE);
		expedientsRDTO.setDarreraModificacio(now());
		expedientsRDTO.setDataPresentacio(now());
		expedientsRDTO.setNomProcediment("Nom PROC01");
		expedientsRDTO.setSollicitant("Sol??licitant");
		expedientsRDTO.setAccioEstatIdext(ONE);
		expedientsRDTO.setUnitatGestoraIdext(ONE);
		expedientsRDTO.setDescUnitatGestora("UG1");
		expedientsRDTO.setTramitador("quiosc");
		expedientsRDTO.setDescEstat("En preparaci??");
		expedientsRDTO.setIdEstat(ONE);
		expedientsRDTO.setProcedimentCodi("PROC01");
		expedientsRDTO.setRelacioTipusRelacio("1-2");

		Sollicituds sollicituds = new Sollicituds();
		sollicituds.setId(ONE);
		sollicituds.setDataSollicitud(now());
		sollicituds.setDataPresentacio(now());
		sollicituds.setRegistre(ONE);

		RegistreAssentament registreAssentament = new RegistreAssentament();
		registreAssentament.setId(ONE);
		registreAssentament.setCodi("REG01");
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

		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);

		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats estats = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Estats();
		estats.setId(ONE);
		estats.setDataCreacio(now());
		estats.setAccioEstatIdext(ONE);
		estats.setEstatAnterior(ONE);
		estats.setUsuari(ONE);
		estats.setUnitatGestoraIdext(ONE);

		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		persones.setPersonesDadescontacte(personesDadescontacte);
		registreAssentament.setPersones(persones);
		sollicituds.setRegistreAssentament(registreAssentament);
		expedientsRDTO.setSollicituds(sollicituds);
		expedientsRDTO.setEstat(estats);

		expedientsRDTOList.add(expedientsRDTO);
		pageDataOfExpedientsRDTO.setData(expedientsRDTOList);

		return pageDataOfExpedientsRDTO;
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
		personesSollicitudRDTO1.setRelacioImplicada("Testimoni");
		personesSollicitudRDTO1.setPersona(ONE);
		personesSollicitudRDTO1.setSollicitud(ONE);
		personesSollicitudRDTO1.setPersones(buildPersones());
		personesSollicitudRDTOList.add(personesSollicitudRDTO1);
		PersonesSollicitudRDTO personesSollicitudRDTO2 = new PersonesSollicitudRDTO();
		personesSollicitudRDTO2.setId(ONE);
		personesSollicitudRDTO2.setRelacioPrincipal(Constants.PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL);
		personesSollicitudRDTO2.setRelacioImplicada("Altres");
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
		PersonesDadescontacte personesDadescontacte = new PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
		documentsIdentitat.setTipusDocumentIdentitat(tipusDocumentIdentitat);
		documentsIdentitat.setPais("108");
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
		tramitsOvtRDTO.setDescripcio("Sol??licitud");
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
		dadesGrupsRDTO.setTitol("T??tol G1");
		dadesGrupsRDTO.setUrlValidacio("URL Validaci?? G1");
		dadesGrupsRDTO.setVigent(INTEGER_ONE);
		ArrayList<DadesOperacions> dadesOperacionsList = new ArrayList<DadesOperacions>();
		DadesOperacions dadesOperacions = new DadesOperacions();
		dadesOperacions.setCercable(INTEGER_ONE);
		dadesOperacions.setCodi("DO");
		dadesOperacions.setComentari("Comentari DO");
		dadesOperacions.setDescripcio("Descripci?? DO");
		dadesOperacions.setDesTipusCamp("Num??ric");
		DadesoperEstatsExp dadesoperEstatsExp = new DadesoperEstatsExp();
		dadesoperEstatsExp.setDadesOperacio(ONE);
		dadesoperEstatsExp.setEstatExpIdext(ONE);
		dadesOperacions.setDadesoperEstatsExpList(Arrays.asList(dadesoperEstatsExp));
		dadesOperacions.setGrup(ONE);
		dadesOperacions.setId(ONE);
		dadesOperacions.setOrdre(INTEGER_ONE);
		dadesOperacions.setProcediment(ONE);
		dadesOperacions.setTipus(INTEGER_ONE);
		dadesOperacions.setTitol("T??tol DO");
		dadesOperacions.setTitolGrup("T??tol G1");
		dadesOperacions.setUrlOrigen("URL Origen DO");
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
		items.setItemDescripcio("Descripci?? Item");
		items.setItemDescripcioCastella("Descripci?? Item en castell??");
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
		configuracioDocsEntradaRDTO1.setDescripcioAmpliada("Descripci?? Ampliada Doc");
		configuracioDocsEntradaRDTO1.setAtributsDocs(atributsDocs);
		configuracioDocsEntradaRDTO1.setSuportConfeccio(INTEGER_ONE);
		configuracioDocsEntradaRDTO1.setSuportEnllac("Suport Enllac Doc");
		configuracioDocsEntradaRDTO1.setUniqueId(new BigDecimal(42));
		configuracioDocsEntradaRDTOList.add(configuracioDocsEntradaRDTO1);
		ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO2 = new ConfiguracioDocsEntradaRDTO();
		configuracioDocsEntradaRDTO2.setId(ONE);
		configuracioDocsEntradaRDTO2.setNom("Nom Doc");
		configuracioDocsEntradaRDTO2.setDescripcioAmpliada("Descripci?? Ampliada Doc");
		configuracioDocsEntradaRDTO2.setAtributsDocs(atributsDocs);
		configuracioDocsEntradaRDTO2.setSuportConfeccio(INTEGER_ONE);
		configuracioDocsEntradaRDTO2.setSuportEnllac("Suport Enllac Doc");
		configuracioDocsEntradaRDTO2.setUniqueId(new BigDecimal(43));
		configuracioDocsEntradaRDTOList.add(configuracioDocsEntradaRDTO2);
		pageDataOfConfiguracioDocsEntradaRDTO.setData(configuracioDocsEntradaRDTOList);

		return pageDataOfConfiguracioDocsEntradaRDTO;
	}

	/**
	 * Cerca configuracio documentacio tramitacio response.
	 *
	 * @return the page data of configuracio docs tramitacio RDTO
	 */
	public static PageDataOfConfiguracioDocsTramitacioRDTO cercaConfiguracioDocumentacioTramitacioResponse() {
		PageDataOfConfiguracioDocsTramitacioRDTO pageDataOfConfiguracioDocsTramitacioRDTO = new PageDataOfConfiguracioDocsTramitacioRDTO();

		ArrayList<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList = new ArrayList<ConfiguracioDocsTramitacioRDTO>();
		AtributsDocs atributsDocs = new AtributsDocs();
		atributsDocs.setObligatori(INTEGER_ONE);
		atributsDocs.setRepetible(INTEGER_ONE);
		ConfiguracioDocsTramitacioRDTO configuracioDocsTramitacioRDTO1 = new ConfiguracioDocsTramitacioRDTO();
		configuracioDocsTramitacioRDTO1.setId(ONE);
		configuracioDocsTramitacioRDTO1.setNom("Nom Doc");
		configuracioDocsTramitacioRDTO1.setAtributsDocs(atributsDocs);
		configuracioDocsTramitacioRDTO1.setSuportConfeccio(INTEGER_ONE);
		configuracioDocsTramitacioRDTO1.setSuportEnllac("Suport Enllac Doc");
		configuracioDocsTramitacioRDTO1.setUniqueId(new BigDecimal(42));
		configuracioDocsTramitacioRDTOList.add(configuracioDocsTramitacioRDTO1);
		ConfiguracioDocsTramitacioRDTO configuracioDocsTramitacioRDTO2 = new ConfiguracioDocsTramitacioRDTO();
		configuracioDocsTramitacioRDTO2.setId(ONE);
		configuracioDocsTramitacioRDTO2.setNom("Nom Doc");
		configuracioDocsTramitacioRDTO2.setAtributsDocs(atributsDocs);
		configuracioDocsTramitacioRDTO2.setSuportConfeccio(INTEGER_ONE);
		configuracioDocsTramitacioRDTO2.setSuportEnllac("Suport Enllac Doc");
		configuracioDocsTramitacioRDTO2.setUniqueId(new BigDecimal(43));
		configuracioDocsTramitacioRDTOList.add(configuracioDocsTramitacioRDTO2);
		pageDataOfConfiguracioDocsTramitacioRDTO.setData(configuracioDocsTramitacioRDTOList);

		return pageDataOfConfiguracioDocsTramitacioRDTO;
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
		accionsEstatsRDTO1.setNomAccio("Aportar documentaci??");
		accionsEstatsRDTO1.setAccio(new BigDecimal(2));
		accionsEstatsRDTOList.add(accionsEstatsRDTO1);

		AccionsEstatsRDTO accionsEstatsRDTO2 = new AccionsEstatsRDTO();
		accionsEstatsRDTO2.setId(ONE);
		accionsEstatsRDTO2.setNomAccio("Informar dades de l???expedient");
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
		accionsEstatsRDTO6.setNomAccio("Registrar la sol??licitud");
		accionsEstatsRDTO6.setAccio(new BigDecimal(4));
		accionsEstatsRDTOList.add(accionsEstatsRDTO6);

		AccionsEstatsRDTO accionsEstatsRDTO7 = new AccionsEstatsRDTO();
		accionsEstatsRDTO7.setId(ONE);
		accionsEstatsRDTO7.setNomAccio("Respondre a requeriment o tr??mit d'al??legacions o IP");
		accionsEstatsRDTO7.setAccio(new BigDecimal(3));
		accionsEstatsRDTOList.add(accionsEstatsRDTO7);

		AccionsEstatsRDTO accionsEstatsRDTO8 = new AccionsEstatsRDTO();
		accionsEstatsRDTO8.setId(ONE);
		accionsEstatsRDTO8.setNomAccio("Validar sol??licitud");
		accionsEstatsRDTO8.setAccio(new BigDecimal(24));
		accionsEstatsRDTOList.add(accionsEstatsRDTO8);

		AccionsEstatsRDTO accionsEstatsRDTO9 = new AccionsEstatsRDTO();
		accionsEstatsRDTO9.setId(ONE);
		accionsEstatsRDTO9.setNomAccio("Pausar l'expedient");
		accionsEstatsRDTO9.setAccio(new BigDecimal(20));
		accionsEstatsRDTOList.add(accionsEstatsRDTO9);

		AccionsEstatsRDTO accionsEstatsRDTO10 = new AccionsEstatsRDTO();
		accionsEstatsRDTO10.setId(ONE);
		accionsEstatsRDTO10.setNomAccio("Reactivar expedient");
		accionsEstatsRDTO10.setAccio(new BigDecimal(21));
		accionsEstatsRDTOList.add(accionsEstatsRDTO10);

		AccionsEstatsRDTO accionsEstatsRDTO11 = new AccionsEstatsRDTO();
		accionsEstatsRDTO11.setId(ONE);
		accionsEstatsRDTO11.setNomAccio(Constants.DESCRIPCIO_ACCIO_ARXIVAR);
		accionsEstatsRDTO11.setAccio(new BigDecimal(23));
		accionsEstatsRDTOList.add(accionsEstatsRDTO11);

		AccionsEstatsRDTO accionsEstatsRDTO12 = new AccionsEstatsRDTO();
		accionsEstatsRDTO12.setId(ONE);
		accionsEstatsRDTO12.setNomAccio("Retornar la tramitaci??");
		accionsEstatsRDTO12.setAccio(new BigDecimal(26));
		accionsEstatsRDTOList.add(accionsEstatsRDTO12);

		AccionsEstatsRDTO accionsEstatsRDTO13 = new AccionsEstatsRDTO();
		accionsEstatsRDTO13.setId(ONE);
		accionsEstatsRDTO13.setNomAccio("Proposar resoluci??");
		accionsEstatsRDTO13.setAccio(new BigDecimal(27));
		accionsEstatsRDTOList.add(accionsEstatsRDTO13);

		AccionsEstatsRDTO accionsEstatsRDTO14 = new AccionsEstatsRDTO();
		accionsEstatsRDTO14.setId(ONE);
		accionsEstatsRDTO14.setNomAccio("Tancar expedient");
		accionsEstatsRDTO14.setAccio(new BigDecimal(9));
		accionsEstatsRDTOList.add(accionsEstatsRDTO14);

		AccionsEstatsRDTO accionsEstatsRDTO15 = new AccionsEstatsRDTO();
		accionsEstatsRDTO15.setId(ONE);
		accionsEstatsRDTO15.setNomAccio("Tornar enrere");
		accionsEstatsRDTO15.setAccio(new BigDecimal(43));
		accionsEstatsRDTOList.add(accionsEstatsRDTO15);

		AccionsEstatsRDTO accionsEstatsRDTO16 = new AccionsEstatsRDTO();
		accionsEstatsRDTO16.setId(ONE);
		accionsEstatsRDTO16.setNomAccio("Validar un document");
		accionsEstatsRDTO16.setAccio(new BigDecimal(15));
		accionsEstatsRDTOList.add(accionsEstatsRDTO16);

		AccionsEstatsRDTO accionsEstatsRDTO17 = new AccionsEstatsRDTO();
		accionsEstatsRDTO17.setId(ONE);
		accionsEstatsRDTO17.setNomAccio("Rebutjar un document");
		accionsEstatsRDTO17.setAccio(new BigDecimal(16));
		accionsEstatsRDTOList.add(accionsEstatsRDTO17);

		AccionsEstatsRDTO accionsEstatsRDTO18 = new AccionsEstatsRDTO();
		accionsEstatsRDTO18.setId(ONE);
		accionsEstatsRDTO18.setNomAccio("Convidar a tramitar");
		accionsEstatsRDTO18.setAccio(new BigDecimal(25));
		accionsEstatsRDTOList.add(accionsEstatsRDTO18);

		AccionsEstatsRDTO accionsEstatsRDTO19 = new AccionsEstatsRDTO();
		accionsEstatsRDTO19.setId(ONE);
		accionsEstatsRDTO19.setNomAccio("Canviar d'unitat gestora");
		accionsEstatsRDTO19.setAccio(new BigDecimal(41));
		accionsEstatsRDTOList.add(accionsEstatsRDTO19);

		AccionsEstatsRDTO accionsEstatsRDTO20 = new AccionsEstatsRDTO();
		accionsEstatsRDTO20.setId(ONE);
		accionsEstatsRDTO20.setNomAccio("Incorporar un nou document electr??nic");
		accionsEstatsRDTO20.setAccio(new BigDecimal(11));
		accionsEstatsRDTOList.add(accionsEstatsRDTO20);

		AccionsEstatsRDTO accionsEstatsRDTO21 = new AccionsEstatsRDTO();
		accionsEstatsRDTO21.setId(ONE);
		accionsEstatsRDTO21.setNomAccio("Signar document");
		accionsEstatsRDTO21.setAccio(new BigDecimal(29));
		accionsEstatsRDTOList.add(accionsEstatsRDTO21);

		AccionsEstatsRDTO accionsEstatsRDTO22 = new AccionsEstatsRDTO();
		accionsEstatsRDTO22.setId(ONE);
		accionsEstatsRDTO22.setNomAccio("Completar un document");
		accionsEstatsRDTO22.setAccio(new BigDecimal(14));
		accionsEstatsRDTOList.add(accionsEstatsRDTO22);

		AccionsEstatsRDTO accionsEstatsRDTO23 = new AccionsEstatsRDTO();
		accionsEstatsRDTO23.setId(ONE);
		accionsEstatsRDTO23.setNomAccio("Presentar declaraci?? responsable");
		accionsEstatsRDTO23.setAccio(new BigDecimal(5));
		accionsEstatsRDTOList.add(accionsEstatsRDTO23);

		AccionsEstatsRDTO accionsEstatsRDTO24 = new AccionsEstatsRDTO();
		accionsEstatsRDTO24.setId(ONE);
		accionsEstatsRDTO24.setNomAccio("Preparar un requeriment a l'interessat");
		accionsEstatsRDTO24.setAccio(new BigDecimal(18));
		accionsEstatsRDTOList.add(accionsEstatsRDTO24);

		AccionsEstatsRDTO accionsEstatsRDTO25 = new AccionsEstatsRDTO();
		accionsEstatsRDTO25.setId(ONE);
		accionsEstatsRDTO25.setNomAccio("Acumular expedients");
		accionsEstatsRDTO25.setAccio(new BigDecimal(37));
		accionsEstatsRDTOList.add(accionsEstatsRDTO25);

		AccionsEstatsRDTO accionsEstatsRDTO26 = new AccionsEstatsRDTO();
		accionsEstatsRDTO26.setId(ONE);
		accionsEstatsRDTO26.setNomAccio("Acc??s a l'expedient (funcionari d??na acc??s)");
		accionsEstatsRDTO26.setAccio(new BigDecimal(35));
		accionsEstatsRDTOList.add(accionsEstatsRDTO26);

		AccionsEstatsRDTO accionsEstatsRDTO27 = new AccionsEstatsRDTO();
		accionsEstatsRDTO27.setId(ONE);
		accionsEstatsRDTO27.setNomAccio("Registrar comunicaci??");
		accionsEstatsRDTO27.setAccio(new BigDecimal(22));
		accionsEstatsRDTOList.add(accionsEstatsRDTO27);

		AccionsEstatsRDTO accionsEstatsRDTO28 = new AccionsEstatsRDTO();
		accionsEstatsRDTO28.setId(ONE);
		accionsEstatsRDTO28.setNomAccio("Notificar");
		accionsEstatsRDTO28.setAccio(new BigDecimal(19));
		accionsEstatsRDTOList.add(accionsEstatsRDTO28);

		AccionsEstatsRDTO accionsEstatsRDTO29 = new AccionsEstatsRDTO();
		accionsEstatsRDTO29.setId(ONE);
		accionsEstatsRDTO29.setNomAccio("Document signat");
		accionsEstatsRDTO29.setAccio(new BigDecimal(44));
		accionsEstatsRDTOList.add(accionsEstatsRDTO29);

		AccionsEstatsRDTO accionsEstatsRDTO30 = new AccionsEstatsRDTO();
		accionsEstatsRDTO30.setId(ONE);
		accionsEstatsRDTO30.setNomAccio("Digitalitzar un document");
		accionsEstatsRDTO30.setAccio(new BigDecimal(13));
		accionsEstatsRDTOList.add(accionsEstatsRDTO30);

		AccionsEstatsRDTO accionsEstatsRDTO31 = new AccionsEstatsRDTO();
		accionsEstatsRDTO31.setId(ONE);
		accionsEstatsRDTO31.setNomAccio("Obtenir un document per intraoperabilitat");
		accionsEstatsRDTO31.setAccio(new BigDecimal(33));
		accionsEstatsRDTOList.add(accionsEstatsRDTO31);

		AccionsEstatsRDTO accionsEstatsRDTO32 = new AccionsEstatsRDTO();
		accionsEstatsRDTO32.setId(ONE);
		accionsEstatsRDTO32.setNomAccio("Presentar recurs");
		accionsEstatsRDTO32.setAccio(new BigDecimal(6));
		accionsEstatsRDTOList.add(accionsEstatsRDTO32);

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
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte personesDadescontacte = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
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
		configuracioDocsEntrada.setDescripcioAmpliada("Configuraci?? Documentaci?? Entrada");
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
		confDocEntradaRequeritRDTO.setDescripcioAmpliada("Descripci?? Ampliada Doc");
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

	/**
	 * Consultar dades document response.
	 *
	 * @return the docs RDTO
	 */
	public static DocsRDTO consultarDadesDocumentResponse() {
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setId(ONE);
		DocsRDTO docsRDTO = new DocsRDTO();
		docsRDTO.setId(ONE);
		docsRDTO.setDocsFisics(docsFisics);
		docsRDTO.setDocumentacio(ONE);
		docsRDTO.setCodi(ONE.toString());

		return docsRDTO;
	}

	/**
	 * Consultar dades document aportat response.
	 *
	 * @return the docs entrada RDTO
	 */
	public static DocsEntradaRDTO consultarDadesDocumentAportatResponse() {
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
		docsEntradaRDTO.setDeclaracioResponsable(NumberUtils.INTEGER_ZERO);
		docsEntradaRDTO.setDocumentacio(ONE);
		docsEntradaRDTO.setSollicitudIdext(BigDecimal.valueOf(2));

		return docsEntradaRDTO;
	}

	/**
	 * Consultar dades document generat response.
	 *
	 * @return the docs tramitacio RDTO
	 */
	public static DocsTramitacioRDTO consultarDadesDocumentGeneratResponse() {
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		TipusMime tipusMime = new TipusMime();
		tipusMime.setId(INTEGER_ONE);
		docsFisics.setTipusMime(tipusMime);
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(ONE);
		configuracioDocsTramitacio.setNom("Nom");
		ConfDocsTramPolitiquesSig confDocsTramPolitiquesSig = new ConfDocsTramPolitiquesSig();
		confDocsTramPolitiquesSig.setModalitatIdext(new BigDecimal(2));
		DocsSignatures docsSignatures = new DocsSignatures();
		docsSignatures.setTicketPeticio(ONE);
		docsSignatures.setConfDocsTramPolitiquesSigEntity(confDocsTramPolitiquesSig);
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(ONE);
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Nom");
		docsTramitacioRDTO.setOrigen(INTEGER_ONE);
		docsTramitacioRDTO.setDataCreacio(now());
		docsTramitacioRDTO.setDataDigitalitzacio(now());
		docsTramitacioRDTO.setDataUltimaModificacio(now());
		docsTramitacioRDTO.setDocumentacio(ONE);
		docsTramitacioRDTO.setDocsSignaturesPendents(Arrays.asList(docsSignatures));
		docsTramitacioRDTO.setUltimaSignatura(ONE);

		return docsTramitacioRDTO;
	}

	/**
	 * Actualitzar document tramitacio response.
	 *
	 * @return the docs tramitacio RDTO
	 */
	public static DocsTramitacioRDTO actualitzarDocumentTramitacioResponse() {
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(ONE);
		configuracioDocsTramitacio.setNom("Nom");
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(ONE);
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Nom");
		docsTramitacioRDTO.setOrigen(INTEGER_ONE);
		docsTramitacioRDTO.setDataCreacio(now());
		docsTramitacioRDTO.setDataDigitalitzacio(now());
		docsTramitacioRDTO.setDataUltimaModificacio(now());
		docsTramitacioRDTO.setDocumentacio(ONE);

		return docsTramitacioRDTO;
	}

	public static DocsTramitacioRDTO crearDocumentTramitacioDigitalitzatResponse() {
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(ONE);
		configuracioDocsTramitacio.setNom("Nom");
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(ONE);
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Nom");
		docsTramitacioRDTO.setOrigen(INTEGER_ONE);
		docsTramitacioRDTO.setDataCreacio(now());
		docsTramitacioRDTO.setDataDigitalitzacio(now());
		docsTramitacioRDTO.setDataUltimaModificacio(now());
		docsTramitacioRDTO.setDocumentacio(ONE);

		return docsTramitacioRDTO;
	}

	/**
	 * Descarregar document expedient response.
	 *
	 * @return the byte[]
	 */
	public static byte[] descarregarDocumentExpedientResponse() {
		return "prova".getBytes();
	}

	/**
	 * Canviar estat accio expedient response.
	 *
	 * @return the resposta canviar estat accio expedient
	 */
	public static RespostaCanviarEstatAccioExpedient canviarEstatExpedientResponse() {
		RespostaCanviarEstatAccioExpedient respostaCanviarEstatAccioExpedient = new RespostaCanviarEstatAccioExpedient();
		ExpedientCanviarEstat expedientCanviEstat = new ExpedientCanviarEstat();
		expedientCanviEstat.setId(ONE);
		expedientCanviEstat.setCodi("Codi");
		expedientCanviEstat.setEstat("Estat");
		expedientCanviEstat.setEstatCastella("Estat Castell??");
		respostaCanviarEstatAccioExpedient.setExpedient(expedientCanviEstat);
		return respostaCanviarEstatAccioExpedient;
	}

	/**
	 * Cerca historics estats response.
	 *
	 * @return the list
	 */
	public static List<EstatsRDTO> cercaHistoricsEstatsResponse() {
		ArrayList<EstatsRDTO> estatsRDTOList = new ArrayList<EstatsRDTO>();
		EstatsRDTO estatsRDTO1 = new EstatsRDTO();
		estatsRDTO1.setDataCreacio(now());
		estatsRDTO1.setDescripcioEstatActualCiutada("Descripci?? Estat Actual Ciutada");
		estatsRDTO1.setDescripcioEstatActualCiutadaCastella("Descripci?? Estat Actual Ciutada Castell??");
		estatsRDTO1.setDescripcioEstatActualCiutadaCatala("Descripci?? Estat Actual Ciutada Catal??");
		estatsRDTO1.setDescripcioEstatActualTramitador("Descripci?? Estat Actual Tramitador");
		estatsRDTO1.setDescripcioEstatActualTramitadorCastella("Descripci?? Estat Actual Tramitador Castell??");
		estatsRDTO1.setDescripcioEstatActualTramitadorCatala("Descripci?? Estat Actual Tramitador Catal??");
		estatsRDTO1.setDescripcioEstatAnteriorCiutada("Descripci?? Estat Anterior Ciutada");
		estatsRDTO1.setDescripcioEstatAnteriorTramitador("Descripci?? Estat Anterior Tramitador");
		estatsRDTO1.setIdEstatActual(ONE);
		estatsRDTO1.setIdEstatAnterior(ONE);
		estatsRDTOList.add(estatsRDTO1);
		EstatsRDTO estatsRDTO2 = new EstatsRDTO();
		estatsRDTO2.setDataCreacio(now());
		estatsRDTO2.setDescripcioEstatActualCiutada("Descripci?? Estat Actual Ciutada");
		estatsRDTO2.setDescripcioEstatActualCiutadaCastella("Descripci?? Estat Actual Ciutada Castell??");
		estatsRDTO2.setDescripcioEstatActualCiutadaCatala("Descripci?? Estat Actual Ciutada Catal??");
		estatsRDTO2.setDescripcioEstatActualTramitador("Descripci?? Estat Actual Tramitador");
		estatsRDTO2.setDescripcioEstatActualTramitadorCastella("Descripci?? Estat Actual Tramitador Castell??");
		estatsRDTO2.setDescripcioEstatActualTramitadorCatala("Descripci?? Estat Actual Tramitador Catal??");
		estatsRDTO2.setDescripcioEstatAnteriorCiutada("Descripci?? Estat Anterior Ciutada");
		estatsRDTO2.setDescripcioEstatAnteriorTramitador("Descripci?? Estat Anterior Tramitador");
		estatsRDTO2.setIdEstatActual(ONE);
		estatsRDTO2.setIdEstatAnterior(ONE);
		estatsRDTOList.add(estatsRDTO2);
		return estatsRDTOList;
	}

	/**
	 * Crear registre solicitud expedient response.
	 *
	 * @return the resposta crear registre expedient
	 */
	public static RespostaCrearRegistreExpedient crearRegistreSolicitudExpedientResponse() {
		RespostaCrearRegistreExpedient respostaCrearRegistreExpedient = new RespostaCrearRegistreExpedient();
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO registreAssentament = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO();

		registreAssentament.setId(ONE);
		respostaCrearRegistreExpedient.setRegistreAssentament(registreAssentament);

		return respostaCrearRegistreExpedient;
	}

	/**
	 * Gets the plantilla doc vinculada response.
	 *
	 * @return the plantilla doc vinculada response
	 */
	public static RespostaPlantillaDocVinculada getPlantillaDocVinculadaResponse() {
		RespostaPlantillaDocVinculada respostaPlantillaDocVinculada = new RespostaPlantillaDocVinculada();
		respostaPlantillaDocVinculada.setId(ONE);
		respostaPlantillaDocVinculada.setPlantilla("PLANTILLA_GPA");
		return respostaPlantillaDocVinculada;
	}

	/**
	 * Guardar document tramitacio response.
	 *
	 * @return the docs tramitacio RDTO
	 */
	public static DocsTramitacioRDTO guardarDocumentTramitacioResponse() {
		DocsTramitacioRDTO respostaCrearJustificant = new DocsTramitacioRDTO();
		respostaCrearJustificant.setId(ONE);
		return respostaCrearJustificant;
	}

	/**
	 * Guardar document entrada response.
	 *
	 * @return the docs entrada RDTO
	 */
	public static DocsEntradaRDTO guardarDocumentEntradaResponse() {
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

		return docsEntradaRDTO;
	}

	/**
	 * Consultar dades registre assentament response.
	 *
	 * @return the es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.
	 *         registre assentament RDTO
	 */
	public static es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO consultarDadesRegistreAssentamentResponse() {
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO registreAssentament = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO();
		registreAssentament.setId(ONE);
		return registreAssentament;
	}

	/**
	 * Cerca dades operacio requerits response.
	 *
	 * @return the page data of dades operacions RDTO
	 */
	public static PageDataOfDadesOperacionsRDTO cercaDadesOperacioRequeritsResponse() {
		PageDataOfDadesOperacionsRDTO pageDataOfDadesOperacionsRDTO = new PageDataOfDadesOperacionsRDTO();
		ArrayList<DadesOperacionsRDTO> dadesOperacionsRDTOList = new ArrayList<DadesOperacionsRDTO>();
		DadesoperEstatsExp dadesoperEstatsExp = new DadesoperEstatsExp();
		dadesoperEstatsExp.setDadesOperacio(ONE);
		dadesoperEstatsExp.setEstatExpIdext(ONE);
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
		ArrayList<DadesOperTramitsOvt> dadesOperTramitsOvtList = new ArrayList<DadesOperTramitsOvt>();
		DadesOperTramitsOvt dadesOperTramitsOvt = new DadesOperTramitsOvt();
		dadesOperTramitsOvt.setDadaOper(ONE);
		dadesOperTramitsOvt.setTramitOvtIdext(ONE);
		dadesOperTramitsOvtList.add(dadesOperTramitsOvt);
		ArrayList<Items> itemsList = new ArrayList<Items>();
		Items items = new Items();
		items.setDadesOperacions(ONE);
		items.setId(ONE);
		items.setItemDescripcio("Descripci?? Item");
		items.setItemDescripcioCastella("Descripci?? Item en castell??");
		items.setItemId(INTEGER_ONE);
		items.setItemOrdre(INTEGER_ONE);
		itemsList.add(items);

		DadesOperacionsRDTO dadesOperacionsRDTO1 = new DadesOperacionsRDTO();
		dadesOperacionsRDTO1.setCercable(INTEGER_ONE);
		dadesOperacionsRDTO1.setCodi("DO1");
		dadesOperacionsRDTO1.setComentari("Comentari DO");
		dadesOperacionsRDTO1.setDescripcio("Descripci?? DO");
		dadesOperacionsRDTO1.setDesTipusCamp("Num??ric");
		dadesOperacionsRDTO1.setDadesoperEstatsExpList(Arrays.asList(dadesoperEstatsExp));
		dadesOperacionsRDTO1.setGrup(ONE);
		dadesOperacionsRDTO1.setId(ONE);
		dadesOperacionsRDTO1.setOrdre(INTEGER_ONE);
		dadesOperacionsRDTO1.setProcediment(ONE);
		dadesOperacionsRDTO1.setTipus(INTEGER_ONE);
		dadesOperacionsRDTO1.setTitol("T??tol DO");
		dadesOperacionsRDTO1.setTitolGrup("T??tol G1");
		dadesOperacionsRDTO1.setUrlOrigen("URL Origen DO");
		dadesOperacionsRDTO1.setVigent(INTEGER_ONE);
		dadesOperacionsRDTO1.setDadesOperacionsValidacio(dadesOperacionsValidacioList);
		dadesOperacionsRDTO1.setDadesOperTramitsOvtList(dadesOperTramitsOvtList);
		dadesOperacionsRDTO1.setItemsList(itemsList);
		dadesOperacionsRDTOList.add(dadesOperacionsRDTO1);
		DadesOperacionsRDTO dadesOperacionsRDTO2 = new DadesOperacionsRDTO();
		dadesOperacionsRDTO2.setCercable(INTEGER_ONE);
		dadesOperacionsRDTO2.setCodi("DO2");
		dadesOperacionsRDTO2.setComentari("Comentari DO");
		dadesOperacionsRDTO2.setDescripcio("Descripci?? DO");
		dadesOperacionsRDTO2.setDesTipusCamp("Num??ric");
		dadesOperacionsRDTO2.setDadesoperEstatsExpList(Arrays.asList(dadesoperEstatsExp));
		dadesOperacionsRDTO2.setGrup(ONE);
		dadesOperacionsRDTO2.setId(ONE);
		dadesOperacionsRDTO2.setOrdre(INTEGER_ONE);
		dadesOperacionsRDTO2.setProcediment(ONE);
		dadesOperacionsRDTO2.setTipus(INTEGER_ONE);
		dadesOperacionsRDTO2.setTitol("T??tol DO");
		dadesOperacionsRDTO2.setTitolGrup("T??tol G1");
		dadesOperacionsRDTO2.setUrlOrigen("URL Origen DO");
		dadesOperacionsRDTO2.setVigent(INTEGER_ONE);
		dadesOperacionsRDTO2.setDadesOperacionsValidacio(dadesOperacionsValidacioList);
		dadesOperacionsRDTO2.setDadesOperTramitsOvtList(dadesOperTramitsOvtList);
		dadesOperacionsRDTO2.setItemsList(itemsList);
		dadesOperacionsRDTOList.add(dadesOperacionsRDTO2);
		pageDataOfDadesOperacionsRDTO.setData(dadesOperacionsRDTOList);

		return pageDataOfDadesOperacionsRDTO;
	}

	public static PeticionsPortasig crearPeticioPortaSigResponse() {
		return new PeticionsPortasig();
	}

	public static NotificacionsRDTO crearNotificacioResponse() {
		NotificacionsRDTO notificacionsRDTO = new NotificacionsRDTO();
		notificacionsRDTO.setNotificacioId(ONE);
		return notificacionsRDTO;
	}

	public static List<AccionsEstatsRDTO> obtenirTransicionsCanviEstat() {
		List<AccionsEstatsRDTO> accionsEstatsRDTOList = new ArrayList<AccionsEstatsRDTO>();
		AccionsEstatsRDTO accionsEstatsRDTO = new AccionsEstatsRDTO();
		accionsEstatsRDTO.setId(new BigDecimal(1));
		accionsEstatsRDTO.setNomAccio("Accio 1");
		accionsEstatsRDTO.setAccio(new BigDecimal(1));
		accionsEstatsRDTO.setDescTransicio("Transicio 1");
		accionsEstatsRDTO.setEsEstatFinal(0);
		accionsEstatsRDTO.setEsEstatInicial(1);
		accionsEstatsRDTO.setEstat(new BigDecimal(1));
		accionsEstatsRDTO.setEstatTramitador("Estat Tramitador 1");
		accionsEstatsRDTOList.add(accionsEstatsRDTO);

		return accionsEstatsRDTOList;
	}

	/**
	 * Crear comentari accio response.
	 *
	 * @return the expedients RDTO
	 */
	public static Integer crearComentariAccioResponse() {

		return INTEGER_ONE;
	}

	/**
	 * Cerca documents entrada per sollicitud response.
	 *
	 * @return the list
	 */
	public static List<DocsEntradaRDTO> cercaDocumentsEntradaPerSollicitudResponse() {
		ArrayList<DocsEntradaRDTO> docsEntradaRDTOList = new ArrayList<DocsEntradaRDTO>();

		DocsEntradaRDTO docsEntradaRDTO = new DocsEntradaRDTO();
		docsEntradaRDTO.setId(ONE);
		docsEntradaRDTO.setTramitOvtIdext(ONE);
		docsEntradaRDTO.setDataPresentacio(now());
		docsEntradaRDTO.setRevisio(INTEGER_ONE);
		docsEntradaRDTO.setRegistreIdext(ONE);
		docsEntradaRDTO.setDocsFisicsNom("fitxer.pdf");
		docsEntradaRDTO.setSollicitudIdext(BigDecimal.valueOf(2));

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
		documentsIdentitat.setPais("108");
		persones.setDocumentsIdentitat(documentsIdentitat);
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte personesDadescontacte = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PersonesDadescontacte();
		personesDadescontacte.setId(ONE);
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
		configuracioDocsEntrada.setDescripcioAmpliada("Configuraci?? Documentaci?? Entrada");
		docsEntradaRDTO.setConfiguracioDocsEntrada(configuracioDocsEntrada);

		docsEntradaRDTOList.add(docsEntradaRDTO);

		return docsEntradaRDTOList;
	}

	public static List<DadesEspecifiquesRDTO> consultarDadesEspecifiquesSollicitudResponse() {
		ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = new ArrayList<DadesEspecifiquesRDTO>();

		DadesEspecifiquesRDTO dadesEspecifiquesRDTO1 = new DadesEspecifiquesRDTO();
		dadesEspecifiquesRDTO1.setCampIdext(ONE);
		dadesEspecifiquesRDTO1.setExpedient(ONE);
		dadesEspecifiquesRDTO1.setId(ONE);
		dadesEspecifiquesRDTO1.setTipus(ONE);
		ArrayList<DadesEspecifiquesValors> dadesEspecifiquesValorsList1 = new ArrayList<DadesEspecifiquesValors>();
		DadesEspecifiquesValors dadesEspecifiquesValors1 = new DadesEspecifiquesValors();
		dadesEspecifiquesValors1.setId(ONE);
		dadesEspecifiquesValors1.setSollicitud(BigDecimal.valueOf(2));
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
		dadesEspecifiquesValors2.setSollicitud(BigDecimal.valueOf(2));
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
		dadesEspecifiquesValors3.setSollicitud(BigDecimal.valueOf(2));
		ArrayList<Integer> valoresListaMultiple = new ArrayList<Integer>();
		valoresListaMultiple.add(INTEGER_ZERO);
		valoresListaMultiple.add(INTEGER_ONE);
		dadesEspecifiquesValors3.setValorListaMultipleList(valoresListaMultiple);
		dadesEspecifiquesRDTO3.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList3);
		dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO3);

		return dadesEspecifiquesRDTOList;
	}

	/**
	 * Cerca sollicituds response.
	 *
	 * @return the page data of sollicituds RDTO
	 */
	public static PageDataOfSollicitudsRDTO cercaSollicitudsResponse() {
		PageDataOfSollicitudsRDTO pageDataOfSollicitudsRDTO = new PageDataOfSollicitudsRDTO();

		// Data
		ArrayList<SollicitudsRDTO> sollicitudsRDTOList = new ArrayList<SollicitudsRDTO>();
		SollicitudsRDTO sollicitudsRDTO = new SollicitudsRDTO();
		sollicitudsRDTO.setId(ONE);
		sollicitudsRDTO.setDataSollicitud(now());
		sollicitudsRDTO.setDataPresentacio(null);
		sollicitudsRDTO.setExpedient(ONE);
		sollicitudsRDTO.setRegistre(null);
		sollicitudsRDTO.setRegistreAssentament(null);
		sollicitudsRDTO.setTramitOvtIdext(ONE);

		sollicitudsRDTOList.add(sollicitudsRDTO);
		pageDataOfSollicitudsRDTO.setData(sollicitudsRDTOList);

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
		pageDataOfSollicitudsRDTO.setPage(paginationAttributes);

		// SortInfo
		es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo sortInfo = new es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SortInfo();
		sortInfo.setSort("codi");
		sortInfo.setDir("asc");
		pageDataOfSollicitudsRDTO.setSortInfo(sortInfo);

		return pageDataOfSollicitudsRDTO;
	}

	/**
	 * Consultar dades document aportat per codi CSV response.
	 *
	 * @return the docs entrada RDTO
	 */
	public static DocsEntradaRDTO consultarDadesDocumentAportatPerCodiCSVResponse() {
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
		docsEntradaRDTO.setDataCreacio(now());
		docsEntradaRDTO.setDataUltimaModificacio(now());
		docsEntradaRDTO.setDocumentacio(ONE);
		docsEntradaRDTO.setDeclaracioResponsable(NumberUtils.INTEGER_ZERO);

		return docsEntradaRDTO;
	}

	/**
	 * Consultar dades document generat per codi CSV response.
	 *
	 * @return the docs tramitacio RDTO
	 */
	public static DocsTramitacioRDTO consultarDadesDocumentGeneratPerCodiCSVResponse() {
		DocsFisics docsFisics = new DocsFisics();
		docsFisics.setNom("prova.txt");
		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(ONE);
		configuracioDocsTramitacio.setNom("Nom");
		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(ONE);
		docsTramitacioRDTO.setDocsFisics(docsFisics);
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);
		docsTramitacioRDTO.setConfiguracioDocsTramitacioNom("Nom");
		docsTramitacioRDTO.setOrigen(INTEGER_ONE);
		docsTramitacioRDTO.setDataCreacio(now());
		docsTramitacioRDTO.setDataDigitalitzacio(now());
		docsTramitacioRDTO.setDataUltimaModificacio(now());
		docsTramitacioRDTO.setDocumentacio(ONE);

		return docsTramitacioRDTO;
	}

	/**
	 * Consultar estat digitalitzacio response.
	 *
	 * @return the peticions digitalitzacio RDTO
	 */
	public static PeticionsDigitalitzacioRDTO consultarEstatDigitalitzacioResponse() {
		PeticionsDigitalitzacioRDTO peticionsDigitalitzacioRDTO = new PeticionsDigitalitzacioRDTO();
		peticionsDigitalitzacioRDTO.setCodiScan(ONE.toString());
		peticionsDigitalitzacioRDTO.setDocumentsCodi("0907a13480249616,0907a13480249617");
		peticionsDigitalitzacioRDTO.setEstatPeticio(new BigDecimal(2));
		return peticionsDigitalitzacioRDTO;
	}

	/**
	 * Obtenir retorn tramitacio.
	 *
	 * @return the retorn tramitacio
	 */
	public static RetornTramitacio obtenirRetornTramitacio() {
		RetornTramitacio retornTramitacio = new RetornTramitacio();
		retornTramitacio.setEsUsuariPrincipalExpedient(TRUE);
		return retornTramitacio;

	}

	/**
	 * Consultar dades usuari response.
	 *
	 * @return the usuaris RDTO
	 */
	public static UsuarisRDTO consultarDadesUsuariResponse() {
		UsuarisRDTO usuarisRDTO = new UsuarisRDTO();
		usuarisRDTO.setNom("nom");
		usuarisRDTO.setCognom1("cognom1");
		usuarisRDTO.setCognom2("cognom2");
		usuarisRDTO.setDocumentIdentitat("documentIdentitat");
		usuarisRDTO.setId(ONE);

		return usuarisRDTO;
	}

	/**
	 * Consultar unitat organigrama response.
	 *
	 * @return the unitats organigrama RDTO
	 */
	public static UnitatsOrganigramaRDTO consultarUnitatOrganigramaResponse() {
		UnitatsOrganigramaRDTO unitatsOrganigramaRDTO = new UnitatsOrganigramaRDTO();
		unitatsOrganigramaRDTO.setId(ONE);
		unitatsOrganigramaRDTO.setCodi("codi");
		unitatsOrganigramaRDTO.setNom("nom");

		return unitatsOrganigramaRDTO;
	}

	/**
	 * Cerca documents tramitacio comunicats response.
	 *
	 * @return the list
	 */
	public static List<DocsTramitacioRDTO> cercaDocumentsTramitacioComunicatsResponse() {
		ArrayList<DocsTramitacioRDTO> docsTramitacioRDTOList = new ArrayList<DocsTramitacioRDTO>();

		DocsTramitacioRDTO docsTramitacioRDTO = new DocsTramitacioRDTO();
		docsTramitacioRDTO.setId(ONE);
		docsTramitacioRDTO.setDataComunicat(now());
		docsTramitacioRDTO.setDocsFisicsNom("fitxer.pdf");

		ConfiguracioDocsTramitacio configuracioDocsTramitacio = new ConfiguracioDocsTramitacio();
		configuracioDocsTramitacio.setId(ONE);
		configuracioDocsTramitacio.setNom("nom");
		docsTramitacioRDTO.setConfiguracioDocsTramitacio(configuracioDocsTramitacio);

		docsTramitacioRDTOList.add(docsTramitacioRDTO);

		return docsTramitacioRDTOList;
	}

	/**
	 * Preparar signatura criptografica response.
	 *
	 * @return the preparar signatura criptografica document response
	 */
	public static PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaResponse() {
		PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaDocumentResponse = new PrepararSignaturaCriptograficaDocumentResponse();

		prepararSignaturaCriptograficaDocumentResponse.setIdPeticio("1");
		prepararSignaturaCriptograficaDocumentResponse.setUrlSignaturaBrowser("https://urlSignaturaBrowser");

		return prepararSignaturaCriptograficaDocumentResponse;
	}

	/**
	 * Signar criptografica response.
	 *
	 * @return the signar criptografica document response
	 */
	public static SignarCriptograficaDocumentResponse signarCriptograficaResponse() {
		SignarCriptograficaDocumentResponse signarCriptograficaDocumentResponse = new SignarCriptograficaDocumentResponse();
		return signarCriptograficaDocumentResponse;
	}

	/**
	 * Signar valid response.
	 *
	 * @return the signar valid document response
	 */
	public static SignarValidDocumentResponse signarValidResponse() {
		SignarValidDocumentResponse signarValidDocumentResponse = new SignarValidDocumentResponse();
		return signarValidDocumentResponse;
	}

	/**
	 * Consultar signatura response.
	 *
	 * @return the consultar signatura response
	 */
	public static ConsultarSignaturaResponse consultarSignaturaResponse() {
		ConsultarSignaturaResponse consultarSignaturaResponse = new ConsultarSignaturaResponse();
		consultarSignaturaResponse.setIdDocumentSignatGestorDocumental("1");
		return consultarSignaturaResponse;
	}

	/**
	 * Signar segell response.
	 *
	 * @return the signar segell document
	 */
	public static SignarSegellDocument signarSegellResponse() {
		SignarSegellDocument signarSegellDocument = new SignarSegellDocument();
		signarSegellDocument.setIdPeticio("1");
		return signarSegellDocument;
	}

	/**
	 * Consultar dades persona sollicitud response.
	 *
	 * @return the persones sollicitud RDTO
	 */
	public static PersonesSollicitudRDTO consultarDadesPersonaSollicitudResponse() {
		PersonesSollicitudRDTO personesSollicitudRDTO = new PersonesSollicitudRDTO();
		personesSollicitudRDTO.setPersona(ONE);
		Persones persones = new Persones();
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setNumeroDocument("00000000T");
		persones.setDocumentsIdentitat(documentsIdentitat);
		personesSollicitudRDTO.setPersones(persones);

		return personesSollicitudRDTO;
	}

}
