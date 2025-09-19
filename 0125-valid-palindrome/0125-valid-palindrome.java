class Solution {
    public boolean isPalindrome(String s) {
        char[] sChars = s.toLowerCase().toCharArray();
        int left = 0, right = sChars.length-1;
        while (left<=right) {
            if (!Character.isLetterOrDigit(sChars[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(sChars[right])) {
                right--;
                continue;
            }
            if (sChars[left] != sChars[right]) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}