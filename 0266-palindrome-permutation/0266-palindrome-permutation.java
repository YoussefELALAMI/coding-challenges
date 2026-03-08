class Solution {
    public boolean canPermutePalindrome(String s) {
        //return hashMapSolution(s);
        return bitManipulationSolution(s);
    }

    private boolean hashMapSolution(String s) {
        HashMap<Character, Integer> occ = new HashMap<>();
        int countOdd = 0;

        for(char c : s.toCharArray()) occ.put(c, occ.getOrDefault(c, 0) + 1);

        for(Integer v: occ.values()){
            if (v%2 != 0) countOdd++;
        }
        return countOdd <= 1;
    }

    private boolean bitManipulationSolution(String s){
        // Create the Bit Vector
        int bitVector = 0;

        // Toggle the letters positions
        for(char c: s.toCharArray()){
            int index = c - 'a';
            bitVector ^= (1 << index);
        }

        // Check at most one bit is set
        boolean zeroBitSet = bitVector == 0;
        boolean oneBitSet = (bitVector & (bitVector - 1)) == 0;
        return zeroBitSet || oneBitSet;
    }
}