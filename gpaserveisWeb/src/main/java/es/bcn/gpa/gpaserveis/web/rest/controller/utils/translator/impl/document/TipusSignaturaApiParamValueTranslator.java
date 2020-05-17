package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusSignaturaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class EstatCiutadaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("tipusSignaturaApiParamValueTranslator")
public class TipusSignaturaApiParamValueTranslator extends ApiParamValueTranslator<TipusSignaturaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "tipusSignatura";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "SEGELL, MANUSCRITA, PORTASIGNATURES, IMI_VALID";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES_OFFLINE. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES_OFFLINE = "SEGELL, MANUSCRITA, PORTASIGNATURES";

}
