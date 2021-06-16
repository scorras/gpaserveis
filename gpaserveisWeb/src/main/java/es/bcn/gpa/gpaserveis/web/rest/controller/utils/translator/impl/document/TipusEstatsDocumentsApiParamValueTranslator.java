package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusEstatsDocumentsApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

@SuppressWarnings("unchecked")
@Component("documentsTipusEstatsDocumentsApiParamValueTranslator")
public class TipusEstatsDocumentsApiParamValueTranslator extends ApiParamValueTranslator<TipusEstatsDocumentsApiParamValue, BigDecimal> {
	
	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "EN_ELABORACIO, FINALITZAT, PENDENT_SIGNATURA , SIGNATURA_REBUTJADA, VIST_I_PLAU, SIGNAT, PENDENT_NOTIFICACIO, PENDENT_COMUNICACIO, REGISTRAT, DISPOSITAT, NOTIFICACIO_VISUALITZADA, NOTIFICACIO_REBUTJADA, NOTIFICACIO_ACCEPTADA, SIGNATURA_CADUCADA, PENDENT_VIST_I_PLAU, VIST_I_PLAU_REBUTJAT, VIST_I_PLAU_CADUCAT, NOTIFICACIO_REBUTJADA_SENSE_ACCES, NOTIFICACIO_REBUTJADA_SENSE_ACCIO, PUBLICAT, NOTIFICACIO_AMB_ERROR, COMPLETAT, DESCARTAT";

}
