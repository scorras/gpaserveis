package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator;

import java.util.List;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;

/**
 * The Interface BaseApiParamValueTranslator.
 */
public interface BaseApiParamValueTranslator {

	/**
	 * Gets the api param allowable values.
	 *
	 * @return the api param allowable values
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public String getApiParamAllowableValues() throws GPAServeisRuntimeException;

	/**
	 * Gets the enum by api param value.
	 *
	 * @param <E>
	 *            the element type
	 * @param apiParamValue
	 *            the api param value
	 * @return the enum by api param value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public <E extends Enum<E>> E getEnumByApiParamValue(String apiParamValue) throws GPAServeisRuntimeException;

	/**
	 * Gets the internal value by api param value.
	 *
	 * @param <T>
	 *            the generic type
	 * @param apiParamValue
	 *            the api param value
	 * @return the internal value by api param value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public <T extends Object> T getInternalValueByApiParamValue(String apiParamValue) throws GPAServeisRuntimeException;

	/**
	 * Gets the internal value list by api param value.
	 *
	 * @param <T>
	 *            the generic type
	 * @param apiParamValue
	 *            the api param value
	 * @return the internal value list by api param value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public <T extends Object> List<T> getInternalValueListByApiParamValue(String apiParamValue) throws GPAServeisRuntimeException;

	/**
	 * Gets the internal value list by api param value list.
	 *
	 * @param <T>
	 *            the generic type
	 * @param apiParamValueList
	 *            the api param value list
	 * @return the internal value list by api param value list
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public <T extends Object> List<T> getInternalValueListByApiParamValueList(String[] apiParamValueList) throws GPAServeisRuntimeException;

	/**
	 * Gets the enum by internal value.
	 *
	 * @param <E>
	 *            the element type
	 * @param internalValue
	 *            the internal value
	 * @return the enum by internal value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public <E extends Enum<E>> E getEnumByInternalValue(Object internalValue) throws GPAServeisRuntimeException;

	/**
	 * Gets the api param value by internal value.
	 *
	 * @param internalValue
	 *            the internal value
	 * @return the api param value by internal value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public String getApiParamValueByInternalValue(Object internalValue) throws GPAServeisRuntimeException;

	/**
	 * Gets the api param value list by internal value.
	 *
	 * @param internalValue
	 *            the internal value
	 * @return the api param value list by internal value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public List<String> getApiParamValueListByInternalValue(Object internalValue) throws GPAServeisRuntimeException;

}
