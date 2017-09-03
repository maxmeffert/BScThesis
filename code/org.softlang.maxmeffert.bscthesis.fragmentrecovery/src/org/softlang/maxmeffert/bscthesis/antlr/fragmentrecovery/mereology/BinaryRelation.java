package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import com.google.common.collect.Sets;

import java.util.Set;

public class BinaryRelation<T extends Comparable<T>> implements IBinaryRelation<T> {

    public static class Builder<T extends Comparable<T>>  {

        private Set<IPair<T,T>> pairs = Sets.newHashSet();

        public Builder<T> add(T left, T right) {
            pairs.add(new Pair<>(left, right));
            return this;
        }

        private IBinaryRelationNodes<T> buildNodeIndex() {
            BinaryRelationNodes.Builder<T> builder = BinaryRelationNodes.builder();
            for (IPair<T,T> pair : pairs) {
                builder.add(pair.getLeft());
                builder.add(pair.getRight());
            }
            return builder.build();
        }

        private SquareMatrix<Boolean> buildAdjacencyMatrix(IBinaryRelationNodes<T> nodeIndex) {
            SquareMatrix<Boolean> adMatrix = new SquareMatrix<>(nodeIndex.size(), false);

            for (IPair<T,T> pair : pairs) {
                adMatrix.set(nodeIndex.indexOf(pair.getLeft()), nodeIndex.indexOf(pair.getRight()), true);
            }

            return adMatrix;
        }

        public IBinaryRelation<T> build()
        {
            IBinaryRelationNodes<T> nodeIndex = buildNodeIndex();
            return new BinaryRelation<>(nodeIndex, buildAdjacencyMatrix(nodeIndex));
        }

        public IBinaryRelation<T> buildReflexiveTransitiveClosure()
        {
            return build().reflexiveTransitiveClosure();
        }

    }

    public static <T extends Comparable<T>> Builder<T> builder() {
        return new Builder<>();
    }

    private final IBinaryRelationNodes<T> nodes;
    private final SquareMatrix<Boolean> adjacencyMatrix;

    protected BinaryRelation(IBinaryRelationNodes<T> nodes, SquareMatrix<Boolean> adjacencyMatrix) {
        this.nodes = nodes;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    @Override
    public IBinaryRelationNodes<T> getNodes() {
        return nodes;
    }

    @Override
    public boolean contains(T value) {
        return nodes.contains(value);
    }

    @Override
    public boolean contains(T left, T right) {
        if (contains(left) && contains(right)) {
            return adjacencyMatrix.get(nodes.indexOf(left), nodes.indexOf(right));
        }
        return false;
    }

    private SquareMatrix<Boolean> reflexiveClosureMatrix() {
        SquareMatrix<Boolean> result = adjacencyMatrix.copy();
        for (int i=0; i<result.size(); i++) {
            result.set(i,i, true);
        }
        return result;
    }

    // implements Floyd-Warshall http://www-i2.informatik.rwth-aachen.de/i2/fileadmin/user_upload/documents/DASAL10/lec18_handout.pdf
    private SquareMatrix<Boolean> reflexiveTransitiveClosureMatrix() {
        SquareMatrix<Boolean> result = reflexiveClosureMatrix();
        for (int k=0; k<result.size(); k++) {
            for (int i=0; i<result.size(); i++) {
                for (int j=0; j<result.size(); j++) {
                    result.set(i,j, result.get(i,j) || (result.get(i,k) && result.get(k,j)));
                }
            }
        }
        return result;
    }

    @Override
    public BinaryRelation<T> reflexiveClosure() {
        return new BinaryRelation<>(nodes, reflexiveClosureMatrix());
    }

    @Override
    public BinaryRelation<T> reflexiveTransitiveClosure() {
        return new BinaryRelation<>(nodes, reflexiveTransitiveClosureMatrix());
    }

    @Override
    public String toString() {
        String result = "    ";

        for (int j = 0; j< nodes.size(); j++) {
            result += nodes.nodeOf(j);
        }
        result += "\n";
        for (int i = 0; i< nodes.size(); i++) {
            result += nodes.nodeOf(i) + " : ";
            for (int j = 0; j< nodes.size(); j++) {
                result += (adjacencyMatrix.get(i,j)  ? 1 : 0 );
            }
            result += "\n";
        }

        return result;
    }
}
