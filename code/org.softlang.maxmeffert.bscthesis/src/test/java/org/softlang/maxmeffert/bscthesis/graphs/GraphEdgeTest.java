package org.softlang.maxmeffert.bscthesis.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.graphs.old.Graph;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GraphEdgeTest {

    private Graph.Direction directionMock;
    private Comparable vertex1Mock;
    private Comparable vertex2Mock;
    private Graph.Edge cut;

    @BeforeEach
    void setup() {
        directionMock = Graph.Direction.INGOING;
        vertex1Mock = mock(Comparable.class);
        vertex2Mock = mock(Comparable.class);

        cut = new Graph.Edge(directionMock, vertex1Mock, vertex2Mock);
    }

    @Test
    void getDirectionReturnsExpectedInstance() {
        assertSame(directionMock, cut.getDirection());
    }

    @Test
    void getVertex1ReturnsExpectedInstance() {
        assertSame(vertex1Mock, cut.getVertex1());
    }

    @Test
    void getVertex2ReturnsExpectedInstance() {
        assertSame(vertex2Mock, cut.getVertex2());
    }
}