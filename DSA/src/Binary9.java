// Minimum Number of Days to Make m Bouquets
public class Binary9 {
    private static boolean posibble(int[] arr, int day, int m, int k){
        int count=0, countBouquets=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= day){
                count++;
            }else{
                countBouquets += count/k;
                count =0;
            }
        }
        countBouquets += count/k;
        return countBouquets >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n)
            return -1;

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int low = mini, high = maxi;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (posibble(bloomDay, mid, m, k) == true)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3, k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}
