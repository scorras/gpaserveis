package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatCiutadaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatTramitadorApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.NivellAutenticacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.VersioProcedimentApiParamValueTranslator;

/**
 * The Class ExpedientsApiParamToInternalMapper.
 */
@Component
public class ExpedientsApiParamToInternalMapper {

	/** The Constant CODI_EXPEDIENT_FORMATTED_PATTERN. */
	private static final String CODI_EXPEDIENT_FORMATTED_PATTERN = "(\\d{4})_(EXP_)?(\\d+)";

	/** The Constant CODI_EXPEDIENT_ORIGINAL_FORMAT. */
	private static final String CODI_EXPEDIENT_ORIGINAL_FORMAT = "ES_%s_%s_EXP_%s";

	/** The ordenar per api param value translator. */
	private static BaseApiParamValueTranslator ordenarPerApiParamValueTranslator;

	/** The sentit ordenacio api param value translator. */
	private static BaseApiParamValueTranslator sentitOrdenacioApiParamValueTranslator;

	/** The estat ciutada api param value translator. */
	private static EstatCiutadaApiParamValueTranslator estatCiutadaApiParamValueTranslator;

	/** The estat tramitador api param value translator. */
	private static EstatTramitadorApiParamValueTranslator estatTramitadorApiParamValueTranslator;

	/** The tramitador api param value translator. */
	private static BaseApiParamValueTranslator tramitadorApiParamValueTranslator;

	/** The versio procediment api param value translator. */
	private static VersioProcedimentApiParamValueTranslator versioProcedimentApiParamValueTranslator;

	/** The nivell autenticacio api param value translator. */
	private static NivellAutenticacioApiParamValueTranslator nivellAutenticacioApiParamValueTranslator;

	/**
	 * Instantiates a new expedients api param to internal mapper.
	 *
	 * @param ordenarPerApiParamValueTranslator
	 *            the ordenar per api param value translator
	 * @param sentitOrdenacioApiParamValueTranslator
	 *            the sentit ordenacio api param value translator
	 * @param estatCiutadaApiParamValueTranslator
	 *            the expedient estat tramitador api param value translator
	 * @param tramitadorApiParamValueTranslator
	 *            the tramitador api param value translator
	 * @param versioProcedimentApiParamValueTranslator
	 *            the versio procediment api param value translator
	 */
	@Autowired
	public ExpedientsApiParamToInternalMapper(
			@Qualifier("expedientOrdenarPerApiParamValueTranslator") BaseApiParamValueTranslator ordenarPerApiParamValueTranslator,
			@Qualifier("expedientSentitOrdenacioApiParamValueTranslator") BaseApiParamValueTranslator sentitOrdenacioApiParamValueTranslator,
			@Qualifier("expedientEstatCiutadaApiParamValueTranslator") EstatCiutadaApiParamValueTranslator estatCiutadaApiParamValueTranslator,
			@Qualifier("expedientEstatTramitadorApiParamValueTranslator") EstatTramitadorApiParamValueTranslator estatTramitadorApiParamValueTranslator,
			@Qualifier("expedientTramitadorApiParamValueTranslator") BaseApiParamValueTranslator tramitadorApiParamValueTranslator,
			@Qualifier("expedientVersioProcedimentApiParamValueTranslator") VersioProcedimentApiParamValueTranslator versioProcedimentApiParamValueTranslator,
			@Qualifier("expedientNivellAutenticacioApiParamValueTranslator") NivellAutenticacioApiParamValueTranslator nivellAutenticacioApiParamValueTranslator) {
		ExpedientsApiParamToInternalMapper.ordenarPerApiParamValueTranslator = ordenarPerApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.sentitOrdenacioApiParamValueTranslator = sentitOrdenacioApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.estatCiutadaApiParamValueTranslator = estatCiutadaApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.estatTramitadorApiParamValueTranslator = estatTramitadorApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.tramitadorApiParamValueTranslator = tramitadorApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.versioProcedimentApiParamValueTranslator = versioProcedimentApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.nivellAutenticacioApiParamValueTranslator = nivellAutenticacioApiParamValueTranslator;
	}

	/**
	 * Gets the ordenar per internal value.
	 *
	 * @param ordenarPer
	 *            the ordenar per
	 * @return the ordenar per internal value
	 */
	public static String getOrdenarPerInternalValue(String ordenarPer) {
		return ordenarPerApiParamValueTranslator.getInternalValueByApiParamValue(ordenarPer);
	}

	/**
	 * Gets the sentit ordenacio internal value.
	 *
	 * @param sentitOrdenacio
	 *            the sentit ordenacio
	 * @return the sentit ordenacio internal value
	 */
	public static String getSentitOrdenacioInternalValue(String sentitOrdenacio) {
		return sentitOrdenacioApiParamValueTranslator.getInternalValueByApiParamValue(sentitOrdenacio);
	}

