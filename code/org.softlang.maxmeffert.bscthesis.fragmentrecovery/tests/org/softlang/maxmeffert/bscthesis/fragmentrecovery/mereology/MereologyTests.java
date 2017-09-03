package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class MereologyTests {

//    private static Mereology.Builder<Integer> mereologyBuilder;

    @BeforeEach
    void SetUp() {
//        mereologyBuilder = Mereology.builder();
//        mereologyBuilder
//                .partOf(1,2)
//                .partOf(2,3)
//                .partOf(3,4)
//                .partOf(4,5)
//                .partOf(4,6);
    }

    @Test
    void builder() {
//        IMereology mereology = mereologyBuilder.build();
//        assertTrue(mereology instanceof Mereology);
    }

    @Test
    void contains() {
        fail("Not Implemented");
    }

    @Test
    void isPartOf() {
//        Mereology<Integer> mereology = mereologyBuilder.build();
//        assertTrue(mereology.isPartOf(1,6));
    }

    @Test
    void isProperPartOf() {

//        Mereology<Integer> mereology = mereologyBuilder.build();
//        assertTrue(mereology.isProperPartOf(1,6));
//        assertFalse(mereology.isProperPartOf(6,6));
    }

    @Test
    void isAtomOf() {
//        Mereology<Integer> mereology = mereologyBuilder.build();
//        assertTrue(mereology.isAtomOf(1,6));
//        assertFalse(mereology.isAtomOf(2,6));
//        assertFalse(mereology.isAtomOf(6,6));
    }

    @Test
    void getProperPartsOf() {
        fail("Not Implemented");
    }

    @Test
    void getPartsOf() {
        fail("Not Implemented");
    }

    @Test
    void getAtomsOf() {
        fail("Not Implemented");
    }

}