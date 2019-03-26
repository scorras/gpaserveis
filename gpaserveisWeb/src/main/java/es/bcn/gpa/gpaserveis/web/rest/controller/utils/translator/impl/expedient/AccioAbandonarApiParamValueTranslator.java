package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioAbandonarApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class AccioAbandonarApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientAccioAbandonarApiParamValueTranslator")
public class AccioAbandonarApiParamValueTranslator extends ApiParamValueTranslator<AccioAbandonarApiParamValue, String> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "desistir, renunciar";

}
