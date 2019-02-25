package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * The Class InternalToStringConverter.
 */
@Component("internalToStringConverter")
public class InternalToStringConverter extends AbstractConverter<Object, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(Object source) {
		return (source != null) ? source.toString() : null;
	}
}