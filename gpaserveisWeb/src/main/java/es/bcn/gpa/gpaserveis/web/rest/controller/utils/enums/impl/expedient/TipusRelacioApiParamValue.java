package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusRelacioApiParamValue.
 */
public enum TipusRelacioApiParamValue implements BaseApiParamValue {

	OBJECTE_D_ACUMULACIO("Objecte d'acumulació", "1-1"),

	ACUMULAT("Acumulat", "1-2"),

	OBJECTE_DE_RECURS("Objecte de recurs", "2-1"),

	RECURS("Recurs", "2-2");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	TipusRelacioApiParamValue(String apiParamValue, String internalValue) {
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
	public String getInternalValue() {
		return internalValue;
	}
}
