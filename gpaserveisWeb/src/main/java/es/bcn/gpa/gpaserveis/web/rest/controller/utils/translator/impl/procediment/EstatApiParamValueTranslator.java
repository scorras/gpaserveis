package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.EstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class EstatApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentEstatApiParamValueTranslator")
public class EstatApiParamValueTranslator extends ApiParamValueTranslator<EstatApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "estat";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "EN_ELABORACIO, FINALITZAT, PUBLICAT";

}
