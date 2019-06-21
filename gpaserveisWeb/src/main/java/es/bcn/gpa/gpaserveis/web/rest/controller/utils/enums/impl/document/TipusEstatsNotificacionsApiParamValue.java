package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusEstatsDocumentsApiParamValue.
 */
public enum TipusEstatsNotificacionsApiParamValue implements BaseApiParamValue {

	/** The pendent notificacio. */
	PENDENT_NOTIFICACIO("PENDENT_NOTIFICACIO", BigDecimal.valueOf(7)),

	/** The registrat. */
	REGISTRAT("REGISTRAT", BigDecimal.valueOf(9)),

	/** The dispositat. */
	DISPOSITAT("DISPOSITAT", BigDecimal.valueOf(10)),

	/** The notificacio visualitzada. */
	NOTIFICACIO_VISUALITZADA("NOTIFICACIO_VISUALITZADA", BigDecimal.valueOf(11)),

	/** The notificacio rebutjada. */
	NOTIFICACIO_REBUTJADA("NOTIFICACIO_REBUTJADA", BigDecimal.valueOf(12)),

	/** The notificacio acceptada. */
	NOTIFICACIO_ACCEPTADA("NOTIFICACIO_ACCEPTADA", BigDecimal.valueOf(13)),

	/** The notificacio rebutjada acces. */
	NOTIFICACIO_REBUTJADA_ACCES("NOTIFICACIO_REBUTJADA_ACCES", BigDecimal.valueOf(18)),

	/** The notificacio rebutjada accio. */
	NOTIFICACIO_REBUTJADA_ACCIO("NOTIFICACIO_REBUTJADA_ACCIO", BigDecimal.valueOf(19));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new tipus accions porta sig api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusEstatsNotificacionsApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
