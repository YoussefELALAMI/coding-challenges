# Can a String Be Rearranged Into a Palindrome?

## Intuition

A palindrome reads the same forwards and backwards (like "racecar" or "madam"). The key insight is: **what makes a string rearrangeable into a palindrome?**

Think about it simply:
- "aabb" → "abba" ✅ Every letter appears an **even** number of times
- "aab" → "aba" ✅ Only **one** letter ("b") can appear an **odd** number of times (it sits in the middle)
- "abc" → ❌ Three letters with odd counts — impossible

**Rule:** A string can form a palindrome if and only if **at most one character has an odd frequency**.

---

## Approach

### Solution 1 — HashMap (Count Frequencies)

Count how many times each character appears. Then count how many characters have an odd count. If that number is 0 or 1, return `true`.

```
"aabb" → {a:2, b:2} → 0 odd counts → ✅
"aab"  → {a:2, b:1} → 1 odd count  → ✅
"abc"  → {a:1, b:1, c:1} → 3 odd counts → ❌
```

### Solution 2 — Bit Manipulation (Clever & Fast!)

Instead of a HashMap, we use a single **integer as a bit vector** — a row of 26 on/off switches, one per letter of the alphabet.

The trick: we **XOR-toggle** each letter's bit as we read the string.
- First time we see `'a'` → flip bit 0 **ON**
- Second time we see `'a'` → flip bit 0 **OFF**

So at the end, **only bits for characters with odd counts remain ON**.

Then we check:
- `bitVector == 0` → all even counts → palindrome ✅
- `(bitVector & (bitVector - 1)) == 0` → exactly one bit is ON → palindrome ✅

> 💡 **Why does `x & (x-1)` check for a single bit?** Subtracting 1 from a number flips its lowest set bit and all bits below it. So `x & (x-1)` clears exactly the lowest set bit. If the result is 0, only one bit was set to begin with!
>
> Example: `x = 0b0100` → `x-1 = 0b0011` → `x & (x-1) = 0b0000` ✅

---

## Complexity

### HashMap Solution
- **Time complexity:** $$O(n)$$ — we loop through the string once to build the map, then loop through at most 26 values.
- **Space complexity:** $$O(1)$$ — the HashMap holds at most 26 entries (one per letter), which is a constant.

### Bit Manipulation Solution
- **Time complexity:** $$O(n)$$ — one pass through the string.
- **Space complexity:** $$O(1)$$ — we only use a single integer, regardless of input size. This is more space-efficient in practice than the HashMap.

---

## Code

```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        //return hashMapSolution(s);
        return bitManipulationSolution(s);
    }

    private boolean hashMapSolution(String s) {
        HashMap<Character, Integer> occ = new HashMap<>();
        int countOdd = 0;

        for (char c : s.toCharArray()) occ.put(c, occ.getOrDefault(c, 0) + 1);

        for (Integer v : occ.values()) {
            if (v % 2 != 0) countOdd++;
        }
        return countOdd <= 1;
    }

    private boolean bitManipulationSolution(String s) {
        // Create the Bit Vector
        int bitVector = 0;

        // Toggle the letter's position bit on each occurrence
        for (char c : s.toCharArray()) {
            int index = c - 'a';        // Map 'a'→0, 'b'→1, ..., 'z'→25
            bitVector ^= (1 << index);  // Flip that bit: ON→OFF or OFF→ON
        }

        // A valid palindrome permutation has AT MOST one bit set
        boolean zeroBitSet = bitVector == 0;                    // All even counts
        boolean oneBitSet  = (bitVector & (bitVector - 1)) == 0; // Exactly one odd count
        return zeroBitSet || oneBitSet;
    }
}
```

---