package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TransicioAccioEstatApiParamValue. Asocia la descripcion de la
 * transicion con el idAccioEstat
 */
public enum TransicioAccioEstatApiParamValue implements BaseApiParamValue {

	/** transicion pausar expedient per esmenes. */
	PAUSAR_EXPEDIENT_PER_ESMENES("Pausar l'expedient per esmenes", "61"),

	/** transicion pausar expedient per allegacio. */
	PAUSAR_EXPEDIENT_PER_ALLEGACIO("Pausar l'expedient per al·legació", "62"),

	/** transicion pausar expedient per informe. */
	PAUSAR_EXPEDIENT_PER_INFORME("Pausar l'expedient per al·legació", "63");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	/**
	 * Instantiates a new accio abandonar api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TransicioAccioEstatApiParamValue(String apiParamValue, String internalValue) {
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
