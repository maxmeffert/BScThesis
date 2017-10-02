package org.softlang.maxmeffert.bscthesis.core.trees;

public interface ITreeWalkerFactory {
    <TValue extends Comparable<TValue>> ITreeWalker<TValue> newTreeWalker();
}
