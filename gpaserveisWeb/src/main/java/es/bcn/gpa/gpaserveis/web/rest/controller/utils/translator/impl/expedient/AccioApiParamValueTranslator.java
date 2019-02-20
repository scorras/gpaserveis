package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class EstatTramitadorApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientAccioApiParamValueTranslator")
public class AccioApiParamValueTranslator extends ApiParamValueTranslator<AccioApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "REQUERIMENT_ESMENA, APORTAR_DOCUMENTACIO, ALEGACIONS, RENUNCIA, DESISTIMENT";

}
