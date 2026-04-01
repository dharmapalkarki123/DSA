package GraphData;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class AdjencyList {
	
	static class Edge{
		
		int src;
		int dest;
		
		public Edge(int src,int dst) {
			this.src=src;
			this.dest=dst;
			
		}
		
		
		
		
		
	}
	
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0;i<graph.length;i++) {
			
			graph[i]=new ArrayList<Edge>();
			
			
		}
		
		
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 2));
		graph[1].add(new Edge(1, 2));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 2));
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int V =4;
		ArrayList<Edge> graph[]=new ArrayList[V];
		
		createGraph(graph);
		
		
		for(int i=0;i<graph[3].size();i++) {
			
			Edge e=graph[3].get(i);
			
			System.out.print(e.dest+ " ");
			
		}
		
	}

}
