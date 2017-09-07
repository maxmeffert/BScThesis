package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereologies;

import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.relations.BinaryRelation;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.relations.FloydWarshall;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs.IPair;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs.Pair;

import java.util.HashSet;
import java.util.Set;

class BinaryRelationTests {

    @Test
    public void test() {
        Set<IPair<Integer, Integer>> pairs = new HashSet<>();
        pairs.add(new Pair<>(1, 2));
        pairs.add(new Pair<>(2, 3));

        BinaryRelation<Integer> relation = new BinaryRelation<>(pairs);

        System.out.println(relation);
        System.out.println(relation.map(new FloydWarshall()::map));
    }

}