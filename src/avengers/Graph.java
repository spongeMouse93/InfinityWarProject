package avengers;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int source, int dest) {
        adj[source].addFirst(dest);
        adj[dest].addFirst(source);
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        DFS(0, visited);
        int count = 0;
        for (int i = 0; i < visited.length; i++)
            if (visited[i])
                count++;
        return count == vertices;
    }

    private void DFS(int source, boolean[] visited) {
        visited[source] = true;
        for (int i = 0; i < adj[source].size(); i++) {
            int neighbor = adj[source].get(i);
            if (!visited[neighbor])
                DFS(neighbor, visited);
        }
    }

    public void removeVertex(int vertex) {
        adj[vertex].clear();
    }
}