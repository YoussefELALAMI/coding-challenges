class Solution {
    public boolean canPermutePalindrome(String s) {
        int oneFrequency = 0;
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        for(Character c : freqMap.keySet()){
            if(freqMap.get(c) % 2 != 0){
                oneFrequency++;
                if(oneFrequency > 1) return false;
            }
        }
        return true;
    }
}