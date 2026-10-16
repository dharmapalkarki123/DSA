package Java8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMap {

	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("eight", 8);
		map.put( "four",4);
		map.put("three", 3);
		map.put("seven", 7);
		
		List<Entry<String, Integer>> entries=new ArrayList<>(map.entrySet()); 
		Collections.sort(entries,new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		System.out.println(entries);
		
	}

}
