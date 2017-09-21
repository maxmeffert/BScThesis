package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeWalkerFactory {
    <T> ITreeWalker<T> newTreeWalker();
}
