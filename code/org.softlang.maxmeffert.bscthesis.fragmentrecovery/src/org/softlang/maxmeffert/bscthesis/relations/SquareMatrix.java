package org.softlang.maxmeffert.bscthesis.relations;

import java.util.function.Function;

public class SquareMatrix<T> implements ISquareMatrix<T> {

    private static <T> T[][] newSquareArray(int size) {
        return (T[][]) new Object[size][size];
    }

    private final int size;
    private final T[][] values;

    public SquareMatrix(int size) {
        this(size, newSquareArray(size));
    }

    public SquareMatrix(int size, T initialValue) {
        this(size, newSquareArray(size), initialValue);
    }

    protected SquareMatrix(int size, T[][] values) {
        this.size = size;
        this.values = values;
    }

    protected SquareMatrix(int size, T[][] values, T initialValue) {
        this(size, values);
        setAll(initialValue);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int i, int j) {
        return values[i][j];
    }

    @Override
    public void set(int i, int j, T value) {
        values[i][j] = value;
    }

    @Override
    public <R> ISquareMatrix<R> map(Function<ISquareMatrix<T>, ISquareMatrix<R>> function) {
        return function.apply(copy());
    }


    public void setAll(T value) {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                set(i, j, value);
            }
        }
    }

    @Override
    public ISquareMatrix<T> copy() {
        ISquareMatrix<T> result = new SquareMatrix<>(size());
        for (int i=0; i < size(); i++) {
            for (int j=0; j < size(); j++) {
                result.set(i, j, get(i, j));
            }
        }
        return result;
    }


}
