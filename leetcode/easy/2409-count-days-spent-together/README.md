# Count Days Spent Together

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Alice and Bob are traveling to Rome for separate business meetings.

You are given 4 strings `arriveAlice`, `leaveAlice`, `arriveBob`, and `leaveBob`. Alice will be in the city from the dates `arriveAlice` to `leaveAlice` (**inclusive**), while Bob will be in the city from the dates `arriveBob` to `leaveBob` (**inclusive**). Each will be a 5-character string in the format `"MM-DD"`, corresponding to the month and day of the date.

Return *the total number of days that Alice and Bob are in Rome together.* 

You can assume that all dates occur in the  **same**  calendar year, which is  **not**  a leap year. Note that the number of days per month can be represented as: `[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]`.

 

 **Example 1:** 

```
Input: arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
Output: 3
Explanation: Alice will be in Rome from August 15 to August 18. Bob will be in Rome from August 16 to August 19. They are both in Rome together on August 16th, 17th, and 18th, so the answer is 3.

```

 **Example 2:** 

```
Input: arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
Output: 0
Explanation: There is no day when Alice and Bob are in Rome together, so we return 0.

```

 

 **Constraints:** 

- All dates are provided in the format "MM-DD".
- Alice and Bob's arrival dates are earlier than or equal to their leaving dates.
- The given dates are valid dates of a non-leap year.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 3.91%)  
**Memory:** 42.4 MB (beats 91.06%)  
**Submitted:** 2026-10-24T13:12:07.353Z  

```java
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days[] = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
             StringBuilder  AliceArriveMonth = new StringBuilder();
             StringBuilder  AliceArriveDay = new StringBuilder();
             StringBuilder  BobArriveMonth = new StringBuilder();
             StringBuilder  BobArriveDay = new StringBuilder();;
             StringBuilder  AliceLeaveDay = new StringBuilder();
             StringBuilder  AliceLeaveMonth = new StringBuilder();
             StringBuilder BobLeaveDay = new StringBuilder();
             StringBuilder BobLeaveMonth = new StringBuilder();
        for(int i=0;i<arriveAlice.length();i++){
           
            if(i<2){
                AliceArriveMonth.append(arriveAlice.charAt(i));
                AliceLeaveMonth.append(leaveAlice.charAt(i));
                BobArriveMonth.append(arriveBob.charAt(i));
                BobLeaveMonth.append(leaveBob.charAt(i));

            }
            else if(i>2){
                AliceArriveDay.append(arriveAlice.charAt(i));
                AliceLeaveDay.append(leaveAlice.charAt(i));
                BobArriveDay.append(arriveBob.charAt(i));
                BobLeaveDay.append(leaveBob.charAt(i));
            }
        }
        int alcArrMon = Integer.parseInt(AliceArriveMonth.toString());
        int alcArrDay = Integer.parseInt(AliceArriveDay.toString());
        int alcLeaveDay = Integer.parseInt(AliceLeaveDay.toString());
        int alcLeaveMon = Integer.parseInt(AliceLeaveMonth.toString());
        int BobArrMon = Integer.parseInt(BobArriveMonth.toString());
        int BobLeaveMon = Integer.parseInt(BobLeaveMonth.toString());
        int BobArrDay = Integer.parseInt(BobArriveDay.toString());
        int BobLveDay = Integer.parseInt(BobLeaveDay.toString());

        int AliceArriveYearDay = alcArrDay;
        for(int i=1;i<alcArrMon;i++){
            AliceArriveYearDay += days[i];
        }
        int AliceLeaveYearDay = alcLeaveDay;
        for(int i=1;i<alcLeaveMon;i++){
            AliceLeaveYearDay+=days[i];
        }
        int BobArriveYearDay = BobArrDay;
        for(int i=1;i<BobArrMon;i++){
            BobArriveYearDay+=days[i];
        }
        int BobLeaveYearDay = BobLveDay;
        for(int i=1;i<BobLeaveMon;i++){
            BobLeaveYearDay +=days[i];
        }
        System.out.print(AliceArriveYearDay + " ");
        System.out.print(AliceLeaveYearDay+" ");
        System.out.print(BobArriveYearDay+" ");
        System.out.print(BobLeaveYearDay);

//248 251
// 249  252


int start = Math.max(AliceArriveYearDay, BobArriveYearDay);
int end = Math.min(AliceLeaveYearDay, BobLeaveYearDay);

return Math.max(0, end - start + 1);

        

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-days-spent-together/)