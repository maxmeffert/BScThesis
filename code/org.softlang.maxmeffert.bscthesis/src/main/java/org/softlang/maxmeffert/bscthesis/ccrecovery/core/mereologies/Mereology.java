package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

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
        return diGraph.getNodes().contains(value);
    }

    @Override
    public boolean isPartOf(TValue part, TValue fusion) {
        return diGraph.getSourceNodesOf(fusion).contains(part);
//        return getPartsOf(fusion).contains(part);
    }

    @Override
    public boolean isProperPartOf(TValue properPart, TValue fusion) {
        return isPartOf(properPart, fusion) && !isPartOf(fusion, properPart);
    }

    @Override
    public boolean isAtomOf(TValue atom, TValue fusion) {
        return getAtomsOf(fusion).contains(atom);
    }

    @Override
    public boolean isAtom(TValue value) {
        return false;
    }

    @Override
    public boolean isFusion(TValue value) {
        return false;
    }

    @Override
    public boolean isBottom(TValue value) {
        return false;
    }

    @Override
    public boolean isTop(TValue value) {
        return false;
    }

    @Override
    public boolean all(Predicate<TValue> predicate) {
        return getElements().all(predicate);
    }

    @Override
    public boolean any(Predicate<TValue> predicate) {
        return getElements().any(predicate);
    }

    @Override
    public boolean none(Predicate<TValue> predicate) {
        return getElements().none(predicate);
    }

    @Override
    public Optional<TValue> getBottom() {
        return Optional.empty();
    }

    @Override
    public Optional<TValue> getTop() {
        return Optional.empty();
    }

    @Override
    public IView<TValue> getElements() {
        return diGraph.getNodes();
    }

    @Override
    public IView<TValue> getProperPartsOf(TValue value) {
        return filter(element -> isProperPartOf(element, value));
    }

    @Override
    public IView<TValue> getPartsOf(TValue value) {
        return filter(element -> isPartOf(element, value));
//        return diGraph.getSourceNodesOf(value);
    }

    @Override
    public IView<TValue> getAtomsOf(TValue value) {
        return filter(element -> isAtomOf(element,value));
    }

    @Override
    public IView<TValue> filter(Predicate<TValue> predicate) {
        return diGraph.filter(predicate);
    }
}
