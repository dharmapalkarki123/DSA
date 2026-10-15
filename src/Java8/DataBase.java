package Java8;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	public static List<Employee> getEmployees(){
		List<Employee> employees=new ArrayList<Employee>();
		
		employees.add(new Employee(1, "Ram", "Account", 5000));
		employees.add(new Employee(2, "Shyam", "IT", 6000));
		employees.add(new Employee(3, "Hari", "HR", 7000));
		employees.add(new Employee(4, "Sita", "Finance", 8000));
		employees.add(new Employee(5, "Gita", "Marketing", 9000));
		employees.add(new Employee(6, "Ramesh", "Sales", 10000));
		employees.add(new Employee(7, "Bikash", "IT", 11000));
		employees.add(new Employee(8, "Nisha", "Account", 12000));
		employees.add(new Employee(9, "Suman", "HR", 13000));
		employees.add(new Employee(10, "Anita", "Finance", 14000));
		
		return employees;
		
		
		
		
	}

}
