package org.softlang.maxmeffert.bscthesis.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;

import java.util.SortedMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DiGraphNodeBuilderFactoryTest {

    private Comparable value;
    private SortedMap sourceEdges;
    private SortedMap targetEdges;
    private ICollectionFactory collectionFactory;

    private DiGraphNodeBuilderFactory cut;

    @BeforeEach
    void SetUp() {
        value = mock(Comparable.class);
        sourceEdges = mock(SortedMap.class);
        targetEdges = mock(SortedMap.class);
        collectionFactory = mock(ICollectionFactory.class);

        cut = new DiGraphNodeBuilderFactory(collectionFactory);

        when(collectionFactory.newSortedMap())
                .thenReturn(sourceEdges)
                .thenReturn(targetEdges);
    }

    @Test
    void newDiGraphNodeBuilderDoesNotReturnNull() {
        assertNotNull(cut.newDiGraphNodeBuilder());
    }

    @Test
    void newDiGraphNodeBuilderReturnsExpectedType() {
        assertThat(cut.newDiGraphNodeBuilder(), instanceOf(DiGraphNodeBuilder.class));
    }

    @Test
    void newDigraphNodeBuilderReturnsBuilderWithExpectedInitialization() {
        IDiGraphNodeBuilder instance = cut.newDiGraphNodeBuilder();

        verify(collectionFactory, times(2)).newSortedMap();

    }


}