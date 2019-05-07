package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.ConfiguracioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class ConfiguracioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("documentConfiguracioApiParamValueTranslator")
public class ConfiguracioApiParamValueTranslator extends ApiParamValueTranslator<ConfiguracioApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "APORTADA, GENERADA";

}
