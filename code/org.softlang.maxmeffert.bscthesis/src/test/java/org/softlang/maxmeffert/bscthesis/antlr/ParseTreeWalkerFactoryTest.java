package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.antlr.ParseTreeWalkerFactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParseTreeWalkerFactoryTest {

    private ParseTreeWalkerFactory cut;

    @BeforeEach
    void setup() {
        cut = new ParseTreeWalkerFactory();
    }

    @Test
    void newParseTreeWalkerDoesNotReturnNull() {
        assertNotNull(cut.newParseTreeWalker());
    }

    @Test
    void newParseTreeWalkerReturnsExpectedType() {
        assertThat(cut.newParseTreeWalker(), instanceOf(ParseTreeWalker.class));
    }

}