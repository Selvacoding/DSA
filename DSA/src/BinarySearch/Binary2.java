
import java.util.Arrays;

// find the first and last occurences of the target value in the array

public class Binary2 {
    private static int lowerBound(int[] nums, int target){
        int low=0, high=nums.length-1;
        int ans=nums.length;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid-1;
            }
            else 
                low =mid+1;
        }
        return ans;
    }
    private static int upperBound(int[] nums, int target){
        int low=0, high=nums.length-1;
        int ans=nums.length;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] > target){
                ans = mid;
                high = mid-1;
            }
            else 
                low =mid+1;
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        if (lb >= nums.length || nums[lb] != target)
            return new int[] { -1, -1 };
        return new int[] { lb, upperBound(nums, target) - 1 };
    }

//--------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] a = { 2, 4, 8, 8, 8, 8, 11, 13 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(a, target)));
    }
//---------------------------------------------------------------------------------------
    // method 2 normal binary search 
    private static int first(int[] nums, int target){
        int low=0, high=nums.length-1;
        int first =-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid] < target)
                low= mid+1;
            else
                high= mid-1;
        }
        return first;
    }

    private static int last(int[] nums, int target){
        int low=0, high=nums.length-1;
        int last =-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                last = mid;
                low = mid+1;
            }
            else if(nums[mid] < target)
                low= mid+1;
            else
                high= mid-1;
        }
        return last;
    }

    public static int[] searchRange2(int[] nums, int target) {
        return new int []{first(nums,target),last(nums,target)};
    }
}
