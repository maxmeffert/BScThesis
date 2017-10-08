package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IPair;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.Pair;

import java.util.Map;

public class MapView<TKey,TValue> extends View<IPair<TKey,TValue>> implements IMapView<TKey,TValue> {

    private final Map<TKey,TValue> map;

    public MapView(Map<TKey, TValue> map) {
        super(map.entrySet().stream().map(entry -> (IPair<TKey,TValue>) new Pair<>(entry.getKey(), entry.getValue())));
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
    public TValue valueOf(TKey key) {
        return map.get(key);
    }

}
