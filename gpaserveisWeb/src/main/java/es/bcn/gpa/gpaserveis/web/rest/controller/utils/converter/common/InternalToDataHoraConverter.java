package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class InternalToDataHoraConverter.
 */
@Component("internalToDataHoraConverter")
public class InternalToDataHoraConverter extends AbstractConverter<DateTime, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(DateTime dateTime) {
		String dateTimeString = null;

		if (dateTime != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			dateTimeString = dateTimeFormatter.print(dateTime);
		}

		return dateTimeString;
	}
}