package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import com.google.common.collect.Sets;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public boolean add(T a, T b) {
        boolean changed = diGraph.addEdge(a, b);
        updateEdges();
        return changed;
    }

    @Override
    public boolean remove(T a, T b) {
        boolean changed = diGraph.removeEdge(a, b);
        updateEdges();
        return changed;
    }

    @Override
    public boolean contains(T a, T b) {
        return diGraph.hasEdge(a, b);
    }

    @Override
    public SortedSet<T> getDomainElements() {
        return diGraph.getNodes();
    }

    @Override
    public SortedSet<T> getDomainElements(Predicate<T> predicate) {
        return getDomainElements().stream().filter(predicate).collect(Collectors.toCollection(Sets::newTreeSet));
    }

    @Override
    public IBinaryRelation<T> getCopy() {
        return new BinaryRelation<>(diGraph.getCopy());
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
