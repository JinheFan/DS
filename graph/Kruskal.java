package graph;

public class Kruskal {
    public static void main(String[] args) {

    }
}

class KruskalCase {
    int edgeNum;
    char[] vertices;
    int[][] matrix;
    public KruskalCase(char[] vertices, int[][] matrix) {
        this.vertices = vertices;
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    edgeNum++;
                }
            }
        }
    }

    private void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        Edge[] res = new Edge[edgeNum];
        Edge[] edges = getEdges();
        sortEdges(edges);
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition((char) edges[i].start);
            int p2 = getPosition((char) edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                res[index++] = edges[i];
            }
        }
    }

    private Edge[] getEdges() {
        Edge[] edges = new Edge[edgeNum];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    edges[index++] = new Edge(vertices[i], vertices[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] end, int i) {
        while (end[i] != 0) {
            i = end[i];
        }
        return i;
    }

    public void sortEdges(Edge[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight)
                swap(edges, j, j + 1);
            }
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private static void swap(Edge[] edges, int i, int j) {
        Edge temp = edges[i];
        edges[i] = edges[j];
        edges[j] = temp;
    }

}


