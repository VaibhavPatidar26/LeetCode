# Number of Closed Islands

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a 2D `grid` consists of `0s` (land) and `1s` (water).  An  *island*  is a maximal 4-directionally connected group of `0s` and a  *closed island*  is an island  **totally**  (all left, top, right, bottom) surrounded by `1s.`

Return the number of  *closed islands*.

 

 **Example 1:** 

```
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
```

 **Example 2:** 

```
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

```

 **Example 3:** 

```
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

```

 

 **Constraints:** 

- 1 <= grid.length, grid[0].length <= 100
- 0 <= grid[i][j] <=1

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 38.41%)  
**Memory:** 45.9 MB (beats 93.65%)  
**Submitted:** 2026-10-25T18:26:08.419Z  

```java
class Solution {
    public boolean dfs(int [][]grid,boolean [][]visited,int i,int j)
    {
                boolean closed = true;
        visited[i][j]=true;
            if(i==0||j==0||i==grid.length-1||j==grid[0].length-1){
                closed= false;
            }

        // boolean closed = true;
        int []dr = {0,0,-1,1};
        int []dc = {1,-1,0,0};
        for(int k=0;k<4;k++){
            int nr = i+dr[k];
            int nc = j+dc[k];

            //we need to check that grid[nr][nc]==0 and should not on edge
            if(nr>=0 && nc>=0 && nc<grid[0].length && nr<grid.length){
                if(grid[nr][nc]==0 && visited[nr][nc]==false){
                    // visited[nr][nc]=true;
                    if(dfs(grid,visited,nr,nc)){
                        continue;
                    }
                    else{
                        // visited[nr][nc]=true;
                        closed = false;
                    }
                }
                
                
            }
        }
        return closed;
    }
    public int closedIsland(int[][] grid) {
        int count=0;
        boolean [][]visited =  new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && visited[i][j]==false){
                    // visited[i][j]=true;
                    if(dfs(grid,visited,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-closed-islands/)