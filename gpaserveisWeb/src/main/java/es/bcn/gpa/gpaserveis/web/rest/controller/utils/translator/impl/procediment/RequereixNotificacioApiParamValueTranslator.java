package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.RequereixNotificacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class IniciacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentRequereixNotificacioApiParamValueTranslator")
public class RequereixNotificacioApiParamValueTranslator extends ApiParamValueTranslator<RequereixNotificacioApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SENSE NOTIFICACIO, NOTIFICACIONS ELECTRONIQUES I EN PAPER, NOTIFICACIONS ELECTRONIQUES, NOTIFICACIONS EN PAPER";

}
