package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum MotiuPausaApiParamValue.
 */
public enum MotiuPausaApiParamValue implements BaseApiParamValue {

    /** The requeriment subsanacio. */
	REQUERIMENT_SUBSANACIO("requerimentSubsanacio", "1"),

	/** The tramit allegacions. */
	TRAMIT_ALLEGACIONS("tramitAllegacions", "2"),

	/** The notificacio resolucio. */
	NOTIFICACIO_RESOLUCIO("notificacioResolucio", "3"),

	/** The requeriment informe. */
	REQUERIMENT_INFORME("requerimentInforme", "4");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	/**
	 * Instantiates a new motiu pausa api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	MotiuPausaApiParamValue(String apiParamValue, String internalValue) {
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
