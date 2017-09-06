package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.function.Consumer;

public interface ITreeWalker<T extends Comparable<T>> {

    void walk(ITree<T> tree, Consumer<ITree<T>> consumer);

}
