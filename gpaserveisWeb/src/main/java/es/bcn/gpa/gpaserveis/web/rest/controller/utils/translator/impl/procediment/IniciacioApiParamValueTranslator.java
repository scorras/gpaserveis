package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.IniciacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class IniciacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentIniciacioApiParamValueTranslator")
public class IniciacioApiParamValueTranslator extends ApiParamValueTranslator<IniciacioApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "OFICI, SOL_LICITUD_INTERESSAT, ALTRA_ADMINISTRACIO, ALTRES";

}
