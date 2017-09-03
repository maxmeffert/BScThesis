package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

public interface ISquareMatrix<T> {
    int size();

    T get(int i, int j);

    void set(int i, int j, T value);

    SquareMatrix<T> copy();
}
