//All Pairs Shortest Paths problem solution using Floyd’s Algorithm (Dynamic Programming Approach) 
import java.util.*;

public class FloydWarshall {
    int vertices = 4;
    int adjmatrix[][];

    public FloydWarshall() {
        //-1 means no direct edge
        adjmatrix = new int[][] {
            {0,   5,  -1, 10},
            {-1,  0,   3, -1},
            {-1, -1,   0,  1},
            {-1, -1,  -1,  0}
        };
    }

    public void floydWarshall() {
        int dist[][] = new int[vertices][vertices];

        // Initialize distance matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjmatrix[i][j] == -1 && i != j) {
                    dist[i][j] = Integer.MAX_VALUE; // treat -1 as infinity
                } else {
                    dist[i][j] = adjmatrix[i][j];
                }
            }
        }

        // Floyd-Warshall main logic
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE &&
                        dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print result
        System.out.println("All Pairs Shortest Path Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall obj = new FloydWarshall();
        obj.floydWarshall();
    }
}

    