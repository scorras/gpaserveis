package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.ActivableEnFormatElectronicApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class ActivableEnFormatElectronicApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component
public class ActivableEnFormatElectronicApiParamValueTranslator
        extends ApiParamValueTranslator<ActivableEnFormatElectronicApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "activableFormatElectronic";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "PORTAL_TRAMITS, ALTRA_WEB, MOBIL, QUIOSC, PER_CANAL_GENERALISTA, PER_CANAL_ESPECIFIC";

}
