package org.softlang.maxmeffert.bscthesis.antlr.fragmentrecovery.mereology;

import org.junit.jupiter.api.Test;

class BinaryRelationTest {

    @Test
    public void test() {

        BinaryRelation.Builder<Integer> builder = BinaryRelation.builder();

        builder.add(3,1);
        builder.add(1,2);

        IBinaryRelation<Integer> relation = builder.build();

        System.out.println(relation);
        System.out.println(relation.reflexiveClosure());
        System.out.println(relation.reflexiveTransitiveClosure());
    }

}