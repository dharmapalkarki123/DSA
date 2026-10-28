package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

	public static void main(String[] args) {
		
		
		List<Integer> number=Arrays.asList(3,7,1,5,9,8);
		
		List<String> wordList=Arrays.asList("CoreJava","Hibernate","Spring"); 
		
		
		int sum=0;
		for(int num:number) {
			sum=sum+num;
		}
		System.out.println(sum);
		
		
		Integer maxVal=number.stream().mapToInt(I->I).sum();
		
		System.out.println(maxVal);
		
		Integer maxVal2=number.stream().reduce(0, (a,b)->a+b);
		System.out.println(maxVal2);
		
		Optional<Integer> reduceSumWithRef=number.stream().reduce(Integer::sum);
		System.out.println(reduceSumWithRef.get());
		
		//using ternary operator
		Integer max=number.stream().reduce(0, (a,b)->a>b?a:b);
		System.out.println("value: "+max);
		
		//for MULTIPLICATION *note: in multipliction start with 1 
		
		Integer mulVal=number.stream().reduce(1, (a,b)->a*b);
		System.out.println(mulVal);
		
		String longestString=wordList.stream().reduce((word1, word2)->word1.length()>word2.length()?word1:word2).get();
		
		System.out.println(longestString);
		
		
		double AvgSalry=EmployeeMapDatabase.getAllEmployeeMap().stream()
				.filter(EmployeeMap->EmployeeMap.getGrade().equalsIgnoreCase("A"))
				.map(EmployeeMap->EmployeeMap.getSalary())
				.mapToDouble(i->i)
				.average().getAsDouble();
		
		System.out.println(AvgSalry);
		
		
		
		

	}

}
