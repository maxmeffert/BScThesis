package org.softlang.maxmeffert.bscthesis.fragments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FragmentBuilderFactoryTest {

    private FragmentBuilderFactory cut;

    @BeforeEach
    void setup() {
        cut = new FragmentBuilderFactory();
    }

    @Test
    void newFragmentBuilderDoesNotReturnNull() {
        assertNotNull(cut.newFragmentBuilder());
    }

    @Test
    void newFragmentBuilderReturnsExpectedType() {
        assertThat(cut.newFragmentBuilder(), instanceOf(FragmentBuilder.class));
    }

}