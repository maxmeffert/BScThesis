package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import com.google.common.collect.Iterables;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;

import java.util.Optional;
import java.util.function.Predicate;

public class Mereology<TValue extends Comparable<TValue>> implements IMereology<TValue> {

    private final IDiGraph<TValue> diGraph;

    public Mereology(IDiGraph<TValue> diGraph) {
        this.diGraph = diGraph;
    }

    @Override
    public boolean isEmpty() {
        return diGraph.isEmpty();
    }

    @Override
    public boolean contains(TValue value) {
        return diGraph.hasNode(value);
    }

    @Override
    public boolean isPartOf(TValue part, TValue fusion) {
        return diGraph.hasEdge(part, fusion);
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
        return diGraph.allNodes(predicate);
    }

    @Override
    public boolean any(Predicate<TValue> predicate) {
        return diGraph.anyNodes(predicate);
    }

    @Override
    public boolean none(Predicate<TValue> predicate) {
        return diGraph.noneNodes(predicate);
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
        return diGraph.getNodes();
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
        return diGraph.getNodes(predicate);
    }
}
