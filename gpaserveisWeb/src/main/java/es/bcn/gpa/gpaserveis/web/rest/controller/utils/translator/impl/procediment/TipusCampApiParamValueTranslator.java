package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusCampApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusCampApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentTipusCampApiParamValueTranslator")
public class TipusCampApiParamValueTranslator extends ApiParamValueTranslator<TipusCampApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "NUMERIC, DECIMAL, MONEDA, DATA, DATA_HORA, HORA, TEXT, TEXT_GRAN, LITERAL, LLISTA_SIMPLE, LLISTA_MULTIPLE, MARCADOR, PAIS, PROVINCIA, COMARCA, MUNICIPI";

}
