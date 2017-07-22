package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import java.util.Optional;
import java.util.Set;

public interface Mereology<T extends Comparable<T>> {

	public void partOf(T a, T b);

	public Optional<Set<T>> getProperPartsOf(T a);
	public Optional<Set<T>> getPartsOf(T a);
	public Optional<Set<T>> getAtomsOf(T a);
	
	public boolean isPartOf(T a, T b);
	public boolean isProperPartOf(T a, T b);
	public boolean isAtomOf(T a, T b);
	
	
}
