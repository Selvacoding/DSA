package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion4 {
    private static void findCombination(int ind, int[] candidates, int target,
        List<List<Integer>> ans, List<Integer> ds){
        
        if(ind==candidates.length){
            if(target==0)
                ans.add(new ArrayList<>(ds));
            return;
        }

        if(candidates[ind] <= target){
            ds.add(candidates[ind]);
            findCombination(ind, candidates, target-candidates[ind], ans, ds);
            ds.remove(ds.size()-1);
        }

        findCombination(ind + 1, candidates, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 }; //Output: [[2,2,3],[7]]
        int target = 7;
        
        System.out.println(combinationSum(candidates, target));
    }
}
