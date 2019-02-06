package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum SentitOrdenacioApiParamValue.
 */
public enum SentitOrdenacioApiParamValue implements BaseApiParamValue {

    /** The asc. */
	ASC("ASC", "asc"),

	/** The desc. */
	DESC("DESC", "desc");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	/**
	 * Instantiates a new ordenar per cerca procediments.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	SentitOrdenacioApiParamValue(String apiParamValue, String internalValue) {
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
	@SuppressWarnings("unchecked")
	@Override
	public String getInternalValue() {
		return internalValue;
	}
}
