class Solution {
    static int target = 0;

    private void dfsSum(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        target += grid[i][j];

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nc >= 0 &&
                nr < grid.length && nc < grid[0].length &&
                grid[nr][nc] != 0 && !visited[nr][nc]) {
                dfsSum(grid, visited, nr, nc);
            }
        }
    }

    public int countIslands(int[][] grid, int k) {
        int count = 0;
        boolean[][] visited =
            new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    target = 0;
                    dfsSum(grid, visited, i, j);
                    System.out.println(target);
                    if (target!=0 && target % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}