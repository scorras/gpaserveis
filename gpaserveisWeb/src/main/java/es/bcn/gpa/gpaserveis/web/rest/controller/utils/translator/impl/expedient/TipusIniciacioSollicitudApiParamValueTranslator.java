package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusIniciacioSollicitudApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusIniciacioSollicitudApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTipusIniciacioSollicitudApiParamValueTranslator")
public class TipusIniciacioSollicitudApiParamValueTranslator extends ApiParamValueTranslator<TipusIniciacioSollicitudApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "OFICI, SOLLICITUD, ALTRA_ADMINISTRACIO";

}
