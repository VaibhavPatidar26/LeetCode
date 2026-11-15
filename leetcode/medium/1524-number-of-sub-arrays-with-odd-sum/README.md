# Number of Sub-arrays With Odd Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `arr`, return  *the number of subarrays with an  **odd**  sum*.

Since the answer can be very large, return it modulo `109 + 7`.

 

Original
Java
 **Example 1:** 

```
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

```

 **Example 2:** 

```
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

```

 **Example 3:** 

```
Input: arr = [1,2,3,4,5,6,7]
Output: 16

```

 

 **Constraints:** 

- 1 <= arr.length <= 105
- 1 <= arr[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 47 ms (beats 5.25%)  
**Memory:** 80.7 MB (beats 98.69%)  
**Submitted:** 2026-11-15T16:19:20.703Z  

```java
class Solution {
    final int MOD = 1000000007;
    public long divisibleBy2(int[] arr,HashMap<Integer,Integer>mp){
        mp.put(0,mp.getOrDefault(0,0)+1);
        long count =0 ;
        int prefixSum = 0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            int rem = prefixSum % 2;
            if(rem<0){
                rem = rem + 2 ;
            }

            if(mp.containsKey(rem)){
                count = count+ mp.get(rem);
                mp.put(rem,mp.getOrDefault(rem,0)+1);
            }
            else{
                 mp.put(rem,mp.getOrDefault(rem,0)+1);
            }
        }
        return count;
    }

    public int numOfSubarrays(int[] arr) {
        //[1 3 5]
        //[1 4 9]
        //if i found no of subarrays divisible by 2 and substract that form total no of subarrays thats it.
        int n = arr.length;
        long total = (long)n * (n + 1) / 2;
        HashMap<Integer,Integer>mp = new HashMap<>();
        long evenSubarrays = divisibleBy2(arr, mp);

        return (int) ((total - evenSubarrays + MOD) % MOD);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)