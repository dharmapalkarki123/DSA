package GraphData;

import java.util.ArrayList;

import GraphData.AdjencyList.Edge;

public class BridgeGraph {

	// Edge class represents a connection between two vertices
    static class Edge {

        int src;     // source vertex
        int dest;    // destination vertex
     

        // Constructor to initialize edge values
        public Edge(int src, int dst) {
            this.src = src;
            this.dest = dst;
          
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
        
        graph[5].add(new Edge(5,3)); 
        graph[5].add(new Edge(5,4)); 
        
    }
    
    
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[],int dist[],int low[],int time, int par) {
    	 
    	vis[curr]=true;
    	
    	dist[curr]=low[curr]=++time;
    	
    	for(int i=0;i<graph[curr].size();i++) {
    		
    		Edge e=graph[curr].get(i);
    		
    		
    		if(e.dest==par) {
    			continue;
    		}
    		else if(!vis[e.dest]) {
    			
    			dfs(graph, e.dest, vis, dist, low, time, curr);
    			low[curr]=Math.min(low[curr], low[e.dest]);
    			if(dist[curr]< low[e.dest]) {
    				
    				System.out.println("Bridge is "+ curr +"----->" +e.dest);
    				
    			}
    		}
    			else {
    				
    				low[curr]=Math.min(low[curr], dist[e.dest]);
    				
    			}
    			
    			
    		}
    		
    		
    		
    		
    		
    	}
    	
    	
    
    
    
    public static void bridgeGraph(ArrayList<Edge> graph[],int V) {
    	
    	int dist[]=new int[V];
    	
    	int low[]=new int[V];
    	int time=0;
    	
    	boolean vis[]=new boolean[V];
    	
    	for(int i=0;i<V;i++) {
    		
    		if(!vis[i]) {
    			dfs(graph,i,vis,dist,low,time,-1);
    		}
    		
    	}
    	
    	
    	
    }
    

	public static void main(String[] args) {
		 int V = 6; // Number of vertices

	        // Create an array of ArrayList to store adjacency list
	        ArrayList<Edge> graph[] = new ArrayList[V];

	        // Initialize graph with edges
	        createGraph(graph);
	        bridgeGraph(graph, V);
	}

}
