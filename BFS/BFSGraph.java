package BFS;

import Graphs.Graph_AdjList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraph {
    Graph_AdjList<Integer> graph;
    boolean[] visited;
    
    public BFSGraph(Graph_AdjList<Integer> graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getList().size()];
    }

    public void getBFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> list = graph.getList();

        queue.add(node);
        visited[node] = true;

        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            res.add(currNode);

            for (int child : list.get(currNode)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        displayBfs(res);
    }

    public void getBfsDisconnected(int node) {
        int count = 1;

        for (int i = 0; i < graph.getList().size(); i++) {
            if (!visited[i]) {
                getBFS(i);
                count++;
            }
        }

        System.out.println("Total components: " + count);
    }

    public void displayBfs(ArrayList<Integer> res) {
        System.out.print("BFS queue: ");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }
}