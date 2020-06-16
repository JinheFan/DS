package graph;

import java.util.*;

public class PrimAlgorithm {
    public static void main(String[] args) {

    }

    public void primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDists = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDists, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        priorityQueue.offer(new Pair<>(minDists[0], 0));
        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> pair = priorityQueue.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.end]) {
                    int destination = edge.end;
                    int curDist = edge.weight;
                    if (curDist < minDists[destination]) {
                        priorityQueue.offer(new Pair<>(curDist, destination));
                        parents[destination] = vertex;
                        minDists[destination] = curDist;
                    }
                }
            }
        }
    }
}

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    List<Edge>[] list;
    public Graph(int vertices) {
        this.vertices = vertices;
        list = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new ArrayList<>();
        }
    }
    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        list[start].add(edge);

        edge = new Edge(end, start, weight);
        list[end].add(edge);
    }
}

class Pair<I extends Number, I1 extends Number> {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}