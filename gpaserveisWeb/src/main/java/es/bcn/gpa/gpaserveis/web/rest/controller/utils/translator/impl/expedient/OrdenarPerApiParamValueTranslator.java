package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.OrdenarPerApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class OrdenarPerApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientOrdenarPerApiParamValueTranslator")
public class OrdenarPerApiParamValueTranslator extends ApiParamValueTranslator<OrdenarPerApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "ordenarPer";

	/** The Constant REQUEST_PARAM_DEFAULT_VALUE. */
	public static final String REQUEST_PARAM_DEFAULT_VALUE = "DARRERA_MODIFICACIO";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "CODI, DATA_PRESENTACIO, SOLLICITANT, DARRERA_MODIFICACIO";

}
