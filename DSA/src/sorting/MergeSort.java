package sorting;

public class MergeSort {
    // Main function that sorts the array using mergeSort
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int[] leftHalf = new int[array.length / 2];
        int[] rightHalf = new int[array.length - leftHalf.length];
        
        for(int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = array[leftHalf.length + i];
        }

        // Recursively sort each half
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge the sorted halves back into the original array
        merge(array, leftHalf, rightHalf);
    }

    // Helper function that merges two sorted arrays
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Compare each element and merge them in sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from right array, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Main function to test the MergeSort implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Unsorted array: ");
        printArray(array);

        mergeSort(array);

        System.out.println("Sorted array: ");
        printArray(array);
    }

    // Helper function to print the array
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
