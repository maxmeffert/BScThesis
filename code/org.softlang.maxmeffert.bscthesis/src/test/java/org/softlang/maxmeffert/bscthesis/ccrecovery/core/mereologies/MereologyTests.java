package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
//        IMereology mereologies = mereologyBuilder.build();
//        assertTrue(mereologies instanceof Mereology);
    }

    @Test
    void contains() {
        fail("Not Implemented");
    }

    @Test
    void isPartOf() {
//        Mereology<Integer> mereologies = mereologyBuilder.build();
//        assertTrue(mereologies.isPartOf(1,6));
    }

    @Test
    void isProperPartOf() {

//        Mereology<Integer> mereologies = mereologyBuilder.build();
//        assertTrue(mereologies.isProperPartOf(1,6));
//        assertFalse(mereologies.isProperPartOf(6,6));
    }

    @Test
    void isAtomOf() {
//        Mereology<Integer> mereologies = mereologyBuilder.build();
//        assertTrue(mereologies.isAtomOf(1,6));
//        assertFalse(mereologies.isAtomOf(2,6));
//        assertFalse(mereologies.isAtomOf(6,6));
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