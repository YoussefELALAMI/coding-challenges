class Solution {
    public boolean canPermutePalindrome(String s) {
        int countOdd = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
            if(freqMap.get(c) % 2 == 1) countOdd++;
            else countOdd--;
        }
        return countOdd <= 1;
    }
}