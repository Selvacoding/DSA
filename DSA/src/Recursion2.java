public class Recursion2 {

    private static int backtrack(int i, int[] nums, int currentSum, int k){
        // Base case: if we have processed all elements
        if(i == nums.length){
            // Check if the current sum is k
            if (currentSum == k) {
                return 1; // Found a valid subsequence
            }
            return 0; // Not a valid subsequence
        }

        // Count subsequences including nums[i]
        int countIncluding = backtrack(i + 1, nums, currentSum + nums[i], k);

        // Count subsequences excluding nums[i]
        int countExcluding = backtrack(i + 1, nums, currentSum, k);

        // Return total count of valid subsequences
        return countIncluding + countExcluding;
    }

    public static int countSubsequencesWithSumK(int[] nums, int k) {
        return backtrack(0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        int k = 2;
        int count = countSubsequencesWithSumK(nums, k);
        System.out.println(count); // Expected output: 3
    }
}
