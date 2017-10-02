package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FragmentBuilderTest {

    private FragmentBuilder cut;

    @BeforeEach
    void setup() {
        cut = new FragmentBuilder();
    }

    @Test
    void buildDoesNotReturnNull() {
        assertNotNull(cut.build());
    }

    @Test
    void buildReturnsExpectedType() {
        assertThat(cut.build(), instanceOf(Fragment.class));
    }

}