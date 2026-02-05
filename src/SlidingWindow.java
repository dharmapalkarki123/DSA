
public class SlidingWindow {

    public static int maxSumSubarray(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // slide window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSubarray(arr, k)); // 9
    }
}

