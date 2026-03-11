package Hash;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashMap {

	public static void main(String[] args) {
		HashMap<String, Integer> map =new HashMap<>();
		
		map.put("US", 180);
		map.put("India", 120);
		map.put("Nepal", 100);
		
		
		System.out.println(map);
		
		
		//Search
		
		if(map.containsKey("India")) {
			System.out.println("Key is in the map");
		}else {
			
			System.out.println("Key is not in the map");
		}
		
		
		if(map.containsKey("China")) {
			System.out.println("Key is in the map");
		}else {
			
			System.out.println("Key is not in the map");
		}
		
		System.out.println(map.get("India"));
		System.out.println(map.get("Nepal"));
		
		
		//Iterator
//		for(Map.Entry<String , Integer> e: map.entrySet()) {
//			
//			System.out.println(e.getKey());
//			System.out.println(e.getValue());
//			
//		}
		
		
		
		Set<String> keys =map.keySet();
		for(String key: keys) {
			
			System.out.println(key+" "+map.get(key));
			
		}
		

	}

}
