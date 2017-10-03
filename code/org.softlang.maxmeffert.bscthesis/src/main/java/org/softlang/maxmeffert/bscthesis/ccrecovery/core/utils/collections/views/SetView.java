package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

import java.util.Set;

public class SetView<TValue> extends CollectionView<TValue> implements ISetView<TValue> {
    public SetView(Set<TValue> set) {
        super(set);
    }
}
