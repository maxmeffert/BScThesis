package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BinaryRelationNodes<N extends Comparable<N>> implements IBinaryRelationNodes<N> {

    public static class Builder<N extends Comparable<N>> {

        private final List<N> nodes = Lists.newLinkedList();

        public Builder<N> add(N node) {
            if (!nodes.contains(node)) {
                nodes.add(node);
            }
            return this;
        }

        public BinaryRelationNodes<N> build() {
            Collections.sort(nodes);
            return new BinaryRelationNodes<>(nodes);
        }

    }

    public static <N extends Comparable<N>> Builder<N> builder() {
        return new Builder<>();
    }

    private final List<N> nodes;

    public BinaryRelationNodes(List<N> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean contains(N node) {
        return nodes.contains(node);
    }

    @Override
    public int indexOf(N node) {
        return nodes.indexOf(node);
    }

    @Override
    public N nodeOf(int index) {
        return nodes.get(index);
    }

    @Override
    public int size() {
        return nodes.size();
    }

    @Override
    public Iterator<N> iterator() {
        return nodes.iterator();
    }
}
