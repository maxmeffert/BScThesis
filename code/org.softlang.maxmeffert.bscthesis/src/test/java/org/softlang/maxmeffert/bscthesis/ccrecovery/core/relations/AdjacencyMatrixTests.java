package org.softlang.maxmeffert.bscthesis.ccrecovery.core.relations;

import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.AdjacencyMatrix;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.IAdjacencyMatrix;

class AdjacencyMatrixTests {

    @Test
    void test() {

        IAdjacencyMatrix a = new AdjacencyMatrix(5);
        IAdjacencyMatrix b = a.set(0,0, true);

        System.out.println(a);
        System.out.println(b);


    }

}