package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.portasig;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusCodiEstatPortasigApiParamValue.
 */
@SuppressWarnings("unchecked")
public enum TipusCodiEstatPortasigApiParamValue implements BaseApiParamValue {

	/** The pendent. */
	PENDENT("PENDENT", BigDecimal.valueOf(1)),

	/** The completada. */
	COMPLETADA("COMPLETADA", BigDecimal.valueOf(2)),

	/** The retornada. */
	RETORNADA("RETORNADA", BigDecimal.valueOf(3)),

	/** The caducada. */
	CADUCADA("CADUCADA", BigDecimal.valueOf(4));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new tipus documentacio vinculada api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusCodiEstatPortasigApiParamValue(String apiParamValue, BigDecimal internalValue) {
		this.apiParamValue = apiParamValue;
		this.internalValue = internalValue;
	}

	/**
	 * Gets the api param value.
	 *
	 * @return the api param value
	 */
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
	@Override
	public BigDecimal getInternalValue() {
		return internalValue;
	}

}
