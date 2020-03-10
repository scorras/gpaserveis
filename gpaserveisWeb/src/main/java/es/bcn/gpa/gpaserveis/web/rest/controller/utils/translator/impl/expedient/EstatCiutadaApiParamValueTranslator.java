package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.EstatCiutadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class EstatCiutadaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientEstatCiutadaApiParamValueTranslator")
public class EstatCiutadaApiParamValueTranslator extends ApiParamValueTranslator<EstatCiutadaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "estat";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ESBORRANY, EN_CURS, PENDENT_ESMENES, PENDENT_ALEGACIONS, RESOLT, TANCAT";

}
