public class Binary10 {
    private static int sumByD(int[] nums, int div){
        int n= nums.length;
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceilDiv(nums[i],div);
        }
        return sum;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n > threshold)
            return -1;
        int maxi = 0;
        for (int num : nums)
            maxi = Math.max(maxi, num);

        int low = 1, high = maxi;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sumByD(nums, mid) <= threshold)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums ={1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
