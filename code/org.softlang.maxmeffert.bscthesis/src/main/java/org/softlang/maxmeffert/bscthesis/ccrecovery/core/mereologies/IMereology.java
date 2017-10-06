package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISetView;

import java.util.Optional;

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
	Optional<TValue> getBottom();
	Optional<TValue> getTop();
	ISetView<TValue> getElements();
	ISetView<TValue> getProperPartsOf(TValue value);
	ISetView<TValue> getPartsOf(TValue value);
	ISetView<TValue> getAtomsOf(TValue value);
}
