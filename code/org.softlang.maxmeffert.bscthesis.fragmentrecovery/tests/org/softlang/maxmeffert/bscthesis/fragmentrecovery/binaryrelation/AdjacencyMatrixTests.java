package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMatrixTests {

    @Test
    void test() {

        IAdjacencyMatrix a = new AdjacencyMatrix(5);
        IAdjacencyMatrix b = a.set(0,0, true);

        System.out.println(a);
        System.out.println(b);


    }

}