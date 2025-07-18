package DFS;

import Graphs.Graph_AdjList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFS {

    public Graph_AdjList<Integer> graph;

    public DFS(Graph_AdjList<Integer> graph) {
        this.graph = graph;
    }

    public void dfs(int node) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> list = graph.getList();

        // use recursion technique for dfs
        boolean[] visited = new boolean[graph.getList().size()];
        dfsRec(list, visited, node, res);

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                dfsRec(list, visited, i, res);
            }
        }

        printRes(res);
    }

    public int totalComponents() {
        int count = 0;
        boolean[] visited = new boolean[graph.getList().size()];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < graph.getList().size(); i++) {
            if (!visited[i]) {
                count++;
                dfsRec(graph.getList(), visited, i, res);
            }
        }

        System.out.println("Total components are: " + count);
        return count;
    }

    // iteratively method in which each node is pushed on stack and then popped to
    // mark as visited and then push all its neighbouring node on stack too to 
    // maintain depth first order.
    public void dfsIterative(int node) {
        int n = graph.getList().size();
        Map<Integer, List<Integer>> adjList = graph.getList();

        boolean[] visited = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (visited[currNode]) continue;

            visited[currNode] = true;
            res.add(currNode);

            for (int neigNode : adjList.get(currNode)) {
                if (!visited[neigNode]) {
                    stack.push(neigNode);
                }
            }
        }
        printRes(res);
    }
    
    public void printRes(ArrayList<Integer> res) {
        System.out.print("DFS recurive: ");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }

    // recusively checks if node is not visited then mark it as visited and check
    // its neighbouring node else if visited then just bactrack (return)
    public void dfsRec(Map<Integer, List<Integer>> list, boolean[] visited, int node, ArrayList<Integer> res) {
        if (visited[node]) return;
        visited[node] = true;

        res.add(node);
        for (int i: list.get(node)) {
            if (!visited[i]) {
                dfsRec(list, visited, i, res);
            }
        }
    }
}