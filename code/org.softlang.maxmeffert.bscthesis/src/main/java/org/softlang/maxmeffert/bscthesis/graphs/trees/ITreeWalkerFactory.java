package org.softlang.maxmeffert.bscthesis.graphs.trees;

public interface ITreeWalkerFactory {
    <T> ITreeWalker<T> newTreeWalker();
}
