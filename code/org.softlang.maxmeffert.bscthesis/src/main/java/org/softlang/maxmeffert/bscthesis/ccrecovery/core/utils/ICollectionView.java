package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils;

import java.util.Collection;

public interface ICollectionView<TValue> extends Iterable<TValue> {
    boolean isEmpty();
    boolean contains(TValue value);
    boolean containsAll(Collection<TValue> values);
    int size();
}
