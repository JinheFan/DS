package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    private List<String> vertexList;
    private int[][] edges;
    private int numEdges;
    private boolean[] visited;

    public GraphBFS(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        this.visited = new boolean[n];
    }

    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        GraphBFS graph = new GraphBFS(n);
        for (String vertex : vertexValue) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
        graph.bfs();
    }

    public void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + " -> ");
        visited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            int nextVertexIndex = getFirstVertex(index);
            if (nextVertexIndex != -1) {
                if (!visited[nextVertexIndex]) {
                    System.out.print(getValueByIndex(nextVertexIndex) + " -> ");
                    visited[nextVertexIndex] = true;
                    queue.add(nextVertexIndex);
                }
            }
            int otherVertex = getNextVertex(index, nextVertexIndex);
            while (otherVertex != -1) {
                if (!visited[otherVertex]) {
                    System.out.print(getValueByIndex(otherVertex) + " -> ");
                    visited[otherVertex] = true;
                    queue.add(otherVertex);
                }
                otherVertex = getNextVertex(index, otherVertex);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumEdges() {
        return numEdges;
    }

    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 得到当前节点的下一个节点的 index
    public int getFirstVertex(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // 根据前一个节点 （v1） 当前节点 (v2) 的下标得到下一个节点的下标
    public int getNextVertex(int v1, int v2) {
        for (int index = v2 + 1; index < vertexList.size(); index++) {
            if (edges[v1][index] > 0) {
                return index;
            }
        }
        return -1;
    }

    public void showGraph() {
        for (int[] row : edges) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
