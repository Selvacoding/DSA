package sorting;

// Step 1 => Pick a pivot element and place it in a correct position (pivot can first, last, median or random)
// Step 2 => Pivot will be placed in between smaller on the left and larger on the right 

public class QuickSort {
    // Method to perform quicksort on the array
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Find the partition index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Method to partition the array and return the pivot index
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = low - 1; // Index of smaller element

        int j = low;
        while (j < high) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Main method to test the quicksort implementation
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        quickSort(arr, 0, n - 1);

        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
