import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int rows=sc.nextInt();
		int cols=sc.nextInt();
		
		int[][] arrays=new int[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
		  for(int j=0;j<cols;j++)
		  {
			  arrays[i][j]=sc.nextInt();
			  
			  }
		}
		
		for(int i=0;i<rows;i++) {
			
			for(int j=0;j<cols;j++) {
				
				System.out.print(arrays[i][j] +" ");
				
			}
			
			System.out.println();
			
		}

		
		

	}

}
