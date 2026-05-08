package GraphData;

import java.util.ArrayList;

import GraphData.BridgeGraph.Edge;

public class ArticulatePoint {
	
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
      

        graph[4].add(new Edge(4, 3));
       
    }
    
    
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[],boolean atP[],int dt[],int low[],int time,int par) {
    	
    	 vis[curr]=true;
    	 dt[curr]=low[curr]=++time;
    	 int child=0;
    	
    	 for(int i=0;i<graph[curr].size();i++) {
    		 
    		 Edge e=graph[curr].get(i);
    		 
    		int neigh =e.dest;
    		if(par==neigh) {
    			
    			continue;
    			
    			
    		}
    		else if (vis[neigh]) {
    			
    			low[curr]=Math.min(low[curr], dt[neigh]);
				
			}
    		else {
    			dfs(graph, neigh, vis, atP, dt, low, time, curr);
    			low[curr]=Math.min(low[curr], low[neigh]);
    			
    			if(dt[curr]<=low[neigh] && par !=-1) {
    				
    				atP[curr]=true;
    				
    			}
    			
    			child++;
    		}
    		 
    		 
    	 }
    	 
    	 if(par==-1 && child>1) {
    		 
    		 atP[curr]=true;
    	 }
    	 
    	 
    	
    	
    }
    
    
    public static void ATpoint(ArrayList<Edge> graph[], int V) {
    	
    	boolean vis[]=new boolean[V];
    	boolean atP[]=new boolean[V];
    	int dt[]=new int[V];
    	int low[]=new int[V];
    	
    	int time=0;
    	
    	for(int i=0;i<V;i++) {
    		
    		if(!vis[i]) {
    			
    			dfs(graph, i, vis, atP, dt, low, time, -1);;
    			
    		}
    		
    		
    	}
    	
    	for(int i=0;i<V;i++) {
    		
    		if(atP[i])
    		
    		System.out.println("ArticulatePoint is: "+i);
    		
    		
    	}
    	
    	
    	
    }
    
    
    
	

	public static void main(String[] args) {
		int V =5;
		ArrayList<Edge>  graph[]=new ArrayList[V];
		createGraph(graph);
		ATpoint(graph, V);

	}

}
