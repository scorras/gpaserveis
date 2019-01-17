package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.ApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.ActivableEnFormatElectronicApiParamValue;

/**
 * The Class OrdenarPerApiParamValueConverter.
 */
@SuppressWarnings("unchecked")
@Component
@Qualifier("activableEnFormatElectronicApiParamValueConverter")
public class ActivableEnFormatElectronicApiParamValueConverter
        extends ApiParamValueConverter<ActivableEnFormatElectronicApiParamValue, String> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "activableFormatElectronic";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "PORTAL_TRAMITS, ALTRA_WEB, MOBIL, QUIOSC, PER_CANAL_GENERALISTA, PER_CANAL_ESPECIFIC";

}
