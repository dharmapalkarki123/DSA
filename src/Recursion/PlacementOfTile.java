//Place Tiles of size 1*m in a floor n*m
package Recursion;

public class PlacementOfTile {
	
	public static int placeTiles(int n, int m) {
		
		
		if(n==m) {
			return 2;
		}
		
		if(n<m) {
			return 1;
		}
		
		//vericall palcement
		int verticalPlacement=placeTiles(n-m,m);
		
		//horizontally placement
		int horizontalPlacement=placeTiles(n-1, m);
		
		return verticalPlacement +horizontalPlacement;
	}
	
	 public static void main(String[] args) {
		 
		int n =4, m=2;
		System.out.println(placeTiles(n, m));
		 
	 }
	
	

}
