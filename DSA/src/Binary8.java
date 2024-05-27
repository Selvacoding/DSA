
public class Binary8 {
    public static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] piles, int hourly) {
        int totalH = 0;
        int n = piles.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return totalH;
    }

    public static int minimumRateToEatBananas(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        //apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = { 7, 15, 6, 3 };
        int h = 8;
        int ans = minEatingSpeed(piles, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
    
    // method -2
    public static int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int n : piles) {
            sum += n;
        }
        
        int l = (int) Math.ceilDiv(sum, h);
        int r = (int) Math.ceilDiv(sum, h - piles.length + 1);

        while (l < r) {
            int m = (l + r) / 2;
            int hours = 0;
            for (int p : piles) {
                hours += (p + m - 1) / m;
                if (hours > h) {
                    break;
                }
            }
            if (hours <= h) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
