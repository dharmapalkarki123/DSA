//
//public class LeftSidePyramid {
//	public static void main(String[] args) {
//		
//		for(int i=1;i<=4;i++) {
//			
//			for(int j=1;j<=i-1;j++) {
//				
//				System.out.print(" ");
//				
//			}
//			
//			for(int j=1;j<=i;j++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//			
//			
//		}
//		
//		
//	}
//	
//}


public class LeftSidePyramid {
    public static void main(String[] args) {
        int row = 0; // To find the total rows dynamically

        // Finding total rows (last i value)
        for (int i = 1; ; i++) {
            row = i;
            if (i == 4) break; // We know we need 4 rows
        }

        for (int i = 1; i <= row; i++) { // Loop for rows

            for (int j = 1; j <= row - i; j++) { // Loop for spaces
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) { // Loop for stars
                System.out.print("*");
            }

            System.out.println(); // Move to the next line
        }
    }
}
