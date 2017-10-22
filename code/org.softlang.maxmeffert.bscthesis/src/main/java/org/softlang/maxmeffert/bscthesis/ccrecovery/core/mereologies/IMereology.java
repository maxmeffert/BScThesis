package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import java.util.Optional;
import java.util.SortedSet;
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

	boolean allPartsOf(TValue value, Predicate<TValue> predicate);
	boolean anyPartsOf(TValue value, Predicate<TValue> predicate);
	boolean nonePartsOf(TValue value, Predicate<TValue> predicate);

	Optional<TValue> getBottom();
	Optional<TValue> getTop();
	SortedSet<TValue> getElements();
	SortedSet<TValue> getProperPartsOf(TValue value);
	SortedSet<TValue> getPartsOf(TValue value);
	SortedSet<TValue> getAtomsOf(TValue value);
	SortedSet<TValue> filter(Predicate<TValue> predicate);
}
