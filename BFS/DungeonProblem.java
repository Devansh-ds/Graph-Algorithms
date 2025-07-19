package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class DungeonProblem {
    
    private String[][] matrix;
    private int R;
    private int C;
    private int sr = 0, sc = 0;
    private Queue<Integer> rowQueue = new LinkedList<>();
    private Queue<Integer> columnQueue = new LinkedList<>();

    // variables used to track the steps taken
    private int move_count = 0;
    private int nodes_left_in_layer = 1;
    private int nodes_in_next_layer = 0;

    private boolean reached_end = false;

    // visited matrix to track which node (i, j) is visited
    private boolean[][] visited;

    // direction vectors
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};

    // traverse the path
    private int[][][] path;
    private int endRow;
    private int endCol;

    public DungeonProblem() {
        this.matrix = new String[][] {
            {"S", "", "", "#", "", "", ""},
            {"", "#", "", "", "", "#", ""},
            {"", "#", "", "", "", "", ""},
            {"", "", "#", "#", "", "", ""},
            {"#", "", "#", "E", "", "#", ""},
        };
        this.R = matrix.length;
        this.C = matrix[0].length;
        this.visited = new boolean[R][C];
        this.path = new int[R][C][2];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                path[i][j][0] = -1;
                path[i][j][1] = -1;
            }
        }
    }

    private void explore_neighbours(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];

            // skip out of bound locations
            if (rr < 0 || cc < 0) continue;
            if (rr >= R || cc >= C) continue;

            // skip visited and blocked locations
            if (visited[rr][cc]) continue;
            if (matrix[rr][cc] == "#") continue;

            // else
            rowQueue.add(rr);
            columnQueue.add(cc);
            visited[rr][cc] = true;
            nodes_in_next_layer++;

            // to traverse path
            path[rr][cc][0] = r;
            path[rr][cc][1] = c;
        }
    }

    private int solveDungeon() {
        rowQueue.add(sr);
        columnQueue.add(sc);
        visited[sr][sc] = true;

        while (rowQueue.size() > 0) {
            int r = rowQueue.poll();
            int c = columnQueue.poll();

            if (matrix[r][c] == "E") {
                reached_end = true;
                endRow = r;
                endCol = c;
                break;
            }
            explore_neighbours(r, c);
            nodes_left_in_layer--;
            if (nodes_left_in_layer == 0) {
                nodes_left_in_layer = nodes_in_next_layer;
                nodes_in_next_layer = 0;
                move_count++;
            }
        }

        if (reached_end) return move_count;
        return -1;
    }

    private void path() {
        if (!reached_end) return;

        LinkedList<String> pathRes = new LinkedList<>();
        int r = endRow;
        int c = endCol;

        while (r != -1 && c != -1) {
            pathRes.addFirst("(" + r + "," + c + ")");
            int pr = path[r][c][0];
            int pc = path[r][c][1];
            r = pr;
            c = pc;
        }

        System.out.print("Path from S to E: ");
        for (String step: pathRes) {
            System.out.print(step + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DungeonProblem dungeonProblem = new DungeonProblem();
        int mc = dungeonProblem.solveDungeon();
        System.out.println("Move count: " + mc);
        dungeonProblem.path();
    }

}
