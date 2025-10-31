package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph{

    private HashMap<Object,List> graphScheme = new HashMap<>();

    @Override
    public void addNode(Object node) {
        ArrayList<Object> connectedNodes = new ArrayList<>();
        graphScheme.put(node, connectedNodes);
    }

    @Override
    public void addEdge(Object source, Object target) {
        graphScheme.get(source).add(target);
        graphScheme.get(target).add(source);
    }

    @Override
    public Set nodeSet() {
        return new HashSet<>(graphScheme.keySet());
    }

    @Override
    public Set linkedNodes(Object node) {
        return new HashSet<>(graphScheme.get(node));
    }

    private boolean dfs(Object current, Object target, Set<Object> visited, List<Object> path) {
        visited.add(current);
        path.add(current);
        
        if(current.equals(target)) {
            return true;
        } else {
            for(Object objectIndex : graphScheme.get(current)) {
                if(!visited.contains(objectIndex)) {
                    if(dfs(objectIndex, target, visited, path)) return true;
                }
            }
        }
        path.remove(path.size()-1);
        return false;
    }

    @Override
    public List getPath(Object source, Object target) {
        List<Object> path = new ArrayList<>();
        Set<Object> visited = new HashSet<>();
        if(dfs(source,target,visited,path)) {
            return path;
        } else {
            return null;
        }
    }
    
}
