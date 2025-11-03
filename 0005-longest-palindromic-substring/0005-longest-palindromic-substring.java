class Solution {
    public String longestPalindrome(String s) {
        for(int length = s.length(); length > 0; length--){
            for(int start = 0; start <= s.length() - length; start++){
                if(check(s, start, length + start)) return s.substring(start, length + start);
            }
        }
        return "";
    }

    private boolean check(String s, int i, int j){
        int left = i, right = j - 1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}