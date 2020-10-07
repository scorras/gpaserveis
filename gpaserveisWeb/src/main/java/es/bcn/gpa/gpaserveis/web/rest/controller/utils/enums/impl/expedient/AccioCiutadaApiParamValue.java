package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum AccioCiutadaApiParamValue.
 */
public enum AccioCiutadaApiParamValue implements BaseApiParamValue {

    // Las acciones que compartan identificador interno de acción, deberán
    // distinguirse a través del identificador del estado origen de la
    // transición

    /** The requeriment esmena. */
	REQUERIMENT_ESMENA("REQUERIMENT_ESMENA", new BigDecimal(3), new BigDecimal(3)),

	/** The aportar documentacio. */
	APORTAR_DOCUMENTACIO("APORTAR_DOCUMENTACIO", new BigDecimal(2), null),

	/** The alegacions. */
	ALEGACIONS("ALEGACIONS", new BigDecimal(3), new BigDecimal(5));

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

	/** The internal value id estat origen. */
	private BigDecimal internalValueIdEstatOrigen;

	/**
	 * Instantiates a new accio ciutada api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 * @param internalValueIdEstatOrigen
	 *            the internal value id estat origen
	 */
	AccioCiutadaApiParamValue(String apiParamValue, BigDecimal internalValue, BigDecimal internalValueIdEstatOrigen) {
		this.apiParamValue = apiParamValue;
		this.internalValue = internalValue;
		this.internalValueIdEstatOrigen = internalValueIdEstatOrigen;
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

	/**
	 * Gets the internal value id estat origen.
	 *
	 * @return the internal value id estat origen
	 */
	public BigDecimal getInternalValueIdEstatOrigen() {
		return internalValueIdEstatOrigen;
	}
}
