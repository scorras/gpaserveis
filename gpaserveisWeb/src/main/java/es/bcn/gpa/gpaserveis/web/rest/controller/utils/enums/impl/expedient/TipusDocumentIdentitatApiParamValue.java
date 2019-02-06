package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusDocumentIdentitatApiParamValue.
 */
public enum TipusDocumentIdentitatApiParamValue implements BaseApiParamValue {

    /** The nif. */
	NIF("NIF", new BigDecimal(0)),

	/** The nie. */
	NIE("NIE", new BigDecimal(1)),

	/** The passaport. */
	PASSAPORT("PASSAPORT", new BigDecimal(2)),

	/** The document identitat estranger. */
	DOCUMENT_IDENTITAT_ESTRANGER("DOCUMENT_IDENTITAT_ESTRANGER", new BigDecimal(3)),

	/** The document empresa estrangera. */
	DOCUMENT_EMPRESA_ESTRANGERA("DOCUMENT_EMPRESA_ESTRANGERA", new BigDecimal(4));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new tipus document identitat api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusDocumentIdentitatApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
	public BigDecimal getInternalValue() {
		return internalValue;
	}
}
