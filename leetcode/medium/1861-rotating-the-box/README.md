# Rotating the Box

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` matrix of characters `boxGrid` representing a side-view of a box. Each cell of the box is one of the following:

- A stone '#'
- A stationary obstacle '*'
- Empty '.'

The box is rotated  **90 degrees clockwise**, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity  **does not**  affect the obstacles' positions, and the inertia from the box's rotation  **does not** affect the stones' horizontal positions.

It is  **guaranteed**  that each stone in `boxGrid` rests on an obstacle, another stone, or the bottom of the box.

Return  *an* `n x m` *matrix representing the box after the rotation described above*.

 

 **Example 1:** 

```
Input: boxGrid = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]

```

 **Example 2:** 

```
Input: boxGrid = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         [" *","* "],
         [".","."]]

```

 **Example 3:** 

```
Input: boxGrid = [["#","#"," *",".","* ","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]

```

 

 **Constraints:** 

- m == boxGrid.length
- n == boxGrid[i].length
- 1 <= m, n <= 500
- boxGrid[i][j] is either '#', '*', or '.'.

## Solution

**Language:** Java  
**Runtime:** 34 ms (beats 5.89%)  
**Memory:** 130.3 MB (beats 12.00%)  
**Submitted:** 2026-10-23T16:55:33.480Z  

```java
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        for (int i = 0; i < boxGrid.length; i++) {
            int p1 = boxGrid[0].length - 1;

            for (int j = boxGrid[0].length - 1; j >= 0; j--) {

                if (boxGrid[i][j] == '#') {
                    char temp = boxGrid[i][p1];
                    boxGrid[i][p1] = boxGrid[i][j];
                    boxGrid[i][j] = temp;
                    p1--;
                }

                if (boxGrid[i][j] == '*') {
                    p1 = j - 1;
                }
            }
        }

        List<List<Character>> ans = new ArrayList<>();

        for (int i = 0; i < boxGrid[0].length; i++) {
            List<Character> current = new ArrayList<>();

            for (int j = boxGrid.length - 1; j >= 0; j--) {
                current.add(boxGrid[j][i]);
            }

            ans.add(current);
        }

        char[][] result = new char[ans.size()][ans.get(0).size()];

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                result[i][j] = ans.get(i).get(j);
            }
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotating-the-box/)