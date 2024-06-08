package Recursion;
import java.util.ArrayList;
import java.util.List;
public class Recursion3 {
    private static boolean backtrack(int i, List<Integer> list, int[] nums, List<Integer> result, int currentSum){
        // Base case: if we have processed all elements
        if(i == nums.length){
            // Check if the current sum is 2
            if (currentSum == 2) {
                result.addAll(new ArrayList<>(list));
                return true; // Subsequence found
            }
            return false; // Subsequence not found
        }

        // Include nums[i] in the subset
        list.add(nums[i]);
        if (backtrack(i + 1, list, nums, result, currentSum + nums[i])) {
            return true; // Terminate if subsequence is found
        }

        // Exclude nums[i] from the subset
        list.remove(list.size() - 1);
        return backtrack(i + 1, list, nums, result, currentSum); // Continue to search
    }

    public static List<Integer> subsequenceWithSum2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, list, nums, result, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        List<Integer> result = subsequenceWithSum2(nums);
        System.out.println(result);
    }
}
