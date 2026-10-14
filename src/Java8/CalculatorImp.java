package Java8;

import javax.management.RuntimeErrorException;

interface Calculator{
//	void sum(int input);
	
	int subtract(int i1,int i2 ) ;
}


 
public class CalculatorImp  {

	
	
	//Tradationl method
	/*
	@Override
	public void switchOn() {
	 System.out.println("Swithc On ");
		
	}
	*/
	
	

	
	
	
	
	
	public static void main(String[] args) {
		
		//using lambada expression ()->{body}
		/*
		Calculator calculator=()->{
			
			System.out.println("Switch on");
		};
		
		*/
		
//		
//		Calculator calculator=(int input)->{
//			
//		System.out.println("Sum is" +input);
//			
//		};
		
		/*
		
		Calculator calculator=(i1,i2)-> i2-i1;
		
		System.out.println(calculator.subtract(8, 10));
		
		*/
		//if logic is added we need to keep bracket
		
		Calculator calculator=(i1,i2)->{
			
			if(i2<i1) {
				
				throw new RuntimeException("message");
			}else {
				return i2-i1;
			}
			
		};
		
		System.out.println(calculator.subtract(1, 8));
		
		
		
		
		
//		calculator.sum(345);
		
		
		
		
	}

	

}
