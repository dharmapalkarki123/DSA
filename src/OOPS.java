
//class Pen{
//	
//	String color;
//	String type;
//	
//	
//	public void write() {
//		
//		System.out.println("Write something");
//			
//		
//		
//	}
//	
//	public void printColor() {
//		
//		
//		System.out.println(this.color);
//		System.out.println(this.type);
//	}
//	
//	
//}



class Student{
	
	String name;
	int age ;
	
	
	
	public void printInfo() {
		
		System.out.println(this.name);
		System.out.println(this.age);
		
		
	}
	
	
	//constructor non parameterized
	Student(){
		
		System.out.println("Constructor is called");
		
		
		
	}
	
	
	
	
	//parameterized constructor
	Student(String name, int age){
		
		this.name=name;
		this.age=age;
		
		
		
	}
	
	
	//copy constructor
	Student(Student s3){
		this.name=s3.name;
		this.age=s3.age;
		
	}
	
	
	
}


public class OOPS {

	public static void main(String[] args) {
	 
		/*
		Pen pen1=new Pen(); //object creation of class
	  
	  pen1.color="blue";
	  pen1.type="ballpen";
	  
	  pen1.write();
	  
	  pen1.printColor();
	  
	  Pen pen2=new Pen();
	  pen2.color="black";
	  pen2.type="cello";
	  
	  pen2.printColor();
	  
	  
	  */
	  
		
		//non parameterized constructor exmaple object
		Student s1=new Student();
		s1.name="aman";
		s1.age=24;
		s1.printInfo();
	  
	  
		
		//parameterized constructor related object
	  Student s2=new Student("aman", 24);
	  s2.printInfo();
	  
	  //copying constructor usally s2 value is assign into s3 object
	  Student s3=new Student(s2);
	  s3.printInfo();
	  
	  
	  

	}

}
