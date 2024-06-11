package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Recursion5 {

    private static void findCombination(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        // If target becomes 0, we found a combination
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Iterate over the candidates starting from the current index
        for (int i = ind; i < candidates.length; i++) {
            // If the candidate exceeds the target, we can break early
            if (candidates[i] > target) break;
            
            // Include the candidate and recurse with the updated target
            ds.add(candidates[i]);
            findCombination(i, candidates, target - candidates[i], ans, ds);
            ds.remove(ds.size() - 1); // Backtrack to try the next candidate
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates array to improve efficiency
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result); // [[2, 2, 3], [7]]
    }

}
