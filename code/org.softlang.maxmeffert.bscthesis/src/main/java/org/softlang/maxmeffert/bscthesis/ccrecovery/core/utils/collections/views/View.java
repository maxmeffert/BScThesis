package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views;

import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;

import java.util.Iterator;
import java.util.function.Predicate;

public class View<TValue> implements IView<TValue> {

    private final Iterable<TValue> iterable;

    public View(Iterable<TValue> iterable) {
        this.iterable = iterable;
    }

    @Override
    public boolean isEmpty() {
        return Iterables.isEmpty(iterable);
    }

    @Override
    public boolean contains(TValue value) {
        return Iterables.contains(iterable, value);
    }

    @Override
    public boolean containsAll(Iterable<TValue> iterable) {
        return Streams.stream(iterable).allMatch(x -> contains(x));
    }

    @Override
    public boolean containsAny(Iterable<TValue> iterable) {
        return Streams.stream(iterable).anyMatch(x -> contains(x));
    }

    @Override
    public boolean containsNone(Iterable<TValue> iterable) {
        return Streams.stream(iterable).noneMatch(x -> contains(x));
    }

    @Override
    public boolean all(Predicate<TValue> predicate) {
        return Streams.stream(this).allMatch(predicate);
    }

    @Override
    public boolean any(Predicate<TValue> predicate) {
        return Streams.stream(this).anyMatch(predicate);
    }

    @Override
    public boolean none(Predicate<TValue> predicate) {
        return Streams.stream(this).noneMatch(predicate);
    }

    @Override
    public IView<TValue> filter(Predicate<TValue> predicate) {
        return new View<>(() -> Streams.stream(this).filter(predicate).iterator());
    }

    @Override
    public int size() {
        return Iterables.size(iterable);
    }

    @Override
    public Iterator<TValue> iterator() {
        return iterable.iterator();
    }
}
