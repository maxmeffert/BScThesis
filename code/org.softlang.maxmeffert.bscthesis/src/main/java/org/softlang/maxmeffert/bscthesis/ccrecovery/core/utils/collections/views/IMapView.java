package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

public interface IMapView<TKey,TValue> {
    boolean isEmpty();
    IView<TKey> keys();
    IView<TValue> values();
    TValue get(TKey key);
    int size();
}
