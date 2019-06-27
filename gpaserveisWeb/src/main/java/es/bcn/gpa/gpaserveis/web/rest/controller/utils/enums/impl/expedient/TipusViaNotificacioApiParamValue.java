package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import org.apache.commons.lang.math.NumberUtils;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusViaApiParamValue.
 */
public enum TipusViaNotificacioApiParamValue implements BaseApiParamValue {

    /** The electronica. */
	ELECTRONICA("ELECTRONICA", NumberUtils.SHORT_ZERO),

	/** The paper. */
	PAPER("PAPER", NumberUtils.SHORT_ONE);

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private Short internalValue;

	/**
	 * Instantiates a new tipus via api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusViaNotificacioApiParamValue(String apiParamValue, Short internalValue) {
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
	public Short getInternalValue() {
		return internalValue;
	}
}
