public class Binary {
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    
    public static int searchInsert2(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int searchInsert3(int[] nums, int target) {
        int low=0, high=nums.length-1;
        int ans=nums.length;
        // low bound concept
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]>=target){
                ans =mid;
                high =mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 9, 14 };
        int target = 10;

        System.out.println(searchInsert3(arr,target));
    }
}
