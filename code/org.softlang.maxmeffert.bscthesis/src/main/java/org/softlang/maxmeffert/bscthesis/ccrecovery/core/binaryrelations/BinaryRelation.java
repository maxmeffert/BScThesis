package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import com.google.common.collect.Sets;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IComparablePair;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class BinaryRelation<T extends Comparable<T>> implements IBinaryRelation<T> {

    private final IDiGraph<T> diGraph;
    private SortedSet<IComparablePair<T,T>> edges = Sets.newTreeSet();

    public BinaryRelation(IDiGraph<T> diGraph) {
        this.diGraph = diGraph;
        updateEdges();
    }

    private void updateEdges() {
        edges = diGraph.getEdges();
    }

    @Override
    public Comparator<? super IComparablePair<T, T>> comparator() {
        return edges.comparator();
    }

    @Override
    public SortedSet<IComparablePair<T, T>> subSet(IComparablePair<T, T> ttiComparablePair, IComparablePair<T, T> e1) {
        return edges.subSet(ttiComparablePair, e1);
    }

    @Override
    public SortedSet<IComparablePair<T, T>> headSet(IComparablePair<T, T> ttiComparablePair) {
        return edges.headSet(ttiComparablePair);
    }

    @Override
    public SortedSet<IComparablePair<T, T>> tailSet(IComparablePair<T, T> ttiComparablePair) {
        return edges.tailSet(ttiComparablePair);
    }

    @Override
    public IComparablePair<T, T> first() {
        return edges.first();
    }

    @Override
    public IComparablePair<T, T> last() {
        return edges.last();
    }

    @Override
    public int size() {
        return edges.size();
    }

    @Override
    public boolean isEmpty() {
        return edges.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return edges.contains(o);
    }

    @Override
    public Iterator<IComparablePair<T, T>> iterator() {
        return edges.iterator();
    }

    @Override
    public Object[] toArray() {
        return edges.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return edges.toArray(ts);
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
    public boolean containsAll(Collection<?> collection) {
        return edges.containsAll(collection);
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
    public String toString() {
        return edges.toString();
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
