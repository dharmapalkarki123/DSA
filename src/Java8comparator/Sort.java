package Java8comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(3);
		
	Collections.sort(list); //ascending order
	System.out.println(list);
	Collections.reverse(list); //descending order
	  System.out.println(list);
	  System.out.println();
	//using lambda
	list.stream().sorted().forEach(t->System.out.println(t)); //ascending order
	System.out.println();
	list.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.println(t)); //descending order
	
	
	
	}
	
	
	
}
