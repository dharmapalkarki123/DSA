package Hash;

import java.util.HashMap;

public class Tickets {
	
	// This function finds the starting point of the journey
	public static String getStart(HashMap<String, String> tick) {
		
		// Reverse map: destination -> source
		HashMap<String, String> revMap = new HashMap<String, String>();
		
		// Fill reverse map
		// Example: Chennai -> Bengaluru becomes Bengaluru -> Chennai
		for (String key : tick.keySet()) {
			revMap.put(tick.get(key), key);
		}
		
		// Find the starting city
		// Starting city is the one that is NOT present as a destination
		for (String key : tick.keySet()) {
			
			// If current city is not in reverse map,
			// it means no one is coming to this city → starting point
			if (!revMap.containsKey(key)) {
				return key;
			}
		}
		
		// If no starting point found (edge case)
		return null;
	}

	public static void main(String[] args) {
	
		// Creating a HashMap to store tickets
		// Key = Source, Value = Destination
		HashMap<String, String> tickets = new HashMap<String, String>();
		
		// Adding ticket data
		tickets.put("Chennai", "Bengaluru");
		tickets.put("Mumbai", "Delhi");
		tickets.put("Goa", "Chennai");
		tickets.put("Delhi", "Goa");
		
		// Find starting city
		String start = getStart(tickets);
		
		// Traverse and print the full route
		// Continue until no further destination exists
		while (tickets.containsKey(start)) {
			
			// Print current city
			System.out.print(start + " -> ");
			
			// Move to next city
			start = tickets.get(start);
		}
		
		// Print the last destination
		System.out.println(start);
	}
}