package org.softlang.maxmeffert.bscthesis.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.graphs.old.Graph;

import java.util.Set;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class GraphTest {

    private SortedMap verticesMock;
    private Graph graph;

    @BeforeEach
    void setup() {
        verticesMock = mock(SortedMap.class);
        graph = new Graph<>(verticesMock);
    }

    @Test
    void isEmptyCallsVerticesIsEmpty() {
        graph.isEmpty();

        verify(verticesMock).isEmpty();
    }

    @Test
    void isEmptyReturnsResultOfVerticesIsEmpty() {
        boolean expectedResult = true;

        when(verticesMock.isEmpty()).thenReturn(expectedResult);

        assertEquals(expectedResult, graph.isEmpty());
    }

    @Test
    void getVerticesCallsVerticesKeySet() {
        graph.getVertices();

        verify(verticesMock).keySet();
    }

    @Test
    void getVerticesReturnsResultOfVerticesKeySet() {
        Set expectedKeySet = mock(Set.class);

        when(verticesMock.keySet()).thenReturn(expectedKeySet);

        assertSame(expectedKeySet, graph.getVertices());
    }

    @Test
    void getVerticesCountCallsVerticesSize() {
        graph.getVertexCount();

        verify(verticesMock).size();
    }



}