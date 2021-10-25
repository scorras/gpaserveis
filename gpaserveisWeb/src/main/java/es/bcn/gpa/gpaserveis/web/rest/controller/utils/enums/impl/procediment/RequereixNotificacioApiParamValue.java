package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum IniciacioApiParamValue.
 */
public enum RequereixNotificacioApiParamValue implements BaseApiParamValue {

	/** The sense notificacio. */
	SENSENOTIFICACIO("SENSE NOTIFICACIO", new Integer(0)),

	/** The notificacions electroniques i en paper. */
	NOTIFICACIONSELECTRONIQUESIENPAPER("NOTIFICACIONS ELECTRONIQUES I EN PAPER", new Integer(1)),
	
	/** The notificacions electroniques. */
	NOTIFICACIONSELECTRONIQUES("NOTIFICACIONS ELECTRONIQUES", new Integer(2)),

	/** The notificacions en paper. */
	NOTIFICACIONSENPAPER("NOTIFICACIONS EN PAPER", new Integer(3));

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
	RequereixNotificacioApiParamValue(String apiParamValue, Integer internalValue) {
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
	public Integer getInternalValue() {
		return internalValue;
	}
}
