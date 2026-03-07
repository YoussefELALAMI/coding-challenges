class Solution {
    public boolean canPermutePalindrome(String s) {
        int realLength = s.length();
        boolean isEven = realLength%2 == 0;
        HashMap<Character, Integer> occ = new HashMap<>();
        int countOdd = 0;

        for(char c : s.toCharArray()) occ.put(c, occ.getOrDefault(c, 0) + 1);

        for(Integer v: occ.values()){
            if (v%2 != 0) {
                if(isEven) return false;
                else if(!isEven && countOdd == 1) return false;
                else countOdd++;
            }
        }
        return true;
    }
}