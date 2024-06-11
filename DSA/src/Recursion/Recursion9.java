package Recursion;

import java.util.ArrayList;
import java.util.List;

// Permutations

public class Recursion9 {
    private static void backtrack(int[] nums, boolean[] freq, List<List<Integer>> ans, List<Integer> ds){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
        }

        for(int i=0; i<nums.length; ++i){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                backtrack(nums, freq, ans, ds);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        backtrack(nums, freq, ans, ds);
        return ans;
    }

    // Aproach 2
    //  without auxillary data structure
    private static void recurPermute(int index, int[] nums, List < List < Integer >> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static List<List<Integer>> permute2(int[] nums) {
        List < List < Integer >> ans = new ArrayList < > ();
        recurPermute(0, nums, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(permute2(arr));
    }
}
