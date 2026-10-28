# Minimum XOR Path in a Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a 2D integer array `grid` of size `m * n`.

You start at the  **top-left**  cell `(0, 0)` and want to reach the  **bottom-right**  cell `(m - 1, n - 1)`.

At each step, you  **may**  move either  **right or down**.

The  **cost**  of a path is defined as the  **bitwise XOR**  of all the values in the cells along that path,  **including**  the start and end cells.

Return the  **minimum**  possible XOR value among all valid paths from `(0, 0)` to `(m - 1, n - 1)`.

 

 **Example 1:** 

 **Input:**  grid = [[1,2],[3,4]]

 **Output:**  6

 **Explanation:** 

There are two valid paths:

- (0, 0) → (0, 1) → (1, 1) with XOR: 1 XOR 2 XOR 4 = 7
- (0, 0) → (1, 0) → (1, 1) with XOR: 1 XOR 3 XOR 4 = 6

The minimum XOR value among all valid paths is 6.

 **Example 2:** 

 **Input:**  grid = [[6,7],[5,8]]

 **Output:**  9

 **Explanation:** 

There are two valid paths:

- (0, 0) → (0, 1) → (1, 1) with XOR: 6 XOR 7 XOR 8 = 9
- (0, 0) → (1, 0) → (1, 1) with XOR: 6 XOR 5 XOR 8 = 11

The minimum XOR value among all valid paths is 9.

 **Example 3:** 

 **Input:**  grid = [[2,7,5]]

 **Output:**  0

 **Explanation:** 

There is only one valid path:

- (0, 0) → (0, 1) → (0, 2) with XOR: 2 XOR 7 XOR 5 = 0

The XOR value of this path is 0, which is the minimum possible.

 

 **Constraints:** 

- 1 <= m == grid.length <= 1000
- 1 <= n == grid[i].length <= 1000
- m * n <= 1000
- 0 <= grid[i][j] <= 1023​

## Solution

**Language:** Java  
**Runtime:** 263 ms (beats 12.07%)  
**Memory:** 74.8 MB (beats 36.21%)  
**Submitted:** 2026-10-28T10:09:30.908Z  

```java

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

```

---

[View on LeetCode](https://leetcode.com/problems/minimum-xor-path-in-a-grid/)