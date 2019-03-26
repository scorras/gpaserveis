package es.bcn.gpa.gpaserveis.web.rest.controller;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.i18n.LocaleContextHolder;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.EstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusCampApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusValidacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusCampApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusValidacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.DocumentAportatSubstituirRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.actualitzar.AtributsActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.AtributRequeritRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.DocumentRequeritCrearRDTO;

/**
 * The Class ServeisPortalRestControllerValidationHelper.
 */
public class ServeisPortalRestControllerValidationHelper {

	/**
	 * Validate procediment crear solicitud expedient.
	 *
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateProcedimentCrearSolicitudExpedient(DadesProcedimentBDTO dadesProcedimentBDTO)
	        throws GPAApiParamValidationException {
		if (dadesProcedimentBDTO.getProcedimentsRDTO() == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_FOUND);
		}

		if (dadesProcedimentBDTO.getProcedimentsRDTO().getEstatsProcediment().getEstat()
		        .compareTo(EstatApiParamValue.PUBLICAT.getInternalValue()) != INTEGER_ZERO) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_PUBLICAT);
		}
	}

	/**
	 * Validate unitat gestora.
	 *
	 * @param unitatsGestoresRDTO
	 *            the unitats gestores RDTO
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateUnitatGestora(UnitatsGestoresRDTO unitatsGestoresRDTO, DadesProcedimentBDTO dadesProcedimentBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		// La Unitat Gestora debe existir, estar vigente y estar asociada al
		// procedimiento
		if (unitatsGestoresRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_NOT_FOUND);
		}

		if (unitatsGestoresRDTO.getVigent() == INTEGER_ZERO) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_NOT_VIGENT);
		}

		boolean unitatAssociadaProcediment = false;
		unitatAssociadaProcediment = unitatsGestoresRDTO.getId()
		        .compareTo(dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext()) == INTEGER_ZERO;
		if (!unitatAssociadaProcediment && CollectionUtils.isNotEmpty(dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList())) {
			for (ProcedimentsUgos ugo : dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList()) {
				if (unitatsGestoresRDTO.getId().compareTo(ugo.getUgoIdext()) == INTEGER_ZERO) {
					unitatAssociadaProcediment = true;
					break;
				}
			}
		}
		if (!unitatAssociadaProcediment) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_NOT_IN_PROCEDIMENT);
		}
	}

	/**
	 * Validate expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateExpedient(DadesExpedientBDTO dadesExpedientBDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_NOT_FOUND);
		}
	}

	/**
	 * Validate accio disponible expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param accioTramitadorApiParamValue
	 *            the accio tramitador api param value
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateAccioDisponibleExpedient(DadesExpedientBDTO dadesExpedientBDTO,
	        AccioTramitadorApiParamValue accioTramitadorApiParamValue, Resultat resultatError) throws GPAApiParamValidationException {
		for (AccionsEstatsRDTO accionsEstatsRDTO : dadesExpedientBDTO.getAccionsDisponibles()) {
			if (accionsEstatsRDTO.getAccio().compareTo(accioTramitadorApiParamValue.getInternalValue()) == INTEGER_ZERO) {
				return;
			}
		}
		throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACCIO_NOT_AVAILABLE,
		        accioTramitadorApiParamValue.getApiParamValue());
	}

	/**
	 * Validate sollicitant actualitzar solicitud expedient.
	 *
	 * @param sollicitant
	 *            the sollicitant
	 * @param representant
	 *            the representant
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateSollicitantActualitzarSolicitudExpedient(PersonesRDTO sollicitant, PersonesRDTO representant)
	        throws GPAApiParamValidationException {
		if (representant != null && sollicitant == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_SOLLICITANT_REQUIRED);
		}
	}

	/**
	 * Validate dades operacio actualitzar solicitud expedient.
	 *
	 * @param dadesOperacio
	 *            the dades operacio
	 * @param dadesGrupsRDTOList
	 *            the dades grups RDTO list
	 * @param idExpedient
	 *            the id expedient
	 * @return the array list
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static ArrayList<DadesEspecifiquesRDTO> validateDadesOperacioActualitzarSolicitudExpedient(
	        List<AtributsActualitzarRDTO> dadesOperacio, List<DadesGrupsRDTO> dadesGrupsRDTOList, BigDecimal idExpedient)
	        throws GPAApiParamValidationException {
		ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
		HashMap<String, List<String>> atributsMap = new HashMap<String, List<String>>();
		if (CollectionUtils.isNotEmpty(dadesOperacio)) {
			for (AtributsActualitzarRDTO atributsActualitzarRDTO : dadesOperacio) {
				atributsMap.put(atributsActualitzarRDTO.getCodi(), atributsActualitzarRDTO.getValor());
			}
			dadesEspecifiquesRDTOList = validateDadesOperacio(atributsMap, dadesGrupsRDTOList, idExpedient);
		}
		return dadesEspecifiquesRDTOList;
	}

	/**
	 * Validate dades operacio esmenar expedient.
	 *
	 * @param dadesOperacio
	 *            the dades operacio
	 * @param dadesGrupsRDTOList
	 *            the dades grups RDTO list
	 * @param idExpedient
	 *            the id expedient
	 * @return the array list
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static ArrayList<DadesEspecifiquesRDTO> validateDadesOperacioEsmenarExpedient(List<AtributRequeritRDTO> dadesOperacio,
	        List<DadesGrupsRDTO> dadesGrupsRDTOList, BigDecimal idExpedient) throws GPAApiParamValidationException {
		ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
		HashMap<String, List<String>> atributsMap = new HashMap<String, List<String>>();
		if (CollectionUtils.isNotEmpty(dadesOperacio)) {
			for (AtributRequeritRDTO atributRequeritRDTO : dadesOperacio) {
				atributsMap.put(atributRequeritRDTO.getCodi(), atributRequeritRDTO.getValor());
			}
			dadesEspecifiquesRDTOList = validateDadesOperacio(atributsMap, dadesGrupsRDTOList, idExpedient);
		}
		return dadesEspecifiquesRDTOList;
	}

	/**
	 * Validate dades operacio.
	 *
	 * @param atributsMap
	 *            the atributs map
	 * @param dadesGrupsRDTOList
	 *            the dades grups RDTO list
	 * @param idExpedient
	 *            the id expedient
	 * @return the array list
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static ArrayList<DadesEspecifiquesRDTO> validateDadesOperacio(Map<String, List<String>> atributsMap,
	        List<DadesGrupsRDTO> dadesGrupsRDTOList, BigDecimal idExpedient) throws GPAApiParamValidationException {
		ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;

		HashMap<String, DadesOperacions> dadesOperacionsMap = new HashMap<String, DadesOperacions>();
		if (CollectionUtils.isNotEmpty(dadesGrupsRDTOList)) {
			for (DadesGrupsRDTO dadesGrupsRDTO : dadesGrupsRDTOList) {
				if (CollectionUtils.isNotEmpty(dadesGrupsRDTO.getDadesOperacionsList())) {
					for (DadesOperacions dadesOperacions : dadesGrupsRDTO.getDadesOperacionsList()) {
						dadesOperacionsMap.put(dadesOperacions.getCodi(), dadesOperacions);
					}
				}
			}
		}
		dadesEspecifiquesRDTOList = new ArrayList<DadesEspecifiquesRDTO>();
		DadesEspecifiquesRDTO dadesEspecifiquesRDTO = null;
		DadesOperacions dadesOperacions = null;
		ArrayList<DadesEspecifiquesValors> dadesEspecifiquesValorsList = null;
		DadesEspecifiquesValors dadesEspecifiquesValors = null;
		DateTimeFormatter dataFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		DateTimeFormatter horaFormatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);
		NumberFormat numberFormat = NumberFormat.getInstance(LocaleContextHolder.getLocale());
		TipusCampApiParamValueTranslator tipusCampApiParamValueTranslator = new TipusCampApiParamValueTranslator();
		TipusCampApiParamValue tipusCampApiParamValue = null;
		for (Entry<String, List<String>> atributEntry : atributsMap.entrySet()) {
			if (!dadesOperacionsMap.containsKey(atributEntry.getKey())) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_FOUND, atributEntry.getKey());
			}
			dadesOperacions = dadesOperacionsMap.get(atributEntry.getKey());
			dadesEspecifiquesRDTO = new DadesEspecifiquesRDTO();
			dadesEspecifiquesRDTO.setCampIdext(dadesOperacions.getId());
			dadesEspecifiquesRDTO.setExpedient(idExpedient);
			dadesEspecifiquesRDTO.setNou(INTEGER_ONE);
			dadesEspecifiquesValorsList = new ArrayList<DadesEspecifiquesValors>();
			dadesEspecifiquesValors = new DadesEspecifiquesValors();
			tipusCampApiParamValue = tipusCampApiParamValueTranslator.getEnumByInternalValue(dadesOperacions.getTipus());
			try {
				switch (tipusCampApiParamValue) {
				case NUMERIC:
					Long valorInteger = Long.valueOf(atributEntry.getValue().get(INTEGER_ZERO));
					validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorInteger));
					dadesEspecifiquesValors.setValorInteger(valorInteger);
					break;
				case DECIMAL:
					Double valorDouble = numberFormat.parse(atributEntry.getValue().get(INTEGER_ZERO)).doubleValue();
					validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorDouble));
					dadesEspecifiquesValors.setValorDouble(valorDouble);
					break;
				case MONEDA:
					Double valorMoneda = numberFormat.parse(atributEntry.getValue().get(INTEGER_ZERO)).doubleValue();
					validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorMoneda));
					dadesEspecifiquesValors.setValorMoneda(valorMoneda);
					break;
				case DATA:
					DateTime valorData = DateTime.parse(atributEntry.getValue().get(INTEGER_ZERO), dataFormatter);
					validateDadesOperacioDataGeneral(dadesOperacions, valorData, tipusCampApiParamValue);
					dadesEspecifiquesValors.setValorCalendar(valorData);
					break;
				case DATA_HORA:
					DateTime valorDataHora = DateTime.parse(atributEntry.getValue().get(INTEGER_ZERO), dataHoraFormatter);
					validateDadesOperacioDataGeneral(dadesOperacions, valorDataHora, tipusCampApiParamValue);
					dadesEspecifiquesValors.setValorCalendar(valorDataHora);
					break;
				case HORA:
					DateTime valorHora = DateTime.parse(atributEntry.getValue().get(INTEGER_ZERO), horaFormatter);
					validateDadesOperacioDataGeneral(dadesOperacions, valorHora, tipusCampApiParamValue);
					dadesEspecifiquesValors.setValorCalendar(valorHora);
					break;
				case TEXT:
					String valorText = atributEntry.getValue().get(INTEGER_ZERO);
					validateDadesOperacioCadenaGeneral(dadesOperacions, valorText);
					dadesEspecifiquesValors.setValorString(valorText);
					break;
				case TEXT_GRAN:
					String valorTextGran = atributEntry.getValue().get(INTEGER_ZERO);
					validateDadesOperacioCadenaGeneral(dadesOperacions, valorTextGran);
					dadesEspecifiquesValors.setValorClob(valorTextGran);
					break;
				case LITERAL:
					break;
				case LLISTA_SIMPLE:
					Integer valorLlistaSimple = Integer.valueOf(atributEntry.getValue().get(INTEGER_ZERO));
					validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorLlistaSimple));
					dadesEspecifiquesValors.setValorListaSimple(valorLlistaSimple);
					break;
				case LLISTA_MULTIPLE:
					ArrayList<Integer> integerList = new ArrayList<Integer>();
					if (CollectionUtils.isNotEmpty(atributEntry.getValue())) {
						for (String valor : atributEntry.getValue()) {
							integerList.add(Integer.valueOf(valor));
						}
					}
					dadesEspecifiquesValors.setValorListaMultipleList(integerList);
					break;
				case MARCADOR:
					dadesEspecifiquesValors.setValorBoolean(Integer.valueOf(atributEntry.getValue().get(INTEGER_ZERO)));
					break;
				case PAIS:
					String valorPais = atributEntry.getValue().get(INTEGER_ZERO);
					validateDadesOperacioCadenaGeneral(dadesOperacions, valorPais);
					dadesEspecifiquesValors.setValorPais(valorPais);
					break;
				case PROVINCIA:
					String valorProvincia = atributEntry.getValue().get(INTEGER_ZERO);
					validateDadesOperacioCadenaGeneral(dadesOperacions, valorProvincia);
					dadesEspecifiquesValors.setValorProvincia(valorProvincia);
					break;
				case COMARCA:
					String valorComarca = atributEntry.getValue().get(INTEGER_ZERO);
					validateDadesOperacioCadenaGeneral(dadesOperacions, valorComarca);
					dadesEspecifiquesValors.setValorComarca(valorComarca);
					break;
				case MUNICIPI:
					String valorMunicipi = atributEntry.getValue().get(INTEGER_ZERO);
					validateDadesOperacioCadenaGeneral(dadesOperacions, valorMunicipi);
					dadesEspecifiquesValors.setValorMunicipi(valorMunicipi);
					break;
				default:
					break;
				}
			} catch (GPAApiParamValidationException e) {
				throw e;
			} catch (Exception e) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_CORRECT_VALUE, StringUtils.join(atributEntry.getValue(), ", "), e);
			}

			if (CollectionUtils.isNotEmpty(dadesEspecifiquesValors.getValorListaMultipleList())) {
				DadesEspecifiquesValors dadesEspecifiquesValorsListaMultiple = null;
				for (Integer valor : dadesEspecifiquesValors.getValorListaMultipleList()) {
					dadesEspecifiquesValorsListaMultiple = new DadesEspecifiquesValors();
					dadesEspecifiquesValorsListaMultiple.setValorListaMultiple(valor);
					dadesEspecifiquesValorsList.add(dadesEspecifiquesValorsListaMultiple);
				}
			} else {
				dadesEspecifiquesValorsList.add(dadesEspecifiquesValors);
			}
			dadesEspecifiquesRDTO.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList);
			dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO);
		}

		return dadesEspecifiquesRDTOList;
	}

	/**
	 * Validate dades operacio numeric general.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param valor
	 *            the valor
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 * @throws ParseException
	 *             the parse exception
	 */
	private static void validateDadesOperacioNumericGeneral(DadesOperacions dadesOperacions, BigDecimal valor)
	        throws GPAApiParamValidationException, ParseException {
		NumberFormat numberFormat = NumberFormat.getInstance(LocaleContextHolder.getLocale());
		TipusValidacioApiParamValueTranslator tipusValidacioApiParamValueTranslator = new TipusValidacioApiParamValueTranslator();
		TipusValidacioApiParamValue tipusValidacioApiParamValue = null;
		boolean valid = true;
		for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
			tipusValidacioApiParamValue = tipusValidacioApiParamValueTranslator
			        .getEnumByInternalValue(dadesOperacionsValidacio.getTipusValidacio());
			DadesOperValidVal dadesOperValidVal0 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ZERO);
			BigDecimal validVal0 = new BigDecimal(numberFormat.parse(dadesOperValidVal0.getValor()).toString());
			DadesOperValidVal dadesOperValidVal1 = null;
			BigDecimal validVal1 = null;
			BigDecimal[] validValArray = null;
			if (dadesOperacionsValidacio.getDadesOperacionsValidValors().size() > INTEGER_ONE) {
				// Es necesario comprobar la validación atendiendo al ordre
				dadesOperValidVal1 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ONE);
				validVal1 = new BigDecimal(dadesOperValidVal1.getValor());
				if (dadesOperValidVal0.getOrdre().longValue() < dadesOperValidVal1.getOrdre().longValue()) {
					validValArray = new BigDecimal[] { validVal0, validVal1 };
				} else {
					validValArray = new BigDecimal[] { validVal1, validVal0 };
				}
			}
			switch (tipusValidacioApiParamValue) {
			case OBLIGATORI:
				valid = valor != null;
				break;
			case MENOR:
				valid = valor.compareTo(validVal0) < INTEGER_ZERO;
				break;
			case MAJOR:
				valid = valor.compareTo(validVal0) > INTEGER_ZERO;
				break;
			case IGUAL:
				valid = valor.compareTo(validVal0) == INTEGER_ZERO;
				break;
			case MENOR_IGUAL:
				valid = valor.compareTo(validVal0) <= INTEGER_ZERO;
				break;
			case MAJOR_IGUAL:
				valid = valor.compareTo(validVal0) >= INTEGER_ZERO;
				break;
			case INTERVAL_TANCAT:
				valid = valor.compareTo(validValArray[0]) >= INTEGER_ZERO && valor.compareTo(validValArray[1]) <= INTEGER_ZERO;
				break;
			case INTERVAL_OBERT:
				valid = valor.compareTo(validValArray[0]) > INTEGER_ZERO && valor.compareTo(validValArray[1]) < INTEGER_ZERO;
				break;
			case URL:
				// TODO Aún no tenemos mecanismo para la validación contra URL
				break;
			default:
				break;
			}

			if (!valid) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE, String.valueOf(valor));
			}
		}
	}

	/**
	 * Validate dades operacio data general.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param valor
	 *            the valor
	 * @param tipusCampApiParamValue
	 *            the tipus camp api param value
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static void validateDadesOperacioDataGeneral(DadesOperacions dadesOperacions, DateTime valor,
	        TipusCampApiParamValue tipusCampApiParamValue) throws GPAApiParamValidationException {
		TipusValidacioApiParamValueTranslator tipusValidacioApiParamValueTranslator = new TipusValidacioApiParamValueTranslator();
		TipusValidacioApiParamValue tipusValidacioApiParamValue = null;
		DateTimeFormatter formatter = null;
		DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		switch (tipusCampApiParamValue) {
		case DATA:
			formatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
			break;
		case DATA_HORA:
			formatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			break;
		case HORA:
			formatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);
			break;
		default:
			formatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			break;
		}
		boolean valid = true;
		for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
			tipusValidacioApiParamValue = tipusValidacioApiParamValueTranslator
			        .getEnumByInternalValue(dadesOperacionsValidacio.getTipusValidacio());
			DadesOperValidVal dadesOperValidVal0 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ZERO);
			DateTime validVal0 = dataHoraFormatter.parseDateTime(dadesOperValidVal0.getValor().split(",")[0]);
			validVal0 = formatter.parseDateTime(formatter.print(validVal0));
			DadesOperValidVal dadesOperValidVal1 = null;
			DateTime validVal1 = null;
			DateTime[] validValArray = null;
			if (dadesOperacionsValidacio.getDadesOperacionsValidValors().size() > INTEGER_ONE) {
				// Es necesario comprobar la validación atendiendo al ordre
				dadesOperValidVal1 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ONE);
				validVal1 = dataHoraFormatter.parseDateTime(dadesOperValidVal1.getValor().split(",")[0]);
				validVal1 = formatter.parseDateTime(formatter.print(validVal1));
				if (dadesOperValidVal0.getOrdre().longValue() < dadesOperValidVal1.getOrdre().longValue()) {
					validValArray = new DateTime[] { validVal0, validVal1 };
				} else {
					validValArray = new DateTime[] { validVal1, validVal0 };
				}
			}
			switch (tipusValidacioApiParamValue) {
			case OBLIGATORI:
				valid = valor != null;
				break;
			case MENOR:
				valid = valor.isBefore(validVal0);
				break;
			case MAJOR:
				valid = valor.isAfter(validVal0);
				break;
			case IGUAL:
				valid = valor.isEqual(validVal0);
				break;
			case MENOR_IGUAL:
				valid = (valor.isBefore(validVal0) || valor.isEqual(validVal0));
				break;
			case MAJOR_IGUAL:
				valid = (valor.isAfter(validVal0) || valor.isEqual(validVal0));
				break;
			case INTERVAL_TANCAT:
				valid = (valor.isAfter(validValArray[0]) || valor.isEqual(validValArray[0]))
				        && (valor.isBefore(validValArray[1]) || valor.isEqual(validValArray[1]));
				break;
			case INTERVAL_OBERT:
				valid = (valor.isAfter(validValArray[0]) && valor.isBefore(validValArray[1]));
				break;
			case URL:
				// TODO Aún no tenemos mecanismo para la validación contra URL
				break;
			default:
				break;
			}

			if (!valid) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE, formatter.print(valor));
			}
		}
	}

	/**
	 * Validate dades operacio cadena general.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param valor
	 *            the valor
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static void validateDadesOperacioCadenaGeneral(DadesOperacions dadesOperacions, String valor)
	        throws GPAApiParamValidationException {
		TipusValidacioApiParamValueTranslator tipusValidacioApiParamValueTranslator = new TipusValidacioApiParamValueTranslator();
		TipusValidacioApiParamValue tipusValidacioApiParamValue = null;
		boolean valid = true;
		for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
			tipusValidacioApiParamValue = tipusValidacioApiParamValueTranslator
			        .getEnumByInternalValue(dadesOperacionsValidacio.getTipusValidacio());
			DadesOperValidVal dadesOperValidVal = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ZERO);
			String validVal = dadesOperValidVal.getValor();
			switch (tipusValidacioApiParamValue) {
			case OBLIGATORI:
				valid = StringUtils.isNotEmpty(valor);
				break;
			case IGUAL:
				valid = StringUtils.equals(valor, validVal);
				break;
			case LONGITUD_MAXIMA:
				valid = valor.length() <= Long.valueOf(validVal).longValue();
				break;
			case MASCARA:
				// TODO Pendiente de formato para las máscaras
				break;
			case URL:
				// TODO Aún no tenemos mecanismo para la validación contra URL
				break;
			default:
				break;
			}

			if (!valid) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE, String.valueOf(valor));
			}
		}
	}

	/**
	 * Validate document aportat.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param expedientsRDTO
	 *            the expedients RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentAportat(DocsEntradaRDTO docsEntradaRDTO, ExpedientsRDTO expedientsRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (docsEntradaRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND);
		}

		if (!docsEntradaRDTO.getDocumentacio().equals(expedientsRDTO.getDocumentacioIdext())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_EXPEDIENT);
		}
	}

	/**
	 * Validate configuracio documentacio aportada.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentAportatCrearRDTOList
	 *            the document aportat crear RDTO list
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateConfiguracioDocumentacioAportada(List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        List<DocumentAportatCrearRDTO> documentAportatCrearRDTOList, Resultat resultatError) throws GPAApiParamValidationException {
		if (CollectionUtils.isNotEmpty(documentAportatCrearRDTOList)) {
			ArrayList<String> idConfiguracioDocumentacioList = new ArrayList<String>();
			for (DocumentAportatCrearRDTO documentAportatCrearRDTO : documentAportatCrearRDTOList) {
				idConfiguracioDocumentacioList.add(documentAportatCrearRDTO.getConfiguracioDocumentacio());
			}
			validateConfiguracioDocumentacio(configuracioDocsEntradaRDTOList, idConfiguracioDocumentacioList, resultatError);
		}
	}

	/**
	 * Validate configuracio documentacio substituir.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentAportatSubstituirRDTO
	 *            the document aportat substituir RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateConfiguracioDocumentacioSubstituir(List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        DocumentAportatSubstituirRDTO documentAportatSubstituirRDTO, Resultat resultatError) throws GPAApiParamValidationException {
		if (documentAportatSubstituirRDTO != null) {
			validateConfiguracioDocumentacio(configuracioDocsEntradaRDTOList,
			        Arrays.asList(documentAportatSubstituirRDTO.getConfiguracioDocumentacio()), resultatError);
		}
	}

	/**
	 * Validate configuracio documentacio esmenar.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentRequeritCrearRDTOList
	 *            the document requerit crear RDTO list
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateConfiguracioDocumentacioEsmenar(List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        List<DocumentRequeritCrearRDTO> documentRequeritCrearRDTOList, Resultat resultatError) throws GPAApiParamValidationException {
		if (CollectionUtils.isNotEmpty(documentRequeritCrearRDTOList)) {
			ArrayList<String> idConfiguracioDocumentacioList = new ArrayList<String>();
			for (DocumentRequeritCrearRDTO documentRequeritCrearRDTO : documentRequeritCrearRDTOList) {
				idConfiguracioDocumentacioList.add(documentRequeritCrearRDTO.getConfiguracioDocumentacio());
			}
			validateConfiguracioDocumentacio(configuracioDocsEntradaRDTOList, idConfiguracioDocumentacioList, resultatError);
		}
	}

	/**
	 * Validate configuracio documentacio.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param idConfiguracioDocumentacioList
	 *            the id configuracio documentacio list
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static void validateConfiguracioDocumentacio(List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        List<String> idConfiguracioDocumentacioList, Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<String, ConfiguracioDocsEntradaRDTO>();
		for (ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO : configuracioDocsEntradaRDTOList) {
			configuracioDocsEntradaRDTOMap.put(String.valueOf(configuracioDocsEntradaRDTO.getId()), configuracioDocsEntradaRDTO);
		}

		for (String idConfiguracioDocumentacio : idConfiguracioDocumentacioList) {
			if (!configuracioDocsEntradaRDTOMap.containsKey(idConfiguracioDocumentacio)) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_CONFIGURACIO_DOCUMENTACIO_NOT_IN_EXPEDIENT,
				        idConfiguracioDocumentacio);
			}
		}
	}
}