package Array;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.jar.Attributes.Name;

public class SSTRING {

	public static void main(java.lang.String[] args) {
//		Scanner sc =new Scanner(System.in);
//		System.out.println("Enter Your Name ");
//		String s1=sc.nextLine();
//		
//		System.out.println("Your Name is " +s1);
		//concatinate
		String s1="Tony";
		String s2="Stark";
		String s3=s1+" " +s2;
		
		System.out.println(s3);
		System.out.println(s3.length());
		
//		for(int i=0;i<s3.length();i++) {
//			
//			System.out.println(s3.charAt(i));
//			
//		}
		
		if(s1.compareTo(s2)==0) {
			System.out.println("String are equal");
		}else {
			System.out.println("String are not equal");
		}
		
		
		String sentence="My name is Tom Hardy";
		String name= sentence.substring(11,sentence.length());
		//String name= sentence.substring(11,sentence.length());
		System.out.println(name);
		

	}

}
