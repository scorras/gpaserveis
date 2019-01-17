package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.ApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitadorApiParamValue;

/**
 * The Class TramitadorApiParamValueConverter.
 */
@SuppressWarnings("unchecked")
@Component
@Qualifier("tramitadorApiParamValueConverter")
public class TramitadorApiParamValueConverter extends ApiParamValueConverter<TramitadorApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "tramitador";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "APLICACIO_DE_NEGOCI, OGE";

}
