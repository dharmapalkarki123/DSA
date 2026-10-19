package Java8;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
	
	public static void main(String[] args) {
		List<Customer> emp=CustomerDataBase.getAllCustomer();
		
		
		//List<Customer> converts into List<String> -> Called as Data Transformation;
		//mapping: customer->customer.getEmail
		//customer->customer.getEmail() ->one to one mapping
		
		List<String> emailList=emp.stream().map(customer->customer.getEmail()).collect(Collectors.toList());
		System.out.println(emailList);
		
		
		
		///customer->customer.getPhoneNo()->one to many mapping it return list of stream inside list  
		List<List<String>> phoneList=emp.stream().map(customer->customer.getPhoneNo()).collect(Collectors.toList());
		
		System.out.println(phoneList);

		
List<String> phon=emp.stream().flatMap(customer->customer.getPhoneNo().stream()).collect(Collectors.toList());
		
		System.out.println(phon);
		
		
	}
	
	

}
