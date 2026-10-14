package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {
	
	
	// traditional directly implementing 
	
	/*
	@Override
	public boolean test(Integer t) {
	
		
		
		if(t%2==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	*/

	public static void main(String[] args) {

//		Predicate<Integer> predicate=new PredicateFunctionalInterface();
//		System.out.println(predicate.test(7));
		
//		Predicate<Integer> predicate=(t)->t%2==0;
//		
//		System.out.println("Even num: " +predicate.test(7));
		
		List<Integer> list2=Arrays.asList(1,2,3,4,5,6,7,8);
		
		list2.stream().filter(t->t%2==0).forEach(t->System.out.println("Even num: " +t));
		
	}

	

}
