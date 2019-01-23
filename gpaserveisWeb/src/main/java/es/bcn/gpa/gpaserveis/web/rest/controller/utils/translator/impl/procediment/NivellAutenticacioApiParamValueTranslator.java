package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.NivellAutenticacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class NivellAutenticacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentNivellAutenticacioApiParamValueTranslator")
public class NivellAutenticacioApiParamValueTranslator extends ApiParamValueTranslator<NivellAutenticacioApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ALT, SUBSTANCIAL, BAIX";

}
