package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;

/**
 * The Class InternalToEstatSollicitudConverter.
 */
@Component("internalToEstatSollicitudConverter")
public class InternalToEstatSollicitudConverter extends AbstractConverter<BigDecimal,String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(BigDecimal source) {
		return ConverterHelper.getEstatSollicitudByIdRegistre(source);
	}
}