package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

public abstract class AbstractGraph<T extends Comparable<T>> implements IGraph<T> {

    @Override
    public Optional<T> getFirstVertex() {
        for (T vertex : getVertices()) {
            return Optional.of(vertex);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<T> iterator() {
        Optional<T> startVertex = getFirstVertex();
        if (startVertex.isPresent()) {
            return DepthFirstIterator.of(this::getAdjacentVerticesOf, startVertex.get());
        }
        return Collections.emptyIterator();
    }
}
