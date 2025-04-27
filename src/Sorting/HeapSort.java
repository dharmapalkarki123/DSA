package Sorting;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left
        int r = 2*i + 2; // right

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort hs = new HeapSort();
        hs.sort(arr);

        for (int num : arr) System.out.print(num + " ");
    }
}
