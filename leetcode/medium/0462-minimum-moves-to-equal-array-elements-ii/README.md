# Minimum Moves to Equal Array Elements II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of size `n`, return  *the minimum number of moves required to make all array elements equal*.

In one move, you can increment or decrement an element of the array by `1`.

Test cases are designed so that the answer will fit in a  **32-bit**  integer.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

```

 **Example 2:** 

```
Input: nums = [1,10,2,9]
Output: 16

```

 

 **Constraints:** 

- n == nums.length
- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 81.89%)  
**Memory:** 46.9 MB (beats 23.98%)  
**Submitted:** 2026-11-04T11:56:15.936Z  

```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        //1 2 9 10->1+0+7+8
        int median =0;
        if(nums.length%2==0){
            median = nums[(nums.length/2) - 1];
        }else{
            median = nums[nums.length/2];
        }

        for(int i=0;i<nums.length;i++){
            count += Math.abs(nums[i]-median);
        }
        return count;

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)