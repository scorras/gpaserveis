package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum HistoricEstatApiParamValue.
 */
public enum HistoricEstatApiParamValue implements BaseApiParamValue {

    /** The en preparacio. */
	EN_PREPARACIO("EN_PREPARACIO", "En preparació"),

	/** The sol licitud en revisio. */
	SOL_LICITUD_EN_REVISIO("SOL_LICITUD_EN_REVISIO", "Sol·licitud en revisió"),

	/** The pendent subsanacio. */
	PENDENT_SUBSANACIO("PENDENT_ESMENES", "Pendent esmenes"),

	/** The en tramitacio. */
	EN_TRAMITACIO("EN_TRAMITACIO", "En tramitació"),

	/** The pendent al legacions. */
	PENDENT_AL_LEGACIONS("PENDENT_AL_LEGACIONS", "Pendent al·legacions"),

	/** The pendent d informes. */
	PENDENT_D_INFORMES("PENDENT_D_INFORMES", "Pendent d’informes"),

	/** The proposta de finalitzacio. */
	PROPOSTA_DE_FINALITZACIO("PROPOSTA_DE_FINALITZACIO", "Proposta de finalització"),

	/** The finalitzat i comunicat. */
	FINALITZAT_I_COMUNICAT("FINALITZAT_I_COMUNICAT", "Finalitzat i comunicat"),

	/** The tancat. */
	TANCAT("TANCAT", "Tancat");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	HistoricEstatApiParamValue(String apiParamValue, String internalValue) {
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
