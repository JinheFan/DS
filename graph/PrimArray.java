package graph;

public class PrimArray {
    public static void main(String[] args) {

    }
}

class MinTree {
    public void createGraph(MGraph graph, int vertices, char[] data, int[][] weight) {
        for (int i = 0; i < vertices; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertices; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.vertices];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE;
        for (int k = 1; k < graph.vertices; k++) {
            for (int i = 0; i < graph.vertices; i++) {
                for (int j = 0; j < graph.vertices; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            visited[h2] = 1;
            minWeight = Integer.MAX_VALUE;
        }
    }
}

class MGraph {
    int vertices;
    char[] data;
    int[][] weight;

    public MGraph(int vertices) {
        this.vertices = vertices;
        this.data = new char[vertices];
        this.weight = new int[vertices][vertices];
    }
}
