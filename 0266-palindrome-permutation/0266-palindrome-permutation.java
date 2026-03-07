class Solution {
    public boolean canPermutePalindrome(String s) {
        int realLength = s.length();
        boolean isEven = realLength%2 == 0;
        HashMap<Character, Integer> occ = new HashMap<>();

        for(char c : s.toCharArray()) occ.put(c, occ.getOrDefault(c, 0) + 1);

        if(isEven){
            for(Integer v: occ.values()){
                if (v%2 != 0) {
                    return false;
                }
            }
        } else {
            int countOdd = 0;
            for(Integer v: occ.values()){
                if(v%2 != 0){
                    if(countOdd >= 1) return false;
                    else countOdd++;
                }
            }
        }
        return true;
    }
}