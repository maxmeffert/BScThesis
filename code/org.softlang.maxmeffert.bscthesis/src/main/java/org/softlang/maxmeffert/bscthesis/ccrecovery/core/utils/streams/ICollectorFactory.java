package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.streams;

import java.util.SortedSet;
import java.util.stream.Collector;

public interface ICollectorFactory {
    <TValue extends Comparable<TValue>> Collector<TValue, ?, SortedSet<TValue>> toSortedSet();
}
