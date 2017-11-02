package org.softlang.megal.util;

import com.google.common.base.Function;
import com.google.common.collect.BiMap;

public class Bijections {
	public static <T, U> Bijection<T, U> of(Function<? super T, ? extends U> in, Function<? super U, ? extends T> out) {
		return new Bijection<T, U>() {
			@Override
			public U apply(T input) {
				return in.apply(input);
			}

			@Override
			public Bijection<U, T> inverse() {
				return of(out, in);
			}
		};
	}

	public static <T, U> Bijection<T, U> of(BiMap<T, U> corr) {
		return new Bijection<T, U>() {
			@Override
			public U apply(T input) {
				return corr.get(input);
			}

			@Override
			public Bijection<U, T> inverse() {
				return of(corr.inverse());
			}
		};
	}

	public static <T, U, V> Bijection<T, V> concat(Bijection<T, U> a, Bijection<U, V> b) {
		return new Bijection<T, V>() {

			@Override
			public V apply(T input) {
				return b.apply(a.apply(input));
			}

			@Override
			public Bijection<V, T> inverse() {
				return concat(b.inverse(), a.inverse());
			}
		};
	}

	public static <T> Bijection<T, T> repeat(Bijection<T, T> bijection, int n) {
		return new Bijection<T, T>() {
			@Override
			public T apply(T input) {
				for (int i = 0; i < n; i++)
					input = bijection.apply(input);
				for (int i = 0; i < -n; i++)
					input = bijection.inverse().apply(input);

				return input;
			}

			@Override
			public Bijection<T, T> inverse() {
				return repeat(bijection, -n);
			}
		};
	}
}
