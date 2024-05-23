public class SlidingWindowPattern13 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return subArraySum(nums,goal) - subArraySum(nums, goal-1);
    }

    private static int subArraySum(int[] nums, int maxSum) {
        int l = 0, r = 0, count = 0, sum = 0;
        if (maxSum < 0)
            return 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > maxSum) {
                // here we cannot use if instead of while because 
                // If you replace the while loop with an if statement,
                // it will only adjust the left pointer l once for each iteration of the outer while (r < nums.length) loop.
                // This means that if the sum is still greater than maxSum after a single adjustment,
                //  the excess will not be properly handled, leading to incorrect subarray counts.
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
