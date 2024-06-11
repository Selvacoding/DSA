package Recursion;
// similar like recursion 1 but 

// subset without duplicate 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion7 {
    private static void backtrack(int start, List<Integer> list, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            list.add(nums[i]);
            backtrack(i + 1, list, nums, ans);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        backtrack(0, list, nums, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
