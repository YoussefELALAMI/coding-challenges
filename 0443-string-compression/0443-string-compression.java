class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int right = 0;
        while(right < chars.length){
            int countConsecutive = 0;
            char current = chars[right];
            while(right < chars.length &&current == chars[right]){
                countConsecutive++;
                right++;
            }
            chars[index++] = current;
            if (countConsecutive > 1) {
                for (char c : String.valueOf(countConsecutive).toCharArray()) {
                    chars[index++] = c;
                }
            } 
        }
        return index;
    }
}