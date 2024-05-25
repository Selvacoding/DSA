
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
        int[] piles = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananas(piles, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}
