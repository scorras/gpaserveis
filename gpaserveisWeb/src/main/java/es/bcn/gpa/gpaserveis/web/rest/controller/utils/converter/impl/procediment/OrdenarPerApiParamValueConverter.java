package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.ApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.OrdenarPerApiParamValue;

/**
 * The Class OrdenarPerApiParamValueConverter.
 */
@SuppressWarnings("unchecked")
@Component
@Qualifier("ordenarPerApiParamValueConverter")
public class OrdenarPerApiParamValueConverter extends ApiParamValueConverter<OrdenarPerApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "ordenarPer";

	/** The Constant REQUEST_PARAM_DEFAULT_VALUE. */
	public static final String REQUEST_PARAM_DEFAULT_VALUE = "CODI";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "CODI, NOM, ESTAT, TRAMITADOR, DARRERA_MODIFICACIO";

}
