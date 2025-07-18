package DFS;

import Graphs.Graph_AdjList;
import DFS.DFS;

public class TestDfs {
    public static void main(String[] args) {
        Graph_AdjList<Integer> graph = new Graph_AdjList<>(8, false);

        // graph.addEdge(0, 1);
        // graph.addEdge(0, 2);
        // graph.addEdge(1, 2);
        // graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(7, 7);

        graph.printGraph();

        DFS dfs = new DFS(graph);
        dfs.dfs(0);
        dfs.totalComponents();
    }
}