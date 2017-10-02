package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils;

import com.google.common.collect.Streams;

import java.util.stream.Stream;

public class StreamFactory implements IStreamFactory {
    @Override
    public <TValue> Stream<TValue> newStream(Iterable<TValue> iterable) {
        return Streams.stream(iterable);
    }
}
