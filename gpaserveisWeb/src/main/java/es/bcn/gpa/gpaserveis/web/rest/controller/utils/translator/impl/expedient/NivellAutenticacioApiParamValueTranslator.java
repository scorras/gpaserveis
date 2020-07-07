package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.NivellAutenticacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class NivellAutenticacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientNivellAutenticacioApiParamValueTranslator")
public class NivellAutenticacioApiParamValueTranslator extends ApiParamValueTranslator<NivellAutenticacioApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "nivellAutenticacio";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ALT, SUBSTANCIAL, BAIX";

}
