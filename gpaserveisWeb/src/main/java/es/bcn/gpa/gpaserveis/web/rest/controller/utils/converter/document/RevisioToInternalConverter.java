package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class RevisioToInternalConverter.
 */
@Component("revisioToInternalConverter")
public class RevisioToInternalConverter extends AbstractConverter<String, Integer> {

	@Autowired
	@Qualifier("documentRevisioApiParamValueTranslator")
	private BaseApiParamValueTranslator revisioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected Integer convert(String source) {
		return revisioApiParamValueTranslator.getInternalValueByApiParamValue(source);
	}
}