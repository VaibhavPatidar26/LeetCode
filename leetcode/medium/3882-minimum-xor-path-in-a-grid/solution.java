
import java.util.Arrays;

class Solution {
    private int solve(int[][] grid, int i, int j, int cost, int[][][] dp) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return cost;
        }

        if (dp[i][j][cost] != -1) {
            return dp[i][j][cost];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (j + 1 < grid[0].length) {
            right = solve(grid, i, j + 1,
                          cost ^ grid[i][j + 1], dp);
        }

        if (i + 1 < grid.length) {
            down = solve(grid, i + 1, j,
                         cost ^ grid[i + 1][j], dp);
        }

        return dp[i][j][cost] = Math.min(right, down);
    }

    public int minCost(int[][] grid) {
        int maxCost = 1024;

        int[][][] dp = new int[grid.length][grid[0].length][maxCost];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, grid[0][0], dp);
    }
}
