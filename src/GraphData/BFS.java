package GraphData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class BFS {
	
	static class Edge{
		
		int src;
		int dest;
		
		
		public Edge(int s,int d) {
			
			this.src=s;
			this.dest=d;
			
			
			
			
		}
		
	}
		
		
		
	public static void createdGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0;i<graph.length;i++) {
			
			graph[i]= new ArrayList<Edge>();
			
		}
		
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2,4));
		
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
	}
		
		
		
		
	
	
	/*
	public static void bfs(ArrayList<Edge> graph[],int V) {
		
		Queue<Integer> q=new LinkedList<>();
		
		boolean vis[]=new boolean[V];
		
		q.add(0);
		
		while(!q.isEmpty()) {
			
			int curr =q.remove();
			
			if(vis[curr]==false) {
				
				System.out.print(curr+" ");
				vis[curr]=true;
				
				for(int i=0;i<graph[curr].size();i++) {
					
					Edge e=graph[curr].get(i);
					
					q.add(e.dest);
					
					
				}
				
			}
			
			
			
		}
		
	
	*/

	
	public static void bfs(ArrayList<Edge> graph[],int V,boolean vis[], int start) {
		
		Queue<Integer> q=new LinkedList<>();
		
		
		
		q.add(start);
		
		while(!q.isEmpty()) {
			
			int curr =q.remove();
			
			if(vis[curr]==false) {
				
				System.out.print(curr+" ");
				vis[curr]=true;
				
				for(int i=0;i<graph[curr].size();i++) {
					
					Edge e=graph[curr].get(i);
					
					q.add(e.dest);
					
					
				}
				
			}
			
			
			
		}
	
		
		
		
	
	}
	
	
	
	
			
			
			
			
		
		
		
	// Depth First Search (DFS) traversal for a graph
	// graph[] -> adjacency list representation of graph
	// curr -> current node we are visiting
	// vis[] -> boolean array to keep track of visited nodes
	public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
	    
	    // Step 1: Print the current node (this is where we "visit" the node)
	    System.out.print(curr + " ");
	    
	    // Step 2: Mark current node as visited so we don't visit it again
	    vis[curr] = true;
	    
	    // Step 3: Traverse all neighbors of current node
	    // graph[curr] contains list of edges from current node
	    for (int i = 0; i < graph[curr].size(); i++) {
	        
	        // Get the edge at index i
	        Edge e = graph[curr].get(i);
	        
	        // Step 4: If the destination node is not visited yet
	        if (vis[e.dest] == false) {
	            
	            // Recursively call DFS for that neighbor
	            // This goes deep into the graph (core idea of DFS)
	            dfs(graph, e.dest, vis);
	        }
	    }
	}
	
	
	public static void printAllpath(ArrayList<Edge> graph[],int curr,boolean vis[], String path,int tar) {
		
		int count=0;
		if(curr==tar) {
			System.out.println(path);
			System.out.println(count);
		}
		
		for(int i=0;i<graph[curr].size();i++) {
			
			Edge e=graph[curr].get(i);
			if(!vis[e.dest]) {
				vis[curr]=true;
				printAllpath(graph, e.dest, vis, path+e.dest, tar);
				vis[curr]=false;
				
				
				
			}
			
			count++;
			
			
			
			
			
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		int V=7;
		
		ArrayList<Edge> graph[]=new ArrayList[V];
		createdGraph(graph);
		
		boolean vis[]=new boolean[V];
		
	
		printAllpath(graph, 0, vis, "0", 5);
		
//		for(int i=0;i<V;i++) {
//			
//			if(vis[i]==false) {
//				bfs(graph, V,vis,i);
//			}
//			
//		}
		
		
//for(int i=0;i<V;i++) {
//			
//			if(vis[i]==false) {
//				dfs(graph, i,vis);
//			}
//			
//		}
		
		//bfs(graph, V);
		
//		dfs(graph, 0, vis);
		System.out.println();

	}

}
