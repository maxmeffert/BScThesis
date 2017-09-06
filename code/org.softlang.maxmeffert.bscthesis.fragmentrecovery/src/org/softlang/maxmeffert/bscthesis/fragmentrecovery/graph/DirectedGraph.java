package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Maps;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.AdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.IAdjacencyMatrix;

import java.util.Map;

public class DirectedGraph<T extends Comparable<T>> implements IGraph<T> {

    private final Map<T, ITree<T>> nodes = Maps.newTreeMap();

    public ITree<T> getNode(T value) {
        if (!nodes.containsKey(value)) {
            ITree<T> node = new Tree<>();
            node.setData(value);
            nodes.put(value, node);
        }
        return nodes.get(value);
    }

    public void add(T left, T right) {
        getNode(left).addChild(getNode(right));
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    private void transitiveClosure(T left, T right) {
        add(left, right);
        for (ITree<T> rightChild : nodes.get(right).getChildren()) {
            if (!rightChild.hasChild(left)) {
                transitiveClosure(left, rightChild.getData());
            }
        }
    }

    public void transitiveClosure() {
        nodes.keySet().forEach(key -> transitiveClosure(key, key));
    }

    @Override
    public IAdjacencyMatrix getMatrix() {
        IAdjacencyMatrix matrix = new AdjacencyMatrix(nodes.size());
        int i = 0;
        for (T left: nodes.keySet()) {
            int j = 0;
            for (T right: nodes.keySet()) {
                if (nodes.get(left).hasChild(right)) {
                    matrix = matrix.set(i, j, true);
                }
                j++;
            }
            i++;
        }
        return matrix;
    }

}
