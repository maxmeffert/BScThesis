package org.softlang.maxmeffert.bscthesis.core.graphs.closures;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.core.graphs.IGraph;

public class GraphClosures implements IGraphClosures {

    private final IGraphClosureFactory graphClosureFactory;
    private final IDiGraphClosureFactory diGraphClosureFactory;

    @Inject
    public GraphClosures(IGraphClosureFactory graphClosureFactory, IDiGraphClosureFactory diGraphClosureFactory) {
        this.graphClosureFactory = graphClosureFactory;
        this.diGraphClosureFactory = diGraphClosureFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> reflexiveDiGraphClosureOf(IDiGraph<TValue> diGraph) {
        return diGraphClosureFactory.reflexiveDiGraphClosureOf(diGraph);
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> transitiveDiGraphClosureOf(IDiGraph<TValue> diGraph) {
        return diGraphClosureFactory.transitiveDiGraphClosureOf(diGraph);
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraph<TValue> reflexiveTransitiveDiGraphClosureOf(IDiGraph<TValue> diGraph) {
        return diGraphClosureFactory.reflexiveTransitiveDiGraphClosureOf(diGraph);
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveGraphClosureOf(IGraph<TValue> graph) {
        return graphClosureFactory.reflexiveGraphClosureOf(graph);
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> transitiveGraphClosureOf(IGraph<TValue> graph) {
        return graphClosureFactory.transitiveGraphClosureOf(graph);
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraph<TValue> reflexiveTransitiveGraphClosureOf(IGraph<TValue> graph) {
        return graphClosureFactory.reflexiveTransitiveGraphClosureOf(graph);
    }
}
