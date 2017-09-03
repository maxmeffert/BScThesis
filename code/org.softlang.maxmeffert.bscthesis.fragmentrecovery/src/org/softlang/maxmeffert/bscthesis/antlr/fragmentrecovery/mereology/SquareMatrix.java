package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

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
        this(size, newSquareArray(size));
        setAll(initialValue);
    }

    protected SquareMatrix(int size, T[][] values) {
        this.size = size;
        this.values = values;
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

    public void setAll(T value) {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                set(i, j, value);
            }
        }
    }

    @Override
    public SquareMatrix<T> copy() {
        T[][] newMatrix = (T[][]) new Object[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                newMatrix[i][j] = values[i][j];
            }
        }
        return new SquareMatrix<>(size, newMatrix);
    }


}
