package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusDadaOperacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

@SuppressWarnings("unchecked")
@Component("procedimentTipusDadaOperacioApiParamValueTranslator")
public class TipusDadaOperacioApiParamValueTranslator extends ApiParamValueTranslator<TipusDadaOperacioApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SIMPLE, REPETIBLE";

}
