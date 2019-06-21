package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsNotificacionsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

@SuppressWarnings("unchecked")
@Component("documentsTipusEstatsNotificacionsApiParamValueTranslator")
public class TipusEstatsNotificacionsApiParamValueTranslator
		extends ApiParamValueTranslator<TipusEstatsNotificacionsApiParamValue, BigDecimal> {

	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "PENDENT_NOTIFICACIO, REGISTRAT, DISPOSITAT, NOTIFICACIO_VISUALITZADA, NOTIFICACIO_REBUTJADA, NOTIFICACIO_ACCEPTADA, NOTIFICACIO_REBUTJADA_ACCES, NOTIFICACIO_REBUTJADA_ACCIO";

}
