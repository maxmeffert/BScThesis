package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import java.util.Set;

public interface IMereology<T extends Comparable<T>> extends Iterable<T> {
	boolean isEmpty();
	boolean contains(T value);
	boolean isPartOf(T left, T right);
	boolean isProperPartOf(T left, T right);
	boolean isAtomOf(T left, T right);
	boolean isAtom(T value);
	boolean isFusion(T value);
	boolean isBottom(T value);
	boolean isTop(T value);
	T getBottom();
	T getTop();
	Set<T> getProperPartsOf(T value);
	Set<T> getPartsOf(T value);
	Set<T> getAtomsOf(T value);
}
