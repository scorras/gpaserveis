package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsNotificacionsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

@SuppressWarnings("unchecked")
@Component("documentsTipusEstatsNotificacionsApiParamValueTranslator")
public class TipusEstatsNotificacionsApiParamValueTranslator
        extends ApiParamValueTranslator<TipusEstatsNotificacionsApiParamValue, BigDecimal> {

	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "Pendent de processar, Registrada, Dipositada, Visualitzada, Rebutjada, Acceptada, Rebutjada sense accés, Rebutjada sense acció, Error";

}
