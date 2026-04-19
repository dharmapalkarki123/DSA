
package GraphData;

import java.util.ArrayList;

public class CycleDetection {

    // Edge class represents a directed edge from src -> dest
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create graph using adjacency list
    public static void createdGraph(ArrayList<Edge> graph[]) {

        // Initialize each index with empty ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Add edges (Directed Graph)
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

        // Graph structure:
        // 0 → 2 → 3 → 0 (cycle)
        // 1 → 0
    }

    // DFS function to detect cycle in directed graph
    public static boolean isCycleDirected(ArrayList<Edge> graph[],
                                          boolean vis[],
                                          int curr,
                                          boolean rec[]) {

        // Mark current node as visited
        vis[curr] = true;

        // Add current node to recursion stack
        rec[curr] = true;

        // Traverse all neighbors of current node
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // Case 1: If neighbor is already in recursion stack → cycle found
            if (rec[e.dest]) {
                return true;
            }

            // Case 2: If neighbor is not visited → go deeper (DFS)
            else if (!vis[e.dest]) {
                if (isCycleDirected(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }

        // Remove current node from recursion stack (backtracking)
        rec[curr] = false;

        // No cycle found from this path
        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        // Create graph array
        ArrayList<Edge> graph[] = new ArrayList[V];

        createdGraph(graph);

        // vis[] → tracks visited nodes
        boolean vis[] = new boolean[V];

        // rec[] → tracks nodes in current recursion stack
        boolean rec[] = new boolean[V];

        // Check for cycle in all components
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                // IMPORTANT FIX: pass 'i' not 0
                boolean isCycle = isCycleDirected(graph, vis, i, rec);

                if (isCycle) {
                    System.out.println("Cycle detected: " + isCycle);
                    break;
                }
            }
          
        }
        
        // System.out.println(isCycleDirected(graph, vis, 0, rec));
    }
}