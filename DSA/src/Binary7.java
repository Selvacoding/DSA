
//  find out peak element which is nothing but greater than neighbour element
public class Binary7 {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 1, 2, 1 };
        System.out.println(findPeakElement(arr));
    }
}
