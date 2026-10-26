# Keys and Rooms

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` rooms labeled from `0` to `n - 1` and all the rooms are locked except for room `0`. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of  **distinct keys**  in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array `rooms` where `rooms[i]` is the set of keys that you can obtain if you visited room `i`, return `true`  *if you can visit  **all**  the rooms, or*  `false`  *otherwise*.

 

 **Example 1:** 

```
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

```

 **Example 2:** 

```
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.

```

 

 **Constraints:** 

- n == rooms.length
- 2 <= n <= 1000
- 0 <= rooms[i].length <= 1000
- 1 <= sum(rooms[i].length) <= 3000
- 0 <= rooms[i][j] < n
- All the values of rooms[i] are unique.

## Solution

**Language:** Java  
**Runtime:** 14 ms (beats 4.66%)  
**Memory:** 45.9 MB (beats 83.52%)  
**Submitted:** 2026-10-26T22:19:44.951Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/keys-and-rooms/)