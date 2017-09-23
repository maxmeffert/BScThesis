package org.softlang.maxmeffert.bscthesis.graphs.trees;

public class TreeWalkerFactory implements ITreeWalkerFactory {

    @Override
    public <T> ITreeWalker<T> newTreeWalker() {
        return new TreeWalker<>();
    }
}
