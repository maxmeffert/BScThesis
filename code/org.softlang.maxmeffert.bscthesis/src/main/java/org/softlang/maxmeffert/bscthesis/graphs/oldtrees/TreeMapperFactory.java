package org.softlang.maxmeffert.bscthesis.graphs.oldtrees;

public class TreeMapperFactory implements ITreeMapperFactory {
    @Override
    public <T, R> ITreeMapper<T, R> newTreeMapper() {
        return new TreeMapper<>();
    }
}
