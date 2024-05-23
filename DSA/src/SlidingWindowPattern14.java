
//  this is a similar problem to binary subarrays
public class SlidingWindowPattern14 {
    public static int numberOfSubarrays(int[] nums, int k) {
        return SubArray(nums, k) - SubArray(nums, k-1);
    }

    private static int SubArray(int[] nums, int k) {
        int l = 0, r = 0, count = 0, sum = 0;

        if (k < 0)
            return 0;
        while (r < nums.length) {
            sum += nums[r] % 2;
            while (sum > k) {
                sum -= nums[l] % 2;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
    
    public static int numberOfSubarrays2(int[] nums, int k) {

        int r = 0;
        int l = 0;
        int oddCount = 0;
        int result = 0;
        int tempResult = 0;

        
        while (r < nums.length) 
        {
            if (nums[r] % 2 == 1)
             {
                oddCount++;
                tempResult = 0;
            }
            while (oddCount == k) 
            {
                tempResult++;
                if (nums[l] % 2 == 1)
                {
                    oddCount--;
                }
                l++;
            }
            result += tempResult;
            r++;
        }
        return result;
        
    }
}
