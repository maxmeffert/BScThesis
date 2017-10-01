package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

public interface ITreeWalkerFactory {
    <T> ITreeWalker<T> newTreeWalker();
}
