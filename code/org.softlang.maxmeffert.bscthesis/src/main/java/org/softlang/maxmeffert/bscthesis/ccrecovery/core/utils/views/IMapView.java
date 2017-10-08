package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.tuples.IPair;

public interface IMapView<TKey,TValue> extends IView<IPair<TKey,TValue>> {
    IView<TKey> keys();
    IView<TValue> values();
    TValue valueOf(TKey key);
}
