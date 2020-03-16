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

	/** The Constant DATE_TIME_PATTERN_NOTIFICACIONS. */
	public static final String DATE_TIME_PATTERN_NOTIFICACIONS = "dd-MM-yyyy HH:mm:ss";

	/** The Constant DATE_TIME_PATTERN. */
	public static final String TIME_PATTERN = "HH:mm:ss";

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

	/** The Constant MISSATGE_ERROR_ARIADNA. */
	public static final String MISSATGE_ERROR_ARIADNA = "Error Ariadna:";

	/** The Constant MISSATGE_ERROR_CATALEG. */
	public static final String MISSATGE_ERROR_CATALEG = "Error Cataleg:";

	/** The Constant MISSATGE_ERROR_CTRLUSER. */
	public static final String MISSATGE_ERROR_CTRLUSER = "Error CtrlUser:";

	/** The Constant MISSATGE_ERROR_DIGITALITZACIO. */
	public static final String MISSATGE_ERROR_DIGITALITZACIO = "Error Digitalització:";

	/** The Constant MISSATGE_ERROR_GEOCOD. */
	public static final String MISSATGE_ERROR_GEOCOD = "Error GeoCod:";

	/** The Constant MISSATGE_ERROR_NOTIFICADOR. */
	public static final String MISSATGE_ERROR_NOTIFICADOR = "Error Notificador:";

	/** The Constant MISSATGE_ERROR_OPENTEXT. */
	public static final String MISSATGE_ERROR_OPENTEXT = "Error OpenText:";

	/** The Constant MISSATGE_ERROR_DOCUMENTUM. */
	public static final String MISSATGE_ERROR_DOCUMENTUM = "Error Documentum:";

	/** The Constant MISSATGE_ERROR_PDFGESTOR. */
	public static final String MISSATGE_ERROR_PDFGESTOR = "Error PdfGestor:";

	/** The Constant MISSATGE_ERROR_PORTASIG. */
	public static final String MISSATGE_ERROR_PORTASIG = "Error PortaSig:";

	/** The Constant MISSATGE_ERROR_SIGNATURES. */
	public static final String MISSATGE_ERROR_SIGNATURES = "Error Signatures:";

	/** The Constant MISSATGE_ERROR_SERVEI_INTEROPERABILITAT. */
	public static final String MISSATGE_ERROR_SERVEI_INTEROPERABILITAT = "Error Servei Interoperabilitat:";

	/** The Constant ESTAT_EXPEDIENT_EN_PREPARACIO. */
	public static final BigDecimal ESTAT_EXPEDIENT_EN_PREPARACIO = BigDecimal.ONE;

	/** The Constant ESTAT_EXPEDIENT_SOLLICITUD_EN_REVISIO. */
	public static final BigDecimal ESTAT_EXPEDIENT_SOLLICITUD_EN_REVISIO = new BigDecimal(2);
	
	/** The Constant DESCRIPCIO_ESTAT_ESBORRANY. */
	public static final String DESCRIPCIO_ESTAT_ESBORRANY = "ESBORRANY";
	
	/** The Constant DESCRIPCIO_ESTAT_REGISTRAT. */
	public static final String DESCRIPCIO_ESTAT_REGISTRAT = "REGISTRAT";
	
	/** The Constant DESCRIPCIO_ACCIO_ARXIVAR. */
	public static final String DESCRIPCIO_ACCIO_ARXIVAR = "Arxivar per incomplerta o inadequada";

}
