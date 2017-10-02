package org.softlang.maxmeffert.bscthesis.utils;

import com.google.common.collect.Iterables;

public class IterableUtils implements IIterableUtils {
    @Override
    public <TValue> boolean contains(Iterable<TValue> iterable, TValue value) {
        return Iterables.contains(iterable, value);
    }

    @Override
    public <TValue> Iterable<TValue> concat(Iterable<TValue>... iterables) {
        return Iterables.concat(iterables);
    }
}
