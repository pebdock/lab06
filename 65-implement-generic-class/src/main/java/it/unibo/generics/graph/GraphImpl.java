package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<T> implements Graph<T>{

    private final Map<T,Set<T>> graphScheme = new HashMap<>();

    @Override
    public void addNode(final T node) {
        graphScheme.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(final T source, final T target) {
        graphScheme.putIfAbsent(source, new HashSet<>());
        graphScheme.putIfAbsent(target,new HashSet<>());
        graphScheme.get(source).add(target);
    }

    @Override
    public Set<T> nodeSet() {
        return Set.copyOf(graphScheme.keySet());
    }

    @Override
    public Set<T> linkedNodes(final T node) {
         if (!graphScheme.containsKey(node)) {
            throw new IllegalArgumentException("Node not included in the graph " + node);
        } else {
            return Set.copyOf(graphScheme.get(node));
        }
    }

    private boolean dfs(final T current, final T target, Set<T> visited, List<T> path) {
        visited.add(current);
        path.add(current);

        if (current.equals(target)) {
            return true;
        } else {
            for (final T neighbor : graphScheme.getOrDefault(current, Set.of())) {
                if (!visited.contains(neighbor) && dfs(neighbor, target, visited, path)) {
                return true;
                }
            }
            path.remove(path.size() - 1);
            return false;
        }
    }

    @Override
    public List<T> getPath(final T source, final T target) {
        if (!graphScheme.containsKey(source) || !graphScheme.containsKey(target)) {
            return null;
        }
        final List<T> path = new ArrayList<>();
        final Set<T> visited = new HashSet<>();
        return dfs(source, target, visited, path) ? path : null;
    }
}
