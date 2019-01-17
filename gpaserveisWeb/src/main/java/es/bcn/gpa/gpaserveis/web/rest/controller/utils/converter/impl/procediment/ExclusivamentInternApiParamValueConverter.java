package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.ApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.ExclusivamentInternApiParamValue;

/**
 * The Class ExclusivamentInternApiParamValueConverter.
 */
@SuppressWarnings("unchecked")
@Component
@Qualifier("exclusivamentInternApiParamValueConverter")
public class ExclusivamentInternApiParamValueConverter extends ApiParamValueConverter<ExclusivamentInternApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "exclusivamentIntern";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SI, NO";

}
