package GraphData;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    // Edge class represents a connection between two nodes with weight
    static class Edge {
        int src;   // source node
        int dest;  // destination node
        int wt;    // weight (cost)

        public Edge(int src, int dest, int wt) {
            this.dest = dest;
            this.src = src;
            this.wt = wt;
        }
    }

    // Function to create graph using adjacency list
    public static void createdGraph(ArrayList<Edge> graph[]) {

        // Initialize each index of array with empty ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges (undirected graph, so add both directions)

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 15)); // NOTE: here weight is 15 (not same as above 40 → might be mistake)
        graph[3].add(new Edge(3, 2, 50));
    }

    // Pair class used in PriorityQueue
    // It stores node and cost to reach that node
    public static class Pair implements Comparable<Pair> {

        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        // This makes PriorityQueue behave like MIN HEAP (smallest cost first)
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    // Prim's Algorithm to find Minimum Spanning Tree (MST)
    public static void primsAlgo(ArrayList<Edge> graph[], int V) {

        // PriorityQueue to always pick minimum cost edge
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean vis[] = new boolean[V]; // visited array

        pq.add(new Pair(0, 0)); // start from node 0 with cost 0

        int mstCost = 0; // total cost of MST

        while (!pq.isEmpty()) {

            Pair curr = pq.remove(); // get node with minimum cost

            // If node is not visited
            if (!vis[curr.node]) {

                vis[curr.node] = true;   // mark visited
                mstCost += curr.cost;   // add cost to MST

                // Traverse all neighbors of current node
                for (int i = 0; i < graph[curr.node].size(); i++) {

                    Edge e = graph[curr.node].get(i);

                    // If neighbor not visited, add to PQ
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        // Print total cost of MST
        System.out.println("min cost of mst=" + mstCost);
    }

    public static void main(String[] args) {

        int V = 4; // number of vertices

        ArrayList<Edge> graph[] = new ArrayList[V];

        createdGraph(graph); // create graph

        primsAlgo(graph, V); // run Prim's Algorithm
    }
}