	/**
	 * Gets the codi internal value.
	 *
	 * @param codi
	 *            the codi
	 * @param expedientsIdOrgan
	 *            the expedients id organ
	 * @return the codi internal value
	 */
	public static String getCodiInternalValue(String codi, String expedientsIdOrgan) {
		if (StringUtils.isEmpty(codi)) {
			return codi;
		}

		Pattern codiExpedientFormattedPattern = Pattern.compile(CODI_EXPEDIENT_FORMATTED_PATTERN);
		Matcher codiExpedientFormattedMatcher = codiExpedientFormattedPattern.matcher(codi);
		if (codiExpedientFormattedMatcher.matches()) {
			return String.format(CODI_EXPEDIENT_ORIGINAL_FORMAT, expedientsIdOrgan, codiExpedientFormattedMatcher.group(1),
					StringUtils.leftPad(codiExpedientFormattedMatcher.group(3), 30, "0"));
		} else {
			return codi;
		}
	}

	/**
	 * Gets the data presentacio inici internal value.
	 *
	 * @param dataPresentacioInici
	 *            the data presentacio inici
	 * @return the data presentacio inici internal value
	 */
	public static DateTime getDataPresentacioIniciInternalValue(String dataPresentacioInici) {
		DateTime dataPresentacioIniciDateTime = null;
		if (StringUtils.isNotEmpty(dataPresentacioInici)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
			dataPresentacioIniciDateTime = DateTime.parse(dataPresentacioInici, dateTimeFormatter);
		}
		return dataPresentacioIniciDateTime;
	}

	/**
	 * Gets the data presentacio fi internal value.
	 *
	 * @param dataPresentacioFi
	 *            the data presentacio fi
	 * @return the data presentacio fi internal value
	 */
	public static DateTime getDataPresentacioFiInternalValue(String dataPresentacioFi) {
		DateTime dataPresentacioFiDateTime = null;
		if (StringUtils.isNotEmpty(dataPresentacioFi)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
			dataPresentacioFiDateTime = DateTime.parse(dataPresentacioFi, dateTimeFormatter);
		}
		return dataPresentacioFiDateTime;
	}

	/**
	 * Gets the estat ciutada internal value list.
	 *
	 * @param estatList
	 *            the estat list
	 * @return the estat ciutada internal value list
	 */
	public static List<BigDecimal> getEstatCiutadaInternalValueList(String[] estatList) {
		// Los códigos de ESTAT_CIUTADA se repiten para valores internos, por lo
		// que por cada código se puede obtener una lista de identificadores
		// internos
		ArrayList<BigDecimal> idList = null;
		if (ArrayUtils.isNotEmpty(estatList)) {
			idList = new ArrayList<BigDecimal>();
			for (String estat : estatList) {
				idList.addAll(estatCiutadaApiParamValueTranslator.getInternalValueListByApiParamValue(estat));
			}
		}
		return idList;
	}

	/**
	 * Gets the estat tramitador internal value list.
	 *
	 * @param estatList
	 *            the estat list
	 * @return the estat tramitador internal value list
	 */
	public static List<BigDecimal> getEstatTramitadorInternalValueList(String[] estatList) {
		ArrayList<BigDecimal> idList = null;
		if (ArrayUtils.isNotEmpty(estatList)) {
			idList = new ArrayList<BigDecimal>();
			for (String estat : estatList) {
				idList.addAll(estatTramitadorApiParamValueTranslator.getInternalValueListByApiParamValue(estat));
			}
		}
		return idList;
	}

	/**
	 * Gets the tramitador internal value.
	 *
	 * @param tramitador
	 *            the tramitador
	 * @return the tramitador internal value
	 */
	public static String getTramitadorInternalValue(String tramitador) {
		return tramitadorApiParamValueTranslator.getInternalValueByApiParamValue(tramitador);
	}

	/**
	 * Gets the versio procediment internal value.
	 *
	 * @param versio
	 *            the versio
	 * @return the versio procediment internal value
	 */
	public static BigDecimal getVersioProcedimentInternalValue(String versio) {
		return versioProcedimentApiParamValueTranslator.getInternalValueByApiParamValue(versio);
	}

	/**
	 * Gets the id unitat gestora internal value list.
	 *
	 * @param unitatsGestoresRDTOList
	 *            the unitats gestores RDTO list
	 * @return the id unitat gestora internal value list
	 */
	public static List<BigDecimal> getIdUnitatGestoraInternalValueList(List<UnitatsGestoresRDTO> unitatsGestoresRDTOList) {
		ArrayList<BigDecimal> idUnitatGestoraInternalValueList = null;
		if (CollectionUtils.isNotEmpty(unitatsGestoresRDTOList)) {
			idUnitatGestoraInternalValueList = new ArrayList<BigDecimal>();
			for (UnitatsGestoresRDTO unitatsGestoresRDTO : unitatsGestoresRDTOList) {
				idUnitatGestoraInternalValueList.add(unitatsGestoresRDTO.getId());
			}
		}
		return idUnitatGestoraInternalValueList;
	}

	/**
	 * Gets the codi procediment internal value list.
	 *
	 * @param codiProcediment
	 *            the codi procediment
	 * @return the codi procediment internal value list
	 */
	public static List<String> getCodiProcedimentInternalValueList(String[] codiProcediment) {
		List<String> codiProcedimentInternalValueList = null;
		if (ArrayUtils.isNotEmpty(codiProcediment)) {
			codiProcedimentInternalValueList = Arrays.asList(codiProcediment);
		}
		return codiProcedimentInternalValueList;
	}

	public static Integer getNivellAutenticacioInternalValue(String nivellAutenticacio) {
		return nivellAutenticacioApiParamValueTranslator.getInternalValueByApiParamValue(nivellAutenticacio);
	}
}
