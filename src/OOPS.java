
class Pen{
	
	String color;
	String type;
	
	
	public void write() {
		
		System.out.println("Write something");
			
		
		
	}
	
	public void printColor() {
		
		
		System.out.println(this.color);
		System.out.println(this.type);
	}
	
	
}


public class OOPS {

	public static void main(String[] args) {
	  Pen pen1=new Pen(); //object creation of class
	  
	  pen1.color="blue";
	  pen1.type="ballpen";
	  
	  pen1.write();
	  
	  pen1.printColor();
	  
	  Pen pen2=new Pen();
	  pen2.color="black";
	  pen2.type="cello";
	  
	  pen2.printColor();
	  
	  

	}

}
