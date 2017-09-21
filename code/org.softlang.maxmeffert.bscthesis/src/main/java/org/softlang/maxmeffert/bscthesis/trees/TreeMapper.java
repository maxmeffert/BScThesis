package org.softlang.maxmeffert.bscthesis.trees;

import java.util.function.Function;

public class TreeMapper<T,R> implements ITreeMapper<T,R> {

    @Override
    public ITree<R> map(ITree<T> tree, Function<T, R> function) {
        ITree<R> newTree = new Tree<>();
        newTree.setValue(function.apply(tree.getValue()));
        for (ITree<T> child : tree.getChildren()) {
            newTree.addChild(map(child, function));
        }
        return newTree;
    }
}
