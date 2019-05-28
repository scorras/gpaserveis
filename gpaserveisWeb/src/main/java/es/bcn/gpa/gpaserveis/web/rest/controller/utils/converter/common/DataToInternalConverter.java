package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class DataToInternalConverter.
 */
@Component("dataToInternalConverter")
public class DataToInternalConverter extends AbstractConverter<String, Date> {
	/**
	 * Logger for this class
	 */
	private static final Log LOGGER = LogFactory.getLog(DataToInternalConverter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected Date convert(String dateString) {
		Date date = null;

		if (StringUtils.isNotEmpty(dateString)) {
			SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_PATTERN);
			try {
				date = formatter.parse(dateString);
			} catch (ParseException e) {
				LOGGER.error(e);
			}
		}

		return date;
	}
}