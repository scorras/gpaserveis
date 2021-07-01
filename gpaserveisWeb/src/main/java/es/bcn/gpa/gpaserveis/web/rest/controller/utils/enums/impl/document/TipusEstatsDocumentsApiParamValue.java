package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusEstatsDocumentsApiParamValue.
 */
public enum TipusEstatsDocumentsApiParamValue implements BaseApiParamValue {

	/** The en elaboracio. */
	EN_ELABORACIO("EN_ELABORACIO", BigDecimal.valueOf(1)),

	/** The finalitzat. */
	FINALITZAT("FINALITZAT", BigDecimal.valueOf(2)),

	/** The pendent signatura. */
	PENDENT_SIGNATURA("PENDENT_SIGNATURA", BigDecimal.valueOf(3)),

	/** The signatura rebutjada. */
	SIGNATURA_REBUTJADA("SIGNATURA_REBUTJADA", BigDecimal.valueOf(4)),

	/** The vist i plau. */
	VIST_I_PLAU("VIST_I_PLAU", BigDecimal.valueOf(5)),

	/** The signat. */
	SIGNAT("SIGNAT", BigDecimal.valueOf(6)),

	/** The pendent notificacio. */
	PENDENT_NOTIFICACIO("PENDENT_NOTIFICACIO", BigDecimal.valueOf(7)),

	/** The pendent comunicació. */
	PENDENT_COMUNICACIO("PENDENT_COMUNICACIO", BigDecimal.valueOf(8)),

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

	/** The signatura caducada. */
	SIGNATURA_CADUCADA("SIGNATURA_CADUCADA", BigDecimal.valueOf(14)),

	/** The pendent vist i plau. */
	PENDENT_VIST_I_PLAU("PENDENT_VIST_I_PLAU", BigDecimal.valueOf(15)),

	/** The vist i plau rebutjat. */
	VIST_I_PLAU_REBUTJAT("VIST_I_PLAU_REBUTJAT", BigDecimal.valueOf(16)),

	/** The vist i plau caducat. */
	VIST_I_PLAU_CADUCAT("VIST_I_PLAU_CADUCAT", BigDecimal.valueOf(17)),
	
	/** The notificacio rebutjada sense acces. */
	NOTIFICACIO_REBUTJADA_SENSE_ACCES("NOTIFICACIO_REBUTJADA_SENSE_ACCES", BigDecimal.valueOf(18)),
	
	/** The notificacio rebutjada sense accio. */
	NOTIFICACIO_REBUTJADA_SENSE_ACCIO("NOTIFICACIO_REBUTJADA_SENSE_ACCIO", BigDecimal.valueOf(19)),
	
	/** The publicat. */
	PUBLICAT("PUBLICAT", BigDecimal.valueOf(20)),
	
	/** The notificacio amb error. */
	NOTIFICACIO_AMB_ERROR("NOTIFICACIO_AMB_ERROR", BigDecimal.valueOf(21)),
	
	/** The completat. */
	COMPLETAT("COMPLETAT", BigDecimal.valueOf(22)),
	
	/** The descartat. */
	DESCARTAT("DESCARTAT", BigDecimal.valueOf(23));

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
