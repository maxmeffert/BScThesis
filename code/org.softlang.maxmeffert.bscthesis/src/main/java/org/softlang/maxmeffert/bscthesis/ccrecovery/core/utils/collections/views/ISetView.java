package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

public interface ISetView<TValue> extends ICollectionView<TValue> {
    ISetView<TValue> union(ISetView<TValue> set);
}
