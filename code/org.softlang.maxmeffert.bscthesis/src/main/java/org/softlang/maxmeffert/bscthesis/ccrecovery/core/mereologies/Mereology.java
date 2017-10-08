package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

import java.util.Optional;

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
        return getPartsOf(fusion).contains(part);
    }

    @Override
    public boolean isProperPartOf(TValue properPart, TValue fusion) {
        return getProperPartsOf(fusion).contains(properPart);
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
    public Optional<TValue> getBottom() {
        return null;
    }

    @Override
    public Optional<TValue> getTop() {
        return null;
    }

    @Override
    public IView<TValue> getElements() {
        return diGraph.getNodes();
    }

    @Override
    public IView<TValue> getProperPartsOf(TValue value) {
        return null;
    }

    @Override
    public IView<TValue> getPartsOf(TValue value) {
        return diGraph.getSourceNodesOf(value);
    }

    @Override
    public IView<TValue> getAtomsOf(TValue value) {
        return null;
    }
}
