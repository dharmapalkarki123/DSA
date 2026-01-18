package Recursion;



public class nQueen {

   
   
    public static void main(String[] args) {
    	
    	
    	int n=4;
    	
    	char[][] board =new char[n][n];
    	
    	for(int i=0; i<n; i++) {
    		
    		for(int j=0;j<n;j++) {
    			
    			board[i][j]='.';
    		
    			
    			
    		}
    		
    		
    	}
    	solveNqueen(board,0);

    }

	private static void solveNqueen(char[][] board, int row) {
		int n=board.length;
		
		if(row==n) {
			
			for(int i=0; i<n; i++) {
	    		
	    		for(int j=0;j<n;j++) {
	    			
	    			System.out.println(board[i][j]);
	    		
	    			
	    		}
	    		
	    		System.out.println();
			
		}
			return;
		}
		for(int j=0;j<n;j++) {
			
			if(isSafe(board,row,j)) {
				
				board[row][j]='Q';
				solveNqueen(board, row+1);
				board[row][j]='.'; //backtacking
				
				
			}
			
			
		}
		
	}

	private static boolean isSafe(char[][] board, int row, int col) {
		
		//for row
		for(int j=0;j<board.length;j++) {
			
			if(board[row][j]=='Q') {
				return false;
			}
			
		}
		
		
		for(int i=0;i<board.length;i++) {
			
			if(board[i][col]=='Q') {
				return false;
			}
			
		}
		
		
		
		return true;
	}
}
