package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToEstatConverter.
 */
@Component("procedimentInternalToEstatConverter")
public class InternalToEstatConverter extends AbstractConverter<BigDecimal, String> {

	/** The estat api param value translator. */
	@Autowired
	@Qualifier("procedimentEstatApiParamValueTranslator")
	private BaseApiParamValueTranslator estatApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(BigDecimal source) {
		return estatApiParamValueTranslator.getApiParamValueByInternalValue(source);
	}
}