package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToSuportConfeccioConverter.
 */
@Component("internalToSuportConfeccioConverter")
public class InternalToSuportConfeccioConverter extends AbstractConverter<Integer, String> {

	/** The suport confeccio api param value translator. */
	@Autowired
	@Qualifier("procedimentSuportConfeccioApiParamValueTranslator")
	private BaseApiParamValueTranslator suportConfeccioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(Integer source) {
		return suportConfeccioApiParamValueTranslator.getApiParamValueByInternalValue(source);
	}
}