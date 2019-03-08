package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum RelacioPersonaApiParamValue.
 */
public enum RelacioPersonaApiParamValue implements BaseApiParamValue {

    /** The sollicitant. */
	SOLLICITANT("SOLLICITANT", new BigDecimal(1)),

	/** The representant. */
	REPRESENTANT("REPRESENTANT", new BigDecimal(2)),

	/** The testimoni. */
	TESTIMONI("TESTIMONI", new BigDecimal(3)),

	/** The altres. */
	ALTRES("ALTRES", new BigDecimal(4));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new relacio persona api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	RelacioPersonaApiParamValue(String apiParamValue, BigDecimal internalValue) {
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

	/**
	 * Gets the internal value.
	 *
	 * @return the internal value
	 */
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
