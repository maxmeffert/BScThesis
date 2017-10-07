package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

import java.util.Map;

public class MapView<TKey,TValue> implements IMapView<TKey,TValue> {

    private final Map<TKey,TValue> map;

    public MapView(Map<TKey, TValue> map) {
        this.map = map;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public IView<TKey> keys() {
        return new View<>(map.keySet());
    }

    @Override
    public IView<TValue> values() {
        return new View<>(map.values());
    }

    @Override
    public TValue get(TKey key) {
        return map.get(key);
    }
}
