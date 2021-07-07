package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusGrupApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

@SuppressWarnings("unchecked")
@Component("procedimentTipusGrupApiParamValueTranslator")
public class TipusGrupApiParamValueTranslator extends ApiParamValueTranslator<TipusGrupApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SIMPLE, REPETIBLE";

}
