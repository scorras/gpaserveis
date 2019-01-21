package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.gpaunitats.UnitatsGestoresApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class ApiParamToInternalMapper.
 */
@Component
public class ApiParamToInternalMapper {

	/** The ordenar per api param value translator. */
	private static BaseApiParamValueTranslator ordenarPerApiParamValueTranslator;

	/** The sentit ordenacio api param value translator. */
	private static BaseApiParamValueTranslator sentitOrdenacioApiParamValueTranslator;

	/** The estat api param value translator. */
	private static BaseApiParamValueTranslator estatApiParamValueTranslator;

	/** The tramitador api param value translator. */
	private static BaseApiParamValueTranslator tramitadorApiParamValueTranslator;

	/** The exclusivament intern api param value translator. */
	private static BaseApiParamValueTranslator exclusivamentInternApiParamValueTranslator;

	/** The activable en format electronic api param value translator. */
	private static BaseApiParamValueTranslator activableEnFormatElectronicApiParamValueTranslator;

	/** The competencia associada api param value translator. */
	private static BaseApiParamValueTranslator competenciaAssociadaApiParamValueTranslator;

	/** The familia api param value translator. */
	private static BaseApiParamValueTranslator familiaApiParamValueTranslator;

	/**
	 * Instantiates a new api param to internal mapper.
	 *
	 * @param ordenarPerApiParamValueTranslator
	 *            the ordenar per api param value translator
	 * @param sentitOrdenacioApiParamValueTranslator
	 *            the sentit ordenacio api param value translator
	 * @param estatApiParamValueTranslator
	 *            the estat api param value translator
	 * @param tramitadorApiParamValueTranslator
	 *            the tramitador api param value translator
	 * @param exclusivamentInternApiParamValueTranslator
	 *            the exclusivament intern api param value translator
	 * @param activableEnFormatElectronicApiParamValueTranslator
	 *            the activable en format electronic api param value translator
	 * @param competenciaAssociadaApiParamValueTranslator
	 *            the competencia associada api param value translator
	 * @param familiaApiParamValueTranslator
	 *            the familia api param value translator
	 * @param unitatsGestoresApi
	 *            the unitats gestores api
	 */
	@Autowired
	public ApiParamToInternalMapper(BaseApiParamValueTranslator ordenarPerApiParamValueTranslator,
	        BaseApiParamValueTranslator sentitOrdenacioApiParamValueTranslator, BaseApiParamValueTranslator estatApiParamValueTranslator,
	        BaseApiParamValueTranslator tramitadorApiParamValueTranslator,
	        BaseApiParamValueTranslator exclusivamentInternApiParamValueTranslator,
	        BaseApiParamValueTranslator activableEnFormatElectronicApiParamValueTranslator,
	        BaseApiParamValueTranslator competenciaAssociadaApiParamValueTranslator,
	        BaseApiParamValueTranslator familiaApiParamValueTranslator, UnitatsGestoresApi unitatsGestoresApi) {
		ApiParamToInternalMapper.ordenarPerApiParamValueTranslator = ordenarPerApiParamValueTranslator;
		ApiParamToInternalMapper.sentitOrdenacioApiParamValueTranslator = sentitOrdenacioApiParamValueTranslator;
		ApiParamToInternalMapper.estatApiParamValueTranslator = estatApiParamValueTranslator;
		ApiParamToInternalMapper.tramitadorApiParamValueTranslator = tramitadorApiParamValueTranslator;
		ApiParamToInternalMapper.exclusivamentInternApiParamValueTranslator = exclusivamentInternApiParamValueTranslator;
		ApiParamToInternalMapper.activableEnFormatElectronicApiParamValueTranslator = activableEnFormatElectronicApiParamValueTranslator;
		ApiParamToInternalMapper.competenciaAssociadaApiParamValueTranslator = competenciaAssociadaApiParamValueTranslator;
		ApiParamToInternalMapper.familiaApiParamValueTranslator = familiaApiParamValueTranslator;
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
	public static Integer getTramitadorInternalValue(String tramitador) {
		return tramitadorApiParamValueTranslator.getInternalValueByApiParamValue(tramitador);
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
	 * Gets the exclusivament intern internal value.
	 *
	 * @param exclusivamentIntern
	 *            the exclusivament intern
	 * @return the exclusivament intern internal value
	 */
	public static Integer getExclusivamentInternInternalValue(String exclusivamentIntern) {
		return exclusivamentInternApiParamValueTranslator.getInternalValueByApiParamValue(exclusivamentIntern);
	}

	/**
	 * Gets the activable format electronic internal value list.
	 *
	 * @param activableFormatElectronic
	 *            the activable format electronic
	 * @return the activable format electronic internal value list
	 */
	public static List<String> getActivableFormatElectronicInternalValueList(String[] activableFormatElectronic) {
		return activableEnFormatElectronicApiParamValueTranslator.getInternalValueListByApiParamValueList(activableFormatElectronic);
	}

	/**
	 * Gets the competencia associada internal value list.
	 *
	 * @param competenciaAssociada
	 *            the competencia associada
	 * @return the competencia associada internal value list
	 */
	public static List<BigDecimal> getCompetenciaAssociadaInternalValueList(String[] competenciaAssociada) {
		return competenciaAssociadaApiParamValueTranslator.getInternalValueListByApiParamValueList(competenciaAssociada);
	}

	/**
	 * Gets the familia internal value list.
	 *
	 * @param familia
	 *            the familia
	 * @return the familia internal value list
	 */
	public static List<BigDecimal> getFamiliaInternalValueList(String[] familia) {
		return familiaApiParamValueTranslator.getInternalValueListByApiParamValueList(familia);
	}
}
