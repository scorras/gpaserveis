package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.SentitOrdenacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class SentitOrdenacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientSentitOrdenacioApiParamValueTranslator")
public class SentitOrdenacioApiParamValueTranslator extends ApiParamValueTranslator<SentitOrdenacioApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "sentitOrdenacio";

	/** The Constant REQUEST_PARAM_DEFAULT_VALUE. */
	public static final String REQUEST_PARAM_DEFAULT_VALUE = "DESC";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ASC, DESC";

}
