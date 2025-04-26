package BitWiseOperation;

public class SingleNumberFinder {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 5, 3, 4};

        int uniqueNumber = findSingleNumber(nums);

        System.out.println("The number that appears only once is: " + uniqueNumber);
    }

    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR operation
        }
        return result;
    }
}
