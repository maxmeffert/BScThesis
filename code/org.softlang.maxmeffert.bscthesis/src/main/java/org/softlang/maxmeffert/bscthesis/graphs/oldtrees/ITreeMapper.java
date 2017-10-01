package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

import java.util.function.Function;

public interface ITreeMapper<T,R> {
    ITree<R> map(ITree<T> tree, Function<T,R> function);
}
