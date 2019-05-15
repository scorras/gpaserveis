package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusCanalComunicacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusCanalComunicacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTipusCanalComunicacioApiParamValueTranslator")
public class TipusCanalComunicacioApiParamValueTranslator extends ApiParamValueTranslator<TipusCanalComunicacioApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "TELEFON, MAIL";

}
