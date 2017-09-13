package org.softlang.maxmeffert.bscthesis.fragments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FragmentKBBuildingParseTreeListenerTest {

    private IFragmentFactory fragmentFactory;
    private FragmentKBBuildingParseTreeListener cut;

    @BeforeEach
    void setUp() {
        fragmentFactory = mock(IFragmentFactory.class);
        cut = new FragmentKBBuildingParseTreeListener(fragmentFactory);
    }

    @Test
    void getFragmentKBDoesNotReturnNull() {
        assertNotNull(cut.getFragmentKB());
    }

    @Test
    void visitTerminal() {
    }

    @Test
    void visitErrorNode() {
    }

    @Test
    void enterEveryRule() {
    }

    @Test
    void exitEveryRule() {
    }

}