// Rotated sorted array with duplicate elements

public class Binary4 {
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target <= nums[high] && nums[mid] <= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 3, 3, 3, 3 };
        int target = 1;
        System.out.println(search(arr, target));
    }
}
