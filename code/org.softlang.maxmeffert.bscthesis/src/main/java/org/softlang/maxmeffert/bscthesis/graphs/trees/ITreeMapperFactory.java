package org.softlang.maxmeffert.bscthesis.graphs.trees;

public interface ITreeMapperFactory {
    <T,R> ITreeMapper<T,R> newTreeMapper();
}
