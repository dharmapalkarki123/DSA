package Hash;

import java.util.HashSet;

public class clasroom2 {
    
    // 🔹 Function to find UNION of two arrays
    // Union means: all UNIQUE elements from both arrays
    public static int union(int arr1[], int arr2[]) {
        
        // HashSet stores only unique values (no duplicates allowed)
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Add all elements of arr1 into set
        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);  // duplicates automatically ignored
        }
        
        // Step 2: Add all elements of arr2 into same set
        for(int j = 0; j < arr2.length; j++) {
            set.add(arr2[j]);  // only new unique elements will be added
        }
        
        // Step 3: Size of set = total unique elements (union count)
        return set.size();
    }
    
    
    // 🔹 Function to find INTERSECTION of two arrays
    // Intersection means: elements that are common in BOTH arrays
    public static int intersection(int arr1[], int arr2[]) {
        
        // HashSet to store elements of first array
        HashSet<Integer> set = new HashSet<>();
        
        int count = 0;  // to count common elements
        
        // Step 1: Add all elements of arr1 into set
//        for(int i = 0; i < arr1.length; i++) {
//            set.add(arr1[i]);
//        }
        
        System.out.println(set);
        
        // Step 2: Check each element of arr2
        for(int j = 0; j < arr2.length; j++) {
            
            // If element exists in set → common element found
            if(set.contains(arr2[j])) {
                count++;                 // increase count
                set.remove(arr2[j]);     // remove to avoid counting duplicate again
            }
        }
        
        // Step 3: return total number of common elements
        return count;
    }
    

    public static void main(String[] args) {
        
        // Example arrays
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        
        // 🔹 Union example
        // Unique elements = {7,3,9,6,2,4} → total = 6
        // System.out.println(union(arr1, arr2));
        
        // 🔹 Intersection example
        // Common elements = {3,9} → total = 2
        System.out.println(intersection(arr1, arr2));
    }
}