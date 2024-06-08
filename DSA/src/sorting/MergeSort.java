package sorting;

import java.util.ArrayList;

public class MergeSort {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    private static void merge2(int arr[], int l, int m, int r) {
        //  this method id for merging two sorted arrays without auxilary data structure
        int start1 = l;
        int start2 = m + 1;

        // If the direct merge is already sorted
        if (arr[m] <= arr[start2]) {
            return;
        }

        // Two pointers to maintain start of both arrays to merge
        while (start1 <= m && start2 <= r) {

            // If element 1 is in right place
            if (arr[start1] <= arr[start2]) {
                start1++;
            } else {
                int value = arr[start2];
                int index = start2;

                // Shift all the elements between element 1 and element 2, right by 1
                while (index != start1) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start1] = value;

                // Update all the pointers
                start1++;
                m++;
                start2++;
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }

    public static void main(String args[]) {
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        int n = arr.length;
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
