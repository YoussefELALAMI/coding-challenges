class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;

        Map<Character, Integer> charsOfSubArr = new HashMap<>();
        int maxSubStr = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            charsOfSubArr.put(r, charsOfSubArr.getOrDefault(r, 0) + 1);

            while (charsOfSubArr.get(r) > 1) {
                char l = s.charAt(left);
                charsOfSubArr.replace(l, charsOfSubArr.get(l) - 1);
                left++;                
            }

            maxSubStr = Math.max(maxSubStr, right - left + 1);

            right++;
        }
        
        return maxSubStr;
    }
}