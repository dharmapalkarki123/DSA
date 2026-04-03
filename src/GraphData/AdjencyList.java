package GraphData;

import java.util.ArrayList;

public class AdjencyList {

    // Edge class represents a connection between two vertices
    static class Edge {

        int src;     // source vertex
        int dest;    // destination vertex
        int weight;  // weight of the edge

        // Constructor to initialize edge values
        public Edge(int src, int dst, int w) {
            this.src = src;
            this.dest = dst;
            this.weight = w;
        }
    }

    // Function to create and initialize the graph
    public static void createGraph(ArrayList<Edge> graph[]) {

        // Initialize each index of array with an empty ArrayList
        // This is required before adding edges
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges to the graph
        // graph[x] means edges starting from vertex x

        graph[0].add(new Edge(0, 2, 2));   // 0 → 2 (weight 2)

        graph[1].add(new Edge(1, 2, 10));  // 1 → 2 (weight 10)
        graph[1].add(new Edge(1, 2, 0));   // 1 → 2 (weight 0)

        graph[2].add(new Edge(2, 0, 2));   // 2 → 0 (weight 2)
        graph[2].add(new Edge(2, 1, 10));  // 2 → 1 (weight 10)
        graph[2].add(new Edge(2, 3, -1));  // 2 → 3 (weight -1)

        graph[3].add(new Edge(3, 1, 0));   // 3 → 1 (weight 0)
        graph[3].add(new Edge(3, 2, -1));  // 3 → 2 (weight -1)
    }

    public static void main(String[] args) {

        int V = 4; // Number of vertices

        // Create an array of ArrayList to store adjacency list
        ArrayList<Edge> graph[] = new ArrayList[V];

        // Initialize graph with edges
        createGraph(graph);

        // Traversing the graph
        for (int i = 0; i < graph.length; i++) {

            // ❌ This line can cause IndexOutOfBoundsException
            // because graph[i].get(i) assumes each list has at least i elements
            // Edge e = graph[i].get(i);

            // ✅ Correct way: iterate through all edges of each vertex
            for (Edge e : graph[i]) {
                System.out.println("From " + e.src + " to " + e.dest + " weight = " + e.weight);
            }
        }
    }
}