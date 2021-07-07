package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum IniciacioApiParamValue.
 */
public enum TipusCampApiParamValue implements BaseApiParamValue {

    /** The numeric. */
	NUMERIC("NUMERIC", new Integer(1)),

	/** The decimal. */
	DECIMAL("DECIMAL", new Integer(2)),

	/** The moneda. */
	MONEDA("MONEDA", new Integer(3)),

	/** The data. */
	DATA("DATA", new Integer(4)),

	/** The data hora. */
	DATA_HORA("DATA_HORA", new Integer(5)),

	/** The hora. */
	HORA("HORA", new Integer(6)),

	/** The text. */
	TEXT("TEXT", new Integer(7)),

	/** The text gran. */
	TEXT_GRAN("TEXT_GRAN", new Integer(8)),

	/** The literal. */
	LITERAL("LITERAL", new Integer(9)),

	/** The llista simple. */
	LLISTA_SIMPLE("LLISTA_SIMPLE", new Integer(10)),

	/** The llista multiple. */
	LLISTA_MULTIPLE("LLISTA_MULTIPLE", new Integer(11)),

	/** The marcador. */
	MARCADOR("MARCADOR", new Integer(12)),

	/** The pais. */
	PAIS("PAIS", new Integer(13)),

	/** The provincia. */
	PROVINCIA("PROVINCIA", new Integer(14)),

	/** The municipi. */
	MUNICIPI("MUNICIPI", new Integer(16)),

	/** The subgrup. */
	SUBGRUP("SUBGRUP", new Integer(17));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private Integer internalValue;

	/**
	 * Instantiates a new tipus camp api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusCampApiParamValue(String apiParamValue, Integer internalValue) {
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
