class Solution {
    public String[] createGrid(int m, int n) {
        char [][]grid = new char[m][n];
        
    for(int i=0;i<grid[0].length;i++){
        grid[0][i]='.';
    }
    for(int i=0;i<grid.length;i++){
        grid[i][n-1]='.';
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]!='.'){
                grid[i][j]='#';
            }
        }
    }
    String []store= new String[grid.length];
     for(int i=0;i<m;i++){
        StringBuilder temp = new StringBuilder();
        for(int j=0;j<n;j++){
            temp.append(grid[i][j]);
        }
        String ans = temp.toString();
        store[i]=ans;
    }

return store;
    }
}