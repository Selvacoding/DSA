public class Binary6 {
    public static  int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        int low = 1, high = n - 2;
        // the main logic is(even index,odd index) then element in the right half
        // if (odd index, even index) then element in the left half
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            // this means the element should be in the right half
            if (((mid % 2) == 1 && nums[mid] == nums[mid - 1]) ||
                    ((mid % 2) == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            }
            // this means the element should be in the left half
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 3, 3, 4, 4 };
        System.out.println(singleNonDuplicate(a));
    }
}
