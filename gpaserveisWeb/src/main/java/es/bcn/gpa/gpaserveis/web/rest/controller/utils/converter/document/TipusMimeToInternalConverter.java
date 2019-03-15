package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class TipusMimeToInternalConverter.
 */
@Component("tipusMimeToInternalConverter")
public class TipusMimeToInternalConverter extends AbstractConverter<String, Integer> {

	@Autowired
	@Qualifier("documentTipusMimeApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusMimeApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected Integer convert(String source) {
		return tipusMimeApiParamValueTranslator.getInternalValueByApiParamValue(source);
	}
}