package org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees;

public class TreeWalkerFactory implements ITreeWalkerFactory {
    @Override
    public <TValue extends Comparable<TValue>> ITreeWalker<TValue> newTreeWalker() {
        return new TreeWalker<>();
    }
}
