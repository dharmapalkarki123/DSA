package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierFunctionalInterface  {
  
	
	//traditional way
	/*
	@Override
	public String get() {
		
		return "HELLO WORLD";
	}
	
	public static void main(String[] args) {
		Supplier<String> supplier=new SupplierFunctionalInterface();
		System.out.println(supplier.get());
		
		
		
	}
	*/
	
	
	public static void main(String[] args) {
		
		Supplier<String> supplier=()->{
			return "Hellow world";
		};
//		System.out.println(supplier.get());
		
		List<String> list3=Arrays.asList();
		
		System.out.println(list3.stream().findAny().orElseGet(supplier));
		
		
	}
	
	
	
	
	

}
