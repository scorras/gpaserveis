package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class DataHoraToInternalConverter.
 */
@Component("dataHoraToInternalConverter")
public class DataHoraToInternalConverter extends AbstractConverter<String, DateTime> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DateTime convert(String dateTimeString) {
		DateTime dateTime = null;

		if (StringUtils.isNotEmpty(dateTimeString)) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
		}

		return dateTime;
	}
}