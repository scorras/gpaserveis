package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum EstatApiParamValue.
 */
public enum EstatApiParamValue implements BaseApiParamValue {

    /** The en preparacio. */
	EN_PREPARACIO("EN_PREPARACIO", new BigDecimal(1)),

	/** The sol licitud en revisio. */
	SOL_LICITUD_EN_REVISIO("SOL_LICITUD_EN_REVISIO", new BigDecimal(2)),

	/** The pendent subsanacio. */
	PENDENT_SUBSANACIO("PENDENT_ESMENES", new BigDecimal(3)),

	/** The en tramitacio. */
	EN_TRAMITACIO("EN_TRAMITACIO", new BigDecimal(4)),

	/** The pendent al legacions. */
	PENDENT_AL_LEGACIONS("PENDENT_AL_LEGACIONS", new BigDecimal(5)),

	/** The pendent d informes. */
	PENDENT_D_INFORMES("PENDENT_D_INFORMES", new BigDecimal(6)),

	/** The proposta de finalitzacio. */
	PROPOSTA_DE_FINALITZACIO("PROPOSTA_DE_FINALITZACIO", new BigDecimal(7)),

	/** The finalitzat i comunicat. */
	FINALITZAT_I_COMUNICAT("FINALITZAT_I_COMUNICAT", new BigDecimal(8)),

	/** The tancat. */
	TANCAT("TANCAT", new BigDecimal(9));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new estat cerca procediments.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	EstatApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
