package org.softlang.megal.plugins.util;

import static com.google.common.collect.Iterables.getLast;

import java.lang.reflect.InvocationTargetException;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;

public class Utils {
	public static String toFirstUpper(String s) {
		if (s.isEmpty())
			return s;

		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	public static Optional<Object> getForXML(Object object, String field) {
		field = getLast(Splitter.on(':').split(field));
		try {
			return Optional.of(object.getClass().getField(field).get(object));
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException fe) {
			try {
				return Optional.of(object.getClass()
						.getMethod("get" + toFirstUpper(field)).invoke(object));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException ge) {
				return Optional.absent();
			}
		}
	}

}
