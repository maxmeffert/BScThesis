package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

public interface IMereologyBuilderFactory {
    <TValue extends Comparable<TValue>> IMereologyBuilder<TValue> newMereologyBuilder();
}
