class Solution {
    public int compress(char[] chars) {
        int left = 0, right = 0;

        while (right < chars.length) {
            int countConsecutive = 0;
            char current = chars[right];
            while (right < chars.length && current == chars[right]) {
                countConsecutive++;
                right++;
            }
            chars[left++] = current;
            if(countConsecutive > 1){
                for(char c: String.valueOf(countConsecutive).toCharArray()) chars[left++] = c;
            }
        }

        return left;
    }
}