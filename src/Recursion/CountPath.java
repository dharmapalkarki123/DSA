package Recursion;

public class CountPath {
	
	public static int countPath(int i,int j,int n, int m) {
		
		if(i==n || j==m) {
			
			return 0;
			
		}
		
		if(i==n-1&&j==m-1) {
			
			return 1;
			
			
		}
		
		
		//move down
		int downPaths=countPath(i+1,j,n,m);
		
		//move right
		int rightPath=countPath(i, j+1, n, m);
		
		return downPaths+rightPath;
		
		
	}

	public static void main(String[] args) {
		int n=3,m=3;
		int totalPath=countPath(0, 0, n, m);
		
		System.out.println(totalPath);
		

	}

}
