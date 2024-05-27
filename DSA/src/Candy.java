public class Candy {
    public static int candy(int[] ratings) {
        if (ratings.length == 1) return 1;

        int n = ratings.length;
        int[] candies = new int[n];

        for (int i = 0; i < n; i++)
            candies[i] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies)
            totalCandies += candy;

        return totalCandies;
    }
    public static void main(String[] args) {
        int[] ratings = { 1, 3, 2, 2, 1 };
        System.out.println(candy(ratings));
    }
}
