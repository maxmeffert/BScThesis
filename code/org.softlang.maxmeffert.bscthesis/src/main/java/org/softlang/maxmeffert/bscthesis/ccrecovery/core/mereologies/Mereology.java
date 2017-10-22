package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import com.google.common.collect.Iterables;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;

import java.util.Optional;
import java.util.function.Predicate;

public class Mereology<TValue extends Comparable<TValue>> implements IMereology<TValue> {

    private final IBinaryRelation<TValue> binaryRelation;

    public Mereology(IBinaryRelation<TValue> binaryRelation) {
        this.binaryRelation = binaryRelation;
    }

    @Override
    public boolean isEmpty() {
        return binaryRelation.isEmpty();
    }

    @Override
    public boolean contains(TValue value) {
        return binaryRelation.getDomainElements().contains(value);
    }

    @Override
    public boolean isPartOf(TValue part, TValue fusion) {
        return binaryRelation.contains(part, fusion);
    }

    @Override
    public boolean isProperPartOf(TValue properPart, TValue fusion) {
        return isPartOf(properPart, fusion) && !isPartOf(fusion, properPart);
    }

    @Override
    public boolean isAtomOf(TValue atom, TValue fusion) {
        return Iterables.contains(getAtomsOf(fusion), atom);
    }

    @Override
    public boolean isAtom(TValue atom) {
        return any(element -> isAtomOf(atom, element));
    }

    @Override
    public boolean isFusion(TValue fusion) {
        return any(element -> isProperPartOf(element, fusion));
    }

    @Override
    public boolean isBottom(TValue bottom) {
        return all(element -> isPartOf(bottom, element));
    }

    @Override
    public boolean isTop(TValue top) {
        return all(element -> isPartOf(element, top));
    }

    @Override
    public boolean all(Predicate<TValue> predicate) {
        return binaryRelation.getDomainElements().stream().allMatch(predicate);
    }

    @Override
    public boolean any(Predicate<TValue> predicate) {
        return binaryRelation.getDomainElements().stream().anyMatch(predicate);
    }

    @Override
    public boolean none(Predicate<TValue> predicate) {
        return binaryRelation.getDomainElements().stream().noneMatch(predicate);
    }

    @Override
    public Optional<TValue> getBottom() {
        for (TValue bottom : filter(element-> isBottom(element))) {
            return Optional.of(bottom);
        }
        return Optional.empty();
    }

    @Override
    public Optional<TValue> getTop() {
        for (TValue top : filter(element-> isTop(element))) {
            return Optional.of(top);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<TValue> getElements() {
        return binaryRelation.getDomainElements();
    }

    @Override
    public Iterable<TValue> getProperPartsOf(TValue value) {
        return filter(element -> isProperPartOf(element, value));
    }

    @Override
    public Iterable<TValue> getPartsOf(TValue value) {
        return filter(element -> isPartOf(element, value));
    }

    @Override
    public Iterable<TValue> getAtomsOf(TValue value) {
        return filter(element -> isAtomOf(element,value));
    }

    @Override
    public Iterable<TValue> filter(Predicate<TValue> predicate) {
        return binaryRelation.getDomainElements(predicate);
    }
}
