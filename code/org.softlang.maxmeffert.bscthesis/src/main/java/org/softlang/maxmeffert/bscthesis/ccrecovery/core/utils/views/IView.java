package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface IView<TValue> extends Iterable<TValue> {
    boolean isEmpty();
    boolean contains(TValue value);
    boolean containsAll(Iterable<TValue> values);
    boolean containsAny(Iterable<TValue> values);
    boolean containsNone(Iterable<TValue> values);
    boolean all(Predicate<TValue> predicate);
    boolean any(Predicate<TValue> predicate);
    boolean none(Predicate<TValue> predicate);
    Optional<TValue> first();
    Optional<TValue> last();
    IView<TValue>  filter(Predicate<TValue> predicate);
    <TResult> IView<TResult> map(Function<TValue,TResult> function);
    int count();
    Stream<TValue> stream();
}
