package Java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMapDatabase {

	public static List<EmployeeMap> getAllEmployeeMap(){
		
		return Stream.of(
				new EmployeeMap(1, "Ram", "A", 40000),
				new EmployeeMap(1, "Ram", "A", 40000),
			    new EmployeeMap(2, "Shyam", "B", 45000),
			    new EmployeeMap(3, "Hari", "C", 50000),
			    new EmployeeMap(4, "Sita", "A", 55000),
			    new EmployeeMap(5, "Gita", "B", 60000),
			    new EmployeeMap(6, "Rita", "C", 35000),
			    new EmployeeMap(7, "Krishna", "A", 48000),
			    new EmployeeMap(8, "Mohan", "B", 52000),
			    new EmployeeMap(9, "Geeta", "C", 42000),
			    new EmployeeMap(10, "Ramesh", "A", 65000))
				
				.collect(Collectors.toList());
	}
	
	
}
