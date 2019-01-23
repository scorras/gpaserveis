package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class InternalToDataPresentacioConverter.
 */
@Component("expedientInternalToDataPresentacioConverter")
public class InternalToDataPresentacioConverter extends AbstractConverter<DateTime, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(DateTime dataPresentacio) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		return dateTimeFormatter.print(dataPresentacio);
	}
}