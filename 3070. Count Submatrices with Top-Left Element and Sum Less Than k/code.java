class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // DP array to store prefix sums
        int count = 0;

        // Calculate the prefix sum for the first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j == 0 ? grid[0][j] : dp[0][j - 1] + grid[0][j]);
            if (dp[0][j] <= k) count++;
        }

        // Calculate the prefix sum for the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            if (dp[i][0] <= k) count++;
        }

        // Calculate the prefix sum for the rest of the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + grid[i][j];
                if (dp[i][j] <= k) count++;
            }
        }

        return count;
    }
}
