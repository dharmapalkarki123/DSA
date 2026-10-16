package Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxPayer {
	
	public static List<Employee> evaluateTaxPayer(String input){
		
		if(input.equalsIgnoreCase("tax")) {
			return DataBase.getEmployees().stream().filter(emp->emp.getSalary()>9000).collect(Collectors.toList());
			
		}else {
			return DataBase.getEmployees().stream().filter(emp->emp.getSalary()<=9000).collect(Collectors.toList());
			
		}

		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
//		System.out.println(evaluateTaxPayer("tax1"));
		
		List<Employee> employees=DataBase.getEmployees();
		
//		Collections.sort(employees, new MyComperator() );
		
		//2.directly implementing Comparator 
		/*
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				
				return (int) (o2.getSalary()-o1.getSalary());
			}
		} );
		
		*/
		
		//3rd way
		
		Collections.sort(employees, (o1,o2)->(int)(o1.getSalary()-o2.getSalary()));
		
		
		
//		System.out.println("this is from sorting: " +employees);
		
		
		
		//now using stream api
		   
	}

}

//this is traditional method

/*

class MyComperator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return (int) (o1.getSalary()-o2.getSalary());
	}
	
}

*/
