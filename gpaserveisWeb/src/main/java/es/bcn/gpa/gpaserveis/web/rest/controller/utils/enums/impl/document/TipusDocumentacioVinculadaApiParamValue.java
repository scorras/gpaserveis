package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusDocumentacioVinculadaApiParamValue.
 */
public enum TipusDocumentacioVinculadaApiParamValue implements BaseApiParamValue {

	/** The evidencia de notificacio. */
	EVIDENCIA_DE_NOTIFICACIO("EVIDÈNCIA DE NOTIFICACIÓ", BigDecimal.valueOf(1)),

	/** The justificant allegacio. */
	JUSTIFICANT_ALLEGACIO("JUSTIFICANT D'AL·LEGACIÓ", BigDecimal.valueOf(2)),

	/** The justificant aportacio. */
	JUSTIFICANT_APORTACIO("JUSTIFICANT D'APORTACIÓ", BigDecimal.valueOf(3)),

	/** The justificant esmena. */
	JUSTIFICANT_ESMENA("JUSTIFICANT ESMENA", BigDecimal.valueOf(4)),

	/** The justificant sollicitud. */
	JUSTIFICANT_SOLLICITUD("JUSTIFICANT SOL·LICITUD", BigDecimal.valueOf(5)),

	/** The notificacio esmena. */
	NOTIFICACIO_ESMENA("NOTIFICACIÓ D'ESMENA", BigDecimal.valueOf(6));

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
	TipusDocumentacioVinculadaApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
