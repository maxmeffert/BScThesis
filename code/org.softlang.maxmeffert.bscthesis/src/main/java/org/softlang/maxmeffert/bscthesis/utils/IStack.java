package org.softlang.maxmeffert.bscthesis.utils;

public interface IStack<T> {
    boolean isEmpty();
    IStack<T> push(T value);
    IStack<T> pop();
    T top();
}
