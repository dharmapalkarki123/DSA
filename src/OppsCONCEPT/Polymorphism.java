package OppsCONCEPT;


//Compile time polymorphism also known as function overloading

class Student {
	
	int age ;
	String name ;
	
	
	
	public  void printInfo(int age) {
		System.out.println(age);
		
	}
	
	public void printInfo(String name) {
		
		
		System.out.println(name);
		
	}
	
	
	
	public void printInfo(int age, String name) {
		
		System.out.println(name+ " "+ age);
		
		
	}
	
	
}

public class Polymorphism {

	public static void main(String[] args) {
		
		
		Student s1=new Student();
		s1.name="Rameshwor";
		s1.age=24;
		s1.printInfo(s1.age,s1.name);
		

	}

}
