package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TerminiMaximApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TerminiMaximApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("procedimentTerminiMaximApiParamValueTranslator")
public class TerminiMaximApiParamValueTranslator extends ApiParamValueTranslator<TerminiMaximApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "DIES_HABILS, DIES_NATURALS, MESOS, ANYS, HORES, IMMEDIAT";

}
