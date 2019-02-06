package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusDocumentIdentitatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusDocumentIdentitatApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTipusDocumentIdentitatApiParamValueTranslator")
public class TipusDocumentIdentitatApiParamValueTranslator
        extends ApiParamValueTranslator<TipusDocumentIdentitatApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "NIF, NIE, PASSAPORT, DOCUMENT_IDENTITAT_ESTRANGER, DOCUMENT_EMPRESA_ESTRANGERA";

}
