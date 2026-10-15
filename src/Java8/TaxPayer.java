package Java8;

import java.util.ArrayList;
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
		System.out.println(evaluateTaxPayer("tax1"));

	}

}
