//  we have to find longest consecutive ones and we can flip k zeros to get maximum length of ones

public class SlidingWindowPattern8 {
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, max_count = 0, zero_count = 0;

        while (r < nums.length) {
            if (nums[r] == 0)
                zero_count++;
            if (zero_count > k) {
                if (nums[l] == 0)
                    zero_count--;
                l++;
            }
            if (zero_count <= k)
                max_count = Math.max(max_count, r - l + 1);
            r++;
        }
        return max_count;
    }
    public static void main(String[] args) {
        
    }
}

