package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import com.google.common.collect.Sets;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.*;

public class BinaryRelation<T extends Comparable<T>> extends SortedSetProxy<IComparablePair<T,T>> implements IBinaryRelation<T> {

    private final IDiGraph<T> diGraph;

    public BinaryRelation(IDiGraph<T> diGraph) {
        super(Sets.newTreeSet());
        this.diGraph = diGraph;
        updateEdges();
    }

    private void updateEdges() {
        sortedSet.clear();
        sortedSet.addAll(diGraph.getEdges());
    }

    @Override
    public boolean add(IComparablePair<T, T> ttiComparablePair) {
        boolean changed = diGraph.addEdge(ttiComparablePair);
        updateEdges();
        return changed;
    }

    @Override
    public boolean remove(Object obj) {
        boolean changed = false;
        if (obj instanceof IComparablePair) {
            changed = diGraph.removeEdge((IComparablePair<T, T>) obj);
            updateEdges();
        }
        return changed;
    }

    @Override
    public boolean addAll(Collection<? extends IComparablePair<T, T>> collection) {
        boolean changed = false;
        for (IComparablePair<T,T> edge : collection) {
            changed |= add(edge);
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean changed = false;
        for (Object edge : this) {
            if (!collection.contains(edge)) {
                changed |= remove(edge);
            }
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        for (Object edge : collection) {
            changed |= remove(edge);
        }
        return changed;
    }

    @Override
    public void clear() {
        diGraph.clear();
        updateEdges();
    }

    @Override
    public void add(T a, T b) {
        diGraph.addEdge(a, b);
        updateEdges();
    }

    @Override
    public void remove(T a, T b) {
        diGraph.removeEdge(a, b);
        updateEdges();
    }

    @Override
    public IBinaryRelation<T> getReflexiveClosure() {
        return new BinaryRelation<>(diGraph.getReflexiveClosure());
    }

    @Override
    public IBinaryRelation<T> getTransitiveClosure() {
        return new BinaryRelation<>(diGraph.getTransitiveClosure());
    }

    @Override
    public IBinaryRelation<T> getReflexiveTransitiveClosure() {
        return new BinaryRelation<>(diGraph.getReflexiveTransitiveClosure());
    }
}
