# Separate Black and White Balls

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` balls on a table, each ball has a color black or white.

You are given a  **0-indexed**  binary string `s` of length `n`, where `1` and `0` represent black and white balls, respectively.

In each step, you can choose two adjacent balls and swap them.

Return  *the  **minimum**  number of steps to group all the black balls to the right and all the white balls to the left*.

 

Original
C++
 **Example 1:** 

```
Input: s = "101"
Output: 1
Explanation: We can group all the black balls to the right in the following way:
- Swap s[0] and s[1], s = "011".
Initially, 1s are not grouped together, requiring at least 1 step to group them to the right.
```

 **Example 2:** 

```
Input: s = "100"
Output: 2
Explanation: We can group all the black balls to the right in the following way:
- Swap s[0] and s[1], s = "010".
- Swap s[1] and s[2], s = "001".
It can be proven that the minimum number of steps needed is 2.

```

 **Example 3:** 

```
Input: s = "0111"
Output: 0
Explanation: All the black balls are already grouped to the right.

```

 

 **Constraints:** 

- 1 <= n == s.length <= 105
- s[i] is either '0' or '1'.

## Solution

**Language:** C++  
**Runtime:** 10 ms (beats 26.08%)  
**Memory:** 17.3 MB (beats 11.42%)  
**Submitted:** 2026-11-11T10:56:26.110Z  

```cpp
class Solution {
public:
    long long minimumSteps(string s) {
        int p1=s.size()-1;
        int p2 = s.size()-1;
        long long counter =0;
        long long ans=0;
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]=='0') counter++;
            else{
                ans = ans+counter;
            }
        }
        return ans;
    }
};
```

---

[View on LeetCode](https://leetcode.com/problems/separate-black-and-white-balls/)