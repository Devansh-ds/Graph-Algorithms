package BFS;
import Graphs.Graph_AdjList;


public class TestBfs {

    public static void main(String[] args) {
        Graph_AdjList<Integer> graph = new Graph_AdjList<>(7, false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(0, 2);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 6);


        BFSGraph bfs = new BFSGraph(graph);
        bfs.getBFS(0);
        bfs.getBfsDisconnected(0);
    }
    
}
