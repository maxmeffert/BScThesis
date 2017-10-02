package org.softlang.maxmeffert.bscthesis.core.trees;

public class TreeWalkerFactory implements ITreeWalkerFactory {
    @Override
    public <TValue extends Comparable<TValue>> ITreeWalker<TValue> newTreeWalker() {
        return new TreeWalker<>();
    }
}
