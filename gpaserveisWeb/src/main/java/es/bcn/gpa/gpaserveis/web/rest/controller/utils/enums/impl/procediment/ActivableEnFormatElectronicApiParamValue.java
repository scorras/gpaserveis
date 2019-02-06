package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum ActivableEnFormatElectronicApiParamValue.
 */
public enum ActivableEnFormatElectronicApiParamValue implements BaseApiParamValue {

    /** The portal tramits. */
	PORTAL_TRAMITS("PORTAL_TRAMITS", "PORTAL_TRAMITS"),

	/** The altra web. */
	ALTRA_WEB("ALTRA_WEB", "ALTRA_WEB"),

	/** The mobil. */
	MOBIL("MOBIL", "MOBIL"),

	/** The quiosc. */
	QUIOSC("QUIOSC", "QUIOSC"),

	/** The per canal generalista. */
	PER_CANAL_GENERALISTA("PER_CANAL_GENERALISTA", "PER_CANAL_GENERALISTA"),

	/** The per canal especific. */
	PER_CANAL_ESPECIFIC("PER_CANAL_ESPECIFIC", "PER_CANAL_ESPECIFIC");

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
	ActivableEnFormatElectronicApiParamValue(String apiParamValue, String internalValue) {
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
