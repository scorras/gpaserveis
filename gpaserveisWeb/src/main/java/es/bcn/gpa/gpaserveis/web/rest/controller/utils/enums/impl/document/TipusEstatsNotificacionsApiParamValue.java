package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusEstatsDocumentsApiParamValue.
 */
public enum TipusEstatsNotificacionsApiParamValue implements BaseApiParamValue {

    /** The pendent de processar. */
	PENDENT_DE_PROCESSAR("Pendent de processar", BigDecimal.valueOf(7)),

	/** The registrada. */
	REGISTRADA("Registrada", BigDecimal.valueOf(9)),

	/** The dipositada. */
	DIPOSITADA("Dipositada", BigDecimal.valueOf(10)),

	/** The visualitzada. */
	VISUALITZADA("Visualitzada", BigDecimal.valueOf(11)),

	/** The rebutjada. */
	REBUTJADA("Rebutjada", BigDecimal.valueOf(12)),

	/** The acceptada. */
	ACCEPTADA("Acceptada", BigDecimal.valueOf(13)),

	/** The rebutjada sense acces. */
	REBUTJADA_SENSE_ACCES("Rebutjada sense accés", BigDecimal.valueOf(18)),

	/** The rebutjada sense accio. */
	REBUTJADA_SENSE_ACCIO("Rebutjada sense acció", BigDecimal.valueOf(19)),

	/** The error. */
	ERROR("Error", BigDecimal.valueOf(21));

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
