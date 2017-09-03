package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereology;

import java.util.Optional;
import java.util.Set;

public interface IMereology<T extends Comparable<T>> {

	boolean contains(T value);
	boolean isPartOf(T left, T right);
	boolean isProperPartOf(T left, T right);
	boolean isAtomOf(T left, T right);
	Optional<Iterable<T>> getProperPartsOf(T value);
	Optional<Iterable<T>> getPartsOf(T value);
	Optional<Iterable<T>> getAtomsOf(T value);
}
