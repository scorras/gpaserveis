package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusViaNotificacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusViaNotificacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTipusViaNotificacioApiParamValueTranslator")
public class TipusViaNotificacioApiParamValueTranslator extends ApiParamValueTranslator<TipusViaNotificacioApiParamValue, Short> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ELECTRONICA, PAPER";

}
