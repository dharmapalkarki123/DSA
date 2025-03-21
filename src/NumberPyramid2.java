
public class NumberPyramid2 {

	public static void main(String[] args) {
		int n=5;
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			
			for(int j=1;j<=i;j++) {
				System.out.print(i +" ");
			}
			
			System.out.println();
			
		}

	}

}


//public class NumberPyramid2 {
//
//    public static void main(String[] args) {
//        int n = 5;
//        
//        for (int i = 1; i <= n; i++) {
//
//            // Print leading spaces
//            for (int j = 1; j <= n - i; j++) {  // Fixed: Changed "i" to "j" and corrected condition
//                System.out.print(" ");
//            }
//
//            // Print numbers
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i + " ");
//            }
//
//            System.out.println();
//        }
//    }
//}
