package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToEstatDigitalitzacioConverter.
 */
@Component("documentInternalToEstatDigitalitzacioConverter")
public class InternalToEstatDigitalitzacioConverter extends AbstractConverter<BigDecimal, String> {

	@Autowired
	@Qualifier("documentEstatDigitalitzacioApiParamValueTranslator")
	private BaseApiParamValueTranslator estatDigitalitzacioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(BigDecimal source) {
		return estatDigitalitzacioApiParamValueTranslator.getApiParamValueByInternalValue(source);
	}
}