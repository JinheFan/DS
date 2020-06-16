package graph;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] matrix = {
                {Integer.MAX_VALUE, 8, 1, Integer.MAX_VALUE},
                {8, Integer.MAX_VALUE, 2, 2},
                {1, 2, Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, 2, 10, Integer.MAX_VALUE}
        };
        int[] vertices = {0, 1, 2, 3};
        Graph graph = new Graph(vertices, matrix, 0);
        System.out.println(Arrays.toString(graph.visitedVertex.distance));
    }

    static class Graph {
        int[] vertices;
        int[][] matrix;
        VisitedVertex visitedVertex;

        public Graph(int[] vertices, int[][] matrix, int start) {
            this.vertices = vertices;
            this.matrix = matrix;
            visitedVertex = new VisitedVertex(vertices.length, start);
            dijkstra(start);
        }

        public void dijkstra(int start) {
            update(start);
            for (int i = 1; i < vertices.length; i++) {
                int nextIndex = visitedVertex.getNextIndex();
                update(nextIndex);
            }
        }

        private void update(int index) {
            int dist = 0;
            for (int i = 0; i < matrix[index].length; i++) {
                dist = visitedVertex.getDistance(index) + matrix[index][i];
                if (!visitedVertex.visited[i] && dist < visitedVertex.getDistance(i)) {
                    visitedVertex.updateParent(i, index);
                    visitedVertex.updateDistance(i, dist);
                }
            }
        }
    }

    static class VisitedVertex {
        boolean[] visited;
        int[] parent;
        int[] distance;

        public VisitedVertex(int length, int vertex) {
            this.visited = new boolean[length];
            this.parent = new int[length];
            this.distance = new int[length];

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[vertex] = 0;
            this.visited[vertex] = true;
        }

        private void updateDistance(int index, int dis) {
            this.distance[index] = dis;
        }

        private void updateParent(int index, int parentIndex) {
            this.parent[index] = parentIndex;
        }

        private int getDistance(int index) {
            return this.distance[index];
        }

        private int getNextIndex() {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    index = i;
                }
            }
            visited[index] = true;
            return index;
        }
    }
}
