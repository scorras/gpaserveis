package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.MotiuPausaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class MotiuPausaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientMotiuPausaApiParamValueTranslator")
public class MotiuPausaApiParamValueTranslator extends ApiParamValueTranslator<MotiuPausaApiParamValue, String> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "requerimentSubsanacio, tramitAllegacions, notificacioResolucio, requerimentInforme";

}
