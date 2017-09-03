package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

public class Pair<A,B> implements IPair {
    private final A left;
    private final B right;

    public Pair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public A getLeft() {
        return left;
    }

    @Override
    public B getRight() {
        return right;
    }
}
