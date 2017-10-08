package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views;

import java.util.Map;

public class ViewFactory implements IViewFactory {
    @Override
    public <TValue> IView<TValue> newView(Iterable<TValue> iterable) {
        return new View<>(iterable);
    }

    @Override
    public <TKey, TValue> IMapView<TKey, TValue> newMapView(Map<TKey, TValue> map) {
        return new MapView<>(map);
    }
}
