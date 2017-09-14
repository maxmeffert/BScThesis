package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CommonTokenStreamFactoryTest {

    private static final Lexer lexer = mock(Lexer.class);

    private AntlrCommonTokenStreamFactory cut;

    @BeforeEach
    void setup() {
        cut = new AntlrCommonTokenStreamFactory();
    }

    @Test
    void newTokenStreamDoesNotReturnNull() {
        assertNotNull(cut.newTokenStream(lexer));
    }

    @Test
    void newTokenStreamReturnsExpectedType() {
        assertThat(cut.newTokenStream(lexer), instanceOf(CommonTokenStream.class));
    }

}