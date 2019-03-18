package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.IdiomaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class IdiomaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("documentIdiomaApiParamValueTranslator")
public class IdiomaApiParamValueTranslator extends ApiParamValueTranslator<IdiomaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "CATALA, CASTELLA, ALTRES";

}
