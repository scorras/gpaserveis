package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TerminiMaximApiParamValue.
 */
public enum TerminiMaximApiParamValue implements BaseApiParamValue {

	DIES_HABILS("DIES_HABILS", new Integer(0)),

	DIES_NATURALS("DIES_NATURALS", new Integer(1)),

	MESOS("MESOS", new Integer(2)),

	ANYS("ANYS", new Integer(3)),

	HORES("HORES", new Integer(4)),

	IMMEDIAT("IMMEDIAT", new Integer(5));

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
	TerminiMaximApiParamValue(String apiParamValue, Integer internalValue) {
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
