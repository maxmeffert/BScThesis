package org.softlang.maxmeffert.bscthesis.relations;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.softlang.maxmeffert.bscthesis.utils.AdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.utils.IAdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.utils.IPair;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryRelation<T extends Comparable<T>> implements IBinaryRelation<T> {

    public static <T extends Comparable<T>> Map<T, Integer> toIndexMap(Set<IPair<T,T>> pairs) {
        return pairs.stream()
            .flatMap(pair -> Stream.of(pair.getFirst(), pair.getSecond()))
            .distinct()
            .sorted()
            .collect(Collectors.toMap(Functions.identity(), new Function<T, Integer>() {
                private int i = 0;
                @Override
                public Integer apply(T t) {
                    return i++;
                }
            }));
    }

    public static <T extends Comparable<T>> BiMap<T, Integer> toIndexBiMap(Set<IPair<T,T>> pairs) {
        return HashBiMap.create(toIndexMap(pairs));
    }

    public static <T extends Comparable<T>> IAdjacencyMatrix toAdjacencyMatrix(Set<IPair<T,T>> pairs, BiMap<T, Integer> index) {
        IAdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(index.size());
        for (IPair<T,T> pair : pairs) {
            adjacencyMatrix = adjacencyMatrix.set(index.get(pair.getFirst()), index.get(pair.getSecond()), true);
        }
        return adjacencyMatrix;
    }

    private final IAdjacencyMatrix adjacencyMatrix;
    private final BiMap<T,Integer> index;
    private final Set<IPair<T,T>> elements;

    public BinaryRelation(Set<IPair<T,T>> elements) {
        this.elements = elements;
        index = toIndexBiMap(elements);
        adjacencyMatrix = toAdjacencyMatrix(elements, index);
        System.out.println(index);

    }

    protected BinaryRelation(Set<IPair<T,T>> elements, BiMap<T, Integer> index, IAdjacencyMatrix adjacencyMatrix) {
        this.elements = elements;
        this.index = index;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    @Override
    public Iterable<T> getValues() {
        return index.keySet();
    }

    @Override
    public Iterable<IPair<T, T>> getPairs() {
        return elements;
    }

    @Override
    public IAdjacencyMatrix getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    @Override
    public boolean contains(T value) {
        return index.containsKey(value);
    }

    @Override
    public boolean contains(T left, T right) {
        return contains(left)
                && contains(right)
                && adjacencyMatrix.get(index.get(left), index.get(right));
    }

    @Override
    public boolean contains(IPair<T, T> pair) {
        return contains(pair.getFirst(), pair.getSecond());
    }

    @Override
    public IBinaryRelation<T> map(java.util.function.Function<IAdjacencyMatrix, IAdjacencyMatrix> function) {
        return new BinaryRelation<>(elements, index, adjacencyMatrix.map(function));
    }

    public IBinaryRelation<T> reflexiveTransitiveClosure() {
        return new BinaryRelation<>(elements, index, adjacencyMatrix.map(new FloydWarshall()::map));
    }

    @Override
    public String toString() {
        String result = "    ";

        for (int j = 0; j< index.size(); j++) {
            result += index.inverse().get(j);
        }
        result += "\n";
        for (int i = 0; i< index.size(); i++) {
            result += index.inverse().get(i) + " : ";
            for (int j = 0; j< index.size(); j++) {
                result += (adjacencyMatrix.get(i,j)  ? 1 : 0 );
            }
            result += "\n";
        }

        return result;
    }
}