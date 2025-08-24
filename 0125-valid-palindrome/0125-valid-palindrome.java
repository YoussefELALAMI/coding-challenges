class Solution {
    public boolean isPalindrome(String s) {
        char[] phrase = s.toCharArray();
        int left = 0, right = phrase.length-1;
        while (left < right) {
            if (!Character.isLetterOrDigit(phrase[left])) left++;
            else if (!Character.isLetterOrDigit(phrase[right])) right--;
            else {
                if (
                    Character.toLowerCase(phrase[left]) != Character.toLowerCase(phrase[right])
                ) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}