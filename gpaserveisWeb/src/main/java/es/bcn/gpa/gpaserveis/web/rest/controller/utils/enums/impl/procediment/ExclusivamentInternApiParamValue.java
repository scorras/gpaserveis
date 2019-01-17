package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import org.apache.commons.lang.math.NumberUtils;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum ExclusivamentInternApiParamValue.
 */
public enum ExclusivamentInternApiParamValue implements BaseApiParamValue {

    /** The si. */
	SI("SI", NumberUtils.INTEGER_ZERO),

	/** The no. */
	NO("NO", NumberUtils.INTEGER_ONE);

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private Integer internalValue;

	/**
	 * Instantiates a new exclusivament intern cerca procediments.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	ExclusivamentInternApiParamValue(String apiParamValue, Integer internalValue) {
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
	public Integer getInternalValue() {
		return internalValue;
	}
}
