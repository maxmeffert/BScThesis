package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.views.IView;

import java.util.function.Predicate;

public abstract class AbstractGraph<TValue extends Comparable<TValue>> implements IGraph<TValue> {

    @Override
    public boolean all(Predicate<TValue> predicate) {
        return getNodes().all(predicate);
    }

    @Override
    public boolean any(Predicate<TValue> predicate) {
        return getNodes().any(predicate);
    }

    @Override
    public boolean none(Predicate<TValue> predicate) {
        return getNodes().none(predicate);
    }

    @Override
    public IView<TValue> filterNodes(Predicate<TValue> predicate) {
        return getNodes().filter(predicate);
    }
}
