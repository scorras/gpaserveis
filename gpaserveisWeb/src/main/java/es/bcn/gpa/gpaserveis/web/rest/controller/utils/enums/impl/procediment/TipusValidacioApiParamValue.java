package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusValidacioApiParamValue.
 */
public enum TipusValidacioApiParamValue implements BaseApiParamValue {

    /** The menor. */
	MENOR("MENOR", new BigDecimal(1)),

	/** The major. */
	MAJOR("MAJOR", new BigDecimal(2)),

	/** The igual. */
	IGUAL("IGUAL", new BigDecimal(3)),

	/** The interval. */
	INTERVAL("INTERVAL", new BigDecimal(4)),

	/** The longitud maxima. */
	LONGITUD_MAXIMA("LONGITUD_MAXIMA", new BigDecimal(5)),

	/** The mascara. */
	MASCARA("MASCARA", new BigDecimal(6)),

	/** The menor igual. */
	MENOR_IGUAL("MENOR_IGUAL", new BigDecimal(7)),

	/** The major igual. */
	MAJOR_IGUAL("MAJOR_IGUAL", new BigDecimal(8)),

	/** The interval tancat. */
	INTERVAL_TANCAT("INTERVAL_TANCAT", new BigDecimal(9)),

	/** The interval obert. */
	INTERVAL_OBERT("INTERVAL_OBERT", new BigDecimal(10)),

	/** The url. */
	URL("URL", new BigDecimal(11));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new tipus validacio api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusValidacioApiParamValue(String apiParamValue, BigDecimal internalValue) {
		this.apiParamValue = apiParamValue;
		this.internalValue = internalValue;
	}

	/**
	 * Gets the api param value.
	 *
	 * @return the api param value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getApiParamValue() {
		return apiParamValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue#
	 * getInternalValue()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getInternalValue() {
		return internalValue;
	}
}
