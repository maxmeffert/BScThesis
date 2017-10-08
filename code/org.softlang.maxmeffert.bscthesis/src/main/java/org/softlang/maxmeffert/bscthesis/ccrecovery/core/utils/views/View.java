package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views;

import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.Tree;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class View<TValue> implements IView<TValue> {

    private final Iterable<TValue> iterable;

    public View(Stream<TValue> stream) {
        this(stream.iterator());
    }

    public View(Iterator<TValue> iterator) {
        this(() -> iterator);
    }

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
        return stream().allMatch(x -> contains(x));
    }

    @Override
    public boolean containsAny(Iterable<TValue> iterable) {
        return stream().anyMatch(x -> contains(x));
    }

    @Override
    public boolean containsNone(Iterable<TValue> iterable) {
        return stream().noneMatch(x -> contains(x));
    }

    @Override
    public boolean all(Predicate<TValue> predicate) {
        return stream().allMatch(predicate);
    }

    @Override
    public boolean any(Predicate<TValue> predicate) {
        return stream().anyMatch(predicate);
    }

    @Override
    public boolean none(Predicate<TValue> predicate) {
        return stream().noneMatch(predicate);
    }

    @Override
    public Optional<TValue> first() {
        for (TValue value : iterable) {
            return Optional.of(value);
        }
        return Optional.empty();
    }

    @Override
    public Optional<TValue> last() {
        Optional<TValue> result = Optional.empty();
        for(TValue value : iterable) {
            result = Optional.of(value);
        }
        return result;
    }

    @Override
    public IView<TValue> filter(Predicate<TValue> predicate) {
        return new View<>(stream().filter(predicate));
    }

    @Override
    public <TResult> IView<TResult> map(Function<TValue, TResult> function) {
        return new View<>(stream().map(function));
    }

    @Override
    public int count() {
        return Iterables.size(iterable);
    }

    @Override
    public Stream<TValue> stream() {
        return Streams.stream(this);
    }

    @Override
    public Iterator<TValue> iterator() {
        return iterable.iterator();
    }

    @Override
    public String toString() {
        return Iterables.toString(iterable);
    }
}
