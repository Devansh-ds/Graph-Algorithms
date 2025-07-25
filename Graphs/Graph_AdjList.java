package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_AdjList<T> {

    private Map<T, List<T>> adjList;
    private int vertices;
    private boolean isDirected;

    public Graph_AdjList(int vertices, boolean isDirected) {
        this.isDirected = isDirected;
        adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put((T) (Integer) i, new ArrayList<>());
        }
    }

    public Graph_AdjList(List<T> nodes, boolean isDirected) {
        this.isDirected = isDirected;
        adjList = new HashMap<>();
        for (T node : nodes ) {
            adjList.put(node, new ArrayList<>());
        }
    }

    public Map<T, List<T>> getList() {
        return adjList;
    }

    // Add edge
    public void addEdge(T u, T v) {
        adjList.get(u).add(v);
        if (!isDirected) {
            adjList.get(v).add(u);
        }
    }

    // Display graph
    public void printGraph() {
        for (T node: adjList.keySet()) {
            System.out.print(node + " -> ");
            for (T neighbour : adjList.get(node)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
    
}