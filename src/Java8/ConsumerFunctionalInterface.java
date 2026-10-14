package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

	
	//traditional method where we should implements Consumer method ie Consumer<T>
	/*
	public static void main(String[] args) {
		
		ConsumerFunctionalInterface consumerFunctionalInterface=new ConsumerFunctionalInterface();
		
		consumerFunctionalInterface.accept(10);
		
	}

	@Override
	public void accept(Integer t) {
		System.out.println("this is printed number :" +t);
		
	}
	*/
	
	//using lamda function
	
	public static void main(String[] args) {
//		Consumer<Integer> consumer=(t)->{
//			
//			
//			System.out.println("Printing number :" +t);
//			
//		};
//		
//		consumer.accept(10);
		
		List<Integer> list1=Arrays.asList(1,2,3,4,5);
		
//		list1.forEach(consumer);
		
		list1.stream().forEach((t)->{
			
			System.out.println("Printing number :" +t);
			
		});
		
		
		
	}
	
	
	

}
