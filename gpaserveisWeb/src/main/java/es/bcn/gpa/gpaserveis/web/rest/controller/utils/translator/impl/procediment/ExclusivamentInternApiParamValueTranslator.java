package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.ExclusivamentInternApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class ExclusivamentInternApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentExclusivamentInternApiParamValueTranslator")
public class ExclusivamentInternApiParamValueTranslator extends ApiParamValueTranslator<ExclusivamentInternApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "exclusivamentIntern";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SI, NO";

}
