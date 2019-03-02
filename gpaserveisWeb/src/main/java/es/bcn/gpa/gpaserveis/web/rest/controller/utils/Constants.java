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

	/** The Constant PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL. */
	public static final Integer PERSONES_SOLLICITUD_RELACIO_NO_PRINCIPAL = NumberUtils.INTEGER_ZERO;

	/** The Constant PERSONES_SOLLICITUD_RELACIO_PRINCIPAL. */
	public static final Integer PERSONES_SOLLICITUD_RELACIO_PRINCIPAL = NumberUtils.INTEGER_ONE;

	/** The Constant PERSONES_SOLLICITUD_RELACIO_SOLLICITANT. */
	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_SOLLICITANT = BigDecimal.ONE;

	/** The Constant PERSONES_SOLLICITUD_RELACIO_REPRESENTANT. */
	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_REPRESENTANT = new BigDecimal(2);

	/** The Constant PERSONES_SOLLICITUD_RELACIO_TESTIMONI. */
	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_TESTIMONI = new BigDecimal(3);

	/** The Constant PERSONES_SOLLICITUD_RELACIO_ALTRES. */
	public static final BigDecimal PERSONES_SOLLICITUD_RELACIO_ALTRES = new BigDecimal(4);

	/** The Constant CODI_ISO_PAIS_PER_DEFECTE. */
	public static final String CODI_ISO_PAIS_PER_DEFECTE = "ES";

}
