package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class ExpedientsApiParamToInternalMapper.
 */
@Component
public class ExpedientsApiParamToInternalMapper {

	/** The ordenar per api param value translator. */
	private static BaseApiParamValueTranslator ordenarPerApiParamValueTranslator;

	/** The sentit ordenacio api param value translator. */
	private static BaseApiParamValueTranslator sentitOrdenacioApiParamValueTranslator;

	/** The estat api param value translator. */
	private static BaseApiParamValueTranslator estatApiParamValueTranslator;

	/** The tramitador api param value translator. */
	private static BaseApiParamValueTranslator tramitadorApiParamValueTranslator;

	/** The versio procediment api param value translator. */
	private static BaseApiParamValueTranslator versioProcedimentApiParamValueTranslator;

	/**
	 * Instantiates a new expedients api param to internal mapper.
	 *
	 * @param ordenarPerApiParamValueTranslator
	 *            the ordenar per api param value translator
	 * @param sentitOrdenacioApiParamValueTranslator
	 *            the sentit ordenacio api param value translator
	 * @param estatApiParamValueTranslator
	 *            the estat api param value translator
	 * @param tramitadorApiParamValueTranslator
	 *            the tramitador api param value translator
	 * @param versioProcedimentApiParamValueTranslator
	 *            the versio procediment api param value translator
	 */
	@Autowired
	public ExpedientsApiParamToInternalMapper(
	        @Qualifier("expedientOrdenarPerApiParamValueTranslator") BaseApiParamValueTranslator ordenarPerApiParamValueTranslator,
	        @Qualifier("expedientSentitOrdenacioApiParamValueTranslator") BaseApiParamValueTranslator sentitOrdenacioApiParamValueTranslator,
	        @Qualifier("expedientEstatApiParamValueTranslator") BaseApiParamValueTranslator estatApiParamValueTranslator,
	        @Qualifier("expedientTramitadorApiParamValueTranslator") BaseApiParamValueTranslator tramitadorApiParamValueTranslator,
	        @Qualifier("expedientVersioProcedimentApiParamValueTranslator") BaseApiParamValueTranslator versioProcedimentApiParamValueTranslator) {
		ExpedientsApiParamToInternalMapper.ordenarPerApiParamValueTranslator = ordenarPerApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.sentitOrdenacioApiParamValueTranslator = sentitOrdenacioApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.estatApiParamValueTranslator = estatApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.tramitadorApiParamValueTranslator = tramitadorApiParamValueTranslator;
		ExpedientsApiParamToInternalMapper.versioProcedimentApiParamValueTranslator = versioProcedimentApiParamValueTranslator;
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
	 * Gets the estat internal value list.
	 *
	 * @param estat
	 *            the estat
	 * @return the estat internal value list
	 */
	public static List<BigDecimal> getEstatInternalValueList(String[] estat) {
		return estatApiParamValueTranslator.getInternalValueListByApiParamValueList(estat);
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
	public static String getVersioProcedimentInternalValue(String versio) {
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
}
