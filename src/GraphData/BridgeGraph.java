package GraphData;

import java.util.ArrayList;

public class BridgeGraph {

    // Edge class represents a connection between two vertices
    static class Edge {
        int src;   // source vertex
        int dest;  // destination vertex

        // Constructor
        public Edge(int src, int dst) {
            this.src = src;
            this.dest = dst;
        }
    }

    // Function to create graph using adjacency list
    public static void createGraph(ArrayList<Edge> graph[]) {

        // Initialize each index with empty list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Creating an undirected graph
        // (Every edge added in both directions)

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    // DFS function to find bridges
    public static void dfs(ArrayList<Edge> graph[], int curr,
                           boolean vis[], int dist[], int low[],
                           int time, int par) {

        vis[curr] = true;

        // Set discovery time and low value
        dist[curr] = low[curr] = ++time;

        // Traverse all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // Ignore parent node (avoid going back)
            if (e.dest == par) {
                continue;
            }

            // If neighbor is not visited → DFS call
            else if (!vis[e.dest]) {

                dfs(graph, e.dest, vis, dist, low, time, curr);

                // Update low value after returning
                low[curr] = Math.min(low[curr], low[e.dest]);

                // Bridge condition
                // If no back-edge from child subtree
                if (dist[curr] < low[e.dest]) {
                    System.out.println("Bridge is " + curr + " -----> " + e.dest);
                }
            }

            // If already visited → back edge
            else {
                low[curr] = Math.min(low[curr], dist[e.dest]);
            }
        }
    }

    // Main function to initialize arrays and call DFS
    public static void bridgeGraph(ArrayList<Edge> graph[], int V) {

        int dist[] = new int[V]; // discovery time
        int low[] = new int[V];  // lowest reachable time
        int time = 0;

        boolean vis[] = new boolean[V]; // visited array

        // Call DFS for each component
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, dist, low, time, -1);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        bridgeGraph(graph, V);
    }
}