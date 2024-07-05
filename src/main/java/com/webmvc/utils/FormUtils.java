package com.webmvc.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtils {

	private FormUtils() {

	}

	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object;

		try {
			object = tClass.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
			return object;
		} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}

		return null;
	}

}
