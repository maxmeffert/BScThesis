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
    public boolean containsKey(TKey tKey) {
        return map.containsKey(tKey);
    }

    @Override
    public boolean containsValue(TValue tValue) {
        return map.containsValue(tValue);
    }

    @Override
    public int size() {
        return map.size();
    }
}
