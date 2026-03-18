package Hash;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1); // Important: handles sum = k case
        
        int count = 0;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            
            // Check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Store current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        
        System.out.println("Number of subarrays: " + subarraySum(nums, k));
    }
}
