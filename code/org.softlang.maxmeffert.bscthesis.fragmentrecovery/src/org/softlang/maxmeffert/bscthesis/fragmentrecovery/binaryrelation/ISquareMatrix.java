package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

import java.util.function.Function;

public interface ISquareMatrix<T> {
    int size();

    T get(int i, int j);

    void set(int i, int j, T value);



    <R> ISquareMatrix<R> map(Function<ISquareMatrix<T>, ISquareMatrix<R>> function);

    ISquareMatrix<T> copy();
}
