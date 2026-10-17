package Java8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortMap {

	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("eight", 8);
		map.put( "four",4);
		map.put("three", 3);
		map.put("seven", 7);
		
		
		
		//1.Traditional Method
		
		/*
		Map<Employee, Integer> employeeMap=new TreeMap<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				
				return (int) (o1.getSalary()-o2.getSalary());
			}
		});
		*/
		
		//2.using lamda method
		Map<Employee, Integer> employeeMap=new TreeMap<>((o1,o2)->(int)(o2.getSalary()-o1.getSalary()));
		
		employeeMap.put(new Employee(1, "Ram", "IT", 45000), 1);
		employeeMap.put(new Employee(2, "Subam", "IT", 50000), 2);
		employeeMap.put(new Employee(3, "Hari", "HR", 40000), 3);
		employeeMap.put(new Employee(4, "Sita", "Finance", 55000), 4);
		employeeMap.put(new Employee(5, "Gita", "IT", 60000), 5);
		employeeMap.put(new Employee(6, "Shyam", "Marketing", 35000), 6);
		employeeMap.put(new Employee(7, "Rita", "HR", 42000), 7);
		employeeMap.put(new Employee(8, "Bikash", "Finance", 65000), 8);
		employeeMap.put(new Employee(9, "Anil", "IT", 48000), 9);
		employeeMap.put(new Employee(10, "Sunita", "Marketing", 38000), 10);
		
		//2.using stream api
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println); //ascending
		System.out.println();
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);//descending
		System.out.println();
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed())).forEach(System.out::println);
		
	 System.out.println(employeeMap);
		
		List<Entry<String, Integer>> entries=new ArrayList<>(map.entrySet()); 
		//1.Traditional method 
		/*
		Collections.sort(entries,new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		
		*/
		
		//2.Using direct lambda expression
		
		Collections.sort(entries,(o1,o2)-> o1.getKey().compareTo(o2.getKey()));

//		for(Entry<String, Integer> entry:entries) {
//			System.out.println(entry.getKey() +" "+entry.getValue());
//			
//			
//		}
		
		//using api stream
//		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		
	}

}
