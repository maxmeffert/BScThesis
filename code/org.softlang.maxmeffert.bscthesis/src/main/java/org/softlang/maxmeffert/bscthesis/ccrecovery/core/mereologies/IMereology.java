package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

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
	IView<TValue> getElements();
	IView<TValue> getProperPartsOf(TValue value);
	IView<TValue> getPartsOf(TValue value);
	IView<TValue> getAtomsOf(TValue value);
	IView<TValue> filter(Predicate<TValue> predicate);
}
