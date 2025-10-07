class Solution {
    public boolean canPermutePalindrome(String s) {
        /* Using bit Vector */
        int bitVector = 0;
        for(char c : s.toCharArray()){
            int val = getCharNumber(c);
            if(val < 0) continue;
            int mask = 1 << val;
            if ((bitVector & mask)==0) bitVector |= mask;
            else bitVector &= ~mask;
        }
        boolean oneOddNum = (bitVector & (bitVector - 1)) == 0;
        return bitVector == 0 || oneOddNum;
    }
    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(Character.toLowerCase(c));
        if (a <= val && val <= z) return val - a;
        return -1; // non-letter characters
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