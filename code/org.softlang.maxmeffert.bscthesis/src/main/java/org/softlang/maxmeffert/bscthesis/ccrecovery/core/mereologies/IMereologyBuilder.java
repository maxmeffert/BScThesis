package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

public interface IMereologyBuilder<TValue extends Comparable<TValue>> {
    IMereologyBuilder<TValue> partOf(TValue part, TValue fusion);
    IMereology<TValue> build();
}
