package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusPersonaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientRelacioPersonaApiParamValueTranslator")
public class RelacioPersonaApiParamValueTranslator extends ApiParamValueTranslator<RelacioPersonaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SOLLICITANT, REPRESENTANT";

}
