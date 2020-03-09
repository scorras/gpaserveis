package es.bcn.gpa.gpaserveis.business.xml.bind.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.xml.bind.adapted.DataHoraAdapted;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;

/**
 * The Class DataHoraAdapter.
 */
@Component
public class DataHoraAdapter extends XmlAdapter<DataHoraAdapted, String> {

	/** The date time formatter. */
	private final DateTimeFormatter dateTimeFormatter;

	/** The date formatter. */
	private final DateTimeFormatter dateFormatter;

	/** The time formatter. */
	private final DateTimeFormatter timeFormatter;

	/**
	 * Instantiates a new data hora adapter.
	 */
	public DataHoraAdapter() {
		dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		dateFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		timeFormatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public String unmarshal(DataHoraAdapted dataHoraAdapted) throws Exception {
		return (dataHoraAdapted.getData() + " " + dataHoraAdapted.getHora());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public DataHoraAdapted marshal(String sourceValue) throws Exception {
		DateTime dateTime = dateTimeFormatter.parseDateTime(sourceValue);

		DataHoraAdapted dataHoraAdapted = new DataHoraAdapted();
		dataHoraAdapted.setData(dateFormatter.print(dateTime));
		dataHoraAdapted.setHora(timeFormatter.print(dateTime));

		return dataHoraAdapted;
	}

}