package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

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
	TValue getBottom();
	TValue getTop();
	Iterable<TValue> getElements();
	Iterable<TValue> getProperPartsOf(TValue value);
	Iterable<TValue> getPartsOf(TValue value);
	Iterable<TValue> getAtomsOf(TValue value);
}
