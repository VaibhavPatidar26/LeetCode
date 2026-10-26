class Solution {
    private void traverse(List<List<Integer>>grid,int i,boolean []visited){
        visited[i]=true;
        for(int k=0;k<grid.get(i).size();k++){//i=0 i=1
            int roomKey = grid.get(i).get(k);   
                if (!visited[roomKey]) {
                traverse(grid, roomKey, visited);
            }
            
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []visited = new boolean[rooms.size()];
        visited[0]=true;
         
             traverse(rooms,0,visited);
            

        System.out.println(visited.length);
         for(int i=0;i<visited.length;i++){
                System.out.println(visited[i]);
            if(visited[i]==false){
                return false;
            }
         }
         return true;
    }
}
//0->[1,3]        
//1->[3,0,1]
//2->[2]
//3->[0]