package org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees;

public interface ITreeWalkerFactory {
    <TValue extends Comparable<TValue>> ITreeWalker<TValue> newTreeWalker();
}
