package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.PeriodicitatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class PeriodicitatApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentPeriodicitatApiParamValueTranslator")
public class PeriodicitatApiParamValueTranslator extends ApiParamValueTranslator<PeriodicitatApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "CONTINU, ESTACIONAL, PUNTUAL, ESPORADIC";

}
