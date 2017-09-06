package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

public class DiGraph<T extends Comparable<T>> implements IDiGraph<T> {

    public static class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

        private final T value;
        private final Map<T, Vertex<T>> sources = Maps.newTreeMap();
        private final Map<T, Vertex<T>> targets = Maps.newTreeMap();

        public Vertex(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Set<T> getSources() {
            return sources.keySet();
        }

        public boolean hasSource(T source) {
            return sources.containsKey(source);
        }

        public boolean hasSource(Vertex<T> source) {
            return hasSource(source.getValue());
        }

        public void addSource(Vertex<T> source) {
            if (hasSource(source)) {
                return;
            }
            sources.put(source.getValue(), source);
//            source.addTarget(this);
        }

        public Set<T> getTargets() {
            return targets.keySet();
        }

        public boolean hasTarget(T target) {
            return targets.containsKey(target);
        }

        public boolean hasTarget(Vertex<T> target) {
            return hasTarget(target.getValue());
        }

        public void addTarget(Vertex<T> target) {
            if (hasTarget(target)) {
                return;
            }
            targets.put(target.getValue(), target);
//            target.addSource(this);
        }

        @Override
        public int compareTo(Vertex<T> tVertex) {
            return value.compareTo(tVertex.value);
        }
    }

    private final Map<T, Vertex<T>> vertices = Maps.newTreeMap();

    public Set<T> getVertices() {
        return vertices.keySet();
    }

    @Override
    public Set<T> getSourcesOf(T target) {
        return vertices.get(target).getSources();
    }

    @Override
    public Set<T> getTargetsOf(T source) {
        return vertices.get(source).getTargets();
    }

    private Vertex<T> getVertex(T value) {
        if (!vertices.containsKey(value)) {
            vertices.put(value, new Vertex<>(value));
        }
        return vertices.get(value);
    }

    @Override
    public void add(T source, T target) {
        getVertex(source).addTarget(getVertex(target));
    }

    @Override
    public boolean contains(T source, T target) {
        return vertices.containsKey(source) && vertices.get(source).hasTarget(target);
    }

    private void closure(T source, T target, Set<T> visited) {
        visited.add(source);
        add(source, target);
        for (T targetOfTarget : getTargetsOf(target)) {
            if (!visited.contains(targetOfTarget)
                    && !contains(targetOfTarget, source)) {
                closure(source, targetOfTarget, visited);
            }
        }
    }

    private void closure(T source, T target) {
        closure(source, target, Sets.newTreeSet());
//        System.out.println("closure("+ source+","+target+")");
//        System.out.println(vertices.size());
//        add(source, target);
//        T[] targetofTargets = null;
//        targetofTargets = getTargetsOf(target).toArray((T[]) new Integer[0]);
//        for (T targetOfTarget : targetofTargets) {
//            if (!contains(targetOfTarget, source)) {
//                closure(targetOfTarget, source);
//            }
//        }
    }

    public void closure() {
        getVertices().forEach(vertex -> closure(vertex, vertex));
    }

}
