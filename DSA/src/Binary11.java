public class Binary11 {
    private static int findDays(int[] nums, int capacity){
        int days =1;
        int load =0;
        for(int num:nums){
            if(load + num > capacity){
                days++;
                load = num;
            }
            else
                load += num;
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numberOfDays = findDays(weights, mid);

            if (numberOfDays <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
