class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> occ = new HashMap<>();
        int countOdd = 0;

        for(char c : s.toCharArray()) occ.put(c, occ.getOrDefault(c, 0) + 1);

        for(Integer v: occ.values()){
            if (v%2 != 0) countOdd++;
        }
        return countOdd <= 1;
    }
}