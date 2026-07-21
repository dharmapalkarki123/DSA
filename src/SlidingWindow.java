public class SlidingWindow {

    /*
     * Function: maxSumSubarray()
     *
     * Purpose:
     * Finds the maximum sum of any contiguous subarray (continuous elements)
     * of size k using the Sliding Window technique.
     *
     * Example:
     * Array = {2,1,5,1,3,2}
     * k = 3
     *
     * Possible subarrays of size 3:
     *
     * {2,1,5} = 8
     * {1,5,1} = 7
     * {5,1,3} = 9   <-- Maximum
     * {1,3,2} = 6
     *
     * Output = 9
     */

    public static int maxSumSubarray(int[] arr, int k) {

        // Stores the sum of the current window (current group of k elements)
        int windowSum = 0;

        // Stores the maximum sum found so far.
        // Initially set to the smallest possible integer so that
        // any valid sum will replace it.
        int maxSum = Integer.MIN_VALUE;

        // ====================================================
        // STEP 1 : Calculate the sum of the FIRST window
        // ====================================================

        /*
         * If
         * arr = {2,1,5,1,3,2}
         * k = 3
         *
         * First window contains:
         * {2,1,5}
         *
         * Loop executes:
         *
         * i=0 -> windowSum = 0+2 = 2
         * i=1 -> windowSum = 2+1 = 3
         * i=2 -> windowSum = 3+5 = 8
         *
         * So first window sum = 8
         */

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // At this point only one window exists,
        // therefore it is also the maximum.
        maxSum = windowSum;

        // ====================================================
        // STEP 2 : Slide the window one position at a time
        // ====================================================

        /*
         * Instead of calculating every window from scratch,
         * we do:
         *
         * New Window Sum
         * =
         * Previous Window Sum
         * + New Element Entering Window
         * - Old Element Leaving Window
         *
         * Formula:
         *
         * windowSum = windowSum + arr[i] - arr[i-k]
         *
         * This makes the algorithm much faster.
         */

        for (int i = k; i < arr.length; i++) {

            /*
             * -------------------------------
             * First Iteration
             * -------------------------------
             *
             * i = 3
             *
             * Previous Window:
             * {2,1,5}
             * Sum = 8
             *
             * New Window:
             * {1,5,1}
             *
             * Add arr[3] = 1
             * Remove arr[0] = 2
             *
             * windowSum = 8 + 1 - 2
             *            = 7
             */

            /*
             * -------------------------------
             * Second Iteration
             * -------------------------------
             *
             * i = 4
             *
             * Previous Window:
             * {1,5,1}
             * Sum = 7
             *
             * New Window:
             * {5,1,3}
             *
             * Add arr[4] = 3
             * Remove arr[1] = 1
             *
             * windowSum = 7 + 3 - 1
             *            = 9
             */

            /*
             * -------------------------------
             * Third Iteration
             * -------------------------------
             *
             * i = 5
             *
             * Previous Window:
             * {5,1,3}
             * Sum = 9
             *
             * New Window:
             * {1,3,2}
             *
             * Add arr[5] = 2
             * Remove arr[2] = 5
             *
             * windowSum = 9 + 2 - 5
             *            = 6
             */

            windowSum = windowSum + arr[i] - arr[i - k];

            /*
             * Compare current window sum with the maximum sum.
             *
             * If current window is larger,
             * update maxSum.
             *
             * Example:
             *
             * maxSum = 8
             * windowSum = 7
             * -> maxSum remains 8
             *
             * maxSum = 8
             * windowSum = 9
             * -> maxSum becomes 9
             */

            maxSum = Math.max(maxSum, windowSum);
        }

        // Return the largest window sum found.
        return maxSum;
    }

    public static void main(String[] args) {

        // Input array
        int[] arr = {2, 1, 5, 1, 3, 2};

        // Window size
        int k = 3;

        // Call the function and print the result
        System.out.println(maxSumSubarray(arr, k));

        // Output:
        // 9
    }
}