import java.util.Scanner;

public class Conditional {
	
	public static void main(String args[]) {
		
//		Scanner sc=new  Scanner(System.in);
//		
//		System.out.println("Enter a ");
//		int a = sc.nextInt();
//		
//		System.out.println("Enter b ");
//		int b=sc.nextInt();
//		
//		
//		
//		if(a<b) {
//			System.out.printf("%d is greater \n",  b);
//		}else {
//			System.out.printf(" %d is greater \n", a);
//		}
//		
//		switch (b) {
//		case 1: System.out.println("Dharmapal");
//		 break;
//		case 2: System.out.println("Suajata");
//		break;
//		case 3: System.out.println("Nisha");
//		break;
//		default: System.out.println("INALID");
//		}
//		
//		
//		
//		
//		for(int i=1;i<=4;i++) {
//			 
//			for(int j=1;j<=4; j++) {
//				
//				System.out.print("*");
//			}
//			
//			System.out.println();
//			
//		}
//		
//		
//		for(int i=1;i<=4;i++) {
//			 
//			for(int j=1;j<=4; j++) {
//				
//				if(i==1 || j==1 || i==4 || j==4 ) {
//					
//					System.out.print("*");
//					
//				}else {
//					
//					System.out.print(" ");
//				}
//				
//			}
//			
//			System.out.println();
//			
//		}
		
		
		
//		for(int i=1; i<=4;i++) {
//			
//			for(int j=1; j<=i; j++)
//			{
//				
//				System.out.print("*");
//			
//			}
//			
//			System.out.println();
//			
//		}
		
		
//		for(int i=4; i>=1;i--) {
//			
//			for(int j=1; j<=i; j++)
//			{
//				
//				System.out.print("*");
//			
//			}
//			
//			System.out.println(" ");
//			
//		}
		
		
//		for(int i=1;i<=4;i++) {
//			for(int j=1; j<=4-i; j++) {
//				System.out.print(" ");
//			}
//			
//			for(int j=1; j<=i;j++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
//		
		
		for(int i=4;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				
				System.out.print(j +" ");
				
				
				
			}
			System.out.println();
			
			
		}
		
		System.out.println();
		
		

		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i;j++) {
				
				System.out.print(j +" ");
				
				
				
			}
			System.out.println();
			
			
		}
		
		System.out.println();
		
		
		
		int num=1;
		
		
		
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i;j++) {
				
				System.out.print(num);
				
				num++;
				
			}
			System.out.println();
			
			
		}
		
		System.out.println();
		
		
		
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i;j++) {
				
				int sum=i+j;
				
				if(sum%2==0) {
					
					System.out.print("1");
					
				}else {
					
					System.out.print("0");
				}
				
			
				
			}
			System.out.println();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
