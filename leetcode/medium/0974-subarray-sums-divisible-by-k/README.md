# Subarray Sums Divisible by K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the number of non-empty  **subarrays**  that have a sum divisible by* `k`.

A  **subarray**  is a  **contiguous**  part of an array.

 

Original
Java
 **Example 1:** 

```
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

```

 **Example 2:** 

```
Input: nums = [5], k = 9
Output: 0

```

 

 **Constraints:** 

- 1 <= nums.length <= 3 * 104
- -104 <= nums[i] <= 104
- 2 <= k <= 104

## Solution

**Language:** Java  
**Runtime:** 26 ms (beats 31.04%)  
**Memory:** 51 MB (beats 65.09%)  
**Submitted:** 2026-11-15T16:24:31.623Z  

```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            int rem = prefixSum%k;
            if(rem<0){
                rem = rem+k;
            }
            if(mp.containsKey(rem)){
                count += mp.get(rem);
                mp.put(rem,mp.getOrDefault(rem,0)+1);
            }else{
                 mp.put(rem,mp.getOrDefault(rem,0)+1);
            }
        }
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarray-sums-divisible-by-k/)