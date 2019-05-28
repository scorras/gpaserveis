package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusEstatsDocumentsApiParamValue.
 */
public enum TipusEstatsNotificacionsApiParamValue implements BaseApiParamValue {

	/** The pendent notificacio. */
	PENDENT_NOTIFICACIO("Pendent notificació", BigDecimal.valueOf(7)),

	/** The registrat. */
	REGISTRAT("Registrar", BigDecimal.valueOf(9)),

	/** The dispositat. */
	DISPOSITAT("Dispositat", BigDecimal.valueOf(10)),

	/** The notificacio visualitzada. */
	NOTIFICACIO_VISUALITZADA("Notificació visualitzada", BigDecimal.valueOf(11)),

	/** The notificacio rebutjada. */
	NOTIFICACIO_REBUTJADA("Notificació rebutjada", BigDecimal.valueOf(12)),

	/** The notificacio acceptada. */
	NOTIFICACIO_ACCEPTADA("Notificació acceptada", BigDecimal.valueOf(13));

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
