package Sorting;

public class MergeSort {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l; i <= r; i++) arr[i] = temp[i - l];
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 6, 3, 7, 1, 4};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) System.out.print(num + " ");
    }
}
