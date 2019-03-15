package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class IdiomaToInternalConverter.
 */
@Component("idiomaToInternalConverter")
public class IdiomaToInternalConverter extends AbstractConverter<String, BigDecimal> {

	@Autowired
	@Qualifier("documentIdiomaApiParamValueTranslator")
	private BaseApiParamValueTranslator idiomaApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected BigDecimal convert(String source) {
		return idiomaApiParamValueTranslator.getInternalValueByApiParamValue(source);
	}
}