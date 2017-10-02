package org.softlang.maxmeffert.bscthesis.core.utils;

public interface IStack<T> {
    boolean isEmpty();
    IStack<T> push(T value);
    IStack<T> pop();
    T top();
}
