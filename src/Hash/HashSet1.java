package Hash;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet1 {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		
		
		set.add(1);
		set.add(2);
		set.add(3);
		
		//set.remove(1);
		
		System.out.println("Size of set " +set.size());
		
		System.out.println(set);
		
		if(set.contains(2)) {
			
			System.out.println("Set contain 2");
			
			
		}
		
		
		if(!set.contains(6)) {
			
			System.out.println("Set does not contain 3");
			
		}
		
		Iterator it =set.iterator();
		
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
			
		}
		

	}

}
