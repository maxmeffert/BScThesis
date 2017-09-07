package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereologies;

import com.google.common.collect.Streams;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.relations.IBinaryRelation;

import java.util.Optional;

public class Mereology<T extends Comparable<T>> implements IMereology<T> {

    private final IBinaryRelation<T> partOf;

    public Mereology(IBinaryRelation<T> partOf) {
        this.partOf = partOf;
    }


    @Override
    public boolean contains(T value) {
        return partOf.contains(value);
    }

    @Override
    public boolean isPartOf(T left, T right) {
        return partOf.contains(left, right);
    }

    @Override
    public boolean isProperPartOf(T left, T right) {
        return isPartOf(left, right) && !isPartOf(right, left);
    }

    @Override
    public boolean isAtomOf(T left, T right) {
        return isPartOf(left, right)
                && Streams.stream(partOf.getValues()).noneMatch(node -> isProperPartOf(node, left));
    }

    @Override
    public Optional<Iterable<T>> getProperPartsOf(T value) {
        return null;
    }

    @Override
    public Optional<Iterable<T>> getPartsOf(T value) {
        return null;
    }

    @Override
    public Optional<Iterable<T>> getAtomsOf(T value) {
        return null;
    }
}
