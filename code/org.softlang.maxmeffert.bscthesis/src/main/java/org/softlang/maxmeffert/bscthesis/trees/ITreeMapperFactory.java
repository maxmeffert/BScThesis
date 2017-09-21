package org.softlang.maxmeffert.bscthesis.trees;

public interface ITreeMapperFactory {
    <T,R> ITreeMapper<T,R> newTreeMapper();
}
