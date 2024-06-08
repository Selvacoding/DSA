public class Binary12 {
    private static int countPartions(int[] nums, int max){
        int countPartions=1, subarraySum =0;
        for(int num: nums){
            if(subarraySum + num <= max){
                 subarraySum += num;
            }
            else{
                countPartions++;
                subarraySum = num;
            }  
        }
        return countPartions;
    }

    public static int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;
        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countPartions(nums, mid) > k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    public static void main(String[] args) {
        // int[] arr = { 10, 20, 30, 40, 50 };
        int[] ar = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(ar, k));

    }
}
