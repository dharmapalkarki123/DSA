package Java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
		
		return Stream.of(list1,list2)
				.flatMap(List::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	public static void main(String[] args) {

		
		
		
		BiFunction biFunction=new BiFunctionExample();
		
		List<Integer> list1=Stream.of(1,3,4,6,7,9,14).collect(Collectors.toList());
		List<Integer> list2=Stream.of(11,3,43,6,7,19).collect(Collectors.toList());
		
		System.out.println("Traditional Method: "+ biFunction.apply(list1, list2));
		
		
		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2=new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
			
			@Override
			public List<Integer> apply(List<Integer> l1, List<Integer> l2) {
			
				return Stream.of(l1,l2)
						.flatMap(List::stream)
						.distinct()
						.sorted(Comparator.reverseOrder())
						.collect(Collectors.toList());
			}
		};
		
		System.out.println("Annoymous Implementation: " +biFunction2.apply(list1, list2));
		
		BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction3=(l1,l2)->{
			return Stream.of(l1,l2)
					.flatMap(List::stream)
					.distinct()
					.sorted()
					.collect(Collectors.toList());
		};
		
		
		System.out.println("Using Lambda Function: " +biFunction3.apply(list1, list2));
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("Basanta", 6000);
		map.put("Ram", 8000);
		map.put("Laxman", 9000);

		
		BiFunction<String, Integer, Integer> increaseSalary=new BiFunction<String, Integer, Integer>() {
			
			@Override
			public Integer apply(String t, Integer u) {
				
				return u+1000;
			}
		};

		map.replaceAll(increaseSalary);
		System.out.println("Using map: "+map);
		
		
		
		
	}
	
	
	

	
	
	

}
