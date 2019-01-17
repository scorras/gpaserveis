package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.procediment;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.impl.ApiParamValueConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.EstatApiParamValue;

/**
 * The Class OrdenarPerApiParamValueConverter.
 */
@SuppressWarnings("unchecked")
@Component
@Qualifier("estatApiParamValueConverter")
public class EstatApiParamValueConverter extends ApiParamValueConverter<EstatApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "estat";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "EN_ELABORACIO, FINALITZAT, PUBLICAT";

}
