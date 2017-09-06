package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.Arrays;
import java.util.function.Function;

public class AdjacencyMatrix implements IAdjacencyMatrix {

    private static boolean[][] copy(boolean[][] array, int size) {
        boolean[][] result = Arrays.copyOf(array, size);
        for (int i=0; i<array.length; i++) {
            result[i] = Arrays.copyOf(array[i], size);
        }
        return result;
    }

    private final int size;
    private final boolean[][] values;

    public AdjacencyMatrix(int size) {
        this(size, new boolean[size][size]);
    }

    protected AdjacencyMatrix(int size, boolean[][] values) {
        this.size = size;
        this.values = values;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean get(int i, int j) {
        return values[i][j];
    }

    @Override
    public IAdjacencyMatrix set(int i, int j, boolean value) {
        boolean[][] copy = copy(values, size);
        copy[i][j] = value;
        return new AdjacencyMatrix(size, copy);
    }

    @Override
    public IAdjacencyMatrix map(Function<IAdjacencyMatrix, IAdjacencyMatrix> function) {
        return function.apply(new AdjacencyMatrix(size, copy(values, size)));
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i< size; i++) {
            for (int j = 0; j< size; j++) {
                result += values[i][j] ? 1 : 0 ;
            }
            result += "\n";
        }
        return result;
    }
}
