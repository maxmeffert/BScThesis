package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

import java.util.function.Predicate;

public interface IView<TValue> extends Iterable<TValue> {
    boolean isEmpty();
    boolean contains(TValue value);
    boolean containsAll(Iterable<TValue> values);
    boolean containsAny(Iterable<TValue> values);
    boolean containsNone(Iterable<TValue> values);
    boolean all(Predicate<TValue> predicate);
    boolean any(Predicate<TValue> predicate);
    boolean none(Predicate<TValue> predicate);
    IView<TValue>  filter(Predicate<TValue> predicate);
    int size();
}
