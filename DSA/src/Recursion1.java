import java.util.ArrayList;
import java.util.List;

public class Recursion1 {
    private static void backtrack(int i, List<Integer> list, int[] nums, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // Include nums[i] in the subset
        list.add(nums[i]);
        backtrack(i + 1, list, nums, ans);

        // Exclude nums[i] from the subset
        list.remove(list.size() - 1);
        backtrack(i + 1, list, nums, ans);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, list, nums, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 }; // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets(nums));
    }
}
