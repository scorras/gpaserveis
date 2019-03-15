package es.bcn.gpa.gpaserveis.web.rest.controller;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.i18n.LocaleContextHolder;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
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
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusCampApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.actualitzar.AtributsActualitzarRDTO;

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
		        .compareTo(EstatApiParamValue.PUBLICAT.getInternalValue()) != NumberUtils.INTEGER_ZERO) {
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
			if (accionsEstatsRDTO.getAccio().compareTo(accioTramitadorApiParamValue.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
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
		if (CollectionUtils.isNotEmpty(dadesOperacio)) {
			dadesEspecifiquesRDTOList = new ArrayList<DadesEspecifiquesRDTO>();
			DadesEspecifiquesRDTO dadesEspecifiquesRDTO = null;
			DadesOperacions dadesOperacions = null;
			ArrayList<DadesEspecifiquesValors> dadesEspecifiquesValorsList = null;
			DadesEspecifiquesValors dadesEspecifiquesValors = null;
			DateTimeFormatter dataFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
			DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			DateTimeFormatter horaFormatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);
			NumberFormat numberFormat = NumberFormat.getInstance(LocaleContextHolder.getLocale());
			for (AtributsActualitzarRDTO atributsActualitzarRDTO : dadesOperacio) {
				if (!dadesOperacionsMap.containsKey(atributsActualitzarRDTO.getCodi())) {
					throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
					        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_FOUND, atributsActualitzarRDTO.getCodi());
				}
				dadesOperacions = dadesOperacionsMap.get(atributsActualitzarRDTO.getCodi());
				dadesEspecifiquesRDTO = new DadesEspecifiquesRDTO();
				dadesEspecifiquesRDTO.setCampIdext(dadesOperacions.getId());
				dadesEspecifiquesRDTO.setExpedient(idExpedient);
				dadesEspecifiquesValorsList = new ArrayList<DadesEspecifiquesValors>();
				dadesEspecifiquesValors = new DadesEspecifiquesValors();
				// TODO Aplicar validaciones
				// TODO Encapsular todo y pasar a un converter, independiente de
				// la validación
				TipusCampApiParamValueTranslator tipusCampApiParamValueTranslator = new TipusCampApiParamValueTranslator();
				TipusCampApiParamValue tipusCampApiParamValue = tipusCampApiParamValueTranslator
				        .getEnumByInternalValue(dadesOperacions.getTipus());
				try {
					switch (tipusCampApiParamValue) {
					case NUMERIC:
						dadesEspecifiquesValors
						        .setValorInteger(Long.valueOf(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO)));
						break;
					case DECIMAL:
						dadesEspecifiquesValors.setValorDouble(
						        numberFormat.parse(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO)).doubleValue());
						break;
					case MONEDA:
						dadesEspecifiquesValors.setValorMoneda(
						        numberFormat.parse(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO)).doubleValue());
						break;
					case DATA:
						dadesEspecifiquesValors.setValorCalendar(
						        DateTime.parse(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO), dataFormatter));
						break;
					case DATA_HORA:
						dadesEspecifiquesValors.setValorCalendar(
						        DateTime.parse(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO), dataHoraFormatter));
						break;
					case HORA:
						dadesEspecifiquesValors.setValorCalendar(
						        DateTime.parse(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO), horaFormatter));
						break;
					case TEXT:
						dadesEspecifiquesValors.setValorString(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO));
						break;
					case TEXT_GRAN:
						dadesEspecifiquesValors.setValorClob(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO));
						break;
					case LITERAL:
						break;
					case LLISTA_SIMPLE:
						dadesEspecifiquesValors
						        .setValorListaSimple(Integer.valueOf(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO)));
						break;
					case LLISTA_MULTIPLE:
						ArrayList<Integer> integerList = new ArrayList<Integer>();
						if (CollectionUtils.isNotEmpty(atributsActualitzarRDTO.getValor())) {
							for (String valor : atributsActualitzarRDTO.getValor()) {
								integerList.add(Integer.valueOf(valor));
							}
						}
						dadesEspecifiquesValors.setValorListaMultipleList(integerList);
						break;
					case MARCADOR:
						dadesEspecifiquesValors
						        .setValorBoolean(Integer.valueOf(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO)));
						break;
					case PAIS:
						dadesEspecifiquesValors.setValorPais(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO));
						break;
					case PROVINCIA:
						dadesEspecifiquesValors.setValorProvincia(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO));
						break;
					case COMARCA:
						dadesEspecifiquesValors.setValorComarca(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO));
						break;
					case MUNICIPI:
						dadesEspecifiquesValors.setValorMunicipi(atributsActualitzarRDTO.getValor().get(NumberUtils.INTEGER_ZERO));
						break;
					default:
						break;
					}
				} catch (Exception e) {
					throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
					        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_INVALID_VALUE,
					        StringUtils.join(atributsActualitzarRDTO.getValor(), ", "), e);
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
		}

		return dadesEspecifiquesRDTOList;
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

		if (docsEntradaRDTO.getDocumentacio().equals(expedientsRDTO.getDocumentacioIdext())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_EXPEDIENT);
		}
	}
}