package Topsort;

import Graphs.Graph_AdjList;
import java.util.List;
import java.util.Stack;

public class TopsortDfs {
    private Graph_AdjList<Integer> graph;

    public TopsortDfs(Graph_AdjList<Integer> graph) {
        this.graph = graph;
    }

    public void topsort(int node) {
        boolean[] visited = new boolean[graph.getList().size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.getList().size(); i++) {
            if (!visited[i]) {
                topsortUtil(i, visited, stack);
            }
        }
        
        displayTopsort(stack);
    }

    public void topsortUtil(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int childNode : graph.getList().get(node)) {
            if (!visited[childNode]) {
                topsortUtil(childNode, visited, stack);
            }
        }
        stack.push(node);
    }

    public void displayTopsort(Stack<Integer> stack) {
        System.out.print("Topsort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Graph_AdjList<Integer> graph = new Graph_AdjList<>(6, true);

        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopsortDfs topsortDfs = new TopsortDfs(graph);
        topsortDfs.topsort(3);
    }

}
