package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusEstatsDocumentsApiParamValue.
 */
public enum TipusEstatsDocumentsApiParamValue implements BaseApiParamValue {

	/** The en elaboracio. */
	EN_ELABORACIO("En elaboració", BigDecimal.valueOf(1)),

	/** The finalitzat. */
	FINALITZAT("Finalitzat", BigDecimal.valueOf(2)),

	/** The pendent signatura. */
	PENDENT_SIGNATURA("Pendent signatura", BigDecimal.valueOf(3)),

	/** The signatura rebutjada. */
	SIGNATURA_REBUTJADA("Signatura rebutjada", BigDecimal.valueOf(4)),

	/** The vist i plau. */
	VIST_I_PLAU("Vist-i-plau", BigDecimal.valueOf(5)),

	/** The signat. */
	SIGNAT("Signat", BigDecimal.valueOf(6)),

	/** The pendent notificacio. */
	PENDENT_NOTIFICACIO("Pendent notificació", BigDecimal.valueOf(7)),

	/** The comunicat. */
	COMUNICAT("Comunicat", BigDecimal.valueOf(8)),

	/** The registrat. */
	REGISTRAT("Registrar", BigDecimal.valueOf(9)),

	/** The dispositat. */
	DISPOSITAT("Dispositat", BigDecimal.valueOf(10)),

	/** The notificacio visualitzada. */
	NOTIFICACIO_VISUALITZADA("Notificació visualitzada", BigDecimal.valueOf(11)),

	/** The notificacio rebutjada. */
	NOTIFICACIO_REBUTJADA("Notificació rebutjada", BigDecimal.valueOf(12)),

	/** The notificacio acceptada. */
	NOTIFICACIO_ACCEPTADA("Notificació acceptada", BigDecimal.valueOf(13)),

	/** The signatura caducada. */
	SIGNATURA_CADUCADA("Signatura caducada", BigDecimal.valueOf(14)),

	/** The pendent vist i plau. */
	PENDENT_VIST_I_PLAU("Pendent vist-i-plau", BigDecimal.valueOf(15)),

	/** The vist i plau rebutjat. */
	VIST_I_PLAU_REBUTJAT("Vist-i-plau rebutjat", BigDecimal.valueOf(16)),

	/** The vist i plau caducat. */
	VIST_I_PLAU_CADUCAT("Vist-i-plau caducat", BigDecimal.valueOf(17));

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
	TipusEstatsDocumentsApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
