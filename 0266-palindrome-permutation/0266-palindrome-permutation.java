class Solution {
    public boolean canPermutePalindrome(String s) {
        /* Using bit Vector */
        int bitVector = 0;
        for(char c : s.toCharArray()){
            int val = Character.getNumericValue(c);
            int mask = 1 << val;
            if ((bitVector & mask)==0) bitVector |= mask;
            else bitVector &= ~mask;
        }
        boolean oneOddNum = (bitVector & (bitVector - 1)) == 0;
        return bitVector == 0 || oneOddNum;
    }
}
/**
 * Using Hash Table :
    int countOdd = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        if(freqMap.get(c) % 2 == 1) countOdd++;
        else countOdd--;
    }
    return countOdd <= 1;
 */