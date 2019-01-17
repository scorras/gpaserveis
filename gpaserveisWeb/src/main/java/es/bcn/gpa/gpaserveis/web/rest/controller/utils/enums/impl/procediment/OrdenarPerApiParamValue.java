package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum OrdenarPerApiParamValue.
 */
public enum OrdenarPerApiParamValue implements BaseApiParamValue {

    /** The codi. */
	CODI("CODI", "codi"),

	/** The nom. */
	NOM("NOM", "nom"),

	/** The estat. */
	ESTAT("ESTAT", "descripcioEstat"),

	/** The tramitador. */
	TRAMITADOR("TRAMITADOR", "tramitador"),

	/** The darrera modificacio. */
	DARRERA_MODIFICACIO("DARRERA_MODIFICACIO", "darreraModificacio");

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
	OrdenarPerApiParamValue(String apiParamValue, String internalValue) {
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
