package Java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachDemo {

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		
		list.add("Ram");
		list.add("Sam");
		list.add("Jam");
		list.add("Bam");
		list.add("Kam");
		
		
		
		
		
		//for each actual form
		for(String ls:list) {
			//System.out.println(ls);
			//using filter
			if(ls.startsWith("R")) {
				System.out.println(ls);
			}
		}
		
		System.out.println();
		//lamda Expression
//		list.stream().forEach(t->System.out.println(t));
		list.stream().filter((t)->t.startsWith("K")).forEach(t->System.out.println(t));
		
		System.out.println();
		
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		
//		map.forEach((k,v)->System.out.println(k+"="+v)); //direct use of forEach, can allow to use pipe line 
		System.out.println();
//		map.entrySet().stream().forEach(obj->System.out.println(obj));
		map.entrySet().stream().filter((k)->k.getKey()%2==0).forEach(obj->System.out.println(obj));
		System.out.println("/////");
		
		Consumer<String> consumer=(t)->System.out.println(t);
		
		for(String t:list) {
			consumer.accept(t);
		}
		
		
		

	}

}
