package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsNotificacionsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

@SuppressWarnings("unchecked")
@Component("documentsTipusEstatsNotificacionsApiParamValueTranslator")
public class TipusEstatsNotificacionsApiParamValueTranslator
		extends ApiParamValueTranslator<TipusEstatsNotificacionsApiParamValue, BigDecimal> {

}
