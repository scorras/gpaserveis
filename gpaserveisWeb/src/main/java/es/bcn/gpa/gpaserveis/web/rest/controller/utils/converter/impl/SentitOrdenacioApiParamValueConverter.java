package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.SentitOrdenacioApiParamValue;

@SuppressWarnings("unchecked")
@Component
@Qualifier("sentitOrdenacioApiParamValueConverter")
public class SentitOrdenacioApiParamValueConverter extends ApiParamValueConverter<SentitOrdenacioApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "sentitOrdenacio";

	/** The Constant REQUEST_PARAM_DEFAULT_VALUE. */
	public static final String REQUEST_PARAM_DEFAULT_VALUE = "ASC";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ASC, DESC";

}
