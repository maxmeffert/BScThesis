package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Iterables;

import java.util.function.Consumer;

public class TreeWalker<T extends Comparable<T>> implements ITreeWalker<T> {
    @Override
    public void walk(ITree<T> tree, Consumer<ITree<T>> consumer) {
        consumer.accept(tree);
        for (ITree<T> child : tree.getChildren()) {
            walk(child, consumer);
        }
    }
}
