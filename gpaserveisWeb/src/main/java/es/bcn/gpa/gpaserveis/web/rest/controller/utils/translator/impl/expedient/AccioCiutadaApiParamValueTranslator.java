package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioCiutadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class AccioCiutadaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientAccioCiutadaApiParamValueTranslator")
public class AccioCiutadaApiParamValueTranslator extends ApiParamValueTranslator<AccioCiutadaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	// public static final String REQUEST_PARAM_ALLOWABLE_VALUES =
	// "REQUERIMENT_ESMENA, APORTAR_DOCUMENTACIO, ALEGACIONS, RENUNCIA,
	// DESISTIMENT";
	// De momento se eliminan las opciones de RENUNCIA y DESISTIMENT. Se
	// volverán a incorporar cuando se implemente este trámite OVT.
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "REQUERIMENT_ESMENA, APORTAR_DOCUMENTACIO, ALEGACIONS, PRESENTAR_RECURSO";

	/**
	 * Gets the api param value by internal value and internal value id estat
	 * origen.
	 *
	 * @param internalValue
	 *            the internal value
	 * @param internalValueIdEstatOrigen
	 *            the internal value id estat origen
	 * @return the api param value by internal value and internal value id estat
	 *         origen
	 */
	public String getApiParamValueByInternalValueAndInternalValueIdEstatOrigen(BigDecimal internalValue,
	        BigDecimal internalValueIdEstatOrigen) {
		List<AccioCiutadaApiParamValue> accioCiutadaApiParamValueList = getEnumListByInternalValue(internalValue);
		// Pueden existir acciones internas que no tengan correspondencia con
		// ninguna acción de cara al ciudadano
		if (CollectionUtils.isEmpty(accioCiutadaApiParamValueList)) {
			return null;
		} else if (accioCiutadaApiParamValueList.size() == NumberUtils.INTEGER_ONE) {
			return accioCiutadaApiParamValueList.get(NumberUtils.INTEGER_ZERO).getApiParamValue();
		} else {
			for (AccioCiutadaApiParamValue accioCiutadaApiParamValue : accioCiutadaApiParamValueList) {
				if (internalValueIdEstatOrigen
				        .compareTo(accioCiutadaApiParamValue.getInternalValueIdEstatOrigen()) == NumberUtils.INTEGER_ZERO) {
					return accioCiutadaApiParamValue.getApiParamValue();
				}
			}
			return null;
		}
	}

}
