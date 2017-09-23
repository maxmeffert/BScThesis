package org.softlang.maxmeffert.bscthesis.graphs.trees;

public class TreeMapperFactory implements ITreeMapperFactory {
    @Override
    public <T, R> ITreeMapper<T, R> newTreeMapper() {
        return new TreeMapper<>();
    }
}
