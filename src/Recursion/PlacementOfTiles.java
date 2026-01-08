package Recursion;

public class PlacementOfTiles {
	
	
	public static int placeTiles(int n, int m) {
		
		
		
		if(n==m) {
		
			return 2;
			
		}
		
		if(n<m) {
			
			
			return 1;
			
		}
		
		
		
		//vertical Placement
		int veticalPlacement=placeTiles(n-m, m);
		
		//horizontalPlacement
		int horizontalPacement=placeTiles(n-1, m);
		
		
		return veticalPlacement+horizontalPacement;
		
		
	}
	

	public static void main(String[] args) {
		int n=4, m=2;
		
		int totalPlacementOfTiles= placeTiles(n, m);
		System.out.println(totalPlacementOfTiles);

	}

}
