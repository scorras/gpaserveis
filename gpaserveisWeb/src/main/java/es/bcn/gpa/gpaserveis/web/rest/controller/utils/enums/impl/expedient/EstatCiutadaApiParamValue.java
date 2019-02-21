package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum EstatCiutadaApiParamValue.
 */
public enum EstatCiutadaApiParamValue implements BaseApiParamValue {

    /** The rebut. */
	REBUT("REBUT", new BigDecimal(1)),

	/** The en curs sol licitud en revisio. */
	EN_CURS_SOL_LICITUD_EN_REVISIO("EN_CURS", new BigDecimal(2)),

	/** The pendent esmenes. */
	PENDENT_ESMENES("PENDENT_ESMENES", new BigDecimal(3)),

	/** The en curs en tramitacio. */
	EN_CURS_EN_TRAMITACIO("EN_CURS", new BigDecimal(4)),

	/** The pendent alegacions. */
	PENDENT_ALEGACIONS("PENDENT_ALEGACIONS", new BigDecimal(5)),

	/** The en curs pendent d informes. */
	EN_CURS_PENDENT_D_INFORMES("EN_CURS", new BigDecimal(6)),

	/** The en curs proposta de finalitzacio. */
	EN_CURS_PROPOSTA_DE_FINALITZACIO("EN_CURS", new BigDecimal(7)),

	/** The resolt. */
	RESOLT("RESOLT", new BigDecimal(8)),

	/** The tancat. */
	TANCAT("TANCAT", new BigDecimal(9));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new estat ciutada api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	EstatCiutadaApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
	public BigDecimal getInternalValue() {
		return internalValue;
	}
}
