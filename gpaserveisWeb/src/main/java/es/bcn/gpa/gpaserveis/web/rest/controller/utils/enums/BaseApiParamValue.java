package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Interface BaseApiParamValue.
 */
public interface BaseApiParamValue {

	/**
	 * Gets the api param value.
	 *
	 * @param <T>
	 *            the generic type
	 * @return the api param value
	 */
	public <T extends Object> T getApiParamValue();

	/**
	 * Gets the internal value.
	 *
	 * @param <T>
	 *            the generic type
	 * @return the internal value
	 */
	public <T extends Object> T getInternalValue();
}
