import java.util.ArrayList;
import java.util.List;

class FindClosestElement {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;

        // Initialize the binary search bounds
        int left = 0, right = arr.length - k;

        // Binary search to find the starting point of the closest k elements
        while (left < right) {
            int mid = (left + right) / 2;
            // Compare the middle of the current range with x
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Collect the k closest elements
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> closestElements = findClosestElements(arr, k, x);
        System.out.println(closestElements); // Output: [1, 2, 3, 4]
    }
}
