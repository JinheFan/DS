package graph;

import java.util.Arrays;

public class Floyd {
    public static void main(String[] args) {
        int[][] matrix = {
                {65535, 8, 1, 65535},
                {8, 65535, 2, 2},
                {1, 2,65535, 10},
                {65535, 2, 10, 65535}
        };
        char[] vertices = {'A', 'B', 'C', 'D'};
        Graph graph = new Graph(vertices.length, vertices, matrix);
        graph.floyd(vertices.length);
        graph.show();
    }

    static class Graph {
        char[] vertices;
        int[][] distance;
        int[][] pre;

        public Graph(int length, char[] vertices, int[][] matrix) {
            this.vertices = vertices;
            this.distance = matrix;
            this.pre = new int[length][length];
            for (int i = 0; i < length; i++) {
                Arrays.fill(pre[i], i);
            }

        }

        public void floyd(int length) {
            int dist = 0;
            for (int k = 0; k < length; k++) {
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {
                        dist = distance[i][k] + distance[k][j];
                        if (dist < distance[i][j]) {
                            distance[i][j] = dist;
                            pre[i][j] = pre[k][j];
                        }
                    }
                }
            }
        }

        public void show() {
            for (int i = 0; i < distance.length; i++) {
                System.out.print(Arrays.toString(distance[i]));
                System.out.println();
            }
        }
    }
}
