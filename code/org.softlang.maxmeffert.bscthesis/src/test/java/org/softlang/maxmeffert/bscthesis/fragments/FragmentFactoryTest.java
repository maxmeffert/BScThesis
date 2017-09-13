package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FragmentFactoryTest {

    private ParserRuleContext parserRuleContext;
    private IFragment fragment;
    private IFragmentBuilder fragmentBuilder;
    private IFragmentBuilderFactory fragmentBuilderFactory;
    private FragmentFactory cut;

    @BeforeEach
    void setup() {
        parserRuleContext = mock(ParserRuleContext.class);
        fragment = mock(IFragment.class);
        fragmentBuilder = mock(IFragmentBuilder.class);
        fragmentBuilderFactory = mock(IFragmentBuilderFactory.class);

        cut = new FragmentFactory(fragmentBuilderFactory);

        when(fragmentBuilderFactory.newFragmentBuilder())
                .thenReturn(fragmentBuilder);

        when(fragmentBuilder.build())
                .thenReturn(fragment);
    }

    @Test
    void newFragmentFromParserRuleContextDoesNotReturnNull() {
        assertNotNull(cut.newFragmentFromParserRuleContext(parserRuleContext));
    }

    @Test
    void newFragmentFromParserRuleContextReturnExpectedResult() {
        assertSame(fragment, cut.newFragmentFromParserRuleContext(parserRuleContext));
    }

    @Test
    void newFragmentFromParserRuleContextCreatesNewFragmentBuilder() {
        cut.newFragmentFromParserRuleContext(parserRuleContext);

        verify(fragmentBuilderFactory).newFragmentBuilder();
    }

    @Test
    void newFragmentFromParserRuleContextBuildsFragment() {
        cut.newFragmentFromParserRuleContext(parserRuleContext);

        verify(fragmentBuilder).build();
    }

    @Test
    void newFragmentFromParserRuleContextBuildsFragmentWithText() {
        cut.newFragmentFromParserRuleContext(parserRuleContext);

        verify(fragmentBuilder).withText(anyString());
    }

}