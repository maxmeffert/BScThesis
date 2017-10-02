package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeWalkerFactory {
    <TValue extends Comparable<TValue>> ITreeWalker<TValue> newTreeWalker();
}
