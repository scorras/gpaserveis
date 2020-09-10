package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusMimeApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusMimeApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("documentTipusMimeApiParamValueTranslator")
public class TipusMimeApiParamValueTranslator extends ApiParamValueTranslator<TipusMimeApiParamValue, Integer> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "PDF, DOC, DOCX, XLS, XLSX, ZIP, RAR, XML, TXT, PPT, PPTX, ODT, BMP, JPG, GIF, PNG, TIFF, RTF";

}
