package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils;

import java.util.stream.Stream;

public interface IStreamFactory {
    <TValue> Stream<TValue> newStream(Iterable<TValue> iterable);
}
