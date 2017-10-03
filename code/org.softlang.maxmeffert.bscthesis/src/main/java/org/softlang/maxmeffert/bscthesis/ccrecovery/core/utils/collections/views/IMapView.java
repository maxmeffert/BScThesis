package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

public interface IMapView<TKey,TValue> {
    boolean isEmpty();
    boolean containsKey(TKey key);
    boolean containsValue(TValue value);
    TValue get(TKey key);
    ISetView<TKey> keySet();
    ICollectionView<TValue> values();
    int size();
}
