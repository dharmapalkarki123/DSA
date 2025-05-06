package Array;

public class MaxInArray {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 9, 2};
        System.out.println(findMax(arr)); // 9
    }
}
