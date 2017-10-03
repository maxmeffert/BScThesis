package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetView<TValue> extends CollectionView<TValue> implements ISetView<TValue> {
    public SetView(Set<TValue> set) {
        super(set);
    }

    @Override
    public ISetView<TValue> union(ISetView<TValue> set) {
        SortedSet<TValue> sortedSet = new TreeSet<>();
        forEach(sortedSet::add);
        set.forEach(sortedSet::add);
        return new SetView<>(sortedSet);
    }
}
