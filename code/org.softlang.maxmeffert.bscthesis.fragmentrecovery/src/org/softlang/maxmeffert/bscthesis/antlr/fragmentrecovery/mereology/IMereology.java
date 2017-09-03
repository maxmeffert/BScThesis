package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import java.util.Optional;
import java.util.Set;

public interface IMereology<T extends Comparable<T>> {

	boolean contains(T a);
	boolean isPartOf(T a, T b);
	boolean isProperPartOf(T a, T b);
	boolean isAtomOf(T a, T b);
	Optional<Iterable<T>> getProperPartsOf(T a);
	Optional<Iterable<T>> getPartsOf(T a);
	Optional<Iterable<T>> getAtomsOf(T a);
}
