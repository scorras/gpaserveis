package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * The Class InternalToStringListConverter.
 */
@Component("internalToStringListConverter")
public class InternalToStringListConverter extends AbstractConverter<String, List<String>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<String> convert(String source) {
		return (source != null) ? Arrays.asList(StringUtils.split(source, ",")) : null;
	}
}