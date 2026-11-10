class Solution {

    public int solve(int n, int[] costs, int index, int[] dp) {

        if(index == n) return 0;

        if(dp[index] != -1) return dp[index];

        int singleStep = costs[index] + 1
                         + solve(n, costs, index + 1, dp);

        int doubleStep = Integer.MAX_VALUE;
        int tripleStep = Integer.MAX_VALUE;

        if(index + 2 <= n) {
            doubleStep = costs[index + 1] + 4
                         + solve(n, costs, index + 2, dp);
        }

        if(index + 3 <= n) {
            tripleStep = costs[index + 2] + 9
                         + solve(n, costs, index + 3, dp);
        }

        return dp[index] = Math.min(singleStep,
                          Math.min(doubleStep, tripleStep));
    }

    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, costs, 0, dp);
    }
}