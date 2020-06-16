package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {
    private List<String> vertexList;
    private int[][] edges;
    private int numEdges;
    private boolean[] visited;

    public GraphDFS(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        this.visited = new boolean[n];
    }

    public static void main(String[] args) {
        int n = 8;
        String[] vertexValue = {"A", "B", "C", "D", "E", "F", "G", "H"};
        GraphDFS graph = new GraphDFS(n);
        for (String vertex : vertexValue) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();
        graph.dfs();

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

    public void dfs(int i) {
        System.out.print(getValueByIndex(i) + "->");
        visited[i] = true;
        // 查找当前节点的下一个节点
        int w = getFirstVertex(i);
        while (w != -1) {
            if (!visited[w]) {
                dfs(w);
            }
            w = getNextVertex(i, w);
        }
    }

    public void dfs() {
//        for (int i = 0; i < getNumOfVertex(); i++) {
//            if (!visited[i]) {
//                dfs(i);
//            }
//        }
        dfs(0);
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
