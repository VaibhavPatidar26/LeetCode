# Minimum Moves to Equal Array Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of size `n`, return  *the minimum number of moves required to make all array elements equal*.

In one move, you can increment `n - 1` elements of the array by `1`.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

```

 **Example 2:** 

```
Input: nums = [1,1,1]
Output: 0

```

 

 **Constraints:** 

- n == nums.length
- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109
- The answer is guaranteed to fit in a 32-bit integer.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 13.34%)  
**Memory:** 46.7 MB (beats 89.78%)  
**Submitted:** 2026-11-01T11:17:24.030Z  

```java
class Solution {
    public int minMoves(int[] nums) {
       int maxi = Integer.MIN_VALUE;
       int mini = Integer.MAX_VALUE;
       int sum=0;
       for(int i=0;i<nums.length;i++){
        maxi = Math.max(nums[i],maxi);
        mini = Math.min(nums[i],mini);
        sum +=nums[i];
       }

       if(maxi==mini) return 0;
      
       
       
            return sum - (mini*nums.length);
       

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)