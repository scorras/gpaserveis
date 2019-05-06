package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusDocumentacioVinculadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusDocumentacioVinculadaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("TipusDocumentacioVinculadaApiParamValueTranslator")
public class TipusDocumentacioVinculadaApiParamValueTranslator
		extends ApiParamValueTranslator<TipusDocumentacioVinculadaApiParamValue, String> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "EVIDÈNCIA DE NOTIFICACIÓ, JUSTIFICANT D'AL·LEGACIÓ, JUSTIFICANT D'APORTACIÓ, JUSTIFICANT ESMENA, JUSTIFICANT SOL·LICITUD, NOTIFICACIÓ D'ESMENA";

}
