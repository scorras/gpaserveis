package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum AccioCiutadaApiParamValue.
 */
public enum AccioCiutadaApiParamValue implements BaseApiParamValue {

    /** The requeriment esmena. */
	REQUERIMENT_ESMENA("REQUERIMENT_ESMENA", new BigDecimal(3)),

	/** The aportar documentacio. */
	APORTAR_DOCUMENTACIO("APORTAR_DOCUMENTACIO", new BigDecimal(2)),

	/** The alegacions. */
	ALEGACIONS("ALEGACIONS", new BigDecimal(3));

	// De momento se eliminan las opciones de RENUNCIA y DESISTIMENT. Se
	// volverán a incorporar cuando se implemente este trámite OVT.
	/** The renuncia. */
	// RENUNCIA("RENUNCIA", new BigDecimal(40)),

	/** The desistiment. */
	// DESISTIMENT("DESISTIMENT", new BigDecimal(40));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new accio api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	AccioCiutadaApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
