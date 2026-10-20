package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import Recursion.subsetOfNaturalNum;

public class OptionalDemo {
	
	public static Customer getCustomerByEmailId(String email) throws Exception{
		
		List<Customer> customers=CustomerDataBase.getAllCustomer();
		return customers.stream()
				.filter(cust->cust.getEmail().equals(email))
				.findAny().orElseThrow(()->new Exception("no customer present with this email"));
		
		
		
	}

	public static void main(String[] args) throws Exception {

		Customer customer=new Customer(1, "Ram ", null, Arrays.asList("9819999999", "9820000000"));
		
		//empty
		//of
		//ofnullable
		
//		Optional<Object> emptyOptional=Optional.empty();
//		
//		System.out.println(emptyOptional);
		
//		Optional<String> emailOptional=Optional.of(customer.getEmail());
//		System.out.println(emailOptional);
		
//		Optional<String> eOptional=Optional.ofNullable(customer.getEmail());
//		System.out.println(eOptional);
		
		Optional<String> eOptional=Optional.ofNullable(customer.getEmail());
//		System.out.println(eOptional.orElse("XYS"));
//		System.out.println(eOptional.orElseThrow(()->new IllegalArgumentException("email no present at system")));
//		System.out.println(eOptional.map(String::toUpperCase).orElseGet(()->"defaultemail..."));
        
		/*
		if(eOptional.isPresent()) {
        	 System.out.println(eOptional.get());
        	 
         }
		*/
		
	
		getCustomerByEmailId("bikash@gmail.com");

	}

}
