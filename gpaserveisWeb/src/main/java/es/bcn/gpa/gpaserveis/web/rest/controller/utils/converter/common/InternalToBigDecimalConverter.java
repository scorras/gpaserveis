package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * The Class InternalToBigDecimalConverter.
 */
@Component("internalToBigDecimalConverter")
public class InternalToBigDecimalConverter extends AbstractConverter<Object, BigDecimal> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected BigDecimal convert(Object source) {
		return new BigDecimal(source.toString());
	}
}