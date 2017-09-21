package org.softlang.maxmeffert.bscthesis.fragments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class FragmentKBFactoryTest {


    private ISimpleParseTree simpleParseTree;
    private ISimpleParseTreeWalker simpleParseTreeWalker;
    private ISimpleParseTreeWalkerFactory simpleParseTreeWalkerFactory;
    private IFragmentKB fragmentKB;
    private IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListener;
    private IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactory;
    private FragmentKBFactory cut;

    @BeforeEach
    void setup() {
        simpleParseTree = mock(ISimpleParseTree.class);
        simpleParseTreeWalker = mock(ISimpleParseTreeWalker.class);
        simpleParseTreeWalkerFactory = mock(ISimpleParseTreeWalkerFactory.class);
        fragmentKB = mock(IFragmentKB.class);
        fragmentKBBuildingParseTreeListener = mock(IFragmentKBBuildingParseTreeListener.class);
        fragmentKBBuildingParseTreeListenerFactory = mock(IFragmentKBBuildingParseTreeListenerFactory.class);

        cut = new FragmentKBFactory(simpleParseTreeWalkerFactory, fragmentKBBuildingParseTreeListenerFactory);

        when(simpleParseTreeWalkerFactory.newParseTreeWalker())
                .thenReturn(simpleParseTreeWalker);

        when(fragmentKBBuildingParseTreeListener.getFragmentKB())
                .thenReturn(fragmentKB);

        when(fragmentKBBuildingParseTreeListenerFactory.newFragmentKBBuildingParseTreeListener())
                .thenReturn(fragmentKBBuildingParseTreeListener);
    }

    @Test
    void newFragmentKBDoesNotReturnNull() {
        assertNotNull(cut.newFragmentKB(simpleParseTree));
    }

    @Test
    void newFragmentKBReturnsExpectedResult() {
        assertSame(fragmentKB, cut.newFragmentKB(simpleParseTree));
    }

    @Test
    void newFragmentKBCreatesNewParseTreeWalker() {
        cut.newFragmentKB(simpleParseTree);

        verify(simpleParseTreeWalkerFactory).newParseTreeWalker();
    }

    @Test
    void newFragmentKBCreatesNewFragmentKBBuildingParseTreeListener() {
        cut.newFragmentKB(simpleParseTree);

        verify(fragmentKBBuildingParseTreeListenerFactory).newFragmentKBBuildingParseTreeListener();
    }

    @Test
    void newFragmentKBWalksOnParseTreeWithExpectedParameters() {
        cut.newFragmentKB(simpleParseTree);

        verify(simpleParseTreeWalker)
                .walk(eq(simpleParseTree), eq(fragmentKBBuildingParseTreeListener));
    }
}