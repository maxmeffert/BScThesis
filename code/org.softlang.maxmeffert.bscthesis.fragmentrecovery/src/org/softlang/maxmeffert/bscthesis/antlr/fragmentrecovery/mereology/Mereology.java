package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import com.google.common.collect.Streams;

import java.util.Optional;

public class Mereology<T extends Comparable<T>> implements IMereology<T> {


    public static class Builder<T extends Comparable<T>> {

        private final BinaryRelation.Builder<T> binaryRelationBuilder = BinaryRelation.builder();

        public Builder<T> partOf(T left, T right) {
            binaryRelationBuilder.add(left, right);
            return this;
        }

        public Mereology<T> build() {
            return new Mereology<>(binaryRelationBuilder.buildReflexiveTransitiveClosure());
        }

    }

    public static <T extends Comparable<T>> Builder<T> builder() {
        return new Builder<>();
    }

    private final IBinaryRelation<T> partOf;

    private Mereology(IBinaryRelation<T> partOf) {
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
        return isPartOf(left, right) && Streams.stream(partOf.getNodes()).noneMatch(node -> isProperPartOf(node, left));
    }

    @Override
    public Optional<Iterable<T>> getProperPartsOf(T a) {
        return null;
    }

    @Override
    public Optional<Iterable<T>> getPartsOf(T a) {
        return null;
    }

    @Override
    public Optional<Iterable<T>> getAtomsOf(T a) {
        return null;
    }
}
