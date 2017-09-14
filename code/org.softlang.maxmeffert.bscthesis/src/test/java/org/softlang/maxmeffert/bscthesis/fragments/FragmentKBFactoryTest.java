package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeWalkerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class FragmentKBFactoryTest {


    private ParseTree parseTreeMock;
    private ParseTreeWalker parseTreeWalkerMock;
    private ISimpleParseTreeWalkerFactory parseTreeWalkerFactoryMock;
    private IFragmentKB fragmentKBMock;
    private IFragmentKBBuildingParseTreeListener fragmentKBBuildingParseTreeListenerMock;
    private IFragmentKBBuildingParseTreeListenerFactory fragmentKBBuildingParseTreeListenerFactoryMock;
    private FragmentKBFactory cut;

    @BeforeEach
    void setup() {
        parseTreeMock = mock(ParseTree.class);
        parseTreeWalkerMock = mock(ParseTreeWalker.class);
        parseTreeWalkerFactoryMock = mock(ISimpleParseTreeWalkerFactory.class);
        fragmentKBMock = mock(IFragmentKB.class);
        fragmentKBBuildingParseTreeListenerMock = mock(IFragmentKBBuildingParseTreeListener.class);
        fragmentKBBuildingParseTreeListenerFactoryMock = mock(IFragmentKBBuildingParseTreeListenerFactory.class);

        cut = new FragmentKBFactory(parseTreeWalkerFactoryMock, fragmentKBBuildingParseTreeListenerFactoryMock);

        when(parseTreeWalkerFactoryMock.newParseTreeWalker())
                .thenReturn(parseTreeWalkerMock);

        when(fragmentKBBuildingParseTreeListenerMock.getFragmentKB())
                .thenReturn(fragmentKBMock);

        when(fragmentKBBuildingParseTreeListenerFactoryMock.newFragmentKBBuildingParseTreeListener())
                .thenReturn(fragmentKBBuildingParseTreeListenerMock);
    }

    @Test
    void newFragmentKBDoesNotReturnNull() {
        assertNotNull(cut.newFragmentKB(parseTreeMock));
    }

    @Test
    void newFragmentKBReturnsExpectedResult() {
        assertSame(fragmentKBMock, cut.newFragmentKB(parseTreeMock));
    }

    @Test
    void newFragmentKBCreatesNewParseTreeWalker() {
        cut.newFragmentKB(parseTreeMock);

        verify(parseTreeWalkerFactoryMock).newParseTreeWalker();
    }

    @Test
    void newFragmentKBCreatesNewFragmentKBBuildingParseTreeListener() {
        cut.newFragmentKB(parseTreeMock);

        verify(fragmentKBBuildingParseTreeListenerFactoryMock).newFragmentKBBuildingParseTreeListener();
    }

    @Test
    void newFragmentKBWalksOnParseTreeWithExpectedParameters() {
        cut.newFragmentKB(parseTreeMock);

        verify(parseTreeWalkerMock)
                .walk(eq(fragmentKBBuildingParseTreeListenerMock), eq(parseTreeMock));
    }
}