// Approach 1 => dynamic with array memory 0(n) space
// Approach 2 => dynamic with constant 0(1) space
public class RobDynamic {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static int rob2(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int dp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }
    
    public static void main(String args[]) {
        System.out.println(rob2(new int[]{1,2,3,4,1}));
    }
}
