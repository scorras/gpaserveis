package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusValidacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusValidacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentTipusValidacioApiParamValueTranslator")
public class TipusValidacioApiParamValueTranslator extends ApiParamValueTranslator<TipusValidacioApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "OBLIGATORI, MENOR, MAJOR, IGUAL, LONGITUD_MAXIMA, MASCARA, MENOR_IGUAL, MAJOR_IGUAL, INTERVAL_TANCAT, INTERVAL_OBERT, URL";

}
