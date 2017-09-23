package org.softlang.maxmeffert.bscthesis.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.graphs.old.Graph;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GraphVertexTest {

    private Comparable valueMock;
    private Graph.Vertex cut;

    @BeforeEach
    void setup() {
        valueMock = mock(Comparable.class);

        cut = new Graph.Vertex(valueMock);
    }

    @Test
    void getValueReturnsExpectedInstance() {
        assertSame(valueMock, cut.getValue());
    }

}