package Graphs;
public class Graph_AdjMatrix {
    private int[][] adjMatrix;
    private int vertices;
    private boolean isDirected;

    public Graph_AdjMatrix(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjMatrix = new int[vertices][vertices];
    }

    // Add edge
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        if (!isDirected) {
            adjMatrix[v][u] = 1;
        }
    }


    // Display matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Graph_AdjMatrix graph = new Graph_AdjMatrix(5, false);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printMatrix();
    }
}
