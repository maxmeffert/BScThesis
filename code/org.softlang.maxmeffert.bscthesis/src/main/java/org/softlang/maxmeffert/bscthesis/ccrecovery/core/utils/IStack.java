package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils;

public interface IStack<T> {
    boolean isEmpty();
    IStack<T> push(T value);
    IStack<T> pop();
    T top();
}
