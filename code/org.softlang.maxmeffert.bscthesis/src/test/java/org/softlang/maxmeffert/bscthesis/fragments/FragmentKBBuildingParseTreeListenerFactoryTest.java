package org.softlang.maxmeffert.bscthesis.fragments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FragmentKBBuildingParseTreeListenerFactoryTest {

    private IFragmentFactory fragmentFactory;
    private FragmentKBBuildingParseTreeListenerFactory cut;

    @BeforeEach
    void setup() {
        fragmentFactory = mock(IFragmentFactory.class);
        cut = new FragmentKBBuildingParseTreeListenerFactory(fragmentFactory);
    }

    @Test
    void newFragmentKBBuildingParseTreeListenerDoesNotReturnNull() {
        assertNotNull(cut.newFragmentKBBuildingParseTreeListener());
    }

    @Test
    void newFragmentKBBuildingParseTreeListenerReturnsExpectedResult() {
        assertThat(cut.newFragmentKBBuildingParseTreeListener(), instanceOf(FragmentKBBuildingParseTreeListener.class));
    }

}