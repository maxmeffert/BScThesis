package org.softlang.maxmeffert.bscthesis.utils;

import java.util.stream.Stream;

public interface IStreamFactory {
    <TValue> Stream<TValue> newStream(Iterable<TValue> iterable);
}
