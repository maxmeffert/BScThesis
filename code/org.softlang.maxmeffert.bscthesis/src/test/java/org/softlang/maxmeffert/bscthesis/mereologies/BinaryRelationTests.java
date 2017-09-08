package org.softlang.maxmeffert.bscthesis.mereologies;

import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.relations.BinaryRelation;
import org.softlang.maxmeffert.bscthesis.relations.FloydWarshall;
import org.softlang.maxmeffert.bscthesis.utils.IPair;
import org.softlang.maxmeffert.bscthesis.utils.Pair;

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