class Solution {
    public boolean dfs(int [][]grid,boolean [][]visited,int i,int j)
    {
        visited[i][j]=true;
            if(i==0||j==0||i==grid.length-1||j==grid[0].length-1){
                return false;
            }

        boolean closed = true;
        int []dr = {0,0,-1,1};
        int []dc = {1,-1,0,0};
        for(int k=0;k<4;k++){
            int nr = i+dr[k];
            int nc = j+dc[k];

            //we need to check that grid[nr][nc]==0 and should not on edge
            if(nr>=0 && nc>=0 && nc<grid[0].length && nr<grid.length){
                if(grid[nr][nc]==0 && visited[nr][nc]==false){
                    //visited[nr][nc]=true;
                    if(dfs(grid,visited,nr,nc)){
                        continue;
                    }
                    else{
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
                    visited[i][j]=true;
                    if(dfs(grid,visited,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}