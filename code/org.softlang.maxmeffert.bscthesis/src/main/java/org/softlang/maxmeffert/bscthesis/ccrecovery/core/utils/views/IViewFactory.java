package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views;

import java.util.Map;

public interface IViewFactory {

    <TValue> IView<TValue> newView(Iterable<TValue> iterable);
    <TKey,TValue> IMapView<TKey,TValue> newMapView(Map<TKey,TValue> map);

}
