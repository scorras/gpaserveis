package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class ApiParamValueTranslator.
 *
 * @param <E>
 *            the element type
 * @param <T>
 *            the generic type
 */
public class ApiParamValueTranslator<E extends Enum<E>, T extends Object> implements BaseApiParamValueTranslator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getApiParamAllowableValues()
	 */
	@Override
	public String getApiParamAllowableValues() throws GPAServeisRuntimeException {
		try {
			ArrayList<String> apiParamList = new ArrayList<String>();
			E[] enumList = getEnumValues(getEnumClass());

			for (E e : enumList) {
				Method method = e.getClass().getDeclaredMethod("getApiParamValue");
				Object object = method.invoke(e);
				apiParamList.add(object.toString());
			}

			return StringUtils.join(apiParamList, ",");
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getEnumByApiParamValue(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E getEnumByApiParamValue(String apiParamValue) throws GPAServeisRuntimeException {
		if (apiParamValue == null) {
			return null;
		}

		try {
			E[] enumList = getEnumValues(getEnumClass());

			for (E e : enumList) {
				Method getApiParamValueMethod = e.getClass().getDeclaredMethod("getApiParamValue");
				Object apiParamValueObject = getApiParamValueMethod.invoke(e);

				if (ObjectUtils.equals(apiParamValueObject, apiParamValue)) {
					return e;
				}
			}
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid");
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getInternalValueByApiParamValue(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getInternalValueByApiParamValue(String apiParamValue) throws GPAServeisRuntimeException {
		T t = null;
		try {
			if (StringUtils.isNotEmpty(apiParamValue)) {
				E e = Enum.valueOf(getEnumClass(), apiParamValue);
				Method method = e.getClass().getMethod("getInternalValue");
				t = (T) method.invoke(e);
			}
			return t;
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getInternalValueListByApiParamValue(java.lang
	 * .String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getInternalValueListByApiParamValue(String apiParamValue) throws GPAServeisRuntimeException {
		ArrayList<T> tList = new ArrayList<T>();

		try {
			if (StringUtils.isNotEmpty(apiParamValue)) {
				E[] enumList = getEnumValues(getEnumClass());

				for (E e : enumList) {
					Method getApiParamValueMethod = e.getClass().getDeclaredMethod("getApiParamValue");
					Object apiParamValueObject = getApiParamValueMethod.invoke(e);

					if (ObjectUtils.equals(apiParamValueObject, apiParamValue)) {
						Method getInternalValueMethod = e.getClass().getMethod("getInternalValue");
						tList.add((T) getInternalValueMethod.invoke(e));
					}
				}
			}

			if (CollectionUtils.isNotEmpty(tList)) {
				return tList;
			}

			throw new GPAServeisRuntimeException("El valor indicat no és vàlid");
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getInternalValueListByApiParamValueList(java.
	 * lang.String[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getInternalValueListByApiParamValueList(String[] apiParamValueList) throws GPAServeisRuntimeException {
		if (ArrayUtils.isEmpty(apiParamValueList)) {
			return null;
		}

		ArrayList<T> internalValueList = new ArrayList<T>();
		for (String apiParamValue : apiParamValueList) {
			if (StringUtils.isNotEmpty(apiParamValue)) {
				internalValueList.add(getInternalValueByApiParamValue(apiParamValue));
			}
		}
		return internalValueList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getEnumByInternalValue(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E getEnumByInternalValue(Object internalValue) throws GPAServeisRuntimeException {
		if (internalValue == null) {
			return null;
		}

		try {
			E[] enumList = getEnumValues(getEnumClass());

			for (E e : enumList) {
				Method getInternalValueMethod = e.getClass().getDeclaredMethod("getInternalValue");
				Object internalValueObject = getInternalValueMethod.invoke(e);

				if (ObjectUtils.equals(internalValueObject, internalValue)) {
					return e;
				}
			}
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid");
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getApiParamValueByInternalValue(java.lang.
	 * Object)
	 */
	@Override
	public String getApiParamValueByInternalValue(Object internalValue) throws GPAServeisRuntimeException {
		if (internalValue == null) {
			return null;
		}

		try {
			E[] enumList = getEnumValues(getEnumClass());

			for (E e : enumList) {
				Method getInternalValueMethod = e.getClass().getDeclaredMethod("getInternalValue");
				Object internalValueObject = getInternalValueMethod.invoke(e);

				if (ObjectUtils.equals(internalValueObject, internalValue)) {
					Method getApiParamValueMethod = e.getClass().getMethod("getApiParamValue");
					Object apiParamValueObject = getApiParamValueMethod.invoke(e);
					return apiParamValueObject.toString();
				}
			}
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid");
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.
	 * BaseApiParamValueTranslator#getApiParamValueListByInternalValue(java.lang
	 * .Object)
	 */
	@Override
	public List<String> getApiParamValueListByInternalValue(Object internalValue) throws GPAServeisRuntimeException {
		ArrayList<String> apiParamValueList = new ArrayList<String>();

		try {
			if (internalValue != null) {
				E[] enumList = getEnumValues(getEnumClass());

				for (E e : enumList) {
					Method getInternalValueMethod = e.getClass().getDeclaredMethod("getInternalValue");
					Object internalValueObject = getInternalValueMethod.invoke(e);

					if (ObjectUtils.equals(internalValueObject, internalValue)) {
						Method getApiParamValueMethod = e.getClass().getMethod("getApiParamValue");
						apiParamValueList.add((getApiParamValueMethod.invoke(e)).toString());
					}
				}
			}

			return apiParamValueList;
		} catch (Exception e) {
			throw new GPAServeisRuntimeException("El valor indicat no és vàlid", e);
		}
	}

	/**
	 * Gets the enum class.
	 *
	 * @return the enum class
	 */
	@SuppressWarnings({ "unchecked" })
	private final Class<E> getEnumClass() {
		ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<E> clazz = (Class<E>) (superclass).getActualTypeArguments()[0];
		return clazz;
	}

	/**
	 * Gets the enum values.
	 *
	 * @param <E>
	 *            the element type
	 * @param enumClass
	 *            the enum class
	 * @return the enum values
	 * @throws NoSuchMethodException
	 *             the no such method exception
	 * @throws SecurityException
	 *             the security exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	@SuppressWarnings("unchecked")
	private static <E extends Enum<E>> E[] getEnumValues(Class<E> enumClass)
	        throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = enumClass.getDeclaredMethod("values");
		Object object = method.invoke(null);
		return (E[]) object;
	}

}
