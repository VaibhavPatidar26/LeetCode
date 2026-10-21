# Design HashSet

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Design a HashSet without using any built-in hash table libraries.

Implement `MyHashSet` class:

- void add(key) Inserts the value key into the HashSet.
- bool contains(key) Returns whether the value key exists in the HashSet or not.
- void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

 

 **Example 1:** 

```
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
```

 

 **Constraints:** 

- 0 <= key <= 106
- At most 104 calls will be made to add, remove, and contains.

## Solution

**Language:** Java  
**Runtime:** 776 ms (beats 5.13%)  
**Memory:** 59.1 MB (beats 5.26%)  
**Submitted:** 2026-10-21T11:57:12.004Z  

```java
class MyHashSet {
    List<Integer>mp= new ArrayList<>();

    public MyHashSet() {
        this.mp = new ArrayList<>();
    }
    
    public void add(int key) {
          boolean present = false;
        for(int i=0;i<mp.size();i++){
          
            if(mp.get(i)==key){
                present = true;
                break;
            }
        }
        if(present){
            return;
        }else{
            mp.add(key);
        }
    }
    
    public void remove(int key) {
        mp.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        for(int i=0;i<mp.size();i++){
            if(mp.get(i).equals(key)) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```

---

[View on LeetCode](https://leetcode.com/problems/design-hashset/)