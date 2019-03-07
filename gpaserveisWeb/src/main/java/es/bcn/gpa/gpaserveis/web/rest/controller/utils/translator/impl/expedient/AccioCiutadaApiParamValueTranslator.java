package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioCiutadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class AccioCiutadaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientAccioCiutadaApiParamValueTranslator")
public class AccioCiutadaApiParamValueTranslator extends ApiParamValueTranslator<AccioCiutadaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "REQUERIMENT_ESMENA, APORTAR_DOCUMENTACIO, ALEGACIONS, RENUNCIA, DESISTIMENT";

}
