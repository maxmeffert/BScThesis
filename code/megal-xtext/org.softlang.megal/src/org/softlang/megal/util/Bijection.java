package org.softlang.megal.util;

import com.google.common.base.Function;

public interface Bijection<T, U> extends Function<T, U> {
	Bijection<U, T> inverse();
}