package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter;

import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.exception.GPAServeisRuntimeException;

/**
 * The Interface BaseApiParamValueConverter.
 */
public interface BaseApiParamValueConverter {

	/**
	 * Gets the api param allowable values.
	 *
	 * @return the api param allowable values
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public String getApiParamAllowableValues() throws GPAServeisRuntimeException;

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
	 * Gets the api param value by internal value.
	 *
	 * @param internalValue
	 *            the internal value
	 * @return the api param value by internal value
	 * @throws GPAServeisRuntimeException
	 *             the GPA serveis runtime exception
	 */
	public String getApiParamValueByInternalValue(Object internalValue) throws GPAServeisRuntimeException;
}
