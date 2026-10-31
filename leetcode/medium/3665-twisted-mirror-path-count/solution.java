
class Solution {
    static final int MOD = 1_000_000_007;

    private int solve(int[][] grid, int i, int j, int dir, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n)
            return 0;

        if (i == m - 1 && j == n - 1)
            return 1;

        if (dp[i][j][dir] != -1)
            return dp[i][j][dir];

        int ans = 0;

        if (grid[i][j] == 1) {

            // Moving right -> reflected down
            if (dir == 0)
                ans = solve(grid, i + 1, j, 1, dp);

            // Moving down -> reflected right
            else
                ans = solve(grid, i, j + 1, 0, dp);

        } else {

            // Move right
            ans = (ans + solve(grid, i, j + 1, 0, dp)) % MOD;

            // Move down
            ans = (ans + solve(grid, i + 1, j, 1, dp)) % MOD;
        }

        return dp[i][j][dir] = ans;
    }

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = solve(grid, 0, 1, 0, dp);
        ans = (ans + solve(grid, 1, 0, 1, dp)) % MOD;

        return ans;
    }
}
