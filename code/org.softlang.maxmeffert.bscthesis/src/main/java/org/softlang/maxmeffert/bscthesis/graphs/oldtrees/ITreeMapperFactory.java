package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

public interface ITreeMapperFactory {
    <T,R> ITreeMapper<T,R> newTreeMapper();
}
