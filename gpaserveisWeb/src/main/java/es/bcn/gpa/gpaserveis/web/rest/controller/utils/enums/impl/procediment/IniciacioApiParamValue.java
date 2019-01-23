package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum IniciacioApiParamValue.
 */
public enum IniciacioApiParamValue implements BaseApiParamValue {

    /** The ofici. */
	OFICI("OFICI", new Integer(1)),

	/** The sol licitud interessat. */
	SOL_LICITUD_INTERESSAT("SOL_LICITUD_INTERESSAT", new Integer(2)),

	/** The altra administracio. */
	ALTRA_ADMINISTRACIO("ALTRA_ADMINISTRACIO", new Integer(3)),

	/** The altres. */
	ALTRES("ALTRES", new Integer(4));

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
	IniciacioApiParamValue(String apiParamValue, Integer internalValue) {
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
