// count subbarray with k different characters

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowPattern15 {

    public static  int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums, k) - subArray(nums, k-1);
    }

    private static int subArray(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
    

  public static int subarraysWithKDistinct2(int[] nums, int k) {
    return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
  }

  private static int subarraysWithAtMostKDistinct(int[] nums, int k) {
      int res = 0;
      int[] count = new int[nums.length + 1];

      for (int l = 0, r = 0; r < nums.length; ++r) {
          if (++count[nums[r]] == 1)
              --k;
          while (k == -1)
              if (--count[nums[l++]] == 0)
                  ++k;
          res += r - l + 1; // nums[l..r], nums[l + 1..r], ..., nums[r]
      }

      return res;
  }
  
}