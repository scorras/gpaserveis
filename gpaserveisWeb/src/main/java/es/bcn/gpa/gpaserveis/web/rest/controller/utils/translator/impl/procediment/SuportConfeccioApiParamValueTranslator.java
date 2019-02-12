package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.SuportConfeccioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class SuportConfeccioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentSuportConfeccioApiParamValueTranslator")
public class SuportConfeccioApiParamValueTranslator extends ApiParamValueTranslator<SuportConfeccioApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SENSE_SUPORT, GUIA, FORMULARI, PLANTILLA";

}
