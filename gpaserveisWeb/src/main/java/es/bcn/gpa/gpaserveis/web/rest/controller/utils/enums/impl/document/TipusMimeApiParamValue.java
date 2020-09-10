package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusMimeApiParamValue.
 */
public enum TipusMimeApiParamValue implements BaseApiParamValue {

    /** The pdf. */
	PDF("PDF", Integer.valueOf(1)),

	/** The doc. */
	DOC("DOC", Integer.valueOf(2)),

	/** The docx. */
	DOCX("DOCX", Integer.valueOf(3)),

	/** The xls. */
	XLS("XLS", Integer.valueOf(4)),

	/** The xlsx. */
	XLSX("XLSX", Integer.valueOf(5)),

	/** The zip. */
	ZIP("ZIP", Integer.valueOf(6)),

	/** The rar. */
	RAR("RAR", Integer.valueOf(7)),

	/** The xml. */
	XML("XML", Integer.valueOf(8)),

	/** The txt. */
	TXT("TXT", Integer.valueOf(9)),

	/** The ppt. */
	PPT("PPT", Integer.valueOf(10)),

	/** The pptx. */
	PPTX("PPTX", Integer.valueOf(11)),

	/** The odt. */
	ODT("ODT", Integer.valueOf(12)),

	/** The bmp. */
	BMP("BMP", Integer.valueOf(13)),

	/** The jpg. */
	JPG("JPG", Integer.valueOf(14)),

	/** The gif. */
	GIF("GIF", Integer.valueOf(15)),

	/** The png. */
	PNG("PNG", Integer.valueOf(16)),

	/** The tiff. */
	TIFF("TIFF", Integer.valueOf(17)),

	/** The rtf. */
	RTF("RTF", Integer.valueOf(18));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private Integer internalValue;

	/**
	 * Instantiates a new tipus mime api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusMimeApiParamValue(String apiParamValue, Integer internalValue) {
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
	public Integer getInternalValue() {
		return internalValue;
	}
}
