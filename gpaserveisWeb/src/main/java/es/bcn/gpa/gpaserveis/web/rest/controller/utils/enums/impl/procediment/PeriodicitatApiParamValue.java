package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum PeriodicitatApiParamValue.
 */
public enum PeriodicitatApiParamValue implements BaseApiParamValue {

	CONTINU("CONTINU", new Integer(0)),

	ESTACIONAL("ESTACIONAL", new Integer(1)),

	PUNTUAL("PUNTUAL", new Integer(2)),

	ESPORADIC("ESPORADIC", new Integer(3));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private Integer internalValue;

	/**
	 * Instantiates a new estat cerca procediments.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	PeriodicitatApiParamValue(String apiParamValue, Integer internalValue) {
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
	public Integer getInternalValue() {
		return internalValue;
	}
}
