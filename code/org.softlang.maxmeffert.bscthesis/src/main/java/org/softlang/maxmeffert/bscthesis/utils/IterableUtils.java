package org.softlang.maxmeffert.bscthesis.utils;

import com.google.common.collect.Iterables;

public class IterableUtils implements IIterableUtils {
    @Override
    public <TValue> boolean contains(Iterable<TValue> iterable, TValue value) {
        return Iterables.contains(iterable, value);
    }
}
