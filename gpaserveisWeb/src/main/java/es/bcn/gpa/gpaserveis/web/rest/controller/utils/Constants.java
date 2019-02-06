package es.bcn.gpa.gpaserveis.web.rest.controller.utils;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;

/**
 * The Class Constants.
 */
public class Constants {

	/** The Constant DATE_PATTERN. */
	public static final String DATE_PATTERN = "dd/MM/yyyy";

	/** The Constant DATE_TIME_PATTERN. */
	public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

	public static final Integer PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL = NumberUtils.INTEGER_ZERO;

	public static final Integer PERSONES_SOLLICITUD_RELACIO_PRINCIPAL = NumberUtils.INTEGER_ONE;

	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_SOLLICITANT = BigDecimal.ONE;

	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_REPRESENTANT = new BigDecimal(2);

	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_TESTIMONI = new BigDecimal(3);

	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_ALTRES = new BigDecimal(4);

}
