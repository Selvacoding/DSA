//  we have to find longest consecutive ones
public class SlidingWindowPattern7 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0, maxCount = 0;
        for (int num : nums) {
            if (num == 0) {
                if (currCount > maxCount)
                    maxCount = currCount;
                currCount = 0;
            } else {
                currCount++;
            }
        }
        return currCount > maxCount ? currCount : maxCount;
    }
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int l =0, r=0, max_len =0;
        int count_zero =0;
        while(r<nums.length){
            if(nums[r]==0)
                count_zero++;
            if(count_zero > 0){
                if(nums[l]==0)
                    count_zero--;
                l++;
            }
            if(count_zero<1)
                max_len = Math.max(max_len, r-l+1);
            r++;
        }
        return max_len;
    }
    public static void main(String[] args) {
        
    }
}
