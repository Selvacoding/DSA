import java.util.*;

class MinimumPathSum {
    
    // approach 1
    public static int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (i > 0 && j > 0)
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                else if (i > 0)
                    grid[i][0] += grid[i - 1][0];
                else if (j > 0)
                    grid[0][j] += grid[0][j - 1];

        return grid[m - 1][n - 1];
    }

    // approach 2
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(grid, m-1, n-1, memo);
    }

    public static int helper(int[][] grid, int m, int n, int[][] memo) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return grid[0][0];
        if (memo[m][n] != -1)
            return memo[m][n];
        return memo[m][n] = grid[m][n] + Math.min(helper(grid, m, n - 1, memo), helper(grid, m - 1, n, memo));
        // return memo[m][n];
    }

    // approach 3
    public static int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the first column
        for (int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the rest of the table
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
    
  public static void main(String[] args) {

      int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum2(grid));
  }
}
