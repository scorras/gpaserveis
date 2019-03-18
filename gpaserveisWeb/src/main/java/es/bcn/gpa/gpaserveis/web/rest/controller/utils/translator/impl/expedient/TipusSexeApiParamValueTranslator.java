package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusSexeApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusPersonaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTipusSexeApiParamValueTranslator")
public class TipusSexeApiParamValueTranslator extends ApiParamValueTranslator<TipusSexeApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "DONA, HOME, NO_BINARI";

}
