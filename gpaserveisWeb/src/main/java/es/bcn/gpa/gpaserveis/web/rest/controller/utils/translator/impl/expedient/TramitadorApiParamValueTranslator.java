package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TramitadorApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTramitadorApiParamValueTranslator")
public class TramitadorApiParamValueTranslator extends ApiParamValueTranslator<TramitadorApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "tramitador";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "APLICACIO_DE_NEGOCI, OGE";

}
