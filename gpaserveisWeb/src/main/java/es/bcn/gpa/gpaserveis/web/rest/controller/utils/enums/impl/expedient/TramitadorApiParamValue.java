package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TramitadorApiParamValue.
 */
public enum TramitadorApiParamValue implements BaseApiParamValue {

    /** The aplicacio de negoci. */
	APLICACIO_DE_NEGOCI("APLICACIO_DE_NEGOCI", "1"),

	/** The oge. */
	OGE("OGE", "2");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	/**
	 * Instantiates a new tramitador cerca procediments.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TramitadorApiParamValue(String apiParamValue, String internalValue) {
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
