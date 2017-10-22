package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import java.util.Optional;
import java.util.function.Predicate;

public interface IMereology<TValue extends Comparable<TValue>> {
	boolean isEmpty();
	boolean contains(TValue value);
	boolean isPartOf(TValue part, TValue fusion);
	boolean isProperPartOf(TValue properPart, TValue fusion);
	boolean isAtomOf(TValue atom, TValue fusion);
	boolean isAtom(TValue value);
	boolean isFusion(TValue value);
	boolean isBottom(TValue value);
	boolean isTop(TValue value);
	boolean all(Predicate<TValue> predicate);
	boolean any(Predicate<TValue> predicate);
	boolean none(Predicate<TValue> predicate);
	Optional<TValue> getBottom();
	Optional<TValue> getTop();
	Iterable<TValue> getElements();
	Iterable<TValue> getProperPartsOf(TValue value);
	Iterable<TValue> getPartsOf(TValue value);
	Iterable<TValue> getAtomsOf(TValue value);
	Iterable<TValue> filter(Predicate<TValue> predicate);
}
