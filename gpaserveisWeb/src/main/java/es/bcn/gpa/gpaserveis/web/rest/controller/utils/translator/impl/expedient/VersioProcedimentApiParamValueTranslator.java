package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.VersioProcedimentApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class VersioProcedimentApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientVersioProcedimentApiParamValueTranslator")
public class VersioProcedimentApiParamValueTranslator extends ApiParamValueTranslator<VersioProcedimentApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "versioProcediment";

	/** The Constant REQUEST_PARAM_DEFAULT_VALUE. */
	public static final String REQUEST_PARAM_DEFAULT_VALUE = "TOTES_LES_VERSIONS";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "TOTES_LES_VERSIONS, DARRERA_VERSIO";

}
