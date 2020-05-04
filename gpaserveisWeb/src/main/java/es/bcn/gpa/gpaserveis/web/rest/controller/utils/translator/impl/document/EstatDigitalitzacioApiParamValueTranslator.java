package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.EstatDigitalitzacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class EstatDigitalitzacioApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("documentEstatDigitalitzacioApiParamValueTranslator")
public class EstatDigitalitzacioApiParamValueTranslator extends ApiParamValueTranslator<EstatDigitalitzacioApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "OK, KO";

}
